package com.faystmax.binance.api.client.domain.enums;


/**
 * Filters define trading rules on a symbol or an exchange. Filters come in two forms: symbol filters and exchange filters
 */
public enum FilterType {
    PRICE_FILTER,
    LOT_SIZE,
    MIN_NOTIONAL,
    MAX_NUM_ORDERS,
    MAX_ALGO_ORDERS,
    MAX_NUM_ALGO_ORDERS,
    ICEBERG_PARTS,
    PERCENT_PRICE,
    MARKET_LOT_SIZE,
    MAX_NUM_ICEBERG_ORDERS,

    EXCHANGE_MAX_NUM_ORDERS,
    EXCHANGE_MAX_ALGO_ORDERS
}
