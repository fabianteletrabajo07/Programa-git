create database if not exists emprendimiento;
use emprendimiento;

create table clientes (
cedula int primary key,
nombre varchar(100) not null,
celular varchar(20));

create table citas (
id_cita int auto_increment primary key,
fecha date not null,
hora time not null,
servicio varchar(100),
cliente_cedula int,
constraint fk_cliente foreign key (cliente_cedula)
references clientes(cedula) on delete cascade
);