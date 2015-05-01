package com.javalec.ex.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("*.do")
public class BFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BFrontController() {
        super(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("actionDo");
		
		String viewPage = null;
	//	BCommand command = null;
		
		String uri = request.getRequestURI();			
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		if (com.equals("/insert.do")){
			System.out.println("insert");
			System.out.println("--------------");
		}
		else if (com.equals("/update.do")){
			System.out.println("update");
			System.out.println("--------------");
		}
		else if (com.equals("/select.do")){
			System.out.println("select");
			System.out.println("--------------");
		}
		else if (com.equals("/delete.do")){
			System.out.println("delete");
			System.out.println("--------------");
		} 		
		viewPage = "list.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);		
	}
}
