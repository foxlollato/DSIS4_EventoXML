create user evento identified by evento;
grant all privileges to evento;

create table evento.atividade(
tipo varchar(30),
titulo varchar(100),
diaHora TIMESTAMP,
responsavel varchar(30)
);

select * from evento.atividade;
