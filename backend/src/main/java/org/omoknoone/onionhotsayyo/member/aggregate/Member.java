package org.omoknoone.onionhotsayyo.member.aggregate;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "member")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
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
    private String image;
    @Column
    @CreationTimestamp
    private String signUpDate;
    @Column(name = "IS_WITHDRAW")
    private boolean isWithdraw;
    @Column(name = "nationality_id")
    private String nationalityId;

}
