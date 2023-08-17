package com.leodelmiro.casadocodigokotlin.controllers.dto

import com.leodelmiro.casadocodigokotlin.models.Author
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class NewAuthorRequest(
    @NotBlank val name: String,
    @NotBlank @Email val email: String,
    @NotBlank @Size(max = 400) val description: String
) {
    fun toModel(): Author = Author(name = this.name, email = this.email, description = this.description)
}