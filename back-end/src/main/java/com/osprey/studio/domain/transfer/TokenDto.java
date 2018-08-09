package com.osprey.studio.domain.transfer;

import com.osprey.studio.domain.entities.Token;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class TokenDto {
    private String tokenSession;

    public static TokenDto from(Token token) {
        return new TokenDto(token.getTokenSession());
    }

}
