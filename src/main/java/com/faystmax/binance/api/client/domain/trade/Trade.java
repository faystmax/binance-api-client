package com.faystmax.binance.api.client.domain.trade;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Trade {
    /**
     * Trade id
     */
    private Long id;
    /**
     * Price
     */
    private BigDecimal price;
    /**
     * Quantity
     */
    private BigDecimal qty;
    /**
     * Quote quantity for the trade (price * qty)
     */
    private BigDecimal quoteQty;
    /**
     * Commission
     */
    private BigDecimal commission;
    /**
     * Asset on which commission is taken
     */
    private String commissionAsset;
    /**
     * Trade execution time
     */
    private long time;
    /**
     * The symbol of the trade
     */
    private String symbol;
    /**
     * Is trade buyer
     */
    private boolean isBuyer;
    /**
     * Is trade maker
     */
    private boolean isMaker;
    /**
     * Is trade best math
     */
    private boolean isBestMatch;
    /**
     * Order id
     */
    private String orderId;
}
