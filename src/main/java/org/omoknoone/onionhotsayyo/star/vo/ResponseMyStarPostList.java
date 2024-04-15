package org.omoknoone.onionhotsayyo.star.vo;

import lombok.Getter;
import org.omoknoone.onionhotsayyo.star.dto.MyStarPostListDTO;

import java.util.List;

@Getter
public class ResponseMyStarPostList {
    private final List<MyStarPostListDTO> mystarPosts;

    public ResponseMyStarPostList(List<MyStarPostListDTO> mystarPosts) {
        this.mystarPosts = mystarPosts;
    }
}
