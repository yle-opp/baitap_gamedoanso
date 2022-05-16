package gamegussnumber.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gamegussnumber.model.NguoiChoi;

@WebServlet(urlPatterns="/gamepage")
public class GamePage extends HttpServlet{
	NguoiChoi nguoichoi = null; 
	List<NguoiChoi> listnguoichoi = new ArrayList<NguoiChoi>();		
	int dem = 0,  demDuDoanDung = 0;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// get infomation user
		String message="";
		String xephang="";
		String  guessNumber = req.getParameter("numberguess");
		String  exit = req.getParameter("btnexit");
		String  rate = req.getParameter("btnrate");
		
		if(exit != null) {
			// TODO Auto-generated method stub
			
			dem = 0;  
			demDuDoanDung = 0;
			resp.sendRedirect(req.getContextPath() +"/loginpage");// chuyển trang 
			
		}else if(rate  != null) {
			nguoichoi = new NguoiChoi();
			Cookie[] cookies =  req.getCookies();
			for (Cookie cookie : cookies) {
				String name =  cookie.getName();
				String value = cookie.getValue();
				if(name.equals("username")) {
					nguoichoi.setNameuser(value);
				}
				
			}
			
			// kiểm tra  trương hợp user không đoán đúng set nguoichoi.setSolandudoan= dem ngươc lại 
			if(demDuDoanDung > 0 ) {
				
				listnguoichoi.add(nguoichoi);
				// Người  có số lần dự đoán ít nhất là  cho đến khi đoán đúng 
				nguoichoi.setSolandudoan(demDuDoanDung);
				NguoiChoi nguoiXepHangNhat = new NguoiChoi();
				
				nguoiXepHangNhat = listnguoichoi.get(0);
				for (NguoiChoi nguoichoi : listnguoichoi) { 
					if( nguoichoi.getSolandudoan()<nguoiXepHangNhat.getSolandudoan()) {
						nguoiXepHangNhat = nguoichoi;
					}
					
				}
				
				xephang = "Người xếp hạng nhất  ";
				req.setAttribute("xephang", xephang);
				req.setAttribute("tennnguoichoi", nguoiXepHangNhat.getNameuser());
				req.setAttribute("solandudoan", nguoiXepHangNhat.getSolandudoan());
				RequestDispatcher dispatcer = req.getRequestDispatcher("gamepage.jsp");
				dispatcer.forward(req, resp);
			}else {
				nguoichoi.setSolandudoan(dem);
				xephang = "Bạn chưa có lần dự đoán  nào  đúng !! Bạn không thể xếp hạng   ";
				req.setAttribute("xephang", xephang);
				req.setAttribute("tennnguoichoi", nguoichoi.getNameuser());
				req.setAttribute("solandudoan", nguoichoi.getSolandudoan());
				
				
				RequestDispatcher dispatcer = req.getRequestDispatcher("gamepage.jsp");
				dispatcer.forward(req, resp);
			}
			
			
			
		}else {
			
		
		Random Random_number= new Random();
	    int random=Random_number.nextInt(1000);
	    random = 8;
	    dem ++;
	    
		if(Integer.parseInt(guessNumber) == random) {
			message = "Bạn đã đoán đúng ";
			demDuDoanDung = dem; // khi user đoán đung thì set lại số lần
		}else if(Integer.parseInt(guessNumber) > random ){
			message="Bạn đã đoán số cao  hơn số dự đoán đúng " + guessNumber ; 
			
		} else if(Integer.parseInt(guessNumber) < random){
			message="Bạn đã đoán số thấp  hơn số dự đoán đúng  " + guessNumber; 
			
		}
		req.setAttribute("message", message);
		RequestDispatcher dispatcer = req.getRequestDispatcher("gamepage.jsp");
		dispatcer.forward(req, resp);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher dispatcer = req.getRequestDispatcher("gamepage.jsp");
		dispatcer.forward(req, resp);
		
		
//		
	}
	

}
