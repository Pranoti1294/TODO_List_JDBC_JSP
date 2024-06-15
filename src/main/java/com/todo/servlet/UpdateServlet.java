package com.todo.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.todo.dao.TodoDao;
import com.todo.module.Todo;
import com.todo.utility.SqlUtil;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String status = request.getParameter("status");

        Todo todo = new Todo();
        todo.setId(id);
        todo.setTodoname(name);
        todo.setTododescription(description);
        todo.setStatus(status);

        TodoDao todoDao = new TodoDao(SqlUtil.getConnection());
        boolean isUpdated = todoDao.updateTodo(todo);

        HttpSession session = request.getSession();

        if (isUpdated) {
            session.setAttribute("smsg", "Todo updated successfully");
            response.sendRedirect("index.jsp"); 
        } else {
            session.setAttribute("fmsg", "Failed to update TODO item.");
            response.sendRedirect("index.jsp"); 
        }
    }
}
