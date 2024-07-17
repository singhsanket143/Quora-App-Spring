package org.example.quoraproject.controllers;


import org.example.quoraproject.dtos.CommentDTO;
import org.example.quoraproject.models.Comment;
import org.example.quoraproject.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/answer/{answerId}")
    public List<Comment> getCommentsByAnswerId(@PathVariable Long answerId, @RequestParam int page, @RequestParam int size) {
        return commentService.getCommentsByAnswerId(answerId, page, size);
    }

    @GetMapping("/comment/{commentId}")
    public List<Comment> getRepliesByCommentId(@PathVariable Long commentId, @RequestParam int page, @RequestParam int size) {
        return commentService.getRepliesByCommentId(commentId, page, size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long id) {
        Optional<Comment> comment = commentService.getCommentById(id);
        return comment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Comment createComment(@RequestBody CommentDTO commentDTO) {
        return commentService.createComment(commentDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }
}