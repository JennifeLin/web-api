package com.alg.boot.webapi.handlers.exceptions

import com.fasterxml.jackson.module.kotlin.MissingKotlinParameterException
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.data.rest.webmvc.ResourceNotFoundException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.server.ResponseStatusException
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@RestControllerAdvice(annotations = [RestController::class])
class GlobalExceptionHandler: ResponseEntityExceptionHandler() {
    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {
        val errors: MutableList<FieldErrorResponse> = mutableListOf()
        ex.bindingResult.allErrors.forEach { error ->
            val field = (error as FieldError).field
            val message: String = error.defaultMessage!!
            errors.add(FieldErrorResponse(field, message))
        }
        val errorResponse = ErrorResponse(status.value(), ex.message, ex::class.simpleName, errors)
        return ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(ResponseStatusException::class)
    fun handleNotFound(exception: ResponseStatusException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(exception.status.value(), exception.message, exception::class.simpleName)
        return ResponseEntity(errorResponse, exception.status)
    }

    @ExceptionHandler(DataIntegrityViolationException::class)
    fun handleDataIntegrityViolationException(exception: DataIntegrityViolationException, webRequest: WebRequest): ResponseEntity<ErrorResponse> {
        val status = HttpStatus.CONFLICT
        var message = exception.message?:""
        if (message.contains("SQL", true)) {
            message = "Los datos enviados no se pueden procesar"
        }
        val errorResponse = ErrorResponse(status.value(), message, webRequest.getDescription(false))
        return ResponseEntity(errorResponse, status)
    }

    @ExceptionHandler(MissingKotlinParameterException::class)
    fun handleMissingKotlinParameterException(exception: MissingKotlinParameterException, webRequest: WebRequest): ResponseEntity<ErrorResponse> {
        val status = HttpStatus.BAD_REQUEST
        val errorResponse = ErrorResponse(status.value(), exception.message, webRequest.getDescription(false))
        return ResponseEntity(errorResponse, status)
    }

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleResourceNotFoundException(exception: ResourceNotFoundException, webRequest: WebRequest): ResponseEntity<ErrorResponse> {
        val status = HttpStatus.NOT_FOUND
        val errorResponse = ErrorResponse(status.value(), exception.message, webRequest.getDescription(false))
        return ResponseEntity(errorResponse, status)
    }

    @ExceptionHandler(BadRequestException::class)
    fun handleBadRequestException(exception: BadRequestException, webRequest: WebRequest): ResponseEntity<ErrorResponse> {
        val status = HttpStatus.BAD_REQUEST
        val errorResponse = ErrorResponse(status.value(), exception.message, webRequest.getDescription(false))
        return ResponseEntity(errorResponse, status)
    }

    @ExceptionHandler(Exception::class)
    fun handleAnyException(exception: Exception, webRequest: WebRequest): ResponseEntity<ErrorResponse> {
        val status = HttpStatus.INTERNAL_SERVER_ERROR
        val errorResponse = ErrorResponse(status.value(), exception.message, webRequest.getDescription(false))
        return ResponseEntity(errorResponse, status)
    }

    @ExceptionHandler(Throwable::class)
    fun handleThrowable(exception: Throwable): ResponseEntity<ErrorResponse> {
        exception.printStackTrace()
        val status = HttpStatus.INTERNAL_SERVER_ERROR
        val errorResponse = ErrorResponse(status.value(), status.toString(), exception::class.simpleName)
        return ResponseEntity(errorResponse, status)
    }
}
