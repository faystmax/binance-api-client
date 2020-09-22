package com.faystmax.binance.api.client.impl;

import com.faystmax.binance.api.client.BinanceApi;
import com.faystmax.binance.api.client.BinanceApiClient;
import com.faystmax.binance.api.client.constant.BinanceApiConstants;
import com.faystmax.binance.api.client.domain.ExchangeInfo;
import com.faystmax.binance.api.client.domain.TickerPrice;
import com.faystmax.binance.api.client.domain.TickerStatistics;
import com.faystmax.binance.api.client.domain.account.Account;
import com.faystmax.binance.api.client.domain.error.BinanceApiError;
import com.faystmax.binance.api.client.domain.request.AllOrdersRequest;
import com.faystmax.binance.api.client.domain.trade.NewOrder;
import com.faystmax.binance.api.client.domain.trade.NewOrderResponse;
import com.faystmax.binance.api.client.domain.trade.Order;
import com.faystmax.binance.api.client.domain.trade.Trade;
import com.faystmax.binance.api.client.exception.BinanceApiException;
import com.faystmax.binance.api.client.security.AuthenticationInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.List;

import static okhttp3.logging.HttpLoggingInterceptor.Level.BODY;

public class BinanceApiClientImpl implements BinanceApiClient {
    private final BinanceApi api;
    private final Converter<ResponseBody, BinanceApiError> errorConverter;

    /**
     * @param apiKey    binance API key
     * @param secret    binance secret key
     * @param enableLog enable log interceptor
     */
    public BinanceApiClientImpl(String apiKey, String secret, boolean enableLog) {
        var httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new AuthenticationInterceptor(apiKey, secret));

        if (enableLog) {
            var logging = new HttpLoggingInterceptor();
            logging.setLevel(BODY);
            httpClient.addInterceptor(logging);
        }

        var retrofit = new Retrofit.Builder()
            .baseUrl(BinanceApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build();

        api = retrofit.create(BinanceApi.class);
        errorConverter = retrofit.responseBodyConverter(BinanceApiError.class, new Annotation[0]);
    }

    @Override
    public void ping() {
        execute(api.ping());
    }

    @Override
    public Long getServerTime() {
        return execute(api.getServerTime()).getServerTime();
    }

    @Override
    public ExchangeInfo getExchangeInfo() {
        return execute(api.getExchangeInfo());
    }

    @Override
    public TickerStatistics get24HrPriceStatistics(String symbol) {
        return execute(api.get24HrPriceStatistics(symbol));
    }

    @Override
    public List<Trade> getMyTrades(String symbol) {
        return execute(api.getMyTrades(symbol, System.currentTimeMillis()));
    }

    @Override
    public Account getAccount() {
        return execute(api.getAccount(System.currentTimeMillis()));
    }

    @Override
    public TickerPrice getLatestPrice(String symbol) {
        return execute(api.getLatestPrice(symbol));
    }

    @Override
    public NewOrderResponse newOrder(NewOrder order) {
        return execute(api.newOrder(order.getSymbol(), order.getSide(), order.getType(),
            order.getTimeInForce(), order.getQuantity(), order.getQuoteOrderQty(), order.getPrice(),
            order.getNewClientOrderId(), order.getStopPrice(), order.getIcebergQty(), order.getNewOrderRespType(),
            order.getRecvWindow(), order.getTimestamp()));
    }

    @Override
    public void newOrderTest(NewOrder order) {
        execute(api.newOrderTest(order.getSymbol(), order.getSide(), order.getType(),
            order.getTimeInForce(), order.getQuantity(), order.getQuoteOrderQty(), order.getPrice(),
            order.getNewClientOrderId(), order.getStopPrice(), order.getIcebergQty(), order.getNewOrderRespType(),
            order.getRecvWindow(), order.getTimestamp()));
    }

    @Override
    public List<Order> getAllOrders(AllOrdersRequest orderRequest) {
        return execute(api.getAllOrders(orderRequest.getSymbol(),
            orderRequest.getOrderId(), orderRequest.getStartTime(), orderRequest.getEndTime(),
            orderRequest.getLimit(), orderRequest.getRecvWindow(), orderRequest.getTimestamp()));
    }

    private <T> T execute(Call<T> call) {
        try {
            Response<T> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                throw new BinanceApiException(errorConverter.convert(response.errorBody()));
            }
        } catch (IOException e) {
            throw new BinanceApiException(e);
        }
    }
}
