package com.spring.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.basic.model.UserVO;

@Controller
@RequestMapping("/response")
public class ResponseController {

	@GetMapping("/res-ex01")
	public void resEx01() {

	}

	/*
	 //1.Model 객체를 사용하여 화면에 데이터 전송하기.
	  
	  @GetMapping("/test") 
	  public void test(@RequestParam("age") int age,Model  model) {
	 
	  //모델은 뷰페이지로 자동으로 전달함
	  model.addAttribute("age",age);
	  model.addAttribute("nick","멍멍이"); 
	  }
	  
	 */	

	//2.@ModelAttribute를 사용한 화면에 데이터 전송 처리      
	//@RequestParam + model.addAttribute 처럼 동작
	@GetMapping("/test")		 //파라미터 값 
	public void test(@ModelAttribute("age") int age ,Model model) {
			model.addAttribute("nick","야옹이");
			//model.addAttribute("age",age); 는 할 필요 없다 !! 
		
		
	}
	
	@GetMapping("/test2")
	public void test2(@ModelAttribute("info") UserVO vo ) {
		//info라는 이름으로 모델에 담는다는 의미 
		System.out.println("메서드 내의 콘솔 출력 :"+vo);
		
	}
	
	
	//3.ModelAndView 객체를 활용한 처리  : model객체 +뷰 지정 가능 
	// 비동기 통신 처리 할 때 주로 사용
	@GetMapping("/test3")
	public ModelAndView test3() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("userName","김철수");   //addAttribute 한것과 같다
		mv.addObject("userAge", 30);
		mv.setViewName("/response/test3");
		
		return mv;
		
		
	}
	
	/////////////////////////////////////////////////////
	@GetMapping("/res-quiz01")
	public void quiz() {}
	

	@PostMapping("/res-login")
	public String login(@ModelAttribute("user") UserVO user) {
		if(user.getUserId().equals("kim123") && user.getUserPw().equals("1234"))
			return "response/res-quiz02";
			
		
		
		return "response/res-quiz03";
		
	}
	
	
	
	
	
}

































