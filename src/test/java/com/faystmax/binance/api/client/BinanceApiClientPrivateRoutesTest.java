package com.faystmax.binance.api.client;

import com.faystmax.binance.api.client.domain.account.Account;
import com.faystmax.binance.api.client.domain.trade.Trade;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.faystmax.binance.api.client.BinanceApiClientTestConstant.SYMBOL;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Tests private BinanceApi routes
 * If you want ro run this tests you should specify api ans secret key and remove @Disabled
 */
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
        List<Trade> trades = apiClient.getMyTrades(SYMBOL);
        assertNotNull(trades);
    }

    @Test
    void getAccount_ok() {
        Account account = apiClient.getAccount();
        assertNotNull(account);
    }
}