package com.faystmax.binance.api.client;

import com.faystmax.binance.api.client.domain.ExchangeInfo;
import com.faystmax.binance.api.client.domain.TickerStatistics;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BinanceApiClientPublicRoutesTest {
    private static BinanceApiClient apiClient;

    @BeforeAll
    public static void setUp() {
        apiClient = BinanceApiClientFactory.create();
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

    @Test
    void get24HrPriceStatistics_ok() {
        TickerStatistics statistics = apiClient.get24HrPriceStatistics("ETHUSDT");
        assertTrue(statistics.getLastPrice().compareTo(BigDecimal.ZERO) > 0);
    }
}