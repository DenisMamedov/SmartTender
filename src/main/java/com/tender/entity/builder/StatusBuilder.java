package com.tender.entity.builder;

import com.tender.entity.Status;

/**
 * Created by Денис on 04.01.2017.
 */
public class StatusBuilder {

    private String status;

    public StatusBuilder setStatus(String status) {
        this.status = status;
        return this;
    }

    public Status createStatus() {
        return new Status(status);
    }
}
