create database BDConta
go
use BDConta

create table Conta (

nome varchar(100) not null,
conta varchar(10) not null,
numCartao varchar(16) not null,
senha varchar(50) not null,
saldo DECIMAL (100,2) not null,
banco varchar(15) not null,
agencia varchar(4) not null,

primary key(conta)
)

select * from Conta

create table Cedulas (

n2 int, 
n5 int,
n10 int,
n20 int,
n50 int,
n100 int,

)

select * from Cedulas

insert into Cedulas(n2, n5, n10, n20, n50, n100) values
(100, 100, 100, 100, 100, 100)

/*update Cedulas set
 n2 = 50,
 n5 = 11,
 n10 = 24,
 n20 = 34,
 n50 = 24,
 n100 = 44*/


update Cedulas set
 n2 = n2 - 1,
 n5 = n5 - 1,
 n10 = n10 - 1,
 n20 = n20 - 1,
 n50 = n50 - 1,
 n100 = n100 - 1