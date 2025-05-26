-- Find customers who have placed orders with a total cost greater than the average
-- total cost of all orders

-- Sample Output:                                                                   
-- Name    Email                                                                                                           
-- Alice Johnson   alice.johnson@example.com                                                                               
-- Bob Smith       bob.smith@example.com                                                                                   
-- Charlie Davis   charlie.davis@example.com                                                                               
-- Diana Williams  diana.williams@example.com                                                                              
-- Ethan Brown     ethan.brown@example.com                                                                                 
-- George Clark    george.clark@example.com  

SELECT c.Name, c.Email
FROM Customers c
JOIN Orders o
    ON c.CustomerID = o.CustomerID
WHERE o.TotalCost > (
    SELECT AVG(o2.TotalCost)
    FROM Orders o2
)
ORDER BY c.Name;

-- Retrieve product names that have been ordered more than the average quantity of
-- all products

-- Sample Output:
-- Name                                                                                                                    
-- Laptop                                                                                                                  
-- Smartphone                                                                                                              
-- Keyboard                                                                                                                
-- Mouse                                                                                                                   
-- Monitor                                                                                                                 
-- Smartwatch   

SELECT p.Name
FROM Products p
JOIN OrderItems oi
    ON p.ProductID = oi.ProductID
GROUP BY p.Name
HAVING COUNT(oi.ProductID) > (
    SELECT AVG(Quantity)
    FROM OrderItems
);

-- Find customers who ordered the most expensive product
-- Sample Output:
-- Name    Email                                                                                                           
-- Alice Johnson   alice.johnson@example.com                                                                               
-- George Clark    george.clark@example.com    

SELECT DISTINCT c.Name, c.Email
FROM Customers c
JOIN Orders o
    ON o.CustomerID = c.CustomerID
JOIN OrderItems oi
    on o.OrderID = oi.OrderID
WHERE oi.UnitPrice = (
    SELECT MAX(UnitPrice)
    FROM OrderItems
);

-- List order IDs where all items in the order are priced above the average product
-- price

-- Sample Output:
-- OrderID                                                                                                                 
-- 1002     

SELECT o.OrderID
FROM Orders o
JOIN OrderItems oi
    ON o.OrderID = oi.OrderID
GROUP BY o.OrderID
HAVING COUNT(oi.OrderItemID) = (
    SELECT COUNT(*)
    FROM OrderItems oi2
    WHERE oi2.OrderID = o.OrderID
    AND oi2.UnitPrice > (
        SELECT AVG(Price)
        FROM Products
    )
);

-- Find the names of products that are only ordered by customers who live in a
-- specific city (e.g., 'New York')

-- Sample Output:
-- Name                                                                                                                    
-- Keyboard    

SELECT p.Name
FROM Products p
WHERE p.ProductID IN (
    SELECT oi.ProductID
    FROM OrderItems oi
    JOIN Orders o ON oi.OrderID = o.OrderID
    JOIN Customers c ON o.CustomerID = c.CustomerID
    WHERE c.Address LIKE '%New York%'
)
AND p.ProductID NOT IN (
    SELECT oi.ProductID
    FROM OrderItems oi
    JOIN Orders o ON oi.OrderID = o.OrderID
    JOIN Customers c ON o.CustomerID = c.CustomerID
    WHERE c.Address NOT LIKE '%New York%'
);



Customers:
==========
Field   Type    Null    Key     Default Extra                                                                           
CustomerID      int     NO      PRI     NULL                                                                            
Name    varchar(255)    YES             NULL                                                                            
Email   varchar(255)    YES             NULL                                                                            
Address varchar(255)    YES             NULL                                                                            
PhoneNumber     varchar(20)     YES             NULL                                                                    

Orders:
=======
Field   Type    Null    Key     Default Extra                                                                           
OrderID int     NO      PRI     NULL                                                                                    
CustomerID      int     YES     MUL     NULL                                                                            
OrderDate       date    YES             NULL                                                                            
TotalCost       decimal(10,2)   YES             NULL                                                                    
Status  varchar(20)     YES             NULL                                                                            

OrderItems:
============
Field   Type    Null    Key     Default Extra                                                                           
OrderItemID     int     NO      PRI     NULL                                                                            
OrderID int     YES     MUL     NULL                                                                                    
ProductID       int     YES     MUL     NULL                                                                            
Quantity        int     YES             NULL                                                                            
UnitPrice       decimal(10,2)   YES             NULL                                                                    

Products:
=========
Field   Type    Null    Key     Default Extra                                                                           
ProductID       int     NO      PRI     NULL                                                                            
Name    varchar(255)    YES             NULL                                                                            
Description     varchar(255)    YES             NULL                                                                    
Price   decimal(10,2)   YES             NULL  
