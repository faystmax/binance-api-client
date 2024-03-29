package com.faystmax.binance.api.client;

import com.faystmax.binance.api.client.domain.ExchangeInfo;
import com.faystmax.binance.api.client.domain.TickerPrice;
import com.faystmax.binance.api.client.domain.TickerStatistics;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static com.faystmax.binance.api.client.BinanceApiClientTestConstants.SYMBOL;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests public BinanceApi routes
 */
class BinanceApiClientPublicRoutesTest {
    private static BinanceApiClient apiClient;

    @BeforeAll
    public static void setUp() {
        apiClient = BinanceApiClientFactory.create();
    }

    @Test
    void ping() {
        apiClient.ping();
    }

    @Test
    void getServerTimeReturnPositiveValue() {
        Long serverTime = apiClient.getServerTime();
        assertTrue(serverTime > 0);
    }

    @Test
    void getExchangeInfoReturnNotNullInfo() {
        ExchangeInfo exchangeInfo = apiClient.getExchangeInfo();
        assertNotNull(exchangeInfo);
    }

    @Test
    void get24HrPriceStatisticsReturnPositiveLastPrice() {
        TickerStatistics statistics = apiClient.get24HrPriceStatistics(SYMBOL);
        assertTrue(statistics.getLastPrice().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    void getLatestPriceReturnPositiveValue() {
        TickerPrice price = apiClient.getLatestPrice(SYMBOL);
        assertTrue(price.getPrice().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    void getAllLatestPriceReturnSizeGreaterThenZero() {
        final List<TickerPrice> latestPrices = apiClient.getLatestPrice();
        assertTrue(latestPrices.size() > 0);
    }
}