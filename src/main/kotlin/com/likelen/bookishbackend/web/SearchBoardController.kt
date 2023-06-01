package com.likelen.bookishbackend.web

import com.likelen.bookishbackend.application.BoardService
import com.likelen.bookishbackend.domain.Board
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.query.Param
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class SearchBoardController(
    private val service: BoardService
) {
    @GetMapping("/board/search")
    fun findBoard(
        @Param("keyword") keyword: String,
        page: Pageable
    ): ResponseEntity<Page<Board>> {

        val search: Page<Board> = service.search(keyword, page)

        return ResponseEntity.of(Optional.of(search))
    }
}