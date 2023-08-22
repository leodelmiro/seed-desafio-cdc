package com.leodelmiro.casadocodigokotlin.controllers.validations

import com.leodelmiro.casadocodigokotlin.controllers.dto.NewAuthorRequest
import com.leodelmiro.casadocodigokotlin.repositories.AuthorRepository
import org.springframework.stereotype.Component
import org.springframework.validation.Errors
import org.springframework.validation.Validator

@Component
class DenyAuthorEmailDuplicatedValidator(private val authorRepository: AuthorRepository) : Validator {
    override fun supports(clazz: Class<*>): Boolean = NewAuthorRequest::class.java.isAssignableFrom(clazz)

    override fun validate(target: Any, errors: Errors) {
        if (errors.hasErrors()) return

        val request = target as? NewAuthorRequest
        authorRepository.findByEmail(request?.email)?.let {
            errors.rejectValue("email", "data.email", "Email: ${it.email}, já existente")
        }
    }
}