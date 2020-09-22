package com.faystmax.binance.api.client.domain.trade;

import com.faystmax.binance.api.client.domain.enums.OrderType;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Trade order information
 */
@Data
public class Order {
    /**
     * Symbol that the order was put on
     */
    private String symbol;
    /**
     * Order id
     */
    private Long orderId;
    /**
     * Order list id
     */
    private Long orderListId;
    /**
     * Client order id
     */
    private String clientOrderId;
    /**
     * Price
     */
    private BigDecimal price;
    /**
     * Original quantity
     */
    private BigDecimal origQty;
    /**
     * Original quantity
     */
    private BigDecimal executedQty;
    /**
     * Order status
     */
    private OrderStatus status;
    /**
     * Time in force to indicate how long will the order remain active
     */
    private TimeInForce timeInForce;
    /**
     * Type of order
     */
    private OrderType type;
    /**
     * Buy/Sell order side
     */
    private OrderSide side;
    /**
     * Used with stop orders
     */
    private BigDecimal stopPrice;
    /**
     * Used with iceberg orders
     */
    private BigDecimal icebergQty;
    /**
     * Order timestamp
     */
    private Long time;
    /**
     * Used to calculate the average price
     */
    private BigDecimal cummulativeQuoteQty;
    /**
     * Update timestamp
     */
    private Long updateTime;
    /**
     * Is working
     */
    private boolean isWorking;
    /**
     * Original quote order quantity
     */
    private BigDecimal origQuoteOrderQty;
}
