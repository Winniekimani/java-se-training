-- Table to create item info
CREATE TABLE IF NOT EXISTS items (item_Code VARCHAR(255) NOT NULL,quantity INT NOT NULL,unit_Price DECIMAL(10, 2) NOT NULL,PRIMARY KEY (itemCode)) ENGINE=INNODB;

-- Table to store customer information
CREATE TABLE IF NOT EXISTS customers (customer_id INT AUTO_INCREMENT PRIMARY KEY,first_name VARCHAR(50) NOT NULL,last_name VARCHAR(50) NOT NULL,email VARCHAR(100),phone VARCHAR(20)
);

-- Insert statements
INSERT INTO items (item_code, quantity, unitPricr) VALUES
    ("002A", 20, 200),
    ("00gh1", 10, 100),
    ("ABC123", 20, 200);
SELECT * FROM items;

