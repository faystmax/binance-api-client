package com.faystmax.binance.api.client.domain.request;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * A specialized order request with additional filters
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AllOrdersRequest extends OrderRequest {
    private static final Integer DEFAULT_LIMIT = 500;

    private Long orderId;

    private Integer limit;

    private Long startTime;

    private Long endTime;

    public AllOrdersRequest(String symbol) {
        super(symbol);
        this.limit = DEFAULT_LIMIT;
    }
}
