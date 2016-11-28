insert into usuario (id_user, dataacessoatual, dataultimoacesso, email, nome, password, username)
    values (1, '1990-01-01', '1990-01-01', 'emersoncantalicee@gmail.com', 'Emerson Cantalice', '123', 'escantalice'),
	   (2, '1990-01-01', '1990-01-01', 'dogllas12@hotmail.com', 'Doglas Lima', '123', 'shinigami');

insert into regraacesso (id, descricao, username)
    values (1, 'ROLE_ADMIN', 1),
	   (2, 'ROLE_GER', 1),
	   (3, 'ROLE_USER', 2);


insert into hospitais (id_hospital, bairo, cep, cidade, 
cnpj, complemento, estado, inscricao_estadual, nome, 
nome_fantasia, numero, rua, site, telefone)
    values (1, 'Cruzeiro', '58417-020', 'Campina Grande', '233.325.453/00001-98',
     'Proximo a rua A', 'Paraíba', '43567865-4', 'Clinica Escola da Facisa', 'CliCISA', '118',
      'Rua Dilma', 'www.cesed.com', '(56)78908-7657');

select column_name, data_type, character_maximum_length
from INFORMATION_SCHEMA.COLUMNS where table_name = 'regraacesso';

select * from usuario;
select * from pessoas;
select * from funcionario;