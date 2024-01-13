package com.application.employee.repository;

import java.util.List;

import com.application.employee.entity.Quiz;
import com.application.employee.entity.QuizQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizQuestionRepository extends JpaRepository<QuizQuestion, Long> {
    // Custom methods for quiz question-related operations
	public List<QuizQuestion> findByQuiz(Quiz quiz);
}