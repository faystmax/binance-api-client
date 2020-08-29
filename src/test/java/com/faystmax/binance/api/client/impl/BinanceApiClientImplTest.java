package com.faystmax.binance.api.client.impl;

import com.faystmax.binance.api.client.domain.ExchangeInfo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BinanceApiClientImplTest {
    private static BinanceApiClientImpl apiClient;

    @BeforeAll
    public static void setUp() {
        apiClient = new BinanceApiClientImpl(true);
    }

    @Test
    void ping_ok() {
        apiClient.ping();
    }

    @Test
    void getServerTime_ok() {
        Long serverTime = apiClient.getServerTime();
        assertTrue(serverTime > 0);
    }

    @Test
    void getExchangeInfo_ok() {
        ExchangeInfo exchangeInfo = apiClient.getExchangeInfo();
        assertNotNull(exchangeInfo);
    }
}