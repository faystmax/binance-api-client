package com.faystmax.binance.api.client;

import com.faystmax.binance.api.client.exception.BinanceApiException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.faystmax.binance.api.client.BinanceApiClientTestConstant.SYMBOL;

class BinanceApiClientErrorTest {
    @Test
    void testApiError() {
        var apiClient = BinanceApiClientFactory.create("test", "test");
        Assertions.assertThrows(BinanceApiException.class, () -> {
            apiClient.getMyTrades(SYMBOL);
        });
    }
}