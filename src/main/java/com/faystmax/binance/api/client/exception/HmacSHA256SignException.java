package com.faystmax.binance.api.client.exception;

public class HmacSHA256SignException extends RuntimeException {
    public HmacSHA256SignException(String message, Throwable cause) {
        super(message, cause);
    }
}
