package com.alg.boot.webapi

import com.alg.boot.webapi.config.ApplicationProperties
import org.apache.commons.lang3.StringUtils
import org.slf4j.LoggerFactory
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.core.env.Environment
import java.net.InetAddress
import java.net.UnknownHostException
import java.util.*
import javax.annotation.PostConstruct


@SpringBootApplication
@EnableConfigurationProperties(ApplicationProperties::class)
class WebApiApplication(private val env: Environment) {
	@PostConstruct
	fun initApplication() {
		val activeProfiles = mutableSetOf<String>()
		env.activeProfiles.forEach {
			activeProfiles.add(it)
		}
		if (activeProfiles.contains("dev") && activeProfiles.contains("prod")) {
			log.error(
				"You have misconfigured your application! It should not run " + "with both the 'dev' and 'prod' profiles at the same time."
			)
		}
		if (activeProfiles.contains("dev") && activeProfiles.contains("cloud")) {
			log.error(
				"You have misconfigured your application! It should not " + "run with both the 'dev' and 'cloud' profiles at the same time."
			)
		}
	}

	companion object {
		private val log = LoggerFactory.getLogger(WebApiApplication::class.java)

		@JvmStatic
		fun main(args: Array<String>) {
			val app = SpringApplication(WebApiApplication::class.java)
			//DefaultProfileUtil.addDefaultProfile(app)
			val env: Environment = app.run(*args).environment
			logApplicationStartup(env)
		}

		private fun logApplicationStartup(env: Environment) {
			val protocol: String = Optional.ofNullable(env.getProperty("server.ssl.key-store")).map { "https" }
				.orElse("http")
			val serverPort = env.getProperty("server.port")
			val contextPath: String = Optional
				.ofNullable(env.getProperty("server.servlet.context-path"))
				.filter(StringUtils::isNotBlank)
				.orElse("/")
			var hostAddress: String? = "localhost"
			try {
				hostAddress = InetAddress.getLocalHost().hostAddress
			} catch (e: UnknownHostException) {
				log.warn("The host name could not be determined, using `localhost` as fallback")
			}
			log.info(
				"""
----------------------------------------------------------
	Application '{}' is running! Access URLs:
	Local: 		{}://localhost:{}{}
	External: 	{}://{}:{}{}
	Profile(s): 	{}
----------------------------------------------------------""",
				env.getProperty("spring.application.name"),
				protocol,
				serverPort,
				contextPath,
				protocol,
				hostAddress,
				serverPort,
				contextPath,
				if (env.activeProfiles.isEmpty()) env.defaultProfiles else env.activeProfiles
			)
			var configServerStatus = env.getProperty("configserver.status")
			if (configServerStatus == null) {
				configServerStatus = "Not found or not setup for this application"
			}
			log.info(
				"""
----------------------------------------------------------
	Config Server: 	{}
----------------------------------------------------------""",
				configServerStatus
			)
		}
	}
}
