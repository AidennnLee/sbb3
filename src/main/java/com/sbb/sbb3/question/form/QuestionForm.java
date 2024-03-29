package com.sbb.sbb3.question.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class QuestionForm {
    @NotEmpty(message = "제목을 입력하세요")
    @Size(max = 100)
    private String title;

    @NotEmpty(message = "내용을 입력하세요")
    private String content;
}
