package com.example.Truper.Model.DTO;

public class ResponseRequest {
    private String jwtToken;

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public ResponseRequest(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
