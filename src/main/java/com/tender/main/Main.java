package com.tender.main;


import com.tender.entity.Tender;
import com.tender.service.ServiceManager;
import com.tender.service.TenderService;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {



        TenderService tenderService = (TenderService) ServiceManager.getService(TenderService.class);
        LinkedList<Tender> tenders = tenderService.showTenders();

        for (Tender tender : tenders){
            System.out.println(tender);
        }




}
}
