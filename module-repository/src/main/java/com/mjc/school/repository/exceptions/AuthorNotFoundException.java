package com.mjc.school.repository.exceptions;

import java.io.FileNotFoundException;

public class AuthorNotFoundException extends FileNotFoundException {
    public AuthorNotFoundException(String s) {
        super(s);
    }
}
