-- Find customers who have spent more than the average order total

-- Sample Output:
-- Name    Email                                                                                                           
-- Alice Johnson   alice.johnson@example.com                                                                               
-- Bob Smith       bob.smith@example.com                                                                                   
-- Diana Williams  diana.williams@example.com                                                                              
-- Ethan Brown     ethan.brown@example.com                                                                                 
-- George Clark    george.clark@example.com                                                                                
-- Charlie Davis   charlie.davis@example.com    

SELECT c.Name, c.Email
FROM Customers c
JOIN Orders o
    ON c.CustomerID = o.CustomerID
WHERE o.TotalCost > (
    SELECT AVG(TotalCost)
    FROM Orders
);

-- List product names that were included in the most expensive order

-- Sample Output:
-- Name                                                                                                                    
-- Laptop                                                                                                                  
-- Keyboard  

SELECT p.Name
FROM Products p
JOIN OrderItems oi
    ON p.ProductID = oi.ProductID
WHERE oi.OrderID = (
    SELECT OrderID
    FROM Orders
    ORDER BY TotalCost DESC
    LIMIT 1
);

-- Show customers who placed more orders than the average number of orders per 
-- customer

-- Sample Output:
-- CustomerID      Name    NumOrders                                                                                       
-- 1       Alice Johnson   4                                                                                               
-- 2       Bob Smith       3                                                                                               
-- 3       Charlie Davis   3  

SELECT c.CustomerID, c.Name, COUNT(o.OrderID) AS NumOrders
FROM Customers c
JOIN Orders o
    ON c.CustomerID = o.CustomerID
GROUP BY c.CustomerID
HAVING COUNT(o.OrderID) > (
    SELECT AVG(order_count)
    FROM (
        SELECT COUNT(OrderID) as order_count
        FROM Orders
        GROUP BY CustomerID
    ) as orders
);

-- Find the name of the customer who spent the most in total

-- Sample Output:
-- Name    TotalSpent                                                                                                      
-- Alice Johnson   1625.00                                                                                                 
-- George Clark    1200.00                                                                                                 
-- Bob Smith       1050.00                                                                                                 
-- Charlie Davis   1050.00                                                                                                 
-- Diana Williams  750.00                                                                                                  
-- Ethan Brown     550.00                                                                                                  
-- Fiona Adams     250.00  

SELECT c.Name, SUM(o.TotalCost) as TotalSpent
FROM Customers c
JOIN Orders o
    ON c.CustomerID = o.CustomerID
GROUP BY c.CustomerID
ORDER BY TotalSpent DESC;

-- Get product names that were never ordered

-- Sample Output:
-- Name                                                                                                                    
-- Headphones    

SELECT Name
FROM Products 
WHERE ProductID
NOT IN (
    SELECT DISTINCT ProductID
    FROM OrderItems
);

-- Customers:
==========
Field   Type    Null    Key     Default Extra                                                                           
CustomerID      int     NO      PRI     NULL                                                                            
Name    varchar(255)    YES             NULL                                                                            
Email   varchar(255)    YES             NULL                                                                            
Address varchar(255)    YES             NULL                                                                            
PhoneNumber     varchar(20)     YES             NULL                                                                    

-- Orders:
=======
Field   Type    Null    Key     Default Extra                                                                           
OrderID int     NO      PRI     NULL                                                                                    
CustomerID      int     YES     MUL     NULL                                                                            
OrderDate       date    YES             NULL                                                                            
TotalCost       decimal(10,2)   YES             NULL                                                                    
Status  varchar(20)     YES             NULL                                                                            

-- OrderItems:
============
Field   Type    Null    Key     Default Extra                                                                           
OrderItemID     int     NO      PRI     NULL                                                                            
OrderID int     YES     MUL     NULL                                                                                    
ProductID       int     YES     MUL     NULL                                                                            
Quantity        int     YES             NULL                                                                            
UnitPrice       decimal(10,2)   YES             NULL                                                                    

-- Products:
=========
Field   Type    Null    Key     Default Extra                                                                           
ProductID       int     NO      PRI     NULL                                                                            
Name    varchar(255)    YES             NULL                                                                            
Description     varchar(255)    YES             NULL                                                                    
Price   decimal(10,2)   YES             NULL  
