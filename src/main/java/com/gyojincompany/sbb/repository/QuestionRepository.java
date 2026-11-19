package com.gyojincompany.sbb.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gyojincompany.sbb.entity.Question;
import java.util.List;


public interface QuestionRepository extends JpaRepository<Question, Integer>{
	
	List<Question> findBySubject(String subject); 
	//제목으로 질문글 찾기 메소드
	
	//모든 질문글을 등록일의 내림차순으로 정렬하여 반환 메소드
	List<Question> findAllByOrderByCreateDateDesc();
		
	
	List<Question> findBySubjectLike(String subject);
	List<Question> findBySubjectContaining(String subject);
	//제목에 특정 키워드가 포함되어 있는 질문글 찾기 메소드
	//select * from question where subject like ?
	
	//select * from question where subject like ? or content ?;
	List<Question> findBySubjectLikeOrContentLike(String subject, String content);
	
	//select * from question where subject like ? or content ? order by creat_date asc;
	List<Question> findBySubjectLikeOrContentLikeOrderByCreateDateAsc(String subject, String content);
	
	//delete from question where subject like ?;
	void deleteBySubjectLike(String keyword);
	
	//페이징 처리 후 질문글 목록 불러오기 메소드
	Page<Question> findAll(Pageable pageable); 
	//pageable->사용자가 클릭한 페이지 번호, 한 페이지당 보여질 질문글의 갯수
	
}
