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

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        if (idStr == null || idStr.isEmpty()) {
            HttpSession session = req.getSession();
            session.setAttribute("fmsg", "Invalid TODO item ID.");
            resp.sendRedirect("index.jsp");
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            HttpSession session = req.getSession();
            session.setAttribute("fmsg", "Invalid TODO item ID.");
            resp.sendRedirect("index.jsp");
            return;
        }

        TodoDao todoDao = new TodoDao(SqlUtil.getConnection());
        boolean isDeleted = todoDao.deleteTodo(id);

        HttpSession session = req.getSession();

        if (isDeleted) {
            session.setAttribute("smsg", "Todo deleted successfully");
        } else {
            session.setAttribute("fmsg", "Failed to delete TODO item.");
        }
        resp.sendRedirect("index.jsp");
    }
}
