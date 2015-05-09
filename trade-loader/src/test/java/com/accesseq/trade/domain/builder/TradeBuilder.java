package com.accesseq.trade.domain.builder;


import com.accesseq.trade.domain.Trade;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TradeBuilder {

    public static TradeBuilder newBuilder() { return new TradeBuilder();};

    private String isin;
    private String partyA;
    private String partyB;
    private BigDecimal quantity;
    private BigDecimal unitPrice;
    private LocalDate tradeDate;

    private TradeBuilder() {
        isin = "isin";
        partyA = "partyA";
        partyB = "partyB";
        quantity = new BigDecimal(100);
        unitPrice = new BigDecimal(100.40);
        tradeDate = LocalDate.now();
    }

    public TradeBuilder withPartyA(String partyA) {
        this.partyA = partyA;
        return this;
    }
    public TradeBuilder withPartyB(String partyB) {
        this.partyB = partyB;
        return this;
    }

    public Trade build() {
        return new Trade (
                isin,
                partyA,
                partyB,
                quantity,
                unitPrice,
                tradeDate
        );
    }
}
