package com.faystmax.binance.api.client.domain.error;

import lombok.Data;

/**
 * Binance API error object
 */
@Data
public class BinanceApiError {
    /**
     * Error code.
     */
    private int code;
    /**
     * Error message.
     */
    private String msg;
}
