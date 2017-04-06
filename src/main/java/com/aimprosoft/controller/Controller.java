package com.aimprosoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@org.springframework.stereotype.Controller("controller")
public class Controller implements HttpRequestHandler {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getServletPath();
        InternalController mainController = (InternalController) applicationContext.getBean(url);

        try {
            mainController.execute(req, resp);
        } catch (SQLException e) {
            req.setAttribute("sqlError", e.getMessage());
            resp.sendRedirect("WEB-INF/jsp/sqlException.jsp");
        }
    }
}
