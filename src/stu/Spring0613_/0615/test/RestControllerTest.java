package stu.Spring0613_;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import oracle.jdbc.proxy.annotation.Post;

@RestController
@RequestMapping("/rest")
public class RestControllerTest {

	/*
	 	@ResponseBody   : 클래스에 @Controller붙였을 때 , 응답 바로 받고 싶으면 해당 메서드에 기입한다.
	 	-메서드가 리턴하는 데이터를 viewResolver에게 전달하지 않고 
	 	클라이언트에게 해당 데이터를 바로 응답하게 합니다.
	 	그래서 주로 비동기 통신에서 많이 사용
	
	  - @RestController를 사용하면 모든 메서드에 
	  @ResponseBody를 붙인 결과와 같습니다. :즉 ,일일히 붙일 필요 없다.
	  
	  JSON : 자바스크립트 데이터 표기방법을 따라한 , 데이터 표기법  : 프로그래밍언어 아님 ( 모든언어가 JSON을  파싱해서 써야함 )
	 */

	
	
	

	@GetMapping("/hello")
	//@ResponseBody
	public String hello() {
		return "Hello World!";
	}
	
	@GetMapping("/hobby")
	//@ResponseBody
	public List<String> hobby(){
		List<String> hobby=Arrays.asList("축구","영화감상","수영");
		return hobby;
	}
	
	@GetMapping("/study")
	public Map<String, Object> stduy(){
		Map<String,Object> subject=new HashMap<>();
		subject.put("자바", "java");
		subject.put("jsp", "java server pages");
		subject.put("스프링", "spring framework5");
		return subject;
		
	}
	
	@GetMapping("/person")
	public Person person() {
		Person p=new Person();
		p.setName("김철수");
		p.setAge(30);
		p.setHobby(Arrays.asList("수영","축구","독서"));
		return p;
	}
	
	
	//@RequestBody   :pom.xml에 작성한 jason-binder가 해줌 
	//클라이언트쪽에서 전송하는 JSON 데이터를 
	//서버에서 사용하는 JAVA언어에 맞게 변환(파싱)하여 받을 수 있게 해주는 아노테이션.
	@PostMapping("/getObject")     //JSON의 형태로 데이터 넣어서 인터넷에서 요청햇음
	public Person getObject(@RequestBody Person person) {  
		System.out.println("/getObject 요청이 들어옴");
		System.out.println("이름 : "+person.getName());
		System.out.println("나이 :"+person.getAge());
		System.out.println("취미 :"+person.getHobby());
		
		person.setAge(2);
		return person;
		
	}
	
	//http://localhost/rest/getPath/abc1234/10/32 로 요청
	@GetMapping("/getPath/{id}/{cpp}/{page}")   //변수명 같게쓰면 @PathVariabvle( )의 괄호 생략 가능  ::URL의 형태로 요청
	public Map<String, Object> getPath(@PathVariable String id,
									   @PathVariable int cpp,
									   @PathVariable int page){
		
		
		Map<String,Object> map=new HashMap<>();
		map.put("아이디",id);
		map.put("게시물개수",cpp);
		map.put("페이지번호",page);
		
		return map;
	}
	
	
	
	



}




























