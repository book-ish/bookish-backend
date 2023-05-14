package com.likelen.bookishbackend.domain

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.postgresql.util.PGobject
import org.springframework.core.convert.converter.Converter
import org.springframework.data.convert.ReadingConverter
import org.springframework.data.convert.WritingConverter

@WritingConverter
class HashtagsToJsonConverter : Converter<HashTags, PGobject> {

    override fun convert(source: HashTags): PGobject? {
        val encodeToString = Json.encodeToString(source)
        val pGobject = PGobject()
        pGobject.type = "json"
        pGobject.value = encodeToString
        return pGobject;
    }
}