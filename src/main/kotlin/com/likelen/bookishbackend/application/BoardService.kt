package com.likelen.bookishbackend.application

import com.likelen.bookishbackend.domain.Board
import com.likelen.bookishbackend.domain.BoardRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.lang.IllegalArgumentException
import java.util.*

@Service
class BoardService(
    private val boardRepository: BoardRepository
) {

    @Transactional
    fun saveBoard(board: Board, file: MultipartFile) {

        // 원본파일이름, 저장될 파일이름
        val originalFilename: String? = file.originalFilename
        val saveFileName = getSaveFileName(originalFilename)
        // 파일 저장(transferTo), 파일정보 DB에 저장
        if (originalFilename != null) {

            file.transferTo(File("/Users/len/StudioProjects/bookish-backend/src/main/resources/images/$saveFileName"))
            board.settingImageUrl(saveFileName)
            boardRepository.save(board)
        } else {
            throw IllegalArgumentException()
        }
    }

    // 저장될 파일이름 생성
    private fun getSaveFileName(originalFilename: String?): String {
        val extPosIndex: Int? = originalFilename?.lastIndexOf(".")
        val ext = originalFilename?.substring(extPosIndex?.plus(1) as Int)

        return UUID.randomUUID().toString() + "_originalFilename_" + "." + ext
    }

    fun get(id: Long): Optional<Board> {
        return boardRepository.findById(id);
    }

    fun getAll(): List<Board> {
        return boardRepository.findAll().toList()
    }

}
