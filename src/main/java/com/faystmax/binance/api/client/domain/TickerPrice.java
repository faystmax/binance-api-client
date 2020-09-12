package com.faystmax.binance.api.client.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Wraps a symbol and its corresponding latest price
 */
@Data
public class TickerPrice {
    /**
     * Ticker symbol
     */
    private String symbol;
    /**
     * Latest price
     */
    private BigDecimal price;
}
