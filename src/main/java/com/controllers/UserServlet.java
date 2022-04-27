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
//@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path=null;
        try {
            if (req.getParameter("insertButton") != null) {
                path ="/input_name.jsp";
                req.setAttribute("text",
                        userService.insert(req.getParameter("userName")));
            } else if (req.getParameter("deleteButton") != null) {
                path ="/input_id.jsp";
                req.setAttribute("text",
                        userService.delete(Long.parseLong(req.getParameter("userId"))));
            } else if (req.getParameter("selectButton") != null) {
                path ="/input_id.jsp";
                req.setAttribute("text",
                        userService.getUser(Long.parseLong(req.getParameter("userId"))));
            } else if (req.getParameter("updateButton") != null) {
                path ="/input_two_parm.jsp";
                req.setAttribute("text",
                        userService.update(Long.parseLong(req.getParameter("userId")), req.getParameter("userName")));
            }
            else if (req.getParameter("home") != null) {
                path ="/index.jsp";
            }
        } catch (Exception e) {
            req.setAttribute("text", "error");
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);
    }
}
