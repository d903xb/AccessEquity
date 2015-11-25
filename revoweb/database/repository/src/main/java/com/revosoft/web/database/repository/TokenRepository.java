package com.revosoft.web.database.repository;

import com.revosoft.web.domain.Token;

import java.time.LocalDateTime;
import java.util.List;


public interface TokenRepository {

    void create(String username, String hash, LocalDateTime localDateTime);

    Token getActiveUserToken(String username);

    List<Token> listTokens();

    void delete(String username, String hash);

}
