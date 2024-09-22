package com.vti.springframework.controller;

import com.vti.springframework.dto.PostDto;
import com.vti.springframework.entity.Post;
import com.vti.springframework.form.PostCreateForm;
import com.vti.springframework.form.PostUpdateForm;
import com.vti.springframework.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PostController {
    private PostService postService;

    @GetMapping("/api/v1/posts")
    public Page<PostDto> findAll(Pageable pageable) {
        return postService.findAll(pageable);
    }

    @GetMapping(value = "/api/v1/posts/search", params = "title")
    public List<PostDto> findByTitle(@RequestParam("title") String title) {
        return postService.findByTitle(title);
    }

    @GetMapping(value = "/api/v1/posts/search", params = {"minId", "maxId"})
    public List<PostDto> findByIdBetween(@RequestParam("minId") Long minId, @RequestParam("maxId") Long maxId) {
        return postService.findByIdBetween(minId, maxId);
    }

    @GetMapping(value = "/api/v1/posts/search", params = "search")
    public Page<PostDto> findByTitleContaining(@RequestParam("search") String search, Pageable pageable) {
        return postService.findByTitleContaining(search, pageable);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostDto findById(@PathVariable("id") Long id) {
        return postService.findById(id);
    }

    @PostMapping("/api/v1/posts")
    public PostDto create(@RequestBody PostCreateForm form) {
        return postService.create(form);
    }

    @PutMapping("/api/v1/posts/{id}")
    public PostDto update(@PathVariable("id") Long id, @RequestBody PostUpdateForm form) {
        return postService.update(id,form);
    }

    @PatchMapping("/api/v1/posts/{id}/title")
    public void updateTitle(@PathVariable("id") Long id, @RequestBody String title) {
        postService.updateTitle(id, title);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        postService.deleteById(id);
    }

    @DeleteMapping(value = "/api/v1/posts/delete", params = "title")
    public void deleteByTitle(@RequestParam("title") String title) {
        postService.deleteByTitle(title);
    }
}
