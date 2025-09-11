

-- Step 1: Create tables that have no dependencies on others 

-- Create Supplier table 

CREATE TABLE Supplier ( 

    SupplierID VARCHAR(10) PRIMARY KEY, 

    SupplierName VARCHAR(50) 

); 

  

-- Create Product table 

CREATE TABLE Product ( 

    ProductNumber VARCHAR(10) PRIMARY KEY, 

    ProductType VARCHAR(20), 

    ProductBrand VARCHAR(20), 

    ProductDescription VARCHAR(255), 

    ProductPrice DECIMAL(10, 2) 

); 

  

-- Create Customer table 

CREATE TABLE Customer ( 

    CustomerID VARCHAR(10) PRIMARY KEY, 

    CustomerName VARCHAR(50), 

    CustomerEmail VARCHAR(50), 

    CustomerShippingAddress VARCHAR(100), 

    CustomerPhoneNumber VARCHAR(15), 

    CustomerPaymentInfo VARCHAR(50) 

); 

  

-- Create Employee table (without foreign key) 

CREATE TABLE Employee ( 

    EmployeeID VARCHAR(10) PRIMARY KEY, 

    EmployeeJobTitle VARCHAR(30), 

    EmployeeContactInfo VARCHAR(50) 

); 

  

-- Step 2: Create tables with dependencies 

-- Create Warehouse table, referencing Employee for ManagerID 

CREATE TABLE Warehouse ( 

    WarehouseID VARCHAR(10) PRIMARY KEY, 

    WarehousePhNumber VARCHAR(15), 

    WarehouseLocation VARCHAR(100), 

    WarehouseMaxCapacity INT, 

    ManagerID VARCHAR(10), 

    FOREIGN KEY (ManagerID) REFERENCES Employee(EmployeeID) 

); 

  

-- Alter Employee table to add WarehouseID foreign key after Warehouse is created 

ALTER TABLE Employee 

ADD WarehouseID VARCHAR(10), 

FOREIGN KEY (WarehouseID) REFERENCES Warehouse(WarehouseID); 

  

-- Create Cust_Order table with foreign key referencing Customer 

CREATE TABLE Cust_Order ( 

    OrderID VARCHAR(10) PRIMARY KEY, 

    OrderDate DATETIME, 

    OrderType VARCHAR(20), 

    CustomerID VARCHAR(10), 

    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID) 

); 

  

-- Create Sale table with foreign key referencing Supplier 

CREATE TABLE Sale ( 

    SalesID VARCHAR(10) PRIMARY KEY, 

    SalesDate DATETIME, 

    SupplierID VARCHAR(10), 

    NoOfSales INT, 

    FOREIGN KEY (SupplierID) REFERENCES Supplier(SupplierID) 

); 

  

-- Create CUST_ORDER_PRODUCT table as a bridging table for Cust_Order and Product 

CREATE TABLE CUST_ORDER_PRODUCT ( 

    OrderID VARCHAR(10), 

    ProductNumber VARCHAR(10), 

	ProductQuantity INT, 

    PRIMARY KEY (OrderID, ProductNumber), 

    FOREIGN KEY (OrderID) REFERENCES Cust_Order(OrderID), 

    FOREIGN KEY (ProductNumber) REFERENCES Product(ProductNumber) 

); 

  

  