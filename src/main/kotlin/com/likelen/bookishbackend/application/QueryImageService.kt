package com.likelen.bookishbackend.application

import org.apache.commons.io.IOUtils
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Service

@Service
class QueryImageService {

    fun getImageFromUrl(s: String): ByteArray? {
        val resource = ClassPathResource("images/$s")
        val inputStream = resource.file.inputStream()
        val toByteArray = IOUtils.toByteArray(inputStream)

        inputStream.close()
        return toByteArray
    }
}