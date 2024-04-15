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

        List<PostListByCategoryDTO> CategoryPostList = posts.stream()
                .map(post -> modelMapper.map(post, PostListByCategoryDTO.class))
                .collect(Collectors.toList());
        log.info("카테고리 ID {}에 해당하는 게시물 목록 조회를 완료했습니다." +
                " 조회된 게시물 수: {}", categoryId, CategoryPostList.size());

        return CategoryPostList;
    }

    @Transactional(readOnly = true)
    @Override
    public ResponsePostDetail viewPostById(Integer postId) {
        log.info("게시물 ID {}에 해당하는 게시물 상세 조회를 시작합니다.", postId);

        Post post = postRepository.findById(postId).orElseThrow(()
                -> new PostNotFoundException("게시물 ID를 찾을 수 없습니다: " + postId));

        ResponsePostDetail responsePostDetail = modelMapper.map(post, ResponsePostDetail.class);
        log.info("게시물 ID {}에 해당하는 게시물 상세 조회를 완료했습니다.", postId);
        return responsePostDetail;
    }

    @Transactional
    @Override
    public ResponsePostDetail createPost(WritePostDetailDTO writePostDetailDTO) {
        log.info("새 게시물 생성을 시작합니다. 제목: {}", writePostDetailDTO.getTitle());

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Post post = modelMapper.map(writePostDetailDTO, Post.class);

        Post newPost = postRepository.save(post);
        log.info("새 게시물이 성공적으로 생성되었습니다. 게시물 ID: {}", newPost.getPostId());

        return modelMapper.map(newPost, ResponsePostDetail.class);
    }

    @Transactional
    @Override
    public ResponsePostDetail modifyPost(Integer postId, WritePostDetailDTO writePostDetailDTO) {
        log.info("게시물 ID {} 수정을 시도합니다.", postId);
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException("게시물 ID를 찾을 수 없습니다: " + postId));

        log.info("게시물 ID {}에 해당하는 게시물을 찾았습니다. 수정을 진행합니다.", postId);
        modelMapper.map(writePostDetailDTO, post);
        Post updatedPost = postRepository.save(post);
        log.info("게시물 ID {}이(가) 성공적으로 수정되었습니다.", postId);

        return modelMapper.map(updatedPost, ResponsePostDetail.class);
    }

    @Transactional
    @Override
    public void removePost(Integer postId) {
        log.info("게시물 ID {} (소프트)삭제를 시작합니다.", postId);

        postRepository.deleteById(postId);
        log.info("게시물 ID {}이(가) 성공적으로 삭제되었습니다.", postId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<MyPostListDTO> viewMyPosts(String memberId) {
        MemberDTO member = memberService.getMemberDetailsByMemberId(memberId);
        if (member == null) {
            log.error("맴버 ID {} 를 찾을 수 없습니다.", memberId);
            throw new UsernameNotFoundException("맴버 ID " + memberId + " 를 찾을 수 없습니다.");
        }

        List<Post> posts = postRepository.findByMemberId(memberId);
        log.info("맴버 ID: {} 확인 되었습니다.", memberId);

        return posts.stream()
                .map(post -> modelMapper.map(post, MyPostListDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public List<MyBookmarkPostListDTO> viewBookmarkedPosts(String memberId) {
        log.info("회원 ID {}의 북마크한 게시물 목록 조회를 시작합니다.", memberId);

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

        log.info("bookmark Service로부터 회원 ID {}에 대한 북마크한 게시물 목록 조회가 완료되었습니다. 조회된 게시물 수: {}"
                , memberId, bookmarkedPostList.size());

        return bookmarkedPostList;
    }

    @Transactional(readOnly = true)
    @Scheduled(cron = "0 0 0 * * ?") // 매일 자정에 실행
    @Override
    public List<PostListByCategoryDTO> findHotPostsByCategory(String categoryId) {
        return postRepository.findTopPostsByCategory(categoryId, PageRequest.of(0, 5))
                .stream()
                .map(post -> modelMapper.map(post, PostListByCategoryDTO.class))
                .collect(Collectors.toList());
    }
}
