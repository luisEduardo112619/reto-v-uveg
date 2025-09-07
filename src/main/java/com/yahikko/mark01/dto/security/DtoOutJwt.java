package com.yahikko.mark01.dto.security;

import lombok.Data;

import static com.yahikko.mark01.util.Enums.JSON_WEB_TOKEN_TYPE_BEARER;

@Data
public class DtoOutJwt {
    private String token;
    private String type;
    private Long id;
    private String email;
    private String rol;

    public  DtoOutJwt(String token, Long id, String email, String rol){
        this.token = token;
        this.type =  JSON_WEB_TOKEN_TYPE_BEARER;
        this.id = id;
        this.email = email;
        this.rol = rol;
    }
}
