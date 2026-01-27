package org.com.bium.board.mapper;

import org.apache.ibatis.annotations.Param;
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

    // board 삭제 기능 구현
    void deleteBoard(int boardId);

    // BoardLike 좋아요 추가 기능 구현
    void addBoardLike(@Param("boardId") int boardId,
                      @Param("userId") int userId);

    // Like_count +1 증가
    void updateLikeCount(int boardId);

    // 증가된 like_count 조회
    int getLikeCount(int boardId);

    // BoardLike 좋아요 삭제 기능 구현
    void deleteBoardLike(@Param("boardId") int boardId,
                                @Param("userId") int userId);

    // Like_count -1 증가
    void minusLikeCount(int boardId);

    // BoardLike 좋아요 존재 여부 확인 구현
    int existsBoardLike(@Param("boardId") int boardId,
                               @Param("userId") int userId);
}
