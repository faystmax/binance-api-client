package com.faystmax.binance.api.client;

import com.faystmax.binance.api.client.domain.trade.Trade;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Disabled
class BinanceApiClientPrivateRoutesTest {
    private static BinanceApiClient apiClient;

    @BeforeAll
    public static void setUp() {
        apiClient = BinanceApiClientFactory.create(
            "", // place Api key here
            ""  // place Secret key here
        );
    }

    @Test
    void getMyTrades_ok() {
        List<Trade> trades = apiClient.getMyTrades("ETHUSDT");
        assertNotNull(trades);
    }
}