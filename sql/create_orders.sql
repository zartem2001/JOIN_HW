CREATE TABLE ORDERS
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    date         DATE           NOT NULL,
    customer_id  INT            NOT NULL,
    product_name VARCHAR(100)   NOT NULL,
    amount       DECIMAL(10, 2) NOT NULL,
);