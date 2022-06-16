-- SELECIONAR DADOS DA TABELA
SELECT * FROM animal;

-- INSERIR DADOS NA TABELA
INSERT INTO animal (nome, especie, nascimento)
	VALUES ("Girilo", "Hamster",'2022-04-03');


    
-- WHERE --> especificar qual(is) registros queremos
SELECT * FROM animal WHERE nome = "Café";


-- ALTERAR TABELA
ALTER TABLE animal ADD COLUMN raca VARCHAR(60);
ALTER TABLE animal DROP COLUMN raca;
ALTER TABLE animal CHANGE data_nascimento nascimento DATE;

-- ALTERAR CONTEÚDO DA TABELA
UPDATE animal SET nome = 'Toddy'
WHERE id = 2;

DELETE FROM animal WHERE id = 2;