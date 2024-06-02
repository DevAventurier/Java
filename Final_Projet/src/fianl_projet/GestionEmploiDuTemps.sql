create database emploidutemps;
use emploidutemps;

create table Enseignants(
N_Enseignant SMALLINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
name varchar (100) not null,
prenom varchar(100) not null,
tel varchar (50) not null,
email varchar(100)not null)ENGINE=INNODB;

create table matiere(
N_matiere SMALLINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
intitule varchar (100) not null,
codes varchar(100) not null)ENGINE=INNODB;

create table classe(
N_classe SMALLINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
intitule varchar (100) not null,
codes varchar(100) not null)ENGINE=INNODB;

create table anneescolaire(
N_anneescolaire SMALLINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
codes varchar (100) not null,
datedebut varchar(100) not null,
datefin varchar (50) not null)ENGINE=INNODB;

create table cours(
N_cours SMALLINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
matiere varchar (100) not null,
enseignant varchar(100) not null,
classe varchar (50)not null,
anneescolaire varchar(20) not null)ENGINE=INNODB;

create table emploidutemps(
N_temps SMALLINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
enseignant varchar (100) not null,
cours varchar(100) not null,
heuredebut varchar (50) not null,
heurefin varchar (50) not null,
salle varchar(50)not null)ENGINE=INNODB;


select * from enseignants;
select * from matiere;
select * from classe;
select * from cours;
select * from anneescolaire;
select * from emploidutemps;



