-- MySQL dump 10.13  Distrib 5.7.29, for osx10.15 (x86_64)
--
-- Host: localhost    Database: usecasemib & usecasemib_master
-- ------------------------------------------------------
-- Server version	5.7.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

CREATE DATABASE /*!32312 IF NOT EXISTS */ `usecasemib` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
CREATE DATABASE /*!32312 IF NOT EXISTS */ `usecasemib_master` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

--
-- Current Database: `usecasmib_master`
--

USE `usecasemib_master`;

--
-- Table structure for table `M_PJ_Foo`
--

DROP TABLE IF EXISTS `M_PJ_Foo`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `M_PJ_Foo`
(
    `ProjectId`   varchar(255) NOT NULL,
    `ProjectName` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`ProjectId`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `M_PJ_Foo`
--

LOCK TABLES `M_PJ_Foo` WRITE;
/*!40000 ALTER TABLE `M_PJ_Foo`
    DISABLE KEYS */;
INSERT INTO `M_PJ_Foo`
VALUES ('25', 'hello25'),
       ('26', 'hello26');
/*!40000 ALTER TABLE `M_PJ_Foo`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `V_PJ_Foo`
--

DROP TABLE IF EXISTS `V_PJ_Foo`;
/*!50001 DROP VIEW IF EXISTS `V_PJ_Foo`*/;
SET @saved_cs_client = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `V_PJ_Foo` AS
SELECT 1 AS `ProjectId`,
       1 AS `ProjectName`
        */;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `V_PJ_Foo`
--

/*!50001 DROP VIEW IF EXISTS `V_PJ_Foo`*/;
/*!50001 SET @saved_cs_client = @@character_set_client */;
/*!50001 SET @saved_cs_results = @@character_set_results */;
/*!50001 SET @saved_col_connection = @@collation_connection */;
/*!50001 SET character_set_client = utf8mb4 */;
/*!50001 SET character_set_results = utf8mb4 */;
/*!50001 SET collation_connection = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM = UNDEFINED */ /*!50013 DEFINER =`root`@`localhost` SQL SECURITY DEFINER */ /*!50001 VIEW `v_pj_foo` AS
select `M_PJ_Foo`.`ProjectId` AS `ProjectId`, `M_PJ_Foo`.`ProjectName` AS `ProjectName`
from `M_PJ_Foo`
        */;
/*!50001 SET character_set_client = @saved_cs_client */;
/*!50001 SET character_set_results = @saved_cs_results */;
/*!50001 SET collation_connection = @saved_col_connection */;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2022-04-13 15:23:33
