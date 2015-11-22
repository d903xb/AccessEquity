package com.revosoft.web.booker.domain;

import lombok.Data;

import java.time.LocalDate;
import java.math.BigDecimal;

@Data
public class Trade {

    final private String isin;
    final private String partyA;
    final private String partyB;
    final private BigDecimal quantity;
    final private BigDecimal unitPrice;
    final private LocalDate tradeDate;

}
