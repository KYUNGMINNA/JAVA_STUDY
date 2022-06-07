package com.spring.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.basic.model.BirthVO;

@Controller
public class BirthController {

	//생일을 입력하는 폼을 열어주는 메서드
	@GetMapping("/birth")
	public String birthform() {
		return "birth/birth-form";
	}
	
	//생일 정보를 result페이지에 전달하는 요청 메서드
	@PostMapping("/birth")
							//스프링이 setter메서드로 값을 집어 넣는다.
	public String login(BirthVO vo,Model model) {
		
		//@ModelAttribute("birth") BirthVO vo 로 작성하는게 더 낫다.
		
		System.out.println(vo.getYear()+vo.getMonth()+vo.getDay());
		model.addAttribute("vo",vo);
		
		return "birth/birth-result";
	}
}
