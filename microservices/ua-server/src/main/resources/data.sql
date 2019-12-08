DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id INT AUTO_INCREMENT,
  email VARCHAR(250)  ,
  firstname VARCHAR(250) NOT NULL,
  lastname VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  PRIMARY KEY(id, email)
);

CREATE TABLE  authorities(
  user_id INT NOT NULL,
  role VARCHAR(20) NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users
);
