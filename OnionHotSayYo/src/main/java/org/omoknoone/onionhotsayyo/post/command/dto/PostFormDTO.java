package org.omoknoone.onionhotsayyo.post.command.dto;

import org.omoknoone.onionhotsayyo.post.command.aggregate.Location;


// 게시글 작성시에 작성자가 직접 입력해야 하는 데이터
public class PostFormDTO {
    private String title;
    private String content;
    private String categoryId;
    private String image;
    private String location;    // Location 엔티티로부터 location을 사용하기 위한 설정

    public PostFormDTO() {
    }

    public PostFormDTO(String title, String content, String categoryId, String image, String location) {
        this.title = title;
        this.content = content;
        this.categoryId = categoryId;
        this.image = image;
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "PostDetailDTO{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", image='" + image + '\'' +
                ", location=" + location +
                '}';
    }
}
