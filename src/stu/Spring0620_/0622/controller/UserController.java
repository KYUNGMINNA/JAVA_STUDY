package stu.Spring0620_;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.myweb.user.service.IUserService;
import com.spring.myweb.util.MailSendService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	
	//도로명주소 승인 키->devU01TX0FVVEgyMDIyMDYyMjE2MTc1MjExMjcxNjM=
	
	@Autowired
	private IUserService service;
	
	@Autowired
	private MailSendService mailService;
	
	
	//회원가입 페이지로 이동 
	@GetMapping("/userJoin")
	public void userJoin() {
		
	}
	
	//아아디 중복 확인(비동기)
	@ResponseBody   //RestController가 아닌 경우에는 아노테이션을 붙여야 비동기 통신이 가능하다.
	@PostMapping("/idCheck")
	public String check(@RequestBody String userId) {
		System.out.println(userId);
		
		int result=service.idCheck(userId);
		
		if(result ==1) {
			return "duplicated";
		}else {
			return "ok";
		}
	}
	
	
	//이메일 인증 
	@GetMapping("/mailCheck")
	@ResponseBody			//파라미터 변수명과  ,매개변수명이 똑같으면 @requestParam 작성안해도 된다.
	public String mailCheck(String email) {
		System.out.println("이메일 인증 요청 들어옴!");
		System.out.println("인증 이메일 :"+email);
		return mailService.joinEmail(email);
		
	}
	
	
	

}
