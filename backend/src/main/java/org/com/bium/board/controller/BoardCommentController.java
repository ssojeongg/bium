package org.com.bium.board.controller;

import org.com.bium.board.dto.BoardCommentDto;
import org.com.bium.board.service.BoardCommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/boardComment")
public class BoardCommentController {

    private final BoardCommentService boardCommentService;
    public BoardCommentController(BoardCommentService boardCommentService) {
        this.boardCommentService = boardCommentService;
    }

    // boardComment 등록 기능 구현
    // POST :
    @PostMapping
    public ResponseEntity<BoardCommentDto> insertBoardComment(@RequestBody BoardCommentDto boardCommentDto) {
        int boardCommentId = boardCommentService.insertBoardComment(boardCommentDto);
        URI uri = URI.create("/boardComment/" + boardCommentId);

        return ResponseEntity.noContent().build();
    }


    // boardComment 목록 조회 기능 구현

    // boardComment 상세 조회 기능 구현

    // boardComment 수정 기능 구현

    // boardComment 삭제 기능 구현
}
