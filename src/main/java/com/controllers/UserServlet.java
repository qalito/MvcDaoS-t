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
        if (req.getParameter("insertButton") != null) {
            userService.insert(req.getParameter("input"));
        } else if (req.getParameter("deleteButton") != null) {
            userService.delete(Long.parseLong(req.getParameter("input")));
        } else if (req.getParameter("selectButton") != null) {
            req.setAttribute("user", userService.getUser(Long.parseLong(req.getParameter("input"))));
        } else if (req.getParameter("updateButton") != null) {

        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req, resp);
    }
}
