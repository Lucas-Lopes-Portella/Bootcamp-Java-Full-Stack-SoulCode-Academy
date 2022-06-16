USE empresa;

CREATE TABLE enderecos(
id INT PRIMARY KEY AUTO_INCREMENT UNIQUE,
logradouro VARCHAR(100),
numero INT,
bairro VARCHAR(100),
cidade VARCHAR(100),
estado VARCHAR(100),
cargo_id INT NOT NULL,
salario_id INT NOT NULL,
 FOREIGN KEY (cargo_id) REFERENCES cargo(id),
 FOREIGN KEY (salario_id) REFERENCES funcionario(id)
);

SELECT * FROM enderecos;

INSERT INTO enderecos (logradouro, numero, bairro, cidade, estado,cargo_id,salario_id)
	VALUES ("Rua F","12","Bairro 6","Ilhéus","Bahia","6","6");
    
UPDATE enderecos SET cidade = 'Niterói', estado = 'Rio de Janeiro'
WHERE id = 2;

UPDATE enderecos SET bairro = 'Bairro 5'
WHERE id = 5;


