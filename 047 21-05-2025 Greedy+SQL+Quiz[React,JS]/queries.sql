-- List customers who have made at least one order with a total cost higher 
-- than $1000

-- Sample Output:
-- Name    Email                                                                                                           
-- Alice Johnson   alice.johnson@example.com                                                                               
-- George Clark    george.clark@example.com 

SELECT DISTINCT c.Name, c.Email
FROM Customers c
JOIN Orders o
ON c.CustomerID = o.CustomerID
WHERE o.TotalCost > 1000;


-- Find all customers who have ordered a "Laptop".

-- Sample Output:
-- Name                                                                                                                    
-- Alice Johnson                                                                                                           
-- George Clark  

SELECT c.Name
FROM Customers c JOIN Orders o ON c.CustomerID = o.CustomerID
JOIN OrderItems oi ON o.OrderID = oi.OrderID
WHERE oi.ProductID = (
    SELECT ProductID
    FROM Products
    WHERE Name = "Laptop"
);


-- List customers who have never placed an order.

-- Sample Output:
-- Name                                                                                                                    
-- Henry Taylor                                                                                                            
-- Irene Green 

SELECT Name
FROM Customers
WHERE CustomerID NOT IN (
    SELECT CustomerID
    FROM Orders
);



/*
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
*/