CREATE DATABASE `momento_valorativo`;

CREATE TABLE `alumnos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `edad` int NOT NULL,
  `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `deletedAt` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3;

CREATE TABLE `cursos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre_curso` varchar(50) NOT NULL,
  `profesor` varchar(80) NOT NULL,
  `descripcion` text NOT NULL,
  `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `deletedAt` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3;


create table `horarios`(
  `id_estudiante` int NOT NULL,
  `id_curso` int NOT NULL,
  `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `deletedAt` timestamp NULL DEFAULT null,
  foreign key (`id_estudiante`) references `alumnos`(`id`),
  foreign key (`id_curso`) references `cursos`(`id`)
);

INSERT INTO `alumnos`(`nombre`,`apellidos`,`edad`) values ('Santiago','TORRES AGUIRRE',20);
INSERT INTO `alumnos`(`nombre`,`apellidos`,`edad`) values ('Oscar','Mesa',20);

INSERT INTO `cursos`(`nombre_curso`,`profesor`,`descripcion`) values ('CES','John Faber','Materia de Ingenieria');
INSERT INTO `cursos`(`nombre_curso`,`profesor`,`descripcion`) values ('ETICA','Gloria','Se da en todas las carreras');

insert into `horarios`(`id_estudiante`,`id_curso`) values (1,1);
insert into `horarios`(`id_estudiante`,`id_curso`) values (1,2);