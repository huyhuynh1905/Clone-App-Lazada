-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: applazada
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanvien` (
  `manv` int NOT NULL AUTO_INCREMENT,
  `tennv` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `tendn` varchar(50) DEFAULT NULL,
  `matkhau` varchar(32) NOT NULL,
  `diachi` text,
  `ngaysinh` varchar(10) DEFAULT NULL,
  `sodt` varchar(10) DEFAULT NULL,
  `gioitinh` tinyint(1) DEFAULT NULL,
  `cmnd` varchar(13) DEFAULT NULL,
  `maloainv` int DEFAULT '2',
  `email` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nhanemail` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`manv`),
  UNIQUE KEY `manv_UNIQUE` (`manv`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `FK_MaLoaiNv` (`maloainv`),
  CONSTRAINT `FK_MaLoaiNv` FOREIGN KEY (`maloainv`) REFERENCES `loainhanvien` (`maloainv`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES (1,'Huynh Huy',NULL,'Huynhhuy19',NULL,NULL,NULL,NULL,NULL,2,'huyhuynh@gmail.com',1),(2,'Huynh Bao',NULL,'Huynhhuy19',NULL,NULL,NULL,NULL,NULL,2,'hao@gmail.com',0),(3,'Bao Huy',NULL,'Huyhuynh19',NULL,NULL,NULL,NULL,NULL,2,'huyhao@gmail.com',0),(4,'Huy',NULL,'Huyhuynh19',NULL,NULL,NULL,NULL,NULL,2,'huy@gmail.com',0),(5,'Huy',NULL,'Huyhuynh19',NULL,NULL,NULL,NULL,NULL,2,'huy1@gmail.com',0),(8,'Huynh Huy',NULL,'Baohuy123',NULL,NULL,NULL,NULL,NULL,2,'huyhuyhuyhuy@gmail.com',0),(9,'Had Hao',NULL,'Haohao123',NULL,NULL,NULL,NULL,NULL,2,'haohao@gmail.com',0);
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-05  0:37:23
