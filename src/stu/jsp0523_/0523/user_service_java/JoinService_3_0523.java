package kr.co.jsp.user.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.user.model.UserDAO_10_0516;
import kr.co.jsp.user.model.UserVO_8_0516;

public class JoinService_3_0523 implements IUserService_2_0523 {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		UserDAO_10_0516 dao = UserDAO_10_0516.getInstance();

		response.setContentType("text/html; charset=UTF-8");
		String htmlCode;
		PrintWriter out;

		try {
			out = response.getWriter();
			if (dao.confiemId(id)) {
				htmlCode = "<script>\r\n" + "alert(\"아이디가 중복되었습니다\");\r\n"
						+ "history.back();\r\n" + "</script>";
				out.print(htmlCode);
				out.flush();
				return;
			} else {
				UserVO_8_0516 vo = new UserVO_8_0516(id, request.getParameter("pw"), request.getParameter("name"),
						request.getParameter("email"), request.getParameter("address"));

				dao.insertUser(vo);
				htmlCode = "   <script>\r\n" + "alert(\"회원가입을 환영합니다!\");\r\n"
						+ "location.href='/MyWeb/loginPage.user';\r\n" + "</script>";
				out.print(htmlCode);
				out.flush();
				return;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
