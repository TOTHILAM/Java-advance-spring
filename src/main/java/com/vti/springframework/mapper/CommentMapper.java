package com.vti.springframework.mapper;

import com.vti.springframework.dto.CommentDto;
import com.vti.springframework.entity.Comment;
import com.vti.springframework.form.CommentCreateForm;
import com.vti.springframework.form.CommentUpdateForm;

public class CommentMapper {
    public static Comment map(CommentCreateForm form) {
        var comment = new Comment();
        comment.setName(form.getName());
        comment.setEmail(form.getEmail());
        comment.setBody(form.getBody());
        return comment;
    }

    public static CommentDto map(Comment comment) {
        var dto = new CommentDto();
        dto.setId(comment.getId());
        dto.setName(comment.getName());
        dto.setEmail(comment.getEmail());
        dto.setBody(comment.getBody());
        dto.setCreateAt(comment.getCreateAt());
        dto.setUpdateAt(comment.getUpdateAt());
        return dto.withSelRel();
    }

    public static void map(CommentUpdateForm form, Comment comment) {
        comment.setName(form.getName());
        comment.setEmail(form.getEmail());
        comment.setBody(form.getBody());
    }
}
