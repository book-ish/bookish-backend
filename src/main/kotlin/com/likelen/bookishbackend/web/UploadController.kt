package com.likelen.bookishbackend.web

import com.likelen.bookishbackend.application.BoardService
import com.likelen.bookishbackend.domain.Board
import com.likelen.bookishbackend.domain.HashTags
import kotlinx.serialization.json.Json
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
class UploadController(
    private val boardService: BoardService,
) {

    @PostMapping("/boards")
    fun createBoard(
        @RequestParam title: String,
        @RequestParam memo: String,
        @RequestParam hashtags: String,
        @RequestPart file: MultipartFile
    ): ResponseEntity<Board> {
        val decodeFromString = Json.decodeFromString<List<String>>(hashtags)
        val board = Board(memo = memo, title = title, hashTags = HashTags.of(decodeFromString))
        val saveBoard = boardService.saveBoard(board, file)
        return ResponseEntity.ok().body(saveBoard)
    }

    @PutMapping("/boards/{boardId}")
    fun updateBoard(
        @PathVariable boardId: Long,
        @RequestParam title: String,
        @RequestParam memo: String,
        @RequestParam hashtags: String,
        @RequestPart file: MultipartFile
    ): ResponseEntity<Board> {
        val decodeFromString = Json.decodeFromString<List<String>>(hashtags)
        val board = Board(memo = memo, title = title, hashTags = HashTags.of(decodeFromString))
        val updateBoard = boardService.updateBoard(boardId, board, file)
        return ResponseEntity.ok().body(updateBoard)
    }
}