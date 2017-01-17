package com.tender.servlet;


import com.tender.entity.Tender;
import com.tender.service.ServiceManager;
import com.tender.service.TenderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by Денис on 05.01.2017.
 */
public class TenderServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        TenderService tenderService = (TenderService) ServiceManager.getService(TenderService.class);
        LinkedList<Tender> tenders = tenderService.showTenders();
        request.setAttribute("tenders", tenders);
        request.getRequestDispatcher("WEB-INF/tenders.jsp").forward(
                request, response);
    }

}
