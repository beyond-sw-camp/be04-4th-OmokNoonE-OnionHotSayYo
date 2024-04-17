package org.omoknoone.onionhotsayyo.post.vo;

import lombok.Getter;
import lombok.ToString;
import org.omoknoone.onionhotsayyo.post.dto.MyPostListDTO;

import java.util.List;

// 본인이 작성한 게시물 목록 응답
@Getter
@ToString
public class ResponseMyPostList {
    private final List<MyPostListDTO> myPosts;

    public ResponseMyPostList(List<MyPostListDTO> myPosts) {
        this.myPosts = myPosts;
    }

}

