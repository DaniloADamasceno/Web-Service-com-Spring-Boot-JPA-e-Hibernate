package com.modulo23.services.exceptions;

import java.io.Serial;

public class DatabaseException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    //? --------------------------------------   Constructors   --------------------------------------------------------
    public DatabaseException(String msg) {
        super(msg);
    }
}

