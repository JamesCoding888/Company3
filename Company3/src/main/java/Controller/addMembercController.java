package Controller;
import java.io.IOException;  
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.memberDao;
import Model.member;
/**
 * Servlet implementation class addMembercController
 */
public class addMembercController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public addMembercController() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. 判斷帳號重複
		 * 2. 重複   --> addMemberError
		 * 3. 不重複  --> add(Object o) --> addMemberSuccess
		 * 
		 */
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		
		if(memberDao.queryUser(username) == null) {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
			String mobile = request.getParameter("mobile");
			
			member p = new member(name, username, password, address, phone, mobile);
			new memberDao().add(p);
			response.sendRedirect("member/addMemberSuccess.jsp");
		} else {
			response.sendRedirect("member/addMemberError.jsp");
		}		
	}
}
