package com.likelen.bookishbackend.config

import com.likelen.bookishbackend.domain.HashtagsToJsonConverter
import com.likelen.bookishbackend.domain.JsonToHashtagsConverter
import org.springframework.context.annotation.Configuration
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing

@Configuration
@EnableJdbcAuditing
class DataJdbcConfig : AbstractJdbcConfiguration() {

    override fun jdbcCustomConversions(): JdbcCustomConversions {
        return JdbcCustomConversions(
            listOf(
                HashtagsToJsonConverter(),
                JsonToHashtagsConverter()
            )
        )
    }
}