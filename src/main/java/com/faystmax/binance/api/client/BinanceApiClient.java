package com.faystmax.binance.api.client;

import com.faystmax.binance.api.client.domain.ExchangeInfo;

public interface BinanceApiClient {
    /**
     * Test connectivity to the Rest API
     */
    void ping();

    /**
     * Test connectivity to the Rest API and get the current server time
     *
     * @return server time in milliseconds
     */
    Long getServerTime();

    /**
     * @return Current exchange trading rules and symbol information
     */
    ExchangeInfo getExchangeInfo();
}
