package com.spring.basic.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



//자동으로 스프링 컨테이너에 해당 클래스의 빈을 등록하는 아노테이션
//빈을 등록 해놔야  HandlerMapping이 이 클래스의 객체를 검색할 수 있을 것이다.
@Controller
@RequestMapping("/request") //컨트롤러 자체에 공통된 URI를 맵핑
public class RequestController {

	public RequestController() {
		System.out.println("RequestCon 생성!");
	}


	//runonserver하면 기본적ㅇ으로    localhost:8181/basic/  으로 설정되어있기에 , /request/test라고 작성한다.
	@RequestMapping("/test")
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

	@RequestMapping("/req")
	public String req() {
		System.out.println("/request/req 요청이 들어옴!");
		return "request/req-ex01";
	}

	//@RequestMapping(value="/request/basic01",method = RequestMethod.GET)
	@GetMapping("/basic01")  //스프링 4버전 부터 허용 | 
	public String basicGet() {

		System.out.println("/request/basic01 요청이 들어옴! : GET  요청!");
		return "request/req-ex01";
	}

	//@RequestMapping(value="/request/basic01", method = RequestMethod.POST)
	@PostMapping("/basic01")  //스프링 4버전 부터 허용
	public String basicPost() {

		System.out.println("/request/basic01 요청이 들어옴! : POST 요청!");
		return "request/req-ex01";
	}

	///////////////////////////////////////////////////////////////////////////

	////2022-06-07
	/*
	 * @GetMapping("/join") public String register() {
	 * System.out.println("/request/join : GET"); return "request/join"; }
	 *
	 */

	//컨트롤러 내의 메서드 타입을 void로 선언하시면 
	//요청이 들어온 URI값을 뷰 리졸버에게 전달합니다.  :리턴값과 URI 값 유사 할때 주로 사용
	//위의 코드와 같은 기능을 함.
	@GetMapping("/join")
	public void register() {
		System.out.println("/request/join : GET");
	}

	//요청 URI 주소가 같더라도 , 전송 방식에 따라서 맵핑을 다르게 진행하기 때문에
	//같은 주소를 사용하는것이 가능합니다.(GET ->화면 처리 ,POST->입력값 처리 )

	/*
	 1.전통적인 jsp/servlet 방식의 파라미터 읽기 처리 방법.
	 -HttpServletRequest 객체를 활용.(우리가 JSP에서 활용하던 방식)

	@PostMapping("/join")
	public void register(HttpServletRequest request) {
		System.out.println("/request/join : POST");

		System.out.println("ID :"+request.getParameter("userId"));
		System.out.println("PW:"+request.getParameter("userPw"));
		System.out.println("HOBBY:"+Arrays.toString(request.getParameterValues("hobby")));
	}
	 */

	/*
	 2.@requestParam 아노테이션을 이용한 요청 파라미터 처리 
	 	@RequestParam( ("파라미터 변수명") 값을 받아서 처리할 변수명)
	 */
	@PostMapping("join")
	public void register(@RequestParam("userId") String id,
			@RequestParam("userPw") String pw,
			@RequestParam("hobby") List<String> hobbies) {
		//List로 작성 시 값을 하나도 안주게 되면  아예 리스트 생성이 되질 않아 오류 발생
		System.out.println("ID :"+id);
		System.out.println("PW : "+pw);
		System.out.println("HOBBY :"+hobbies);
	}






















}
