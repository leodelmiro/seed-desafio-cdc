package com.leodelmiro.casadocodigokotlin.repositories

import com.leodelmiro.casadocodigokotlin.models.Author
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorRepository : CrudRepository<Author, Long> {
    fun findByEmail(email: String?): Author?
}
