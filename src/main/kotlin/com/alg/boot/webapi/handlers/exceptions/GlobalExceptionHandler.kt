package com.alg.boot.webapi.handlers.exceptions

import com.fasterxml.jackson.module.kotlin.MissingKotlinParameterException
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.data.rest.webmvc.ResourceNotFoundException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler: ResponseEntityExceptionHandler() {
    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {
        val errors: HashMap<String, String> = HashMap()
        ex.bindingResult.allErrors.forEach { error ->
            val field = (error as FieldError).field
            val message: String = error.defaultMessage!!
            errors[field] = message
        }
        return ResponseEntity(errors, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(DataIntegrityViolationException::class)
    fun handleDataIntegrityViolationException(exception: DataIntegrityViolationException, webRequest: WebRequest): ResponseEntity<ErrorResponse> {
        val status = HttpStatus.CONFLICT
        var message = exception.message?:""
        if (message.contains("SQL", true)) {
            message = "Los datos enviados no se pueden procesar"
        }
        val error = ErrorResponse(status.value(), message, webRequest.getDescription(false))
        return ResponseEntity(error, status)
    }

    @ExceptionHandler(MissingKotlinParameterException::class)
    fun handleMissingKotlinParameterException(exception: MissingKotlinParameterException, webRequest: WebRequest): ResponseEntity<ErrorResponse> {
        val status = HttpStatus.BAD_REQUEST
        val error = ErrorResponse(status.value(), exception.message, webRequest.getDescription(false))
        return ResponseEntity(error, status)
    }

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleResourceNotFoundException(exception: ResourceNotFoundException, webRequest: WebRequest): ResponseEntity<ErrorResponse> {
        val status = HttpStatus.NOT_FOUND
        val error = ErrorResponse(status.value(), exception.message, webRequest.getDescription(false))
        return ResponseEntity(error, status)
    }

    @ExceptionHandler(BadRequestException::class)
    fun handleBadRequestException(exception: BadRequestException, webRequest: WebRequest): ResponseEntity<ErrorResponse> {
        val status = HttpStatus.BAD_REQUEST
        val error = ErrorResponse(status.value(), exception.message, webRequest.getDescription(false))
        return ResponseEntity(error, status)
    }

    @ExceptionHandler(Exception::class)
    fun handleAnyException(exception: Exception, webRequest: WebRequest): ResponseEntity<ErrorResponse> {
        val status = HttpStatus.INTERNAL_SERVER_ERROR
        val error = ErrorResponse(status.value(), exception.message, webRequest.getDescription(false))
        return ResponseEntity(error, status)
    }
}
