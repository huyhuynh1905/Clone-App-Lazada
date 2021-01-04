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
-- Table structure for table `binhluan`
--

DROP TABLE IF EXISTS `binhluan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `binhluan` (
  `mabl` int NOT NULL AUTO_INCREMENT,
  `manv` int DEFAULT NULL,
  `masp` int DEFAULT NULL,
  `noidungbl` text,
  `ngaybl` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`mabl`),
  KEY `FK_NVBinhLuan` (`manv`),
  KEY `FK_SPBinhLuan` (`masp`),
  CONSTRAINT `FK_NVBinhLuan` FOREIGN KEY (`manv`) REFERENCES `nhanvien` (`manv`),
  CONSTRAINT `FK_SPBinhLuan` FOREIGN KEY (`masp`) REFERENCES `sanpham` (`masp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `binhluan`
--

LOCK TABLES `binhluan` WRITE;
/*!40000 ALTER TABLE `binhluan` DISABLE KEYS */;
/*!40000 ALTER TABLE `binhluan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chitietdathang`
--

DROP TABLE IF EXISTS `chitietdathang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitietdathang` (
  `madh` int NOT NULL,
  `masp` int NOT NULL,
  `soluong` int DEFAULT NULL,
  PRIMARY KEY (`madh`,`masp`),
  KEY `FK_MaSPChiTiet` (`masp`),
  CONSTRAINT `FK_MaDHChiTiet` FOREIGN KEY (`madh`) REFERENCES `dondathang` (`madh`),
  CONSTRAINT `FK_MaSPChiTiet` FOREIGN KEY (`masp`) REFERENCES `sanpham` (`masp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietdathang`
--

LOCK TABLES `chitietdathang` WRITE;
/*!40000 ALTER TABLE `chitietdathang` DISABLE KEYS */;
/*!40000 ALTER TABLE `chitietdathang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chitiethoadon`
--

DROP TABLE IF EXISTS `chitiethoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitiethoadon` (
  `MAHD` int NOT NULL,
  `MASP` int NOT NULL,
  `SOLUONG` int DEFAULT NULL,
  PRIMARY KEY (`MAHD`,`MASP`),
  KEY `KHOANGOAI_CHITIETHOADON_MASP` (`MASP`),
  CONSTRAINT `KHOANGOAI_CHITIETHOADON_MAHD` FOREIGN KEY (`MAHD`) REFERENCES `hoadon` (`MAHD`),
  CONSTRAINT `KHOANGOAI_CHITIETHOADON_MASP` FOREIGN KEY (`MASP`) REFERENCES `sanpham` (`masp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitiethoadon`
--

LOCK TABLES `chitiethoadon` WRITE;
/*!40000 ALTER TABLE `chitiethoadon` DISABLE KEYS */;
INSERT INTO `chitiethoadon` VALUES (2,2,2),(2,4,3),(2,5,1),(2,12,3),(3,1,1),(3,4,1),(3,5,2);
/*!40000 ALTER TABLE `chitiethoadon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chitietkhuyenmai`
--

DROP TABLE IF EXISTS `chitietkhuyenmai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitietkhuyenmai` (
  `masp` int NOT NULL,
  `makm` int NOT NULL,
  `phantramkm` int DEFAULT NULL,
  PRIMARY KEY (`masp`,`makm`),
  CONSTRAINT `FK_ChiTietKMSP` FOREIGN KEY (`masp`) REFERENCES `sanpham` (`masp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietkhuyenmai`
--

LOCK TABLES `chitietkhuyenmai` WRITE;
/*!40000 ALTER TABLE `chitietkhuyenmai` DISABLE KEYS */;
INSERT INTO `chitietkhuyenmai` VALUES (1,1,49),(2,1,49),(3,1,49),(4,1,49),(5,1,49),(6,1,49),(7,1,49),(8,1,49),(9,1,49),(10,1,49),(11,2,50),(12,2,50),(13,2,50),(14,2,50),(15,2,50),(16,2,50),(17,2,50),(18,2,50),(19,2,50),(20,2,50),(21,3,40),(21,4,30),(22,3,40),(22,4,30),(23,3,40),(23,4,30),(24,3,40),(24,4,30),(25,3,40),(25,4,30),(26,3,40),(26,4,30),(27,3,40),(27,4,30),(28,3,40),(28,4,30),(29,3,40),(29,4,30),(30,3,40),(30,4,30);
/*!40000 ALTER TABLE `chitietkhuyenmai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chitietsanpham`
--

DROP TABLE IF EXISTS `chitietsanpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitietsanpham` (
  `machitiet` int NOT NULL AUTO_INCREMENT,
  `masp` int DEFAULT NULL,
  `tenchitiet` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `giatri` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  PRIMARY KEY (`machitiet`),
  KEY `KHOANGOAI_CHITIETSANPHAM_MASP` (`masp`),
  CONSTRAINT `KHOANGOAI_CHITIETSANPHAM_MASP` FOREIGN KEY (`masp`) REFERENCES `sanpham` (`masp`)
) ENGINE=InnoDB AUTO_INCREMENT=558 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietsanpham`
--

LOCK TABLES `chitietsanpham` WRITE;
/*!40000 ALTER TABLE `chitietsanpham` DISABLE KEYS */;
INSERT INTO `chitietsanpham` VALUES (1,1,'3D TV','No'),(2,1,'Camera Back','11 - 15 MP'),(3,1,'Camera Front','5 - 6 MP'),(4,1,'Điều kiện','Mới'),(5,1,'Curved TV','No'),(6,1,'Kích thước màn hình','4.7'),(7,1,'Mẫu mã','6s'),(8,1,'Network Connections','3G-HSPA|4G-LTE'),(9,1,'Hệ điều hành','IOS'),(10,1,'Operation System Version','IOS9'),(11,1,'Trọng lượng (KG)','0.2'),(12,1,'Sản xuất tại','Trung quốc'),(13,1,'RAM memory','2GB'),(14,1,'Sim type','SIM nano'),(15,1,'Sim Slots','1'),(16,1,'Bộ nhớ trong','64GB'),(17,1,'Bảo hành','12 tháng'),(18,2,'3D TV','No'),(19,2,'Camera Back','11 - 15 MP'),(20,2,'Camera Front','5 - 6 MP'),(21,2,'Điều kiện','Mới'),(22,2,'Curved TV','No'),(23,2,'Kích thước màn hình','4.7'),(24,2,'Mẫu mã','6s'),(25,2,'Network Connections','3G-HSPA|4G-LTE'),(26,2,'Hệ điều hành','IOS'),(27,2,'Operation System Version','IOS9'),(28,2,'Trọng lượng (KG)','0.2'),(29,2,'Sản xuất tại','Trung quốc'),(30,2,'RAM memory','2GB'),(31,2,'Sim type','SIM nano'),(32,2,'Sim Slots','1'),(33,2,'Bộ nhớ trong','64GB'),(34,2,'Bảo hành','12 tháng'),(35,3,'3D TV','No'),(36,3,'Camera Back','11 - 15 MP'),(37,3,'Camera Front','5 - 6 MP'),(38,3,'Điều kiện','Mới'),(39,3,'Curved TV','No'),(40,3,'Kích thước màn hình','4.7'),(41,3,'Mẫu mã','6s'),(42,3,'Network Connections','3G-HSPA|4G-LTE'),(43,3,'Hệ điều hành','IOS'),(44,3,'Operation System Version','IOS9'),(45,3,'Trọng lượng (KG)','0.2'),(46,3,'Sản xuất tại','Trung quốc'),(47,3,'RAM memory','2GB'),(48,3,'Sim type','SIM nano'),(49,3,'Sim Slots','1'),(50,3,'Bộ nhớ trong','64GB'),(51,3,'Bảo hành','12 tháng'),(52,4,'3D TV','No'),(53,4,'Camera Back','11 - 15 MP'),(54,4,'Camera Front','5 - 6 MP'),(55,4,'Điều kiện','Mới'),(56,4,'Curved TV','No'),(57,4,'Kích thước màn hình','4.7'),(58,4,'Mẫu mã','6s'),(59,4,'Network Connections','3G-HSPA|4G-LTE'),(60,4,'Hệ điều hành','IOS'),(61,4,'Operation System Version','IOS9'),(62,4,'Trọng lượng (KG)','0.2'),(63,4,'Sản xuất tại','Trung quốc'),(64,4,'RAM memory','2GB'),(65,4,'Sim type','SIM nano'),(66,4,'Sim Slots','1'),(67,4,'Bộ nhớ trong','64GB'),(68,4,'Bảo hành','12 tháng'),(69,5,'3D TV','No'),(70,5,'Camera Back','11 - 15 MP'),(71,5,'Camera Front','5 - 6 MP'),(72,5,'Điều kiện','Mới'),(73,5,'Curved TV','No'),(74,5,'Kích thước màn hình','4.7'),(75,5,'Mẫu mã','6s'),(76,5,'Network Connections','3G-HSPA|4G-LTE'),(77,5,'Hệ điều hành','IOS'),(78,5,'Operation System Version','IOS9'),(79,5,'Trọng lượng (KG)','0.2'),(80,5,'Sản xuất tại','Trung quốc'),(81,5,'RAM memory','2GB'),(82,5,'Sim type','SIM nano'),(83,5,'Sim Slots','1'),(84,5,'Bộ nhớ trong','64GB'),(85,5,'Bảo hành','12 tháng'),(86,6,'3D TV','No'),(87,6,'Camera Back','11 - 15 MP'),(88,6,'Camera Front','5 - 6 MP'),(89,6,'Điều kiện','Mới'),(90,6,'Curved TV','No'),(91,6,'Kích thước màn hình','4.7'),(92,6,'Mẫu mã','6s'),(93,6,'Network Connections','3G-HSPA|4G-LTE'),(94,6,'Hệ điều hành','IOS'),(95,6,'Operation System Version','IOS9'),(96,6,'Trọng lượng (KG)','0.2'),(97,6,'Sản xuất tại','Trung quốc'),(98,6,'RAM memory','2GB'),(99,6,'Sim type','SIM nano'),(100,6,'Sim Slots','1'),(101,6,'Bộ nhớ trong','64GB'),(102,6,'Bảo hành','12 tháng'),(103,7,'3D TV','No'),(104,7,'Camera Back','11 - 15 MP'),(105,7,'Camera Front','5 - 6 MP'),(106,7,'Điều kiện','Mới'),(107,7,'Curved TV','No'),(108,7,'Kích thước màn hình','4.7'),(109,7,'Mẫu mã','6s'),(110,7,'Network Connections','3G-HSPA|4G-LTE'),(111,7,'Hệ điều hành','IOS'),(112,7,'Operation System Version','IOS9'),(113,7,'Trọng lượng (KG)','0.2'),(114,7,'Sản xuất tại','Trung quốc'),(115,7,'RAM memory','2GB'),(116,7,'Sim type','SIM nano'),(117,7,'Sim Slots','1'),(118,7,'Bộ nhớ trong','64GB'),(119,7,'Bảo hành','12 tháng'),(120,8,'3D TV','No'),(121,8,'Camera Back','11 - 15 MP'),(122,8,'Camera Front','5 - 6 MP'),(123,8,'Điều kiện','Mới'),(124,8,'Curved TV','No'),(125,8,'Kích thước màn hình','4.7'),(126,8,'Mẫu mã','6s'),(127,8,'Network Connections','3G-HSPA|4G-LTE'),(128,8,'Hệ điều hành','IOS'),(129,8,'Operation System Version','IOS9'),(130,8,'Trọng lượng (KG)','0.2'),(131,8,'Sản xuất tại','Trung quốc'),(132,8,'RAM memory','2GB'),(133,8,'Sim type','SIM nano'),(134,8,'Sim Slots','1'),(135,8,'Bộ nhớ trong','64GB'),(136,8,'Bảo hành','12 tháng'),(137,9,'3D TV','No'),(138,9,'Camera Back','11 - 15 MP'),(139,9,'Camera Front','5 - 6 MP'),(140,9,'Điều kiện','Mới'),(141,9,'Curved TV','No'),(142,9,'Kích thước màn hình','4.7'),(143,9,'Mẫu mã','6s'),(144,9,'Network Connections','3G-HSPA|4G-LTE'),(145,9,'Hệ điều hành','IOS'),(146,9,'Operation System Version','IOS9'),(147,9,'Trọng lượng (KG)','0.2'),(148,9,'Sản xuất tại','Trung quốc'),(149,9,'RAM memory','2GB'),(150,9,'Sim type','SIM nano'),(151,9,'Sim Slots','1'),(152,9,'Bộ nhớ trong','64GB'),(153,9,'Bảo hành','12 tháng'),(154,10,'3D TV','No'),(155,10,'Camera Back','11 - 15 MP'),(156,10,'Camera Front','5 - 6 MP'),(157,10,'Điều kiện','Mới'),(158,10,'Curved TV','No'),(159,10,'Kích thước màn hình','4.7'),(160,10,'Mẫu mã','6s'),(161,10,'Network Connections','3G-HSPA|4G-LTE'),(162,10,'Hệ điều hành','IOS'),(163,10,'Operation System Version','IOS9'),(164,10,'Trọng lượng (KG)','0.2'),(165,10,'Sản xuất tại','Trung quốc'),(166,10,'RAM memory','2GB'),(167,10,'Sim type','SIM nano'),(168,10,'Sim Slots','1'),(169,10,'Bộ nhớ trong','64GB'),(170,10,'Bảo hành','12 tháng'),(171,11,'3D TV','No'),(172,11,'Camera Back','11 - 15 MP'),(173,11,'Camera Front','5 - 6 MP'),(174,11,'Điều kiện','Mới'),(175,11,'Curved TV','No'),(176,11,'Kích thước màn hình','4.7'),(177,11,'Mẫu mã','6s'),(178,11,'Network Connections','3G-HSPA|4G-LTE'),(179,11,'Hệ điều hành','IOS'),(180,11,'Operation System Version','IOS9'),(181,11,'Trọng lượng (KG)','0.2'),(182,11,'Sản xuất tại','Trung quốc'),(183,11,'RAM memory','2GB'),(184,11,'Sim type','SIM nano'),(185,11,'Sim Slots','1'),(186,11,'Bộ nhớ trong','64GB'),(187,11,'Bảo hành','12 tháng'),(188,12,'3D TV','No'),(189,12,'Camera Back','11 - 15 MP'),(190,12,'Camera Front','5 - 6 MP'),(191,12,'Điều kiện','Mới'),(192,12,'Curved TV','No'),(193,12,'Kích thước màn hình','4.7'),(194,12,'Mẫu mã','6s'),(195,12,'Network Connections','3G-HSPA|4G-LTE'),(196,12,'Hệ điều hành','IOS'),(197,12,'Operation System Version','IOS9'),(198,12,'Trọng lượng (KG)','0.2'),(199,12,'Sản xuất tại','Trung quốc'),(200,12,'RAM memory','2GB'),(201,12,'Sim type','SIM nano'),(202,12,'Sim Slots','1'),(203,12,'Bộ nhớ trong','64GB'),(204,12,'Bảo hành','12 tháng'),(205,13,'3D TV','No'),(206,13,'Camera Back','11 - 15 MP'),(207,13,'Camera Front','5 - 6 MP'),(208,13,'Điều kiện','Mới'),(209,13,'Curved TV','No'),(210,13,'Kích thước màn hình','4.7'),(211,13,'Mẫu mã','6s'),(212,13,'Network Connections','3G-HSPA|4G-LTE'),(213,13,'Hệ điều hành','IOS'),(214,13,'Operation System Version','IOS9'),(215,13,'Trọng lượng (KG)','0.2'),(216,13,'Sản xuất tại','Trung quốc'),(217,13,'RAM memory','2GB'),(218,13,'Sim type','SIM nano'),(219,13,'Sim Slots','1'),(220,13,'Bộ nhớ trong','64GB'),(221,13,'Bảo hành','12 tháng'),(222,14,'3D TV','No'),(223,14,'Camera Back','11 - 15 MP'),(224,14,'Camera Front','5 - 6 MP'),(225,14,'Điều kiện','Mới'),(226,14,'Curved TV','No'),(227,14,'Kích thước màn hình','4.7'),(228,14,'Mẫu mã','6s'),(229,14,'Network Connections','3G-HSPA|4G-LTE'),(230,14,'Hệ điều hành','IOS'),(231,14,'Operation System Version','IOS9'),(232,14,'Trọng lượng (KG)','0.2'),(233,14,'Sản xuất tại','Trung quốc'),(234,14,'RAM memory','2GB'),(235,14,'Sim type','SIM nano'),(236,14,'Sim Slots','1'),(237,14,'Bộ nhớ trong','64GB'),(238,14,'Bảo hành','12 tháng'),(239,15,'3D TV','No'),(240,15,'Camera Back','11 - 15 MP'),(241,15,'Camera Front','5 - 6 MP'),(242,15,'Điều kiện','Mới'),(243,15,'Curved TV','No'),(244,15,'Kích thước màn hình','4.7'),(245,15,'Mẫu mã','6s'),(246,15,'Network Connections','3G-HSPA|4G-LTE'),(247,15,'Hệ điều hành','IOS'),(248,15,'Operation System Version','IOS9'),(249,15,'Trọng lượng (KG)','0.2'),(250,15,'Sản xuất tại','Trung quốc'),(251,15,'RAM memory','2GB'),(252,15,'Sim type','SIM nano'),(253,15,'Sim Slots','1'),(254,15,'Bộ nhớ trong','64GB'),(255,15,'Bảo hành','12 tháng'),(256,16,'3D TV','No'),(257,16,'Camera Back','11 - 15 MP'),(258,16,'Camera Front','5 - 6 MP'),(259,16,'Điều kiện','Mới'),(260,16,'Curved TV','No'),(261,16,'Kích thước màn hình','4.7'),(262,16,'Mẫu mã','6s'),(263,16,'Network Connections','3G-HSPA|4G-LTE'),(264,16,'Hệ điều hành','IOS'),(265,16,'Operation System Version','IOS9'),(266,16,'Trọng lượng (KG)','0.2'),(267,16,'Sản xuất tại','Trung quốc'),(268,16,'RAM memory','2GB'),(269,16,'Sim type','SIM nano'),(270,16,'Sim Slots','1'),(271,16,'Bộ nhớ trong','64GB'),(272,16,'Bảo hành','12 tháng'),(273,17,'3D TV','No'),(274,17,'Camera Back','11 - 15 MP'),(275,17,'Camera Front','5 - 6 MP'),(276,17,'Điều kiện','Mới'),(277,17,'Curved TV','No'),(278,17,'Kích thước màn hình','4.7'),(279,17,'Mẫu mã','6s'),(280,17,'Network Connections','3G-HSPA|4G-LTE'),(281,17,'Hệ điều hành','IOS'),(282,17,'Operation System Version','IOS9'),(283,17,'Trọng lượng (KG)','0.2'),(284,17,'Sản xuất tại','Trung quốc'),(285,17,'RAM memory','2GB'),(286,17,'Sim type','SIM nano'),(287,17,'Sim Slots','1'),(288,17,'Bộ nhớ trong','64GB'),(289,17,'Bảo hành','12 tháng'),(290,18,'3D TV','No'),(291,18,'Camera Back','11 - 15 MP'),(292,18,'Camera Front','5 - 6 MP'),(293,18,'Điều kiện','Mới'),(294,18,'Curved TV','No'),(295,18,'Kích thước màn hình','4.7'),(296,18,'Mẫu mã','6s'),(297,18,'Network Connections','3G-HSPA|4G-LTE'),(298,18,'Hệ điều hành','IOS'),(299,18,'Operation System Version','IOS9'),(300,18,'Trọng lượng (KG)','0.2'),(301,18,'Sản xuất tại','Trung quốc'),(302,18,'RAM memory','2GB'),(303,18,'Sim type','SIM nano'),(304,18,'Sim Slots','1'),(305,18,'Bộ nhớ trong','64GB'),(306,18,'Bảo hành','12 tháng'),(307,19,'3D TV','No'),(308,19,'Camera Back','11 - 15 MP'),(309,19,'Camera Front','5 - 6 MP'),(310,19,'Điều kiện','Mới'),(311,19,'Curved TV','No'),(312,19,'Kích thước màn hình','4.7'),(313,19,'Mẫu mã','6s'),(314,19,'Network Connections','3G-HSPA|4G-LTE'),(315,19,'Hệ điều hành','IOS'),(316,19,'Operation System Version','IOS9'),(317,19,'Trọng lượng (KG)','0.2'),(318,19,'Sản xuất tại','Trung quốc'),(319,19,'RAM memory','2GB'),(320,19,'Sim type','SIM nano'),(321,19,'Sim Slots','1'),(322,19,'Bộ nhớ trong','64GB'),(323,19,'Bảo hành','12 tháng'),(324,20,'3D TV','No'),(325,20,'Camera Back','11 - 15 MP'),(326,20,'Camera Front','5 - 6 MP'),(327,20,'Điều kiện','Mới'),(328,20,'Curved TV','No'),(329,20,'Kích thước màn hình','4.7'),(330,20,'Mẫu mã','6s'),(331,20,'Network Connections','3G-HSPA|4G-LTE'),(332,20,'Hệ điều hành','IOS'),(333,20,'Operation System Version','IOS9'),(334,20,'Trọng lượng (KG)','0.2'),(335,20,'Sản xuất tại','Trung quốc'),(336,20,'RAM memory','2GB'),(337,20,'Sim type','SIM nano'),(338,20,'Sim Slots','1'),(339,20,'Bộ nhớ trong','64GB'),(340,20,'Bảo hành','12 tháng'),(341,21,'3D TV','No'),(342,21,'Camera Back','11 - 15 MP'),(343,21,'Camera Front','5 - 6 MP'),(344,21,'Điều kiện','Mới'),(345,21,'Curved TV','No'),(346,21,'Kích thước màn hình','4.7'),(347,21,'Mẫu mã','6s'),(348,21,'Network Connections','3G-HSPA|4G-LTE'),(349,21,'Hệ điều hành','IOS'),(350,21,'Operation System Version','IOS9'),(351,21,'Trọng lượng (KG)','0.2'),(352,21,'Sản xuất tại','Trung quốc'),(353,21,'RAM memory','2GB'),(354,21,'Sim type','SIM nano'),(355,21,'Sim Slots','1'),(356,21,'Bộ nhớ trong','64GB'),(357,21,'Bảo hành','12 tháng'),(358,22,'3D TV','No'),(359,22,'Camera Back','11 - 15 MP'),(360,22,'Camera Front','5 - 6 MP'),(361,22,'Điều kiện','Mới'),(362,22,'Curved TV','No'),(363,22,'Kích thước màn hình','4.7'),(364,22,'Mẫu mã','6s'),(365,22,'Network Connections','3G-HSPA|4G-LTE'),(366,22,'Hệ điều hành','IOS'),(367,22,'Operation System Version','IOS9'),(368,22,'Trọng lượng (KG)','0.2'),(369,22,'Sản xuất tại','Trung quốc'),(370,22,'RAM memory','2GB'),(371,22,'Sim type','SIM nano'),(372,22,'Sim Slots','1'),(373,22,'Bộ nhớ trong','64GB'),(374,22,'Bảo hành','12 tháng'),(375,23,'3D TV','No'),(376,23,'Camera Back','11 - 15 MP'),(377,23,'Camera Front','5 - 6 MP'),(378,23,'Điều kiện','Mới'),(379,23,'Curved TV','No'),(380,23,'Kích thước màn hình','4.7'),(381,23,'Mẫu mã','6s'),(382,23,'Network Connections','3G-HSPA|4G-LTE'),(383,23,'Hệ điều hành','IOS'),(384,23,'Operation System Version','IOS9'),(385,23,'Trọng lượng (KG)','0.2'),(386,23,'Sản xuất tại','Trung quốc'),(387,23,'RAM memory','2GB'),(388,23,'Sim type','SIM nano'),(389,23,'Sim Slots','1'),(390,23,'Bộ nhớ trong','64GB'),(391,23,'Bảo hành','12 tháng'),(392,24,'3D TV','No'),(393,24,'Camera Back','11 - 15 MP'),(394,24,'Camera Front','5 - 6 MP'),(395,24,'Điều kiện','Mới'),(396,24,'Curved TV','No'),(397,24,'Kích thước màn hình','4.7'),(398,24,'Mẫu mã','6s'),(399,24,'Network Connections','3G-HSPA|4G-LTE'),(400,24,'Hệ điều hành','IOS'),(401,24,'Operation System Version','IOS9'),(402,24,'Trọng lượng (KG)','0.2'),(403,24,'Sản xuất tại','Trung quốc'),(404,24,'RAM memory','2GB'),(405,24,'Sim type','SIM nano'),(406,24,'Sim Slots','1'),(407,24,'Bộ nhớ trong','64GB'),(408,24,'Bảo hành','12 tháng'),(409,25,'3D TV','No'),(410,25,'Camera Back','11 - 15 MP'),(411,25,'Camera Front','5 - 6 MP'),(412,25,'Điều kiện','Mới'),(413,25,'Curved TV','No'),(414,25,'Kích thước màn hình','4.7'),(415,25,'Mẫu mã','6s'),(416,25,'Network Connections','3G-HSPA|4G-LTE'),(417,25,'Hệ điều hành','IOS'),(418,25,'Operation System Version','IOS9'),(419,25,'Trọng lượng (KG)','0.2'),(420,25,'Sản xuất tại','Trung quốc'),(421,25,'RAM memory','2GB'),(422,25,'Sim type','SIM nano'),(423,25,'Sim Slots','1'),(424,25,'Bộ nhớ trong','64GB'),(425,25,'Bảo hành','12 tháng'),(426,26,'3D TV','No'),(427,26,'Camera Back','11 - 15 MP'),(428,26,'Camera Front','5 - 6 MP'),(429,26,'Điều kiện','Mới'),(430,26,'Curved TV','No'),(431,26,'Kích thước màn hình','4.7'),(432,26,'Mẫu mã','6s'),(433,26,'Network Connections','3G-HSPA|4G-LTE'),(434,26,'Hệ điều hành','IOS'),(435,26,'Operation System Version','IOS9'),(436,26,'Trọng lượng (KG)','0.2'),(437,26,'Sản xuất tại','Trung quốc'),(438,26,'RAM memory','2GB'),(439,26,'Sim type','SIM nano'),(440,26,'Sim Slots','1'),(441,26,'Bộ nhớ trong','64GB'),(442,26,'Bảo hành','12 tháng'),(443,27,'3D TV','No'),(444,27,'Camera Back','11 - 15 MP'),(445,27,'Camera Front','5 - 6 MP'),(446,27,'Điều kiện','Mới'),(447,27,'Curved TV','No'),(448,27,'Kích thước màn hình','4.7'),(449,27,'Mẫu mã','6s'),(450,27,'Network Connections','3G-HSPA|4G-LTE'),(451,27,'Hệ điều hành','IOS'),(452,27,'Operation System Version','IOS9'),(453,27,'Trọng lượng (KG)','0.2'),(454,27,'Sản xuất tại','Trung quốc'),(455,27,'RAM memory','2GB'),(456,27,'Sim type','SIM nano'),(457,27,'Sim Slots','1'),(458,27,'Bộ nhớ trong','64GB'),(459,27,'Bảo hành','12 tháng'),(460,27,'3D TV','No'),(461,27,'Camera Back','11 - 15 MP'),(462,27,'Camera Front','5 - 6 MP'),(463,27,'Điều kiện','Mới'),(464,27,'Curved TV','No'),(465,27,'Kích thước màn hình','4.7'),(466,27,'Mẫu mã','6s'),(467,27,'Network Connections','3G-HSPA|4G-LTE'),(468,27,'Hệ điều hành','IOS'),(469,27,'Operation System Version','IOS9'),(470,27,'Trọng lượng (KG)','0.2'),(471,27,'Sản xuất tại','Trung quốc'),(472,27,'RAM memory','2GB'),(473,28,'3D TV','No'),(474,28,'Camera Back','11 - 15 MP'),(475,28,'Camera Front','5 - 6 MP'),(476,28,'Điều kiện','Mới'),(477,28,'Curved TV','No'),(478,28,'Kích thước màn hình','4.7'),(479,28,'Mẫu mã','6s'),(480,28,'Network Connections','3G-HSPA|4G-LTE'),(481,28,'Hệ điều hành','IOS'),(482,28,'Operation System Version','IOS9'),(483,28,'Trọng lượng (KG)','0.2'),(484,28,'Sản xuất tại','Trung quốc'),(485,28,'RAM memory','2GB'),(486,28,'Sim type','SIM nano'),(487,28,'Sim Slots','1'),(488,28,'Bộ nhớ trong','64GB'),(489,28,'Bảo hành','12 tháng'),(490,29,'3D TV','No'),(491,29,'Camera Back','11 - 15 MP'),(492,29,'Camera Front','5 - 6 MP'),(493,29,'Điều kiện','Mới'),(494,29,'Curved TV','No'),(495,29,'Kích thước màn hình','4.7'),(496,29,'Mẫu mã','6s'),(497,29,'Network Connections','3G-HSPA|4G-LTE'),(498,29,'Hệ điều hành','IOS'),(499,29,'Operation System Version','IOS9'),(500,29,'Trọng lượng (KG)','0.2'),(501,29,'Sản xuất tại','Trung quốc'),(502,29,'RAM memory','2GB'),(503,29,'Sim type','SIM nano'),(504,29,'Sim Slots','1'),(505,29,'Bộ nhớ trong','64GB'),(506,29,'Bảo hành','12 tháng'),(507,30,'3D TV','No'),(508,30,'Camera Back','11 - 15 MP'),(509,30,'Camera Front','5 - 6 MP'),(510,30,'Điều kiện','Mới'),(511,30,'Curved TV','No'),(512,30,'Kích thước màn hình','4.7'),(513,30,'Mẫu mã','6s'),(514,30,'Network Connections','3G-HSPA|4G-LTE'),(515,30,'Hệ điều hành','IOS'),(516,30,'Operation System Version','IOS9'),(517,30,'Trọng lượng (KG)','0.2'),(518,30,'Sản xuất tại','Trung quốc'),(519,30,'RAM memory','2GB'),(520,30,'Sim type','SIM nano'),(521,30,'Sim Slots','1'),(522,30,'Bộ nhớ trong','64GB'),(523,30,'Bảo hành','12 tháng'),(524,31,'3D TV','No'),(525,31,'Camera Back','11 - 15 MP'),(526,31,'Camera Front','5 - 6 MP'),(527,31,'Điều kiện','Mới'),(528,31,'Curved TV','No'),(529,31,'Kích thước màn hình','4.7'),(530,31,'Mẫu mã','6s'),(531,31,'Network Connections','3G-HSPA|4G-LTE'),(532,31,'Hệ điều hành','IOS'),(533,31,'Operation System Version','IOS9'),(534,31,'Trọng lượng (KG)','0.2'),(535,31,'Sản xuất tại','Trung quốc'),(536,31,'RAM memory','2GB'),(537,31,'Sim type','SIM nano'),(538,31,'Sim Slots','1'),(539,31,'Bộ nhớ trong','64GB'),(540,31,'Bảo hành','12 tháng'),(541,32,'3D TV','No'),(542,32,'Camera Back','11 - 15 MP'),(543,32,'Camera Front','5 - 6 MP'),(544,32,'Điều kiện','Mới'),(545,32,'Curved TV','No'),(546,32,'Kích thước màn hình','4.7'),(547,32,'Mẫu mã','6s'),(548,32,'Network Connections','3G-HSPA|4G-LTE'),(549,32,'Hệ điều hành','IOS'),(550,32,'Operation System Version','IOS9'),(551,32,'Trọng lượng (KG)','0.2'),(552,32,'Sản xuất tại','Trung quốc'),(553,32,'RAM memory','2GB'),(554,32,'Sim type','SIM nano'),(555,32,'Sim Slots','1'),(556,32,'Bộ nhớ trong','64GB'),(557,32,'Bảo hành','12 tháng');
/*!40000 ALTER TABLE `chitietsanpham` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `danhgia`
--

DROP TABLE IF EXISTS `danhgia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `danhgia` (
  `MADG` varchar(200) NOT NULL,
  `MASP` int DEFAULT NULL,
  `TENTHIETBI` text,
  `TIEUDE` text,
  `NOIDUNG` text,
  `SOSAO` int DEFAULT NULL,
  `NGAYDANHGIA` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`MADG`),
  KEY `KHOANGOAI_DANHGIA_MASP` (`MASP`),
  CONSTRAINT `KHOANGOAI_DANHGIA_MASP` FOREIGN KEY (`MASP`) REFERENCES `sanpham` (`masp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `danhgia`
--

LOCK TABLES `danhgia` WRITE;
/*!40000 ALTER TABLE `danhgia` DISABLE KEYS */;
INSERT INTO `danhgia` VALUES ('Android SDK built for x861',1,'Android SDK built for x86','Tui xai oke','tui Danh gia khach Quan nhe',4,'01/01/2021'),('Android SDK built for x862',2,'Android SDK built for x86','Huy Danh Gia','Qua la oke luon!!!',5,'01/01/2021'),('Android SDK built for x863',2,'Android SDK built for x86','Huy Danh Gia','Tuyệt vời!',4,'01/01/2021'),('Nokia 6.1 Plus2',2,'Nokia 6.1 Plus','Hao danh gia','Hao thấy sản phẩm xài tốt',4,'04/01/2021');
/*!40000 ALTER TABLE `danhgia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dondathang`
--

DROP TABLE IF EXISTS `dondathang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dondathang` (
  `madh` int NOT NULL AUTO_INCREMENT,
  `manv` int DEFAULT NULL,
  `trangthai` tinyint(1) DEFAULT NULL,
  `diachigiao` text,
  `ngaydat` varchar(10) DEFAULT NULL,
  `ngaygiao` varchar(10) DEFAULT NULL,
  `mota` text,
  PRIMARY KEY (`madh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dondathang`
--

LOCK TABLES `dondathang` WRITE;
/*!40000 ALTER TABLE `dondathang` DISABLE KEYS */;
/*!40000 ALTER TABLE `dondathang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `giohang`
--

DROP TABLE IF EXISTS `giohang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `giohang` (
  `magiohang` int NOT NULL AUTO_INCREMENT,
  `manv` int DEFAULT NULL,
  `masp` int DEFAULT NULL,
  `tensp` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `giatien` decimal(10,0) DEFAULT NULL,
  `hinhanh` text,
  `soluong` int DEFAULT NULL,
  PRIMARY KEY (`magiohang`),
  UNIQUE KEY `magiohang_UNIQUE` (`magiohang`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giohang`
--

LOCK TABLES `giohang` WRITE;
/*!40000 ALTER TABLE `giohang` DISABLE KEYS */;
INSERT INTO `giohang` VALUES (5,1,1,'Apple Iphone 6s Plus 16GB',13960000,'/hinhsanpham/iphone6spluse.png',1),(19,2,1,'Apple Iphone 6s Plus 16GB',13960000,'/hinhsanpham/iphone6spluse.png',1),(20,3,1,'Apple Iphone 6s Plus 16GB',27920000,'/hinhsanpham/iphone6spluse.png',2),(21,9,2,'Apple Iphone 6s Plus 16GB (Vàng hồng)',41880000,'/hinhsanpham/iphone6spluse.png',3);
/*!40000 ALTER TABLE `giohang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoadon`
--

DROP TABLE IF EXISTS `hoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoadon` (
  `MAHD` int NOT NULL AUTO_INCREMENT,
  `NGAYMUA` text,
  `NGAYGIAO` text,
  `TRANGTHAI` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT 'Đang chờ',
  `TENNGUOINHAN` varchar(50) DEFAULT NULL,
  `SODT` text,
  `DIACHI` text,
  `CHUYENKHOAN` tinyint(1) DEFAULT NULL,
  `MACHUYENKHOAN` text,
  PRIMARY KEY (`MAHD`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadon`
--

LOCK TABLES `hoadon` WRITE;
/*!40000 ALTER TABLE `hoadon` DISABLE KEYS */;
INSERT INTO `hoadon` VALUES (2,'04/01/2021','08/01/2021',NULL,'Huy Huynh','0985632585','71 Cong Hoa',1,NULL),(3,'04/01/2021','08/01/2021',NULL,'Huy Huynh','0987541744','71/36 Congrats Hoa',0,NULL);
/*!40000 ALTER TABLE `hoadon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khuyenmai`
--

DROP TABLE IF EXISTS `khuyenmai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khuyenmai` (
  `MAKM` int NOT NULL AUTO_INCREMENT,
  `MALOAISP` int DEFAULT NULL,
  `TENKM` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `NGAYBATDAU` varchar(20) DEFAULT NULL,
  `NGAYKETTHUC` varchar(20) DEFAULT NULL,
  `HINHKHUYENMAI` text,
  PRIMARY KEY (`MAKM`),
  KEY `KHOANGOAI_KHUYENMAI_MALOAISP` (`MALOAISP`),
  CONSTRAINT `KHOANGOAI_KHUYENMAI_MALOAISP` FOREIGN KEY (`MALOAISP`) REFERENCES `loaisanpham` (`maloaisp`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khuyenmai`
--

LOCK TABLES `khuyenmai` WRITE;
/*!40000 ALTER TABLE `khuyenmai` DISABLE KEYS */;
INSERT INTO `khuyenmai` VALUES (1,2,'Xã hàng hot đến 49%','2016/9/12','2021/10/12','/hinhkhuyenmai/con loc giam gia mua he.png'),(2,2,'Giải nhiệt mùa hè giảm ngay 50%','2016/9/12','2021/10/12','/hinhkhuyenmai/khuyen mai ta quan ta dan.jpg'),(3,2,'Hè này mua gì ?','2016/9/12','2021/10/12','/hinhkhuyenmai/du lich.jpg'),(4,3,'Festival salve !','2016/9/12','2020/10/12','/hinhkhuyenmai/festival sale 90.jpg');
/*!40000 ALTER TABLE `khuyenmai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loaikhuyenmai`
--

DROP TABLE IF EXISTS `loaikhuyenmai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loaikhuyenmai` (
  `maloaikm` int NOT NULL AUTO_INCREMENT,
  `tenloaikm` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`maloaikm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaikhuyenmai`
--

LOCK TABLES `loaikhuyenmai` WRITE;
/*!40000 ALTER TABLE `loaikhuyenmai` DISABLE KEYS */;
/*!40000 ALTER TABLE `loaikhuyenmai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loainhanvien`
--

DROP TABLE IF EXISTS `loainhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loainhanvien` (
  `maloainv` int NOT NULL AUTO_INCREMENT,
  `tenloainv` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`maloainv`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loainhanvien`
--

LOCK TABLES `loainhanvien` WRITE;
/*!40000 ALTER TABLE `loainhanvien` DISABLE KEYS */;
INSERT INTO `loainhanvien` VALUES (1,'Admin'),(2,'Khách hàng');
/*!40000 ALTER TABLE `loainhanvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loaisanpham`
--

DROP TABLE IF EXISTS `loaisanpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loaisanpham` (
  `maloaisp` int NOT NULL AUTO_INCREMENT,
  `tenloaisp` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `maloai_cha` int DEFAULT NULL,
  PRIMARY KEY (`maloaisp`)
) ENGINE=InnoDB AUTO_INCREMENT=143 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaisanpham`
--

LOCK TABLES `loaisanpham` WRITE;
/*!40000 ALTER TABLE `loaisanpham` DISABLE KEYS */;
INSERT INTO `loaisanpham` VALUES (1,'Điện thoại & Máy tính bảng',0),(2,'Điện thoại di động',1),(3,'Máy tính bảng',1),(4,'Điện thoại bàn',1),(5,'Phụ kiện điện thoại & máy tính bảng',1),(6,'Ốp lưng và bao da điện thoại',5),(7,'Miếng dán màn hình điện thoại',5),(8,'Phụ kiện di động trên xe hơi',5),(9,'Phụ kiện khác',5),(10,'Cáp & Dock sạc',5),(11,'Linh kiện & Dụng cụ',5),(12,'SIM & Thẻ cào',5),(13,'Pin và bộ sạc',5),(14,'Phụ kiện máy tính bảng',5),(15,'Pin sạc dự phòng',5),(16,'Phụ kiện camera điện thoại',5),(17,'Nhà cửa & Đời sống',0),(18,'Bếp phòng ăn',17),(19,'Dụng cụ làm bánh',18),(20,'Dụng cụ nấu ăn',18),(21,'Đồ dùng bàn ăn',18),(22,'Đồ dùng uống trà và cà phê',18),(23,'Dao nấu bếp',18),(24,'Khăn trải bàn & Phụ kiện bằng vải',18),(25,'Phụ kiện & Dụng cụ nhà bếp',18),(26,'Đồ dùng phòng ngủ',17),(27,'Bộ chăn và ga giường gối',26),(28,'Gối',26),(29,'Phụ kiện giường ngủ',26),(30,'Bộ chăn ra gối nệm',26),(31,'Ga giường',26),(32,'Nệm và Vỏ nệm',26),(33,'Đồ nội thất',17),(34,'Nội thất phòng ngủ',33),(35,'Nội thất phòng khách',33),(36,'Nội thất bếp & Phòng ăn',33),(37,'Nội thất phòng trẻ em',33),(38,'Nội thất phòng làm việc tại gia',33),(39,'Nội thất cho hành lang & lối vào',33),(40,'Nội thất phòng trang trí',33),(41,'Nội thất kiểu cổ',33),(42,'Tân trang nhà cửa',17),(43,'Kho chứa dụng cụ và Garage',42),(44,'Điện',42),(45,'Cổng và Hàng rào',42),(46,'Bảo vệ và An toàn',42),(47,'Ống nước',42),(48,'Máy vi tính & Laptop',17),(49,'Laptop',48),(50,'Dòng giải trí',49),(51,'Macbooks',49),(52,'Ultrabooks',49),(53,'Thiết bị lưu trữ',17),(54,'Ổ cứng SSD',53),(55,'Ổ cứng gắn ngoài',53),(56,'Ổ cứng gắn trong',53),(57,'USB lưu trữ',53),(58,'Máy in & Phụ kiện',17),(59,'Máy in',58),(60,'Kệ máy in',58),(61,'Máy Fax',58),(62,'Mực in',58),(63,'Chăm sóc sức khỏe & làm đẹp',17),(64,'Trang điểm',63),(65,'Mặt',64),(66,'Môi',64),(67,'Mắt',64),(68,'Tẩy trang',64),(69,'Chăm sóc mặt',63),(70,'Mặt nạ đắp',69),(71,'Sữa rữa mặt',69),(72,'Thể thao',17),(73,'Yaga & Thể hình',72),(74,'Yoga',73),(75,'Máy tập thể hình',73),(76,'Máy tập thể lực',73),(77,'Giày & Trang phục',72),(78,'Dành cho nữ',77),(79,'Dành cho nam',77),(80,'Dành cho bé',77),(81,'Thời trang',0),(82,'TV, Video, Âm Thanh ,Game & Thiết Bị Số',0),(83,'Tivi',82),(84,'Dưới 24 inches',83),(85,'25-32 inches',83),(86,'33-42 inches',83),(87,'43-54 inches',83),(88,'Trên 55 inches',83),(89,'Tivi giá đặc biệt cho các tỉnh, thành lớn',83),(90,'Thiết bị âm thanh',82),(91,'Các loại tai nghe',90),(92,'Loa di động',90),(93,'Dàn âm thanh giải trí',90),(94,'Máy nghe nhạc',90),(95,'Video',82),(96,'Thiết bị trình chiếu',95),(97,'Thiết bị streaming',95),(98,'Thiết bị chơi game',82),(99,'Xbox',98),(100,'Nitendo',98),(101,'Thiết bị đeo công nghệ',82),(102,'Đồng hồ thông minh',101),(103,'Thiết bị theo dõi sức khỏe & vận động',101),(104,'Mắt kính thông minh',101),(105,'Thiết bị giám sát thông minh',102),(106,'Thể thao & du lịch',0),(107,'Các loại bài tập & thể hình',106),(108,'Máy tập thể hình',107),(109,'Máy tập thể lực',107),(110,'Phụ kiện',107),(111,'Tạ',107),(112,'Yoga',107),(113,'Pilates',107),(114,'Đấm bốc, Võ thuật & Đánh MMA',107),(115,'Thể tao đồng đội',106),(116,'Máy tập thể hình',115),(117,'Máy tập thể hình',115),(118,'Bóng đá',115),(119,'Bóng rổ',115),(120,'Bóng chuyền',115),(121,'Hoạt động dã ngoại',106),(122,'Xe đạp',121),(123,'Dã ngoại & leo núi',121),(124,'Câu cá',121),(125,'Xe Scooters',121),(126,'Trượt băng trong nhà',121),(127,'Trượt ván',121),(128,'Bơi lội',121),(129,'Xe máy và bách hóa',0),(130,'Ô tô & xe máy',129),(131,'Chăm sóc ô tô & xe máy',130),(132,'Phụ kiện bên ngoài',130),(133,'Phụ kiện bên trong',130),(134,'Link kiện thay thế',130),(135,'Thiết bị giám định ô tô',130),(136,'Xe mô tô & xe địa hình',130),(137,'Dầu nhớt',130),(138,'Sơn sửa',130),(139,'Phụ kiện xe tải',130),(140,'Dụng cụ và thiết bị',130),(141,'Bánh & vỏ xe',130),(142,'Thiết bị định vị',130);
/*!40000 ALTER TABLE `loaisanpham` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `sanpham`
--

DROP TABLE IF EXISTS `sanpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sanpham` (
  `masp` int NOT NULL AUTO_INCREMENT,
  `tensp` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `gia` decimal(10,0) DEFAULT NULL,
  `hinhlon` text,
  `hinhnho` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `thongtin` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `soluong` int DEFAULT NULL,
  `maloaisp` int DEFAULT NULL,
  `math` int DEFAULT NULL,
  `luotmua` int DEFAULT NULL,
  `manv` int DEFAULT NULL,
  PRIMARY KEY (`masp`),
  KEY `FK_LoaiSP` (`maloaisp`),
  KEY `FK_ThuongHieu` (`math`),
  KEY `FK_MaNvSanPham_idx` (`manv`),
  CONSTRAINT `FK_LoaiSP` FOREIGN KEY (`maloaisp`) REFERENCES `loaisanpham` (`maloaisp`),
  CONSTRAINT `FK_MaNvSanPham` FOREIGN KEY (`manv`) REFERENCES `nhanvien` (`manv`),
  CONSTRAINT `FK_ThuongHieu` FOREIGN KEY (`math`) REFERENCES `thuonghieu` (`math`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sanpham`
--

LOCK TABLES `sanpham` WRITE;
/*!40000 ALTER TABLE `sanpham` DISABLE KEYS */;
INSERT INTO `sanpham` VALUES (1,'Apple Iphone 6s Plus 16GB',13960000,'/hinhsanpham/iphone6spluse.png','/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg','Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu',10,2,1,10,1),(2,'Apple Iphone 6s Plus 16GB (Vàng hồng)',13960000,'/hinhsanpham/iphone6spluse.png','/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg','Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu',10,2,1,5,1),(3,'Apple Iphone 6s Plus 16GB (Vàng gold)',13960000,'/hinhsanpham/iphone6spluse.png','/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg','Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu',10,2,1,0,1),(4,'Apple Iphone 6s Plus 16GB (Vàng gold)',13960000,'/hinhsanpham/iphone6spluse.png','/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg','Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu',10,2,1,0,2),(5,'Apple Iphone 6s Plus 16GB (Vàng gold)',13960000,'/hinhsanpham/iphone6spluse.png','/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg','Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu',10,2,1,0,2),(6,'Apple Iphone 6s Plus 16GB (Vàng gold)',13960000,'/hinhsanpham/iphone6spluse.png','/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg','Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu',10,2,1,0,2),(7,'Apple Iphone 6s Plus 16GB (Vàng gold)',13960000,'/hinhsanpham/iphone6spluse.png','/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg','Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu',10,2,1,0,2),(8,'Apple Iphone 6s Plus 16GB (Vàng gold)',13960000,'/hinhsanpham/iphone6spluse.png','/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg','Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu',10,2,1,0,2),(9,'Apple Iphone 6s Plus 16GB (Vàng gold)',13960000,'/hinhsanpham/iphone6spluse.png','/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg','Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu',10,2,1,0,2),(10,'Apple Iphone 6s Plus 16GB (Vàng gold)',13960000,'/hinhsanpham/iphone6spluse.png','/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg','Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu',10,2,1,0,2),(11,'Apple Iphone 6s Plus 16GB (Vàng gold)',13960000,'/hinhsanpham/iphone6spluse.png','/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg','Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu',10,49,1,6,2),(12,'Pin sạc dự phòng Asus Zenpower 10.050mAh (Vàng) ',339000,'/hinhsanpham/pinsacduphongasus.jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,13,5,12,2),(13,'Bao da kiêm bàn phím cho máy tính bảng 7 inch ( Đen)  ',98000,'/hinhsanpham/baodabanphimmaytinhbang7ich.jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,14,5,0,2),(14,'Gậy chụp hình Selfie Stick (Đen phối vàng) ',36000,'/hinhsanpham/gaychuphinhtusuong.png','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,16,5,7,2),(15,'Bộ Miếng dán cường lực và ốp lưng cho iPhone 6 - NVPro 30306 (Trong suốt)  ',86000,'/hinhsanpham/mieng-gian-cuong-luc-iphone-6-6s.jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,7,5,0,2),(16,'Đế kẹp smartphone cho điện thoại',36000,'/hinhsanpham/dekepsmartphonechodienthoai.jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,8,5,2,2),(17,'Sim 3G tài khoản 600 MB',106000,'/hinhsanpham/sim3gtaikhoan600.jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,12,5,1,2),(18,'Ổ cắm thông minh Xiaomi Mi Power Strips (Trắng) ',166000,'/hinhsanpham/o-cam-thong-minh-xiaomi.jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,11,5,0,2),(19,'Giá đỡ điện thoại cho tay cầm chơi Game Terios T-3 ( Đen)  ',99000,'/hinhsanpham/taycamchoigame.jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,11,5,0,2),(20,'Tivi LED Arirang 24inch HD - Model AR-2488F (Đen)',2439000,'/hinhsanpham/tiviled24inchesariang.jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,84,5,0,2),(21,'Tivi LED LG 42inch 42LF550T Full HD (Đen)  ',6939000,'/hinhsanpham/tiviled42inches.jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,85,5,0,2),(22,'Smart Tivi LED LG 55inch Full HD - Model 55LH575T (Đen)',17000000,'/hinhsanpham/tiviled55inches.jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,87,5,0,2),(23,'Load Bluetooth SUNTEK S204 (Đen) ',269000,'/hinhsanpham/sony-electronics-hd-radio.jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,92,5,0,2),(24,'Tai nghe chụp tai Ovann X1 Gaming (Đen phối Xanh) ',60000,'/hinhsanpham/tai-nghe-chup-tai-ovann-x1-gaming-den-phoi-xanh_5235588062018469161_300.jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,91,5,0,2),(25,'Dàn âm thanh Samsung HT-E350K 5.1 330W (Đen) ',1760000,'/hinhsanpham/vish-dvd-ht-e350k-2.jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,93,5,0,2),(26,'Máy nghe nhạc MP3 NVPro Minion (Xanh dương) ',40000,'/hinhsanpham/may-nghe-nhac-mp3-nvpro-minion-xanh-duong-8610-6315961-e77b808c5237d08a940e6fe597050469-catalog_233.jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,94,5,0,2),(27,'Máy chiếu mini cho điện thoại (Nâu)  ',169999,'/hinhsanpham/may-chieu-mini-cho-dien-thoai-nau-9973-9001242-168928dd2df3fa0fae4f2c453b3e8620-catalog_233.jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,96,5,0,2),(28,'Thiết bị Android TV box MXQ S805 (Đen) ',429300,'/hinhsanpham/20160530150209551.jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,97,5,0,2),(29,'Tay cầm chơi game Xbox One Controller và Wireless Adapter for PC (Đen)',1549000,'/hinhsanpham/36743763_palaciodehierro_wirelesscontrollerc35mmone_xbox_vista_1.jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,99,5,0,2),(30,'Máy chơi games Nintendo Wii +HDD 500 GB (Full Games) (Đen) ',5999000,'/hinhsanpham/23. WII CONSOLE BLACK W WII REMOTE PLUS _ NUNCHUCK (UPC 045496880675).jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,100,5,0,2),(31,'Đồng hồ thông minh Smart Watch Uwatch DZ09 (Bạc) ',302676000,'/hinhsanpham/res_50df6f16088731d12e6c6698c47231e4_1200x1200c_mttq.jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,102,5,0,2),(32,'Vòng đeo tay Xiaomi Miband 2 (Đen)  ',819000,'/hinhsanpham/sh-02-a.jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,103,5,0,2),(33,'Bút ghi âm chuyên nghiệp 8 GB (Đen) ',612000,'/hinhsanpham/130814225508442671.jpg','','Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.',10,104,5,0,2);
/*!40000 ALTER TABLE `sanpham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sanphamyeuthich`
--

DROP TABLE IF EXISTS `sanphamyeuthich`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sanphamyeuthich` (
  `masp` int NOT NULL,
  `manv` int NOT NULL,
  PRIMARY KEY (`masp`,`manv`),
  KEY `FK_NvYeuThich` (`manv`),
  CONSTRAINT `FK_NvYeuThich` FOREIGN KEY (`manv`) REFERENCES `nhanvien` (`manv`),
  CONSTRAINT `FK_SPYeuThich` FOREIGN KEY (`masp`) REFERENCES `sanpham` (`masp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sanphamyeuthich`
--

LOCK TABLES `sanphamyeuthich` WRITE;
/*!40000 ALTER TABLE `sanphamyeuthich` DISABLE KEYS */;
/*!40000 ALTER TABLE `sanphamyeuthich` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thuonghieu`
--

DROP TABLE IF EXISTS `thuonghieu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thuonghieu` (
  `math` int NOT NULL AUTO_INCREMENT,
  `tenth` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `luotmua` int DEFAULT '0',
  PRIMARY KEY (`math`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thuonghieu`
--

LOCK TABLES `thuonghieu` WRITE;
/*!40000 ALTER TABLE `thuonghieu` DISABLE KEYS */;
INSERT INTO `thuonghieu` VALUES (1,'Apple',0),(2,'Nokia',0),(3,'Samsung',0),(4,'Xiaomi',0),(5,'Asus',0),(6,'Lenovo',0),(7,'Oppo',0),(8,'Sony',0),(9,'HTC',0),(10,'Dell',0),(11,'HP',0),(12,'Scandisk',0),(13,'Silicon',0),(14,'Canon',0),(15,'Microsoft',0);
/*!40000 ALTER TABLE `thuonghieu` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-05  0:36:27
