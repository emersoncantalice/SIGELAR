
create database SIGELAR;

    create table Funcionario (
        dataAcessoAtual timestamp not null,
        dataUltimaAlteracao date not null,
        dataUltimoAcesso timestamp not null,
        funcao varchar(100),
        nome varchar(300) not null,
        password varchar(32) not null,
        role varchar(32) not null,
        username varchar(32) not null,
        id int8 not null,
        primary key (id)
    );

    create table Paciente (
        plano_de_saude varchar(15),
        id int8 not null,
        primary key (id)
    );

    create table RegraAcesso (
        id int8 not null,
        descricao varchar(15) not null,
        username int8 not null,
        primary key (id)
    );

    create table Usuario (
        id_user int8 not null,
        dataAcessoAtual timestamp not null,
        dataUltimoAcesso timestamp not null,
        email varchar(50) not null,
        nome varchar(300) not null,
        password varchar(32) not null,
        username varchar(32) not null,
        id_almoxarifado int8,
        primary key (id_user)
    );

    create table almoxarifado (
        id_almoxarifado  bigserial not null,
        primary key (id_almoxarifado)
    );

    create table consultas (
        id_usuario  bigserial not null,
        data_consulta timestamp not null,
        primary key (id_usuario)
    );

    create table hospitais (
        id_hospital  bigserial not null,
        bairo varchar(100) not null,
        cep varchar(15) not null,
        cidade varchar(100) not null,
        cnh varchar(15) not null,
        nome varchar(100) not null,
        numero varchar(5) not null,
        rua varchar(100) not null,
        primary key (id_hospital)
    );

    create table medicos (
        id_medico int8 not null,
        crea varchar(15),
        primary key (id_medico)
    );

    create table pessoas (
        id_pessoa int8 not null,
        cpf varchar(11) not null,
        nome varchar(100) not null,
        primary key (id_pessoa)
    );

    create table prescricoes_medicas (
        id_prescricao int8 not null,
        data_emicao date,
        data_validade date,
        dosagem varchar(50),
        prescricao varchar(200),
        quantidade varchar(4),
        primary key (id_prescricao)
    );

    create table produtos (
        id_produto int8 not null,
        codigo_produto varchar(20) not null,
        nome varchar(100) not null,
        quantidade int4 not null,
        referencia varchar(50) not null,
        id_almoxarifado int8,
        primary key (id_produto)
    );

    alter table Usuario 
        add constraint UK_471i15k6vbj1lfsfb19getcdi unique (username);
 
    alter table produtos 
        add constraint UK_s6k1hxg3cysks5ofysv0jhhdh unique (codigo_produto);
 
    alter table produtos 
        add constraint UK_68les18ejq8cjyxw9snrbtd7t unique (nome);

    alter table produtos 
        add constraint UK_q7u1mtj26qlddirg4en9h3jo7 unique (referencia);
 
    alter table Funcionario 
        add constraint FK_2acj82h4rhnhdo9h135ylcj83 
        foreign key (id) 
        references pessoas;

    alter table Funcionario 
        add constraint FK_2acj82h4rhnhdo9h135ylcj83 
        foreign key (id) 
        references Usuario;

    alter table Paciente 
        add constraint FK_1v7x7cppa4eqwj7ksl2wffxgf 
        foreign key (id) 
        references pessoas;

    alter table RegraAcesso 
        add constraint FK_h5dbc9hsbo4vmb60v9xqhdivj 
        foreign key (username) 
        references Usuario;

    alter table Usuario 
        add constraint FK_huev1se6q326387p5fevalh5 
        foreign key (id_almoxarifado) 
        references almoxarifado;

    alter table consultas 
        add constraint FK_nief1ey3qtdb2g8m3lnmgs96q 
        foreign key (id_usuario) 
        references prescricoes_medicas;
 
    alter table consultas 
        add constraint FK_nief1ey3qtdb2g8m3lnmgs96q 
        foreign key (id_usuario) 
        references Paciente;

    alter table consultas 
        add constraint FK_nief1ey3qtdb2g8m3lnmgs96q 
        foreign key (id_usuario) 
        references medicos;

    alter table medicos 
        add constraint FK_ftnvnrttchplpcvsofe0bvaly 
        foreign key (id_medico) 
        references Usuario;

    alter table pessoas 
        add constraint FK_mrdcrsty4vq5q7hj9to007ka2 
        foreign key (id_pessoa) 
        references hospitais;

    alter table prescricoes_medicas 
        add constraint FK_51f7qykm6bnh8j6nqhmy1qpgw 
        foreign key (id_prescricao) 
        references consultas;

    alter table produtos 
        add constraint FK_hv00dvffhooxomghv2ssoq06w 
        foreign key (id_almoxarifado) 
        references almoxarifado;


