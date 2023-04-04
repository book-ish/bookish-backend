package com.likelen.bookishbackend.web

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HeathCheckController {

    @GetMapping("/health")
    fun findAllBoards(): ResponseEntity<String> {
        return ResponseEntity("annyeng", HttpStatus.OK)
    }
}