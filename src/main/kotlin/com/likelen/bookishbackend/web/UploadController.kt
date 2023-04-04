package com.likelen.bookishbackend.web

import com.likelen.bookishbackend.domain.Board
import com.likelen.bookishbackend.domain.BoardRepository
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
class UploadController(
    private val boardService: BoardService
) {

    @PostMapping("/upload")
    fun createBoard(
        @RequestParam title: String,
        @RequestPart file: MultipartFile
    ): String {
        val board = Board(pictureName = title)
        boardService.saveBoard(board, file)
        return "ok"
    }

}