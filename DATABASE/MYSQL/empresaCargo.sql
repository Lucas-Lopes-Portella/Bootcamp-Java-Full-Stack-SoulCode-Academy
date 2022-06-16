-- CREATE DB
CREATE DATABASE empresa;

-- USE DB
USE empresa;

-- CREATE TABLE
CREATE TABLE cargo(
id INT PRIMARY KEY AUTO_INCREMENT UNIQUE,
nome VARCHAR(50) NOT NULL,
funcao VARCHAR(50) NOT NULL
);

-- INSERT VALUES IN THE TABLE
INSERT INTO cargo (name, positionInTheCompany)
	VALUES ("Carmela", "CEO - SoulCode Academy  ");
    
-- INSERT NO-POSITION
INSERT INTO cargo (name, positionInTheCompany)
	VALUES ("Lucas","");
    
-- ALTER TABLE
 ALTER TABLE cargo CHANGE funcao positionInTheCompany VARCHAR(50);
 
-- UPDATE
UPDATE cargo SET name = 'Rafael'
WHERE id = 5;
 
    
-- SELECT VALUES
SELECT * FROM cargo;

SELECT name AS Nome, positionInTheCompany AS Posição  
FROM cargo;

-- ALTER TABLE
 ALTER TABLE cargo CHANGE funcao positionInTheCompany VARCHAR(50);
 

 
 
 