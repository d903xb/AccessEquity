package com.revosoft.web.database.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import com.revosoft.web.domain.Token;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;

@Slf4j
@AllArgsConstructor
public class TokenRepositoryImpl implements TokenRepository {

    private JdbcOperations jdbcOperations;

    public void create(String username, String hash, LocalDateTime localDateTime) {
        String SQL = "insert into Token (username, tokenHash, expiryDateTime) values (?, ?, ?)";

        try {
            jdbcOperations.update(SQL, username, hash, localDateTime.toString());
        }
        catch (Exception e) {
            log.info(e.getMessage());
        }
        log.info("Created Token Username = " + username + ", Hash = " + hash + " ExpiryDate = " + localDateTime);
        return;
    }

    public Token getToken(String username) {
        String SQL = "select * from Token where username = ? and activeStatus = 'active'";
        Token student = jdbcOperations.queryForObject(SQL,
                new Object[]{username}, new TokenRowMapper());
        return student;
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
            token.setExpiryDateTime(LocalDateTime.ofInstant(rs.getDate("expiryDateTime").toInstant(), ZoneId.systemDefault()));
            token.setTokenHash(rs.getString("tokenHash"));
            return token;
        }

    }

}