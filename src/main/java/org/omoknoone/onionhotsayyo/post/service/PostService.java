package org.omoknoone.onionhotsayyo.post.service;

import org.omoknoone.onionhotsayyo.post.dto.MyBookmarkPostListDTO;
import org.omoknoone.onionhotsayyo.post.dto.MyPostListDTO;
import org.omoknoone.onionhotsayyo.post.dto.PostListByCategoryDTO;
import org.omoknoone.onionhotsayyo.post.dto.WritePostDetailDTO;
import org.omoknoone.onionhotsayyo.post.vo.ResponsePostDetail;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface PostService {

    // 카테고리별 게시글 목록 조회
    List<PostListByCategoryDTO> viewPostsByCategory(Integer categoryId);

    // 게시글 상세 조회
    ResponsePostDetail viewPostById(Integer postId);

    // 게시글 작성
    ResponsePostDetail createPost(WritePostDetailDTO writePostDetailDTO);

    // 게시글 수정
    ResponsePostDetail modifyPost(Integer postId, WritePostDetailDTO writePostDetailDTO);

    // 게시글 삭제
    void removePost(Integer postId);

    // 내가 작성한 게시글 목록 조회
    List<MyPostListDTO> viewMyPosts(String memberId);

//     내가 북마크한 게시글 목록 조회
    List<MyBookmarkPostListDTO> viewBookmarkedPosts(String memberId);

    // 카테고리별 상위 게시물 조회 (조회수 기준, 상위 5개 게시물)
    List<PostListByCategoryDTO> findTopPostsByCategory(Integer categoryId, LocalDate day, int limit);
//    // 언어별 게시글 (제목+내용) 검색 (상단 검색)
//    List<Post> searchPostsByLanguageAndText(String language, String text);
//
//    // 번역검색 허용 게시글 (제목+내용) 검색 (상단 검색)
//    List<Post> searchTranslatablePostsByText(String text);
//
//    // 카테고리 내 조건 검색
//    List<Post> searchPostsInCategoryWithCriteria(String categoryId, String criteriaType, String keyword, String location, String language);
}
