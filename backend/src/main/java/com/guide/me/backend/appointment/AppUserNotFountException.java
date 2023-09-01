package com.guide.me.backend.appointment;

import java.util.NoSuchElementException;

public class AppUserNotFountException extends NoSuchElementException {
    public AppUserNotFountException(String s) {
        super(s);
    }
}
