package org.omoknoone.onionhotsayyo.post.dto;

import lombok.*;


// 게시글 작성시에 작성자가 직접 입력해야 하는 데이터
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class WritePostDetailDTO {
    private String title;
    private String content;
    private String categoryId;
    private String image;
    private String locationId;
//    private String location;    // Location 엔티티로부터 location을 사용하기 위한 설정
}
