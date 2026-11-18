package com.gyojincompany.sbb;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.gyojincompany.sbb.entity.Answer;
import com.gyojincompany.sbb.entity.Question;
import com.gyojincompany.sbb.repository.AnswerRepository;
import com.gyojincompany.sbb.repository.QuestionRepository;

@SpringBootTest
class SbbProjectTest {
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
//	@Test
//	@DisplayName("답변글 저장 테스트")
//	void test1() {
//		//답변글이 달릴 질문글이 존재해야만 답변이 저장될 수 있다
//		//1. 답변이 달릴 질문글 레코드를 db에서 가져온다
//		//2. 해당 질문글에 답변이 달리도록 answer 테이블에 저장
//		
//		//5번 질문글에 답변달기
//		Optional<Question> op = questionRepository.findById(5); 
//		//부모 질문글 5번 가져오기(답변이 달릴 질문글 5번)
//		
//		if(op.isPresent()) { //답변이 달릴 질문글이 존재
//			Question question = op.get();
//			
//			Answer answer = new Answer();
//			answer.setContent("2번째 답변 네 자동으로 생성됩니다.");
//			answer.setQuestion(question); //질문이 달릴 질문글 entity를 setter로 저장
//			answer.setCreateDate(LocalDateTime.now()); //현재 시간 추출하여 답변 등록일로 저장
//			answerRepository.save(answer); //답변글 저장
//		}
//	}
	
//	@Test
//    void testJpa() {
//        Optional<Answer> oa = this.answerRepository.findById(2);
//        assertTrue(oa.isPresent());
//        Answer a = oa.get();
//        assertEquals(5, a.getQuestion().getId());
//    }
	
//	@Transactional
	@Test
	@DisplayName("5번 질문글에 달린 답변들 확인 테스트")
    void testJpa() {
       Optional<Question> op5 = questionRepository.findById(5); //5번 질문글 가져오기
       if(op5.isPresent()) { //참->5번 질문글 존재확인
    	   Question q5 = op5.get(); //5번 질문글 가져오기
    	   
    	   List<Answer> answerList = q5.getAnswerList(); //5번 질문글에 달린 답변글들 list
    	   
    	   System.out.println(answerList.get(0).getContent());
    	   //5번 질문글에 달린 답변 중 첫번째 답변의 내용 출력
    	   System.out.println(answerList.get(1).getContent());
    	   //5번 질문글에 달린 답변 중 두번째 답변의 내용 출력
       }
       
    }
	
	

}
