package com.faystmax.binance.api.client;

import com.faystmax.binance.api.client.domain.ExchangeInfo;
import com.faystmax.binance.api.client.domain.TickerPrice;
import com.faystmax.binance.api.client.domain.TickerStatistics;
import com.faystmax.binance.api.client.domain.account.Account;
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
     * @return current account information
     */
    Account getAccount();

    /**
     * @param symbol symbol ticker symbol (e.g. ETHBTC)
     * @return latest symbol price
     */
    TickerPrice getLatestPrice(String symbol);
}
