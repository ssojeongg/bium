package org.com.bium.board.controller;

import org.com.bium.board.dto.BoardDto;
import org.com.bium.board.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

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

    // board 목록 조회 기능 구현
    @GetMapping
    public ResponseEntity<List<BoardDto>> getBoard() {
        List<BoardDto> list = boardService.getBoard();
        return ResponseEntity.ok(list);
    }

    // board 상세 조회 기능 구현
    @GetMapping("/{boardId}")
    public ResponseEntity<BoardDto> getByBoardId(@PathVariable int boardId) {
        BoardDto item = boardService.getByBoardId(boardId);
        return ResponseEntity.ok(item);
    }
}
