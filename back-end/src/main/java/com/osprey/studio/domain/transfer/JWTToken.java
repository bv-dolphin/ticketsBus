package com.osprey.studio.domain.transfer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Setter;

/**
 * Object to return as body in JWT Authentication.
 */
@AllArgsConstructor
@Setter
public class JWTToken {

    private String idToken;

    @JsonProperty("id_token")
    String getIdToken() {
        return this.idToken;
    }

}

