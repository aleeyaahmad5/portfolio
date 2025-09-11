--Encryption
USE Electro_World_Implementation;
create master key encryption by password = 'Rmit1234'
create certificate class_cert with subject = 'CLASS encryption key'


-- Proof master key exists
USE Electro_World_Implementation;
SELECT * 
FROM sys.symmetric_keys 
WHERE name = '##MS_DatabaseMasterKey##';

-- Proof class_cert exists
USE Electro_World_Implementation;
SELECT * 
FROM sys.certificates 
WHERE name = 'class_cert';



-- Confirm certificate works for encryption and decryption
USE Electro_World_Implementation;
DECLARE @encryptedText VARBINARY(MAX);

-- Encrypt sample text
SET @encryptedText = EncryptByCert(CERT_ID('class_cert'), 'Electro World Test Encryption');
-- Check the encrypted text
SELECT @encryptedText AS EncryptedText;
-- Decrypt sample text
DECLARE @decryptedText NVARCHAR(MAX);
SET @decryptedText = CONVERT(NVARCHAR(MAX), DecryptByCert(CERT_ID('class_cert'), @encryptedText));
-- Check the decrypted text (should return 'Electro World Test Encryption')
SELECT @decryptedText AS DecryptedText;
