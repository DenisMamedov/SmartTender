package com.tender.command;

import com.tender.entity.Offer;
import com.tender.entity.Supplier;
import com.tender.entity.TenderSpecification;
import com.tender.service.ServiceManager;
import com.tender.service.TenderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by Денис on 12.01.2017.
 */
public class CommandViewTender implements ICommand {

    private static CommandViewTender instance = null;

    public static synchronized CommandViewTender getInstance() {
        if (instance == null) {
            instance = new CommandViewTender();
        }
        return instance;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String page = null;

        TenderService service = (TenderService) ServiceManager.getService(TenderService.class);
        int tenderId = Integer.parseInt(request.getParameter("id"));

        HttpSession session = request.getSession();
        session.setAttribute("tender_id", tenderId);
        LinkedList<TenderSpecification> tenderSpec = service.showTenderDetails(tenderId);
        Map<Integer, Double> bestPrice = service.getBestPrices(tenderId);

        String tenderName = tenderSpec.getFirst().getTender().getTenderName();
        request.setAttribute("tenderName", tenderName);
        request.setAttribute("tenderSpec", tenderSpec);
        request.setAttribute("bestPrice", bestPrice);
        page = "WEB-INF/viewTender.jsp";

        Map<Integer, Offer> offers = service.showTenderDetailsFromHistory(tenderId, (Supplier)session.getAttribute("user"));
        //if (!offers.isEmpty())
        request.setAttribute("offer", offers);

        if (request.getParameter("isHistory")!=null){

            page = "WEB-INF/viewHistoryTender.jsp";
        }

        return page;
    }
}
