package com.likelen.bookishbackend.application

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class QueryImageServiceTest {

    lateinit var sut: QueryImageService;

    @Test
    fun `이미지를 Url에 맞게 조회`() {
        sut = QueryImageService();

        sut.getImageFromUrl("zxc")

    }
}