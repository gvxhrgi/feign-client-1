package com.example.demo.model.response;

import com.example.demo.model.Support;
import com.example.demo.model.User;

public class SingleUserResponse {
    private User data;
    private Support support;

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }
}
