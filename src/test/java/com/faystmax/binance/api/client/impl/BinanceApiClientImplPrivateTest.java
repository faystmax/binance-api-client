package com.faystmax.binance.api.client.impl;

import com.faystmax.binance.api.client.domain.trade.Trade;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Disabled
class BinanceApiClientImplPrivateTest {
    private static BinanceApiClientImpl apiClient;

    @BeforeAll
    public static void setUp() {
        apiClient = new BinanceApiClientImpl(
            "", // place Api key here
            "",  // place Secret key here
            true);
    }

    @Test
    void getMyTrades_ok() {
        List<Trade> trades = apiClient.getMyTrades("ETHUSDT");
        assertNotNull(trades);
    }
}