package com.urbana_pe.gereciadorCartao.infrastructure.exception;

public class AccessDeniedCartaoException extends RuntimeException {

    public AccessDeniedCartaoException(String message) {
        super(message);
    }
}
