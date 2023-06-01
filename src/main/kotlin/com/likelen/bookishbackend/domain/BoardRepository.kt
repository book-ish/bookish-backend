package com.likelen.bookishbackend.domain

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param


interface BoardRepository : CrudRepository<Board, Long>, PagingAndSortingRepository<Board, Long> {

    @Query("SELECT * FROM board as b WHERE title = :keyword")
    fun findAllBoardByKeyword(@Param("keyword") keyword:String, page: Pageable): Page<Board>
}