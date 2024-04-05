package org.omoknoone.onionhotsayyo.post.command.service;

import org.modelmapper.ModelMapper;
import org.omoknoone.onionhotsayyo.post.command.aggregate.Post;
import org.omoknoone.onionhotsayyo.post.command.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private ModelMapper modelMapper;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Post> viewPostsByCategory(Integer categoryId) {
        return null;
    }
}
