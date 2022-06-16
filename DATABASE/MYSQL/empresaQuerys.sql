-- SALARIO + FUNCIONARIO
SELECT name AS Nome, positionInTheCompany AS Cargo, salario AS Salario
	FROM funcionario
    INNER JOIN cargo
    on funcionario.cargo_id = cargo.id;
    
SELECT *
	FROM funcionario 
    RIGHT JOIN cargo 
    on funcionario.cargo_id = cargo.id;
	
SELECT *
	FROM funcionario 
    LEFT JOIN cargo 
    on funcionario.cargo_id = cargo.id;


--  SALARIO + FUNCIONARIO + CARGO


SELECT name AS Nome, estado AS Estado, salario AS Salario
	FROM enderecos
    INNER JOIN funcionario
    on funcionario.cargo_id = enderecos.id
    INNER JOIN cargo
    on cargo.id = funcionario.cargo_id
    WHERE salario > 3000 AND estado = 'Rio de Janeiro';


    


    

    
