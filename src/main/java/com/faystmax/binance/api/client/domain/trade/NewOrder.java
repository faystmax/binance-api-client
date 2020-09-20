package com.faystmax.binance.api.client.domain.trade;

import com.faystmax.binance.api.client.domain.enums.OrderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

import static com.faystmax.binance.api.client.constant.BinanceApiConstants.DEFAULT_RECEIVING_WINDOW;
import static com.faystmax.binance.api.client.domain.trade.NewOrderResponseType.RESULT;

@Data
@Builder
@AllArgsConstructor
public class NewOrder {
    /**
     * Symbol to place the order on
     */
    private String symbol;
    /**
     * Buy/Sell order side
     */
    private OrderSide side;
    /**
     * Type of order
     */
    private OrderType type;
    /**
     * Time in force to indicate how long will the order remain active
     */
    private TimeInForce timeInForce;
    /**
     * Quantity
     */
    private BigDecimal quantity;
    /**
     * Quote quantity
     */
    private BigDecimal quoteOrderQty;
    /**
     * Price
     */
    private BigDecimal price;
    /**
     * A unique id for the order. Automatically generated if not sent
     */
    private String newClientOrderId;
    /**
     * Used with stop orders
     */
    private BigDecimal stopPrice;
    /**
     * Used with iceberg orders
     */
    private BigDecimal icebergQty;
    /**
     * Set the response JSON. ACK, RESULT, or FULL; default: RESULT
     */
    private NewOrderResponseType newOrderRespType;
    /**
     * Receiving window
     */
    private Long recvWindow;
    /**
     * Order timestamp
     */
    private long timestamp;

    /**
     * Creates a new order with all required parameters
     */
    public NewOrder(String symbol, OrderSide side, OrderType type, TimeInForce timeInForce, BigDecimal quantity) {
        this.symbol = symbol;
        this.side = side;
        this.type = type;
        this.timeInForce = timeInForce;
        this.quantity = quantity;
        this.newOrderRespType = RESULT;
        this.recvWindow = DEFAULT_RECEIVING_WINDOW;
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * Creates a new order with all required parameters plus price, which is optional for MARKET orders
     */
    public NewOrder(String symbol, OrderSide side, OrderType type, TimeInForce timeInForce, BigDecimal quantity, BigDecimal price) {
        this(symbol, side, type, timeInForce, quantity);
        this.price = price;
    }

    /**
     * Places a MARKET buy order for the given quantity
     *
     * @return a new order which is pre-configured with MARKET as the order type and BUY as the order side
     */
    public static NewOrder marketBuy(String symbol, BigDecimal quantity) {
        return new NewOrder(symbol, OrderSide.BUY, OrderType.MARKET, null, quantity);
    }

    /**
     * Places a MARKET sell order for the given quantity
     *
     * @return a new order which is pre-configured with MARKET as the order type and SELL as the order side
     */
    public static NewOrder marketSell(String symbol, BigDecimal quantity) {
        return new NewOrder(symbol, OrderSide.SELL, OrderType.MARKET, null, quantity);
    }

    /**
     * Places a LIMIT buy order for the given quantity and price
     *
     * @return a new order which is pre-configured with LIMIT as the order type and BUY as the order side
     */
    public static NewOrder limitBuy(String symbol, TimeInForce timeInForce, BigDecimal quantity, BigDecimal price) {
        return new NewOrder(symbol, OrderSide.BUY, OrderType.LIMIT, timeInForce, quantity, price);
    }

    /**
     * Places a LIMIT sell order for the given quantity and price
     *
     * @return a new order which is pre-configured with LIMIT as the order type and SELL as the order side
     */
    public static NewOrder limitSell(String symbol, TimeInForce timeInForce, BigDecimal quantity, BigDecimal price) {
        return new NewOrder(symbol, OrderSide.SELL, OrderType.LIMIT, timeInForce, quantity, price);
    }
}
