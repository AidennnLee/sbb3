package com.sbb.sbb3.question.repository;

import com.sbb.sbb3.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
