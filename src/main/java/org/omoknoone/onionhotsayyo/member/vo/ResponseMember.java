package org.omoknoone.onionhotsayyo.member.vo;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ResponseMember {
    private String memberId;
    private String nickname;
    private String email;
    private String profile;
    private String image;
}
