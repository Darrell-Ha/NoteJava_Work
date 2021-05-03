CREATE SCHEMA IF NOT EXISTS testspring;
USE testspring;
CREATE TABLE IF NOT EXISTS user(
	idUser INT NOT NULL AUTO_INCREMENT ,
    UserName VARCHAR(45) NOT NULL,
	Password VARCHAR(45) NOT NULL,
	email VARCHAR(45) DEFAULT NULL,
	sdt VARCHAR(45) DEFAULT NULL,
    PRIMARY KEY(idUser)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO user (idUser, UserName, Password, email, sdt) VALUES (1, 'nameus1','12345614','nameus1@gmail.com','0978456123'); 
INSERT INTO user (idUser, UserName, Password, email, sdt) VALUES (2, 'nameus2','12354645','nameus2@gmail.com','0346713187'); 
INSERT INTO user (idUser, UserName, Password, email, sdt) VALUES (3, 'nameus3','12341212','nameus3@gmail.com','0246571347'); 
INSERT INTO user (idUser, UserName, Password, email, sdt) VALUES (4, 'nameus4','12345341','nameus4@gmail.com','0431879531'); 
INSERT INTO user (idUser, UserName, Password, email, sdt) VALUES (5, 'nameus5','12341545','nameus5@gmail.com','0348977561'); 
INSERT INTO user (idUser, UserName, Password, email, sdt) VALUES (6, 'nameus6','11513112','nameus6@gmail.com','0345676517'); 
INSERT INTO user (idUser, UserName, Password, email, sdt) VALUES (7, 'nameus7','41432154','nameus7@gmail.com','0973127811'); 
INSERT INTO user (idUser, UserName, Password, email, sdt) VALUES (8, 'nameus8','11153164','nameus8@gmail.com','097317871/'); 
INSERT INTO user (idUser, UserName, Password, email, sdt) VALUES (9, 'nameus9','15322164','nameus9@gmail.com','0123875643'); 