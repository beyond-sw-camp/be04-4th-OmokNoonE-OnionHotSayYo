package org.omoknoone.onionhotsayyo.post.controller;

import org.omoknoone.onionhotsayyo.post.dto.MyPostListDTO;
import org.omoknoone.onionhotsayyo.post.dto.WritePostDetailDTO;
import org.omoknoone.onionhotsayyo.post.service.PostService;
import org.omoknoone.onionhotsayyo.post.vo.ResponsePostDetail;
import org.omoknoone.onionhotsayyo.post.vo.ResponseMyPostList;
import org.omoknoone.onionhotsayyo.post.vo.ResponsePostListByCategory;
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
    public ResponseEntity<List<ResponsePostListByCategory>> viewPostListByCategory(@PathVariable String categoryId) {
        logger.info("카테고리별 게시글 목록 조회 요청: 카테고리 ID {}", categoryId);
        List<ResponsePostListByCategory> categoryPosts = postService.viewPostsByCategory(categoryId);
        logger.info("카테고리 ID {}에 대한 게시글 {}개 발견", categoryId, categoryPosts.size());

        return ResponseEntity.ok(categoryPosts);
    }

    // 게시글 상세 조회
    @GetMapping("/view/{postId}")
    public ResponseEntity<ResponsePostDetail> viewPostById(@PathVariable Integer postId) {
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
    public ResponseEntity<ResponsePostDetail> createPost(@RequestBody WritePostDetailDTO writePostDetailDTO) {
        logger.info("새 게시글 작성 요청: 제목 {}", writePostDetailDTO.getTitle());

        ResponsePostDetail response = postService.createPost(writePostDetailDTO);
        logger.info("게시글 생성 완료: 게시글 ID {}", response.getPostId());

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // 게시글 수정
    @PutMapping("/modify/{postId}")
    public ResponseEntity<ResponsePostDetail> modifyPost(@PathVariable Integer postId,
                                                         @RequestBody WritePostDetailDTO writePostDetailDTO) {
        logger.info("게시글 수정 요청: 게시글 ID {}", postId);

        ResponsePostDetail  updatedPost = postService.modifyPost(postId, writePostDetailDTO);
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
    public ResponseEntity<ResponseMyPostList> viewMyPosts(@PathVariable String memberId) {
        logger.info("나의 게시글 리스트 요청: 맴버 ID {}", memberId);
        List<MyPostListDTO> myPosts = postService.viewMyPosts(memberId);
        logger.info("나의 게시물 리스트 조회 완료 {}", myPosts);
        ResponseMyPostList myPostList = new ResponseMyPostList(myPosts);

        return ResponseEntity.ok(myPostList);
    }
}
