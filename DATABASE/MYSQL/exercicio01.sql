CREATE DATABASE meubanco;
USE meubanco;
DROP DATABASE meubanco;

-- CRIAR BANCO DE DADOS
CREATE DATABASE petshop;

-- USAR TABELA
USE petshop;

-- TIPOS DE DADOS
-- VARCHAR --> texto
-- INT, DOUBLE --> valores numéricos
-- DATE --> datas


-- CRIAR TABELA 
CREATE TABLE animal(
	id INT PRIMARY KEY AUTO_INCREMENT UNIQUE,
    nome VARCHAR(50) NOT NULL,
    especie VARCHAR(50),
    data_nascimento DATE

);






























