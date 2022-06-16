package stu.Spring0613_;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.mvc.user.model.UserVO;
import com.spring.mvc.user.service.IUserService;

import oracle.jdbc.proxy.annotation.Post;

/*
 -만약에 컨트롤러에 비동기 통신 요청을 받는 메서드가 있다고 해서 
 무조건 그 컨트롤러는 restController일 필요는 없습니다
 일반 컨트롤러에 @ResponseBody가 붙은 메서드가 있으면 
 클라이언트 값을 리턴할 수 있습니다 . 
 @RestController 는 스프링 4부터 가능한 문법 
 --비동기 통신이 많을것 같으면 @RestController를 붙이는것이 좋다는거지 무조건은 아님 
 
 */


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService service;
	
	//아이디 중복 여부 체크 
	@PostMapping("/checkId")	//@RequestBodt를 붙여 JSON으로 넘어온 데이터를 자바로 변환 :login_modal.jsp의 ajax함수에 JSON으로보낸다고 써있음
	public String checkId(@RequestBody String account) {
		System.out.println("/user/checkId:POST");
		System.out.println("param:"+account);
		int checkNum=service.checkId(account);
		if(checkNum==1) {
			System.out.println("아이디가 중복됨!");
			return "duplicated";
		}else {
			System.out.println("아이디 사용 가능 ");
			return "available";
		}
	}
	
	//회원 가입 요청 처리
	@PostMapping("/")  //ajax에서 text 주기로 해서 String으로 쓴다.
	public String regiseter(@RequestBody UserVO vo) {
		System.out.println("/user/: POST");
		service.register(vo);
		return "joinSuccess";
		
	}

	//로그인 요청 처리 +암호화 
	@PostMapping("/loginCheck")
	public String loginCheck(@RequestBody UserVO vo,HttpSession session) {
		System.out.println("/user/loginCheck :POST");
		System.out.println("param :"+vo);
		
		//서버에서 세션 객체를 얻는 방법
		//1.HttpServlerRequest 객체 사용    메서드의 매개변수로 (HttpServletRequest request)선언
		//HttpSession session=request.getSession();
		 //JSP에서 사용하던 방법
		//기존의 스프링메서드를 오버라이딩하는 경우가 생길 수 있어 , 이 방법을 알아둬야 한다 !!!!!!!!!!!!!!
		
		//2.매가 값으로 HttpSession session 객체 받아서 사용 메서드의 매개변수로 (HttpSession session)선언 
		
		
		
		
		UserVO dbData=service.selectOne(vo.getAccount());
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		
		if(dbData !=null) {
			//if(dbData.getPassword().equals(vo.getPassword())) { 암호화 전 
			if(encoder.matches(vo.getPassword(), dbData.getPassword())) {
				
				//로그인 성공 회원을 대상으로 세션 정보를 생성
				session.setAttribute("login", dbData);
				
				
				return "loginSuccess";
			}else {
				return "pwFail";
			}
		}else {
			return "idFail";
		}
		
		
	}
	
	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session,RedirectAttributes ra) {
		System.out.println("/user/logout:GET");
		session.removeAttribute("login");
		ra.addFlashAttribute("msg", "logout");
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("redirect:/");
		return mv;
		 //다른 코드 같은 기능 
		//return new ModelAndView("redirect:/");
		
		//return new ModelAndView("redirect:/");
	}
	
}
