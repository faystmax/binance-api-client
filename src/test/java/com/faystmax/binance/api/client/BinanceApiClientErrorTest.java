package com.faystmax.binance.api.client;

import com.faystmax.binance.api.client.exception.BinanceApiException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BinanceApiClientErrorTest {
    @Test
    void testApiError() {
        var apiClient = BinanceApiClientFactory.create("test", "test");
        Assertions.assertThrows(BinanceApiException.class, () -> {
            apiClient.getMyTrades("ETHUSDT");
        });
    }
}