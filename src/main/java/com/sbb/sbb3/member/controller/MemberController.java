package com.sbb.sbb3.member.controller;

import com.sbb.sbb3.member.form.MemberCreateForm;
import com.sbb.sbb3.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/signup")
    public String signup(MemberCreateForm memberCreateForm){
        return "member/signup_form";
    }

    @PostMapping("/signup")
    public String signup(@Valid MemberCreateForm memberCreateForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "member/signup_form";
        }
        if(!memberCreateForm.getPassword().equals(memberCreateForm.getPasswordConfirm())){
            bindingResult.rejectValue("passwordConfirm", "passwordIncorrect", "패스워드가 일치하지 않습니다.");
            return "member/signup_form";
        }
        try {
            memberService.create(memberCreateForm.getUsername(),
                    memberCreateForm.getEmail(), memberCreateForm.getPassword());
        } catch (DataIntegrityViolationException e){
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
            return "member/signup_form";
        } catch (Exception e){
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            return "member/signup_form";
        }

        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(){
        return "member/login_form";
    }
}
