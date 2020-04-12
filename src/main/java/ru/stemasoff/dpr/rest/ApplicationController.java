package ru.stemasoff.dpr.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.stemasoff.dpr.dto.AnswerDto;
import ru.stemasoff.dpr.dto.KnowledgeBaseDto;
import ru.stemasoff.dpr.service.KnowledgeBaseService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class ApplicationController {
    private final KnowledgeBaseService service;

    @GetMapping("/start")
    public KnowledgeBaseDto start(){
        return service.start();
    }

    @PostMapping("/answer")
    public KnowledgeBaseDto answer(@RequestBody AnswerDto answerDto) {
        return service.answer(answerDto.getPoint(), answerDto.isAnswer());
    }

}
