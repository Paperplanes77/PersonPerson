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
import javax.websocket.Session;



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
		if ("张三".equals(name)&&"1234".equals(pwd)) {//注意，本例如果，用户名和密码就是“为输入”，则也不会设定会话！
			HttpSession hs = request.getSession();
			hs.setAttribute("userid", name);
			/*ServletContext context=getServletContext();
			RequestDispatcher rd=context.getRequestDispatcher("/login/LoginSuccess.html");
			rd.forward(request, response);*/
			response.sendRedirect("../listener/list.jsp");
			
		}/*else if(!name.equals("未输入") && !pwd.equals("未输入")&&!"张三".equals(name)&&!"1234".equals(pwd)){
			HttpSession hs = request.getSession();
			hs.setAttribute("userid", name);
			String userid=request.getParameter("userid");
			if(!(userid==null||"".equals(userid))){
				response.sendRedirect("../listener/list.jsp");
			}}*/
		else if (name.equals("未输入") && !pwd.equals("未输入")) {
			System.out.println("不好意思 你怎么不输入账户!");
		}else if (!name.equals("未输入") &&pwd.equals("未输入")){
			System.out.println("不好意思 你怎么不输入密码!");
		} else{
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
