package com.sbb.sbb3;

import com.sbb.sbb3.answer.repository.AnswerRepository;
import com.sbb.sbb3.question.repository.QuestionRepository;
import com.sbb.sbb3.question.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class Sbb3ApplicationTests {

    @Autowired
    private QuestionService questionService;

    @Test
    void testJpa(){
        for(int i = 1; i <= 300; i++){
            String title = String.format("테스트 데이터 [%03d]", i);
            String content = "내용 없음";
            this.questionService.create(title, content);

        }
    }
}
