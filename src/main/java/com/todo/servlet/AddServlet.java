package com.todo.servlet;

import java.io.IOException;

import com.todo.dao.TodoDao;
import com.todo.utility.SqlUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/add_todo")
public class AddServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nameString = req.getParameter("name");
		String descString = req.getParameter("description");
		String statuString = req.getParameter("status");
		System.out.println(nameString+" "+descString+" "+statuString);
		
		TodoDao dao = new TodoDao(SqlUtil.getConnection());
		boolean f = dao.addTodo(nameString, descString, statuString);
		
		HttpSession session = req.getSession();
		
		if(f) {
			session.setAttribute("smsg", "Todo added successfully");
			resp.sendRedirect("index.jsp");
		}else {
			session.setAttribute("smsg", "Todo not added ");
			resp.sendRedirect("add_todo.jsp");
		}
	}
}
