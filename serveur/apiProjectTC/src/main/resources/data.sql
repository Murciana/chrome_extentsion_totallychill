DROP TABLE IF EXISTS good_vibe_phrases;

CREATE TABLE good_vibe_phrases (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  phrase VARCHAR(250) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP

);

INSERT INTO good_vibe_phrases (phrase) VALUES
  ('Coucou'),
  ('ça marche'),
  ('bien');