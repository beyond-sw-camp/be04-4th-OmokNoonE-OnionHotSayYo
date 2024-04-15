package org.omoknoone.member.vo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class RequestSignUpMember {
    private String memberId;
    private String nickname;
    private String password;
    private String email;
    private String nationalityId;

}
