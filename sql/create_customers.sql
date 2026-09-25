CREATE TABLE CUSTOMERS
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    name         VARCHAR(50) NOT NULL,
    surname      VARCHAR(50) NOT NULL,
    age          INT CHECK (age > 0),
    phone_number VARCHAR(20) UNIQUE
);