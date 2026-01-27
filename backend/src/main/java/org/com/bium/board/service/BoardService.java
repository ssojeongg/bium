package org.com.bium.board.service;

import org.com.bium.board.dto.BoardDto;
import org.com.bium.board.mapper.BoardMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {

    private final BoardMapper boardMapper;
    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    // board 등록 기능 구현
    @Transactional
    public int insertBoard(BoardDto boardDto) {
        // user 존재 확인
        if(!boardMapper.existsByUserId(boardDto.getUserId())) {
            throw new IllegalArgumentException("user가 존재하지 않습니다.");
        }
        boardMapper.insertBoard(boardDto);
        return boardDto.getBoardId();
    }

    // board 목록 조회 기능 구현
    public List<BoardDto> getBoard() {
        return boardMapper.getBoard();
    }

    // board 상세 조회 기능 구현
    public BoardDto getByBoardId(int boardId) {
        return boardMapper.getByBoardId(boardId);
    }

    // board 수정 기능 구현
    public BoardDto updateBoard(BoardDto boardDto) {
        boardMapper.updateBoard(boardDto);
        return boardMapper.getByBoardId(boardDto.getBoardId());
    }

    // board 삭제 기능 구현
    public void deleteBoard(int boardId) {
        boardMapper.deleteBoard(boardId);
    }

    // BoardLike 좋아요 추가 기능 구현
    @Transactional
    public int addBoardLike(int boardId, int userId) {
        // BoardLike 좋아요 존재 여부 확인
        if(boardMapper.existsBoardLike(boardId, userId) > 0) {
            throw new IllegalArgumentException("이미 좋아요를 누른 댓글입니다.");
        }

        // 좋아요 추가
        boardMapper.addBoardLike(boardId,userId);

        // 좋아요 +1
        boardMapper.updateLikeCount(boardId);

        // 증가된 like_count
        return boardMapper.getLikeCount(boardId);
    }

    // BoardLike 좋아요 삭제 기능 구현
    @Transactional
    public int deleteBoardLike(int boardId, int userId) {
        // 좋아요 삭제
        boardMapper.deleteBoardLike(boardId,userId);

        // 좋아요 -1
        boardMapper.minusLikeCount(boardId);

        // 증가된 like_count
        return boardMapper.getLikeCount(boardId);
    }
}
