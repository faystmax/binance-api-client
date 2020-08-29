package com.faystmax.binance.api.client.domain;

import com.faystmax.binance.api.client.domain.enums.RateLimitInterval;
import com.faystmax.binance.api.client.domain.enums.RateLimitType;
import lombok.Data;

/**
 * Rate limits
 */
@Data
public class RateLimit {
    private RateLimitType rateLimitType;

    private RateLimitInterval interval;

    private Integer limit;
}
