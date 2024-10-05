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

    @Override
    public Page<PostDto> findAll(PostFilterForm form, Pageable pageable) {
        var spec = PostSpecitification.buidSpec(form);
        return postRepository.findAll(spec, pageable)
                .map(PostMapper::map);
    }

    @Override
    public PostDto findById(Long id) {
        return postRepository.findById(id)
                .map(PostMapper::map)
                .orElse(null);
    }

    @Override
    public List<PostDto> findByTitle(String title) {
        return postRepository.findByTitle(title)
                .stream()
                .map(PostMapper::map)
                .toList();
    }

    @Override
    public List<PostDto> findByIdBetween(Long minId, Long maxId) {
        return postRepository.findByIdBetween(minId, maxId)
                .stream()
                .map(PostMapper::map)
                .toList();
    }

    @Override
    public Page<PostDto> findByTitleContaining(String search, Pageable pageable) {
        return postRepository.findByTitleContaining(search, pageable)
                .map(PostMapper::map);
    }

    @Override
    public PostDto create(PostCreateForm form) {
        var post = PostMapper.map(form);
        var savePost = postRepository.save(post);
        return PostMapper.map(savePost);
    }

    @Override
    public PostDto update(Long id, PostUpdateForm form) {
        var optional = postRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        var post = optional.get();
        PostMapper.map(form, post);
        var savedPost = postRepository.save(post);
        return PostMapper.map(savedPost);
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
