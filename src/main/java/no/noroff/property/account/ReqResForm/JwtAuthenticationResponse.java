package no.noroff.property.account.ReqResForm;

import lombok.Data;

import java.util.Map;

@Data
public class JwtAuthenticationResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private Map<String, Object> account;

    public JwtAuthenticationResponse(String accessToken, Map<String, Object>account) {
        this.accessToken = accessToken;
        this.account = account;

    }

    public JwtAuthenticationResponse() {

    }


    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}