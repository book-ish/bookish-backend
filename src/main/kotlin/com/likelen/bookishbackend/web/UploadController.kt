package com.likelen.bookishbackend.web

import com.likelen.bookishbackend.domain.Board
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
class UploadController(
    private val boardService: BoardService
) {

    //TODO Validation Version Params
    @PostMapping("/upload")
    fun createBoard2(
        @RequestParam title: String,
        @RequestParam memo: String,
        @RequestPart file: MultipartFile
    ): String {
        val board = Board(memo = memo, title = title)
        boardService.saveBoard(board, file)
        return "ok"
    }
}