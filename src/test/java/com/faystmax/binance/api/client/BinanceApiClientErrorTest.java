package com.faystmax.binance.api.client;

import com.faystmax.binance.api.client.exception.BinanceApiException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BinanceApiClientErrorTest {
    private static BinanceApiClient apiClient;

    @BeforeAll
    public static void setUp() {
        apiClient = new BinanceApiClientImpl(
            "test", // place Api key here
            "test",  // place Secret key here
            true);
    }

    @Test
    void testApiError() {
        Assertions.assertThrows(BinanceApiException.class, () -> {
            apiClient.getMyTrades("ETHUSDT");
        });
    }
}