package com.gyojincompany.sbb;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gyojincompany.sbb.entity.Answer;
import com.gyojincompany.sbb.entity.Question;
import com.gyojincompany.sbb.repository.AnswerRepository;
import com.gyojincompany.sbb.repository.QuestionRepository;

@SpringBootTest
class JpaTest01 {

	@Autowired //DI
	private AnswerRepository answerRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Test
	@DisplayName("답변 저장 테스트")
	void test1() {
		Optional<Question> questionOp = questionRepository.findById(1); //1번 질문글 엔티티 가져오기
		assertTrue(questionOp.isPresent()); //거짓->중간에서 테스트 종료
		Question q1 = questionOp.get();
		
		
		Answer answer = new Answer();
		answer.setContent("1번 질문글의 답변입니다."); //답변 내용 넣기
		answer.setCreateDate(LocalDateTime.now()); //현재 시간 넣기
		answer.setQuestion(q1);
		
		answerRepository.save(answer);
	}

}
