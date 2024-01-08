package com.sbb.sbb3.question.controller;

import com.sbb.sbb3.question.entity.Question;
import com.sbb.sbb3.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/list")
    public String list(Model model){
        List<Question> questionList = questionService.getList();
        model.addAttribute("questionList", questionList);

        return "question/question_list";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id){
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);

        return "question/question_detail";
    }

    @GetMapping("/create")
    public String questionCreate(){
        return "question/question_from";
    }

    @PostMapping("/create")
    public String questionCreate(@RequestParam(value = "title") String title, @RequestParam(value = "content") String content){
        this.questionService.create(title, content);

        return "redirect:/question/list";
    }
}
