package com.vti.springframework.specitification;

import com.vti.springframework.entity.Comment;
import com.vti.springframework.form.CommentFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.ArrayList;

public class CommentSpecitification {
    public static Specification<Comment> builSpec(CommentFilterForm form) {
        return form == null ? null : new Specification<Comment>() {
            @Override
            public Predicate toPredicate(Root<Comment> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                var predicates = new ArrayList<Predicate>();

                // ...WHERE name LIKE '%search%' OR email LIKE '%search%'
                var search = form.getSearch();
                if (StringUtils.hasText(search)) {
                    var pattern = "%" + search + "%";
                    var hasNameLike = builder.like(root.get("name"), pattern);
                    var hasEmailLike = builder.like(root.get("email"), pattern);
                    var predicate = builder.or(hasNameLike, hasEmailLike);
                    predicates.add(predicate);
                }

                // ...WHERE post_id = ?
                var postId = form.getPostId();
                if (postId != null) {
                    var predicate = builder.equal(root.get("post").get("id"), postId);
                    predicates.add(predicate);
                }

                return builder.and(predicates.toArray(new Predicate[0]));
            }
        };
    }
}
