package com.tender.servlet;

import com.tender.entity.Supplier;
import com.tender.service.LoginService;
import com.tender.service.ServiceManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Денис on 06.01.2017.
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/login.jsp").forward(
                request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        LoginService loginService = (LoginService) ServiceManager.getService(LoginService.class);
        Supplier supplier = loginService.login(email, password);
        if (supplier == null){
            response.sendRedirect("/login");
        }

        HttpSession session = request.getSession();
        session.setAttribute("user", supplier);

        response.sendRedirect("/");
}

    @Override
    public void init() throws ServletException {

    }
}
