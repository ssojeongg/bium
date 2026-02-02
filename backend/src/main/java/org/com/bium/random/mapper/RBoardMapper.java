package org.com.bium.random.mapper;

import org.com.bium.random.dto.RBoardDto;

public interface RBoardMapper {
    // board 등록 기능 구현
    void insertRBoard(RBoardDto rboardDto);

    // user 존재 확인
    boolean existsByUserId(int userId);
}
