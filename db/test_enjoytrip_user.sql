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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `login_id` varchar(255) DEFAULT NULL,
  `nickname` varchar(20) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `refresh_token` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `login_id_unique` (`login_id`)
) ENGINE=InnoDB AUTO_INCREMENT=256 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (109,'asdf123','asdf','hello@ssafy.com','hello','asdf123@','01012345678','2023-05-18 04:20:29.090000','2023-05-23 04:30:05.721000','eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyZWZyZXNoLXRva2VuIiwiaWF0IjoxNjg0ODE2MjA1LCJleHAiOjE2ODYwMjU4MDUsImxvZ2luVG9rZW4iOnsidXNlcklkIjoxMDksIm5pY2tOYW1lIjoiYXNkZiJ9fQ.x2qM4_zrfEpkc4F6A0v3rHT9Yr3RNJ98yG8JLRAy7aE'),(110,'test1','테스트','test123@test.com','링크','Test1234!','01000001111','2023-05-22 00:40:45.425000','2023-05-23 06:34:58.905000','eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyZWZyZXNoLXRva2VuIiwiaWF0IjoxNjg0ODIzNjk4LCJleHAiOjE2ODYwMzMyOTgsImxvZ2luVG9rZW4iOnsidXNlcklkIjoxMTAsIm5pY2tOYW1lIjoi7YWM7Iqk7Yq4In19.aXfpGQVAE0wYyU6FlbJI371ya2bQ_ec2zfdGOAwy8B8'),(111,'tamtam','탐탐','tamtam1234@tamtam.com','탐탐','tamtam1234!','01010102020','2023-05-23 01:27:48.766000','2023-05-25 07:40:42.185000','eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyZWZyZXNoLXRva2VuIiwiaWF0IjoxNjg1MDAwNDQyLCJleHAiOjE2ODYyMTAwNDIsImxvZ2luVG9rZW4iOnsidXNlcklkIjoxMTEsIm5pY2tOYW1lIjoi7YOQ7YOQIn19.t1_a64kBmcEyeeaCwzFksZMdMP_RynKv1O2ufl6zhbU');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
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
