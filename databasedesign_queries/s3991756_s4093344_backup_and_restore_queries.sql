--Backup and restore 
-- Backup database
BACKUP DATABASE Electro_World_Implementation
TO DISK = 'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER2019\MSSQL\Backup\s3991756_s4093344_backup.bak'
WITH FORMAT, 
     NAME = 'Electro World Full Backup';

-- Simulate a change in the database
USE Electro_World_Implementation;
GO

UPDATE Warehouse
SET WarehouseLocation = 'DamagedLocation'
WHERE WarehouseID = 'W001';
GO

-- Restore database and rename the restored copy
USE master;
GO

-- Set the database to single-user mode
ALTER DATABASE s3991756_s4093344_restored
SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
GO

-- Restore the database
RESTORE DATABASE s3991756_s4093344_restored
FROM DISK = 'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER2019\MSSQL\Backup\s3991756_s4093344_backup.bak'
WITH REPLACE,
MOVE 'Electro_World_Implementation' TO 'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER2019\MSSQL\Data\s3991756_s4093344_restored.mdf',
MOVE 'Electro_World_Implementation_log' TO 'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER2019\MSSQL\Data\s3991756_s4093344_restored_log.ldf';
GO

-- Set the database back to multi-user mode
ALTER DATABASE s3991756_s4093344_restored
SET MULTI_USER;
GO


-- Verify restoration
USE Electro_World_Implementation;
GO

SELECT * FROM Warehouse WHERE WarehouseID = 'W001';  
GO
