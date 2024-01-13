package com.application.employee.service;

import com.application.employee.entity.UserAnswers;
import com.application.employee.repository.UserAnswerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAnswerService {
	private final UserAnswerRepository userAnswerRepository;

	public UserAnswerService(UserAnswerRepository userAnswerRepository) {
		this.userAnswerRepository = userAnswerRepository;
	}

	public UserAnswers createUserAnswer(UserAnswers userAnswer) {
		return userAnswerRepository.save(userAnswer);
	}

	public UserAnswers getUserAnswerById(Long id) {
		return userAnswerRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("User Answer not found"));
	}

	public UserAnswers updateUserAnswer(Long id, UserAnswers updatedUserAnswer) {
		UserAnswers userAnswer = getUserAnswerById(id);
		userAnswer.setUsers(updatedUserAnswer.getUsers());
		userAnswer.setQuestions(updatedUserAnswer.getQuestions());
		userAnswer.setSelectedOption(updatedUserAnswer.getSelectedOption());
		return userAnswerRepository.save(userAnswer);
	}

	public void deleteUserAnswer(Long id) {
		UserAnswers userAnswer = getUserAnswerById(id);
		userAnswerRepository.delete(userAnswer);
	}

	public List<UserAnswers> getAllUserAnswers() {
		return userAnswerRepository.findAll();
	}
}
		