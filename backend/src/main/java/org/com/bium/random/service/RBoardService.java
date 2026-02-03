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

    // RBoard 수정 기능 구현
    public RBoardDto updateRBoard(RBoardDto rBoardDto) {
        rBoardMapper.updateRBoard(rBoardDto);
        return rBoardMapper.getByRBoardId(rBoardDto.getRBoardId());
    }

    // RBoard 삭제 기능 구현
    public void deleteRBoard(int rBoardId) {
        rBoardMapper.deleteRBoard(rBoardId);
    }

    // RBoardLike 좋아요 추가 기능 구현
    @Transactional
    public int addRBoardLike(int rBoardId, int userId) {
        // RBoardLike 좋아요 존재 여부 확인
        if(rBoardMapper.existsRBoardLike(rBoardId, userId) > 0) {
            throw new IllegalArgumentException("이미 좋아요를 누른 게시글입니다.");
        }

        // 좋아요 추가
        rBoardMapper.addRBoardLike(rBoardId,userId);

        // 좋아요 +1
        rBoardMapper.updateLikeCount(rBoardId);

        // 증가된 like_count
        return rBoardMapper.getLikeCount(rBoardId);
    }
}
