package com.likelen.bookishbackend.domain

import org.springframework.data.repository.CrudRepository


interface BoardRepository : CrudRepository<Board, Long>