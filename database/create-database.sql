create database proyecto1;
use proyecto1;

create table entidad
(
    id_entidad int(10) not null auto_increment,
    nb_entidad varchar(100),
    
    primary key (id_entidad)
);

create table persona
(
    id_persona int(10) not null auto_increment,
    nb_persona varchar(50) not null,
    tx_primer_ap varchar(50) not null,
    tx_segundo_ap varchar(50) not null,
    fh_nacimiento date not null,
    
    primary key (id_persona)
);

create table direccion
(
    id_persona int(10) not null,
    id_entidad int(10) not null,
    nb_calle varchar(100) not null,
    nb_colonia varchar(100) not null,
    nb_ciudad varchar(100) not null,
    tx_cp varchar(5) not null,
    
    primary key (id_persona)
);

create table usuario
(
    id_usuario int(10) not null,
    tx_login varchar(50) not null unique,
    tx_password varchar(15) not null,
    
    primary key (id_usuario)
);

alter table direccion
add index FKdireccion743004 (id_persona),
add constraint FKdireccion743004
foreign key (id_persona) references persona (id_persona);

alter table direccion
add index FKdireccion990290 (id_entidad),
add constraint FKdireccion990290
foreign key (id_entidad) references entidad (id_entidad);

alter table usuario
add index FKusuario892796 (id_usuario),
add constraint FKusuario892796
foreign key (id_usuario) references persona (id_persona);
