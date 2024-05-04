CREATE DATABASE `database_evaluative_moment`;

CREATE TABLE `students` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `lastName` varchar(100) NOT NULL,
  `age` int NOT NULL,
  `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `deletedAt` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3;

CREATE TABLE `courses` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name_course` varchar(50) NOT NULL,
  `teacher` varchar(80) NOT NULL,
  `description` text NOT NULL,
  `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `deletedAt` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3;


create table `schedules`(
  `id_student` int NOT NULL,
  `id_course` int NOT NULL,
  `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `deletedAt` timestamp NULL DEFAULT null,
  foreign key (`id_student`) references `students`(`id`),
  foreign key (`id_course`) references `courses`(`id`)
);

INSERT INTO `students`(`name`,`lastName`,`age`) values ('Santiago','TORRES AGUIRRE',20);
INSERT INTO `students`(`name`,`lastName`,`age`) values ('Oscar','Mesa',20);

INSERT INTO `courses`(`name_course`,`teacher`,`description`) values ('CES','John Faber','Materia de Ingenieria');
INSERT INTO `courses`(`name_course`,`teacher`,`description`) values ('ETICA','Gloria','Se da en todas las carreras');

insert into `schedules`(`id_student`,`id_course`) values (1,1);
insert into `schedules`(`id_student`,`id_course`) values (1,2);