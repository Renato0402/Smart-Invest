drop table if exists clientes;

create table if not exists clientes(
    id int auto_increment not null,
    nome varchar(30) not null,
    saldo double not null,
    compartilhado bool not null default false,

    primary key(id)
);

create table if not exists corretoras(
    id int auto_increment not null,
    nome varchar(30) not null,
    extrato double not null,

    primary key(id)
);

create table if not exists investimentos(
    id int auto_increment not null,
	nome varchar(50) not null,
	cliente_id int not null,
	corretora_id int not null,

	primary key(id),
	foreign key(cliente_id) references clientes(id),
	foreign key(corretora_id) references corretoras(id)
);

create table if not exists historicos(
    id int auto_increment not null,
    valor_investido double not null,
	data_realizada date not null,
	investimento_id int not null,

	primary key(id),
	foreign key(investimento_id) references investimentos(id)
);

insert into clientes(nome, saldo, compartilhado) values
('Paulo', 1250.50, false),
('Renato', 1250.50, true),
('Victor', 1250.50, false),
('Igor', 1250.50, true);

insert into corretoras(nome, extrato) values
('CORRETORA A', 100.0),
('CORRETORA B', 100.0),
('CORRETORA C', 100.0);

insert into investimentos(nome, cliente_id, corretora_id) values
('INVESTIMENTO A', 1, 1),
('INVESTIMENTO B', 2, 1),
('INVESTIMENTO C', 3, 2),
('INVESTIMENTO D', 2, 3),
('INVESTIMENTO EEEEE', 2, 2),
('INVESTIMENTOFFFF', 4, 2),
('INVESTIMENTO DSADSA', 2, 3),
('INVESTIMENTO DSFSDF', 3, 3),
('INVESTIMENTO DFGDFJGDG', 3, 1),
('INVESTIMENTO DFJSDFOJSDFO', 3, 2);

insert into historicos(investimento_id, valor_investido, data_realizada) values
(1, 2000.0, to_date('11-02-2020', 'd-m-Y')),
(1, 1520.0, to_date('21-06-2020', 'd-m-Y')),
(1, 20.6, to_date('01-03-2020', 'd-m-Y')),
(1, 100.0, to_date('31-06-2020', 'd-m-Y'));