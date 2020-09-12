package com.faystmax.binance.api.client.domain.trade;

/**
 * Time in force to indicate how long an order will remain active before it is executed or expires
 * <p>
 * GTC (Good-Til-Canceled) orders are effective until they are executed or canceled
 * IOC (Immediate or Cancel) orders fills all or part of an order immediately and cancels the remaining part of the order
 * FOK (Fill or Kill) orders fills all in its entirety, otherwise, the entire order will be cancelled
 */
public enum TimeInForce {
    GTC,
    IOC,
    FOK
}

