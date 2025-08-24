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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES (1,'brian','Cazón','2003-08-04',44948099,'colegio 14','quinto','Primario',6,1),(2,'ana','mamani','2004-03-19',47152374,'tec 2','quinto','Primario',2,1),(3,'ezequiel','cazon','2024-04-04',1111111,'t perez','qunto','Inicial',1,1),(4,'rerew','fewfew','2023-04-03',432432432,'fwfdsfds','fwffwfwefwe','Inicial',4,1),(5,'ffdsf','fdfs','2023-03-03',34432432,'eerrfdsfdsfds','fdfdsf','Primario',5,1),(6,'ana','mamani','2024-03-02',2313231,'sarmiento','fwefwefew','Secundario',NULL,0),(7,'pablo','Flores','2003-04-03',121212,'perez','quinto','Secundario',105,0),(9,'bandi','cazon','2000-04-04',47152375,'nueva ciudad','quinto','Primario',105,0),(12,'rafa','aguante','2004-03-03',56565656,'sarmiento77','quinto','Inicial',75,0),(14,'bandi','cazon','2000-04-04',13456378,'Sarmiento','quinto','Primario',NULL,0),(15,'kovu','cazón','2024-12-12',77777777,'sarmiento','quinto','Inicial',NULL,0),(16,'lionel','messi','2000-03-03',14141414,'sarmiento','sexto','Inicial',NULL,1),(17,'angel','di maria','2001-03-03',88888888,'fdfdfds','fdsfdsf','Inicial',35,1),(18,'jose','Antonio','2004-03-03',432432,'fewfdsf','fdsfdsf','Secundario',35,0),(19,'fdfsdfs','ewrwrew','2004-04-04',34234234,'rrewrrewrw','fsdfsdfdsfs','Inicial',27,1),(20,'ian','ibarra','2020-09-29',43254123,'papa francisco 457','5to','Inicial',105,0);
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno_tutor`
--

LOCK TABLES `alumno_tutor` WRITE;
/*!40000 ALTER TABLE `alumno_tutor` DISABLE KEYS */;
/*!40000 ALTER TABLE `alumno_tutor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ciclo_lectivo`
--

DROP TABLE IF EXISTS `ciclo_lectivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ciclo_lectivo` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `codigo_inscripcion` int NOT NULL,
  `año_ciclo_lectivo` int DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_ciclo_lectivo_inscripcion1_idx` (`codigo_inscripcion`),
  CONSTRAINT `fk_ciclo_lectivo_inscripcion1` FOREIGN KEY (`codigo_inscripcion`) REFERENCES `inscripcion` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciclo_lectivo`
--

LOCK TABLES `ciclo_lectivo` WRITE;
/*!40000 ALTER TABLE `ciclo_lectivo` DISABLE KEYS */;
/*!40000 ALTER TABLE `ciclo_lectivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cronograma_dias`
--

DROP TABLE IF EXISTS `cronograma_dias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cronograma_dias` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `dias` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cronograma_dias`
--

LOCK TABLES `cronograma_dias` WRITE;
/*!40000 ALTER TABLE `cronograma_dias` DISABLE KEYS */;
/*!40000 ALTER TABLE `cronograma_dias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cronograma_horarios`
--

DROP TABLE IF EXISTS `cronograma_horarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cronograma_horarios` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `horario` time NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cronograma_horarios`
--

LOCK TABLES `cronograma_horarios` WRITE;
/*!40000 ALTER TABLE `cronograma_horarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `cronograma_horarios` ENABLE KEYS */;
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
  `codigo_cronograma_dias` int NOT NULL,
  `codigo_cronograma_horarios` int NOT NULL,
  `codigo_profesor` int NOT NULL,
  `codigo_servicio` int NOT NULL,
  `fecha_inscripcion` date NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_cronograma_d_h_alumno_alumno1_idx` (`codigo_alumno`),
  KEY `fk_cronograma_d_h_alumno_cronograma_dias1_idx` (`codigo_cronograma_dias`),
  KEY `fk_cronograma_d_h_alumno_croograma_horarios1_idx` (`codigo_cronograma_horarios`),
  KEY `fk_inscripcion_profesor1_idx` (`codigo_profesor`),
  KEY `fk_inscripcion_servicios1_idx` (`codigo_servicio`),
  CONSTRAINT `fk_cronograma_d_h_alumno_alumno1` FOREIGN KEY (`codigo_alumno`) REFERENCES `alumno` (`codigo`),
  CONSTRAINT `fk_cronograma_d_h_alumno_cronograma_dias1` FOREIGN KEY (`codigo_cronograma_dias`) REFERENCES `cronograma_dias` (`codigo`),
  CONSTRAINT `fk_cronograma_d_h_alumno_croograma_horarios1` FOREIGN KEY (`codigo_cronograma_horarios`) REFERENCES `cronograma_horarios` (`codigo`),
  CONSTRAINT `fk_inscripcion_profesor1` FOREIGN KEY (`codigo_profesor`) REFERENCES `profesor` (`codigo`),
  CONSTRAINT `fk_inscripcion_servicios1` FOREIGN KEY (`codigo_servicio`) REFERENCES `servicios` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inscripcion`
