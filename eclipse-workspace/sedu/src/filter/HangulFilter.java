package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class HangulFilter implements Filter {


	public void destroy() {
		
	}
	
	//detroy, init은 interface 상속이므로 남겨놔야 함.

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("HangulFilter 수행 - BEFORE");
		if(((HttpServletRequest)request).getMethod().equals("POST")) {
			//getMethod 는 HttpServletRequest 에서 추가된 메서드라 강제 형변환을 해줘야 한다.
			request.setCharacterEncoding("UTF-8");
		}
		chain.doFilter(request, response);
		System.out.println("HangulFilter 수행 - AFTER");
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
