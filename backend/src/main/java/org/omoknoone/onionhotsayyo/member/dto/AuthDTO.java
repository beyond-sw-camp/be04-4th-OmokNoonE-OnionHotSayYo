package org.omoknoone.onionhotsayyo.member.dto;

public class AuthDTO {
    private Long id;
    private String refreshToken;
    private String memberId;
    private boolean isExpired;

    public AuthDTO() {
    }

    public AuthDTO(Long id, String refreshToken, String memberId, boolean isExpired) {
        this.id = id;
        this.refreshToken = refreshToken;
        this.memberId = memberId;
        this.isExpired = isExpired;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }
}
