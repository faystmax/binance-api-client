package com.faystmax.binance.api.client.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinanceApiClientImplTest {
    private static BinanceApiClientImpl apiClient;

    @BeforeAll
    public static void setUp() {
        apiClient = new BinanceApiClientImpl(true);
    }

    @Test
    void ping() {
        apiClient.ping();
    }
}