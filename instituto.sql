-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: instituto
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumno` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `fecha_nac` date NOT NULL,
  `dni` int NOT NULL,
  `escuela` varchar(80) NOT NULL,
  `grado` varchar(45) NOT NULL,
  `nivel` varchar(45) NOT NULL,
  `obra_social` int DEFAULT NULL,
  `borrado` tinyint NOT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `dni_UNIQUE` (`dni`),
  KEY `fk_alumno_obra_social1_idx` (`obra_social`),
  CONSTRAINT `fk_alumno_obra_social1` FOREIGN KEY (`obra_social`) REFERENCES `obra_social` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES (40,'ezequiel','cazon','2022-11-12',44948099,'221','sexto','Primario',NULL,0),(42,'mundo','ghghghg','2022-11-12',5675765,'fdsfsdsf','dfsfdsf','Secundario',138,1),(43,'jhjhj','jhjhjh','2024-11-09',564645,'654gfdg','gdfgdg','Secundario',142,0),(44,'luca','lopez','2019-11-09',666666666,'gfdgd','gfdgdfg','Inicial',140,1),(45,'alberto','meee','2022-11-12',435435,'gfdgd','gdfgdfg','Secundario',NULL,0),(47,'loco','lopez','2020-11-15',6757567,'6gffd','gfdgdf','Secundario',145,1),(48,'JJJJJ','JJJJJ','2022-11-12',56,'hgfh','hgfh','Primario',NULL,0),(49,'ESTEBAN LOCÓ','DÍAZ','2023-11-11',554646,'hrthgfh','hghf','Primario',NULL,0),(50,'JORGE','CAYO','2023-11-11',453345,'gfdgfdf','gfdgdgfd','Primario',NULL,0);
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumno_tutor`
--

DROP TABLE IF EXISTS `alumno_tutor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumno_tutor` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `codigo_alumno` int NOT NULL,
  `codigo_tutor` int NOT NULL,
  `parentesco` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_alumno_tutor_alumno_idx` (`codigo_alumno`),
  KEY `fk_alumno_tutor_tutor1_idx` (`codigo_tutor`),
  CONSTRAINT `fk_alumno_tutor_alumno` FOREIGN KEY (`codigo_alumno`) REFERENCES `alumno` (`codigo`),
  CONSTRAINT `fk_alumno_tutor_tutor1` FOREIGN KEY (`codigo_tutor`) REFERENCES `tutor` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno_tutor`
--

