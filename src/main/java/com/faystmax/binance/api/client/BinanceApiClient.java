package com.faystmax.binance.api.client;

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
}
