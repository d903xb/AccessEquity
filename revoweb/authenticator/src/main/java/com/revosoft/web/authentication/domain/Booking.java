package com.revosoft.web.authentication.domain;

import lombok.Data;
import lombok.Setter;

@Data
public class Booking {

    @Setter
    private int id;
    @Setter
    private String name;
    @Setter
    private String address;

}
