package com.gogokwon.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by KJShin on 2017-04-30.
 */
@Entity
public class User {
    @Id
    private String id;
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
