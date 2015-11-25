package com.revosoft.web.authentication.web.routing;


import com.revosoft.netty.server.http.routing.WebRouter;
import com.revosoft.web.database.repository.TokenRepository;
import com.revosoft.web.domain.Credentials;
import com.revosoft.web.domain.Token;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
public class AuthenticationWebRouter implements WebRouter {

        private TokenRepository tokenRepository;

        public Object routeRequest (String uri, String valueJson) throws IOException {

                if(uri.equals("/revoweb/authenticate")) {
                        ObjectMapper objectMapper = new ObjectMapper();
                        final Credentials credentials = objectMapper.readValue(valueJson, Credentials.class);

                        Token token = tokenRepository.getActiveUserToken(credentials.getUsername());
                        if(token!=null) {
                                return "{\n" +
                                        "\t\"Hash\" : \"" + token.getTokenHash() + "\"\n" +
                                        "}";
                        }
                        else {
                                final String newToken = UUID.randomUUID().toString();
                                tokenRepository.create(credentials.getUsername(),
                                        newToken, LocalDateTime.from(LocalDateTime.now()));

                                return "{\n" +
                                        "\t\"Hash\" : \"" + newToken + "\"\n" +
                                        "}";

                        }
                }

                return "No Services for this URI";
        }


        public String hashText(final String textToHash) {
                String generatedHash = null;
                try {
                        // Create MessageDigest instance for MD5
                        MessageDigest md = MessageDigest.getInstance("MD5");
                        //Add password bytes to digest
                        md.update(textToHash.getBytes());
                        //Get the hash's bytes
                        byte[] bytes = md.digest();
                        //This bytes[] has bytes in decimal format;
                        //Convert it to hexadecimal format
                        StringBuilder sb = new StringBuilder();
                        for(int i=0; i< bytes.length ;i++)
                        {
                                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
                        }
                        //Get complete hashed password in hex format
                        generatedHash = sb.toString();
                }
                catch (NoSuchAlgorithmException e)
                {
                        e.printStackTrace();
                }
                return generatedHash;
        }

        public String toString() {
        return "AuthenticationRouter";
    }

}
