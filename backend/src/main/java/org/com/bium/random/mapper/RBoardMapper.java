package org.com.bium.random.mapper;

import org.com.bium.random.dto.RBoardDto;

import java.util.List;

public interface RBoardMapper {
    // rBoard 등록 기능 구현
    void insertRBoard(RBoardDto rboardDto);

    // user 존재 확인
    boolean existsByUserId(int userId);

    // rBoard 목록 조회 기능 구현
    List<RBoardDto> getRBoard();

    // rBoard 상세 조회 기능 구현
    RBoardDto getByRBoardId(int rBoardId);

    // rBoard 수정 기능 구현
    void updateRBoard(RBoardDto rBoardDto);

    // rBoard 삭제 기능 구현
    void deleteRBoard(int rBoardId);
}
