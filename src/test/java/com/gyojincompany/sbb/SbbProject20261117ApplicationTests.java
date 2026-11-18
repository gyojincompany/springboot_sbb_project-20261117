package com.gyojincompany.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gyojincompany.sbb.entity.Question;
import com.gyojincompany.sbb.repository.QuestionRepository;

@SpringBootTest
class SbbProject20261117ApplicationTests {
	
	@Autowired //DI 의존성 주입
	private QuestionRepository questionRepository;
	
	//질문 저장 테스트
//	@Test
//	@DisplayName("question 테이블 insert 테스트")
//	void testJpa1() {
//		Question q1 = new Question(); //질문 객체 생성(비어 있는 상태)
//		q1.setSubject("안녕하세요 질문3번 테스트입니다.");
//		q1.setContent("질문3번의 내용입니다. 잘되고 싶어요.");
//		q1.setCreateDate(LocalDateTime.now()); //현재 시간 추출하기
//		//insert into question(subject, content, createate)
//		//values('안녕','내용','2026-11-17 00:00:00;)
//		questionRepository.save(q1);
//	}
	
//	@Test
//	@DisplayName("question 테이블 select 테스트")
//	void testJpa2() {
//		//select * from question;
//		List<Question> questionList = questionRepository.findAll();
//		
//		assertEquals(3, questionList.size());
//		
//		System.out.println(questionList.get(0).getSubject());
//		
//	}
//	
//	@Test
//	@DisplayName("번호로 질문글 찾기")
//	void testJpa3() {
//		//select * from question where id=2;
//		Optional<Question> questionOptional = questionRepository.findById(2); //기본키인 id값으로 질문글 찾기
//		if(questionOptional.isPresent()) { //참이면 검색한 질문글이 존재한다는 이야기
//			Question question = questionOptional.get(); //Optional 객체안에서 질문글(question 객체) 빼기
//			System.out.println(question.getSubject());
//		}
//	}
//	
//	@Test
//	@DisplayName("제목으로 질문글 찾기")
//	void testJpa4() {
//		//select * from question where subject = ?
//		List<Question> subjectList = questionRepository.findBySubject("안녕하세요 질문3번 테스트입니다.");
//		//System.out.println(subjectList.get(0).getId()); //찾은 글의 번호 출력
//		assertEquals(3, subjectList.get(0).getId());
//	}
//	
//	@Test
//	@DisplayName("제목에 포함된 키워드로 질문글 찾기")
//	void testJpa5() {
//		//select * from question where subject like ?
//		List<Question> subjectList1 = questionRepository.findBySubjectLike("%안녕%");
//		//키워드에 % 포함해서 넣기
//		assertEquals(3, subjectList1.size());
//		
//		List<Question> subjectList2 = questionRepository.findBySubjectContaining("안녕");
//		//containing->% 없이 키워드만 넣기
//		assertEquals(3, subjectList2.size());
//		
//		List<Question> subjectList3 = questionRepository.findBySubjectLikeOrContentLike("%안녕%","%안녕%");
//		assertEquals(3, subjectList3.size());
//		
//	}
	
//	@Test
//	@DisplayName("질문글 삭제 테스트")
//	void testJpa6() {
//		Optional<Question> qOptional = questionRepository.findById(2);
//		if(qOptional.isPresent()) { //해당 번호의 글이 존재하는지 확인후에 삭제를 추천
//			questionRepository.deleteById(2); //2번글 삭제
//		}
//		
//	}
	
//	@Test
//	@DisplayName("질문글 제목과 내용 수정하기")
//	void testJpa7() {
//		//update question set subject=?, content=? where id=?;
//		//update 메소드는 존재하지 않음
//		//->해당 번호의 글을 가져오기(findById)->글 수정 후 save로 다시 넣기
//		Optional<Question> questionOp = questionRepository.findById(2); //2번글 가져오기
//		if(questionOp.isPresent()) {
//			Question question = questionOp.get();
//			question.setSubject("반갑습니다!");
//			question.setContent("오늘 비가 옵니다!");
//			questionRepository.save(question);
//		}
//		
//	}
	
	
//	@Test
//    void testJpa() {        
//        Question q1 = new Question();
//        q1.setSubject("sbb가 무엇인가요?");
//        q1.setContent("sbb에 대해서 알고 싶습니다.");
//        q1.setCreateDate(LocalDateTime.now());
//        this.questionRepository.save(q1);  // 첫번째 질문 저장
//
//        Question q2 = new Question();
//        q2.setSubject("스프링부트 모델 질문입니다.");
//        q2.setContent("id는 자동으로 생성되나요?");
//        q2.setCreateDate(LocalDateTime.now());
//        this.questionRepository.save(q2);  // 두번째 질문 저장
//    }
	
//	@Test
//    void testJpa() {
//        List<Question> all = this.questionRepository.findAll();
//        assertEquals(5, all.size());
//
//        Question q = all.get(3); //세번째 글 index 3
//        assertEquals("sbb가 무엇인가요?", q.getSubject());
//    }
	
	@Test
    void testJpa() {
        Optional<Question> oq = this.questionRepository.findById(4);
        if(oq.isPresent()) {
            Question q = oq.get();
            assertEquals("sbb가 무엇인가요?", q.getSubject());
        }
    }
	
//	@Test
//	@DisplayName("질문 수정 테스트")
//	void testJpa2() {
//		//JpaRepository에 update 메소드는 존재하지 않음
//		//1. findBy로 레코드를 찾아온다
//		//2. 찾아온 레코드의 내용을 수정(setter 사용)
//		//3. 수정한 후에 save로 다시 DB에 넣기
//		
//		Optional<Question> op = questionRepository.findById(1); //1번글 가져오기
//		if(op.isPresent()) { //참일 경우에만 레코드 가져오기가 가능(참일 때만 수정가능)
//			Question question = op.get(); //1번 질문글 꺼내기
//			question.setSubject("오늘 제목 수정했습니다.");
//			question.setContent("내용도 수정했습니다!!");
//			questionRepository.save(question);
//		}
//		
//	}
	
	@Test
	@DisplayName("질문글 삭제 연습") //delete
	void testJpa3() {
		
	}
	
}
