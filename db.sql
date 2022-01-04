-- MySQL dump 10.13  Distrib 5.7.35, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: db_RC
-- ------------------------------------------------------
-- Server version	5.7.35-0ubuntu0.18.04.1

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
-- Table structure for table `t_admin`
--

CREATE DATABASE db_rc;
USE db_rc;

CREATE TABLE `t_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `realName` varchar(20) DEFAULT NULL,
  `idc` varchar(18) DEFAULT NULL,
  `tel` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_admin`
--

LOCK TABLES `t_admin` WRITE;
/*!40000 ALTER TABLE `t_admin` DISABLE KEYS */;
INSERT INTO `t_admin` VALUES (1,'0','0','admin','398866529958820832','13809088888'),(2,'Tekola','azhe1...4','TKLA','182423323838842690','15928450000'),(3,'sunyu','3738','孙瑜','512901194405120025','13521371453'),(4,'zhaoqiang','123','赵强','183465665758061409','17877006758'),(5,'longaotian','%,8R#(dHX0','龙傲天','440708467465547407','15893180124'),(6,'lishaohua','9513901215','李少华','493414226897949816','18269219229'),(7,'lizonghe','lklsY9:SDC','李棕鹤','156202935635906931','17274175896'),(8,'likai','3244137158','李开','419190706003146421','17595049450'),(9,'lijiale','5927$1626','李家乐','299656076360974801','17063247024'),(10,'lizhangzhi','Qwerty**..1','李张志','422186777208330434','13634145698');
/*!40000 ALTER TABLE `t_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_car`
--

DROP TABLE IF EXISTS `t_car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(30) DEFAULT NULL,
  `license` varchar(10) DEFAULT NULL,
  `brand` varchar(20) DEFAULT NULL,
  `size` varchar(20) DEFAULT NULL,
  `seatNum` int(11) DEFAULT NULL,
  `isAuto` int(11) DEFAULT '1',
  `tons` varchar(20) DEFAULT NULL,
  `color` varchar(20) DEFAULT NULL,
  `cost` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_car`
--

LOCK TABLES `t_car` WRITE;
/*!40000 ALTER TABLE `t_car` DISABLE KEYS */;
INSERT INTO `t_car` VALUES (3,'经济型','川A87E3A','大众','途观L2015',5,1,'2.0T','白色',300,1),(4,'舒适型','川A6DD15','丰田','凯美瑞2018',5,1,'1.8T','黑色',300,1),(5,'SUV','川AAN116','宝马','X6',5,1,'3.0T','红色',500,1),(6,'商务型','川AC0967','别克','GLB',5,1,'2.0T','白色',700,-1),(8,'电动型','川AAN116','特斯拉','MODEL3',5,1,'2.0T','黑色',400,0),(9,'高端车','川AC0967','保时捷','卡宴',5,1,'3.0T','红色',800,1),(10,'SUV','冀N45AJ7','Bench','xxx',5,1,'5.0T','灰色',200,1),(11,'舒适型','晋T45A53','BMW','yy',5,0,'5.0T','蓝色',400,1),(12,'电动型','沪Q478AQ','Ferrari','b',5,1,'5.0T','白色',700,0),(13,'高端车','新A45W45','Spyker','a',5,0,'5.0T','白色',1000,1);
/*!40000 ALTER TABLE `t_car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_maintain`
--

DROP TABLE IF EXISTS `t_maintain`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_maintain` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `carID` int(11) DEFAULT NULL,
  `adminID` int(11) DEFAULT NULL,
  `errorDesc` varchar(50) DEFAULT NULL,
  `stDate` varchar(20) DEFAULT NULL,
  `edDate` varchar(20) DEFAULT NULL,
  `cost` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY ` t_maintain_t_admin_id_fk` (`adminID`),
  KEY ` t_maintain_t_car_id_fk` (`carID`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_maintain`
--

LOCK TABLES `t_maintain` WRITE;
/*!40000 ALTER TABLE `t_maintain` DISABLE KEYS */;
INSERT INTO `t_maintain` VALUES (65,11,1,'发动机故障','21/09/05','21/09/05',1000),(66,10,1,'充电故障','21/09/05','21/09/05',200),(67,5,8,'变速箱钝挫','21/09/05','21/09/05',220),(68,10,8,'变速箱钝挫','21/09/05','21/09/05',100),(69,13,8,'变速箱钝挫','21/09/05','21/09/05',100),(70,13,8,'变速箱钝挫','21/09/05','21/09/05',100),(71,6,4,'磨损','21/09/05','21/09/05',500),(72,9,4,'磨损','21/09/05','21/09/05',100),(73,3,4,'磨损','21/09/05','21/09/05',500),(74,6,4,NULL,'21/09/05',NULL,0);
/*!40000 ALTER TABLE `t_maintain` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_rented`
--

DROP TABLE IF EXISTS `t_rented`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_rented` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `carID` int(11) DEFAULT NULL,
  `usrID` int(11) DEFAULT NULL,
  `stDate` varchar(20) DEFAULT NULL,
  `edDate` varchar(20) DEFAULT NULL,
  `dates` int(11) DEFAULT NULL,
  `cost` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `t_rented_t_car_id_fk` (`carID`),
  KEY `t_rented_t_user_id_fk` (`usrID`),
  CONSTRAINT `t_rented_t_car_id_fk` FOREIGN KEY (`carID`) REFERENCES `t_car` (`id`),
  CONSTRAINT `t_rented_t_user_id_fk` FOREIGN KEY (`usrID`) REFERENCES `t_usr` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_rented`
--

LOCK TABLES `t_rented` WRITE;
/*!40000 ALTER TABLE `t_rented` DISABLE KEYS */;
INSERT INTO `t_rented` VALUES (15,6,1,'21/09/05','21/09/05',0,0),(16,11,1,'21/09/05','21/09/05',0,0),(17,3,1,'21/09/05',NULL,0,0),(18,11,10,'21/09/05','21/09/05',0,0),(19,9,10,'21/09/05','21/09/05',0,0),(20,9,10,'21/09/05','21/09/05',0,0),(21,5,18,'21/09/05',NULL,0,0),(22,8,13,'21/09/05',NULL,0,0),(23,11,16,'21/09/05','21/09/05',0,0),(24,12,16,'21/09/05','21/09/05',0,0),(25,12,16,'21/09/05',NULL,0,0);
/*!40000 ALTER TABLE `t_rented` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_usr`
--

DROP TABLE IF EXISTS `t_usr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_usr` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `realName` varchar(20) DEFAULT NULL,
  `idc` varchar(18) DEFAULT NULL,
  `tel` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_usr`
--

LOCK TABLES `t_usr` WRITE;
/*!40000 ALTER TABLE `t_usr` DISABLE KEYS */;
INSERT INTO `t_usr` VALUES (1,'0','0','tt','362881319759759442','10000000001'),(10,'zsh','>Vy2','ZSH','445322112648084966','11000195061'),(11,'rc','D1Ei&R+_M','陈王','403713631597134126','14411595855'),(12,'op','YP>L&&','李素','276613328515851578','14196403677'),(13,'123','dD?','梅里','252592593724689847','19297895656'),(14,'lucy','TWgI','鲁西','292016089025626253','11409290972'),(15,'zhanghe','Nim6t','张和','474327912974768353','19115986128'),(16,'sg','ataY','孙戈','558993862258789960','19562972882'),(17,'wzzNic','O1^Gyp7R','王之张','126065818148467617','11608027234'),(18,'lxk','U@RPmtp0','李歆奎','210809706648879356','11409290972');
/*!40000 ALTER TABLE `t_usr` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-05 23:17:40
