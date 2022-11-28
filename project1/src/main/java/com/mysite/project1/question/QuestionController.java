package com.mysite.project1.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import com.mysite.project1.answer.AnswerForm;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {
	
	//private final QuestionRepository questionRepository;
	
	private final QuestionService questionService;
	
	@RequestMapping("/list")
    public String list(Model model, @RequestParam(value = "page", defaultValue="0") int page) {
		//List<Question> questionList = this.questionRepository.findAll();
		
//		List<Question> questionList = this.questionService.getList();
//      model.addAttribute("questionList", questionList);
		
		Page<Question> paging = this.questionService.getList(page);
		model.addAttribute("paging", paging);
        return "question_list";
    }
	
	@RequestMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerFrom) {
		Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }
	
	@GetMapping("/create")
    public String questionCreate(QuestionForm questionForm) {
        return "question_form";
    }
	
	@PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "question_form";
        }
        
        this.questionService.create(questionForm.getSubject(), questionForm.getContent());
        return "redirect:/question/list";
	}
}
