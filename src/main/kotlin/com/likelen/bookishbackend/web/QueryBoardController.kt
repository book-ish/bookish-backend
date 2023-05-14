package com.likelen.bookishbackend.web

import com.likelen.bookishbackend.application.BoardService
import com.likelen.bookishbackend.domain.Board
import org.apache.commons.io.IOUtils
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStream
import java.util.*


@RestController
class QueryBoardController(
    private val service: BoardService
) {


    @GetMapping("/board/{id}")
    fun findBoard(@PathVariable("id") id: Long): ResponseEntity<Board> {
        val boardOptional: Optional<Board> = service.get(id)
        val board = boardOptional.orElseThrow()
        return ResponseEntity(board, HttpStatus.OK)
    }

    @GetMapping("/boards")
    fun findImageByURL(): ResponseEntity<List<Board>> {
        val allBoard = service.getAll()
        return ResponseEntity(allBoard, HttpStatus.OK)
    }

    @GetMapping(
        value = ["image/{imagename}"],
        produces = [MediaType.IMAGE_JPEG_VALUE]
    )
    fun userSearch(@PathVariable("imagename") imagename: String): ResponseEntity<ByteArray?>? {
        val imageStream: InputStream =
            FileInputStream("/Users/len/StudioProjects/bookish-backend/src/main/resources/images/$imagename")
        val imageByteArray: ByteArray = IOUtils.toByteArray(imageStream)
        imageStream.close()
        return ResponseEntity(imageByteArray, HttpStatus.OK)
    }
}
