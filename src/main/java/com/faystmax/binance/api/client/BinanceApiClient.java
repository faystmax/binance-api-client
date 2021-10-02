package com.faystmax.binance.api.client;

import com.faystmax.binance.api.client.domain.ExchangeInfo;
import com.faystmax.binance.api.client.domain.TickerPrice;
import com.faystmax.binance.api.client.domain.TickerStatistics;
import com.faystmax.binance.api.client.domain.account.Account;
import com.faystmax.binance.api.client.domain.request.AllOrdersRequest;
import com.faystmax.binance.api.client.domain.trade.NewOrder;
import com.faystmax.binance.api.client.domain.trade.NewOrderResponse;
import com.faystmax.binance.api.client.domain.trade.Order;
import com.faystmax.binance.api.client.domain.trade.Trade;

import java.util.List;

public interface BinanceApiClient {
    /**
     * Test connectivity to the Rest API
     */
    void ping();

    /**
     * Test connectivity to the Rest API and get the current server time
     *
     * @return server time in milliseconds
     */
    Long getServerTime();

    /**
     * @return Current exchange trading rules and symbol information
     */
    ExchangeInfo getExchangeInfo();

    /**
     * Get 24 hour price change statistics
     *
     * @param symbol ticker symbol (e.g. ETHBTC)
     * @return 24 hour price change statistics
     */
    TickerStatistics get24HrPriceStatistics(String symbol);

    /**
     * Get trades for current account and symbol
     *
     * @param symbol symbol to get trades from
     * @return a list of trades
     */
    List<Trade> getMyTrades(String symbol);

    /**
     * Get limited amount of trades for current account and symbol
     *
     * @param symbol symbol to get trades from
     * @param limit  maximum orders amount to return
     * @return a limited list of trades
     */
    List<Trade> getMyTrades(String symbol, Integer limit);

    /**
     * @return current account information
     */
    Account getAccount();

    /**
     * @param symbol symbol ticker symbol (e.g. ETHBTC)
     * @return latest symbol price
     */
    TickerPrice getLatestPrice(String symbol);

    /**
     * @return latest prices of all symbols
     */
    List<TickerPrice> getLatestPrice();

    /**
     * Send in a new order
     *
     * @param order the new order to submit
     * @return a response containing details about the newly placed order
     */
    NewOrderResponse newOrder(NewOrder order);

    /**
     * Test new order creation and signature/recvWindow long
     * Creates and validates a new order but does not send it into the matching engine
     *
     * @param order the new TEST order to submit
     */
    void newOrderTest(NewOrder order);

    /**
     * Get all account orders; active, canceled, or filled
     *
     * @param orderRequest order request parameters
     * @return a list of all account orders
     */
    List<Order> getAllOrders(AllOrdersRequest orderRequest);

    /**
     * Get all margin account orders; active, canceled, or filled
     *
     * @param orderRequest order request parameters
     * @return a list of all account orders
     */
    List<Order> getAllMarginOrders(AllOrdersRequest orderRequest);
}
