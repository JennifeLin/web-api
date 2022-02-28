import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.run.BootRun

plugins {
	id("org.springframework.boot") version "2.6.3"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id("org.asciidoctor.convert") version "1.5.8"
	kotlin("jvm") version "1.6.10"
	kotlin("plugin.spring") version "1.6.10"
	kotlin("plugin.jpa") version "1.6.10"
}

group = "com.alg.boot"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://repo.spring.io/snapshot") }
	maven {
		name = "github"
        credentials {
            username = System.getenv("GITHUB_USERNAME")
            password = System.getenv("GITHUB_TOKEN")
        }
		url = uri("https://maven.pkg.github.com/lgzarturo/shared-utils")
	}
}

extra["mockitoVersion"] = "4.3.1"
extra["modelMapperVersion"] = "3.0.0"
extra["mapstructVersion"] = "1.4.2.Final"
extra["openApiVersion"] = "1.6.6"

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-data-rest")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-loader-tools")
	// implementation("org.springframework.boot:spring-boot-starter-mail")
	// implementation("org.springframework.boot:spring-boot-starter-data-elasticsearch")
	implementation("org.springframework.boot:spring-boot-starter-logging")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.modelmapper:modelmapper:${property("modelMapperVersion")}")
	implementation("org.springdoc:springdoc-openapi-ui:${property("openApiVersion")}")
	implementation("org.springdoc:springdoc-openapi-data-rest:${property("openApiVersion")}")
	implementation("org.springdoc:springdoc-openapi-kotlin:${property("openApiVersion")}")
	implementation("org.springdoc:springdoc-openapi-javadoc:${property("openApiVersion")}")
	implementation("com.arthurolg:shared-utils:1.0.5")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	implementation("org.mapstruct:mapstruct:${property("mapstructVersion")}")
	annotationProcessor("org.mapstruct:mapstruct-processor:${property("mapstructVersion")}")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
	runtimeOnly("mysql:mysql-connector-java")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
	testImplementation("org.mockito:mockito-core:${property("mockitoVersion")}")
	testImplementation("org.mockito:mockito-inline:${property("mockitoVersion")}")
}

allOpen {
	annotation("javax.persistence.Entity")
	annotation("javax.persistence.MappedSuperclass")
	annotation("javax.persistence.Embeddable")
}

tasks.getByName<BootRun>("bootRun") {
	environment["SPRING_PROFILES_ACTIVE"] = environment["SPRING_PROFILES_ACTIVE"] ?: "local"
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.test {
	outputs.dir(file("build/generated-snippets"))
}

tasks.asciidoctor {
	inputs.dir(file("build/generated-snippets"))
	dependsOn(tasks.test)
}
