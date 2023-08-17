package com.leodelmiro.casadocodigokotlin.controllers.dto

import com.leodelmiro.casadocodigokotlin.models.Author
import java.time.LocalDateTime

data class NewAuthorResponse(
    val id: Long?,
    val name: String,
    val email: String,
    val description: String,
    val createdAt: LocalDateTime
) {
    constructor(model: Author) : this(
        id = model.id,
        name = model.name,
        email = model.email,
        description = model.description,
        createdAt = model.createdAt
    )
}
