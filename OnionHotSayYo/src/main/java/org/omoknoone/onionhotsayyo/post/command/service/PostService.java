package org.omoknoone.onionhotsayyo.post.command.service;

import org.omoknoone.onionhotsayyo.post.command.dto.MyPostListDTO;
import org.omoknoone.onionhotsayyo.post.command.dto.PostFormDTO;
import org.omoknoone.onionhotsayyo.post.command.vo.PostDetailVO;
import org.omoknoone.onionhotsayyo.post.command.vo.PostSummaryVO;

import java.util.List;

public interface PostService {

    // 카테고리별 게시글 목록 조회
    List<PostSummaryVO> viewPostsByCategory(String categoryId);

    // 게시글 상세 조회
    PostDetailVO viewPostById(Integer postId);

    // 게시글 작성
    PostFormDTO createPost(PostFormDTO postFormDTO);

    // 게시글 수정
    PostFormDTO modifyPost(Integer postId, PostFormDTO postFormDTO);

    // 게시글 삭제
    void removePost(Integer postId);

    // 내가 작성한 게시글 목록 조회
    List<MyPostListDTO> viewMyPosts(String memberId);

//    // 내가 북마크한 게시글 목록 조회
//    List<Post> viewBookmarkedPosts(Integer userId);
//
//    // 내가 좋아요한 게시글 목록 조회
//    List<Post> viewLikedPosts(Integer userId);
//
//    // 언어별 게시글 (제목+내용) 검색 (상단 검색)
//    List<Post> searchPostsByLanguageAndText(String language, String text);
//
//    // 번역검색 허용 게시글 (제목+내용) 검색 (상단 검색)
//    List<Post> searchTranslatablePostsByText(String text);
//
//    // 카테고리 내 조건 검색
//    List<Post> searchPostsInCategoryWithCriteria(String categoryId, String criteriaType, String keyword, String location, String language);
}
