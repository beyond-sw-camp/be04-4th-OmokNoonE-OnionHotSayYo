package org.omoknoone.onionhotsayyo.post.command.service;

import org.modelmapper.ModelMapper;
import org.omoknoone.onionhotsayyo.exceptions.PostNotFoundException;
import org.omoknoone.onionhotsayyo.member.dto.MemberDTO;
import org.omoknoone.onionhotsayyo.member.service.MemberService;
import org.omoknoone.onionhotsayyo.post.command.aggregate.Post;
import org.omoknoone.onionhotsayyo.post.command.dto.MyPostListDTO;
import org.omoknoone.onionhotsayyo.post.command.dto.PostFormDTO;
import org.omoknoone.onionhotsayyo.post.command.repository.PostRepository;
import org.omoknoone.onionhotsayyo.post.command.vo.PostDetailVO;
import org.omoknoone.onionhotsayyo.post.command.vo.PostSummaryVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private static final Logger log = LoggerFactory.getLogger(PostServiceImpl.class);
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;
    private final MemberService memberService;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper, MemberService memberService) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
        this.memberService = memberService;
    }

    @Transactional(readOnly = true)
    @Override
    public List<PostSummaryVO> viewPostsByCategory(String categoryId) {
        log.info("카테고리 ID {}에 해당하는 게시물 목록 조회를 시작합니다.", categoryId);
        List<Post> posts = postRepository.findByCategoryId(categoryId);
        List<PostSummaryVO> postSummaryVOList = posts.stream()
                .map(post -> modelMapper.map(post, PostSummaryVO.class))
                .collect(Collectors.toList());
        log.info("카테고리 ID {}에 해당하는 게시물 목록 조회를 완료했습니다. 조회된 게시물 수: {}", categoryId, postSummaryVOList.size());
        return postSummaryVOList;
    }

    @Transactional(readOnly = true)
    @Override
    public PostDetailVO viewPostById(Integer postId) {
        log.info("게시물 ID {}에 해당하는 게시물 상세 조회를 시작합니다.", postId);
        Post post = postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException("게시물 ID를 찾을 수 없습니다: " + postId));
        PostDetailVO postDetailVO = modelMapper.map(post, PostDetailVO.class);
        log.info("게시물 ID {}에 해당하는 게시물 상세 조회를 완료했습니다.", postId);
        return postDetailVO;
    }

    @Transactional
    @Override
    public PostFormDTO createPost(PostFormDTO postFormDTO) {
        log.info("새 게시물 생성을 시작합니다. 제목: {}", postFormDTO.getTitle());
        Post post = modelMapper.map(postFormDTO, Post.class);
        Post savedPost = postRepository.save(post);
        log.info("새 게시물이 성공적으로 생성되었습니다. 게시물 ID: {}", savedPost.getPostId());
        return modelMapper.map(savedPost, PostFormDTO.class);
    }

    @Transactional
    @Override
    public PostFormDTO modifyPost(Integer postId, PostFormDTO postFormDTO) {
        log.info("게시물 ID {} 수정을 시도합니다.", postId);
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException("게시물 ID를 찾을 수 없습니다: " + postId));

        log.info("게시물 ID {}에 해당하는 게시물을 찾았습니다. 수정을 진행합니다.", postId);
        modelMapper.map(postFormDTO, post);
        Post updatedPost = postRepository.save(post);
        log.info("게시물 ID {}이(가) 성공적으로 수정되었습니다.", postId);

        return modelMapper.map(updatedPost, PostFormDTO.class);
    }

    @Transactional
    @Override
    public void removePost(Integer postId) {
        log.info("게시물 ID {} (소프트)삭제를 시작합니다.", postId);
        postRepository.deleteById(postId);
        log.info("게시물 ID {}이(가) 성공적으로 삭제되었습니다.", postId);
    }

    @Transactional
    @Override
    public List<MyPostListDTO> viewMyPosts(String memberId) {
        MemberDTO member = memberService.getMemberDetailsByMemberId(memberId);
        if (member == null) {
            log.error("맴버 ID {} 를 찾을 수 없습니다.", memberId);
            throw new UsernameNotFoundException("맴버 ID " + memberId + " 를 찾을 수 없습니다.");
        }

        List<Post> posts = postRepository.findByMemberId(memberId);
        log.info("맴버 ID {} 확인 되었습니다.", memberId);
        return posts.stream()
                .map(post -> modelMapper.map(post, MyPostListDTO.class))
                .collect(Collectors.toList());
    }
}
