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
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Author

        if (name != other.name) return false
        if (email != other.email) return false
        if (description != other.description) return false
        if (createdAt != other.createdAt) return false
        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + email.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + createdAt.hashCode()
        result = 31 * result + (id?.hashCode() ?: 0)
        return result
    }


}