package com.leodelmiro.casadocodigokotlin.controllers.exceptions

import com.fasterxml.jackson.annotation.JsonProperty

class ValidationErrorsOutputDTO() {
    @JsonProperty("global_errors_messages")
    private val globalErrorsMessages: MutableList<String> = mutableListOf()

    @JsonProperty("field_errors")
    private val fieldErrors: MutableList<FieldErrorOutputDTO> = mutableListOf()

    fun addError(message: String) = globalErrorsMessages.add(message)
    fun addFieldError(field: String, message: String) =
        fieldErrors.add(FieldErrorOutputDTO(field, message))
}

data class FieldErrorOutputDTO(val field: String, val message: String)
