create user evento identified by evento;
grant all privileges to evento;

create table evento.atividade(
tipo varchar(30),
titulo varchar(100),
dia date,
horario timestamp,
responsavel varchar(30)
);

drop table evento.atividade;
delete from evento.atividade;
select  * from evento.atividade;

commit;