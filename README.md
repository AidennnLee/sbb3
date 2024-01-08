# 점프 투 스프링부트

## 개요

---
스프링 부트 공부를 목적으로 위키독스의 [점프 투 스프링부트](https://wikidocs.net/book/7601) 문서를 보면서 "Spring Boot Board(SBB)"라는 이름의 게시판 서비스를 만든다.
- velog 시리즈 : https://velog.io/@aiden_lee/series/%EC%A0%90%ED%94%84-%ED%88%AC-%EC%8A%A4%ED%8A%B8%EB%A7%81%EB%B6%80%ED%8A%B8
- github 리포지터리 : https://github.com/AidennnLee/sbb3.git

## 구조

---

### home

#### Home Controller

- ("/")
- ("/sbb")

### question

#### QuestionController

- @GetMapping("/question/list")
- @GetMapping("/question/create")
- @GetMapping("/question/detail/{id}")

#### QuestionService

#### QuestionRepository

#### Question(Entity)

|속성명| 설명          |
|---|-------------|
|id| 	질문의 고유 번호  |
|subject| 	질문의 제목     |
|content| 	질문의 내용     |
|create_date| 	질문을 작성한 일시 |


### answer

#### AnswerController

- @PostMapping("answer/create/{id}")

#### AnswerService

#### AnswerRepository

#### Answer(Entity)

|속성명| 설명       |
|---|----------|
|id| 	답변의 고유 번호 |
|subject| 	답변의 제목  |
|content| 	답변의 내용  |
|create_date| 답변을 작성한 일시 |

### template

#### question

- question_list
- question_detail
- question_form

#### global

- layout

### Exception

- DataNotFoundException

## 메모

---