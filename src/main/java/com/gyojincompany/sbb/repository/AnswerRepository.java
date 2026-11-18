package com.gyojincompany.sbb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gyojincompany.sbb.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
	//기본적으로 제공하는 메소드 3가지
	//findby(select), delete(delete), save(insert)
}
