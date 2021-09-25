package Controller;

import java.io.IOException;  
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.porderDao;
import Model.porder;

/**
 * Servlet implementation class addOrderController
 */
public class addOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addOrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. 取得 porder 訂單 --> session
		 * 2. 新增到資料庫
		 * 3. 切換到 finish
		 */
		HttpSession session = request.getSession();
		porder p =  (porder)session.getAttribute("P");
		new porderDao().add(p);
		response.sendRedirect("porder/finish.jsp");
		
	}
}
