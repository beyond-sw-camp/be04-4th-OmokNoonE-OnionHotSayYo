package org.omoknoone.onionhotsayyo.member.vo;

public class ResponseMember {
    private String memberId;
    private String nickname;
    private String email;

    public ResponseMember() {
    }

    public ResponseMember(String memberId, String nickname, String email) {
        this.memberId = memberId;
        this.nickname = nickname;
        this.email = email;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ResponseMember{" +
                "memberId='" + memberId + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
