package com.alg.boot.webapi.handlers.exceptions

import com.arthurolg.exceptions.ErrorResponse
import com.arthurolg.exceptions.FieldErrorResponse
import com.fasterxml.jackson.module.kotlin.MissingKotlinParameterException
import org.slf4j.LoggerFactory
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

    private val log = LoggerFactory.getLogger(GlobalExceptionHandler::class.java)

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
        val errorResponse = ErrorResponse.builder()
            .httpStatus(status.value())
            .message(ex.message)
            .exception(ex::class.simpleName)
            .fieldErrorResponses(errors).build()
        return ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(ResponseStatusException::class)
    fun handleNotFound(exception: ResponseStatusException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse.builder()
            .httpStatus(exception.status.value())
            .message(exception.message)
            .exception(exception::class.simpleName)
            .build()
        return ResponseEntity(errorResponse, exception.status)
    }

    @ExceptionHandler(DataIntegrityViolationException::class)
    fun handleDataIntegrityViolationException(exception: DataIntegrityViolationException, webRequest: WebRequest): ResponseEntity<ErrorResponse> {
        val status = HttpStatus.CONFLICT
        var message = exception.message?:""
        if (message.contains("SQL", true)) {
            message = "Los datos enviados no se pueden procesar"
        }
        val errorResponse = ErrorResponse.builder()
            .httpStatus(status.value())
            .message(message)
            .exception(webRequest.getDescription(false))
            .build()
        return ResponseEntity(errorResponse, status)
    }

    @ExceptionHandler(MissingKotlinParameterException::class)
    fun handleMissingKotlinParameterException(exception: MissingKotlinParameterException, webRequest: WebRequest): ResponseEntity<ErrorResponse> {
        val status = HttpStatus.BAD_REQUEST
        val errorResponse = ErrorResponse.builder()
            .httpStatus(status.value())
            .message(exception.message)
            .exception(webRequest.getDescription(false))
            .build()
        return ResponseEntity(errorResponse, status)
    }

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleResourceNotFoundException(exception: ResourceNotFoundException, webRequest: WebRequest): ResponseEntity<ErrorResponse> {
        val status = HttpStatus.NOT_FOUND
        val errorResponse = ErrorResponse.builder()
            .httpStatus(status.value())
            .message(exception.message)
            .exception(webRequest.getDescription(false))
            .build()
        return ResponseEntity(errorResponse, status)
    }

    @ExceptionHandler(Exception::class)
    fun handleAnyException(exception: Exception, webRequest: WebRequest): ResponseEntity<ErrorResponse> {
        log.error("Exception error ", exception.message)
        val status = HttpStatus.INTERNAL_SERVER_ERROR
        val errorResponse = ErrorResponse.builder()
            .httpStatus(status.value())
            .message(exception.message)
            .exception(webRequest.getDescription(false))
            .build()
        return ResponseEntity(errorResponse, status)
    }

    @ExceptionHandler(Throwable::class)
    fun handleThrowable(exception: Throwable): ResponseEntity<ErrorResponse> {
        log.error("Throwable error ", exception.message)
        exception.printStackTrace()
        val status = HttpStatus.INTERNAL_SERVER_ERROR
        val errorResponse = ErrorResponse.builder()
            .httpStatus(status.value())
            .message(exception.message)
            .exception(status.toString())
            .build()
        return ResponseEntity(errorResponse, status)
    }

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(exception: NotFoundException, webRequest: WebRequest): ResponseEntity<ErrorResponse> {
        return ResponseEntity(getErrorResponse(exception, webRequest.getDescription(false)), exception.status)
    }

    @ExceptionHandler(BadRequestException::class)
    fun handleBadRequestException(exception: BadRequestException, webRequest: WebRequest): ResponseEntity<ErrorResponse> {
        return ResponseEntity(getErrorResponse(exception, webRequest.getDescription(false)), exception.status)
    }

    @ExceptionHandler(ServerErrorException::class)
    fun handleServerErrorException(exception: ServerErrorException, webRequest: WebRequest): ResponseEntity<ErrorResponse> {
        exception.printStackTrace()
        return ResponseEntity(getErrorResponse(exception, webRequest.getDescription(false)), exception.status)
    }

    private fun getErrorResponse(exception: GeneralException, description: String): ErrorResponse {
        log.error("Código del error: ${exception.getCode()}, ${exception.message}")
        val status = exception.status
        val errors: MutableList<FieldErrorResponse> = mutableListOf()
        exception.getErrors().forEach { error ->
            errors.add(FieldErrorResponse(error.name, error.value))
        }
        return ErrorResponse.builder()
            .httpStatus(status.value())
            .message(exception.message)
            .exception(description)
            .fieldErrorResponses(errors)
            .build()
    }
}
