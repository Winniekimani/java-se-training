-- Table to create item info
CREATE TABLE IF NOT EXISTS items (item_Code VARCHAR(255) NOT NULL,quantity INT NOT NULL,unit_Price DECIMAL(10, 2) NOT NULL,PRIMARY KEY (itemCode)) ENGINE=INNODB;

--users table
CREATE TABLE IF NOT EXISTS users (id INT AUTO_INCREMENT PRIMARY KEY,username VARCHAR(255) NOT NULL,password VARCHAR(255) NOT NULL,name VARCHAR(255),email VARCHAR(255));

--payment table 
CREATE TABLE IF NOT EXISTS payments (id INT AUTO_INCREMENT PRIMARY KEY,total_amount DECIMAL(10, 2) NOT NULL,amount_given DECIMAL(10, 2) NOT NULL,change_amount DECIMAL(10, 2) NOT NULL)";


-- Insert statement
INSERT INTO items (item_code, quantity, unitPricr) VALUES("002A", 20, 200),("00gh1", 10, 100),("ABC123", 20, 200);
SELECT * FROM items;

--delete
DELETE FROM items WHERE item_code = ?;
DELETE FROM items WHERE item_code="002A";
DELETE FROM items WHERE item_code="002";



