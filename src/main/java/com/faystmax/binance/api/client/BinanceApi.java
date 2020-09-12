package com.faystmax.binance.api.client;

import com.faystmax.binance.api.client.constant.BinanceApiConstants;
import com.faystmax.binance.api.client.domain.ExchangeInfo;
import com.faystmax.binance.api.client.domain.ServerTime;
import com.faystmax.binance.api.client.domain.TickerPrice;
import com.faystmax.binance.api.client.domain.TickerStatistics;
import com.faystmax.binance.api.client.domain.account.Account;
import com.faystmax.binance.api.client.domain.enums.OrderType;
import com.faystmax.binance.api.client.domain.trade.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.math.BigDecimal;
import java.util.List;

public interface BinanceApi {
    @GET("/api/v3/ping")
    Call<Void> ping();

    @GET("/api/v3/time")
    Call<ServerTime> getServerTime();

    @GET("/api/v3/exchangeInfo")
    Call<ExchangeInfo> getExchangeInfo();

    @GET("/api/v3/ticker/24hr")
    Call<TickerStatistics> get24HrPriceStatistics(@Query("symbol") String symbol);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/v3/myTrades")
    Call<List<Trade>> getMyTrades(@Query("symbol") String symbol, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/v3/account")
    Call<Account> getAccount(@Query("timestamp") Long timestamp);

    @GET("/api/v3/ticker/price")
    Call<TickerPrice> getLatestPrice(@Query("symbol") String symbol);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/api/v3/order")
    Call<NewOrderResponse> newOrder(@Query("symbol") String symbol,
                                    @Query("side") OrderSide side,
                                    @Query("type") OrderType type,
                                    @Query("timeInForce") TimeInForce timeInForce,
                                    @Query("quantity") BigDecimal quantity,
                                    @Query("quoteOrderQty") BigDecimal quoteOrderQty,
                                    @Query("price") BigDecimal price,
                                    @Query("newClientOrderId") String newClientOrderId,
                                    @Query("stopPrice") BigDecimal stopPrice,
                                    @Query("icebergQty") BigDecimal icebergQty,
                                    @Query("newOrderRespType") NewOrderResponseType newOrderRespType,
                                    @Query("recvWindow") Long recvWindow,
                                    @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/api/v3/order/test")
    Call<NewOrderResponse> newOrderTest(@Query("symbol") String symbol,
                                        @Query("side") OrderSide side,
                                        @Query("type") OrderType type,
                                        @Query("timeInForce") TimeInForce timeInForce,
                                        @Query("quantity") BigDecimal quantity,
                                        @Query("quoteOrderQty") BigDecimal quoteOrderQty,
                                        @Query("price") BigDecimal price,
                                        @Query("newClientOrderId") String newClientOrderId,
                                        @Query("stopPrice") BigDecimal stopPrice,
                                        @Query("icebergQty") BigDecimal icebergQty,
                                        @Query("newOrderRespType") NewOrderResponseType newOrderRespType,
                                        @Query("recvWindow") Long recvWindow,
                                        @Query("timestamp") Long timestamp);
}
