-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: web_phim
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accounts` (
  `account_name` varchar(50) NOT NULL,
  `password` varchar(500) NOT NULL,
  `is_enabled` tinyint DEFAULT '0',
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`account_name`),
  UNIQUE KEY `client_id_UNIQUE` (`user_id`),
  KEY `role_id_idx` (`role_id`),
  CONSTRAINT `role_id` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`) ON UPDATE CASCADE,
  CONSTRAINT `user_id_accounts` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES ('Hieu','$2a$10$kYqE9rSpYBry8kB.h6rPDuP4xY3x/I0kzL8x69HsAAI0naAbY7u3a',1,1,2),('Hieu1','$2a$10$yWnph/TI92voKNir3bwdiuh3bq0ff0hgwrsz186mJcKZLyiiTWvaK',1,13,2),('nguyenvanb','$2a$10$kYqE9rSpYBry8kB.h6rPDuP4xY3x/I0kzL8x69HsAAI0naAbY7u3a',0,2,3),('nguyenvanc','$2a$10$kYqE9rSpYBry8kB.h6rPDuP4xY3x/I0kzL8x69HsAAI0naAbY7u3a',0,3,3),('nguyenvand','$2a$10$kYqE9rSpYBry8kB.h6rPDuP4xY3x/I0kzL8x69HsAAI0naAbY7u3a',0,4,3),('nguyenvane','$2a$10$kYqE9rSpYBry8kB.h6rPDuP4xY3x/I0kzL8x69HsAAI0naAbY7u3a',0,6,3),('nguyenvanf','$2a$10$lAD46Tz4ChQrBTEkdnu1l.5iNBDmIPzLaAikE3cEY1C0QVaHSzK3C',0,7,3),('nguyenvang','$2a$10$NIfUCidNvskAVBC4.2UHkekkRbtYGeq7xkF/T3.m7ug7iJEt3P7Eq',0,8,3),('nguyenvanh','$2a$10$uSMRyjDY28VN9.tFgY7K0u/Eh7PLVf.Jq/A1ku7QTOjq8976RB71.',0,9,3),('nguyenvani','$2a$10$EclK.XGmAoK/1ZKnF3gKReMJFmgi6plTVCioDlU.Hq/mt7ezoiyLi',1,12,3);
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `actors`
--

