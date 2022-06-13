package stu.Spring0613_;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.spring.mvc.board.controller.BoardController;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/mvc-config.xml",
"file:src/main/webapp/WEB-INF/spring/servlet-config.xml"}) //sevlet-config에 controller설정이 되어있어서 가져와야함
@WebAppConfiguration  //WebApplicationContext 를 사용하가 위한 아노테이션
@Log4j
public class BoardControllerTest {



	/*
	 	-테스트 환경에서 가상의 DispatcherServlet을 사용하기 위한 객체 자동 주입.  ::서버 동작하지 않아 ,dispatcherservlet생성안되서 이 객체를 사용
	 	- WebApplicationContext는 Spring에서 제공되는 servlet들을 사용할 수 있도록 정보를 저장하는 객체
	 */

	@Autowired               
	private WebApplicationContext ctx;


	//특정 컨트롤러만 테스트 할 때 , 그 컨트롤러만  가져옴 
	//	---@Autowired
	//	---private BoardController controller;
	// ---this.mockMvc=MockMvcBuilders.standaloneSetup(controller).build(); 와 함께 사용



	//MockMvc는 웹 어플리케이션을 서버에 배포하지 않아도 스프링 MVC동작을
	//구현할 수 있는 가상의 구조를 만들어 줍니다.
	private MockMvc mockMvc;

	@Before    //실행 되기 전에 이거 먼저 돌게끔 하기 위함 
	public void setUp() {
		//가상의 구조를 세팅
		//스프링 컨테이너에 등록된 모든 빈과 의존성 주입까지 전부다 로드해서 사용이 가능  ::컨테이너가 여러개 일 때 전부 테스트 할 때 이거 추천  
		this.mockMvc=MockMvcBuilders.webAppContextSetup(ctx).build();


		//테스트할 컨트롤러를 수동으로 주입. 하나의 컨트롤러만 테스트 진행 할 때 이렇게 씁니다.
		// ---this.mockMvc=MockMvcBuilders.standaloneSetup(controller).build();


	}

	@Test
	public void testList() throws Exception {
		//컨트롤러에 있는 메서드 동작 한 결과가 여기로 넘어옴
		log.info(
				mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
				.andReturn()
				.getModelAndView()
				.getModelMap()

				);
	}

	@Test
	public void testInsert() throws Exception {
		//화면이 없어서 , 파라미터를 같이 보내야 한다.
		String viewPage=mockMvc.perform(MockMvcRequestBuilders.post("/board/write")
				.param("title", "테스트 새 글 제목")
				.param("content","테스트 새 글 내용")	
				.param("writer", "user01")
				).andReturn().getModelAndView().getViewName();

		log.info(viewPage);
	}


	//게시글 상세보기 요청 넣어보기.
	//컨트롤러에서는 DB에서 가지고 온 글 객체를 model에 담아서 jsp로 이동시킬 것입니다.
	//42번글을 보여달라는 요청을 넣으시고, 요청 결과가 들어있는 model을 출력해 보세요.
	// /board/content -> get
	@Test
	public void tesetContent() throws Exception{
		log.info(
				mockMvc.perform(MockMvcRequestBuilders.get("/board/content")
						.param("boardNo", "33"))
				.andReturn()
				.getModelAndView()
				.getModelMap()

				);
	}




	//5번글의 제목과 내용을 수정하는 요청을 보낼 예정입니다.
	//전송방식은 post 방식입니다.
	//수정 후 이동하는 페이지는 해당 글의 상세보기 페이지입니다.
	//컨트롤러가 리턴하는 viewName을 출력해 주세요. ("/board/modify")
	@Test
	public void testModify() throws Exception {

		log.info(
				mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
						//BoardVO변수명이랑 같게 작성
						.param("title", "수정된 게시글 제목")
						.param("content","수정된 게시글  내용")	
						.param("boardNo", "5")
						).andReturn().getModelAndView().getViewName()
				);
	}




	//42번글을 삭제하세요.
	//전송 방식은 post방식이고, 이동하는 곳은 목록 요청이 재요청될 것입니다.
	//viewName을 출력해 주세요.   
	@Test
	public void delete() throws Exception {

		log.info(
				mockMvc.perform(MockMvcRequestBuilders.post("/board/delete")
				.param("boardNo", "42")).andReturn().getModelAndView().getViewName());

	}






}
