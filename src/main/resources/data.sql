INSERT INTO post (id, title             , content                           , description             , created_at       , updated_at       )
VALUES           (1 , 'Spring Framework', 'Learn Spring Framework with Lâm', 'Learn Spring Framework', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO comment (id, name        , email                , body              , post_id, created_at       , updated_at       )
VALUES              (1 , 'Tô Thị Lâm', 'tolam0902@gmail.com', 'Bài viết rất hay', 1      , CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);