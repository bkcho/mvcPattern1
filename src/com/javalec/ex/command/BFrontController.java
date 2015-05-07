package com.javalec.ex.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.BCommand;
import command.BContentCommand;
import command.BDeleteCommand;
import command.BListCommand;
import command.BModifyCommand;
import command.BReplayViewComand;
import command.BReplyCommand;
import command.BWriteCommand;
 
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
 
		String viewPage = null;
		BCommand command = null;
		
		String uri = request.getRequestURI();			
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		if (com.equals("/write_view.do")){
			viewPage = "write_view.jsp";
		}
		else if (com.equals("/write.do")){		
			command = new BWriteCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}
		else if (com.equals("/list.do")){
			command = new BListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
		}
		else if (com.equals("/content_view.do")){
			command = new BContentCommand();
			command.execute(request, response);
			viewPage = "content_view.jsp";
		}
		else if (com.equals("/modify.do")){
			command = new BModifyCommand();
			command.execute(request, response);
			viewPage = "list.do";
		} 		
		else if (com.equals("/delete.do")){
			command = new BDeleteCommand();
			command.execute(request, response);
			viewPage = "list.do";
		} 		
		else if (com.equals("/reply_view.do")){		
			command = new BReplayViewComand();
			command.execute(request, response);
			viewPage = "reply_view.jsp";
		} 		
		else if (com.equals("/reply.do")){
			command = new BReplyCommand();
			command.execute(request, response);
			viewPage = "list.do";
		} 
	 		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);		
	}
}
