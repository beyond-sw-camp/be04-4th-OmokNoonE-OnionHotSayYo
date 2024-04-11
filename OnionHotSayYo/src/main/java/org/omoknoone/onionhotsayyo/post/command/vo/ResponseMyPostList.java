package org.omoknoone.onionhotsayyo.post.command.vo;

import org.omoknoone.onionhotsayyo.post.command.dto.MyPostListDTO;

import java.util.List;

public class ResponseMyPostList {
    private final List<MyPostListDTO> myPosts;

    public ResponseMyPostList(List<MyPostListDTO> myPosts) {
        this.myPosts = myPosts;
    }

    public List<MyPostListDTO> getMyPosts() {
        return myPosts;
    }

    @Override
    public String toString() {
        return "ResponseMyPosts{" +
                "myPosts=" + myPosts +
                '}';
    }
}

