-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: juego
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `minijuegoseguidorestable`
--

DROP TABLE IF EXISTS `minijuegoseguidorestable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `minijuegoseguidorestable` (
  `idminijuegoseguidorestable` int(11) NOT NULL,
  `tema` varchar(45) DEFAULT NULL,
  `pregunta` longtext,
  `respuesta` varchar(45) DEFAULT NULL,
  `respuesta1` varchar(45) DEFAULT NULL,
  `respuesta2` varchar(45) DEFAULT NULL,
  `respuesta3` varchar(45) DEFAULT NULL,
  `respuesta4` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idminijuegoseguidorestable`),
  UNIQUE KEY `idminijuegoseguidorestable_UNIQUE` (`idminijuegoseguidorestable`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `nivelias`
--

DROP TABLE IF EXISTS `nivelias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nivelias` (
  `iddificultad` varchar(45) NOT NULL,
  `velocidad` double DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  PRIMARY KEY (`iddificultad`),
  UNIQUE KEY `iddificultad_UNIQUE` (`iddificultad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `niveltable`
--

DROP TABLE IF EXISTS `niveltable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `niveltable` (
  `idmapa` varchar(45) NOT NULL,
  `pesomax` int(11) DEFAULT NULL,
  `objetosmapa` json DEFAULT NULL,
  `policias` varchar(45) DEFAULT NULL,
  `transeuntes` varchar(45) DEFAULT NULL,
  `votantes` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idmapa`),
  UNIQUE KEY `idmapa_UNIQUE` (`idmapa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ranking`
--

DROP TABLE IF EXISTS `ranking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ranking` (
  `idmapa` varchar(45) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `votos` int(11) DEFAULT NULL,
  `seguidores` int(11) DEFAULT NULL,
  `puntuaciontot` int(11) DEFAULT NULL,
  PRIMARY KEY (`usuario`),
  UNIQUE KEY `usuario_UNIQUE` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `nombre` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `idMapa` varchar(45) DEFAULT NULL,
  `puntFinal` int(11) DEFAULT NULL,
  PRIMARY KEY (`nombre`),
  UNIQUE KEY `usuario_UNIQUE` (`nombre`),
  UNIQUE KEY `correo_UNIQUE` (`correo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-17 11:29:15
