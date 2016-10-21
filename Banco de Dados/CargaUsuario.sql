select * from usuario;

insert into usuario (id, dataacessoatual, dataultimoacesso, email, nome, password, username)
    values (1, '1990-01-01', '1990-01-01', 'emersoncantalicee@gmail.com', 'Emerson Cantalice', '123', 'escantalice'),
	   (2, '1990-01-01', '1990-01-01', 'dogllas12@hotmail.com', 'Doglas Lima', '123', 'shinigami');

select * from regraacesso; 

select column_name, data_type, character_maximum_length
from INFORMATION_SCHEMA.COLUMNS where table_name = 'regraacesso';

insert into regraacesso (id, descricao, username)
    values (1, 'ROLE_ADMIN', 1),
	   (2, 'ROLE_GER', 1),
	   (3, 'ROLE_USER', 2);