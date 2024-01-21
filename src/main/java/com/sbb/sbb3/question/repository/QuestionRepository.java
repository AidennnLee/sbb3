package com.sbb.sbb3.question.repository;

import com.sbb.sbb3.question.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Question findByTitle(String title);
    Question findByTitleAndContent(String title, String content);
    List<Question> findByTitleLike(String title);
    Page<Question> findAllBy(Pageable pageable);
}
