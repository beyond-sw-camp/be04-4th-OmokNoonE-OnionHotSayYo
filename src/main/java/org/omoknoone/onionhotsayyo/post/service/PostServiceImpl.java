package org.omoknoone.onionhotsayyo.post.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.omoknoone.onionhotsayyo.bookmark.aggregate.Bookmark;
import org.omoknoone.onionhotsayyo.bookmark.service.BookmarkService;
import org.omoknoone.onionhotsayyo.exceptions.PostNotFoundException;
import org.omoknoone.onionhotsayyo.member.dto.MemberDTO;
import org.omoknoone.onionhotsayyo.member.service.MemberService;
import org.omoknoone.onionhotsayyo.post.aggregate.Post;
import org.omoknoone.onionhotsayyo.post.dto.MyBookmarkPostListDTO;
import org.omoknoone.onionhotsayyo.post.dto.MyPostListDTO;
import org.omoknoone.onionhotsayyo.post.dto.PostListByCategoryDTO;
import org.omoknoone.onionhotsayyo.post.dto.WritePostDetailDTO;
import org.omoknoone.onionhotsayyo.post.repository.PostRepository;
import org.omoknoone.onionhotsayyo.post.vo.ResponsePostDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private static final Logger log = LoggerFactory.getLogger(PostServiceImpl.class);
    private final ModelMapper modelMapper;
    private final PostRepository postRepository;
    private final MemberService memberService;
    private final BookmarkService bookmarkService;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper, MemberService memberService, BookmarkService bookmarkService) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
        this.memberService = memberService;
        this.bookmarkService = bookmarkService;
    }

    @Transactional(readOnly = true)
    @Override
    public List<PostListByCategoryDTO> viewPostsByCategory(Integer categoryId) {
        log.info("카테고리 ID {}에 해당하는 게시물 목록 조회를 시작합니다.", categoryId);

        List<Post> posts = postRepository.findByCategoryId(categoryId);

        List<PostListByCategoryDTO> categoryPostList = posts.stream()
                .map(post -> modelMapper.map(post, PostListByCategoryDTO.class))
                .collect(Collectors.toList());
        log.info("카테고리 ID {} 조회 완료, 총 {}건의 게시글 발견", categoryId, categoryPostList.size());

        return categoryPostList;
    }

    @Transactional(readOnly = true)
    @Override
    public ResponsePostDetail viewPostById(Integer postId) {
        log.info("게시글 ID {} 상세 조회 시작", postId);

        Post post = postRepository.findById(postId).orElseThrow(()
                -> new PostNotFoundException("게시글 ID " + postId + "를 찾을 수 없습니다."));

        ResponsePostDetail responsePostDetail = modelMapper.map(post, ResponsePostDetail.class);
        log.info("게시글 ID {} 상세 조회 완료", postId);
        return responsePostDetail;
    }

    @Transactional
    @Override
    public ResponsePostDetail createPost(WritePostDetailDTO writePostDetailDTO) {
        log.info("새 게시물 생성을 시작, 제목: {}", writePostDetailDTO.getTitle());

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Post post = modelMapper.map(writePostDetailDTO, Post.class);

        Post newPost = postRepository.save(post);
        log.info("새 게시물이 성공적으로 생성, 게시물 ID: {}", newPost.getPostId());

        return modelMapper.map(newPost, ResponsePostDetail.class);
    }

    @Transactional
    @Override
    public ResponsePostDetail modifyPost(Integer postId, WritePostDetailDTO writePostDetailDTO) {
        log.info("게시물 ID {} 수정을 시작.", postId);
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException("게시글 ID " + postId + "를 찾을 수 없습니다."));

        log.info("게시물 ID {}에 해당하는 게시물 발견, 수정을 진행합니다.", postId);
        modelMapper.map(writePostDetailDTO, post);
        Post updatedPost = postRepository.save(post);
        log.info("게시물 ID {} 수정 완료.", postId);

        return modelMapper.map(updatedPost, ResponsePostDetail.class);
    }

    @Transactional
    @Override
    public void removePost(Integer postId) {
        log.info("게시물 ID {} 삭제 시작.", postId);

        postRepository.deleteById(postId);
        log.info("게시물 ID {} 삭제 완료.", postId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<MyPostListDTO> viewMyPosts(String memberId) {
        log.info("회원 ID {}의 게시글 목록 조회 시작", memberId);

        MemberDTO member = memberService.getMemberDetailsByMemberId(memberId);
        if (member == null) {
            log.error("회원 ID {} 를 찾을 수 없습니다.", memberId);
            throw new UsernameNotFoundException("회원 ID " + memberId + " 를 찾을 수 없습니다.");
        }

        List<Post> posts = postRepository.findByMemberId(memberId);
        log.info("회원 ID {}의 게시글 {}건 발견.", memberId, posts.size());

        return posts.stream()
                .map(post -> modelMapper.map(post, MyPostListDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public List<MyBookmarkPostListDTO> viewBookmarkedPosts(String memberId) {
        log.info("회원 ID {}의 북마크한 게시물 목록 조회 시작.", memberId);

// BookmarkService를 사용하여 북마크된 게시물 목록을 조회
        List<Bookmark> bookmarks = bookmarkService.findBookmarkSByMemberId(memberId);
        if (bookmarks.isEmpty()) {
            log.warn("회원 ID {}에 대한 북마크한 게시물이 없습니다.", memberId);
            throw new PostNotFoundException("북마크한 게시물이 없습니다.");
        }

        // 북마크된 게시물의 ID 목록 추출
        List<Integer> bookmarkedPostIds = bookmarks.stream()
                .map(Bookmark::getPostId)  // Bookmark 객체에서 postId를 추출
                .collect(Collectors.toList());

        // 조회된 게시물 ID로 게시물 정보를 조회
        List<Post> bookmarkedPosts = postRepository.findAllById(bookmarkedPostIds);
        List<MyBookmarkPostListDTO> bookmarkedPostList = bookmarkedPosts.stream()
                .map(post -> modelMapper.map(post, MyBookmarkPostListDTO.class))
                .collect(Collectors.toList());

        log.info("bookmark Service로부터 회원 ID {}가 북마크한 게시물 목록 조회 완료. 조회된 게시물 수: {}"
                , memberId, bookmarkedPostList.size());

        return bookmarkedPostList;
    }

    @Transactional(readOnly = true)
    @Override
    public List<PostListByCategoryDTO> findTopPostsByCategory(Integer categoryId, int limit) {
        log.info("카테고리 ID {} 기준 상위 {}개 게시물 조회 시작", categoryId, limit);

        List<Post> posts = postRepository.findTopPostsByCategory(categoryId, PageRequest.of(0, limit));
        List<PostListByCategoryDTO> topPostsByCategory = posts.stream()
                .map(post -> modelMapper.map(post, PostListByCategoryDTO.class))
                .collect(Collectors.toList());
        log.info("카테고리 ID {}에서 조회된 상위 게시물 수: {}", categoryId, topPostsByCategory.size());

        return topPostsByCategory;
    }
}
