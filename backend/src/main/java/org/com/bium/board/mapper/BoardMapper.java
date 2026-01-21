package org.com.bium.board.mapper;

import org.com.bium.board.dto.BoardDto;

public interface BoardMapper {

    // board 등록 기능 구현
    void insertBoard(BoardDto boardDto);

    // user 존재 확인
    boolean existsByUserId(int userId);
}
