DROP TABLE IF EXISTS article;

CREATE TABLE article (
  id VARCHAR(36) PRIMARY KEY,
  author_id INT NOT NULL,
  content JSONB,
  title VARCHAR(64) NOT NULL,
  description VARCHAR(512) NOT NULL,
  date TIMESTAMP NOT NULL
);