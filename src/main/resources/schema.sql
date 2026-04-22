-- DROP TABLE IF EXISTS wishlist_item;
-- DROP TABLE IF EXISTS wishlist;
-- DROP TABLE IF EXISTS users;


CREATE TABLE IF NOT EXISTS users(
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL

);
CREATE TABLE IF NOT EXISTS wishlist(
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100),
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS wishlist_item(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    description VARCHAR(500),
    price DECIMAL(10,2),
    link VARCHAR(500),
    image_url VARCHAR(500),
    wishlist_id INT,
    FOREIGN KEY(wishlist_id) REFERENCES wishlist(id));



