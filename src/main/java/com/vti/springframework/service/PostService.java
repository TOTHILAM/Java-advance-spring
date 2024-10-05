package com.vti.springframework.service;

import com.vti.springframework.dto.PostDto;
import com.vti.springframework.entity.Post;
import com.vti.springframework.form.PostCreateForm;
import com.vti.springframework.form.PostFilterForm;
import com.vti.springframework.form.PostUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {
    Page<PostDto> findAll(PostFilterForm form, Pageable pageable);

    PostDto findById(Long id);

    List<PostDto> findByTitle(String title);

    List<PostDto> findByIdBetween(Long minId, Long maxId);

    Page<PostDto> findByTitleContaining(String search, Pageable pageable);

    PostDto create(PostCreateForm form);

    PostDto update(Long id, PostUpdateForm form);

    void updateTitle(Long id, String title);

    void deleteById(Long id);

    void deleteByTitle(String title);


}
