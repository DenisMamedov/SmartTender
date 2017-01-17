package com.tender.command;

import com.tender.entity.Supplier;
import com.tender.entity.builder.SupplierBuilder;
import com.tender.main.Message;
import com.tender.service.ServiceManager;
import com.tender.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Денис on 11.01.2017.
 */
public class CommandRegistration implements ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String page = null;
        String method = request.getMethod();
        if (method.equalsIgnoreCase("GET"))
            page = "/WEB-INF/registration.jsp";
        if (method.equalsIgnoreCase("POST")) {
            HttpSession session = request.getSession();

            String supplierName = request.getParameter("supplier_name");
            session.setAttribute("supplierName", supplierName);

            String okpo = request.getParameter("okpo");
            session.setAttribute("okpo", okpo);

            String address = request.getParameter("address");
            session.setAttribute("address", address);

            String contactName = request.getParameter("contact_name");
            session.setAttribute("contactName", contactName);

            String contactPhone = request.getParameter("contact_phone");
            session.setAttribute("contactPhone", contactPhone);

            String email = request.getParameter("email");
            session.setAttribute("email", email);

            String password = request.getParameter("password");
            String passwordConfirm = request.getParameter("passwordConfirm");

            if (!password.equals(passwordConfirm)) {
                Message.setFlash("Пароли не совпадают! Попробуйте еще раз.");
                return "/WEB-INF/registration.jsp";
            }

            if (supplierName != null && okpo != null && address != null & contactName != null
                    && contactPhone != null && email != null && password != null) {
                Supplier supplier = new SupplierBuilder()
                        .setSupplierName(supplierName)
                        .setOkpo(new Integer(okpo))
                        .setAddress(address)
                        .setContactName(contactName)
                        .setContactPhone(contactPhone)
                        .setEmail(email)
                        .setPassword(password)
                        .createSupplier();
                UserService supplierService = (UserService) ServiceManager.getService(UserService.class);
                int id = supplierService.registration(supplier);
                if (id != 0) return "/WEB-INF/login.jsp";
            }

            page = "/WEB-INF/registration.jsp";
        }

        return page;
    }
}
