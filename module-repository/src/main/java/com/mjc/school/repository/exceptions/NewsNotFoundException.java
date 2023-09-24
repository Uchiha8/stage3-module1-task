package com.mjc.school.repository.exceptions;

import java.io.FileNotFoundException;

public class NewsNotFoundException extends FileNotFoundException {
    public NewsNotFoundException(String s) {
        super(s);
    }
}
