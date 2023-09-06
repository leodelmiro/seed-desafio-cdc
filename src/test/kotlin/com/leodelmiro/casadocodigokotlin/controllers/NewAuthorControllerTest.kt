package com.leodelmiro.casadocodigokotlin.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import com.leodelmiro.casadocodigokotlin.controllers.dto.NewAuthorRequest
import com.leodelmiro.casadocodigokotlin.controllers.validations.DenyAuthorEmailDuplicatedValidator
import com.leodelmiro.casadocodigokotlin.models.Author
import com.leodelmiro.casadocodigokotlin.repositories.AuthorRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.any
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest
@AutoConfigureMockMvc
class NewAuthorControllerTest() {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Autowired
    private lateinit var denyAuthorEmailDuplicatedValidator: DenyAuthorEmailDuplicatedValidator

    @MockBean
    private lateinit var authorRepository: AuthorRepository

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `Should create a new author`() {
        `when`(authorRepository.save(any())).thenReturn(authorModel)

        mockMvc.perform(
            MockMvcRequestBuilders
                .post("/author")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
    }

    @Test
    fun `Should not create a duplicate author`() {
        `when`(authorRepository.findByEmail(any())).thenReturn(authorModel)

        mockMvc.perform(
            MockMvcRequestBuilders
                .post("/author")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
            .andExpect(MockMvcResultMatchers.status().isBadRequest)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
    }


    companion object {
        private const val authorName = "Author Name"
        private const val email = "email@example.com"
        private const val description = "Author description"
        private val request = NewAuthorRequest(authorName, email, description)
        private val authorModel = Author(name = authorName, email = email, description = description)
    }
}