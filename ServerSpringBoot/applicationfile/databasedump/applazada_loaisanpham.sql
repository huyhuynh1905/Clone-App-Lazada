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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-05  0:37:24
