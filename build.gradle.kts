import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

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
}

extra["mockitoVersion"] = "4.3.1"
extra["modelMapperVersion"] = "3.0.0"
extra["openApiVersion"] = "1.6.6"

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-data-rest")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.modelmapper:modelmapper:${property("modelMapperVersion")}")
	implementation("org.springdoc:springdoc-openapi-ui:${property("openApiVersion")}")
	implementation("org.springdoc:springdoc-openapi-data-rest:${property("openApiVersion")}")
	implementation("org.springdoc:springdoc-openapi-kotlin:${property("openApiVersion")}")
	implementation("org.springdoc:springdoc-openapi-javadoc:${property("openApiVersion")}")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("mysql:mysql-connector-java")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
	testImplementation("org.mockito:mockito-core:${property("mockitoVersion")}")
	testImplementation("org.mockito:mockito-inline:${property("mockitoVersion")}")
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
