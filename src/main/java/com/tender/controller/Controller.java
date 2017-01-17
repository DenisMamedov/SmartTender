package com.tender.controller;

import com.tender.command.ICommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Денис on 11.01.2017.
 */
public class Controller extends HttpServlet {

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ICommand command = ControllerHelper.getInstance().getCommand(request);
        String path = command.execute(request, response);
        request.getRequestDispatcher(path).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }
}
