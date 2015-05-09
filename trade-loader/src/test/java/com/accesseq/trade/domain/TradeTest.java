package com.accesseq.trade.domain;

import com.accesseq.trade.domain.builder.TradeBuilder;
import org.junit.Test;
import static org.junit.Assert.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class TradeTest {

    @Test
    public void testTradeBuilder() {

        Trade trade = new Trade(
                "INSIN1",
                "partyA",
                "partyB",
                new BigDecimal(100),
                new BigDecimal(1.40),
                LocalDate.now()
        );

        TradeBuilder tradeBuilder = TradeBuilder.newBuilder();
        Trade builtTrade = tradeBuilder
                .withPartyA("Steve")
                .withPartyB("MinZaw")
                .build();

        assertNotSame(trade, builtTrade);

    }
}