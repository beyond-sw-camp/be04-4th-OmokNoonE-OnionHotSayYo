package org.omoknoone.onionhotsayyo.member.aggregate;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash(value = "auth") // 60초
public class Auth {

    @Id
    private String id;
    @Indexed
    private String refreshToken;
    private String memberId;
    private boolean isExpired;

    public Auth() {
    }

    public Auth(String refreshToken, String memberId, boolean isExpired) {
        this.refreshToken = refreshToken;
        this.memberId = memberId;
        this.isExpired = isExpired;
    }

    public Auth(String id, String refreshToken, String memberId, boolean isExpired) {
        this.id = id;
        this.refreshToken = refreshToken;
        this.memberId = memberId;
        this.isExpired = isExpired;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    @Override
    public String toString() {
        return "Auth{" +
                "id=" + id +
                ", refreshToken='" + refreshToken + '\'' +
                ", memberId='" + memberId + '\'' +
                ", isExpired=" + isExpired +
                '}';
    }
}
