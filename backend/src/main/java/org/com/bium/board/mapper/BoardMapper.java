package org.com.bium.board.mapper;

import org.com.bium.board.dto.BoardDto;

import java.util.List;

public interface BoardMapper {

    // board 등록 기능 구현
    void insertBoard(BoardDto boardDto);

    // user 존재 확인
    boolean existsByUserId(int userId);

    // board 목록 조회 기능 구현
    List<BoardDto> getBoard();

    // board 상세 조회 기능 구현
    BoardDto getByBoardId(int boardId);

    // board 수정 기능 구현
    void updateBoard(BoardDto boardDto);
}
