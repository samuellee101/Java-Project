CREATE DATABASE  IF NOT EXISTS `materials` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `materials`;
-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: materials
-- ------------------------------------------------------
-- Server version	5.7.35-log

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
-- Table structure for table `largecomponents`
--

DROP TABLE IF EXISTS `largecomponents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `largecomponents` (
  `DefaultPart` varchar(60) NOT NULL,
  `Price` double DEFAULT NULL,
  PRIMARY KEY (`DefaultPart`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `largecomponents`
--

LOCK TABLES `largecomponents` WRITE;
/*!40000 ALTER TABLE `largecomponents` DISABLE KEYS */;
INSERT INTO `largecomponents` VALUES ('Boosters',582.3),('Contrusction',443.9),('External Tank',636.1),('F-1 Engine',15000000),('Falcon 9 Block 5',62000000),('Launch & Landing',1079.1),('Main Engines',1389.9),('Merlin Engine',57000),('Orbiter',6250.7),('Raptor Engine',1000000),('RD-180',25000000),('Technology Development',149.5),('Thaicom 6',160000000);
/*!40000 ALTER TABLE `largecomponents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rawmaterials`
--

DROP TABLE IF EXISTS `rawmaterials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rawmaterials` (
  `id` varchar(45) DEFAULT NULL,
  `Material` varchar(45) NOT NULL,
  `unitpricelb` double DEFAULT NULL,
  `inventory` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Material`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rawmaterials`
--

LOCK TABLES `rawmaterials` WRITE;
/*!40000 ALTER TABLE `rawmaterials` DISABLE KEYS */;
INSERT INTO `rawmaterials` VALUES ('f134','201 SS',0.33,'1000'),('321f','301 SS',0.56,'1000'),('h54w','304 SS Solid',0.81,'1000'),('bhw4','304 SS Turning',0.7,'1000'),('jk56','309 SS ',1.05,'1000'),('3w2h','310 SS',1.59,'1000'),('m6m5','316 SS Solid',1.05,'1000'),('5b2f','330 SS',2.59,'1000'),('l96t','Aluminum',1.1,'1000'),('o64r','Aluminum Alloy',1.01,'1000'),('q23t','Brass',3.21,'1000'),('n45r','Copper',4.18,'1000'),('d4te','Fiberglass & polyester',2.5,'1000'),('r423','Lead',1.05,'1000'),('y56f','Palladium',61.17,'1000'),('j74d','Platinum',25.27,'1000'),('ui74','Rubber',1.73,'1000'),('q3ed','Sheet Metal',0.07,'1000'),('f32d','Silicone',25,'1000'),('as34','Silver',0.67,'1000'),('c3sa','Steel Rebar',0.33,'1000'),('g3ad','Steel Scrap',0.22,'1000'),('k74g','Structural Steel',0.09,'1000'),('k7rf','Tin',15.77,'1000'),('g3ds','Zinc',1.33,'1000');
/*!40000 ALTER TABLE `rawmaterials` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-28 23:12:48
