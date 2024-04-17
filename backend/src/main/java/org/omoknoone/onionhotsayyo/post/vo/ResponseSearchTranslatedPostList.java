package org.omoknoone.onionhotsayyo.post.vo;

import java.util.List;

import org.omoknoone.onionhotsayyo.post.dto.SearchTranslatedPostListDTO;

import lombok.Getter;
import lombok.ToString;
// 본인이 작성한 게시물 목록 응답
@Getter
@ToString
public class ResponseSearchTranslatedPostList {
    private final List<SearchTranslatedPostListDTO> SearchTranslatedPosts;

    public ResponseSearchTranslatedPostList(List<SearchTranslatedPostListDTO> searchTranslatedPosts) {
        SearchTranslatedPosts = searchTranslatedPosts;
    }
}

