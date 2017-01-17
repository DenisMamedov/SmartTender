package com.tender.command;

import com.tender.dao.impl.StatusEnum;
import com.tender.entity.Supplier;
import com.tender.entity.Tender;
import com.tender.service.ServiceManager;
import com.tender.service.TenderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by Денис on 14.01.2017.
 */
public class CommandShowHistory implements ICommand{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String page = "WEB-INF/tenders.jsp";

        HttpSession session = request.getSession();
        TenderService tenderService = (TenderService) ServiceManager.getService(TenderService.class);
        LinkedList<Tender> tenders = tenderService.getHistory((Supplier)session.getAttribute("user"), StatusEnum.ENDED.getValue());

        request.setAttribute("command", "/history");
        request.setAttribute("tenders", tenders);
        return page;
    }
}
