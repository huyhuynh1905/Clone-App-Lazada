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
-- Table structure for table `chitietthuonghieu`
--

DROP TABLE IF EXISTS `chitietthuonghieu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitietthuonghieu` (
  `math` int NOT NULL,
  `maloaisp` int NOT NULL,
  `hinhthuonghieu` text,
  PRIMARY KEY (`math`,`maloaisp`),
  KEY `KHOANGOAI_CHITIETTHUONGHIEU_MALOAISP` (`maloaisp`),
  CONSTRAINT `KHOANGOAI_CHITIETTHUONGHIEU_MALOAISP` FOREIGN KEY (`maloaisp`) REFERENCES `loaisanpham` (`maloaisp`),
  CONSTRAINT `KHOANGOAI_CHITIETTHUONGHIEU_MATHUONGHIEU` FOREIGN KEY (`math`) REFERENCES `thuonghieu` (`math`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietthuonghieu`
--

LOCK TABLES `chitietthuonghieu` WRITE;
/*!40000 ALTER TABLE `chitietthuonghieu` DISABLE KEYS */;
INSERT INTO `chitietthuonghieu` VALUES (1,1,'/hinhthuonghieu/apple.png'),(1,49,'/hinhthuonghieu/macbook.png'),(2,1,'/hinhthuonghieu/nokia.png'),(3,1,'/hinhthuonghieu/samsung.png'),(4,1,'/hinhthuonghieu/xiaomi.png'),(5,1,'/hinhthuonghieu/asus.png'),(6,1,'/hinhthuonghieu/lenovo.png'),(6,49,'/hinhthuonghieu/laptoplenovo.png'),(7,1,'/hinhthuonghieu/oppo.png'),(8,1,'/hinhthuonghieu/sony.png'),(9,1,'/hinhthuonghieu/htc.png'),(10,49,'/hinhthuonghieu/dell.png'),(11,1,'/hinhthuonghieu/hp.png'),(12,1,'/hinhthuonghieu/scandisk.png'),(13,1,'/hinhthuonghieu/silicon.jpg'),(14,1,'/hinhthuonghieu/canon.jpg'),(15,49,'/hinhthuonghieu/microsoft.png');
/*!40000 ALTER TABLE `chitietthuonghieu` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-05  0:37:25
