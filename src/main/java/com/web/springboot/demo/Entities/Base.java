package com.web.springboot.demo.Entities;

import java.util.Date;

public class Base {
    public long id;
    public Date createdAt;
    public String createdBy;
    public Base() {}
    public Base(long id,  Date createdAt, String createdBy) {
        this.id = id;
        this.createdAt = createdAt;
        this.createdBy = createdBy;

    }

    public long getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
