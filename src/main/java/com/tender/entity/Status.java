package com.tender.entity;

import java.util.Objects;

/**
 * Created by Денис on 03.01.2017.
 */

public class Status extends AbstractEntity {

    private String status;

    public Status(String status){
        this.status = status;
    }

    public String getStatusName() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status1 = (Status) o;
        return Objects.equals(id, status1.id) &&
                Objects.equals(status, status1.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status);
    }

    @Override
    public String toString() {
        return "Status{" +
                "status='" + status + '\'' +
                '}';
    }
}
