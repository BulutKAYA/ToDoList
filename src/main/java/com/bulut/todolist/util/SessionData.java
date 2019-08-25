package com.bulut.todolist.util;

import com.bulut.todolist.model.User;

import java.io.Serializable;
import java.util.Locale;

public class SessionData implements Serializable {

    private User user;

    private Locale locale;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}
