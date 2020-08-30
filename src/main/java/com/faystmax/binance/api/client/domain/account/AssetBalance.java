package com.faystmax.binance.api.client.domain.account;

import lombok.Data;

import java.math.BigDecimal;

/**
 * An asset balance in an Account
 *
 * @see Account
 */
@Data
public class AssetBalance {
    /**
     * Asset symbol
     */
    private String asset;
    /**
     * Available balance
     */
    private BigDecimal free;
    /**
     * Locked by open orders
     */
    private BigDecimal locked;

    public static AssetBalance createEmpty(String symbol) {
        AssetBalance balance = new AssetBalance();
        balance.setAsset(symbol);
        balance.setFree(BigDecimal.ZERO);
        balance.setLocked(BigDecimal.ZERO);
        return balance;
    }
}
