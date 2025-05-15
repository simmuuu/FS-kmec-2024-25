-- Find customers who have placed at least one order with a cost greater than the
-- average order cost for that customer

-- Sample Output:
-- Name    OrderID TotalCost                                                                                               
-- Alice Johnson   1001    1250.00                                                                                         
-- Bob Smith       1002    850.00                                                                                          
-- Diana Williams  1005    450.00                                                                                          
-- Charlie Davis   1010    950.00  

SELECT c.Name, o.OrderID, o.TotalCost
FROM Customers c
JOIN Orders o
    ON c.CustomerID = o.CustomerID
WHERE o.TotalCost > (
    SELECT AVG(o2.TotalCost)
    FROM Orders o2
    WHERE o2.CustomerID = o.CustomerID
);

-- Find the distinct names of customers who have placed at least one order that includes the
-- most expensive product in the catalog.

-- Sample Output:
-- Name                                                                                                                    
-- Alice Johnson                                                                                                           
-- George Clark 

SELECT DISTINCT c.Name
FROM Customers c
JOIN Orders o 
    ON c.CustomerID = o.CustomerID
JOIN OrderItems oi
    ON o.OrderID = oi.OrderID
JOIN Products p
    ON oi.ProductID = p.ProductID
WHERE p.Price = (SELECT MAX(price) FROM Products);

-- List orders where the total cost is higher than the total cost of any other 
-- order made by the same customer:

-- Sample Output:
-- OrderID CustomerID      TotalCost                                                                                       
-- 1001    1       1250.00                                                                                                 
-- 1002    2       850.00                                                                                                  
-- 1005    4       450.00                                                                                                  
-- 1006    5       550.00                                                                                                  
-- 1007    6       250.00                                                                                                  
-- 1008    7       1200.00                                                                                                 
-- 1010    3       950.00  

SELECT o.OrderID, c.CustomerID, o.TotalCost
FROM Orders o
WHERE o.TotalCost > (
    SELECT MAX(o2.TotalCost)
    FROM Orders o2
    WHERE o2.CustomerID = o.CustomerID
); 


-- Find the customers who placed orders that include more items than any other 
-- order theyve placed:

-- Sample Output:
-- OrderID Name    ItemCount                                                                                               
-- 1010    Charlie Davis   2                                                                                               
-- 1005    Diana Williams  2                                                                                               
-- 1006    Ethan Brown     2                                                                                               
-- 1007    Fiona Adams     1                                                                                               
-- 1008    George Clark    2  

SELECT
    oi.OrderID AS OrderID,
    c.Name AS Name,
    COUNT(*) AS ItemCount
FROM
    OrderItems oi
JOIN
    Orders o ON oi.OrderID = o.OrderID
JOIN
    Customers c ON o.CustomerID = c.CustomerID
GROUP BY
    oi.OrderID, c.Name, o.CustomerID
HAVING
    COUNT(*) > ALL (
        SELECT
            COUNT(*)
        FROM
            OrderItems oi2
        JOIN
            Orders o2 ON oi2.OrderID = o2.OrderID
        WHERE
            o2.CustomerID = o.CustomerID
            AND oi2.OrderID != oi.OrderID
        GROUP BY
            oi2.OrderID
    );



-- Find the names of customers whose total spending is greater than the average 
-- total spending of all customers.

-- Sample Output:
-- Name                                                                                                                    
-- Alice Johnson                                                                                                           
-- Bob Smith                                                                                                               
-- Charlie Davis                                                                                                           
-- George Clark 

USE fs;

SELECT Name
FROM Customers c
JOIN Orders o ON o.customerid = c.customerid
GROUP BY c.customerid
HAVING SUM(totalcost) > (
    SELECT AVG(tc)
    FROM (
        SELECT SUM(totalcost) AS tc
        FROM Orders i
        WHERE i.customerid != c.customerid
        GROUP BY i.customerid
    ) AS inner_table
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

