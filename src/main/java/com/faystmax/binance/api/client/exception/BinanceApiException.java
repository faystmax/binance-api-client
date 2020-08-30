package com.faystmax.binance.api.client.exception;

import com.faystmax.binance.api.client.domain.error.BinanceApiError;
import lombok.Getter;

@Getter
public class BinanceApiException extends RuntimeException {
    private int code;

    public BinanceApiException(String message) {
        super(message);
    }

    public BinanceApiException(BinanceApiError apiError) {
        super(apiError.getMsg());
        this.code = apiError.getCode();
    }

    public BinanceApiException(Throwable cause) {
        super(cause);
    }
}
