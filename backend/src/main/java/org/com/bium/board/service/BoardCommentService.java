package org.com.bium.board.service;

import org.com.bium.board.dto.BoardCommentDto;
import org.com.bium.board.mapper.BoardCommentMapper;
import org.springframework.stereotype.Service;

@Service
public class BoardCommentService {
    private final BoardCommentMapper boardCommentMapper;

    public BoardCommentService(BoardCommentMapper boardCommentMapper) {
        this.boardCommentMapper = boardCommentMapper;
    }

    // boardComment 등록 기능 구현

    public int insertBoardComment(BoardCommentDto boardCommentDto) {
        // boardComment 등록 기능 구현 전에 board 유무 확인
        if(!boardCommentMapper.existsByBoardId(boardCommentDto.getBoardId())) {
            throw new  IllegalArgumentException("board가 존재하지 않습니다.");
        }
        boardCommentMapper.insertBoardComment(boardCommentDto);
        return boardCommentDto.getBoardCommentId();
    }

    // boardComment 목록 조회 기능 구현

    // boardComment 상세 조회 기능 구현

    // boardComment 수정 기능 구현

    // boardComment 삭제 기능 구현
}
