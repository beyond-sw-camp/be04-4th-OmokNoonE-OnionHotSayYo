package org.omoknoone.onionhotsayyo.post.vo;

import lombok.Getter;
import lombok.ToString;
import org.omoknoone.onionhotsayyo.post.dto.MyPostListDTO;

import java.util.List;

@Getter
@ToString
// 본인이 작성한 게시물 리스트 응답
public class ResponseMyPostList {
    private final List<MyPostListDTO> myPosts;

    public ResponseMyPostList(List<MyPostListDTO> myPosts) {
        this.myPosts = myPosts;
    }

}

