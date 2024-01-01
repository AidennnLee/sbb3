package com.sbb.sbb3.answer.controller;

import com.sbb.sbb3.answer.service.AnswerService;
import com.sbb.sbb3.question.entity.Question;
import com.sbb.sbb3.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/answer")
public class AnswerController {

    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam("content") String content){
        Question question = this.questionService.getQuestion(id);
        this.answerService.create(question, content);

        return String.format("redirect:/question/detail/%s", id);
    }
}
