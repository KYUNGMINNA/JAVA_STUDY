package kr.co.jsp.user.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.jsp.user.model.UserDAO_10_0516;
import kr.co.jsp.user.model.UserVO_8_0516;

public class ChangePwService_5_0523 implements IUserService_2_0523 {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String oldpw = request.getParameter("old_pw");
		String newpw = request.getParameter("new_pw");
		HttpSession session = request.getSession();

		UserDAO_10_0516 dao = UserDAO_10_0516.getInstance();

		UserVO_8_0516 vo = (UserVO_8_0516) session.getAttribute("user");

		response.setContentType("text/html; charset=UTF-8");

		String htmlCode;
		PrintWriter out;

		try {
			out = response.getWriter();
			if (dao.userCheck(vo.getId(), oldpw) == 1) {
				dao.changePassword(vo.getId(), newpw);
				htmlCode = "<script>\r\n" + "alert(\"비밀번호가 정상적으로 변경되었습니다.\");\r\n"
						+ "location.href='/MyWeb/myPage.user';\r\n" + "</script> ";
				out.print(htmlCode);
				out.flush();

			} else {
				htmlCode = "String htmlCode = \"<script> \\r\\n\" +\r\n"
						+ "\"alert('현재 비밀번호가 다릅니다.'); \\r\\n\" +\r\n"
						+ "\"history.back(); \\r\\n\" + \"</script>";

				out.print(htmlCode);
				out.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
