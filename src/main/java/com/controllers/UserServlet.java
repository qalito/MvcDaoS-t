package com.controllers;

import com.service.UserService;
import com.service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (req.getParameter("insertButton") != null) {
                req.setAttribute("text",
                        userService.insert(req.getParameter("userName")));
            } else if (req.getParameter("deleteButton") != null) {
                req.setAttribute("text",
                        userService.delete(Long.parseLong(req.getParameter("userId"))));
            } else if (req.getParameter("selectButton") != null) {
                req.setAttribute("text",
                        userService.getUser(Long.parseLong(req.getParameter("userId"))));
            } else if (req.getParameter("updateButton") != null) {
                req.setAttribute("text",
                        userService.update(Long.parseLong(req.getParameter("userId")), req.getParameter("userName")));
            }
        } catch (Exception e) {
            req.setAttribute("text", "error");
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req, resp);
    }
}
