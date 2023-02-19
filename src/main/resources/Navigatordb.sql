-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: navigatordb
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `car` (
  `idCar` int NOT NULL,
  `averageSpeed` double NOT NULL,
  `make` varchar(45) DEFAULT NULL,
  `model` varchar(45) DEFAULT NULL,
  `productionYear` int DEFAULT NULL,
  `bodyType` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCar`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car`
--

LOCK TABLES `car` WRITE;
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` VALUES (1,60,'BMW','X5',2009,'SUV');
/*!40000 ALTER TABLE `car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `idCity` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`idCity`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Batumi'),(2,'Tbilisi'),(3,'Kutaisi');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `directions`
--

DROP TABLE IF EXISTS `directions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `directions` (
  `idDirections` int NOT NULL AUTO_INCREMENT,
  `idStreetLocation1` int NOT NULL,
  `idStreetLocation2` int NOT NULL,
  `trafficLight` tinyint NOT NULL,
  PRIMARY KEY (`idDirections`,`idStreetLocation1`,`idStreetLocation2`),
  KEY `fk_StreetLocation_has_StreetLocation_StreetLocation2_idx` (`idStreetLocation2`),
  KEY `fk_StreetLocation_has_StreetLocation_StreetLocation1_idx` (`idStreetLocation1`),
  CONSTRAINT `fk_StreetLocation_has_StreetLocation_StreetLocation1` FOREIGN KEY (`idStreetLocation1`) REFERENCES `streetlocation` (`idStreetLocation`) ON UPDATE CASCADE,
  CONSTRAINT `fk_StreetLocation_has_StreetLocation_StreetLocation2` FOREIGN KEY (`idStreetLocation2`) REFERENCES `streetlocation` (`idStreetLocation`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `directions`
--

LOCK TABLES `directions` WRITE;
/*!40000 ALTER TABLE `directions` DISABLE KEYS */;
INSERT INTO `directions` VALUES (1,1,1,0),(2,1,2,0),(3,1,3,0),(4,1,4,0),(5,2,2,0),(6,2,1,0),(8,2,5,0),(9,3,3,0),(10,3,1,0),(11,3,4,0),(12,3,5,0),(13,4,4,0),(14,4,1,0),(15,4,3,0),(16,4,6,0),(17,5,5,0),(18,5,2,0),(19,5,3,0),(20,5,6,0),(21,6,6,0),(22,6,5,0),(23,6,4,0);
/*!40000 ALTER TABLE `directions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publictransport`
--

DROP TABLE IF EXISTS `publictransport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `publictransport` (
  `idPublicTransport` int NOT NULL AUTO_INCREMENT,
  `publicTransportNumber` int NOT NULL,
  `averageSpeed` double NOT NULL,
  PRIMARY KEY (`idPublicTransport`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publictransport`
--

LOCK TABLES `publictransport` WRITE;
/*!40000 ALTER TABLE `publictransport` DISABLE KEYS */;
INSERT INTO `publictransport` VALUES (1,1,40),(2,4,40),(3,5,40),(4,7,40),(5,8,40),(6,11,40),(7,13,40),(8,17,40),(9,18,40),(10,20,40);
/*!40000 ALTER TABLE `publictransport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publictransportdirections`
--

DROP TABLE IF EXISTS `publictransportdirections`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `publictransportdirections` (
  `idPublicTransportDirections` int NOT NULL AUTO_INCREMENT,
  `idPublicTransport` int NOT NULL,
  `idStreetLocation` int NOT NULL,
  PRIMARY KEY (`idPublicTransportDirections`,`idPublicTransport`,`idStreetLocation`),
  KEY `fk_PublicTransport_has_StreetLocation_StreetLocation1_idx` (`idStreetLocation`),
  KEY `fk_PublicTransport_has_StreetLocation_PublicTransport1_idx` (`idPublicTransport`),
  CONSTRAINT `fk_PublicTransport_has_StreetLocation_PublicTransport1` FOREIGN KEY (`idPublicTransport`) REFERENCES `publictransport` (`idPublicTransport`) ON UPDATE CASCADE,
  CONSTRAINT `fk_PublicTransport_has_StreetLocation_StreetLocation1` FOREIGN KEY (`idStreetLocation`) REFERENCES `streetlocation` (`idStreetLocation`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publictransportdirections`
--

LOCK TABLES `publictransportdirections` WRITE;
/*!40000 ALTER TABLE `publictransportdirections` DISABLE KEYS */;
INSERT INTO `publictransportdirections` VALUES (1,1,1),(2,2,5),(3,3,7),(4,4,10),(5,5,13),(6,6,17);
/*!40000 ALTER TABLE `publictransportdirections` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `street`
--

DROP TABLE IF EXISTS `street`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `street` (
  `idStreet` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `idCity` int DEFAULT NULL,
  PRIMARY KEY (`idStreet`),
  KEY `fk_Street_City_idx` (`idCity`),
  CONSTRAINT `fk_Street_City` FOREIGN KEY (`idCity`) REFERENCES `city` (`idCity`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `street`
--

LOCK TABLES `street` WRITE;
/*!40000 ALTER TABLE `street` DISABLE KEYS */;
INSERT INTO `street` VALUES (1,'Ilia Chavchavadze Street',1),(2,'Ninoshvili Street',1),(3,'Rustaveli Street',1),(4,'Bagrationi Street',1),(5,'Leonidze Street',1),(6,'Pushkin Street',1),(7,'Vakhtang Gorgasali Street',1),(8,'David Agmashenebeli Avenue',2),(9,'Pekini Street',2),(10,'Alexander Kazbegi Avenue',2),(11,'Erekle Tatishvili Street',2),(12,'Ilia Chavchavadze Street',2),(13,'Tsotne Dadiani Street',2),(14,'Ksani Street',2),(15,'Bagrati Street',3),(16,'Grishashvili Street',3),(17,'Gogebashvili Street',3),(18,'David Agmashenebeli Street',3),(19,'Nikea Street',3),(20,'Sulkhan Saba Avenue',3);
/*!40000 ALTER TABLE `street` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `streetlocation`
--

DROP TABLE IF EXISTS `streetlocation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `streetlocation` (
  `idStreetLocation` int NOT NULL AUTO_INCREMENT,
  `streetNumber` int NOT NULL,
  `xCoordinate` double NOT NULL,
  `yCoordinate` double NOT NULL,
  `idStreet` int DEFAULT NULL,
  PRIMARY KEY (`idStreetLocation`),
  KEY `fk_StreetLocation_Street1_idx` (`idStreet`),
  CONSTRAINT `fk_StreetLocation_Street1` FOREIGN KEY (`idStreet`) REFERENCES `street` (`idStreet`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `streetlocation`
--

LOCK TABLES `streetlocation` WRITE;
/*!40000 ALTER TABLE `streetlocation` DISABLE KEYS */;
INSERT INTO `streetlocation` VALUES (1,7,41.64719,41.64357,1),(2,15,41.64682,41.6424,1),(3,49,41.64431,41.63499,1),(4,131,41.64142,41.62584,1),(5,5,41.65045,41.62727,2),(6,2,41.65358,41.63612,2),(7,1,41.65289,41.63817,3),(8,57,41.64618,41.61992,3),(9,61,41.64512,41.6201,3),(10,79,41.63738,41.64323,4),(11,125,41.63384,41.62534,4),(12,12,41.62115,41.62425,5),(13,1,41.64288,41.64797,6),(14,19,41.64322,41.64614,6),(15,23,41.64389,41.64404,6),(16,109,41.64228,41.63527,6),(17,4,41.64999,41.64262,7);
/*!40000 ALTER TABLE `streetlocation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-16 15:05:59
