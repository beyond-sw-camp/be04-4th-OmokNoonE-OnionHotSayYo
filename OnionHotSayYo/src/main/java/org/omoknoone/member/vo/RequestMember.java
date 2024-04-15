package org.omoknoone.member.vo;

public class RequestMember {
    private String memberId;
    private String nickname;
    private String password;
    private String email;
    private String profile;
    private String nationalityId;
    public RequestMember() {
    }

    public RequestMember(String memberId, String nickname, String password, String email, String profile, String nationalityId) {
        this.memberId = memberId;
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.profile = profile;
        this.nationalityId = nationalityId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(String nationalityId) {
        this.nationalityId = nationalityId;
    }

    @Override
    public String toString() {
        return "RequestMember{" +
                "memberId='" + memberId + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", profile='" + profile + '\'' +
                ", nationalityId='" + nationalityId + '\'' +
                '}';
    }
}
