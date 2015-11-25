package com.revosoft.web.booker.domain;

import lombok.Data;
import lombok.Setter;

import java.time.LocalDate;
import java.math.BigDecimal;

@Data
public class Booking {

    @Setter
    private int id;
    @Setter
    private String name;
    @Setter
    private String address;

}
