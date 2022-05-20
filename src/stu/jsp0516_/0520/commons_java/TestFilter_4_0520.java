package kr.co.jsp.board.commons;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


//컨트롤러 앞에 필터가 있어 , 모든 요청이 필터를 거치고 나서 컨트롤러로 전달한다.

@WebFilter("/*")  // 모든 요청에 다 반응을 하는 필터
public class TestFilter_4_0520 implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("필터 동작!");
		
		chain.doFilter(request, response);
		
	}

}
