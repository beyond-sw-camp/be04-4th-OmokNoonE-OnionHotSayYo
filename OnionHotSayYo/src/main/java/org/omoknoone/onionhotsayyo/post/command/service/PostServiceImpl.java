package org.omoknoone.onionhotsayyo.post.command.service;

import org.modelmapper.ModelMapper;
import org.omoknoone.onionhotsayyo.post.command.aggregate.Post;
import org.omoknoone.onionhotsayyo.post.command.dto.PostFormDTO;
import org.omoknoone.onionhotsayyo.post.command.repository.PostRepository;
import org.omoknoone.onionhotsayyo.post.command.vo.PostDetailVO;
import org.omoknoone.onionhotsayyo.post.command.vo.PostSummaryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PostSummaryVO> viewPostsByCategory(String categoryId) {
        // Repository에서 Entity 리스트를 가져와 VO 리스트로 변환
        List<Post> posts = postRepository.findByCategoryId(categoryId);
        return posts.stream()
                .map(post -> modelMapper.map(post, PostSummaryVO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDetailVO viewPostById(Integer postId) {
        // Repository에서 Entity를 가져와 VO로 변환
        Post post = postRepository.findById(postId).orElse(null);
        return modelMapper.map(post, PostDetailVO.class);
    }

    @Override
    public PostFormDTO createPost(PostFormDTO postFormDTO) {
        // DTO를 Entity로 변환하여 저장
        Post post = modelMapper.map(postFormDTO, Post.class);
        Post savedPost = postRepository.save(post);
        return modelMapper.map(savedPost, PostFormDTO.class);
    }

    @Override
    public PostFormDTO modifyPost(Integer postId, PostFormDTO postFormDTO) {
        // ID를 기반으로 Entity를 조회하고, DTO의 내용으로 업데이트
        Post post = postRepository.findById(postId).orElse(null);
        if (post != null) {
            modelMapper.map(postFormDTO, post);
            Post updatedPost = postRepository.save(post);
            return modelMapper.map(updatedPost, PostFormDTO.class);
        }
        return null;
    }

    @Override
    public void removePost(Integer postId) {
        // 예시 로직: ID를 기반으로 Entity 삭제
        postRepository.deleteById(postId);
    }
}
