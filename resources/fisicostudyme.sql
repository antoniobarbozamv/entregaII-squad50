-- Entrega - Squad 50

CREATE TABLE Perfis (
avaliacoes VARCHAR(300),
sobre_mim VARCHAR(500),
id_perfil INTEGER PRIMARY KEY auto_increment
);

CREATE TABLE Cadastros (
tipo_perfil VARCHAR(10),
senha VARCHAR(15),
nome VARCHAR(50),
email VARCHAR(20),
id_cadastro INTEGER PRIMARY KEY auto_increment
);

CREATE TABLE Feeds (
reacoes INTEGER,
data_post DATETIME,
comentario VARCHAR(600),
id_post INTEGER PRIMARY KEY auto_increment
);
