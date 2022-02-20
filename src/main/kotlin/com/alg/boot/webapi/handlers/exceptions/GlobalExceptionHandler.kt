package com.alg.boot.webapi.handlers.exceptions

import groovy.util.logging.Slf4j
import org.springframework.data.rest.webmvc.ResourceNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class GlobalExceptionHandler {
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
