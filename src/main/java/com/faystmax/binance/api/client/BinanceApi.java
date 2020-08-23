package com.faystmax.binance.api.client;

import com.faystmax.binance.api.client.domain.ServerTime;
import retrofit2.Call;
import retrofit2.http.GET;

public interface BinanceApi {
    @GET("/api/v3/ping")
    Call<Void> ping();

    @GET("/api/v3/time")
    Call<ServerTime> getServerTime();
}