--

LOCK TABLES `inscripcion` WRITE;
/*!40000 ALTER TABLE `inscripcion` DISABLE KEYS */;
/*!40000 ALTER TABLE `inscripcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modalidad_servicio`
--

DROP TABLE IF EXISTS `modalidad_servicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `modalidad_servicio` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modalidad_servicio`
--

LOCK TABLES `modalidad_servicio` WRITE;
/*!40000 ALTER TABLE `modalidad_servicio` DISABLE KEYS */;
INSERT INTO `modalidad_servicio` VALUES (1,'Mensual'),(2,'Clase');
/*!40000 ALTER TABLE `modalidad_servicio` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `obra_social`
--

LOCK TABLES `obra_social` WRITE;
/*!40000 ALTER TABLE `obra_social` DISABLE KEYS */;
INSERT INTO `obra_social` VALUES (1,'Obra Social Sanar Salud',0),(2,'Obra Social Vida Plena',0),(3,'Obra Social Unión Médica',0),(4,'Obra Social Salud Total',0),(5,'Obra Social Bienestar',0),(6,'Obra Social Vital Plus',0),(7,'Obra Social Red Médica',0),(8,'Obra Social Protección Familiar',0),(9,'Obra Social MedIntegral',0),(10,'Obra Social Nova Salud',0),(11,'Obra Social Horizonte',0),(12,'Obra Social Futuro Salud',0),(13,'Obra Social Salud Argentina',0),(14,'Obra Social Medifácil',0),(15,'Obra Social Doctor Asistencia',0),(16,'Obra Social Vida Sana',0),(17,'Obra Social Salud y Vida',0),(18,'Obra Social Buena Salud',0),(19,'Obra Social Cobertura Total',0),(20,'Obra Social Salud Hogar',0),(21,'Obra Social Bien Cuidado',0),(22,'Obra Social Medicor',0),(23,'Obra Social Suma Salud',0),(24,'Obra Social Federal Salud',0),(25,'Obra Social Comunidad Médica',0),(26,'Obra Social Norte Médico',0),(27,'Obra Social Vital Médica',0),(28,'Obra Social Crecer Salud',0),(29,'Obra Social Asistencia Nacional',0),(30,'Obra Social Médica Jujeña',0),(31,'Obra Social Sanar Juntos',0),(32,'Obra Social Familia Protegida',0),(33,'Obra Social Confianza Médica',0),(34,'Obra Social Más Vida',0),(35,'Obra Social Asistir Hoy',0),(36,'Obra Social Vida Segura',0),(37,'Obra Social Cuidarte',0),(38,'Obra Social MedCare',0),(39,'Obra Social Red Integral',0),(40,'Obra Social Grupo Salud',0),(41,'Obra Social Compromiso Médico',0),(42,'Obra Social Médicos Unidos',0),(43,'Obra Social Central de Salud',0),(44,'Obra Social Nueva Esperanza',0),(45,'Obra Social Vida y Bienestar',0),(46,'Obra Social Integral Médica',0),(47,'Obra Social Protege',0),(48,'Obra Social Salud Pública',0),(49,'Obra Social Futuro Protegido',0),(50,'Obra Social TotalMed',0),(51,'Obra Social Preventiva',0),(52,'Obra Social Esperanza Médica',0),(53,'Obra Social Sanadora',0),(54,'Obra Social MedPlus',0),(55,'Obra Social Cuidarnos',0),(56,'Obra Social Cooperativa de Salud',0),(57,'Obra Social Medic Solidaria',0),(58,'Obra Social ProSalud',0),(59,'Obra Social Pami Ficción',0),(60,'Obra Social OSP Argentina',0),(61,'Obra Social Médica del Norte',0),(62,'Obra Social Bienestar Total',0),(63,'Obra Social Vida Protegida',0),(64,'Obra Social Clínica Popular',0),(65,'Obra Social Médica de Barrio',0),(66,'Obra Social del Pueblo',0),(67,'Obra Social Popular Médica',0),(68,'Obra Social Proteger',0),(69,'Obra Social MedFamiliar',0),(70,'Obra Social Opción Salud',0),(71,'Obra Social Nueva Vida',0),(72,'Obra Social Familias Unidas',0),(73,'Obra Social Médico Federal',0),(74,'Obra Social Médica Popular',0),(75,'Obra Social Argentina Saludable',0),(76,'Obra Social Plenitud Médica',0),(77,'Obra Social Todos por la Salud',0),(78,'Obra Social CoSalud',0),(79,'Obra Social Centro Médico Familiar',0),(80,'Obra Social Círculo Médico Federal',0),(81,'Obra Social Solidaria Argentina',0),(82,'Obra Social Médica de la Sierra',0),(83,'Obra Social La Salud Primero',0),(84,'Obra Social Siempre Sanos',0),(85,'Obra Social Sanar es Vivir',0),(86,'Obra Social Red Familiar',0),(87,'Obra Social Salud Ya',0),(88,'Obra Social MedVida',0),(89,'Obra Social Médicos por Todos',0),(90,'Obra Social Asistencia Global',0),(91,'Obra Social Argentina Protegida',0),(92,'Obra Social Federal Vida',0),(93,'Obra Social Comunitaria Médica',0),(94,'Obra Social Unión Familiar',0),(95,'Obra Social Cuidado Total',0),(96,'Obra Social Salud Presente',0),(97,'Obra Social Siempre Contigo',0),(98,'Obra Social Jujuy Protege',0),(99,'Obra Social Santa María Salud',0),(100,'Obra Social Vida Plena Federal',0),(101,'Obra Social Horizonte Médico',0),(102,'Obra Social Proteger Argentina',0),(103,'Obra Social Viva la Salud',0),(104,'Obra Social Médico en Casa',0),(105,'IOSFA',0);
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
  `monto_pagado` float NOT NULL,
  `recargo` float DEFAULT '0',
  `periodo_mes` int DEFAULT NULL,
  `periodo_año` int DEFAULT NULL,
  `observacion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_pagos_tipo_pago1_idx` (`codigo_tipo_pago`),
  KEY `fk_pagos_inscripcion1_idx` (`codigo_inscripcion`),
  CONSTRAINT `fk_pagos_inscripcion1` FOREIGN KEY (`codigo_inscripcion`) REFERENCES `inscripcion` (`codigo`),
  CONSTRAINT `fk_pagos_tipo_pago1` FOREIGN KEY (`codigo_tipo_pago`) REFERENCES `tipo_pago` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagos`
--

LOCK TABLES `pagos` WRITE;
/*!40000 ALTER TABLE `pagos` DISABLE KEYS */;
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
  `borado` tinyint NOT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
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
  `codigo_modalidad_servicio` int NOT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `nombre` (`nombre`),
  KEY `fk_servicios_tipo_modalidad_pago1_idx` (`codigo_modalidad_servicio`),
  CONSTRAINT `fk_servicios_tipo_modalidad_pago1` FOREIGN KEY (`codigo_modalidad_servicio`) REFERENCES `modalidad_servicio` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicios`
--

LOCK TABLES `servicios` WRITE;
/*!40000 ALTER TABLE `servicios` DISABLE KEYS */;
INSERT INTO `servicios` VALUES (2,'Educación Temprana',35000,1),(3,'Apoyo Pedagógico',30000,1),(4,'Clases Personalizadas',6500,2),(5,'Inclusión Escolar: Acompañamiento',0,2),(6,'Inclusión Escolar: Itinerancia',80000,2);
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_pago`
--

LOCK TABLES `tipo_pago` WRITE;
/*!40000 ALTER TABLE `tipo_pago` DISABLE KEYS */;
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
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tutor`
--

LOCK TABLES `tutor` WRITE;
/*!40000 ALTER TABLE `tutor` DISABLE KEYS */;
INSERT INTO `tutor` VALUES (1,'ezequiel','cazon',12345678,'3888684916',0),(2,'mario albert','kempres',34567890,'1234',1),(3,'pablo','flores',432432,'11111111111',1),(4,'lionel','messi',10101010,'123423',0);
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

-- Dump completed on 2025-08-24 14:52:16
