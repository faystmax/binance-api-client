package com.faystmax.binance.api.client;

import com.faystmax.binance.api.client.exception.BinanceApiException;
import org.junit.jupiter.api.Test;

import static com.faystmax.binance.api.client.BinanceApiClientTestConstants.SYMBOL;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BinanceApiClientErrorTest {
    @Test
    void testApiError() {
        var apiClient = BinanceApiClientFactory.create("test", "test");
        assertThrows(BinanceApiException.class, () -> apiClient.getMyTrades(SYMBOL));
    }
}