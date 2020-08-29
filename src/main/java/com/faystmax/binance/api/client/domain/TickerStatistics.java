package com.faystmax.binance.api.client.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 24 hour price change statistics for a ticker
 */
@Data
public class TickerStatistics {
    /**
     * Ticker symbol
     */
    private String symbol;

    /**
     * Price change during the last 24 hours
     */
    private BigDecimal priceChange;

    /**
     * Price change, in percentage, during the last 24 hours
     */
    private BigDecimal priceChangePercent;

    /**
     * Weighted average price
     */
    private BigDecimal weightedAvgPrice;

    /**
     * Previous close price
     */
    private BigDecimal prevClosePrice;

    /**
     * Last price
     */
    private BigDecimal lastPrice;

    /**
     * Last quantity
     */
    private BigDecimal lastQty;

    /**
     * Bid price
     */
    private BigDecimal bidPrice;

    /**
     * Ask price
     */
    private BigDecimal askPrice;

    /**
     * Open price 24 hours ago
     */
    private BigDecimal openPrice;

    /**
     * Highest price during the past 24 hours
     */
    private BigDecimal highPrice;

    /**
     * Lowest price during the past 24 hours
     */
    private BigDecimal lowPrice;

    /**
     * Total volume during the past 24 hours
     */
    private BigDecimal volume;

    /**
     * Total quote volume during the past 24 hours
     */
    private BigDecimal quoteVolume;

    /**
     * Open time
     */
    private long openTime;

    /**
     * Close time
     */
    private long closeTime;

    /**
     * First trade id
     */
    private long firstId;

    /**
     * Last trade id
     */
    private long lastId;

    /**
     * Total number of trades during the last 24 hours
     */
    private long count;
}
