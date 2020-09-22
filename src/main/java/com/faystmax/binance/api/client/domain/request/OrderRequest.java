package com.faystmax.binance.api.client.domain.request;

import com.faystmax.binance.api.client.constant.BinanceApiConstants;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Base request parameters for order-related methods
 */
@Data
@NoArgsConstructor
public class OrderRequest {

    private String symbol;

    private Long recvWindow;

    private Long timestamp;

    public OrderRequest(String symbol) {
        this.symbol = symbol;
        this.timestamp = System.currentTimeMillis();
        this.recvWindow = BinanceApiConstants.DEFAULT_RECEIVING_WINDOW;
    }
}
