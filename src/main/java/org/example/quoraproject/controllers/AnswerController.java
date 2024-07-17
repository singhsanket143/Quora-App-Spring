package org.example.quoraproject.controllers;


import org.example.quoraproject.dtos.AnswerDTO;
import org.example.quoraproject.models.Answer;
import org.example.quoraproject.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/answers")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @GetMapping("/question/{questionId}")
    public List<Answer> getAnswersByQuestionId(@PathVariable Long questionId, @RequestParam int page, @RequestParam int size) {
        return answerService.getAnswersByQuestionId(questionId, page, size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Answer> getAnswerById(@PathVariable Long id) {
        Optional<Answer> answer = answerService.getAnswerById(id);
        return answer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Answer createAnswer(@RequestBody AnswerDTO answerDTO) {
        return answerService.createAnswer(answerDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnswer(@PathVariable Long id) {
        answerService.deleteAnswer(id);
        return ResponseEntity.noContent().build();
    }
}