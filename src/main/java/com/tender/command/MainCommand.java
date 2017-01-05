package com.tender.command;

import com.tender.service.TenderService;
import com.tender.servlet.ControllerHelper;

import java.util.LinkedList;

/**
 * Created by Денис on 05.01.2017.
 */
public class MainCommand extends ActionCommand {
    @Override
    public String execute(ControllerHelper controllerHelper) {
        String page = null;
        LinkedList tenders;
        TenderService tenderService= new TenderService();

        tenders = tenderService.showTenders();
        controllerHelper.setAttribute("tenders", tenders);
        controllerHelper.setSessionAttribute("tenders", tenders);
        page = "/jsp/main.jsp";
        return page;
    }
}
