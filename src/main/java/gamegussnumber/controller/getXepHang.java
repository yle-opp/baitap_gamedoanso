package gamegussnumber.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/xephang")
public class getXepHang extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie[] cookies =  req.getCookies();
		for (Cookie cookie : cookies) {
			String name =  cookie.getName();
			String value = cookie.getValue();
			
			System.out.println("Kiem tra cookie :" + name +" _ " + value);
		}
		resp.getWriter().append("<h1>Get cookie: <h1>");
		
	}
}
