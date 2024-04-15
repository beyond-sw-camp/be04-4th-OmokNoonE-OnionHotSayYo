package org.omoknoone.post.vo;

import lombok.Getter;
import lombok.ToString;
import org.omoknoone.post.dto.MyBookmarkPostListDTO;

import java.util.List;

@Getter
@ToString
// 회원이 북마크한 게시물 목록 응답
public class ResponseMyBookmarkPostList {
    private final List<MyBookmarkPostListDTO> myBookmarkPosts;

    public ResponseMyBookmarkPostList(List<MyBookmarkPostListDTO> myBookmarkPosts) {
        this.myBookmarkPosts = myBookmarkPosts;
    }
}
