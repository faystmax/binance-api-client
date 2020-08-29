package com.faystmax.binance.api.client.domain;

import com.faystmax.binance.api.client.domain.enums.FilterType;
import com.faystmax.binance.api.client.domain.enums.OrderType;
import com.faystmax.binance.api.client.domain.enums.SymbolStatus;
import com.faystmax.binance.api.client.domain.enums.TradePermission;
import lombok.Data;

import java.util.List;

/**
 * Symbol information (base/quote)
 */
@Data
public class SymbolInfo {

    private String symbol;

    private SymbolStatus status;

    private String baseAsset;

    private Integer baseAssetPrecision;

    private String quoteAsset;

    private Integer quotePrecision;

    private Integer baseCommissionPrecision;

    private Integer quoteCommissionPrecision;

    private List<OrderType> orderTypes;

    private boolean icebergAllowed;

    private boolean ocoAllowed;

    private boolean quoteOrderQtyMarketAllowed;

    private boolean isSpotTradingAllowed;

    private boolean isMarginTradingAllowed;

    private List<SymbolFilter> filters;

    private List<TradePermission> permissions;

    /**
     * @param filterType filter type to filter for.
     * @return symbol filter information for the provided filter type or null
     */
    public SymbolFilter getSymbolFilter(FilterType filterType) {
        return filters.stream()
            .filter(symbolFilter -> symbolFilter.getFilterType() == filterType)
            .findFirst()
            .orElse(null);
    }
}
