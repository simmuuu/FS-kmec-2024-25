-- List each customer along with the number of orders they've placed.

-- Sample Output:
-- CustomerID      Name    OrderCount                                                                                      
-- 1       Alice Johnson   4                                                                                               
-- 2       Bob Smith       3                                                                                               
-- 3       Charlie Davis   3                                                                                               
-- 4       Diana Williams  2                                                                                               
-- 5       Ethan Brown     1                                                                                               
-- 6       Fiona Adams     1                                                                                               
-- 7       George Clark    1                                                                                               
-- 8       Henry Taylor    0                                                                                               
-- 9       Irene Green     0  

SELECT c.CustomerID, c.Name, COUNT(o.OrderID) AS OrderCount
FROM Customers c
LEFT JOIN Orders o
    ON c.CustomerID = o.CustomerID
GROUP BY c.CustomerID;


-- Find customers who have ordered the most expensive product.

-- Sample Output:
-- CustomerID      Name    Email   Address PhoneNumber                                                                     
-- 1       Alice Johnson   alice.johnson@example.com       123 Apple St, New York, NY      123-456-7890                    
-- 7       George Clark    george.clark@example.com        213 Birch St, San Francisco, CA 555-666-7777    

SELECT *
FROM Customers c
WHERE CustomerID IN (
    SELECT o.CustomerID FROM Orders o
    JOIN OrderItems oi ON o.OrderID = oi.OrderID
    WHERE oi.ProductID IN (
        SELECT ProductID FROM Products
        WHERE Price = (SELECT MAX(Price) FROM Products)
    ) 
);


-- Show each product along with the total quantity sold across all orders.

-- Sample Output:
-- ProductID       Name    TotalQuantitySold                                                                               
-- 101     Laptop  2                                                                                                       
-- 102     Smartphone      2                                                                                               
-- 103     Headphones      NULL                                                                                            
-- 104     Keyboard        5                                                                                               
-- 105     Mouse   8                                                                                                       
-- 106     Monitor 2                                                                                                       
-- 107     Printer 1                                                                                                       
-- 108     Tablet  1                                                                                                       
-- 109     External SSD    1                                                                                               
-- 110     Smartwatch      2 

SELECT p.ProductID, p.Name, SUM(oi.Quantity) as TotalQuantitySold
FROM Products p
LEFT JOIN OrderItems oi 
    ON p.ProductID = oi.ProductID
GROUP BY p.ProductID;


-- List customers who have never placed an order.

-- Sample Output:
-- CustomerID      Name    Email   Address PhoneNumber                                                                     
-- 8       Henry Taylor    henry.taylor@example.com        456 Spruce St, Denver, CO       111-222-3333                    
-- 9       Irene Green     irene.green@example.com 789 Willow St, Austin, TX       444-555-6666 

SELECT *
FROM Customers
WHERE CustomerID NOT IN (
    SELECT DISTINCT CustomerID
    FROM Orders
);


-- Find orders where the total cost is higher than the total amount spent by at
-- least one other

-- Sample Output:
-- OrderID CustomerID      OrderDate       TotalCost       Status                                                          
-- 1001    1       2024-10-10      1250.00 Shipped                                                                         
-- 1002    2       2024-10-12      850.00  Processing                                                                      
-- 1005    4       2024-10-13      450.00  Shipped                                                                         
-- 1006    5       2024-10-12      550.00  Processing                                                                      
-- 1008    7       2024-10-15      1200.00 Delivered                                                                       
-- 1009    4       2024-10-14      300.00  Processing                                                                      
-- 1010    3       2024-10-15      950.00  Shipped   

SELECT *
FROM Orders o
WHERE o.TotalCost > ANY (
    SELECT SUM(TotalCost)
    FROM Orders
    WHERE o.CustomerID != CustomerID
    GROUP BY CustomerID
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