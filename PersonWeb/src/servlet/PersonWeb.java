package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PersonWeb
 */
@WebServlet("/servlet/PersonWeb")
public class PersonWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonWeb() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("username");
		String pwd=request.getParameter("password");
		if (name == null || name == "")
			name = "未输入";
		if (pwd == null || pwd == "")
			pwd = "未输入";
		if (!name.equals("未输入") && !pwd.equals("未输入")) {//注意，本例如果，用户名和密码就是“为输入”，则也不会设定会话！
			HttpSession hs = request.getSession();
			hs.setAttribute("userid", name);
		}else if ("zhangsan".equals(name)&&"1234".equals(pwd)) {
			ServletContext context=getServletContext();
			RequestDispatcher rd=context.getRequestDispatcher("/login/LoginSuccess.html");
			rd.forward(request, response);
		}else{
			/*RequestDispatcher rd=request.getRequestDispatcher("/servlet/MyLoginServletDemo");
			rd.include(request, response);*/
			ServletContext context=getServletContext();
			RequestDispatcher rd=context.getRequestDispatcher("/login/LoginFailed.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
