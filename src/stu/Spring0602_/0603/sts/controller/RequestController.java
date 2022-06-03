package stu.Spring0602_;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



//자동으로 스프링 컨테이너에 해당 클래스의 빈을 등록하는 아노테이션
//빈을 등록 해놔야  HandlerMapping이 이 클래스의 객체를 검색할 수 있을 것이다.
@Controller
public class RequestController {

	public RequestController() {
		System.out.println("RequestCon 생성!");
	}
	
	
	 				//runonserver하면 기본적ㅇ으로    localhost:8181/basic/  으로 설정되어있기에 , /request/test라고 작성한다.
	@RequestMapping("/request/test")
	public String testCall() {
		System.out.println("/request/test 요청이 들어옴!");
		return "test";
	}
	
	
	
	/*
    만약 사용자가 /request/req 요청을 보내 왔을 때
    views폴더 아래에 request폴더 안에 존재하는
    req-ex01.jsp파일을 열도록 메서드를 구성해 보세요.
    
     prefix :: /WEB-INF/views/
     suffix :: .jsp 
    */
	
	@RequestMapping("/request/req")
	public String req() {
		System.out.println("/request/req 요청이 들어옴!");
		return "request/req-ex01";
	}
	
	//@RequestMapping(value="/request/basic01",method = RequestMethod.GET)
	@GetMapping("/request/basic01")  //스프링 4버전 부터 허용
	public String basicGet() {
		
		System.out.println("/request/basic01 요청이 들어옴! : GET  요청!");
		return "request/req-ex01";
	}
	
	//@RequestMapping(value="/request/basic01", method = RequestMethod.POST)
	@PostMapping("/request/basic01")  //스프링 4버전 부터 허용
	public String basicPost() {
		
		System.out.println("/request/basic01 요청이 들어옴! : POST 요청!");
		return "request/req-ex01";
	}
	

	
}
