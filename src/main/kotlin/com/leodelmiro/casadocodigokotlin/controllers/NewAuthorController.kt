package com.leodelmiro.casadocodigokotlin.controllers

import com.leodelmiro.casadocodigokotlin.controllers.dto.NewAuthorRequest
import com.leodelmiro.casadocodigokotlin.controllers.dto.NewAuthorResponse
import com.leodelmiro.casadocodigokotlin.repositories.AuthorRepository
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class NewAuthorController(private val authorRepository: AuthorRepository) {

    @PostMapping("/author")
    fun registerAuthor(@RequestBody @Valid request: NewAuthorRequest): ResponseEntity<NewAuthorResponse> {
        val model = authorRepository.save(request.toModel())
        return ResponseEntity.ok().body(NewAuthorResponse(model))
    }
}