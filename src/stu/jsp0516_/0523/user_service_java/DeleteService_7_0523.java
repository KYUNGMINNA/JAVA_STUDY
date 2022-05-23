package kr.co.jsp.user.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.jsp.user.model.UserDAO_10_0516;
import kr.co.jsp.user.model.UserVO_8_0516;

public class DeleteService_7_0523 implements IUserService_2_0523 {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		String checkpw = request.getParameter("check_pw");

		UserDAO_10_0516 dao = UserDAO_10_0516.getInstance();
		UserVO_8_0516 vo = (UserVO_8_0516) session.getAttribute("user");

		String id = vo.getId();
		
		response.setContentType("text/html; charset=UTF-8");
		String htmlCode;
		PrintWriter out;

		try {
			out = response.getWriter();

			if (dao.userCheck(id, checkpw) == 1) {
				dao.deleteUser(id);
				session.invalidate();
				htmlCode = "<script> \r\n" + "alert('비밀번호가 일치하지 않습니다..'); \r\n" + "history.back(); \r\n" + "</script>";
				out.print(htmlCode);
				out.flush();
			} else {
				htmlCode = "<script>\r\n" + "		alert(\"비밀번호가 일치하지 않습니다. \");\r\n"
						+ "		//location.href='/MyWeb/myPage.user'; -- 강사 버전\r\n" + "		history.back();\r\n"
						+ "		</script>    ";
				out.print(htmlCode);
				out.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
