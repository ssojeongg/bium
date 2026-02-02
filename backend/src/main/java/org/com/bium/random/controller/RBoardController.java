package org.com.bium.random.controller;

import org.com.bium.board.dto.BoardDto;
import org.com.bium.random.dto.RBoardDto;
import org.com.bium.random.service.RBoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/random")
public class RBoardController {
    private final RBoardService rBoardService;
    public RBoardController(RBoardService rBoardService) {
        this.rBoardService = rBoardService;
    }

    // RBoard 등록 기능 구현
    // POST : userId, rBoardTitle, rBoardContent
    @PostMapping
    public ResponseEntity<RBoardDto> insertRBoard(@RequestBody RBoardDto rBoardDto) {
        int boardId = rBoardService.insertRBoard(rBoardDto);

        URI location = URI.create("/random/" + boardId);

        return ResponseEntity.created(location).build();
    }

    // board 목록 조회 기능 구현
    @GetMapping
    public ResponseEntity<List<RBoardDto>> getRBoard() {
        List<RBoardDto> list = rBoardService.getRBoard();
        return ResponseEntity.ok(list);
    }

}
