package org.com.bium.random.mapper;

import org.apache.ibatis.annotations.Param;
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

    // RBoardLike 좋아요 추가 기능 구현
    void addRBoardLike(@Param("rBoardId") int rBoardId,
                      @Param("userId") int userId);

    // Like_count +1 증가
    void updateLikeCount(int rBoardId);

    // 변화된 like_count 조회
    int getLikeCount(int rBoardId);


    // RBoardLike 좋아요 삭제 기능 구현
    void deleteRBoardLike(@Param("rBoardId") int rBoardId,
                         @Param("userId") int userId);

    // Like_count -1 감소
    void minusLikeCount(int rBoardId);

    // RBoardLike 좋아요 존재 여부 확인 구현
    int existsRBoardLike(@Param("rBoardId") int rBoardId,
                        @Param("userId") int userId);
}
