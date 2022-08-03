CREATE DATABASE servicesdb;



DROP DATABASE servicesdb;

DROP table called;
DROP table cargo;
DROP table employee;




USE servicesdb;




SELECT * FROM client;
SELECT * FROM employee;
SELECT * FROM cargo;
SELECT * FROM address;
SELECT * FROM payment;
SELECT * FROM called;
SELECT * FROM user;


SELECT * FROM payment WHERE status_payment = "PAID";

SELECT * FROM called WHERE status = "ATRIBUIDO";
SELECT * FROM called WHERE date_register BETWEEN '2022-06-20' AND '2022-06-27';

SELECT * FROM employee WHERE id_cargo = 1;

SELECT  payment.*, called.id_called, called.tittle, client.id_client, client.name 
FROM called RIGHT JOIN payment ON  payment.id_payment = called.id_called 
LEFT JOIN client ON client.id_client = called.id_called;


INSERT INTO user VALUES (NULL, "jose@gmail.com", "$2a$10$4.hW1gxsAbrO1mOQIZ11OeXwvKOBQLLEN58XYZXJuzTZh3MASfy8G
");
