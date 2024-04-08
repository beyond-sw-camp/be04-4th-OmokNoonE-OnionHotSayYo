package org.omoknoone.onionhotsayyo.member.aggregate;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "member")
public class Member {

    @Id
    @Column
    private String memberId;
    @Column
    private String nickname;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private String profile;
    @Column
    @CreationTimestamp
    private String signUpDate;
    @Column(name = "IS_WITHDRAW")
    private boolean isWithdraw;

    @JoinColumn(name = "nationality_id")
    @OneToOne
    private Nationality nationalityId;

    public Member() {
    }

    public Member(String memberId, String nickname, String password, String email, String profile, String signUpDate, boolean isWithdraw, Nationality nationalityId) {
        this.memberId = memberId;
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.profile = profile;
        this.signUpDate = signUpDate;
        this.isWithdraw = isWithdraw;
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

    public String getSignUpDate() {
        return signUpDate;
    }

    public void setSignUpDate(String signUpDate) {
        this.signUpDate = signUpDate;
    }

    public boolean isWithdraw() {
        return isWithdraw;
    }

    public void setWithdraw(boolean withdraw) {
        isWithdraw = withdraw;
    }

    public Nationality getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(Nationality nationalityId) {
        this.nationalityId = nationalityId;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", profile='" + profile + '\'' +
                ", signUpDate='" + signUpDate + '\'' +
                ", isWithdraw=" + isWithdraw +
                ", nationalityId=" + nationalityId +
                '}';
    }
}
