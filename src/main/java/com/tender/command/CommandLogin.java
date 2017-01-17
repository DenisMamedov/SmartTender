package com.tender.command;

import com.tender.entity.Supplier;
import com.tender.main.Message;
import com.tender.service.LoginService;
import com.tender.service.ServiceManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Денис on 12.01.2017.
 */
public class CommandLogin implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;

        final String email = request.getParameter("email");
        final String password = request.getParameter("password");
        String method = request.getMethod();
        if (method.equalsIgnoreCase("GET"))
            page = "/WEB-INF/login.jsp";
        if (method.equalsIgnoreCase("POST")) {
            HttpSession session = request.getSession();
            LoginService loginService = (LoginService) ServiceManager.getService(LoginService.class);
            Supplier supplier = loginService.login(email, password);
            if (supplier == null) {
                Message.setFlash("Неверные данные для входа!");
                page = "/WEB-INF/login.jsp";
            } else {
                session.setAttribute("user", supplier);
                Message.setFlash("Вы вошли как " + supplier.getSupplierName() + "!");
                page = CommandTender.getInstance().execute(request, response);
            }
        }
        return page;
    }
}
