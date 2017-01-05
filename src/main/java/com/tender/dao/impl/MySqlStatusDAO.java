package com.tender.dao.impl;

import com.tender.dao.StatusDAO;
import com.tender.entity.Status;
import com.tender.entity.builder.StatusBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Денис on 04.01.2017.
 */
public class MySqlStatusDAO implements StatusDAO {

    public static final String FIND_STATUS = "SELECT * FROM status WHERE id = ?";

    private Connection connection;

    public MySqlStatusDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public int insertStatus(Status category) {
        return 0;
    }

    @Override
    public boolean deleteStatus(int id) {
        return false;
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

    @Override
    public boolean updateStatus(Status status) {
        return false;
    }

    @Override
    public ArrayList<Status> selectStatus() {
        return null;
    }
}
