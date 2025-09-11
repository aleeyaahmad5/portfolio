

USE electro_world_implementation; 

GO 

  

-- Insert sample data into the Employee table first with NULL WarehouseID 

INSERT INTO Employee (EmployeeID, EmployeeJobTitle, EmployeeContactInfo, WarehouseID) 

VALUES  

('E001', 'Warehouse Manager', 'manager1@example.com', NULL),  -- Placeholder 

('E002', 'Assistant Manager', 'manager2@example.com', NULL),  -- Placeholder 

('E003', 'Inventory Specialist', 'inventory1@example.com', NULL),  -- Placeholder 

('E004', 'Warehouse Manager', 'manager3@example.com', NULL),  -- Placeholder 

('E005', 'Logistics Coordinator', 'logistics1@example.com', NULL),  -- Placeholder 

('E006', 'Supply Chain Analyst', 'analyst1@example.com', NULL),  -- Placeholder 

('E007', 'Warehouse Supervisor', 'supervisor1@example.com', NULL),  -- Placeholder 

('E008', 'Operations Manager', 'operations1@example.com', NULL),  -- Placeholder 

('E009', 'Warehouse Manager', 'manager4@example.com', NULL),  -- Placeholder 

('E010', 'Assistant Manager', 'assistant1@example.com', NULL);  -- Placeholder 

  

-- Insert sample data into the Warehouse table 

INSERT INTO Warehouse (WarehouseID, WarehousePhNumber, WarehouseLocation, WarehouseMaxCapacity, ManagerID) 

VALUES  

('W001', '(03) 1234 5678', '123 Warehouse St, City', 5000, 'E001'), 

('W002', '(03) 8765 4321', '456 Storage Rd, Town', 3000, 'E002'), 

('W003', '(03) 1122 3344', '789 Depot Ave, Village', 4500, 'E003'), 

('W004', '(03) 5566 7788', '101 Warehouse Ln, Metro', 2500, 'E004'), 

('W005', '(03) 9988 7766', '202 Facility Blvd, Center', 6000, 'E005'), 

('W006', '(03) 6655 4433', '303 Logistics Dr, North', 3200, 'E006'), 

('W007', '(03) 5544 2211', '404 Storage St, South', 2700, 'E007'), 

('W008', '(03) 4433 6677', '505 Supply Way, East', 3300, 'E008'), 

('W009', '(03) 8899 1122', '606 Inventory St, West', 4900, 'E009'), 

('W010', '(03) 7788 5566', '707 Stockyard St, Region', 2800, 'E010'); 

  

-- Update Employee records with the correct WarehouseID after inserting Warehouse data 

UPDATE Employee SET WarehouseID = 'W001' WHERE EmployeeID = 'E001'; 

UPDATE Employee SET WarehouseID = 'W002' WHERE EmployeeID = 'E002'; 

UPDATE Employee SET WarehouseID = 'W003' WHERE EmployeeID = 'E003'; 

UPDATE Employee SET WarehouseID = 'W004' WHERE EmployeeID = 'E004'; 

UPDATE Employee SET WarehouseID = 'W005' WHERE EmployeeID = 'E005'; 

UPDATE Employee SET WarehouseID = 'W006' WHERE EmployeeID = 'E006'; 

UPDATE Employee SET WarehouseID = 'W007' WHERE EmployeeID = 'E007'; 

UPDATE Employee SET WarehouseID = 'W008' WHERE EmployeeID = 'E008'; 

UPDATE Employee SET WarehouseID = 'W009' WHERE EmployeeID = 'E009'; 

UPDATE Employee SET WarehouseID = 'W010' WHERE EmployeeID = 'E010'; 

  

-- Insert sample data into the Supplier table 

INSERT INTO Supplier (SupplierID, SupplierName) 

VALUES  

('S001', 'TechSupplies Inc.'), 

('S002', 'ElectroGoods Co.'), 

('S003', 'DeviceHub Ltd.'), 

('S004', 'Component World'), 

('S005', 'GadgetGalaxy'), 

('S006', 'CircuitCity Inc.'), 

('S007', 'DigitalMart'), 

('S008', 'HardwareZone'), 

('S009', 'PartsPlus'), 

('S010', 'EquipSource'); 

  

-- Insert sample data into the Product table 

INSERT INTO Product (ProductNumber, ProductType, ProductBrand, ProductDescription, ProductPrice) 

VALUES  

('P001', 'Laptop', 'Apple', '13.3-inch laptop with Intel Core i5', 999.99), 

('P002', 'Smartphone', 'Samsung', 'Galaxy S21 Ultra 5G', 1199.99), 

