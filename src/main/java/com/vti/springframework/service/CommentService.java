package com.vti.springframework.service;

import com.vti.springframework.dto.CommentDto;
import com.vti.springframework.form.CommentCreateForm;
import com.vti.springframework.form.CommentUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommentService {
    Page<CommentDto> findAll(Pageable pageable);

    CommentDto findById(Long id);

    CommentDto create(Long postId, CommentCreateForm form);

    CommentDto update(Long id, CommentUpdateForm form);

    void deleteById(Long id);
}
