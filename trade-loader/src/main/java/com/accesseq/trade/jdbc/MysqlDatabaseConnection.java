package com.accesseq.trade.jdbc;

import lombok.Data;

@Data
public class MysqlDatabaseConnection implements DatabaseConnection {
    private String url;
}
