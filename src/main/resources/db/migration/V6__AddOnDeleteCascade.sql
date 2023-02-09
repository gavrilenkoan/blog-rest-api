ALTER TABLE post
    DROP CONSTRAINT post_user_id_fkey,
    ADD CONSTRAINT post_user_id_fkey
        FOREIGN KEY (user_id)
        REFERENCES _user(id)
        ON DELETE CASCADE;

ALTER TABLE user_follower
    DROP CONSTRAINT user_follower_user_id_fkey,
    ADD CONSTRAINT user_follower_user_id_fkey
        FOREIGN KEY (user_id)
            REFERENCES _user(id)
            ON DELETE CASCADE;

ALTER TABLE user_follower
    DROP CONSTRAINT user_follower_follower_id_fkey,
    ADD CONSTRAINT user_follower_follower_id_fkey
        FOREIGN KEY (follower_id)
            REFERENCES _user(id)
            ON DELETE CASCADE;

ALTER TABLE comment
    DROP CONSTRAINT comment_user_id_fkey,
    ADD CONSTRAINT comment_user_id_fkey
        FOREIGN KEY (user_id)
            REFERENCES _user(id)
            ON DELETE CASCADE;

ALTER TABLE comment
    DROP CONSTRAINT comment_post_id_fkey,
    ADD CONSTRAINT comment_post_id_fkey
        FOREIGN KEY (post_id)
            REFERENCES post(id)
            ON DELETE CASCADE;

ALTER TABLE comment_reply
    DROP CONSTRAINT comment_reply_comment_id_fkey,
    ADD CONSTRAINT comment_reply_comment_id_fkey
        FOREIGN KEY (comment_id)
            REFERENCES comment(id)
            ON DELETE CASCADE;

ALTER TABLE comment_reply
    DROP CONSTRAINT comment_reply_reply_id_fkey,
    ADD CONSTRAINT comment_reply_reply_id_fkey
        FOREIGN KEY (reply_id)
            REFERENCES comment(id)
            ON DELETE CASCADE;