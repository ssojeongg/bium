package org.com.bium.board.dto;


import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {

    private int boardId;
    private int userId;
    private String boardTitle;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