DROP TABLE IF EXISTS `actors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actors` (
  `actor_id` int NOT NULL AUTO_INCREMENT,
  `actor_name` varchar(45) NOT NULL,
  PRIMARY KEY (`actor_id`),
  UNIQUE KEY `actor_name_UNIQUE` (`actor_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actors`
--

LOCK TABLES `actors` WRITE;
/*!40000 ALTER TABLE `actors` DISABLE KEYS */;
/*!40000 ALTER TABLE `actors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(45) NOT NULL,
  `status` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`category_id`),
  UNIQUE KEY `category_name_UNIQUE` (`category_name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Action',1),(2,'Cartoon',1),(3,'Horror',1),(4,'Family',1),(5,'War',1),(6,'Tragedy',1),(7,'NhomPhimMoi',1);
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comments` (
  `comment_id` int NOT NULL AUTO_INCREMENT,
  `film_id` int NOT NULL,
  `account_name` varchar(50) NOT NULL,
  `comment_content` varchar(200) NOT NULL,
  `comment_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `parent_comment_id` int DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `fk_comments_film_id_idx` (`film_id`),
  KEY `fk_comments_account_name_idx` (`account_name`),
  KEY `fk_comments_reply_idx` (`parent_comment_id`),
  CONSTRAINT `fk_comments_account_name` FOREIGN KEY (`account_name`) REFERENCES `accounts` (`account_name`) ON UPDATE CASCADE,
  CONSTRAINT `fk_comments_film_id` FOREIGN KEY (`film_id`) REFERENCES `films` (`film_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_comments_reply` FOREIGN KEY (`parent_comment_id`) REFERENCES `comments` (`comment_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,1,'Hieu','hay','2023-05-15 12:10:41',NULL),(2,1,'Hieu','rely','2023-05-15 13:11:15',1),(3,1,'Hieu','rely1','2023-05-15 14:12:42',2),(4,1,'Hieu1','hay','2023-05-15 15:35:52',NULL);
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `directors`
--

DROP TABLE IF EXISTS `directors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `directors` (
  `director_id` int NOT NULL AUTO_INCREMENT,
  `director_name` varchar(45) NOT NULL,
  PRIMARY KEY (`director_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `directors`
--

LOCK TABLES `directors` WRITE;
/*!40000 ALTER TABLE `directors` DISABLE KEYS */;
INSERT INTO `directors` VALUES (1,'Brian De Palma'),(2,'newdirector');
/*!40000 ALTER TABLE `directors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discount_details`
--

DROP TABLE IF EXISTS `discount_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `discount_details` (
  `discount_id` int NOT NULL,
  `film_package_id` int NOT NULL,
  PRIMARY KEY (`discount_id`,`film_package_id`),
  KEY `film_package_id_idx` (`film_package_id`),
  KEY `discount_details_film_package_id_idx` (`film_package_id`),
  CONSTRAINT `discount_details_film_package_id` FOREIGN KEY (`film_package_id`) REFERENCES `film_packages` (`film_package_id`) ON UPDATE CASCADE,
  CONSTRAINT `discount_id` FOREIGN KEY (`discount_id`) REFERENCES `discounts` (`discount_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discount_details`
--

LOCK TABLES `discount_details` WRITE;
/*!40000 ALTER TABLE `discount_details` DISABLE KEYS */;
INSERT INTO `discount_details` VALUES (2,5),(3,5),(5,5),(4,6);
/*!40000 ALTER TABLE `discount_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discounts`
--

DROP TABLE IF EXISTS `discounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `discounts` (
  `discount_id` int NOT NULL AUTO_INCREMENT,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `discount_rate` float NOT NULL,
  PRIMARY KEY (`discount_id`),
  KEY `start_dateDESC_discounts` (`start_date` DESC)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discounts`
--

LOCK TABLES `discounts` WRITE;
/*!40000 ALTER TABLE `discounts` DISABLE KEYS */;
INSERT INTO `discounts` VALUES (1,'2022-03-03','2022-03-13',0.3),(2,'2022-04-03','2022-04-13',0.25),(3,'2023-04-26','2023-05-05',0.25),(4,'2023-04-20','2023-04-26',0.25),(5,'2023-04-20','2023-04-25',0.2);
/*!40000 ALTER TABLE `discounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `episodes`
--

DROP TABLE IF EXISTS `episodes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `episodes` (
  `episode_id` int NOT NULL AUTO_INCREMENT,
  `episode_path` varchar(200) NOT NULL,
  `movie_id` int NOT NULL,
  `title` varchar(1000) NOT NULL,
  `cre_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`episode_id`),
  KEY `fk_episodes_film_id_idx` (`movie_id`),
  CONSTRAINT `fk_episodes_film_id` FOREIGN KEY (`movie_id`) REFERENCES `films` (`film_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `episodes`
--

LOCK TABLES `episodes` WRITE;
/*!40000 ALTER TABLE `episodes` DISABLE KEYS */;
INSERT INTO `episodes` VALUES (1,'adsd',2,'tap1','2023-05-17 20:23:17',1),(2,'aad',2,'tap 1','2023-05-17 20:23:17',1),(3,'asd',1,'tap2','2023-05-17 20:23:17',1),(4,'http://localhost:8081/films/content/1dfbbbae-231e-4f8d-a30d-c34475728f57.mp4',6,'1','2023-05-17 20:23:17',1),(5,'http://localhost:8081/films/content/56a063f4-9e8a-430a-b55d-1aa73f996fe9.mp4',6,'2','2023-05-17 20:23:17',1),(6,'http://localhost:8081/films/content/a0254a68-e533-4f57-a402-af5e106351ae.mp4',1,'tap1','2023-05-17 20:23:17',1),(7,'ádsdsd',1,'ádsd','2023-05-17 20:23:17',1),(8,'ádsd',1,'adsdđ','2023-05-17 20:23:17',1),(9,'http://localhost:8081/films/content/7e094661-72a2-49ca-a395-d6712f5e8b5e.mp4',6,'tap1','2023-05-19 18:34:01',1),(10,'http://localhost:8081/films/content/2792981c-6d09-4efd-9848-dc374d2903fe.mp4',7,'tap 1','2023-06-02 15:19:53',1),(11,'http://localhost:8081/films/content/98833324-47e5-4152-909f-475cee56cc88.mp4',7,'tap 2','2023-06-02 15:19:53',1),(12,'http://localhost:8081/films/content/904780dc-649f-473b-8960-861e21967ed2.mp4',6,'hay','2023-06-02 15:21:16',1),(13,'http://localhost:8081/films/content/c095d185-efc8-4c8e-907d-80120c47cf60.mp4',10,'hay','2023-06-02 17:48:07',0),(15,'http://localhost:8081/films/content/645b0594-3f11-47f4-9109-082b8c437a8b.mp4',10,'hay','2023-06-02 18:12:26',0),(16,'http://localhost:8081/films/content/f3d58038-7143-45b3-a429-d62d637285b2.mp4',10,'hay1','2023-06-02 18:19:25',1),(23,'abc.com',13,'link','2023-06-02 19:26:48',1),(24,'abc.com',13,'link','2023-06-02 19:26:48',1),(25,'abc.com',14,'link1','2023-06-02 19:39:50',0),(26,'abcsd.com',14,'linkmoi','2023-06-02 19:39:50',1);
/*!40000 ALTER TABLE `episodes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evaluations`
--

DROP TABLE IF EXISTS `evaluations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `evaluations` (
  `film_id` int NOT NULL,
  `account_name` varchar(50) NOT NULL,
  `star_number` float NOT NULL,
  `comment` varchar(200) NOT NULL DEFAULT '',
  `eval_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`film_id`,`account_name`),
  KEY `FK_evaluations_filmid_idx` (`film_id`),
  KEY `FK_evaluations_account_name_idx` (`account_name`),
  CONSTRAINT `FK_evaluations_account_name` FOREIGN KEY (`account_name`) REFERENCES `accounts` (`account_name`) ON UPDATE CASCADE,
  CONSTRAINT `FK_evaluations_film_id` FOREIGN KEY (`film_id`) REFERENCES `films` (`film_id`) ON UPDATE CASCADE,
  CONSTRAINT `evaluations_chk_1` CHECK (((`star_number` >= 1) and (`star_number` <= 10)))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evaluations`
--

LOCK TABLES `evaluations` WRITE;
/*!40000 ALTER TABLE `evaluations` DISABLE KEYS */;
INSERT INTO `evaluations` VALUES (1,'Hieu',3,'k hay','2023-06-02 12:43:57'),(1,'Hieu1',10,'hay','2023-06-02 12:43:39'),(3,'Hieu1',10,'khong hay','2023-06-02 13:17:56');
/*!40000 ALTER TABLE `evaluations` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trg_insert_favorite` BEFORE INSERT ON `evaluations` FOR EACH ROW BEGIN
 IF (SELECT average_rating FROM films WHERE film_id = NEW.film_id) = 0 THEN
    UPDATE films
    SET average_rating = NEW.star_number
    WHERE film_id = NEW.film_id;
  ELSE
    UPDATE films
    SET average_rating = (average_rating + NEW.star_number) / 2
    WHERE film_id = NEW.film_id;
  END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `favorites`
--

DROP TABLE IF EXISTS `favorites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `favorites` (
  `favorite_film_id` int NOT NULL,
  `account_name` varchar(45) NOT NULL,
  `favorite_cre_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`favorite_film_id`,`account_name`),
  KEY `fk_account_name_idx` (`account_name`),
  CONSTRAINT `fk_account_name` FOREIGN KEY (`account_name`) REFERENCES `accounts` (`account_name`),
  CONSTRAINT `fk_film_id` FOREIGN KEY (`favorite_film_id`) REFERENCES `films` (`film_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favorites`
--

LOCK TABLES `favorites` WRITE;
/*!40000 ALTER TABLE `favorites` DISABLE KEYS */;
INSERT INTO `favorites` VALUES (1,'Hieu','2023-06-02 12:43:57'),(1,'Hieu1','2023-06-02 12:43:39');
/*!40000 ALTER TABLE `favorites` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `film_packages`
--

DROP TABLE IF EXISTS `film_packages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `film_packages` (
  `film_package_id` int NOT NULL AUTO_INCREMENT,
  `used_time` int NOT NULL,
  `applicable_date` date NOT NULL,
  `price` int NOT NULL,
  PRIMARY KEY (`film_package_id`),
  KEY `applicable_dateDESC_used_timeASC` (`applicable_date` DESC,`used_time`),
  CONSTRAINT `film_packages_chk_price` CHECK ((`price` > 0))
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `film_packages`
--

LOCK TABLES `film_packages` WRITE;
/*!40000 ALTER TABLE `film_packages` DISABLE KEYS */;
INSERT INTO `film_packages` VALUES (1,1,'2019-01-01',10),(2,1,'2020-02-02',15),(3,3,'2019-01-01',30),(4,6,'2019-01-01',55),(5,3,'2020-01-01',45),(6,6,'2020-01-01',85);
/*!40000 ALTER TABLE `film_packages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `film_producers`
--

DROP TABLE IF EXISTS `film_producers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `film_producers` (
  `film_producer_id` int NOT NULL AUTO_INCREMENT,
  `film_producer_name` varchar(80) NOT NULL,
  PRIMARY KEY (`film_producer_id`),
  UNIQUE KEY `film_producer_name_UNIQUE` (`film_producer_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `film_producers`
--

LOCK TABLES `film_producers` WRITE;
/*!40000 ALTER TABLE `film_producers` DISABLE KEYS */;
INSERT INTO `film_producers` VALUES (2,'newproducer'),(1,'Tom Cruise');
/*!40000 ALTER TABLE `film_producers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `films`
--

DROP TABLE IF EXISTS `films`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `films` (
  `film_id` int NOT NULL AUTO_INCREMENT,
  `film_name` varchar(80) NOT NULL,
  `film_poster_path` varchar(150) NOT NULL,
  `trailer_path` varchar(150) NOT NULL,
  `film_description` varchar(2000) NOT NULL,
  `film_duration` int NOT NULL,
  `release_time` date NOT NULL,
  `odd_film` tinyint NOT NULL,
  `average_rating` float NOT NULL DEFAULT '0',
  `film_producer_id` int NOT NULL,
  `nation_id` int NOT NULL,
  `director_id` int NOT NULL,
  `status` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`film_id`),
  KEY `film_producer_id_idx` (`film_producer_id`),
  KEY `nation_id_idx` (`nation_id`),
  KEY `director_id_idx` (`director_id`),
  CONSTRAINT `director_id` FOREIGN KEY (`director_id`) REFERENCES `directors` (`director_id`) ON UPDATE CASCADE,
  CONSTRAINT `film_producer_id` FOREIGN KEY (`film_producer_id`) REFERENCES `film_producers` (`film_producer_id`) ON UPDATE CASCADE,
  CONSTRAINT `nation_id` FOREIGN KEY (`nation_id`) REFERENCES `nations` (`nation_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `films`
--

LOCK TABLES `films` WRITE;
/*!40000 ALTER TABLE `films` DISABLE KEYS */;
INSERT INTO `films` VALUES (1,'Mission: Impossible','abc','abc','abc',120,'1996-03-03',1,6.5,1,1,1,1),(2,'Mission: Impossible 2','abc','abc','abc',120,'1998-02-02',1,0,1,1,1,1),(3,'a','http://localhost:8081/films/7332234c-cc58-405d-8e70-03d2b4fbb860.png','http://localhost:8081/films/9ab63ce3-9337-4e41-9235-09e8bf38a2c3.mp4','adsdsd',120,'2022-03-01',0,10,1,1,1,0),(5,'phimmoi','http://localhost:8081/films/6b15768e-05d8-48a6-8bba-a2ac346d2b50.png','http://localhost:8081/films/2aca6632-2a75-4aca-a99f-6e9c45012fa9.mp4','adsdsd',120,'2022-03-01',0,0,1,1,1,1),(6,'phimmoi1','http://localhost:8081/films/54149a4d-5b42-450a-a4fc-ea53e4710a9a.png','http://localhost:8081/films/b1086738-dcbd-4e4d-a497-da1fa7dc0103.mp4','adsdsd',120,'2022-03-01',0,0,1,1,1,1),(7,'Phimhay','http://localhost:8081/films/1c3ac179-ce90-4f2f-84bc-12c62d1bf424.png','http://localhost:8081/films/bd548b62-00b7-4b9c-808b-d9b69175a874.mp4','phim moi 2023',120,'2023-02-06',0,0,1,1,1,1),(8,'a','http://localhost:8081/films/2008d2bd-918a-4c72-ae08-0337f5b03b7c.png','http://localhost:8081/films/ecdf49bf-84dc-4b9f-b3af-f0181a222b85.mp4','phim moi 2023',120,'2023-02-06',0,0,1,1,1,0),(10,'a','http://localhost:8081/films/40f212b1-b6ad-4e49-9849-a08f1f965142.png','http://localhost:8081/films/de8dfc90-d787-41fd-a507-8182dfbbf971.mp4','phim moi 2023',120,'2023-02-06',0,0,1,1,1,1),(11,'phimhot','poster.com','poster.com','hadsd',1,'0007-08-15',1,0,1,1,1,0),(12,'phimhot','poster.com','poster.com','hadsd',1,'0007-08-15',1,0,1,1,1,0),(13,'phimhot','poster.com','poster.com','hadsd',1,'0007-08-15',1,0,1,1,1,0),(14,'phimhot123','poster.com','poster.com','hadsd',1,'0007-08-15',0,0,1,1,1,1);
/*!40000 ALTER TABLE `films` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `films_actors`
--

DROP TABLE IF EXISTS `films_actors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `films_actors` (
  `film_id` int NOT NULL,
  `actor_id` int NOT NULL,
  PRIMARY KEY (`film_id`,`actor_id`),
  KEY `actor_id_idx` (`actor_id`),
  CONSTRAINT `actor_id` FOREIGN KEY (`actor_id`) REFERENCES `actors` (`actor_id`) ON UPDATE CASCADE,
  CONSTRAINT `movie_id` FOREIGN KEY (`film_id`) REFERENCES `films` (`film_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `films_actors`
--

LOCK TABLES `films_actors` WRITE;
/*!40000 ALTER TABLE `films_actors` DISABLE KEYS */;
/*!40000 ALTER TABLE `films_actors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `films_categories`
--

DROP TABLE IF EXISTS `films_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `films_categories` (
  `film_id` int NOT NULL,
  `category_id` int NOT NULL,
  PRIMARY KEY (`film_id`,`category_id`),
  KEY `category_id_idx` (`category_id`),
  CONSTRAINT `category_id` FOREIGN KEY (`category_id`) REFERENCES `categories` (`category_id`) ON UPDATE CASCADE,
  CONSTRAINT `film_id` FOREIGN KEY (`film_id`) REFERENCES `films` (`film_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `films_categories`
--

LOCK TABLES `films_categories` WRITE;
/*!40000 ALTER TABLE `films_categories` DISABLE KEYS */;
INSERT INTO `films_categories` VALUES (1,1),(2,1);
/*!40000 ALTER TABLE `films_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nations`
--

DROP TABLE IF EXISTS `nations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nations` (
  `nation_id` int NOT NULL AUTO_INCREMENT,
  `nation_name` varchar(60) NOT NULL,
  PRIMARY KEY (`nation_id`),
  UNIQUE KEY `nation_name_UNIQUE` (`nation_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nations`
--

LOCK TABLES `nations` WRITE;
/*!40000 ALTER TABLE `nations` DISABLE KEYS */;
INSERT INTO `nations` VALUES (2,'newnation'),(1,'newnation1');
/*!40000 ALTER TABLE `nations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchased_film_packages`
--

DROP TABLE IF EXISTS `purchased_film_packages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purchased_film_packages` (
  `account_name` varchar(50) NOT NULL,
  `film_package_id` int NOT NULL,
  `purchase_date` date NOT NULL,
  `start_date` date NOT NULL,
  `expiration_date` date NOT NULL,
  `status` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`account_name`,`film_package_id`,`start_date`),
  KEY `account_name_purchased_film_packages_idx` (`account_name`),
  KEY `film_package_id_purchased_film_packages_idx` (`film_package_id`),
  CONSTRAINT `account_name_purchased_film_packages` FOREIGN KEY (`account_name`) REFERENCES `accounts` (`account_name`) ON UPDATE CASCADE,
  CONSTRAINT `film_package_id_purchased_film_packages` FOREIGN KEY (`film_package_id`) REFERENCES `film_packages` (`film_package_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchased_film_packages`
--

LOCK TABLES `purchased_film_packages` WRITE;
/*!40000 ALTER TABLE `purchased_film_packages` DISABLE KEYS */;
INSERT INTO `purchased_film_packages` VALUES ('nguyenvanc',2,'2023-01-01','2023-01-01','2023-01-31',1),('nguyenvanc',2,'2023-05-01','2023-05-01','2023-05-31',1),('nguyenvanc',2,'2023-05-01','2023-05-31','2023-06-30',0);
/*!40000 ALTER TABLE `purchased_film_packages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) NOT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `role_name_UNIQUE` (`role_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (2,'ROLE_ADMIN'),(3,'ROLE_CLIENT'),(1,'ROLE_USER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tokens`
--

DROP TABLE IF EXISTS `tokens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tokens` (
  `id` int NOT NULL AUTO_INCREMENT,
  `token` varchar(500) NOT NULL,
  `revoked` tinyint DEFAULT NULL,
  `expired` tinyint DEFAULT NULL,
  `account_name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `token_UNIQUE` (`token`),
  KEY `account_name_tokens_idx` (`account_name`),
  CONSTRAINT `account_name_tokens` FOREIGN KEY (`account_name`) REFERENCES `accounts` (`account_name`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tokens`
--

LOCK TABLES `tokens` WRITE;
/*!40000 ALTER TABLE `tokens` DISABLE KEYS */;
INSERT INTO `tokens` VALUES (34,'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJIaWV1MSIsImlhdCI6MTY4NTU5MjgyNywiZXhwIjoxNjg2MTk3NjI3fQ.rsw55w0TXhxskjMMEbvwDKdm-vrvyTEtUaR2yhFB1JaKnan_eBmwBqehoCw-RfNAZKYMfmQTDP_vujzTk0UcWA',1,1,'Hieu1'),(35,'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJIaWV1MSIsImlhdCI6MTY4NTU5NDk4NywiZXhwIjoxNjg2MTk5Nzg3fQ.10RD1D9n5crroqZnL_n3tY7aAoxh7JUlbhiLFr08mbAo7yPBu16iTfGtiaR4Jh20z9eNYnKp-lp8ngxKABSGEA',1,1,'Hieu1'),(36,'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJIaWV1MSIsImlhdCI6MTY4NTU5NTc4MywiZXhwIjoxNjg2MjAwNTgzfQ.c95xwx5AQLkY6IOkG3odI7NJqAxM84dw-D5NTvoHNpCAqQdayxf-n9GtC_h-42r8H_S8PiORCOm46HK7DaMeTg',1,1,'Hieu1'),(37,'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJIaWV1MSIsImlhdCI6MTY4NTYyNjMyOCwiZXhwIjoxNjg2MjMxMTI4fQ.tjrj038Uro5P-e5EZxCmhag_zKsIO55nEMRQOsq6KR5qkS2Kp6mXdziRg0otjUQj_DEfVujiGeA-VNBeOjHmlg',1,1,'Hieu1'),(38,'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJIaWV1MSIsImlhdCI6MTY4NTYyNjM4OSwiZXhwIjoxNjg2MjMxMTg5fQ.Jo8tt0H9LwU5ONrx1Tn44A4Wco2hsMm5vBqzHIoeZQmRlM9lCTStAGQym7OZhPLSPX311CcwvANjLul-i4O0UA',1,1,'Hieu1'),(39,'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJIaWV1MSIsImlhdCI6MTY4NTYyNjM5OSwiZXhwIjoxNjg2MjMxMTk5fQ.DYu1hhUL1_HcoVLCgIdwz5DHDdMLTxj1pqvLfwIPYUuS7oM0samP3e-Cdz9EbnaJiCy-5z7tll0_aeyqJxkH2A',1,1,'Hieu1'),(40,'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJIaWV1MSIsImlhdCI6MTY4NTYyNzAzOSwiZXhwIjoxNjg2MjMxODM5fQ.2xFJa_rBdyFHhdpnu7CRhGQ2EG4_sPGWirV9mXFcWa2F0WlkaKGqn1TGSd7IjT7Imj7XIwel2FvJOOfCwE7zFA',1,1,'Hieu1'),(41,'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJIaWV1MSIsImlhdCI6MTY4NTYzNDU0NCwiZXhwIjoxNjg2MjM5MzQ0fQ.qpY6jx3stV92_tDy7PqbCsoJuo09cNcJeNYJ6qxRP0fnFjSTU6p73iG186tAGiL5LTqRruMKCgWIFIB3XxxajA',1,1,'Hieu1'),(42,'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJIaWV1MSIsImlhdCI6MTY4NTYzNDY1MCwiZXhwIjoxNjg2MjM5NDUwfQ.yhvmuNPgp73672pJLqJmxI9XAgjCjpqkPJzCdzJh10nR4EaiG6qpoFrn0hF5oTkuXwBjdL1ZrIDcqtsejpHy3Q',1,1,'Hieu1'),(43,'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJIaWV1MSIsImlhdCI6MTY4NTYzNDY3OCwiZXhwIjoxNjg2MjM5NDc4fQ.1dhNIt9c3wXym2siVRt1v3cB_dQmIdOsVWu7kVNoQaRyrge3t0qMmOTdxUrwR9BwmqwM6KeiW03NvMIUiZPS4A',1,1,'Hieu1'),(44,'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJIaWV1MSIsImlhdCI6MTY4NTYzNDkwOSwiZXhwIjoxNjg2MjM5NzA5fQ.tekn5TX3klO3Kz4OxuC0MG_aeXfcmENwOFwrKrDOrfPDDuu2cYgg7Cs2mEtbZT0JcpI-1OzWSNPgCZDYiZxs6g',1,1,'Hieu1'),(45,'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJIaWV1MSIsImlhdCI6MTY4NTYzNDk0OSwiZXhwIjoxNjg2MjM5NzQ5fQ.sbtyyTwvZaQ8j-fED5lrQ1jumAcAal94mULuc-szbRBHFdNlvlYbJILiqTdpsmLYSlkWYgJ5JyJ2qpyzwd-Gfw',1,1,'Hieu1'),(46,'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJIaWV1MSIsImlhdCI6MTY4NTYzNDk4MywiZXhwIjoxNjg2MjM5NzgzfQ.AgMnPw_SQ6AA-Gei6IUYiYhY2A-a9tQV9FMgvFDQZqPJ4AfQueFhVikpDKaSvHtPrJa4EuaaO23rlfD2qWV8uQ',1,1,'Hieu1'),(47,'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJIaWV1MSIsImlhdCI6MTY4NTYzNTAxMiwiZXhwIjoxNjg2MjM5ODEyfQ._UwQAmJgTcDUskAqyN_G0j1YM1qKypl1RQ618LFI_T4B1Qeo7kmrPCYmgAXSVl_MCejiHUU2T5z3q6TqbqNBxQ',1,1,'Hieu1'),(48,'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJIaWV1MSIsImlhdCI6MTY4NTYzNTAzNSwiZXhwIjoxNjg2MjM5ODM1fQ.HqrP_nmQ_EnCGsGKr1TJtvKuKUghf4_g65y9DRySMKkqjrGkBoHLd4CLAfe7QU12W9jI-cYNDOcpHRlYKSGUsQ',1,1,'Hieu1'),(49,'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJIaWV1MSIsImlhdCI6MTY4NTYzNTEzMywiZXhwIjoxNjg2MjM5OTMzfQ.DSdlUFjHXprDjYXY-MF1ZeINcEnceYpX0hwuL97_rebuwZvL9Bt4aT_s6NMK1_GSZB_2onKOw5P5oTHFnrY3QQ',1,1,'Hieu1'),(50,'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJIaWV1MSIsImlhdCI6MTY4NTYzNTE5NywiZXhwIjoxNjg2MjM5OTk3fQ.fJPIexUnjz_t_xMCEMNEIf7sVQqyEOw1r1tRLhm_b4w-r52-fstO3AzjvN3Y6H2yV-CWV1RWoELX2KgcAOeipQ',1,1,'Hieu1'),(51,'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJIaWV1MSIsImlhdCI6MTY4NTY4NjM2NCwiZXhwIjoxNjg2MjkxMTY0fQ.8iXMcshivNIhMxa7qLPXxqgUKlZt6aJTHDbkJufP2quOKt2nHCSBoo1lrD0fzmcu2xlD5WnUHo98kbXp5lgvwQ',1,1,'Hieu1'),(52,'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJIaWV1MSIsImlhdCI6MTY4NTY5MzQxNiwiZXhwIjoxNjg2Mjk4MjE2fQ.xDBp4AGZ8e9dtIHRVucVD7DbZshV9yDJbY74lrRwmfa9VNGj5Js2auBsOFkzPrQ5uhX-ggstZN80ug4mdJfA_Q',1,1,'Hieu1'),(53,'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJIaWV1MSIsImlhdCI6MTY4NTkyODUzMywiZXhwIjoxNjg2NTMzMzMzfQ.TIKSecuUQDZRhcVFdJlyEite4tA04lbUa0t-pjKMOzT1kRYU2lWQHtHhxVUITvv9pExFsvdOcuGtI15WQxbDuA',1,1,'Hieu1'),(54,'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJIaWV1MSIsImlhdCI6MTY4NTkyODk3NCwiZXhwIjoxNjg2NTMzNzc0fQ.1sZzAyaabo6O0HZzt0SlOaA2Yw3ohFwNcontaZX7YDVhyqDSs2IlOLKpGI3N63UXFkdDlJCJK7r-0yaQFCp8ww',1,1,'Hieu1'),(55,'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJIaWV1MSIsImlhdCI6MTY4NTkzMjY0NCwiZXhwIjoxNjg2NTM3NDQ0fQ.kZn1yljJRsnpwcxPf-1qagC9Za8lqba4H_36UvIHvb5bhGF-yv-shYWedTTjFDbSV_ytXiEs-q2-PrWIffW9bg',1,1,'Hieu1'),(56,'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJIaWV1MSIsImlhdCI6MTY4NTkzMjY3NCwiZXhwIjoxNjg2NTM3NDc0fQ.1ZnPy7UutXDqv3Jhxlyp5dyRl14m2FBEddJn7gJDN0aXzzJVRE6FyKAwkqFLU3Fa0XTjQpbvsDrrtQTYVpCp2w',1,1,'Hieu1'),(57,'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJIaWV1MSIsImlhdCI6MTY4NTkzMjcyMCwiZXhwIjoxNjg2NTM3NTIwfQ.03HcuSRDiraAitju6OJ9oeYKbfiEueYrbdCi90QRqDT77OODjp0uNpehcmQpRZ-tLYcm5kUgml-E3IuSrruJ8A',0,0,'Hieu1');
/*!40000 ALTER TABLE `tokens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `sex` tinyint(1) NOT NULL DEFAULT '0',
  `birthdate` date NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `phone_UNIQUE` (`phone_number`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'nguyenvana','0969665842','nguyenvana@gmail.com',0,'2001-01-01'),(2,'nguyenvanb','0969665482','nguyenvanb@gmail.com',0,'2001-05-16'),(3,'nguyenvanc','0969665472','nguyenvanc@gmail.com',0,'2001-05-16'),(4,'nguyenvand','0969615472','nguyenvand@gmail.com',0,'2001-05-16'),(6,'nguyenvane','0949615472','nguyenvane@gmail.com',0,'2001-05-16'),(7,'nguyenvanf','0949615672','nguyenvanf@gmail.com',0,'2001-05-16'),(8,'nguyenvang',NULL,'nguyenvang@gmail.com',0,'2001-05-16'),(9,'nguyenvanh',NULL,'nguyenvanh@gmail.com',0,'2001-05-16'),(12,'nguyenvani','0965665842','ninhdng37@gmail.com',0,'2001-01-01'),(13,'Hieu1',NULL,'hieuhdhk@gmail.com',0,'2001-05-16');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-05 11:28:51
