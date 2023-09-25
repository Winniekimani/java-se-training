
--table to create product info
CREATE TABLE IF NOT EXISTS products (product_id INT AUTO_INCREMENT PRIMARY KEY,product_name VARCHAR(255) NOT NULL,price DECIMAL(10, 2) NOT NULL,description TEXT,category VARCHAR(50));

-- table to store customer information
CREATE TABLE IF NOT EXISTS customers (customer_id INT AUTO_INCREMENT PRIMARY KEY,first_name VARCHAR(50) NOT NULL,last_name VARCHAR(50) NOT NULL,email VARCHAR(100),phone VARCHAR(20));

--table to store sales transactions
CREATE TABLE IF NOT EXISTS sales (sale_id INT AUTO_INCREMENT PRIMARY KEY,customer_id INT,sale_date DATE,total_amount DECIMAL(10, 2) NOT NULL,FOREIGN KEY (customer_id) REFERENCES customers(customer_id));

--table to store items in each sale
CREATE TABLE sale_items (sale_item_id INT AUTO_INCREMENT PRIMARY KEY,sale_id INT,product_id INT,quantity INT NOT NULL,item_price DECIMAL(10, 2) NOT NULL,FOREIGN KEY (sale_id) REFERENCES sales(sale_id),FOREIGN KEY (product_id) REFERENCES products(product_id));


--insert statements
--Insert  into the products table
INSERT INTO products (product_name, price, description, category)VALUES('Product A', 19.99, 'Description for Product A', 'Category 1'),
('Product B', 29.99, 'Description for Product B', 'Category 2'),
('Product C', 9.99, 'Description for Product C', 'Category 1');

---- Insert  data into the customers table
INSERT INTO customers (first_name, last_name, email, phone)VALUES('John', 'Doe', 'john.doe@example.com', '123-456-7890'),
('Jane', 'Smith', 'jane.smith@example.com', '987-654-3210');

---- Insert  data into the sales table
INSERT INTO sales (customer_id, sale_date, total_amount)VALUES(1, '2023-09-15', 49.98),(2, '2023-09-16', 19.99);

-- Insert  data into the sale_items table
INSERT INTO sale_items (sale_id, product_id, quantity, item_price)VALUES(1, 1, 2, 19.99),(1, 2, 1, 29.99),(2, 3, 3, 9.99);