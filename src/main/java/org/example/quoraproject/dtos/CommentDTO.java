package org.example.quoraproject.dtos;

import lombok.Data;

@Data
public class CommentDTO {
    private Long id;
    private String content;
    private Long answerId;
    private Long parentCommentId;
}