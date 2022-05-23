package kr.co.jsp.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.user.service.ChangePwService_5_0523;
import kr.co.jsp.user.service.DeleteService_7_0523;
import kr.co.jsp.user.service.IUserService_2_0523;
import kr.co.jsp.user.service.JoinService_3_0523;
import kr.co.jsp.user.service.LoginService_4_0523;
import kr.co.jsp.user.service.UpdateService_6_0523;

@WebServlet("*.user")
public class UserController_1_0523 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RequestDispatcher dp;
	private IUserService_2_0523 sv;

	public UserController_1_0523() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doRequest(request, response);
	}

	protected void doRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();

		uri = uri.substring(request.getContextPath().length() + 1, uri.lastIndexOf("."));

		System.out.println(uri);

		switch (uri) {

		case "joinPage":
			System.out.println("회원 가입 페이지로 이동 요청!");
			response.sendRedirect("user/3_user_join_0516.jsp");
			break;
		case "join":
			System.out.println("회원가입 요청!");
			sv = new JoinService_3_0523();
			sv.execute(request, response);
			break;

		case "loginPage":
			System.out.println("로그인 페이지로 이동 요청!");
			response.sendRedirect("user/5_user_login_0516.jsp");
			break;
		case "login":
			System.out.println("로그인 요청!");
			sv = new LoginService_4_0523();
			sv.execute(request, response);
			break;
			
		case "myPage":
			System.out.println("마이페이지로 이동 요청!");
			response.sendRedirect("user/7_user_mypage_0516.jsp");
			break;

		case "pwPage":
			System.out.println("비밀번호 변경 페이지로 이동 요청!");
			response.sendRedirect("user/1_user_change_pw_0517.jsp");
			break;
		case "changePw":
			System.out.println("비밀번호 변경 요청!");
			sv = new ChangePwService_5_0523();
			sv.execute(request, response);
			break;
			
		case "modPage":
			System.out.println("회원 정보 변경 페이지로 이동 요청");
			response.sendRedirect("user/3_user_update_0517.jsp");
			break;
		case "update":
			System.out.println("회원 정보 수정 요청이 들어옴!");
			sv = new UpdateService_6_0523();
			sv.execute(request, response);
			break;
			
		case "delPage":
			System.out.println("회원 탈퇴 페이지로 이동 요청!");
			response.sendRedirect("user/6_user_delete_0517.jsp");
			break;
		case "delete":
			System.out.println("회원 탈퇴 요청!");
			sv = new DeleteService_7_0523();
			sv.execute(request, response);
			break;
			
			

		}
	}

}
