package org.com.bium.board.service;

import org.com.bium.board.dto.BoardCommentDto;
import org.com.bium.board.mapper.BoardCommentMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<BoardCommentDto> getBoardComment() {
        return boardCommentMapper.getBoardComment();
    }

    // boardComment 상세 조회 기능 구현
    public BoardCommentDto getByBoardCommentId(int boardCommentId) {
        return boardCommentMapper.getByBoardCommentId(boardCommentId);
    }

    // boardComment 수정 기능 구현
    public BoardCommentDto updateBoardComment(BoardCommentDto boardCommentDto) {
        boardCommentMapper.updateBoardComment(boardCommentDto);
        return boardCommentMapper.getByBoardCommentId(boardCommentDto.getBoardCommentId());
    }

    // boardComment 삭제 기능 구현
    public void deleteBoard(int boardCommentId) {
        boardCommentMapper.deleteBoardComment(boardCommentId);
    }
}
