package com.likelen.bookishbackend.domain

import org.springframework.data.annotation.Id


class Board(
    @Id var id: Long? = null,
    val title: String,
    val memo: String
) {
}