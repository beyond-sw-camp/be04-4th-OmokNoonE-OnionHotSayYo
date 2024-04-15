//package org.omoknoone.onionhotsayyo.post.service;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.modelmapper.ModelMapper;
//import org.omoknoone.onionhotsayyo.post.aggregate.Post;
//import org.omoknoone.onionhotsayyo.post.dto.WritePostDetailDTO;
//import org.omoknoone.onionhotsayyo.post.repository.PostRepository;
//import org.omoknoone.onionhotsayyo.post.vo.ResponsePostDetail;
//import org.omoknoone.onionhotsayyo.post.service.PostServiceImpl;
//import org.omoknoone.onionhotsayyo.post.vo.ResponsePostListByCategory;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class PostServiceImplTests {
//    @Mock
//    private PostRepository postRepository;
//
//    @Mock
//    private ModelMapper modelMapper;
//
//    @InjectMocks
//    private PostServiceImpl postService;
//
//    @Test
//    void whenViewPostsByCategory_thenReturnsPostSummaryList() {
//        // Arrange
//        String categoryId = "testCategory";
//        List<Post> posts = new ArrayList<>();
//        posts.add(new Post());
//        when(postRepository.findByCategoryId(categoryId)).thenReturn(posts);
//        when(modelMapper.map(any(Post.class), eq(ResponsePostListByCategory.class)))
//                .thenReturn(new ResponsePostListByCategory());
//
//        // Act
//        List<ResponsePostListByCategory> result = postService.viewPostsByCategory(categoryId);
//
//        // Assert
//        assertFalse(result.isEmpty());
//    }
//
//    @Test
//    void whenViewPostById_thenReturnsPostDetail() {
//        // Arrange
//        Integer postId = 1;
//        Post post = new Post();
//        when(postRepository.findById(postId)).thenReturn(Optional.of(post));
//        when(modelMapper.map(any(Post.class), eq(ResponsePostDetail.class))).thenReturn(new ResponsePostDetail());
//
//        // Act
//        ResponsePostDetail result = postService.viewPostById(postId);
//
//        // Assert
//        assertNotNull(result);
//    }
//
//    @Test
//    void whenCreatePost_thenReturnsPostFormDTO() {
//        // Arrange
//        WritePostDetailDTO postFormDTO = new WritePostDetailDTO();
//        Post post = new Post();
//        when(modelMapper.map(any(WritePostDetailDTO.class), eq(Post.class))).thenReturn(post);
//        when(postRepository.save(any(Post.class))).thenReturn(post);
//        when(modelMapper.map(any(Post.class), eq(WritePostDetailDTO.class))).thenReturn(postFormDTO);
//
//        // Act
//        ResponsePostDetail result = postService.createPost(postFormDTO);
//
//        // Assert
//        assertNotNull(result);
//    }
//
////    @Test
////    void whenModifyPostWithExistingPost_thenReturnsUpdatedPostFormDTO() throws Exception {
////        // Arrange
////        Integer postId = 1;
////        PostFormDTO postFormDTO = new PostFormDTO();
////        postFormDTO.setTitle("My Updated Title");
////        Post existingPost = new Post(); // 기존 Post 엔티티 준비
////        Post updatedPost = new Post(); // 업데이트된 Post 엔티티 준비
////
////        // 리플렉션을 사용하여 updatedPost 객체의 title 필드 값을 설정합니다.
////        setTitleUsingReflection(existingPost, "Original Title");
////        setTitleUsingReflection(updatedPost, "My Updated Title");
////
////        when(postRepository.findById(postId)).thenReturn(Optional.of(existingPost));
////
////// ModelMapper 스터빙을 수정하여, 정확한 객체 매핑을 보장합니다.
////        when(modelMapper.map(any(PostFormDTO.class), eq(Post.class))).thenAnswer(invocation -> {
////            PostFormDTO dto = invocation.getArgument(0);
////            Post post = existingPost; // 기존 Post 엔티티를 사용합니다.
////            // 리플렉션을 사용하여 Post 객체의 title 필드 값을 설정합니다.
////            Field field = Post.class.getDeclaredField("title");
////            field.setAccessible(true);
////            field.set(post, dto.getTitle()); // DTO에서 제공된 제목으로 Post 엔티티의 title 필드를 업데이트합니다.
////            return post; // 업데이트된 Post 엔티티를 반환합니다.
////        });
////
////        when(postRepository.save(any(Post.class))).thenReturn(updatedPost); // 업데이트된 Post 엔티티를 저장하고 반환합니다.
////
////        when(modelMapper.map(any(Post.class), eq(PostFormDTO.class))).thenReturn(postFormDTO); // Post 엔티티를 PostFormDTO로 매핑합니다.
////
////        when(postRepository.save(any(Post.class))).thenReturn(updatedPost);
////
////        // Act
////        PostFormDTO result = postService.modifyPost(postId, postFormDTO);
////
////        // Assert
////        assertNotNull(result.getTitle()); // 수정된 PostFormDTO의 제목이 null이 아닌지 확인
////        assertEquals("My Updated Title", result.getTitle());
////
////        // Verify
////        verify(postRepository).findById(postId);
//////        verify(modelMapper).map(eq(postFormDTO), eq(Post.class)); // 변경
////        verify(postRepository).save(any(Post.class));
////
////    }
////
////    // 헬퍼 메소드: Post 객체의 title 필드에 값을 설정합니다.
////    private void setTitleUsingReflection(Post testPost, String title)
////            throws NoSuchFieldException, IllegalAccessException {
////        Field field = Post.class.getDeclaredField("title");
////        field.setAccessible(true);
////        field.set(testPost, title);
////
////    }
//
//    @Test
//    void whenRemovePost_thenPostIsDeleted() {
//        // Arrange
//        Integer postId = 1;
//        doNothing().when(postRepository).deleteById(postId);
//
//        // Act
//        postService.removePost(postId);
//
//        // Assert
//        verify(postRepository).deleteById(postId);
//    }
//}
