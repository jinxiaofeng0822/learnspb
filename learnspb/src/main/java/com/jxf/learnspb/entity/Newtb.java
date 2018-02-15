package com.jxf.learnspb.entity;

import java.io.Serializable;

public class Newtb implements Serializable {
    private Integer id;

    private String qwEr;

    private String asDf;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQwEr() {
        return qwEr;
    }

    public void setQwEr(String qwEr) {
        this.qwEr = qwEr;
    }

    public String getAsDf() {
        return asDf;
    }

    public void setAsDf(String asDf) {
        this.asDf = asDf;
    }
}