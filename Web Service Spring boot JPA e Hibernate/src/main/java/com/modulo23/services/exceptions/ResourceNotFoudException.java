package com.modulo23.services.exceptions;

import java.io.Serial;

public class ResourceNotFoudException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    //? --------------------------------------   Constructors   --------------------------------------------------------
    public ResourceNotFoudException(Object id) {
        super("Resource not found :ID / Recurso não encontrado ID:" + id);
    }
}
