package com.faystmax.binance.api.client.impl;

import com.faystmax.binance.api.client.BinanceApi;
import com.faystmax.binance.api.client.BinanceApiClient;
import com.faystmax.binance.api.client.domain.ExchangeInfo;
import com.faystmax.binance.api.client.domain.TickerStatistics;
import com.faystmax.binance.api.client.domain.trade.Trade;
import com.faystmax.binance.api.client.exception.BinanceApiException;
import com.faystmax.binance.api.client.security.AuthenticationInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

import static okhttp3.logging.HttpLoggingInterceptor.Level.BODY;

public class BinanceApiClientImpl implements BinanceApiClient {
    private static final String BASE_URL = "https://api.binance.com/";
    private final BinanceApi api;

    public BinanceApiClientImpl(String apiKey, String secret, boolean enableLog) {
        var httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new AuthenticationInterceptor(apiKey, secret));

        if (enableLog) {
            var logging = new HttpLoggingInterceptor();
            logging.setLevel(BODY);
            httpClient.addInterceptor(logging);
        }

        api = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
            .create(BinanceApi.class);
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

    private <T> T execute(Call<T> call) {
        try {
            Response<T> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            }
            throw new BinanceApiException("Unsuccessful response: " + response);
        } catch (IOException e) {
            throw new BinanceApiException(e);
        }
    }
}
