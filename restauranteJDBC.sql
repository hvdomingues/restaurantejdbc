CREATE DATABASE  IF NOT EXISTS `restaurantejdbc` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `restaurantejdbc`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: restaurantejdbc
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `billpayment`
--

DROP TABLE IF EXISTS `billpayment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8*/;
CREATE TABLE `billpayment` (
  `PaymentID` int unsigned NOT NULL,
  `IndividualBillID` int NOT NULL,
  PRIMARY KEY (`PaymentID`,`IndividualBillID`),
  KEY `IndividualBillID` (`IndividualBillID`),
  CONSTRAINT `billpayment_ibfk_1` FOREIGN KEY (`PaymentID`) REFERENCES `payments` (`PaymentID`),
  CONSTRAINT `billpayment_ibfk_2` FOREIGN KEY (`IndividualBillID`) REFERENCES `individualbills` (`IndividualBillID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billpayment`
--

LOCK TABLES `billpayment` WRITE;
/*!40000 ALTER TABLE `billpayment` DISABLE KEYS */;
INSERT INTO `billpayment` VALUES (1,15),(2,15),(3,17),(4,17),(5,19),(6,19),(7,21),(8,21),(9,24);
/*!40000 ALTER TABLE `billpayment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bills`
--

DROP TABLE IF EXISTS `bills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `bills` (
  `BillID` int NOT NULL AUTO_INCREMENT,
  `TableNumber` int DEFAULT NULL,
  `StatusBill` int DEFAULT NULL,
  PRIMARY KEY (`BillID`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8	COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bills`
--

LOCK TABLES `bills` WRITE;
/*!40000 ALTER TABLE `bills` DISABLE KEYS */;
INSERT INTO `bills` VALUES (1,6,0),(2,25,0),(3,7,0),(4,9,0),(5,6,0),(6,3,0),(7,7,0),(8,9,0),(9,6,0),(10,3,0),(11,7,0),(12,9,1),(13,39,0),(14,3,0),(15,7,0),(16,9,0),(17,6,0),(18,3,0),(19,7,0),(20,9,0),(23,12,0),(24,39,0),(25,39,1);
/*!40000 ALTER TABLE `bills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `categories` (
  `CategoryID` int NOT NULL AUTO_INCREMENT,
  `CategoryName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`CategoryID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Massas'),(2,'Massas'),(3,'Saladas');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `individualbills`
--

DROP TABLE IF EXISTS `individualbills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `individualbills` (
  `IndividualBillID` int NOT NULL AUTO_INCREMENT,
  `BillID` int DEFAULT NULL,
  `Observation` varchar(255) DEFAULT NULL,
  `TabPosition` int NOT NULL,
  `StatusBill` int DEFAULT '0',
  `TotalPaid` double DEFAULT '0',
  `TipPaid` double DEFAULT '0',
  PRIMARY KEY (`IndividualBillID`),
  KEY `individualbills_ibfk_1` (`BillID`),
  CONSTRAINT `individualbills_ibfk_1` FOREIGN KEY (`BillID`) REFERENCES `bills` (`BillID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `individualbills`
--

LOCK TABLES `individualbills` WRITE;
/*!40000 ALTER TABLE `individualbills` DISABLE KEYS */;
INSERT INTO `individualbills` VALUES (15,1,'Henrique',2,0,0,0),(16,1,'Debora',1,0,0,0),(17,1,'Henrique',2,0,0,0),(18,1,'Debora',1,0,0,0),(19,1,'Henrique',2,0,0,0),(20,1,'Debora',1,0,0,0),(21,1,'Henrique',2,0,0,0),(22,1,'Debora',1,0,0,0),(23,24,'Oswaldo',3,0,0,0),(24,25,'Oswaldo',3,0,0,0);
/*!40000 ALTER TABLE `individualbills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderitem`
--

DROP TABLE IF EXISTS `orderitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `orderitem` (
  `OrderItemID` int NOT NULL AUTO_INCREMENT,
  `Quantity` int DEFAULT NULL,
  `ItemPrice` double DEFAULT NULL,
  `OrderID` int DEFAULT NULL,
  `ProductID` int DEFAULT NULL,
  PRIMARY KEY (`OrderItemID`),
  KEY `OrderID` (`OrderID`),
  KEY `ProductID` (`ProductID`),
  CONSTRAINT `orderitem_ibfk_1` FOREIGN KEY (`OrderID`) REFERENCES `orders` (`OrderID`),
  CONSTRAINT `orderitem_ibfk_2` FOREIGN KEY (`ProductID`) REFERENCES `products` (`ProductID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderitem`
--

LOCK TABLES `orderitem` WRITE;
/*!40000 ALTER TABLE `orderitem` DISABLE KEYS */;
INSERT INTO `orderitem` VALUES (1,2,24.99,1,1),(2,1,19.99,1,2),(3,2,24.99,2,3),(4,1,19.99,2,4),(5,4,15,3,5);
/*!40000 ALTER TABLE `orderitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `OrderID` int NOT NULL AUTO_INCREMENT,
  `Moment` timestamp NULL DEFAULT NULL,
  `IndividualBillID` int DEFAULT NULL,
  PRIMARY KEY (`OrderID`),
  KEY `IndividualBillID` (`IndividualBillID`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`IndividualBillID`) REFERENCES `individualbills` (`IndividualBillID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'2020-06-09 14:40:30',19),(2,'2020-06-09 14:51:01',21),(3,'2020-06-10 15:14:33',24);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payments`
--

DROP TABLE IF EXISTS `payments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `payments` (
  `PaymentID` int unsigned NOT NULL AUTO_INCREMENT,
  `PaymentMoment` timestamp NULL DEFAULT NULL,
  `PaymentValue` double NOT NULL,
  PRIMARY KEY (`PaymentID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payments`
--

LOCK TABLES `payments` WRITE;
/*!40000 ALTER TABLE `payments` DISABLE KEYS */;
INSERT INTO `payments` VALUES (1,'2020-06-07 21:00:00',150),(2,'2020-06-07 21:00:00',50),(3,'2020-06-09 13:45:14',150),(4,'2020-06-09 13:45:14',50),(5,'2020-06-09 14:40:30',150),(6,'2020-06-09 14:40:30',50),(7,'2020-06-09 14:51:01',150),(8,'2020-06-09 14:51:01',50),(9,'2020-06-10 15:14:33',60);
/*!40000 ALTER TABLE `payments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `ProductID` int NOT NULL AUTO_INCREMENT,
  `ProductName` varchar(50) DEFAULT NULL,
  `ProductPrice` double DEFAULT NULL,
  `ProductDesc` varchar(255) DEFAULT NULL,
  `CategoryID` int DEFAULT NULL,
  PRIMARY KEY (`ProductID`),
  KEY `CategoryID` (`CategoryID`),
  CONSTRAINT `products_ibfk_1` FOREIGN KEY (`CategoryID`) REFERENCES `categories` (`CategoryID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Macarrão a bolonhesa',24.99,'Macarrão feito com molho de tomate e carne moída',1),(2,'Macarrão ao pesto',19.99,'Macarrão com molho a base de ervas',1),(3,'Macarrão a bolonhesa',24.99,'Macarrão feito com molho de tomate e carne moída',2),(4,'Macarrão ao pesto',19.99,'Macarrão com molho a base de ervas',2),(5,'Ceasar Salad',15,'Salada com croutons',3);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `waiters`
--

DROP TABLE IF EXISTS `waiters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `waiters` (
  `WaiterID` int NOT NULL AUTO_INCREMENT,
  `WaiterName` varchar(55) DEFAULT NULL,
  PRIMARY KEY (`WaiterID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `waiters`
--

LOCK TABLES `waiters` WRITE;
/*!40000 ALTER TABLE `waiters` DISABLE KEYS */;
/*!40000 ALTER TABLE `waiters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'restaurantejdbc'
--

--
-- Dumping routines for database 'restaurantejdbc'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-13 15:29:58
