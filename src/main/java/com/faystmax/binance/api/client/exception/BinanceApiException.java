package com.faystmax.binance.api.client.exception;

public class BinanceApiException extends RuntimeException {
    public BinanceApiException(String message) {
        super(message);
    }

    public BinanceApiException(Throwable cause) {
        super(cause);
    }
}
