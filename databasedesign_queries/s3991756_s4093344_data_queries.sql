 
USE Electro_World_Implementation; 

GO 

  

-- A.1 Display all records from each table 

  

-- Display all records from Warehouse 

SELECT * FROM Warehouse; 

  

-- Display all records from Supplier 

SELECT * FROM Supplier; 

  

-- Display all records from Product 

SELECT * FROM Product; 

  

-- Display all records from Customer 

SELECT * FROM Customer; 

  

-- Display all records from Employee 

SELECT * FROM Employee; 

  

-- Display all records from Cust_Order 

SELECT * FROM Cust_Order; 

  

-- Display all records from Sale 

SELECT * FROM Sale; 

  

-- Display all records from CUST_ORDER_PRODUCT 

SELECT * FROM CUST_ORDER_PRODUCT; 

  

-- A.2 Data Dictionary 

-- (Document the data dictionary separately as outlined before) 

  

-- B.1 Add a new attribute to the Customer table (DOB) 

ALTER TABLE Customer 

ADD DOB DATE; 

  

-- B.2 Update all customer records with DOB 

UPDATE Customer 

SET DOB = '1985-01-15' WHERE CustomerID = 'C001'; -- John Doe 

UPDATE Customer 

SET DOB = '1990-02-20' WHERE CustomerID = 'C002'; -- Jane Smith 

UPDATE Customer 

SET DOB = '1988-03-10' WHERE CustomerID = 'C003'; -- Alice Brown 

UPDATE Customer 

SET DOB = '1983-04-05' WHERE CustomerID = 'C004'; -- Bob White 

UPDATE Customer 

SET DOB = '1992-05-25' WHERE CustomerID = 'C005'; -- Charlie Green 

UPDATE Customer 

SET DOB = '1987-06-15' WHERE CustomerID = 'C006'; -- Diana Black 

UPDATE Customer 

SET DOB = '1991-07-22' WHERE CustomerID = 'C007'; -- Edward Grey 

UPDATE Customer 

SET DOB = '1989-08-14' WHERE CustomerID = 'C008'; -- Fiona Blue 

UPDATE Customer 

SET DOB = '1986-09-30' WHERE CustomerID = 'C009'; -- George Red 

UPDATE Customer 

SET DOB = '1993-10-01' WHERE CustomerID = 'C010'; -- Hannah Yellow 

  

-- C.1 Display all records from the Customer table sorted 

SELECT * FROM Customer 

ORDER BY  

    SUBSTRING(CustomerName, CHARINDEX(' ', CustomerName) + 1, LEN(CustomerName)) DESC,  -- Last Name 

    SUBSTRING(CustomerName, 1, CHARINDEX(' ', CustomerName) - 1) ASC;                         -- First Name 

  

-- C.2 Display Suppliers whose name starts with a certain letter 

SELECT * FROM Supplier 

WHERE SupplierName LIKE 'T%'; 

  

-- C.3 Display all Orders made before a certain date 

SELECT * FROM Cust_Order 

WHERE OrderDate < '2024-09-16 00:00:00.000'; -- Change date as needed 

  

-- C.4 Add Stock attribute to the Product table 

ALTER TABLE Product 

ADD Stock INT; 

  

-- Update stock values for the products 

UPDATE Product SET Stock = 10 WHERE ProductNumber = 'P001'; 

UPDATE Product SET Stock = 5 WHERE ProductNumber = 'P002'; 

UPDATE Product SET Stock = 7 WHERE ProductNumber = 'P003'; 

UPDATE Product SET Stock = 2 WHERE ProductNumber = 'P004'; 

UPDATE Product SET Stock = 4 WHERE ProductNumber = 'P005'; 

UPDATE Product SET Stock = 1 WHERE ProductNumber = 'P006'; 

UPDATE Product SET Stock = 3 WHERE ProductNumber = 'P007'; 

UPDATE Product SET Stock = 6 WHERE ProductNumber = 'P008'; 

UPDATE Product SET Stock = 2 WHERE ProductNumber = 'P009'; 

UPDATE Product SET Stock = 8 WHERE ProductNumber = 'P010'; 

  

-- Calculate total value of all products in stock 

SELECT SUM(ProductPrice * Stock) AS TotalValue FROM Product; 

  

-- C.5 Display all Customers from specified suburbs 

SELECT * FROM Customer 

WHERE CustomerShippingAddress LIKE '%Purchase Pl, Centera%' OR CustomerShippingAddress LIKE '%Consumer Ln, North%'; -- Change suburbs as needed 

  

-- C.6 Display Products with price greater than a certain amount and stock less than a certain amount 

SELECT * FROM Product 

WHERE ProductPrice > 50 AND Stock < 3; -- Change values as needed 

  

-- C.7 Display the youngest customer's name and DOB 

SELECT TOP 1 CustomerName, DOB  

FROM Customer 

ORDER BY DOB DESC; 

  