-- JOIN

SELECT animal.nome, animal.especie, cliente.nome, cliente.email
FROM animal JOIN cliente
ON animal.id = cliente.animal_id