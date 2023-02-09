CREATE TABLE comment_reply (
    id BIGSERIAL PRIMARY KEY,
    comment_id BIGINT NOT NULL REFERENCES comment(id),
    reply_id BIGINT NOT NULL REFERENCES comment(id)
);