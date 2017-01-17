package com.tender.command;

import com.tender.entity.Offer;
import com.tender.entity.Supplier;
import com.tender.entity.Tender;
import com.tender.entity.builder.OfferBuilder;
import com.tender.entity.builder.TenderBuilder;
import com.tender.main.Message;
import com.tender.service.ServiceManager;
import com.tender.service.TenderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Денис on 14.01.2017.
 */
public class CommandSave implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        TenderService service = (TenderService) ServiceManager.getService(TenderService.class);
        HttpSession session = request.getSession();
        String method = request.getMethod();
        if (method.equalsIgnoreCase("POST")) {

            String[] lotId = request.getParameterValues("lot_id");
            String[] price = request.getParameterValues("price");
            String[] termOfDelivery = request.getParameterValues("term_of_delivery");
            String[] conditionOfPayment = request.getParameterValues("condition_of_payment");
            String[] additionalInfo = request.getParameterValues("additional_info");
            String[] conditionOfDelivery = request.getParameterValues("condition_of_delivery");
            String[] guarantee = request.getParameterValues("guarantee");
            Integer tenderId = (Integer) session.getAttribute("tender_id");
            ArrayList<Integer> lotToIgnore = new ArrayList<>();
            for (int i = 0; i < price.length; i++) {
                if (price[i].isEmpty()) {
                    lotToIgnore.add(Integer.parseInt(lotId[i]));
                }
            }
            if (!lotToIgnore.isEmpty()) {
                for (int id : lotToIgnore) {
                    lotId[id - 1] = null;
                    termOfDelivery[id - 1] = null;
                    conditionOfPayment[id - 1] = null;
                    additionalInfo[id - 1] = null;
                    conditionOfDelivery[id - 1] = null;
                    guarantee[id - 1] = null;
                }
            }

            lotId = removeNullValue(lotId);
            price = removeNullValue(price);
            termOfDelivery = removeNullValue(termOfDelivery);
            conditionOfPayment = removeNullValue(conditionOfPayment);
            additionalInfo = removeNullValue(additionalInfo);
            conditionOfDelivery = removeNullValue(conditionOfDelivery);
            guarantee = removeNullValue(guarantee);

            Map<Integer, Offer> offerMap = new HashMap<>();

            for (int i = 0; i < lotId.length; i++) {
                Tender tender = new TenderBuilder().createTender();
                tender.setId(tenderId);
                Offer offer = new OfferBuilder()
                        .setLotId(Integer.parseInt(lotId[i]))
                        .setSupplier((Supplier) session.getAttribute("user"))
                        .setTender(tender)
                        .setPrice(Double.parseDouble(price[i]))
                        .setTermOfDelivery(Integer.parseInt(termOfDelivery[i]))
                        .setConditionOfPayment(conditionOfPayment[i])
                        .setAdditionalInfo(additionalInfo[i])
                        .setConditionOfDelivery(conditionOfDelivery[i])
                        .setGuarantee(Double.parseDouble(guarantee[i]))
                        .createOffer();
                offerMap.put(offer.getLotId(), offer);
            }
            Integer supplierId = Integer.parseInt(request.getParameter("supplier_id"));
            if (request.getParameter("update").equals("true")){
                if (service.updateOffer(offerMap, supplierId, tenderId) > 0){
                Message.setFlash("Предложение принято!");
                page = "WEB-INF/save.jsp";
                }
                else {
                    Message.setFlash("Нельзя подавать предложение на тендер, если нет цены ни по одному лоту!");
                page = CommandViewTender.getInstance().execute(request, response);
                }
            }
            else {
                if (service.saveOffer(offerMap) > 0) {
                    Message.setFlash("Предложение принято!");
                    page = "WEB-INF/save.jsp";
                }
                else {
                    Message.setFlash("Нельзя подавать предложение на тендер, если нет цены ни по одному лоту!");
                    page = CommandViewTender.getInstance().execute(request, response);
                }
            }

        }
        return page;
    }
    public static String[] removeNullValue(String[] array) {
        return Arrays.stream(array)
                .filter(s -> (s != null && s.length() > 0))
                .toArray(String[]::new);
    }
}