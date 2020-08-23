package com.faystmax.binance.api.client.domain;

import lombok.Value;

@Value
public class ServerTime {
    /**
     * Time in milliseconds
     */
    Long serverTime;
}
