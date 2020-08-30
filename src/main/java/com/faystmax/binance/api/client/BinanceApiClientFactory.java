package com.faystmax.binance.api.client;

import com.faystmax.binance.api.client.impl.BinanceApiClientImpl;

public class BinanceApiClientFactory {
    /**
     * @return binance api client with enabled logging
     */
    public static BinanceApiClient create() {
        return create(null, null);
    }

    /**
     * @param apiKey binance API key
     * @param secret binance secret key
     * @return binance api client with enabled logging
     */
    public static BinanceApiClient create(String apiKey, String secret) {
        return create(apiKey, secret, true);
    }

    /**
     * @param apiKey    binance API key
     * @param secret    binance secret key
     * @param enableLog enable log interceptor
     * @return binance api client
     */
    public static BinanceApiClient create(String apiKey, String secret, boolean enableLog) {
        return new BinanceApiClientImpl(apiKey, secret, enableLog);
    }
}
