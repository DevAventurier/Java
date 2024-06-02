
use emploidutemps;

drop table Enseignants;

create table Enseignants(
N_Enseignant SMALLINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
name varchar (100) not null,
prenom varchar(100) not null,
tel varchar (50) not null,
matricule varchar (50) not null,
email varchar(100)not null)ENGINE=INNODB;

drop table matiere;
create table matiere(
N_matiere SMALLINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
intitule varchar (100) not null,
codes varchar(100) not null)ENGINE=INNODB;

drop table classe;
create table classe(
N_classe SMALLINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
intitule varchar (100) not null,
codes varchar(100) not null)ENGINE=INNODB;

drop table anneescolaire;
create table anneescolaire(
N_anneescolaire SMALLINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
codes varchar (100) not null,
datedebut varchar(100) not null,
datefin varchar (50) not null)ENGINE=INNODB;

drop table cours;
create table cours(
N_cours SMALLINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
matiere varchar (100) not null,
enseignant varchar(100) not null,
classe varchar (50)not null,
anneescolaire varchar(20) not null)ENGINE=INNODB;
drop table emploidutemps;

create table emploidutemps(
N_temps SMALLINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
enseignant varchar (100) not null,
cours varchar(100) not null,
heuredebut varchar (50) not null,
heurefin varchar (50) not null,
salle varchar(50)not null)ENGINE=INNODB;


show tables;
desc enseignants;
select * from enseignants;
-- delete from enseignants where N_Enseignant = 6;

select * from matiere;
-- delete from matiere where N_matiere = 7;

select * from classe;
select * from cours;

select * from anneescolaire;
select * from emploidutemps;



