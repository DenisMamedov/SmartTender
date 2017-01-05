package com.tender.entity;

import java.io.Serializable;

/**
 * Created by Денис on 04.01.2017.
 */
public abstract class AbstractEntity implements Serializable {

    protected Integer id;

    public Integer getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

}
