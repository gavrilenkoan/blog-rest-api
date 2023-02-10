ALTER TABLE comment
    ADD comment_reply_id BIGINT REFERENCES comment_reply(id) ON DELETE CASCADE;