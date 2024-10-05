package com.vti.springframework.service;

import com.vti.springframework.dto.PostDto;
import com.vti.springframework.entity.Post;
import com.vti.springframework.form.PostCreateForm;
import com.vti.springframework.form.PostFilterForm;
import com.vti.springframework.form.PostUpdateForm;
import com.vti.springframework.mapper.PostMapper;
import com.vti.springframework.repository.PostRepository;
import com.vti.springframework.specitification.PostSpecitification;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Function;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    private ModelMapper modelMapper;

    @Override
    public Page<PostDto> findAll(PostFilterForm form, Pageable pageable) {
        var spec = PostSpecitification.buidSpec(form);
        return postRepository.findAll(spec, pageable)
                .map(post -> modelMapper.map(post, PostDto.class).withSelfRel());
    }

    @Override
    public PostDto findById(Long id) {
        return postRepository.findById(id)
                .map(post -> modelMapper.map(post, PostDto.class).withSelfRel())
                .orElse(null);
    }

    @Override
    public List<PostDto> findByTitle(String title) {
        return postRepository.findByTitle(title)
                .stream()
                .map(post -> modelMapper.map(post, PostDto.class).withSelfRel())
                .toList();
    }

    @Override
    public List<PostDto> findByIdBetween(Long minId, Long maxId) {
        return postRepository.findByIdBetween(minId, maxId)
                .stream()
                .map(post -> modelMapper.map(post, PostDto.class).withSelfRel())
                .toList();
    }

    @Override
    public Page<PostDto> findByTitleContaining(String search, Pageable pageable) {
        return postRepository.findByTitleContaining(search, pageable)
                .map(post -> modelMapper.map(post, PostDto.class).withSelfRel());
    }

    @Override
    public PostDto create(PostCreateForm form) {
        var post = modelMapper.map(form, Post.class);
        var savedPost = postRepository.save(post);
        return modelMapper.map(savedPost, PostDto.class);
    }

    @Override
    public PostDto update(Long id, PostUpdateForm form) {
        var optional = postRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        var post = optional.get();
        modelMapper.map(form, post);
        var savedPost = postRepository.save(post);
        return modelMapper.map(savedPost, PostDto.class);
    }

    @Override
    @Transactional
    public void updateTitle(Long id, String title) {
        postRepository.updateTitle(id, title);
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteByTitle(String title) {
        postRepository.deleteByTitle(title);
    }
}
