package com.tender.dao.impl;

/**
 * Created by Денис on 17.01.2017.
 */
public enum StatusEnum {

    IN_PROGRESS("Приём предложений"), ENDED("Завершен"), EDITING("Редактируется"), PROLONGED("Продлен");

    private String value;

    StatusEnum(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }
}
