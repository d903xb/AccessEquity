package com.revosoft.web.database.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import com.revosoft.web.domain.Token;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;

@Slf4j
@AllArgsConstructor
public class TokenRepositoryImpl implements TokenRepository {

    private JdbcOperations jdbcOperations;

    public void create(String username, String hash, LocalDateTime localDateTime) {
        String SQL = "insert into Token (username, tokenHash, expiryDateTime, activeStatus) values (?, ?, ?, ?)";

        try {
            jdbcOperations.update(SQL, username, hash, localDateTime.toString(), "true");
        }
        catch (Exception e) {
            log.info(e.getMessage());
        }
        log.info("Created Token Username = " + username + ", Hash = " + hash + " ExpiryDate = " + localDateTime);
        return;
    }

    public Token getActiveUserToken(String username) {
        String SQL = "select * from Token where username = ? and activeStatus = true";

        List<Token> tokens = jdbcOperations.query(SQL, new Object[]{username}, new TokenRowMapper());

        if(tokens!=null && tokens.size()>0) {
            log.info("Found Token : Username = " + tokens.get(0).getUserId() + ", Hash = " + tokens.get(0).getTokenHash() + " ExpiryDate = " + tokens.get(0).getExpiryDateTime());
            return tokens.get(0);
        }
        return  null;

    }

    public List<Token> listTokens() {
        String SQL = "select * from Token";
        List <Token> students = jdbcOperations.query(SQL,
                new TokenRowMapper());
        return students;
    }

    public void delete(String username, String hash){
        String SQL = "delete from Token where username = ? and tokenHash = ?";
        jdbcOperations.update(SQL, username, hash);
        log.info("Deleted Token for Username = " + username + " and hash " + hash);
        return;
    }

    public class TokenRowMapper implements RowMapper<Token>
    {
        public Token mapRow(ResultSet rs, int rowNum) throws SQLException {
            Token token = new Token();
            token.setUserId(rs.getString("username"));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime dateTime = LocalDateTime.parse(rs.getString("expiryDateTime").substring(0, 19), formatter);
            token.setExpiryDateTime(dateTime);
            token.setTokenHash(rs.getString("tokenHash"));
            return token;
        }

    }

}