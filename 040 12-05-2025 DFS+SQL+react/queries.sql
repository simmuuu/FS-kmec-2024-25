-- List the names and emails of customers who placed orders with the status "Delivered".
SELECT DISTINCT c.Name, c.Email
FROM Customers c
JOIN Orders o
    ON c.CustomerID = o.CustomerID
WHERE o.Status = "Delivered";

-- Calculate the total amount spent by each customer and display customer names
-- along with their total spending, ordered by highest spending first.
SELECT c.name, SUM(o.TotalCost) AS TotalSpent
FROM Customers c
JOIN Orders o
    ON c.CustomerID = o.CustomerID
GROUP BY c.CustomerID
ORDER BY TotalSpent DESC;

-- Show product names along with the total quantity sold for each product. Display 
-- only products where the total quantity sold is greater than or equal to 2.
SELECT p.Name as ProductName, SUM(oi.Quantity) as TotalQuantitySold
FROM Products p
JOIN OrderItems oi
    ON p.ProductID = oi.ProductID
GROUP BY p.ProductID
HAVING TotalQuantitySold >= 2;

-- Find all orders placed by customers living in "Texas (TX)".Include customer name,
-- order date, total cost, and status.
SELECT c.Name, o.OrderDate, o.TotalCost, o.Status
FROM Customers c
JOIN Orders o
    ON c.CustomerID = o.CustomerID
WHERE c.Address LIKE '%TX';

-- List orders that contain more than one item. Show OrderID, customer name, and 
-- the total number of items in the order.
SELECT o.OrderID, c.Name AS CustomerName, COUNT(oi.OrderItemID) AS NumberOfItems
FROM Customers c
JOIN Orders o
    ON c.CustomerID = o.CustomerID
JOIN OrderItems oi
    ON o.OrderID = oi.OrderID
GROUP BY o.OrderID
HAVING NumberOfItems > 1;

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
