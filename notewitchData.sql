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
INSERT INTO `group_table` VALUES ('1e882401-38ea-4a23-9595-3a929d16f045','system',NULL,'system',NULL,'WILLS'),('1e882401-38ea-4a23-9595-3a929d16f046','system',NULL,'system',NULL,'JACKS'),('1e882401-38ea-4a23-9595-3a929d16f047','Eric',NULL,'Eric',NULL,'STL'),('1e882401-38ea-4a23-9595-3a929d16f048','Yaw',NULL,'Yaw',NULL,'MovenPick');
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
INSERT INTO `project` VALUES ('1e882401-38ea-4a23-9595-3a929d16f021','eric','2016-09-23 00:00:00','eric','2016-09-13 00:00:00','Switch',NULL,'1e882401-38ea-4a23-9595-3a929d16f031'),('1e882401-38ea-4a23-9595-3a929d16f022','Yaw','2016-04-24 00:00:00','Yaw','2006-09-23 00:00:00','Leixs','1e882401-38ea-4a23-9595-3a929d16f045',NULL),('1e882401-38ea-4a23-9595-3a929d16f023','Eric','2006-09-23 00:00:00','Eric','2006-09-23 00:00:00','The-noteWiTCH','1e882401-38ea-4a23-9595-3a929d16f047',NULL),('1e882401-38ea-4a23-9595-3a929d16f024','Kwamena','2006-09-23 00:00:00','Kwamena','2006-09-23 00:00:00','Loveworld','1e882401-38ea-4a23-9595-3a929d16f047',NULL),('1e882401-38ea-4a23-9595-3a929d16f025','Doris','2006-09-23 00:00:00','Doris','2006-09-23 00:00:00','Projekta','1e882401-38ea-4a23-9595-3a929d16f047',NULL),('1e882401-38ea-4a23-9595-3a929d16f026','Luigi','2006-09-23 00:00:00','Luigi','2006-09-23 00:00:00','Malta','1e882401-38ea-4a23-9595-3a929d16f047',NULL),('1e882401-38ea-4a23-9595-3a929d16f027','Prince','2006-09-23 00:00:00','Prince','2006-09-23 00:00:00','ICGC Alumni','1e882401-38ea-4a23-9595-3a929d16f047',NULL),('1e882401-38ea-4a23-9595-3a929d16f028','Phil','2006-09-23 00:00:00','Phil','2006-09-23 00:00:00','Phishing','1e882401-38ea-4a23-9595-3a929d16f045',NULL),('1e882401-38ea-4a23-9595-3a929d16f029','Adam','2006-09-23 00:00:00','Adam','2006-09-23 00:00:00','Sodom','1e882401-38ea-4a23-9595-3a929d16f047',NULL),('1e882401-38ea-4a23-9595-3a929d16f030','Nayo','2006-09-23 00:00:00','Nayo','2006-09-23 00:00:00','Nestle prod','1e882401-38ea-4a23-9595-3a929d16f047',NULL);
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
INSERT INTO `user_group_bridge` VALUES ('1e882401-38ea-4a23-9595-3a929d16f01','1e882401-38ea-4a23-9595-3a929d16f045',1,'1e882401-38ea-4a23-9595-3a929d16f031'),('1e882401-38ea-4a23-9595-3a929d16f02','1e882401-38ea-4a23-9595-3a929d16f046',1,'1e882401-38ea-4a23-9595-3a929d16f031'),('1e882401-38ea-4a23-9595-3a929d16f03','1e882401-38ea-4a23-9595-3a929d16f047',1,'1e882401-38ea-4a23-9595-3a929d16f031'),('1e882401-38ea-4a23-9595-3a929d16f04','1e882401-38ea-4a23-9595-3a929d16f048',1,'1e882401-38ea-4a23-9595-3a929d16f031');
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

-- Dump completed on 2018-05-01 23:02:52
