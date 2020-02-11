package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/firstone")
//이 클래스는 firstone이 호출될 때 사용되는 filter 클래스임을 알리는 구문
// * 를 쓰면 이 서버에 있는 모든 servlet에 대해
public class FlowFilter implements Filter {


    public FlowFilter() {
    	System.out.println("FlowFilter 객체 생성");
    }


	public void destroy() {
		System.out.println("FlowFilter 객체 삭제");
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("FlowFilter 수행 전...");
		chain.doFilter(request, response);
		System.out.println("FlowFilter 수행 후...");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("FlowFilter 객체 초기화");
	}

}
