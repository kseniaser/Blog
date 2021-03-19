DROP TABLE IF EXISTS article;

CREATE TABLE article (
  id VARCHAR(36) PRIMARY KEY,
  author_id INT NOT NULL,
  content VARCHAR(10000) NOT NULL,
  date TIMESTAMP NOT NULL
);