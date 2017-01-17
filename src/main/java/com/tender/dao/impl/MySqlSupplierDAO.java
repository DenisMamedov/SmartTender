package com.tender.dao.impl;

import com.tender.dao.SupplierDAO;
import com.tender.entity.Supplier;
import com.tender.entity.builder.SupplierBuilder;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Денис on 10.01.2017.
 */
public class MySqlSupplierDAO implements SupplierDAO {

    private static final String SELECT_SUPPLIER_BY_EMAIL_AND_PASSWORD = "SELECT * FROM supplier WHERE email = ? AND password = ?";
    private static final String ADD_SUPPLIER = "INSERT INTO supplier(supplier_name, okpo, address, contact_name, contact_phone, email, password) VALUES (?,?,?,?,?,?,?)";
    private Connection connection;

    public MySqlSupplierDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public int insertSupplier(Supplier supplier) {
        int result = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_SUPPLIER, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, supplier.getContactName());
            preparedStatement.setInt(2, supplier.getOkpo());
            preparedStatement.setString(3, supplier.getAddress());
            preparedStatement.setString(4, supplier.getContactName());
            preparedStatement.setString(5, supplier.getContactPhone());
            preparedStatement.setString(6, supplier.getEmail());
            preparedStatement.setString(7, DigestUtils.md5Hex(supplier.getPassword()));

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) result=rs.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean deleteSupplier(int id) {
        return false;
    }

    @Override
    public Supplier findSupplierByLoginAndPassword(String email, String password) {
        Supplier supplier = null;
        try {
            String passwordMD5 = DigestUtils.md5Hex(password);
            PreparedStatement statement = connection.prepareStatement(SELECT_SUPPLIER_BY_EMAIL_AND_PASSWORD);
            statement.setString(1, email);
            statement.setString(2, passwordMD5);
            ResultSet result = statement.executeQuery();
            result.next();
            supplier = new SupplierBuilder()
                    .setSupplierName(result.getString("supplier_name"))
                    .setOkpo(result.getInt("okpo"))
                    .setAddress(result.getString("address"))
                    .setContactName(result.getString("contact_name"))
                    .setContactPhone(result.getString("contact_phone"))
                    .setEmail(result.getString("email"))
                    .setPassword(result.getString("password"))
                    .setRole(result.getString("role"))
                    .createSupplier();
            supplier.setId(result.getInt("id"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return supplier;
    }
    @Override
    public boolean updateSupplier(Supplier supplier) {
        return false;
    }

    @Override
    public ArrayList<Supplier> selectSupplier() {
        return null;
    }
}
