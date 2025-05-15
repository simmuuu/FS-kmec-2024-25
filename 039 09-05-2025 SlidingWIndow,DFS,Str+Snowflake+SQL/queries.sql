-- Find customers who have Gmail email addresses and have ordered food items whose 
-- names consist of exactly two words.

SELECT 
	CONCAT(c.first_name, " ", c.last_name) AS full_name,
	c.email,
	f.name
FROM Customers c
JOIN Orders o ON c.customer_id = o.customer_id
JOIN FoodItems f ON o.food_id = f.food_id
WHERE
	c.email REGEXP '^[A-Za-z0-9._-]+@gmail\\.com$'
	AND f.name REGEXP '^[A-Za-z]+\\s+[A-Za-z]+$';

-- List names, categories, and descriptions of food items containing exactly one 
-- occurrence of the letter 'y' (case-insensitive) in their descriptions, which 
-- have been ordered more than twice.

SELECT 
    f.name, f.category, f.description
FROM FoodItems f 
JOIN Orders o ON f.food_id = o.food_id
GROUP BY o.food_id
HAVING 
    COUNT(o.order_id) > 2
    AND f.description REGEXP '^[^yY]*[yY][^yY]*$';

-- Display full names and phone numbers of customers whose phone numbers start 
-- with '98' or '87' and who have placed at least one delivered order.

SELECT
    CONCAT(c.first_name, " ", c.last_name) AS full_name,
    c.phone
FROM Customers c
JOIN Orders o 
    ON c.customer_id = o.customer_id
WHERE
    c.phone REGEXP '^98|^87'
    AND o.status = 'Delivered';

-- Find the names and categories of food items from the 'Main Course' 
-- category ordered by customers whose last names end with either 'a' or 'i'.

SELECT 
    f.name, f.category
FROM Customer c
JOIN Orders o ON o.customer_id = c.customer_id
JOIN FoodItems f ON f.food_id = o.food_id
WHERE
    f.category = 'Main Course'
    AND c.last_name REGEXP '[ai]$';

-- List email addresses of customers along with the names of food items they've 
-- ordered, where the food item's name contains exactly two consecutive vowels.

SELECT 
    c.email,
    f.name
FROM Customers c
JOIN Orders o ON c.customer_id = o.customer_id
JOIN FoodItems f ON o.food_id = f.food_id
WHERE 
    f.name REGEXP '[aeiouAEIOU]{2}'
    AND f.name NOT REGEXP '[aeiouAEIOU]{3}';


-- Customers Table
==================
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    phone VARCHAR(15),
    address TEXT


-- FoodItems Table
==================
    food_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    price DECIMAL(8,2) NOT NULL,
    category VARCHAR(50),
    availability BOOLEAN DEFAULT TRUE


-- Orders Table
===============
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    food_id INT NOT NULL,
    quantity INT NOT NULL,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status ENUM('Pending', 'Preparing', 'Delivered', 'Cancelled') DEFAULT 'Pending',
    total_amount DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id),
    FOREIGN KEY (food_id) REFERENCES FoodItems(food_id)
