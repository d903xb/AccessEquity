package com.revosoft.web.domain;

import lombok.Data;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonAutoDetect;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Credentials {

    @Setter
    private String username;
    @Setter
    private String password;

}
