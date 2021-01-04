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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-05  0:37:22
