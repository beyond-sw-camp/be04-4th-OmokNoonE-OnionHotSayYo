package org.omoknoone.onionhotsayyo.post.command.dto;

import lombok.*;


// 게시글 작성시에 작성자가 직접 입력해야 하는 데이터
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class PostFormDTO {
    private String title;
    private String content;
    private String categoryId;
    private String image;
    private String location;    // Location 엔티티로부터 location을 사용하기 위한 설정


    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
