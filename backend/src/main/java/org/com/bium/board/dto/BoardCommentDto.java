package org.com.bium.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BoardCommentDto {
    private int boardCommentId;

    private int boardId;

    private String boardCommentName;

    private String boardCommentTitle;

    private String boardCommentContent;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    // private int viewCount;

    // private int likeCount;
}
