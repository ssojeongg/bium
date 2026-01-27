package org.com.bium.board.mapper;


import org.apache.ibatis.annotations.Param;
import org.com.bium.board.dto.BoardCommentDto;

import java.util.List;

public interface BoardCommentMapper {

    // boardComment 등록 기능 구현 전에 board 유무 확인
    boolean existsByBoardId(int boardId);

    // boardComment 등록 기능 구현
    void insertBoardComment(BoardCommentDto boardCommentDto);

    // boardComment 목록 조회 기능 구현
    List<BoardCommentDto> getBoardComment();

    // boardComment 상세 조회 기능 구현
    BoardCommentDto getByBoardCommentId(int boardCommentId);

    // boardComment 수정 기능 구현
    void updateBoardComment(BoardCommentDto boardCommentDto);

    // boardComment 삭제 기능 구현
    void deleteBoardComment(int boardCommentId);

    // BoardCommentLike 좋아요 추가 기능 구현
    void addBoardCommentLike(@Param("boardCommentId") int boardCommentId,
            @Param("userId") int userId);

    // Like_count +1 증가
    void updateLikeCount(int boardCommentId);

    // 증가된 like_count 조회
    int getLikeCount(int boardCommentId);

    // BoardCommentLike 좋아요 삭제 기능 구현
    void deleteBoardCommentLike(@Param("boardCommentId") int boardCommentId,
                             @Param("userId") int userId);

    // Like_count -1 증가
    void minusLikeCount(int boardCommentId);

    // BoardCommentLike 좋아요 존재 여부 확인 구현
    int existsBoardCommentLike(@Param("boardCommentId") int boardCommentId,
                                   @Param("userId") int userId);

}
