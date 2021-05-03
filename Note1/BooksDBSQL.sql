USE testspring;
CREATE TABLE IF NOT EXISTS Books(
	idBook INT NOT NULL,
    nameBook VARCHAR(45) NOT NULL,
    yearEdition INT NOT NULL,
    descript VARCHAR(200) ,
    linkImg VARCHAR(200),
    author VARCHAR(20),
    price DECIMAL(15,2) NOT NULL,
    category VARCHAR(15),
    PRIMARY KEY(idBook)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO Books (idBook, nameBook, yearEdition,descript,linkImg,author,price,category) VALUES (100001,'Văn học 1',2020,'Sách văn học 1',NULL,'Nguyễn A',100000,'Văn học');
INSERT INTO Books (idBook, nameBook, yearEdition,descript,linkImg,author,price,category) VALUES (101001,'Toán học 1',2020,'Sách toán học 1',NULL,'Nguyễn B',100000,'Toán học');
INSERT INTO Books (idBook, nameBook, yearEdition,descript,linkImg,author,price,category) VALUES (101002,'Toán học 2',2021,'Sách toán học 2',NULL,'Văn B',120000,'Toán học');
INSERT INTO Books (idBook, nameBook, yearEdition,descript,linkImg,author,price,category) VALUES (100002,'Học Văn',2016,'Văn is iz',NULL,'Cao A',65000,'Văn học');
INSERT INTO Books (idBook, nameBook, yearEdition,descript,linkImg,author,price,category) VALUES (100003,'Giết con chim nhại',1960,'nhiều mô - tuýp',NULL,'Harper Lee',105000,'Văn học');
INSERT INTO Books (idBook, nameBook, yearEdition,descript,linkImg,author,price,category) VALUES (101003,'Giải tích hàm',2018,'Toán và hơn toán',NULL,'Hoàng Tụy',114000,'Toán học');

