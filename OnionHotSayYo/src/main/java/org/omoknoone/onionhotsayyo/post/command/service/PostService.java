package org.omoknoone.onionhotsayyo.post.command.service;

import org.omoknoone.onionhotsayyo.post.command.aggregate.Post;

import java.util.List;

public interface PostService {

    //** 카테고리별 그시글 목록 조회
    List<Post> viewPostsByCategory(Integer categoryId);


}
