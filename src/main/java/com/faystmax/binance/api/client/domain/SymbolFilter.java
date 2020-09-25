package com.faystmax.binance.api.client.domain;

import com.faystmax.binance.api.client.domain.enums.FilterType;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Filters define trading rules on a symbol or an exchange. Filters come in two forms: symbol filters and exchange filters
 *
 * @see FilterType#PRICE_FILTER defines the price rules for a symbol
 * @see FilterType#LOT_SIZE filter defines the quantity (aka "lots" in auction terms) rules for a symbol
 * @see FilterType#MIN_NOTIONAL filter defines the minimum notional value allowed for an order on a symbol. An order's notional value is the price * quantity
 * @see FilterType#MAX_NUM_ORDERS filter defines the maximum number of orders an account is allowed to have open on a symbol. Note that both "algo" orders and normal orders are counted for this filter
 * @see FilterType#MAX_ALGO_ORDERS filter defines the maximum number of "algo" orders an account is allowed to have open on a symbol. "Algo" orders are STOP_LOSS, STOP_LOSS_LIMIT, TAKE_PROFIT, and TAKE_PROFIT_LIMIT orders
 * @see FilterType#MAX_POSITION filter defines the allowed maximum position an account can have on the base asset of a symbol
 */
@Data
public class SymbolFilter {

    private FilterType filterType;

    /**
     * Defines the minimum price/stopPrice allowed
     *
     * @see FilterType#PRICE_FILTER
     */
    private BigDecimal minPrice;
    /**
     * Defines the maximum price/stopPrice allowed
     *
     * @see FilterType#PRICE_FILTER
     */
    private BigDecimal maxPrice;
    /**
     * Defines the intervals that a price/stopPrice can be increased/decreased by
     *
     * @see FilterType#PRICE_FILTER
     */
    private BigDecimal tickSize;

    /**
     * Defines the minimum quantity/icebergQty allowed.
     *
     * @see FilterType#LOT_SIZE
     */
    private BigDecimal minQty;
    /**
     * Defines the maximum quantity/icebergQty allowed.
     *
     * @see FilterType#LOT_SIZE
     */
    private BigDecimal maxQty;
    /**
     * Defines the intervals that a quantity/icebergQty can be increased/decreased by
     *
     * @see FilterType#LOT_SIZE
     */
    private BigDecimal stepSize;

    /**
     * Defines the minimum notional value allowed for an order on a symbol. An order's notional value is the price * quantity
     *
     * @see FilterType#MIN_NOTIONAL
     */
    private String minNotional;

    /**
     * Defines the maximum number of "algo" orders an account is allowed to have open on a symbol. "Algo" orders are STOP_LOSS, STOP_LOSS_LIMIT, TAKE_PROFIT, and TAKE_PROFIT_LIMIT orders
     *
     * @see FilterType#MAX_NUM_ALGO_ORDERS
     */
    private String maxNumAlgoOrders;

    /**
     * @see FilterType#MAX_NUM_ORDERS filter defines the maximum number of orders an account is allowed to have open on a symbol. Note that both "algo" orders and normal orders are counted for this filter
     * @see FilterType#MAX_ALGO_ORDERS filter defines the maximum number of "algo" orders an account is allowed to have open on a symbol. "Algo" orders are STOP_LOSS, STOP_LOSS_LIMIT, TAKE_PROFIT, and TAKE_PROFIT_LIMIT orders
     * @see FilterType#ICEBERG_PARTS filter defines the maximum parts an iceberg order can have. The number of ICEBERG_PARTS is defined as CEIL(qty / icebergQty)
     */
    private String limit;

    /**
     * @see FilterType#MAX_POSITION filter defines the allowed maximum position an account can have on the base asset of a symbol
     */
    private BigDecimal maxPosition;
}
