package com.tender.dao.impl;

import com.tender.dao.StatusDAO;
import com.tender.entity.Status;
import com.tender.entity.builder.StatusBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Денис on 04.01.2017.
 */
public class MySqlStatusDAO implements StatusDAO {

    public static final String FIND_STATUS = "SELECT * FROM status WHERE id = ?";

    private Connection connection;

    public MySqlStatusDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Status findStatus(int id) {
        Status status = null;
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_STATUS);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            result.next();
            status = new StatusBuilder()
                    .setStatus(result.getString("status"))
                    .createStatus();
            status.setId(result.getInt("id"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;
    }

}
