package com.vti.springframework.repository;

import com.vti.springframework.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
//    custom query 1.method name
//     tiền tố: findBy, countBy,existBy, deleteBy
//    VD: lấy ra tất cả các bài viết theo title
//    WHERE title = ?
    List<Post> findByTitle(String title);

//    VD:Lấy ra tất cả bài viết có minId <= id <= maxId
//    ...WHERE id BETWEEN ? AND ?
    List<Post> findByIdBetween(Long minId, Long maxId);

//    VD: Tìm kiếm Post theo title
//    ...WHERE title LIKE '%?%'
    Page<Post> findByTitleContaining(String search, Pageable pageable);

//    VD: Xóa Post theo title
    void deleteByTitle(String title);

}
