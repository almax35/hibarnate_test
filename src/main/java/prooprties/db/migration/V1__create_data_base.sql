CREATE TABLE IF NOT EXISTS `car` (
                       `idCar` int NOT NULL AUTO_INCREMENT,
                       `cost` float NOT NULL,
                       `idOwner` int NOT NULL,
                       PRIMARY KEY (`idCar`),
                       UNIQUE KEY `idCar_UNIQUE` (`idCar`),
                       KEY `fk1_idx` (`idOwner`),
                       KEY `fk_idx` (`idOwner`),
                       CONSTRAINT `fk` FOREIGN KEY (`idOwner`) REFERENCES `owner` (`idOwner`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE IF NOT EXISTS `owner` (
                         `idOwner` int NOT NULL AUTO_INCREMENT,
                         `name` varchar(45) DEFAULT NULL,
                         `birthday` date DEFAULT NULL,
                         PRIMARY KEY (`idOwner`),
                         UNIQUE KEY `idOwner_UNIQUE` (`idOwner`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

