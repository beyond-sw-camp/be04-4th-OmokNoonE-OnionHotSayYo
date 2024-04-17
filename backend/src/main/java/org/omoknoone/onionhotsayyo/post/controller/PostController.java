package org.omoknoone.onionhotsayyo.post.controller;

import org.omoknoone.onionhotsayyo.post.dto.SearchTranslatedPostListDTO;
import org.omoknoone.onionhotsayyo.post.service.PostService;
import org.omoknoone.onionhotsayyo.post.dto.MyBookmarkPostListDTO;
import org.omoknoone.onionhotsayyo.post.dto.MyPostListDTO;
import org.omoknoone.onionhotsayyo.post.dto.PostListByCategoryDTO;
import org.omoknoone.onionhotsayyo.post.dto.WritePostDetailDTO;
import org.omoknoone.onionhotsayyo.post.vo.ResponseMyBookmarkPostList;
import org.omoknoone.onionhotsayyo.post.vo.ResponsePostDetail;
import org.omoknoone.onionhotsayyo.post.vo.ResponseMyPostList;
import org.omoknoone.onionhotsayyo.post.vo.ResponsePostListByCategory;
import org.omoknoone.onionhotsayyo.post.vo.ResponseSearchTranslatedPostList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 카테고리별 게시글 목록 조회
    @GetMapping("/list/{categoryId}")
    public ResponseEntity<ResponsePostListByCategory> viewPostList(@PathVariable Integer categoryId) {
        logger.info("카테고리별 게시글 목록 조회 요청: 카테고리 ID {}", categoryId);

        List<PostListByCategoryDTO> categoryPosts = postService.viewPostsByCategory(categoryId);

        logger.info("카테고리 ID {}에 대한 게시글 {}건 발견", categoryId, categoryPosts.size());
        ResponsePostListByCategory myPostList = new ResponsePostListByCategory(categoryPosts);

        return ResponseEntity.ok(myPostList);
    }

    // 게시글 상세 조회
    @GetMapping("/view/{postId}")
    public ResponseEntity<ResponsePostDetail> viewPost(@PathVariable Integer postId) {
        logger.info("게시글 상세 조회 요청: 게시글 ID {}", postId);
        ResponsePostDetail postDetail = postService.viewPostById(postId);
        if (postDetail == null) {
            logger.error("게시글 ID {}에 해당하는 게시글을 찾을 수 없음", postId);
            return ResponseEntity.notFound().build();
        }

        logger.info("게시글 ID {}에 해당하는 게시글 찾음", postId);
        return ResponseEntity.ok(postDetail);
    }

    // 게시글 작성
    @PostMapping("/create")
    public ResponseEntity<ResponsePostDetail> createPost(@ModelAttribute WritePostDetailDTO writePostDetailDTO) {
        logger.info("새 게시글 작성 요청: 제목 - {}", writePostDetailDTO.getTitle());

        ResponsePostDetail response = postService.createPost(writePostDetailDTO);
        logger.info("게시글 생성 완료: 게시글 ID {}", response.getPostId());

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // 게시글 수정
    @PutMapping("/modify/{postId}")
    public ResponseEntity<ResponsePostDetail> modifyPost(@PathVariable Integer postId,
        @RequestBody WritePostDetailDTO writePostDetailDTO) {
        logger.info("게시글 수정 요청: 게시글 ID {}", postId);

        ResponsePostDetail updatedPost = postService.modifyPost(postId, writePostDetailDTO);
        if (updatedPost == null) {
            logger.error("게시글 ID {}를 찾을 수 없어 수정 불가", postId);
            return ResponseEntity.notFound().build();
        }
        logger.info("게시글 ID {} 수정 완료", postId);

        return ResponseEntity.ok(updatedPost);
    }

    // 게시글 삭제
    @DeleteMapping("/remove/{postId}")
    public ResponseEntity<Void> removePost(@PathVariable Integer postId) {
        logger.info("게시글 삭제 요청: 게시글 ID {}", postId);

        postService.removePost(postId);
        logger.info("게시글 ID {} 삭제 완료", postId);

        return ResponseEntity.noContent().build();
    }

    // 내가 작성한 게시글 목록 조회
    @GetMapping("/list/mypost/{memberId}")
    public ResponseEntity<ResponseMyPostList> viewMyPostListByMe(@PathVariable String memberId) {
        logger.info("나의 게시글 리스트 요청, 회원 ID: {}", memberId);

        List<MyPostListDTO> myPosts = postService.viewMyPosts(memberId);
        logger.info("회원 {}(이)가 작성한 게시글 {}건 발견", memberId, myPosts.size());

        ResponseMyPostList myPostList = new ResponseMyPostList(myPosts);

        return ResponseEntity.ok(myPostList);
    }

    // 내가 북마크한 게시글 목록 조회
    @GetMapping("/list/mybookmark/{memberId}")
    public ResponseEntity<ResponseMyBookmarkPostList> viewPostListByBookmark(@PathVariable String memberId) {
        logger.info("나의 북마크된 게시글 리스트 요청, 회원 ID: {}", memberId);

        List<MyBookmarkPostListDTO> myBookmarkedPosts = postService.viewBookmarkedPosts(memberId);
        if (myBookmarkedPosts.isEmpty()) {
            logger.info("회원 ID {}에 대한 북마크된 게시글이 없습니다.", memberId);
            return ResponseEntity.noContent().build();
        }
        logger.info("회원 ID {}에 대한 북마크된 게시글 리스트 조회 완료. 조회된 게시글 수 {}건 발견", memberId, myBookmarkedPosts.size());

        ResponseMyBookmarkPostList myBookmarkList = new ResponseMyBookmarkPostList(myBookmarkedPosts);
        return ResponseEntity.ok(myBookmarkList);
    }

    // 상단 검색바 게시글 검색
    @GetMapping("/search/{title}")
    public ResponseEntity<ResponseSearchTranslatedPostList> searchPost(
        @PathVariable String title,
        @RequestParam(required = false) String language
    ) {

        if (language == null) {
            logger.info("기본 검색");
            List<SearchTranslatedPostListDTO> searchResultPosts = postService.searchPost(title);
            ResponseSearchTranslatedPostList myPostList = new ResponseSearchTranslatedPostList(searchResultPosts);
            logger.info("게시글 발견");
            logger.info(myPostList.toString());
            return ResponseEntity.ok(myPostList);
        }

        else{
            logger.info("번역 결과 언어: " + language);
            List<SearchTranslatedPostListDTO> searchResultPosts = postService.searchTranslationPost(title, language);

            ResponseSearchTranslatedPostList myPostList = new ResponseSearchTranslatedPostList(searchResultPosts);
            logger.info("게시글 발견");

            return ResponseEntity.ok(myPostList);
        }
    }
}
