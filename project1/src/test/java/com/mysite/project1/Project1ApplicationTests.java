package com.mysite.project1;

//import java.time.LocalDateTime;   // 1. 데이터 저장하기 
import static org.junit.jupiter.api.Assertions.assertEquals;

//import java.util.List; // 2. 데이터 조회하기

import java.util.Optional;  // ID 값으로 데이터 조회 

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.project1.question.Question;
import com.mysite.project1.question.QuestionRepository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class Project1ApplicationTests {
	
	@Autowired
    private QuestionRepository questionRepository;
	
	@Test
    void testJpa() {        
//        Question q1 = new Question();   //1. 데이터 저장하기 
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
		
//		List<Question> all = this.questionRepository.findAll();  2. 데이터 조회하기 
//        assertEquals(2, all.size());
//
//        Question q = all.get(0);
//        assertEquals("sbb가 무엇인가요?", q.getSubject());
		
//		Optional<Question> oq = this.questionRepository.findById(1);  // ID값으로 데이터 조회
//        if(oq.isPresent()) {
//            Question q = oq.get();
//            assertEquals("sbb가 무엇인가요?", q.getSubject());
//        }
		
		Question q = this.questionRepository.findBySubjectAndContent(
                "sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
        assertEquals(1, q.getId());
    }
}
