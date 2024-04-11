package org.omoknoone.onionhotsayyo.post.command.controller;

import org.omoknoone.onionhotsayyo.post.command.dto.MyPostListDTO;
import org.omoknoone.onionhotsayyo.post.command.dto.PostFormDTO;
import org.omoknoone.onionhotsayyo.post.command.service.PostService;
import org.omoknoone.onionhotsayyo.post.command.vo.PostDetailVO;
import org.omoknoone.onionhotsayyo.post.command.vo.PostSummaryVO;
import org.omoknoone.onionhotsayyo.post.command.vo.ResponseMyPostList;
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
    public ResponseEntity<List<PostSummaryVO>> viewPostListByCategory(@PathVariable String categoryId) {
        logger.info("카테고리별 게시글 목록 조회 요청: 카테고리 ID {}", categoryId);
        List<PostSummaryVO> posts = postService.viewPostsByCategory(categoryId);
        logger.info("카테고리 ID {}에 대한 게시글 {}개 발견", categoryId, posts.size());

        return ResponseEntity.ok(posts);
    }

    // 게시글 상세 조회
    @GetMapping("/view/{postId}")
    public ResponseEntity<PostDetailVO> viewPostById(@PathVariable Integer postId) {
        logger.info("게시글 상세 조회 요청: 게시글 ID {}", postId);
        PostDetailVO postDetail = postService.viewPostById(postId);
        if (postDetail == null) {
            logger.error("게시글 ID {}에 해당하는 게시글을 찾을 수 없음", postId);
            return ResponseEntity.notFound().build();
        }

        logger.info("게시글 ID {}에 해당하는 게시글 찾음", postId);
        return ResponseEntity.ok(postDetail);
    }

    // 게시글 작성
    @PostMapping("/create")
    public ResponseEntity<PostFormDTO> createPost(@RequestBody PostFormDTO postFormDTO) {
        logger.info("새 게시글 작성 요청: 제목 {}", postFormDTO.getTitle());
        PostFormDTO createdPost = postService.createPost(postFormDTO);
        logger.info("게시글 생성 완료: 게시글 ID {}", createdPost.getTitle());

        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    // 게시글 수정
    @PutMapping("/modify/{postId}")
    public ResponseEntity<PostFormDTO> modifyPost(@PathVariable Integer postId, @RequestBody PostFormDTO postFormDTO) {
        logger.info("게시글 수정 요청: 게시글 ID {}", postId);
        PostFormDTO updatedPost = postService.modifyPost(postId, postFormDTO);
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
        logger.info("나의 게시물 리스트 조회 완료 {}", memberId);
        ResponseMyPostList myPostList = new ResponseMyPostList(myPosts);

        return ResponseEntity.ok(myPostList);
    }
}
