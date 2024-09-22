package com.vti.springframework.repository;

import com.vti.springframework.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
//    custom query 1: method name
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

//    custom query 2: @Query anotation
//    VD: Cập nhật title cho post cách 1 đặt tên cho tham số
    @Query("UPDATE Post SET title = :title WHERE id = :id")
    @Modifying
    void updateTitle(@Param("id") Long id, @Param("title") String title);

    //    VD: Cập nhật title cho post cách 2 dùng chỉ số
//    @Query("UPDATE Post SET title = ?2 WHERE id = ?1")
//    void updateTitle(@Param("id") Long id, @Param("title") String title);

    //    VD: Cập nhật title cho post cách 3 Câu truy vấn ở dang nguyên thủy
//    @Query(value = "UPDATE post SET title = :title WHERE id = :id", nativeQuery = true)
//    void updateTitle(@Param("id") Long id, @Param("title") String title);
}
