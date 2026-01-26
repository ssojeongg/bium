package org.com.bium.board.mapper;


import org.com.bium.board.dto.BoardCommentDto;

public interface BoardCommentMapper {

    // boardComment 등록 기능 구현 전에 board 유무 확인
    boolean existsByBoardId(int boardId);

    // boardComment 등록 기능 구현
    void insertBoardComment(BoardCommentDto boardCommentDto);

    // boardComment 목록 조회 기능 구현

    // boardComment 상세 조회 기능 구현

    // boardComment 수정 기능 구현

    // boardComment 삭제 기능 구현

}
