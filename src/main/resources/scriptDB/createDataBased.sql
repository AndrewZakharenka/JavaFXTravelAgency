create schema if not exists travelagency collate utf8_general_ci;

create table if not exists clients
(
	idClients int auto_increment
		primary key,
	Name varchar(45) null,
	Surname varchar(45) null,
	SerialPassport varchar(2) null,
	NumberPassport varchar(7) null,
	Address varchar(100) null
);

create table if not exists roles
(
	idRoles int not null
		primary key,
	Name varchar(45) null
);

create table if not exists users
(
	idUsers int auto_increment
		primary key,
	Name varchar(45) not null,
	Surname varchar(45) not null,
	Login varchar(45) not null,
	Password varchar(45) not null,
	IdRoles int null,
	constraint IdRoles
		foreign key (IdRoles) references roles (idRoles)
);

create table if not exists tours
(
	idTours int auto_increment
		primary key,
	Departure varchar(45) not null,
	Arive varchar(45) not null,
	Price double null,
	Hotel varchar(45) null,
	IdUsers int null,
	IdClients int null,
	constraint IdClients
		foreign key (IdClients) references clients (idClients),
	constraint IdUsers
		foreign key (IdUsers) references users (idUsers)
);

create index IdClients_idx
	on tours (IdClients);

create index IdUsers_idx
	on tours (IdUsers);

create index Roles_idx
	on users (IdRoles);

