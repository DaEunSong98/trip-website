-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: test_enjoytrip
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
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `board` (
  `board_id` bigint NOT NULL AUTO_INCREMENT,
  `content` text,
  `title` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`board_id`),
  KEY `board_user_fk` (`user_id`),
  CONSTRAINT `board_user_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=172 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES (13,'테스트1','테스트1',NULL,'2023-05-03 06:18:54.190000','2023-05-03 06:18:54.190000'),(14,'테스트1','테스트1',NULL,'2023-05-03 06:19:45.847000','2023-05-03 06:19:45.847000'),(15,'테스트1','테스트1',NULL,'2023-05-03 06:20:47.908000','2023-05-03 06:20:47.908000'),(16,'테스트1','테스트1',NULL,'2023-05-03 06:30:56.797000','2023-05-03 06:30:56.797000'),(17,'테스트1','테스트1',NULL,'2023-05-03 06:38:35.607000','2023-05-03 06:38:35.607000'),(18,'테스트1','테스트1',NULL,'2023-05-03 06:38:48.674000','2023-05-03 06:38:48.674000'),(19,'테스트1','테스트1',NULL,'2023-05-03 06:39:23.024000','2023-05-03 06:39:23.024000'),(33,'테스트1','테스트1',NULL,'2023-05-04 01:27:31.314000','2023-05-04 01:27:31.314000'),(34,'테스트1','테스트1',NULL,'2023-05-04 01:27:31.380000','2023-05-04 01:27:31.380000'),(70,'asdasd','집에가고싶어',110,'2023-05-22 00:48:43.517000','2023-05-22 00:48:43.517000'),(71,'asdads','asdasd',110,'2023-05-22 00:50:18.419000','2023-05-22 00:50:18.419000'),(72,'123123','123123',110,'2023-05-22 01:33:50.772000','2023-05-22 01:33:50.772000'),(75,'asd','asd',110,'2023-05-22 05:20:18.895000','2023-05-22 05:20:18.895000'),(84,'ㅁㄴㅇㅁㄴㅇ','업로드테드스',110,'2023-05-23 00:17:35.938000','2023-05-23 06:36:25.738000'),(85,'4165465asdasdasdasd','asdasd',111,'2023-05-23 01:28:51.350000','2023-05-23 02:56:34.565000'),(86,'123123asdaasdasd','123123',111,'2023-05-23 02:56:45.113000','2023-05-23 04:12:18.709000'),(171,'asd','집에가고싶어',111,'2023-05-25 01:26:26.258000','2023-05-25 01:26:26.258000');
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-25 17:38:37
