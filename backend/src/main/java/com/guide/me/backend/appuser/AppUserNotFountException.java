package com.guide.me.backend.appuser;

import java.util.NoSuchElementException;

public class AppUserNotFountException extends NoSuchElementException {
    public AppUserNotFountException(String s) {
        super(s);
    }
}
