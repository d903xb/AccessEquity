package com.revosoft.web.domain;

import lombok.Data;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonAutoDetect;

import java.time.LocalDateTime;


@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Token {

    @Setter
    private String userId;

    @Setter
    private String tokenHash;

    @Setter
    private LocalDateTime expiryDateTime;

}
