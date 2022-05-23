package kr.co.jsp.user.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.jsp.user.model.UserDAO_10_0516;
import kr.co.jsp.user.model.UserVO_8_0516;

public class UpdateService_6_0523 implements IUserService_2_0523 {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");

		UserVO_8_0516 vo = new UserVO_8_0516();
		vo.setId(id);
		vo.setName(name);
		vo.setEmail(email);
		vo.setAddress(address);

		UserDAO_10_0516 dao = UserDAO_10_0516.getInstance();
		dao.updateUser(vo);
		session.setAttribute("user", dao.getUserInfo(vo.getId()));
		
		response.setContentType("text/html; charset=UTF-8");

		try {
			String htmlCode;
			PrintWriter out = response.getWriter();
			htmlCode = "	<script>\r\n" + "    	alert(\"회원 정보가 수정되었습니다.\");\r\n"
					+ "    	location.href='/MyWeb/myPage.user';\r\n" + "</script>";
			out.print(htmlCode);
			out.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
