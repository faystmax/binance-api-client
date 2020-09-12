package com.faystmax.binance.api.client.domain.trade;

import com.faystmax.binance.api.client.domain.enums.OrderType;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class NewOrderResponse {
    private String symbol;

    private Long orderId;

    private Long orderListId;

    private String clientOrderId;

    private Long transactTime;

    private BigDecimal price;

    private BigDecimal origQty;

    private BigDecimal executedQty;

    private BigDecimal cummulativeQuoteQty;

    private OrderStatus status;

    private TimeInForce timeInForce;

    private OrderType type;

    private OrderSide side;

    private List<Trade> fills = new ArrayList<>();
}
