package gamegussnumber.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gamegussnumber.common.Const;

@WebServlet("/loginpage")
public class LoginPage extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/loginpage.jsp").forward(req, resp);
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nameuser = req.getParameter("nameuser");
		Cookie cookie = new Cookie(Const.sessionlogin,nameuser);
		cookie.setMaxAge(1800); // Đặt thời gian sống
		resp.addCookie(cookie); // Gửi cookie vào Http Reponse
		resp.sendRedirect(req.getContextPath() +"/gamepage.jsp");// chuyển trang 
		
	}
}
