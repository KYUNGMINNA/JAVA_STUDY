package kr.co.jsp.servlet.basic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//FronController_7_0518에서 *.do(확장자 패턴의 매핑)로 

@WebServlet("*.do")
public class FrontController_7_0518 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController_7_0518() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 메서드 호출!");
		System.out.println("요청 URI :"+request.getRequestURI());
		
		String uri=request.getRequestURI();
		String conPath=request.getContextPath(); // /MyWeb 을 리턴 해줌
		
		uri=uri.substring(conPath.length()+1, uri.lastIndexOf("."));
		System.out.println("정제된 uri:"+uri);
		
		if(uri.equals("write")) {
			System.out.println("글 작성 요청이 들어옴!");
		}else if(uri.equals("list")) {
			System.out.println("글 목록 요청이 들어옴!");
		}
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
