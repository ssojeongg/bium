package org.com.bium.random.service;

import org.com.bium.random.dto.RBoardDto;
import org.com.bium.random.mapper.RBoardMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RBoardService {

    private final RBoardMapper rBoardMapper;
    public RBoardService(RBoardMapper rBoardMapper) {
        this.rBoardMapper = rBoardMapper;
    }

    // RBoard 등록 기능 구현
    @Transactional
    public int insertRBoard(RBoardDto rBoardDto) {
        // user 존재 확인
        if(!rBoardMapper.existsByUserId(rBoardDto.getUserId())) {
            throw new IllegalArgumentException("user가 존재하지 않습니다.");
        }
        rBoardMapper.insertRBoard(rBoardDto);
        return rBoardDto.getRBoardId();
    }

    // RBoard 목록 조회 기능 구현
    public List<RBoardDto> getRBoard() {
        return rBoardMapper.getRBoard();
    }

    // RBoard 상세 조회 기능 구현
    public RBoardDto getByRBoardId(int rBoardId) {
        return rBoardMapper.getByRBoardId(rBoardId);
    }
}
