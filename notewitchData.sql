CREATE DATABASE  IF NOT EXISTS `notewitch` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `notewitch`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: notewitch
-- ------------------------------------------------------
-- Server version	5.7.10-log

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
-- Table structure for table `group_table`
--

DROP TABLE IF EXISTS `group_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group_table` (
  `group_id` varchar(255) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) NOT NULL,
  `modified_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_table`
--

LOCK TABLES `group_table` WRITE;
/*!40000 ALTER TABLE `group_table` DISABLE KEYS */;
INSERT INTO `group_table` VALUES ('1581c7b7-86f5-406c-a0a8-40d2b8956143','ardeneric','2018-05-03 16:15:01','ardeneric','2018-05-03 16:15:01','NAra'),('179cd2dd-ebee-4296-8124-a08ee526d826','ardeneric','2018-05-03 11:49:01','ardeneric','2018-05-03 11:49:01','Blue Town'),('1da5ff41-f245-47e3-ae1e-49c152dd6f3a','ardenyaw','2018-05-03 17:32:39','ardenyaw','2018-05-03 17:32:39','Legion'),('1e882401-38ea-4a23-9595-3a929d16f045','system','2018-05-03 17:32:39','system','2018-05-03 17:32:39','WILLS'),('1e882401-38ea-4a23-9595-3a929d16f046','system','2018-05-03 17:32:39','system','2018-05-03 17:32:39','JACKS'),('1e882401-38ea-4a23-9595-3a929d16f047','Eric','2018-05-03 17:32:39','Eric','2018-05-03 17:32:39','STL'),('1e882401-38ea-4a23-9595-3a929d16f048','Yaw','2018-05-03 17:32:39','Yaw','2018-05-03 17:32:39','MovenPick'),('45787ca8-7b06-4bf8-a8fb-a3b8979a5a99','ardeneric','2018-05-03 14:36:08','ardeneric','2018-05-03 14:36:08','blue Skies'),('72ea05e5-3439-499f-925d-b622201cc672','ardenyaw','2018-05-03 17:31:23','ardenyaw','2018-05-03 17:31:23','Quantico'),('e3a59558-eac4-4f13-bc01-274d576442a9','ardenyaw','2018-05-03 17:31:40','ardenyaw','2018-05-03 17:31:40','Flash'),('fd507930-6ee9-4ab3-9ec2-8ab168f18964','ardeneric','2018-05-03 13:53:58','ardeneric','2018-05-03 13:53:58','Ghana Airways');
/*!40000 ALTER TABLE `group_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `multimedia`
--

DROP TABLE IF EXISTS `multimedia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `multimedia` (
  `id` varchar(255) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `image` longblob,
  `location` varchar(255) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `project_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjvjsa08lup1wws7xawynww3ed` (`project_id`),
  CONSTRAINT `FKjvjsa08lup1wws7xawynww3ed` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `multimedia`
--

LOCK TABLES `multimedia` WRITE;
/*!40000 ALTER TABLE `multimedia` DISABLE KEYS */;
/*!40000 ALTER TABLE `multimedia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `project_id` varchar(255) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) NOT NULL,
  `modified_date` datetime DEFAULT NULL,
  `project_name` varchar(255) NOT NULL,
  `group_id` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`project_id`),
  KEY `FK81mo7ncennc5djauh2vpleq4i` (`group_id`),
  KEY `FKo06v2e9kuapcugnyhttqa1vpt` (`user_id`),
  CONSTRAINT `FK81mo7ncennc5djauh2vpleq4i` FOREIGN KEY (`group_id`) REFERENCES `group_table` (`group_id`),
  CONSTRAINT `FKo06v2e9kuapcugnyhttqa1vpt` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES ('1e882401-38ea-4a23-9595-3a929d16f021','eric','2016-09-23 00:00:00','eric','2016-09-13 00:00:00','Switch',NULL,'1e882401-38ea-4a23-9595-3a929d16f031'),('1e882401-38ea-4a23-9595-3a929d16f022','Yaw','2016-04-24 00:00:00','Yaw','2006-09-23 00:00:00','Leixs','1e882401-38ea-4a23-9595-3a929d16f045',NULL),('1e882401-38ea-4a23-9595-3a929d16f023','Eric','2006-09-23 00:00:00','Eric','2006-09-23 00:00:00','The-noteWiTCH','1e882401-38ea-4a23-9595-3a929d16f047',NULL),('1e882401-38ea-4a23-9595-3a929d16f024','Kwamena','2006-09-23 00:00:00','Kwamena','2006-09-23 00:00:00','Loveworld','1e882401-38ea-4a23-9595-3a929d16f047',NULL),('1e882401-38ea-4a23-9595-3a929d16f025','Doris','2006-09-23 00:00:00','Doris','2006-09-23 00:00:00','Projekta','1e882401-38ea-4a23-9595-3a929d16f047',NULL),('1e882401-38ea-4a23-9595-3a929d16f026','Luigi','2006-09-23 00:00:00','Luigi','2006-09-23 00:00:00','Malta','1e882401-38ea-4a23-9595-3a929d16f047',NULL),('1e882401-38ea-4a23-9595-3a929d16f027','Prince','2006-09-23 00:00:00','Prince','2006-09-23 00:00:00','ICGC Alumni','1e882401-38ea-4a23-9595-3a929d16f047',NULL),('1e882401-38ea-4a23-9595-3a929d16f028','Phil','2006-09-23 00:00:00','Phil','2006-09-23 00:00:00','Phishing','1e882401-38ea-4a23-9595-3a929d16f045',NULL),('1e882401-38ea-4a23-9595-3a929d16f029','Adam','2006-09-23 00:00:00','Adam','2006-09-23 00:00:00','Sodom','1e882401-38ea-4a23-9595-3a929d16f047',NULL),('1e882401-38ea-4a23-9595-3a929d16f030','Nayo','2006-09-23 00:00:00','Nayo','2006-09-23 00:00:00','Nestle prod','1e882401-38ea-4a23-9595-3a929d16f047',NULL),('3820b4ef-58f3-4c32-82be-685502654e5f','ardeneric','2018-05-03 14:37:27','ardeneric','2018-05-03 14:37:27','Shatta Wale',NULL,'1e882401-38ea-4a23-9595-3a929d16f031'),('5e42b3cd-60b9-4e4e-983f-aaf9494e3b5c','ardeneric','2018-05-03 16:22:32','ardeneric','2018-05-03 16:22:32','live','1581c7b7-86f5-406c-a0a8-40d2b8956143',NULL),('63b33179-3819-4d7c-b56f-ab9cf606f44a','ardeneric','2018-05-03 15:04:29','ardeneric','2018-05-03 15:04:29','Flight Automation Project','fd507930-6ee9-4ab3-9ec2-8ab168f18964',NULL),('6d3302f8-4ca3-44e7-a26c-09654e12c420','ardeneric','2018-05-03 16:41:37','ardeneric','2018-05-03 16:41:37','the Delis','1e882401-38ea-4a23-9595-3a929d16f048',NULL),('70ed5d2c-527d-4aa5-a2ab-98b1260fe6b4','ardeneric','2018-05-09 11:41:08','ardeneric','2018-05-09 11:41:08','Surgical Project',NULL,'1e882401-38ea-4a23-9595-3a929d16f031'),('76c5960e-5e10-4943-ad1d-de2af5f8078c','ardeneric','2018-05-03 16:43:47','ardeneric','2018-05-03 16:43:47','cafe','45787ca8-7b06-4bf8-a8fb-a3b8979a5a99',NULL),('c05907b5-2c62-494d-81b5-db1aa4b4620e','','2018-05-03 16:57:34','','2018-05-03 16:57:34','WAR','1e882401-38ea-4a23-9595-3a929d16f047',NULL),('c6a1ca17-c0a5-4724-a93a-8f5fb82f14fa','ardenyaw','2018-05-03 17:32:28','ardenyaw','2018-05-03 17:32:28','University of Ghana',NULL,'1e882401-38ea-4a23-9595-3a929d16f032'),('dc364242-7b0b-43f8-a3ae-73afae01d2f4','ardeneric','2018-05-03 17:00:16','ardeneric','2018-05-03 17:00:16','HObbits',NULL,'1e882401-38ea-4a23-9595-3a929d16f031'),('df21d823-8ef0-4126-a8ad-169a624d613e','','2018-05-03 16:55:02','','2018-05-03 16:55:02','SKY','45787ca8-7b06-4bf8-a8fb-a3b8979a5a99',NULL),('eb3bc0ad-6f3e-4b67-8489-420da9916c51','','2018-05-09 11:38:37','','2018-05-09 11:38:37','Laevan','45787ca8-7b06-4bf8-a8fb-a3b8979a5a99',NULL),('ec03d142-27b2-4f47-b6ae-98f34ac05498','ardeneric','2018-05-03 10:48:35','ardeneric','2018-05-03 10:48:35','Gringo',NULL,'1e882401-38ea-4a23-9595-3a929d16f031'),('fa6c39a6-9308-40a0-a3eb-73dbb3e0a1fb','','2018-05-03 17:32:01','','2018-05-03 17:32:01','FanMilk','72ea05e5-3439-499f-925d-b622201cc672',NULL);
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ADMIN'),(2,'USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `other_names` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('1e882401-38ea-4a23-9595-3a929d16f031','VHC/19','ardeneric77@gmail.com','Eric','Arden','Junior','thethe77','ardeneric'),('1e882401-38ea-4a23-9595-3a929d16f032','accra','ardeneric8@gmail.com','Yaw','Arden',NULL,'thethe','ardenyaw');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_group_bridge`
--

DROP TABLE IF EXISTS `user_group_bridge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_group_bridge` (
  `id` varchar(255) NOT NULL,
  `group_id` varchar(255) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgyr5057hm4j8r33nhq10k2wo0` (`group_id`),
  KEY `FKl0gv5porrcuo0xoou0u0k1ef6` (`role_id`),
  KEY `FKiqnoc4o2ijdyibfkdwuejavmn` (`user_id`),
  CONSTRAINT `FKgyr5057hm4j8r33nhq10k2wo0` FOREIGN KEY (`group_id`) REFERENCES `group_table` (`group_id`),
  CONSTRAINT `FKiqnoc4o2ijdyibfkdwuejavmn` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKl0gv5porrcuo0xoou0u0k1ef6` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_group_bridge`
--

LOCK TABLES `user_group_bridge` WRITE;
/*!40000 ALTER TABLE `user_group_bridge` DISABLE KEYS */;
INSERT INTO `user_group_bridge` VALUES ('1e882401-38ea-4a23-9595-3a929d16f01','1e882401-38ea-4a23-9595-3a929d16f045',1,'1e882401-38ea-4a23-9595-3a929d16f031'),('1e882401-38ea-4a23-9595-3a929d16f02','1e882401-38ea-4a23-9595-3a929d16f046',1,'1e882401-38ea-4a23-9595-3a929d16f031'),('1e882401-38ea-4a23-9595-3a929d16f03','1e882401-38ea-4a23-9595-3a929d16f047',1,'1e882401-38ea-4a23-9595-3a929d16f031'),('1e882401-38ea-4a23-9595-3a929d16f04','1e882401-38ea-4a23-9595-3a929d16f048',1,'1e882401-38ea-4a23-9595-3a929d16f031'),('352cf29f-316e-4437-8075-819399c4a9ba','45787ca8-7b06-4bf8-a8fb-a3b8979a5a99',1,'1e882401-38ea-4a23-9595-3a929d16f031'),('6d3f3b66-4ca3-4ef8-9143-bfe7b26ba650','fd507930-6ee9-4ab3-9ec2-8ab168f18964',1,'1e882401-38ea-4a23-9595-3a929d16f031'),('7e867fd8-7ce7-43e9-b2d8-3f4885ada3ef','e3a59558-eac4-4f13-bc01-274d576442a9',1,'1e882401-38ea-4a23-9595-3a929d16f032'),('a2298fc9-6c74-4d54-9685-fe1a1c25a01a','1581c7b7-86f5-406c-a0a8-40d2b8956143',1,'1e882401-38ea-4a23-9595-3a929d16f031'),('cb0b55ad-1339-4ed6-bf30-5af7bb404e60','1da5ff41-f245-47e3-ae1e-49c152dd6f3a',1,'1e882401-38ea-4a23-9595-3a929d16f032'),('fc0b2c20-6d44-4edd-a6a0-1d1bc76a9f94','72ea05e5-3439-499f-925d-b622201cc672',1,'1e882401-38ea-4a23-9595-3a929d16f032');
/*!40000 ALTER TABLE `user_group_bridge` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-09 12:11:10
