package org.com.bium.random.mapper;

import org.com.bium.random.dto.RBoardDto;

import java.util.List;

public interface RBoardMapper {
    // board 등록 기능 구현
    void insertRBoard(RBoardDto rboardDto);

    // user 존재 확인
    boolean existsByUserId(int userId);

    // board 목록 조회 기능 구현
    List<RBoardDto> getRBoard();
}
