package gamegussnumber.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/gamepage")
public class GamePage extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// get infomation user
		String message="Hãy nhập vào số dự đoán của bạn";
		String  guessNumber = req.getParameter("numberguess");
		int dem =0;
		// cover string to int 
		int demMay = 0, demNguoichoi = 0;
		Random Random_number= new Random();
	    int random=Random_number.nextInt(1000);
	    demNguoichoi ++;
		if(Integer.parseInt(guessNumber) == random) {
			message = "Bạn đã đoán đúng ";
			
		}else if(Integer.parseInt(guessNumber) > random ){
			message="Bạn đã đoán số cao  hơn số dự đoán đúng " + guessNumber ; 
			
		} else if(Integer.parseInt(guessNumber) < random){
			message="Bạn đã đoán số thấp  hơn số dự đoán đúng  " + guessNumber; 
			
		}
		
		req.setAttribute("message", message);
		RequestDispatcher dispatcer = req.getRequestDispatcher("gamepage.jsp");
		dispatcer.forward(req, resp);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher dispatcer = req.getRequestDispatcher("gamepage.jsp");
		dispatcer.forward(req, resp);
//		
	}
	
}
