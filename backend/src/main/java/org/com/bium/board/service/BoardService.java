package org.com.bium.board.service;

import org.com.bium.board.dto.BoardDto;
import org.com.bium.board.mapper.BoardMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardService {

    private final BoardMapper boardMapper;
    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    // board 등록 기능 구현
    @Transactional
    public int insertBoard(BoardDto boardDto) {
        // user 존재 확인
        if(!boardMapper.existsByUserId(boardDto.getUserId())) {
            throw new IllegalArgumentException("user가 존재하지 않습니다.");
        }
        boardMapper.insertBoard(boardDto);
        return boardDto.getBoardId();
    }
}
