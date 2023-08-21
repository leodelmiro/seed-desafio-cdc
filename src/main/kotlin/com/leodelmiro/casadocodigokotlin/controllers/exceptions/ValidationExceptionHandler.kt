package com.leodelmiro.casadocodigokotlin.controllers.exceptions

import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ValidationExceptionHandler(private val messageSource: MessageSource) {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationError(exception: MethodArgumentNotValidException): ResponseEntity<ValidationErrorsOutputDTO> {
        val globalErrors: List<ObjectError> = exception.bindingResult.globalErrors
        val fieldErrors: List<FieldError> = exception.bindingResult.fieldErrors

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(buildValidationErrors(globalErrors, fieldErrors))
    }

    private fun buildValidationErrors(
        globalErrors: List<ObjectError>, fieldErrors: List<FieldError>
    ): ValidationErrorsOutputDTO {
        val validationErrors = ValidationErrorsOutputDTO()
        globalErrors.forEach { error -> validationErrors.addError(getErrorMessage(error)) }
        fieldErrors.forEach { error -> validationErrors.addFieldError(error.field, getErrorMessage(error)) }

        return validationErrors
    }

    private fun getErrorMessage(error: ObjectError) = messageSource.getMessage(error, LocaleContextHolder.getLocale())
}