package com.faystmax.binance.api.client;

import com.faystmax.binance.api.client.domain.account.Account;
import com.faystmax.binance.api.client.domain.request.AllOrdersRequest;
import com.faystmax.binance.api.client.domain.trade.NewOrder;
import com.faystmax.binance.api.client.domain.trade.Order;
import com.faystmax.binance.api.client.domain.trade.Trade;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static com.faystmax.binance.api.client.BinanceApiClientTestConstants.SYMBOL;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Tests private BinanceApi routes
 * If you want ro run this tests you should specify api ans secret key and remove @Disabled
 */
@Disabled
class BinanceApiClientPrivateRoutesTest {
    public static final String API_KEY = ""; // Place Api key here
    public static final String SECRET = "";  // Place Secret key here

    private static BinanceApiClient apiClient;

    @BeforeAll
    public static void setUp() {
        apiClient = BinanceApiClientFactory.create(API_KEY, SECRET);
    }

    @Test
    void getMyTradesReturnNotNullTrades() {
        List<Trade> trades = apiClient.getMyTrades(SYMBOL);
        assertNotNull(trades);
    }

    @Test
    void getAccountReturnNotNullAccount() {
        Account account = apiClient.getAccount();
        assertNotNull(account);
    }

    @Test
    void newOrderTest() {
        NewOrder order = NewOrder.marketSell(SYMBOL, new BigDecimal("0.5"));
        assertDoesNotThrow(() -> apiClient.newOrderTest(order));
    }

    @Test
    void getAllOrdersReturnNotNullOrders() {
        List<Order> allOrders = apiClient.getAllOrders(new AllOrdersRequest(SYMBOL));
        assertNotNull(allOrders);
    }
}