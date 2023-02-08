CREATE TABLE user_follower (
  id BIGSERIAL PRIMARY KEY,
  user_id BIGINT NOT NULL REFERENCES _user(id),
  follower_id BIGINT NOT NULL REFERENCES _user(id)
);