package kr.co.jsp.user.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.jsp.user.model.UserDAO_10_0516;
import kr.co.jsp.user.model.UserVO_8_0516;

public class LoginService_4_0523 implements IUserService_2_0523 {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		UserDAO_10_0516 dao = UserDAO_10_0516.getInstance();

		response.setContentType("text/html; charset=UTF-8");
		String htmlCode;
		int result = dao.userCheck(id, pw);

		try {
			PrintWriter out = response.getWriter();
			if (result == -1) {
				htmlCode = "<script> \r\n" + "alert('아이디가 없습니다.'); \r\n" + "location.href='/MyWeb/loginPage.user'; \r\n"
						+ "</script>";
				out.print(htmlCode);
				out.flush();
			} else if (result == 0) {
				htmlCode = "<script> \r\n" + "alert('비밀번호가 틀렸습니다.'); \r\n" + "history.back(); \r\n" + "</script>";
				out.print(htmlCode);
				out.flush();

			} else {
				UserVO_8_0516 vo = dao.getUserInfo(id);
				request.getSession().setAttribute("user", vo);
				response.sendRedirect("/MyWeb/myPage.user");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
