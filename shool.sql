-- MySQL dump 10.13  Distrib 5.6.24, for Win32 (x86)
--
-- Host: localhost    Database: school
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.19-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `idcourse` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `price` int(11) DEFAULT NULL,
  `idteacher` int(11) NOT NULL,
  `description` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idcourse`),
  KEY `idteacher_idx` (`idteacher`),
  CONSTRAINT `idteacher` FOREIGN KEY (`idteacher`) REFERENCES `teacher` (`idteacher`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'java',2000000,1,'Java là một ngôn ngữ lập trình hướng đối tượng (OOP) và dựa trên các lớp (class). Khác với phần lớn ngôn ngữ lập trình thông thường, thay vì biên dịch mã nguồn thành mã máy hoặc thông dịch mã nguồn khi chạy, Java được thiết kế để biên dịch mã nguồn thành bytecode, bytecode sau đó sẽ được môi trường thực thi (runtime environment) chạy.'),(2,'.Net',1500000,2,'.NET là một nền tảng phát triển mã nguồn mở miễn phí, đa nền tảng để xây dựng nhiều loại ứng dụng khác nhau.');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detail`
--

DROP TABLE IF EXISTS `detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detail` (
  `iddetail` int(11) NOT NULL AUTO_INCREMENT,
  `idstudent` int(11) NOT NULL,
  `idcourse` int(11) NOT NULL,
  PRIMARY KEY (`iddetail`),
  KEY `idstudent_idx` (`idstudent`),
  KEY `idcourse_idx` (`idcourse`),
  CONSTRAINT `idcourse` FOREIGN KEY (`idcourse`) REFERENCES `course` (`idcourse`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idstudent` FOREIGN KEY (`idstudent`) REFERENCES `student` (`idstudent`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detail`
--

LOCK TABLES `detail` WRITE;
/*!40000 ALTER TABLE `detail` DISABLE KEYS */;
INSERT INTO `detail` VALUES (1,1,1),(2,2,2),(3,1,2);
/*!40000 ALTER TABLE `detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `new`
--

DROP TABLE IF EXISTS `new`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `new` (
  `idnew` int(11) NOT NULL AUTO_INCREMENT,
  `titel` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `image` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idnew`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `new`
--

LOCK TABLES `new` WRITE;
/*!40000 ALTER TABLE `new` DISABLE KEYS */;
INSERT INTO `new` VALUES (1,'Tuyen dung',NULL,'Cong ty IFI Solution tuyen dung so luong lon lap trinh vien ve Java, .NET. C#... nhanh tay gui CV nao cac ban!!'),(2,'Tot nghiep',NULL,'Danh sach cac ban co thanh tich tot trong khoa hoc HDSE I2013');
/*!40000 ALTER TABLE `new` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `idstudent` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `gender` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `birth` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `address` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idstudent`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'Loc','Nam','06/05/1998','Hung Yen'),(2,'Tri','Nam','10/10/1994','Ha Noi'),(3,'Hue','Nu','13/06/1996','Ha Noi'),(4,'Hien','Nam','11/11/1991','Ha Nam');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `idteacher` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `age` int(11) DEFAULT NULL,
  `address` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `contact` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idteacher`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'Hoan',30,'Ha Noi','hoan.dinh@gmail.com'),(2,'david',29,'Anh','099996611');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-24 16:46:02
