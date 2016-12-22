package filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginCheckFilter
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
					, description = "登录检查过滤", urlPatterns = { "/listener/*","/login/*"})
public class LoginCheckFilter implements Filter {

    /**
     * Default constructor.  
     */
    public LoginCheckFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("登录验证gg了!");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("hello world!");
		// pass the request along the filter chain
		HttpServletRequest ht=(HttpServletRequest)request;
		HttpSession hs=ht.getSession();
		String userid=(String)hs.getAttribute("userid");
		if ("".equals(userid)||userid==null) {
			System.out.println("不好意思,你被拦截");
			HttpServletResponse hsr=(HttpServletResponse)response;
			hsr.sendRedirect("../LoginTest.jsp");
			//一种页面跳转
			//hsr.sendRedirect("../LoginTest.jsp");
			/*hsr.sendRedirect("/PersonWeb/filter/unlogin.jsp");*/
			//页面定时跳转
			/*hsr.setHeader("refresh","4;URL=/login/LoginSuccess.html");*/
		}else{
			System.out.println("成功了,请放行吧!");
			//((HttpServletResponse) response).sendRedirect("../listener/list.jsp");
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("登录验证开始了,朋友!");
	}

}
