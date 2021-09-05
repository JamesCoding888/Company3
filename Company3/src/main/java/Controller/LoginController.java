package Controller;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Dao.memberDao;
import Model.member;

/**
 * Servlet implementation class loginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. request 鳩收帳號密碼
		 * 2. memberDao.queryUser(帳號, 密碼)-->物件 或 null
		 * 3. 有-->物件session-->登入成功頁 (loginSuccess.jsp)
		 * 4. null-->loginError.jsp
		 */
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		member m = memberDao.queryUser(username, password);
		if(m!=null) {
			session.setAttribute("M", m);
			response.sendRedirect("member/loginSuccess.jsp");
		}
		else {
			response.sendRedirect("member/loginError.jsp");
		}
	}
}
