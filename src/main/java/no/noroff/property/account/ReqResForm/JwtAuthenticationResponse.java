package no.noroff.property.account.ReqResForm;

import lombok.Data;
import no.noroff.property.account.Account;

import java.util.Optional;

@Data
public class JwtAuthenticationResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private Optional<Account> account;

    public JwtAuthenticationResponse(String accessToken, Optional<Account> account) {
        this.accessToken = accessToken;
        this.account = account;

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