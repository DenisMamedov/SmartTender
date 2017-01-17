package com.tender.command;

import com.tender.entity.Tender;
import com.tender.service.ServiceManager;
import com.tender.service.TenderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by Денис on 12.01.2017.
 */
public class CommandTender implements ICommand {

    private static CommandTender instance = null;

    public static synchronized CommandTender getInstance() {
        if (instance == null) {
            instance = new CommandTender();
        }
        return instance;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String page = "WEB-INF/tenders.jsp";

        TenderService tenderService = (TenderService) ServiceManager.getService(TenderService.class);
        LinkedList<Tender> tenders = tenderService.showTenders();
        Set<String> allCompany = tenderService.getAllCompany(tenders);
        Set<String> allCategory = tenderService.getAllCategory(tenders);
        LinkedList<Tender> tendersSearch = tenders;
        String method = request.getMethod();

        if (method.equalsIgnoreCase("POST") && request.getParameter("search") != null) {

            String context = request.getParameter("context");
            String company = request.getParameter("company");
            String category = request.getParameter("category");
            if (!context.isEmpty())
                tenders = tenderService.searchTenderByContext(context);

           if (!company.isEmpty())
                tenders = tenderService.searchTenderByCompanyName(company, tenders);

           if (!category.isEmpty())
                tenders = tenderService.searchTenderByCategoryName(category, tenders);

        }
        request.setAttribute("command", "/");
        request.setAttribute("tenders", tenders);
        request.setAttribute("companyNames", allCompany);
        request.setAttribute("categoryNames", allCategory);

        return page;
    }
}
