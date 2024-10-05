package com.vti.springframework.specitification;

import com.vti.springframework.entity.Post;
import com.vti.springframework.form.PostFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class PostSpecitification {
    public static Specification<Post> buidSpec(PostFilterForm form) {
        return form == null ? null : new Specification<Post>() {
            @Override
            public Predicate toPredicate(Root<Post> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                var predicates = new ArrayList<Predicate>();

                // ...WHERE title LIKE '%search%'
                var search = form.getSearch();
                if (StringUtils.hasText(search)) {
                    var pattern = "%" + search + "%";
                    var predicate = builder.like(root.get("title"), pattern);
                    predicates.add(predicate);
                }

                // ...WHERE create_at >= ?
                var minCreatedDate = form.getMinCreateDate();
                if (minCreatedDate != null) {
                    var minCreateAt = LocalDateTime.of(minCreatedDate, LocalTime.MIN);
                    var predicate = builder.greaterThanOrEqualTo(root.get("createdAT"), minCreateAt);
                    predicates.add(predicate);
                }

                // ...WHERE create_at <= ?
                var maxCreatedDate = form.getMaxCreateDate();
                if (maxCreatedDate != null) {
                    var maxCreatedAt = LocalDateTime.of(maxCreatedDate, LocalTime.MAX);
                    var predicate = builder.greaterThanOrEqualTo(root.get("createdAT"), maxCreatedAt);
                    predicates.add(predicate);
                }

                return builder.and(predicates.toArray(new Predicate[0]));
            }
        };
    }
}
