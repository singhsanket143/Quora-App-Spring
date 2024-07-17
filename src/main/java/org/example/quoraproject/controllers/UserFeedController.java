package org.example.quoraproject.controllers;

import org.example.quoraproject.models.Question;
import org.example.quoraproject.services.UserFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/feed")
public class UserFeedController {
    @Autowired
    private UserFeedService userFeedService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Question>> getUserFeed(@PathVariable Long userId, @RequestParam int page, @RequestParam int size) {
        List<Question> feed = userFeedService.getUserFeed(userId, page, size);
        return ResponseEntity.ok(feed);
    }
}