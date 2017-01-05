package com.tender.dao;

import com.tender.entity.Status;

import java.util.ArrayList;

/**
 * Created by Денис on 04.01.2017.
 */
public interface StatusDAO {

    int insertStatus(Status status);
    boolean deleteStatus(int id);
    Status findStatus(int id);
    boolean updateStatus(Status status);
    ArrayList<Status> selectStatus();
}
