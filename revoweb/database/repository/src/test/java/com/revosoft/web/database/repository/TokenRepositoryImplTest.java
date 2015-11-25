package com.revosoft.web.database.repository;


import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by steve on 25/11/2015.
 */
public class TokenRepositoryImplTest{

    @Test
    public void testGetActiveUserToken() throws Exception {
        System.out.println("2015-11-25 17:38:58.01".substring(0,19));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse("2015-11-25 17:38:58.01".substring(0,19), formatter);




    }
}