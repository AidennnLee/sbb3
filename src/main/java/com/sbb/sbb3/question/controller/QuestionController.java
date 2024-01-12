package com.sbb.sbb3.question.controller;

import com.sbb.sbb3.question.QuestionForm;
import com.sbb.sbb3.question.entity.Question;
import com.sbb.sbb3.question.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "question/question_form";
        }
        this.questionService.create(questionForm.getTitle(), questionForm.getContent());

        return "redirect:/question/list";
    }
}
