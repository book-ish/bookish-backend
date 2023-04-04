package com.likelen.bookishbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BookishApplication

fun main(args: Array<String>) {
	runApplication<BookishApplication>(*args)
}
