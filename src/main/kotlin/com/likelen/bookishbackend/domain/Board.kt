package com.likelen.bookishbackend.domain

import org.springframework.data.annotation.Id


class Board(
    @Id var id: Long? = null,
    val title: String,
    val memo: String,
    val hashTags: HashTags,
    var imageUrl: String = ""
) {

    fun settingImageUrl(url: String) {
        this.imageUrl = url;
    }
}