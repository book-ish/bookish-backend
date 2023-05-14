package com.likelen.bookishbackend.domain

import kotlinx.serialization.json.Json
import org.postgresql.util.PGobject
import org.springframework.core.convert.converter.Converter
import org.springframework.data.convert.ReadingConverter

@ReadingConverter
class JsonToHashtagsConverter : Converter<PGobject, HashTags> {

    override fun convert(source: PGobject): HashTags {
        val value = source.value

        return Json.decodeFromString(value)
    }
}