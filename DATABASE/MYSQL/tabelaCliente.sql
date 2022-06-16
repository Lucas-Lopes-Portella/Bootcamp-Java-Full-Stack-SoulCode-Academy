CREATE TABLE cliente(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    animal_id INT NOT NULL,
    FOREIGN KEY (animal_id) REFERENCES animal(id)
    
)

SELECT * FROM cliente;

INSERT INTO cliente(nome,email,animal_id)
	VALUES ("zé","zezé@gmail.com","3");
    
