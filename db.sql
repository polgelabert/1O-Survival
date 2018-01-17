-- MySQL dump 10.13  Distrib 5.7.20, for Win64 (x86_64)
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
-- Current Database: `juego`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `juego` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `juego`;

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
-- Dumping data for table `minijuegoseguidorestable`
--

LOCK TABLES `minijuegoseguidorestable` WRITE;
/*!40000 ALTER TABLE `minijuegoseguidorestable` DISABLE KEYS */;
INSERT INTO `minijuegoseguidorestable` VALUES (1,'Ciencia','¿Cuál de las sisguientes enfermedades ataca al higado?','Hepatitis','Diabetes','Artrósis','Cifoescoliosis','Hepatitis'),(2,'Ciencia','¿Qué hay en la boca del estómago?','El cardías','El píloro','El cardías','Los ácidos gástricos','El epilón mayor'),(3,'Ciencia','¿Qué órgano del cuerpo humano produce la bilis?','Hígado','Páncreas','Intestino delgado','Hígado','Intestino grueso'),(4,'Ciencia','¿De donde de saca la sacarina?','Del carbón','Del aceite de girasol','Del azúcar','Del carbón','Del azufre'),(5,'Ciencia','¿Cuántas caras tiene un icosaedro?','20','20','14','24','18'),(6,'Ciencia','¿Qué es el calostro?','La primera leche materna','Un hueso de la espina dorsal','Una hormona','Una parte del intestino grueso','La primera leche materna'),(7,'Ciencia','¿Cuál es el hueso más pequeño del cuerpo?','El estribo','El yunque','La falange','El estribo','Ninguna es correcta'),(8,'Ciencia','¿Qué es un equino?','Un caballo','Una vaca','Un antílope','Una oveja','Un caballo'),(9,'Ciencia','¿Qué tipo de mamífero es un conejo?','Lagomorfo','Lagomorfo','Roedor','Marsupial','Equino'),(10,'Ciencia','¿Qué es el gavial (Gavialis gangeticus)?','Cocodrilo','Cocodrilo','Hipopótamo','Serpiente','Tiburón'),(11,'Ciencia','¿Qué sonido hace un elefante?','Baritan','Baritan','Gruñen','Brugen','Bruzan'),(12,'Ciencia','¿Cuáles son los efectos de la prolactina?','Producción de leche','Crecimiento del cabello','Producción de leche','Ayuda al parto','Ninguna de las anteriores'),(13,'Ciencia','¿Qué tipo de músculos realizan los movimientos voluntarios?','Estriados','Estriados','Lisos','Gordos','Gruesos'),(14,'Ciencia','¿Cuál es la raíz cuadrada del 176?','13.3','13.3','13.4','13.6','13.8'),(15,'Ciencia','¿Qué sustancia libera el Sistema Parasimpático?','Acetilcolina','Noradrenalina','Serotonina','Adrenalina','Acetilcolina'),(16,'Geografia','¿Cuál es el país menos turístico de Europa?','Liechtenstein','Armenia','Moldavia','Hungría','Liechtenstein'),(17,'Geografia','¿A qué país pertenece la isla de Tasmania?','Australia','Australia','Nueva Zelanda','Filipinas','Ninguna es correcta'),(18,'Geografia','¿Cuál es la capital del estado de Arkansas?','Little Rock','Kansas','Little Rock','Hot Springs','Washington'),(19,'Geografia','¿En qué país situarías la ciudad de Cali?','Colombia','Venezuela','Costa Rica','Chile','Colombia'),(20,'Geografia','¿Cuál de las siguientes especialidades NO es típica de la cocina estadounidense?','Todas son típicas','La hamburguesa','El pastel de cangrejo','La tarta de manzana','Todas son típicas'),(21,'Geografia','¿Con cuántos países limita Argentina?','Cinco','Tres','Cuatro','Cinco','Seis'),(22,'Geografia','¿Cuál es la capital de Suiza?','Berna','Berna','Zurich','Basilea','Ginebra'),(23,'Geografia','¿Qué separa las franjas de Gaza y Cisjordania?','Israel','Un muro','Israel','Un río','Nada'),(24,'Geografia','¿En qué país está Ushuaia, la ciudad más al sur del mundo?','Argentina','Chile','Argentina','Sudáfrica','Nueva Zelanda'),(25,'Geografia','¿Cuál de estos países africanos no tiene costa?','Todas tienen costa','Mauritania','Senegal','Gambia','Todas tienen costa'),(26,'Geografia','¿Cuál de las siguientes islas está más al sur?','Malta','Sicilia','Malta','Córcega','Cerdeña'),(27,'Geografia','¿Cuál de las siguientes ciudades no es una ciudad santa?','Burgos','Santiago de Compostela','Hebrón','Asís','Burgos'),(28,'Geografia','¿Qué ciudad europea es famosa por la belleza de su parlamento?','Budapest','París','Madrid','Budapest','Praga'),(29,'Geografia','¿Cuál es la capital de Libia?','Trípoli','Trípoli','Beirut','El Cairo','Riad'),(30,'Geografia','¿Entre qué dos países está el lago Titicaca?','Bolivia y Perú','Bolivia y Perú','Bolivia y Paraguay','Bolivia y Brasil','Bolivia y Argentina'),(31,'Deportes','¿Cuántos mangos por lado tiene el futbolín?','Cuatro','Dos','Tres','Cuatro','Cinco'),(32,'Deportes','¿Cuántos jugadores componen un equipo de rugby?','15','11','12','14','15'),(33,'Deportes','¿Cuántas puntas de cada color hay en un tablero de backgammon?','Doce','Ocho','Doce','Catorce','Dieciséis'),(34,'Deportes','¿En qué país se inventó el voleibol?','Estados Unidos','Gran Bretaña','Francia','Rusia','Estados Unidos'),(35,'Deportes','¿Cuál de las siguientes modalidades no forma parte del deporte rural vasco?','Desintegramiento de piedra','Desintegramiento de piedra','Arrastre de piedra','Lanzamiento de fardo','Corte de troncos'),(36,'Deportes','¿Qué selección acumula mayor cantidad de expulsados en  mundiales de fútbol?','Argentina','Argentina','Brasil','Italia','Camerún'),(37,'Deportes','¿Quién inventó el arte marcial llamado Jeet Kune Do?','Bruce Lee','Chuck Norris','Bruce Lee','Kato Mimoko','Ninguna es correcta'),(38,'Deportes','¿De qué color es el cero en el cilindro de la ruleta?','Verde','Blanco','Negro','Rojo','Verde'),(39,'Deportes','¿Cuánto pesa aproximadamente una bola de bolera?','Siete kilos y cuarto','Cuatro kilos y medio','Cinco kilos y medio','Siete kilos y cuarto','Siete kilos y medio'),(40,'Deportes','¿Cuántos puntos vale un tiro libre encestado en baloncesto?','Uno','Uno','Uno','Tres','Depende'),(41,'Deportes','¿Qué tipo de competición es el Giro de Italia?','Una carrera ciclista','Una competición de vela','Una carrera ciclista','Un maratón','Una carrera automovilística'),(42,'Deportes','¿Cuál es el derbi más esperado en Andalucía?','Betis vs Sevilla','Real Madrid vs Sevilla','Betis vs Sevilla','Granada vs Málaga','Real Madrid vs At. Madrid'),(43,'Deportes','¿Cómo se llama la zona de hierba rasa donde está ubicado el hoyo en golf?','Green','Green','Esplanada','Campo','Set'),(44,'Deportes','¿Cuál de estos pilotos no es de F1?','Richard Petty','Mark Webber','Sebastian Vettel','Fernando Alonso','Richard Petty'),(45,'Deportes','¿A qué tipo de billar se juega con más bolas?','Snooker','Bola 9','Snooker','Billar español','Billar italiano'),(46,'Historia','¿Cuál es la rama mayoritaria del Islam?','Sunismo','Chiísmo','Sunismo','Jariyismo','Sufismo'),(47,'Historia','¿De qué fue ministro Manuel Fraga durante el franquismo?','De Información y Turismo','De Interior','De Economía','Del Ejército','De Información y Turismo'),(48,'Historia','¿En qué año tuvo lugar el ataque a Pearl Harbor?','1941','1939','1940','1941','1945'),(49,'Historia','A qué dirigente latinoamericano mandó callar Juan Carlos de Borbón?','Hugo Chávez','Evo Morales','Fidel Castro','Hugo Chávez','Rafael Correa'),(50,'Historia','¿Quiénes fueron los sans-culottes de la Revolución Francesa?','La principal masa social revolucionaria','La burguesía durante la Revolución','La principal masa social revolucionaria','El nombre despectivo de los burgueses','Ninguna es correcta'),(51,'Historia','¿Cuál es la ciudad más antigua de América Latina?','Caral','Valparaíso','Arequipa','La Paz','Caral'),(52,'Historia','¿Con qué emperador estuvo casada Cleopatra?','Todas son correctas','Todas son correctas','Ptolomeo XIV','Julio César','Marco Antonio'),(53,'Historia','¿Qué país fue dirigido por Stalin?','Unión Soviética','Cuba','Unión Soviética','Alemania','Polonia'),(54,'Historia','¿Qué se celebra el 8 de Marzo?','El día de la mujer','El día del trabajo','El día del medio ambiente','El día de la mujer','El día del niño'),(55,'Historia','¿Cuántos siglos duró el Siglo de Oro?','Dos','Medio siglo','Uno','Dos','Tres'),(56,'Historia','¿Para qué fue creado el plan Marshall en 1947?','Reconstrucción','Conquista','Regalo','Comercio','Reconstrucción'),(57,'Historia','¿Cómo se llama la capital del antiguo imperio azteca?','Tenochtitlan','Quetzalcoatl','Tenochtitlan','Culhuacan','Texcoco'),(58,'Historia','Los cuatro evangelistas de la Biblia son Mateo, Marcos, Lucas y...','Juan','Antonio','Jesús','Jose','Juan'),(59,'Historia','¿Quién gobernó Francia desde 1799 a 1815?','Napoleón Bonaparte','Napoleón Bonaparte','Adam Smith','François Quesnay','Louis Bonaldgug'),(60,'Historia','¿Qué modelo de Seat significó la motorización de los españoles?','600','500','Ibiza','600','Ninguna es correcta'),(81,'CiNa','¿Quien fue un importante\r cientifico italiano del siglo XVII?','Evangelista Torricelli','Piere de Fermat','Evangelista Torricelli','Caravaggio','Marin Mersenne');
/*!40000 ALTER TABLE `minijuegoseguidorestable` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `nivelias`
--

LOCK TABLES `nivelias` WRITE;
/*!40000 ALTER TABLE `nivelias` DISABLE KEYS */;
INSERT INTO `nivelias` VALUES ('nivel1',1,5),('nivel2',1.2,10),('nivel3',1.6,15);
/*!40000 ALTER TABLE `nivelias` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `niveltable`
--

LOCK TABLES `niveltable` WRITE;
/*!40000 ALTER TABLE `niveltable` DISABLE KEYS */;
/*!40000 ALTER TABLE `niveltable` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `ranking`
--

LOCK TABLES `ranking` WRITE;
/*!40000 ALTER TABLE `ranking` DISABLE KEYS */;
INSERT INTO `ranking` VALUES ('mapa1','Alex2',49,2,33),('mapa1','Anna2',58,5,43),('mapa1','Javi',115,7,137),('mapa1','Joan2',55,4,38),('mapa1','Joaquin',105,9,130),('mapa2','mama',64,3,49),('mapa2','Maria',254,13,355),('mapa2','Oriol',38,0,26),('mapa2','Pedro',99,5,115),('mapa2','Pol2',50,3,34),('mapa3','Victor',287,18,428);
/*!40000 ALTER TABLE `ranking` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('ACarla','4Carla','CACACarla@gmail.com',NULL,0),('Alex2','4','alexagui@gmail.com','mapa1',0),('Anna2','2','annagarcia@gmail.com','mapa1',0),('Javi','111','javijavito@gmail.com','mapa1',254),('Joan2','1','joanet@gmail.com','mapa1',0),('Joaquin','10','joaquin@gmail.com','mapa1',0),('mama','18','mama@gmail.com','mapa2',0),('Maria','5','maria@gmail.com','mapa2',0),('Marta','8447','martamartaa@gmail.com',NULL,0),('MartinaGrande','01556565','martiPoLnmontelior@gmail.com',NULL,0),('MartinALL','0155','martinmontelior@gmail.com',NULL,0),('Oriol','8','oriol@gmail.com','mapa2',0),('Pedro','9','pedro@gmail.com','mapa2',0),('Pol2','3','pol@gmail.com','mapa2',0),('popo','pipi','piopoi@gmail.com',NULL,0),('Victor','7','victor@gmail.com','mapa3',0);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-17 12:22:38
