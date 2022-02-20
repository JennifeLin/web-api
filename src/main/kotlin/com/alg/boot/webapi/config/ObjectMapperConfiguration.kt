package com.alg.boot.webapi.config

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.modelmapper.Conditions
import org.modelmapper.ModelMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


@Configuration
class ObjectMapperConfiguration {

    @Bean
    fun modelMapper(): ModelMapper? {
        val modelMapper = ModelMapper()
        modelMapper.configuration.propertyCondition = Conditions.isNotNull()
        return modelMapper
    }

    @Primary
    @Bean
    fun configure() =
        ObjectMapper().apply {
            setSerializationInclusion(JsonInclude.Include.NON_EMPTY)
            configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true)
            configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE, true)
            disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            val javaTimeModule = JavaTimeModule().apply {
                this.addDeserializer(
                    LocalDateTime::class.java,
                    LocalDateTimeDeserializer(DateTimeFormatter.ISO_DATE_TIME)
                )
            }
            registerModules(javaTimeModule, KotlinModule.Builder().build())
        }
}
