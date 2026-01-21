package org.com.bium.board.controller;

import org.com.bium.board.dto.BoardDto;
import org.com.bium.board.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // board 등록 기능 구현
    // POST : userId, boardTitle
    @PostMapping
    public ResponseEntity<BoardDto> insertBoard(@RequestBody BoardDto boardDto) {
        int boardId = boardService.insertBoard(boardDto);

        URI location = URI.create("/board/" + boardId);

        return ResponseEntity.created(location).build();
    }

}
