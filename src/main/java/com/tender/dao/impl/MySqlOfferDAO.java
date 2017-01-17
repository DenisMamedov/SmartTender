package com.tender.dao.impl;

import com.tender.dao.OfferDAO;
import com.tender.entity.Offer;
import com.tender.entity.builder.OfferBuilder;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Денис on 13.01.2017.
 */
public class MySqlOfferDAO implements OfferDAO {
    private Connection connection;

    public MySqlOfferDAO(Connection connection) {
        this.connection = connection;
    }

    private static final String INSERT_OFFER = "INSERT INTO offer " +
            "(supplier_id, tender_id, lot_id, price, term_of_delivery, condition_of_payment, additional_info, condition_of_delivery, guarantee)" +
            " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String UPDATE_OFFER = "UPDATE offer SET " +
            "price = ?, term_of_delivery = ?, condition_of_payment = ?, additional_info = ?, condition_of_delivery = ?, guarantee = ? WHERE lot_id = ? AND tender_id = ? AND supplier_id = ?";

    private static final String GET_OFFER_INFORMATION = "SELECT lot_id, price, term_of_delivery, condition_of_payment, additional_info, condition_of_delivery, guarantee FROM offer " +
            "WHERE tender_id= ? AND supplier_id= ?";

    private static final String GET_MIN_PRICE = "SELECT MIN(price) AS min, lot_id FROM offer WHERE tender_id= ? GROUP BY lot_id";

    @Override
    public int insertOffer(Map<Integer, Offer> offerMap) {

        int result = 0;
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_OFFER, Statement.RETURN_GENERATED_KEYS);
            for (Map.Entry entry : offerMap.entrySet()) {
                Offer offer = (Offer) entry.getValue();
                preparedStatement.setInt(1, offer.getSupplier().getId());
                preparedStatement.setInt(2, offer.getTender().getId());
                preparedStatement.setInt(3, offer.getLotId());
                preparedStatement.setDouble(4, offer.getPrice());
                preparedStatement.setInt(5, offer.getTermOfDelivery());
                preparedStatement.setString(6, offer.getConditionOfPayment());
                preparedStatement.setString(7, offer.getAdditionalInfo());
                preparedStatement.setString(8, offer.getConditionOfDelivery());
                preparedStatement.setDouble(9, offer.getGuarantee());

                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();
            connection.commit();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) result = rs.getInt(1);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateOffer(Map<Integer, Offer> offerMap, int supplier_id, int tender_id) {
        int result = 0;
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_OFFER, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(8, tender_id);
            preparedStatement.setInt(9, supplier_id);
            for (Map.Entry entry : offerMap.entrySet()) {
                Offer offer = (Offer) entry.getValue();
                preparedStatement.setDouble(1, offer.getPrice());
                preparedStatement.setInt(2, offer.getTermOfDelivery());
                preparedStatement.setString(3, offer.getConditionOfPayment());
                preparedStatement.setString(4, offer.getAdditionalInfo());
                preparedStatement.setString(5, offer.getConditionOfDelivery());
                preparedStatement.setDouble(6, offer.getGuarantee());
                preparedStatement.setInt(7, offer.getLotId());

                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            connection.commit();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) result = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Map<Integer, Offer> selectOfferByTenderIdAndSupplierId(int tenderId, int supplierId) {

        Map<Integer, Offer> offerMap = new HashMap<>();

        try {
            PreparedStatement statement = connection.prepareStatement(GET_OFFER_INFORMATION);
            statement.setInt(1, tenderId);
            statement.setInt(2, supplierId);

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Offer offer = new OfferBuilder()
                        .setLotId(result.getInt("lot_id"))
                        .setPrice(result.getDouble("price"))
                        .setTermOfDelivery(result.getInt("term_of_delivery"))
                        .setConditionOfPayment(result.getString("condition_of_payment"))
                        .setAdditionalInfo(result.getString("additional_info"))
                        .setConditionOfDelivery(result.getString("condition_of_delivery"))
                        .setGuarantee(result.getDouble("guarantee"))
                        .createOffer();

                offerMap.put(result.getInt("lot_id"), offer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return offerMap;
    }

    @Override
    public Map<Integer, Double> selectMinimalPrices(int tenderId) {

        Map<Integer, Double> priceList = new HashMap<>();

        try {
            PreparedStatement statement = connection.prepareStatement(GET_MIN_PRICE);
            statement.setInt(1, tenderId);

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                priceList.put(result.getInt("lot_id"), result.getDouble("min"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return priceList;
    }
}