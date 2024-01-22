package com.sbb.sbb3.member.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberCreateForm {
    @Size(min = 3, max = 25)
    @NotEmpty(message = "사용자 ID를 입력하세요")
    private String username;

    @NotEmpty(message = "비밀번호를 입력하세요")
    private String password;

    @NotEmpty(message = "비밀번호 확인을 입력하세요")
    private String passwordConfirm;

    @NotEmpty(message = "이메일을 입력하세요")
    private String email;
}
