package org.omoknoone.onionhotsayyo.post.command.service;

import org.modelmapper.ModelMapper;
import org.omoknoone.onionhotsayyo.exceptions.BusinessRuleViolationException;
import org.omoknoone.onionhotsayyo.post.command.aggregate.Location;
import org.omoknoone.onionhotsayyo.post.command.aggregate.Post;
import org.omoknoone.onionhotsayyo.post.command.dto.PostFormDTO;
import org.omoknoone.onionhotsayyo.post.command.repository.LocationRepository;
import org.omoknoone.onionhotsayyo.post.command.vo.PostDetailVO;
import org.omoknoone.onionhotsayyo.post.command.vo.PostSummaryVO;
import org.omoknoone.onionhotsayyo.post.command.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final LocationRepository locationRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, LocationRepository locationRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.locationRepository = locationRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional(readOnly = true)
    @Override
    public List<PostSummaryVO> viewPostsByCategory(String categoryId) {

        // PostRepository 를 사용하여 특정 카테고리에 속하는 게시물 조회.
        List<Post> posts = postRepository.findByCategoryId(categoryId);

        // 조회된 Post 엔티티 목록을 PostSummaryVO(게시물 목록)로 반환
        return posts.stream()
                .map(post -> modelMapper.map(post, PostSummaryVO.class))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public PostDetailVO viewPostById(Integer postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() ->
                        new BusinessRuleViolationException("게시글 ID " + postId + " 는 존재하지 않습니다!(ㅠ.ㅠ)."));

        return modelMapper.map(post, PostDetailVO.class);
    }

    @Transactional
    @Override
    public PostFormDTO createPost(PostFormDTO postFormDTO) {

        // PostFormDTO에서 Post 엔티티로 변환. Location은 별도로 처리.
        Post post = modelMapper.map(postFormDTO, Post.class);

        // 지역 이름으로 Location 엔티티 조회
        Location location = locationRepository.findByLocation(postFormDTO.getLocation());
        post.setLocation(location); // Post 엔티티에 Location 설정

        // 작성된 게시글 저장
        Post savedPost = postRepository.save(post);

        // 저장된 Post 엔티티를 PostFormDTO로 변환하여 반환
        return modelMapper.map(savedPost, PostFormDTO.class);
    }

    @Transactional
    @Override
    public PostFormDTO modifyPost(Integer postId, PostFormDTO postFormDTO) {
        Post existingPost = postRepository.findById(postId)
                .orElseThrow(() ->
                        new BusinessRuleViolationException("게시글 ID " + postId + "에 해당하는 게시글이 아니군요!."));

        // PostFormDTO에서 제공하는 정보를 기반으로 기존 Post 엔티티 수정
        existingPost.setTitle(postFormDTO.getTitle());
        existingPost.setContent(postFormDTO.getContent());
        existingPost.setCategoryId(postFormDTO.getCategoryId());
        existingPost.setImage(postFormDTO.getImage());

        // 지역명으로 Location 정보 업데이트 처리
        Location location = locationRepository.findByLocation(postFormDTO.getLocation());
        existingPost.setLocation(location);

        // 수정된 게시물 저장
        Post modifiedPost = postRepository.save(existingPost);

        // 저장된 Post 엔티티를 PostFormDTO로 변환하여 반환
        return modelMapper.map(modifiedPost, PostFormDTO.class);
    }

    @Transactional
    @Override
    public void removePost(Integer postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() ->
                        new BusinessRuleViolationException("게시글 ID " + postId + "은 이미 삭제된 게시글입니다."));

        // 게시물을 소프트 삭제 처리
        post.setDeleted(true);
        postRepository.save(post);
    }
}
