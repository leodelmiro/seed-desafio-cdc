package com.leodelmiro.casadocodigokotlin.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime

@Entity(name = "tb_author")
class Author(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null,
    @NotBlank @NotNull val name: String,
    @NotBlank @NotNull @Email val email: String,
    @NotBlank @NotNull @Size(max = 400) val description: String,
    @NotNull @CreatedDate val createdAt: LocalDateTime = LocalDateTime.now()
)