LOCK TABLES `alumno_tutor` WRITE;
/*!40000 ALTER TABLE `alumno_tutor` DISABLE KEYS */;
INSERT INTO `alumno_tutor` VALUES (29,40,26,'madre'),(30,42,26,'padre'),(31,43,30,'madre'),(32,44,31,'padre'),(33,45,30,'padre'),(34,47,31,'madre'),(35,48,30,'ytryr'),(36,49,28,'hgfhfh'),(37,50,30,'dfsdfs');
/*!40000 ALTER TABLE `alumno_tutor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asistencias_mensuales`
--

DROP TABLE IF EXISTS `asistencias_mensuales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asistencias_mensuales` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `codigo_inscripcion` int NOT NULL,
  `codigo_mes` int NOT NULL,
  `codigo_ciclo_lectivo` int NOT NULL,
  `asistio` varchar(2) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_asistencias_mensuales_meses1_idx` (`codigo_mes`),
  KEY `fk_asistencias_mensuales_inscripcion1_idx` (`codigo_inscripcion`),
  KEY `fk_asistencias_mensuales_ciclo_lectivo1_idx` (`codigo_ciclo_lectivo`),
  CONSTRAINT `fk_asistencias_mensuales_ciclo_lectivo1` FOREIGN KEY (`codigo_ciclo_lectivo`) REFERENCES `ciclo_lectivo` (`codigo`),
  CONSTRAINT `fk_asistencias_mensuales_inscripcion1` FOREIGN KEY (`codigo_inscripcion`) REFERENCES `inscripcion` (`codigo`),
  CONSTRAINT `fk_asistencias_mensuales_meses1` FOREIGN KEY (`codigo_mes`) REFERENCES `meses` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asistencias_mensuales`
--

LOCK TABLES `asistencias_mensuales` WRITE;
/*!40000 ALTER TABLE `asistencias_mensuales` DISABLE KEYS */;
INSERT INTO `asistencias_mensuales` VALUES (85,80,11,1,'SI'),(86,80,12,1,'SI'),(87,81,11,1,'SI'),(88,87,11,1,'SI'),(89,81,12,1,'SI'),(90,89,11,1,'SI');
/*!40000 ALTER TABLE `asistencias_mensuales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ciclo_lectivo`
--

DROP TABLE IF EXISTS `ciclo_lectivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ciclo_lectivo` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `año` int NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciclo_lectivo`
--

LOCK TABLES `ciclo_lectivo` WRITE;
/*!40000 ALTER TABLE `ciclo_lectivo` DISABLE KEYS */;
INSERT INTO `ciclo_lectivo` VALUES (1,2025);
/*!40000 ALTER TABLE `ciclo_lectivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gastos`
--

DROP TABLE IF EXISTS `gastos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gastos` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `precio` float NOT NULL,
  `codigo_mes` int NOT NULL,
  `año` int NOT NULL,
  `borrado` tinyint NOT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `gasto_unico_por_mes` (`nombre`,`codigo_mes`,`año`),
  KEY `fk_gastos_meses1_idx` (`codigo_mes`),
  KEY `fk_gastos_ciclo_lectivo1_idx` (`año`),
  CONSTRAINT `fk_gastos_ciclo_lectivo1` FOREIGN KEY (`año`) REFERENCES `ciclo_lectivo` (`codigo`),
  CONSTRAINT `fk_gastos_meses1` FOREIGN KEY (`codigo_mes`) REFERENCES `meses` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gastos`
--

LOCK TABLES `gastos` WRITE;
/*!40000 ALTER TABLE `gastos` DISABLE KEYS */;
INSERT INTO `gastos` VALUES (30,'luz',50000,11,1,1),(31,'alquiler',5000,11,1,1);
/*!40000 ALTER TABLE `gastos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horarios`
--

DROP TABLE IF EXISTS `horarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `horarios` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `horario` varchar(30) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horarios`
--

LOCK TABLES `horarios` WRITE;
/*!40000 ALTER TABLE `horarios` DISABLE KEYS */;
INSERT INTO `horarios` VALUES (1,'16:00 - 17:30'),(2,'17:30 - 19:00'),(3,'19:00 - 20:30');
/*!40000 ALTER TABLE `horarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inscripcion`
--

DROP TABLE IF EXISTS `inscripcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inscripcion` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `codigo_alumno` int NOT NULL,
  `dias` varchar(50) DEFAULT NULL,
  `codigo_horarios` int DEFAULT NULL,
  `codigo_profesor` int NOT NULL,
  `codigo_servicio` int NOT NULL,
  `fecha_inscripcion` date NOT NULL,
  `codigo_ciclo_lectivo` int NOT NULL,
  `estado` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_cronograma_d_h_alumno_alumno1_idx` (`codigo_alumno`),
  KEY `fk_cronograma_d_h_alumno_croograma_horarios1_idx` (`codigo_horarios`),
  KEY `fk_inscripcion_profesor1_idx` (`codigo_profesor`),
  KEY `fk_inscripcion_servicios1_idx` (`codigo_servicio`),
  KEY `fk_inscripcion_ciclo_lectivo1_idx` (`codigo_ciclo_lectivo`),
  CONSTRAINT `fk_cronograma_d_h_alumno_alumno1` FOREIGN KEY (`codigo_alumno`) REFERENCES `alumno` (`codigo`),
  CONSTRAINT `fk_cronograma_d_h_alumno_croograma_horarios1` FOREIGN KEY (`codigo_horarios`) REFERENCES `horarios` (`codigo`),
  CONSTRAINT `fk_inscripcion_ciclo_lectivo1` FOREIGN KEY (`codigo_ciclo_lectivo`) REFERENCES `ciclo_lectivo` (`codigo`),
  CONSTRAINT `fk_inscripcion_profesor1` FOREIGN KEY (`codigo_profesor`) REFERENCES `profesor` (`codigo`),
  CONSTRAINT `fk_inscripcion_servicios1` FOREIGN KEY (`codigo_servicio`) REFERENCES `servicios` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inscripcion`
--

LOCK TABLES `inscripcion` WRITE;
/*!40000 ALTER TABLE `inscripcion` DISABLE KEYS */;
INSERT INTO `inscripcion` VALUES (80,47,'Miercoles - Viernes',3,18,2,'2025-11-24',1,'INACTIVO'),(81,45,'Miercoles - Viernes',2,21,3,'2025-11-24',1,'INACTIVO'),(82,44,'Martes - Jueves',1,18,4,'2025-11-24',1,'INACTIVO'),(83,43,NULL,NULL,21,5,'2025-11-24',1,'INACTIVO'),(84,40,NULL,NULL,18,6,'2025-11-24',1,'INACTIVO'),(85,40,NULL,NULL,19,5,'2025-11-24',1,'INACTIVO'),(86,40,NULL,NULL,20,6,'2025-11-24',1,'INACTIVO'),(87,47,'Martes - Jueves',2,18,3,'2025-11-24',1,'INACTIVO'),(88,40,NULL,NULL,18,6,'2025-11-24',1,'ACTIVO'),(89,45,'Martes - Jueves',3,19,2,'2025-11-24',1,'ACTIVO');
/*!40000 ALTER TABLE `inscripcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meses`
--

DROP TABLE IF EXISTS `meses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `meses` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `mes` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meses`
--

LOCK TABLES `meses` WRITE;
/*!40000 ALTER TABLE `meses` DISABLE KEYS */;
INSERT INTO `meses` VALUES (1,'Enero'),(2,'Febrero'),(3,'Marzo'),(4,'Abril'),(5,'Mayo'),(6,'Junio'),(7,'Julio'),(8,'Agosto'),(9,'Septiembre'),(10,'Octubre'),(11,'Noviembre'),(12,'Diciembre');
/*!40000 ALTER TABLE `meses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modalidad_cobro`
--

DROP TABLE IF EXISTS `modalidad_cobro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `modalidad_cobro` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `modalidad` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modalidad_cobro`
--

LOCK TABLES `modalidad_cobro` WRITE;
/*!40000 ALTER TABLE `modalidad_cobro` DISABLE KEYS */;
INSERT INTO `modalidad_cobro` VALUES (1,'Mensual'),(2,'Clase'),(3,'Pago Unico');
/*!40000 ALTER TABLE `modalidad_cobro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `obra_social`
--

DROP TABLE IF EXISTS `obra_social`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `obra_social` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(80) NOT NULL,
  `borrado` tinyint NOT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=148 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `obra_social`
--

LOCK TABLES `obra_social` WRITE;
/*!40000 ALTER TABLE `obra_social` DISABLE KEYS */;
INSERT INTO `obra_social` VALUES (138,'IOSFAA',0),(139,'iose',1),(140,'ioioioioi',0),(141,'jujuy sana',1),(142,'iosfa',0),(144,'ttttttttthhhhhh',0),(145,'ghfhfhgfhfh',0),(146,'nnnnnnnnnnn',0),(147,'NOÁ',0);
/*!40000 ALTER TABLE `obra_social` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagos`
--

DROP TABLE IF EXISTS `pagos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pagos` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `codigo_tipo_pago` int NOT NULL,
  `codigo_inscripcion` int NOT NULL,
  `fecha_pago` date NOT NULL,
  `codigo_servicio` int NOT NULL,
  `recargo` float NOT NULL DEFAULT '0',
  `codigo_mes` int DEFAULT NULL,
  `codigo_ciclo_lectivo` int NOT NULL,
  `observacion` varchar(100) DEFAULT NULL,
  `total` float NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_pagos_tipo_pago1_idx` (`codigo_tipo_pago`),
  KEY `fk_pagos_inscripcion1_idx` (`codigo_inscripcion`),
  KEY `fk_pagos_servicios1_idx` (`codigo_servicio`),
  KEY `fk_pagos_meses1_idx` (`codigo_mes`),
  KEY `fk_pagos_ciclo_lectivo1_idx` (`codigo_ciclo_lectivo`),
  CONSTRAINT `fk_pagos_ciclo_lectivo1` FOREIGN KEY (`codigo_ciclo_lectivo`) REFERENCES `ciclo_lectivo` (`codigo`),
  CONSTRAINT `fk_pagos_inscripcion1` FOREIGN KEY (`codigo_inscripcion`) REFERENCES `inscripcion` (`codigo`),
  CONSTRAINT `fk_pagos_meses1` FOREIGN KEY (`codigo_mes`) REFERENCES `meses` (`codigo`),
  CONSTRAINT `fk_pagos_servicios1` FOREIGN KEY (`codigo_servicio`) REFERENCES `servicios` (`codigo`),
  CONSTRAINT `fk_pagos_tipo_pago1` FOREIGN KEY (`codigo_tipo_pago`) REFERENCES `tipo_pago` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagos`
--

LOCK TABLES `pagos` WRITE;
/*!40000 ALTER TABLE `pagos` DISABLE KEYS */;
INSERT INTO `pagos` VALUES (64,1,80,'2025-11-24',2,0,11,1,'paga noviembre',30000),(65,1,80,'2025-11-24',2,0,12,1,'',30000),(66,1,82,'2025-11-24',4,0,NULL,1,'',9000),(67,1,87,'2025-11-24',3,0,11,1,'',30000),(68,1,81,'2025-11-24',3,0,11,1,'',30000),(69,1,81,'2025-11-24',3,0,12,1,'',30000);
/*!40000 ALTER TABLE `pagos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profesor` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `dni` int NOT NULL,
  `residencia` varchar(75) NOT NULL,
  `titulo` varchar(75) NOT NULL,
  `borrado` tinyint NOT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
INSERT INTO `profesor` VALUES (16,'oscar manuel','hoyos',3434,'tanto','profesor',0),(17,'fdsf','fdsf',43535,'fdsfsd','grtrete',1),(18,'juaco','lopez',7657657,'gfdgdf','gfdgdf',0),(19,'tytytyt','tytyty',564645654,'gfdgd','gfdhsgsfh',0),(20,'yoyoyoy','uuuuu',768686,'6757','hfgghgfhgfhf',0),(21,'TTTTTTTT','ALCÓ',444444444,'frfffffff','rtetrete',0),(22,'LINA','LÓPEZ',546465,'hgfhf','hgfhf',0);
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicios`
--

DROP TABLE IF EXISTS `servicios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servicios` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(70) NOT NULL,
  `precio` float NOT NULL,
  `codigo_modalidad_cobro` int DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `nombre` (`nombre`),
  KEY `fk_servicios_tipo_modalidad_pago1_idx` (`codigo_modalidad_cobro`),
  CONSTRAINT `fk_servicios_tipo_modalidad_pago1` FOREIGN KEY (`codigo_modalidad_cobro`) REFERENCES `modalidad_cobro` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicios`
--

LOCK TABLES `servicios` WRITE;
/*!40000 ALTER TABLE `servicios` DISABLE KEYS */;
INSERT INTO `servicios` VALUES (2,'Educación Temprana',30000,1),(3,'Apoyo Pedagógico',30000,1),(4,'Clases Personalizadas',10000,2),(5,'Inclusión Escolar: Acompañamiento',0,NULL),(6,'Inclusión Escolar: Itinerancia',0,NULL);
/*!40000 ALTER TABLE `servicios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_pago`
--

DROP TABLE IF EXISTS `tipo_pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_pago` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `tipo_pago` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_pago`
--

LOCK TABLES `tipo_pago` WRITE;
/*!40000 ALTER TABLE `tipo_pago` DISABLE KEYS */;
INSERT INTO `tipo_pago` VALUES (1,'Efectivo'),(2,'Transferencia');
/*!40000 ALTER TABLE `tipo_pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tutor`
--

DROP TABLE IF EXISTS `tutor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tutor` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `dni` int NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `borrado` tinyint NOT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `dni_UNIQUE` (`dni`),
  UNIQUE KEY `telefono_UNIQUE` (`telefono`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tutor`
--

LOCK TABLES `tutor` WRITE;
/*!40000 ALTER TABLE `tutor` DISABLE KEYS */;
INSERT INTO `tutor` VALUES (26,'ana maria','mamani',47152375,'3888 630002',0),(27,'gonza','gdfg',4535435,'4535435',1),(28,'uuuuu','uuuuuuu',67575756,'54654646',0),(30,'fgd','gdfgfd',47152378,'3888630002',0),(31,'brian','CAZON',343536,'3888684916',0),(32,'RAMIRO ESTEBAN','FEDÉ',666666765,'4654645',0);
/*!40000 ALTER TABLE `tutor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-24  4:51:36