('P003', 'Tablet', 'Microsoft', 'Surface Pro 7', 749.99), 

('P004', 'Headphones', 'Sony', 'WH-1000XM4 Noise Cancelling', 349.99), 

('P005', 'Monitor', 'Dell', '27-inch 4K UHD Monitor', 499.99), 

('P006', 'Smartwatch', 'Apple', 'Apple Watch Series 6', 399.99), 

('P007', 'Camera', 'Canon', 'EOS R5', 3899.99), 

('P008', 'Printer', 'HP', 'LaserJet Pro M404dn', 299.99), 

('P009', 'Router', 'Netgear', 'Nighthawk AX12', 499.99), 

('P010', 'SSD', 'Samsung', '1TB NVMe SSD', 149.99); 

  

-- Insert sample data into the Customer table 

INSERT INTO Customer (CustomerID, CustomerName, CustomerEmail, CustomerShippingAddress, CustomerPhoneNumber, CustomerPaymentInfo) 

VALUES  

('C001', 'John Doe', 'johndoe@example.com', '456 Customer St, City', '(03) 9876 5432', '1234 5678 9012 3456'), 

('C002', 'Jane Smith', 'janesmith@example.com', '789 Shopper Ave, Town', '(03) 4321 8765', '5678 1234 9012 3456'), 

('C003', 'Alice Brown', 'alicebrown@example.com', '101 Buyer Blvd, Village', '(03) 8765 4321', '9012 3456 5678 1234'), 

('C004', 'Bob White', 'bobwhite@example.com', '202 Retail Rd, Metro', '(03) 3344 5566', '3456 7890 1234 5678'), 

('C005', 'Charlie Green', 'charliegreen@example.com', '303 Purchase Pl, Center', '(03) 6655 7788', '7890 1234 5678 3456'), 

('C006', 'Diana Black', 'dianablack@example.com', '404 Consumer Ln, North', '(03) 9988 7766', '5678 9012 3456 1234'), 

('C007', 'Edward Grey', 'edwardgrey@example.com', '505 Market St, South', '(03) 4433 6677', '1234 5678 3456 7890'), 

('C008', 'Fiona Blue', 'fionablue@example.com', '606 Buyer St, East', '(03) 7788 5566', '9012 5678 1234 3456'), 

('C009', 'George Red', 'georgered@example.com', '707 Cart Ave, West', '(03) 8899 1122', '3456 7890 1234 5678'), 

('C010', 'Hannah Yellow', 'hannahayellow@example.com', '808 Shop Ln, Region', '(03) 1122 3344', '7890 3456 5678 9012'); 

  

  

-- Insert sample data into the Cust_Order table 

INSERT INTO Cust_Order (OrderID, OrderDate, OrderType, CustomerID) 

VALUES  

('O001', '2024-09-11', 'Customer', 'C001'), 

('O002', '2024-09-12', 'Business', 'C002'), 

('O003', '2024-09-13', 'Customer', 'C003'), 

('O004', '2024-09-14', 'Business', 'C004'), 

('O005', '2024-09-15', 'Customer', 'C005'), 

('O006', '2024-09-16', 'Business', 'C006'), 

('O007', '2024-09-17', 'Customer', 'C007'), 

('O008', '2024-09-18', 'Business', 'C008'), 

('O009', '2024-09-19', 'Customer', 'C009'), 

('O010', '2024-09-20', 'Business', 'C010'); 

  

-- Insert sample data into the Sale table 

INSERT INTO Sale (SalesID, SalesDate, SupplierID, NoOfSales) 

VALUES  

('SA001', '2024-09-11', 'S001', 50), 

('SA002', '2024-09-12', 'S002', 30), 

('SA003', '2024-09-13', 'S003', 40), 

('SA004', '2024-09-14', 'S004', 20), 

('SA005', '2024-09-15', 'S005', 60), 

('SA006', '2024-09-16', 'S006', 70), 

('SA007', '2024-09-17', 'S007', 80), 

('SA008', '2024-09-18', 'S008', 90), 

('SA009', '2024-09-19', 'S009', 100), 

('SA010', '2024-09-20', 'S010', 110); 

  

-- Insert sample data into the Cust_Order_Product table 

INSERT INTO Cust_Order_Product (OrderID, ProductNumber, ProductQuantity) 

VALUES  

('O001', 'P001', 2), 

('O002', 'P002', 3), 

('O003', 'P003', 1), 

('O004', 'P004', 5), 

('O005', 'P005', 4), 

('O006', 'P006', 6), 

('O007', 'P007', 2), 

('O008', 'P008', 3), 

('O009', 'P009', 1), 

('O010', 'P010', 2); 

 