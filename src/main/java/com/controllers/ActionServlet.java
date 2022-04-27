package com.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/action")
public class ActionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path ="/index.jsp";
        switch (req.getParameter("input")){
            case "1":
                path="/input_id.jsp";
                break;
            case "2":
                path="/input_name.jsp";
                break;
            case "3":
                path="/input_two_parm.jsp";
                break;
        }
        req.getRequestDispatcher(path).forward(req, resp);
    }
}
