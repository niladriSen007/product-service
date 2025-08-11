CREATE TABLE product(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    image_url VARCHAR(255),
    color VARCHAR(50) NOT NULL,
    price FLOAT NOT NULL,
    description TEXT NOT NULL,
    discount FLOAT NOT NULL,
    model VARCHAR(50) NOT NULL,
    stock INT NOT NULL,
    title VARCHAR(50) NOT NULL,
    price FLOAT NOT NULL,
    category_id BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

   CONSTRAINT fk_product_category
    FOREIGN KEY (category_id)
    REFERENCES category (id)
)