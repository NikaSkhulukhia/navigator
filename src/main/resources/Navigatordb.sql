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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `directions`
--

LOCK TABLES `directions` WRITE;
/*!40000 ALTER TABLE `directions` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publictransport`
--

LOCK TABLES `publictransport` WRITE;
/*!40000 ALTER TABLE `publictransport` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publictransportdirections`
--

LOCK TABLES `publictransportdirections` WRITE;
/*!40000 ALTER TABLE `publictransportdirections` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `street`
--

LOCK TABLES `street` WRITE;
/*!40000 ALTER TABLE `street` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `streetlocation`
--

LOCK TABLES `streetlocation` WRITE;
/*!40000 ALTER TABLE `streetlocation` DISABLE KEYS */;
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

-- Dump completed on 2023-02-15 12:42:46
