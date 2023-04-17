package com.gmail.spanteleyko.multiproject.repo.exceptions;

import java.io.FileNotFoundException;

public class FileNotExistsException extends FileNotFoundException {
    public FileNotExistsException(String errorMessage) {
        super(errorMessage);
    }
}
