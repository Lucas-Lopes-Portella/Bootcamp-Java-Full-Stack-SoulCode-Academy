USE empresa;

CREATE TABLE funcionario(
id INT PRIMARY KEY AUTO_INCREMENT UNIQUE,
salario INT,
cargo_id INT NOT NULL,
 FOREIGN KEY (cargo_id) REFERENCES cargo(id)
);

SELECT * FROM funcionario;

INSERT INTO funcionario (salario, cargo_id)
	VALUES ("0", "6")
