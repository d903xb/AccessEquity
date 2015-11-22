package com.revosoft.web.booker.jdbc;

import lombok.Data;

@Data
public class MysqlDatabaseConnection implements DatabaseConnection {
    private String url;
}
