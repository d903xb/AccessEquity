package com.accesseq.trade.jdbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class H2DatabaseConnection implements DatabaseConnection {
    final private String url;
}
