package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAO;
import servlet.model.MemberVO;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String name = request.getParameter("name");
	int age = request.getParameter("age")!=null ?Integer.parseInt(request.getParameter("age")) : 0 ;
	String addr = request.getParameter("addr");
	
	MemberVO vo = new MemberVO(name, age, addr);
	
	MemberDAO dao = new MemberDAO();
	try {
		dao.insertMember(vo);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	} catch (SQLException e) {}
	
	response.sendRedirect("view2");
	}
	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
