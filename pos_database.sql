-- Table to create item info
CREATE TABLE IF NOT EXISTS items (itemCode VARCHAR(255) NOT NULL,quantity INT NOT NULL,unitPrice DECIMAL(10, 2) NOT NULL,PRIMARY KEY (itemCode)) ENGINE=INNODB;

-- Table to store customer information
CREATE TABLE IF NOT EXISTS customers (customer_id INT AUTO_INCREMENT PRIMARY KEY,first_name VARCHAR(50) NOT NULL,last_name VARCHAR(50) NOT NULL,email VARCHAR(100),phone VARCHAR(20)
);

-- Insert statements
-- Insert data into the items table
INSERT INTO items (itemCode, quantity, unitPrice) VALUES (?, ?, ?);
INSERT INTO items (item_code, quantity, unitPricr) VALUES
    (002, 20, 200),
    (003, 10, 100),
    (001, 20, 200);

-