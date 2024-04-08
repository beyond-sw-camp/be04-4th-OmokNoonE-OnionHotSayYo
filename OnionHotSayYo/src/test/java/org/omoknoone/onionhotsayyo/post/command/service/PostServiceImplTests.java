package org.omoknoone.onionhotsayyo.post.command.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.omoknoone.onionhotsayyo.post.command.aggregate.Post;
import org.omoknoone.onionhotsayyo.post.command.dto.PostFormDTO;
import org.omoknoone.onionhotsayyo.post.command.repository.PostRepository;
import org.omoknoone.onionhotsayyo.post.command.vo.PostDetailVO;
import org.omoknoone.onionhotsayyo.post.command.vo.PostSummaryVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)

public class PostServiceImplTests {
    @Mock
    private PostRepository postRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private PostServiceImpl postService;

    @Test
    void whenViewPostsByCategory_thenReturnsPostSummaryList() {
        // Arrange
        String categoryId = "testCategory";
        List<Post> posts = new ArrayList<>();
        posts.add(new Post());
        when(postRepository.findByCategoryId(categoryId)).thenReturn(posts);
        when(modelMapper.map(any(Post.class), eq(PostSummaryVO.class))).thenReturn(new PostSummaryVO());

        // Act
        List<PostSummaryVO> result = postService.viewPostsByCategory(categoryId);

        // Assert
        assertFalse(result.isEmpty());
    }

    @Test
    void whenViewPostById_thenReturnsPostDetail() {
        // Arrange
        Integer postId = 1;
        Post post = new Post();
        when(postRepository.findById(postId)).thenReturn(Optional.of(post));
        when(modelMapper.map(any(Post.class), eq(PostDetailVO.class))).thenReturn(new PostDetailVO());

        // Act
        PostDetailVO result = postService.viewPostById(postId);

        // Assert
        assertNotNull(result);
    }

    @Test
    void whenCreatePost_thenReturnsPostFormDTO() {
        // Arrange
        PostFormDTO postFormDTO = new PostFormDTO();
        Post post = new Post();
        when(modelMapper.map(any(PostFormDTO.class), eq(Post.class))).thenReturn(post);
        when(postRepository.save(any(Post.class))).thenReturn(post);
        when(modelMapper.map(any(Post.class), eq(PostFormDTO.class))).thenReturn(postFormDTO);

        // Act
        PostFormDTO result = postService.createPost(postFormDTO);

        // Assert
        assertNotNull(result);
    }

    @Test
    void whenModifyPost_thenReturnsUpdatedPostFormDTO() {
//        // Arrange
//        Integer postId = 1;
//        PostFormDTO postFormDTO = new PostFormDTO();
//        postFormDTO.setTitle("Updated Title");
//        Post existingPost = new Post(); // 가정: 기존 Post 엔티티
//        Post updatedPost = new Post(); // 가정: 업데이트 후 Post 엔티티
//        when(postRepository.findById(postId)).thenReturn(Optional.of(existingPost));
//        when(modelMapper.map(any(PostFormDTO.class), eq(Post.class))).thenReturn(updatedPost);
//        when(postRepository.save(any(Post.class))).thenReturn(updatedPost);
//        when(modelMapper.map(any(Post.class), eq(PostFormDTO.class))).thenReturn(new PostFormDTO());
//
//        // Act
//        PostFormDTO result = postService.modifyPost(postId, postFormDTO);
//
//        // Assert
//        assertNotNull(result);

        // Arrange
        Integer postId = 1;
        PostFormDTO postFormDTO = new PostFormDTO();
        postFormDTO.setTitle("Updated Title");
        Post existingPost = new Post(); // 가정: 기존 Post 엔티티
        Post updatedPost = new Post(); // 가정: 업데이트 후 Post 엔티티
        when(postRepository.findById(postId)).thenReturn(Optional.of(existingPost));
        when(modelMapper.map(postFormDTO, Post.class)).thenReturn(updatedPost);
        when(postRepository.save(updatedPost)).thenReturn(updatedPost);
        when(modelMapper.map(updatedPost, PostFormDTO.class)).thenReturn(new PostFormDTO());

        // Act
        PostFormDTO result = postService.modifyPost(postId, postFormDTO);

        // Assert
        assertNotNull(result);
        // 추가적인 검증이 필요하다면 여기에 추가하세요.
    }

    @Test
    void whenRemovePost_thenPostIsDeleted() {
        // Arrange
        Integer postId = 1;
        doNothing().when(postRepository).deleteById(postId);

        // Act
        postService.removePost(postId);

        // Assert
        verify(postRepository).deleteById(postId);
    }
}
