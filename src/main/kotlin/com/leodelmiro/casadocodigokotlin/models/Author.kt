package com.leodelmiro.casadocodigokotlin.models

import jakarta.persistence.*
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime

@Entity(name = "tb_author")
class Author(
    @field:NotBlank @field:NotNull val name: String,
    @field:NotBlank @field:NotNull @field:Email @Column(unique = true) val email: String,
    @field:NotBlank @field:NotNull @field:Size(max = 400) val description: String,
    @field:NotNull @field:CreatedDate val createdAt: LocalDateTime = LocalDateTime.now()
) {
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}