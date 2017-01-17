package com.tender.main;


import com.tender.connection.ConnectionPool;
import com.tender.entity.Supplier;
import com.tender.entity.Tender;
import com.tender.entity.builder.SupplierBuilder;
import com.tender.service.ServiceManager;
import com.tender.service.TenderService;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {

    public static void main(String[] args) {



//        TenderService tenderService = (TenderService) ServiceManager.getService(TenderService.class);
//        LinkedList<Tender> tenders = tenderService.showTenders();
        ConnectionPool connectionPoll = ConnectionPool.getInstance();
        //Connection connection = connectionPoll.getConnection();
        TenderService service = (TenderService) ServiceManager.getService(TenderService.class);
        LinkedList<Tender> alltenders = service.showTenders();
        LinkedList<Tender> tenders = service.searchTenderByCompanyName("Азовсталь", alltenders);
       // LinkedList<Tender> tenders = service.searchTenderByCategoryName("Измерительные приборы", alltenders);
//        for (Tender tender : tenders) {
//            System.out.println(tender);
//        }
        Supplier supplier = new SupplierBuilder()
                .setSupplierName("Test3")
                .setAddress("Test3")
                .setContactName("Test3")
                .setContactPhone("123456789")
                .setEmail("test3@test.com")
                .setPassword("test3").createSupplier();
        supplier.setId(1);
        //ArrayList<Offer> offers = service.showTenderDetailsFromHistory(44, supplier);
        //System.out.println(offers);
        Map<Integer, Supplier> map = new HashMap<>();
        map.put(1, supplier);
        System.out.println(map.get(1).getOkpo());
//        Map<Integer, Double> bestPrice = service.getBestPrices(44);
//        System.out.println(bestPrice.get(1));
//        LoginService loginService = (LoginService) ServiceManager.getService(LoginService.class);
//        Supplier supplier = loginService.login("dd02@ukrteh.kiev.ua", "xeov2p");
        //System.out.println();
//        //SupplierDAO supplierDAO = new MySqlDAOFactory(connection).getSupplierDAO();
//        ArrayList<Offer> offers = service.showTenderDetailsFromHistory(44, supplier);
//        for (Offer offer : offers){
//            System.out.println(offer);

//            OfferDAO offerDAO = new MySqlDAOFactory(connection).getOfferDAO();
//        ArrayList<Offer> offers = offerDAO.selectOfferByTenderIdAndSupplierId(44, 15);
//        for (Offer offer : offers){
//           System.out.println(offer);
        //        TenderDAO tenderDAO = new MySqlDAOFactory(connection).getTenderDAO();
//        for (Tender tender : tenderDAO.selectTenderBySupplierId(1)){
//            System.out.println(tender);
       // };
       // TenderDAO tenderDAO = new MySqlDAOFactory(connection).getTenderDAO();
//                TenderService tenderService = (TenderService) ServiceManager.getService(TenderService.class);
//        LinkedList<Tender> tenders = tenderService.showTenders();
//        for (Tender tender : tenders){
//            System.out.println(tender);
//        };

//        SupplierDAO supplierDAO = new MySqlDAOFactory(connection).getSupplierDAO();
//        Supplier supplier = new SupplierBuilder()
//                .setSupplierName("Test3")
//                .setOkpo(5555555)
//                .setAddress("Test3")
//                .setContactName("Test3")
//                .setContactPhone("123456789")
//                .setEmail("test3@test.com")
//                .setPassword("test3").createSupplier();
//        for(TenderSpecification ts :  tenderSpecificationDAO.selectTenderSpecificationByTenderId(43))
//            System.out.println(ts);
       // System.out.println(supplierDAO.findSupplierByLoginAndPassword("dd02@ukrteh.kiev.ua", "xeov2p"));
//        for (Tender tender : tenders){
//            System.out.println(tender.getTenderName());
//        }




}}

