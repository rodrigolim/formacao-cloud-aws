package br.com.api.payload;

import lombok.Data;

@Data
public class JwtResponse {
    private String access_token;
    private String token_type = "Bearer";
    private Long id;
    private String username;

    public JwtResponse(String accessToken, Long id, String username) {
        this.access_token = accessToken;
        this.id = id;
        this.username = username;
    }

}
