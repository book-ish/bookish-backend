package com.likelen.bookishbackend.domain

import org.springframework.data.annotation.Id


class Board(
    @Id var id: Long? = null,
    var title: String,
    var memo: String,
    var hashTags: HashTags,
    var imageUrl: String = ""
) {

    fun settingImageUrl(url: String) {
        this.imageUrl = url;
    }

    fun changeContent(title: String, memo: String, hashTags: HashTags, imageUrl: String) {
        this.title = title
        this.memo = memo
        this.hashTags = hashTags
        this.imageUrl = imageUrl
    }
}