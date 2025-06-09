CREATE TABLE prices (
    id SERIAL NOT NULL PRIMARY KEY,
    brand_id INT NOT NULL,
    start_date DATETIME NOT NULL,
    end_date DATETIME NOT NULL,
    price_list DOUBLE NOT NULL,
    product_id INT NOT NULL,
    priority INT NOT NULL,
    price FLOAT NOT NULL,
    currency VARCHAR(3) NOT NULL
);