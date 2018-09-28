-- MySQL dump 10.16  Distrib 10.1.19-MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: localhost
-- ------------------------------------------------------
-- Server version	10.1.19-MariaDB

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
-- Table structure for table `articulo`
--

DROP TABLE IF EXISTS `articulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `articulo` (
  `ID_ART` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PROV` int(11) DEFAULT NULL,
  `NRO_ART` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DESCRIPCION_ART` varchar(40) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ESPECIFICACIONES_ART` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `FABRICANTE_ART` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `UNIDADMEDIDA_ART` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  `COSTOESTANDAR_ART` float DEFAULT NULL,
  `MAXIMO_ART` float DEFAULT NULL,
  `PUNTOREORDEN_ART` float DEFAULT NULL,
  `CANTIDADREORDEN_ART` float DEFAULT NULL,
  `MINIMO_ART` float DEFAULT NULL,
  `TIEMPOENTR_NRODIAS_ART` int(11) DEFAULT NULL,
  `NOTAS_ART` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `CANTIDAD_ART` float DEFAULT NULL,
  `DESCCANTIDAD_ART` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ACTIVO` int(11) DEFAULT '1',
  PRIMARY KEY (`ID_ART`),
  KEY `FK_PROV_ART` (`ID_PROV`),
  CONSTRAINT `FK_PROV_ART` FOREIGN KEY (`ID_PROV`) REFERENCES `proveedor` (`ID_PROV`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articulo`
--

LOCK TABLES `articulo` WRITE;
/*!40000 ALTER TABLE `articulo` DISABLE KEYS */;
INSERT INTO `articulo` VALUES (1,1,'ART001','Caneca de Aceite','Aceite máquinas industriales','Na','Caneca',200,1000,300,500,200,6,'na',50,'Litros',1);
/*!40000 ALTER TABLE `articulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departamento` (
  `ID_DEPT` int(11) NOT NULL AUTO_INCREMENT,
  `NRO_DEPT` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DESCRIPCION_DEPT` varchar(40) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ACTIVO` int(11) DEFAULT '1',
  PRIMARY KEY (`ID_DEPT`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (1,'DEP_SIS','Departamento de Sistemas',1),(2,'DEP_FIN','Departamento de Finanzas',1),(3,'DEP_VENT','Departamento de Ventas',1);
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp_mant`
--

DROP TABLE IF EXISTS `emp_mant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emp_mant` (
  `ID_MANT` int(11) NOT NULL,
  `ID_EMP` int(11) NOT NULL,
  PRIMARY KEY (`ID_MANT`,`ID_EMP`),
  KEY `FK_EMP_MANT2` (`ID_EMP`),
  CONSTRAINT `FK_EMP_MANT` FOREIGN KEY (`ID_MANT`) REFERENCES `mantenimiento` (`ID_MANT`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_EMP_MANT2` FOREIGN KEY (`ID_EMP`) REFERENCES `empleado` (`ID_EMP`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp_mant`
--

LOCK TABLES `emp_mant` WRITE;
/*!40000 ALTER TABLE `emp_mant` DISABLE KEYS */;
INSERT INTO `emp_mant` VALUES (1,1),(1,2);
/*!40000 ALTER TABLE `emp_mant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp_mant2`
--

DROP TABLE IF EXISTS `emp_mant2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emp_mant2` (
  `ID_MANT2` int(11) DEFAULT NULL,
  `ID_EMP2` int(11) DEFAULT NULL,
  `CAMBIO` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp_mant2`
--

LOCK TABLES `emp_mant2` WRITE;
/*!40000 ALTER TABLE `emp_mant2` DISABLE KEYS */;
INSERT INTO `emp_mant2` VALUES (1,1,0),(1,2,0),(1,1,0),(1,1,0),(1,2,0),(1,1,1),(1,1,0),(1,1,1),(1,2,1),(1,1,2),(1,2,2);
/*!40000 ALTER TABLE `emp_mant2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleado` (
  `ID_EMP` int(11) NOT NULL AUTO_INCREMENT,
  `ID_DEPT` int(11) DEFAULT NULL,
  `NRO_EMP` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `NOMBRE_EMP` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `APELLIDO_EMP` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `POSICION_EMP` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `EXTENSION_EMP` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `TELFTRAB_EMP` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  `TELFPERS_EMP` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  `TELFCASA_EMP` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  `EMAIL_EMP` varchar(40) COLLATE utf8_spanish_ci DEFAULT NULL,
  `EMAIL2_EMP` varchar(40) COLLATE utf8_spanish_ci DEFAULT NULL,
  `LOCACIONOFICINA_EMP` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `SUELDO_EMP` float DEFAULT NULL,
  `SOBRETIEMPO_EMP` float DEFAULT NULL,
  `ACTIVO` int(11) DEFAULT '1',
  PRIMARY KEY (`ID_EMP`),
  KEY `FK_DEPT_EMP` (`ID_DEPT`),
  CONSTRAINT `FK_DEPT_EMP` FOREIGN KEY (`ID_DEPT`) REFERENCES `departamento` (`ID_DEPT`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (1,1,'EMP001','Jhonny','Cajamarca','Especialista TICS','314','0989097643','0987077325','023170481','jho.cjtb72@gmail.com','jocajamarca@espe.edu.ec','Av. Eloy Alfaro y Flores',450.5,22,1),(2,1,'EMP002','Ricardo','Herrera','Diseñador gráfico','234','094578967','0968765743','02344574','ricardo@gmail.com','ricardo@hotmail.com','Quito, Obrero Independiente',450.5,22,1);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipo`
--

DROP TABLE IF EXISTS `equipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipo` (
  `ID_EQ` int(11) NOT NULL AUTO_INCREMENT,
  `ID_LOCT` int(11) DEFAULT NULL,
  `ID_EMP` int(11) DEFAULT NULL,
  `IDPADRE_EQ` int(11) DEFAULT NULL,
  `NRO_EQ` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DESCRIPCION_EQ` varchar(40) COLLATE utf8_spanish_ci DEFAULT NULL,
  `NROMODELO_EQ` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `NROSERIE_EQ` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `TIPO_EQ` varchar(40) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ESTADO_EQ` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  `FABRICANTE_EQ` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `FECHACOMPRA_EQ` date DEFAULT NULL,
  `FECHAINI_EQ` date DEFAULT NULL,
  `FECHAVEN_EQ` date DEFAULT NULL,
  `CONTRATISTA_EQ` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `PIEZAS_EQ` varchar(500) COLLATE utf8_spanish_ci DEFAULT NULL,
  `FOTO_EQ` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ACTIVO` int(11) DEFAULT '1',
  PRIMARY KEY (`ID_EQ`),
  KEY `FK_EMP_EQ` (`ID_EMP`),
  KEY `FK_LOC_EQ` (`ID_LOCT`),
  KEY `FK_PADRE_HIJO` (`IDPADRE_EQ`),
  CONSTRAINT `FK_EMP_EQ` FOREIGN KEY (`ID_EMP`) REFERENCES `empleado` (`ID_EMP`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_LOC_EQ` FOREIGN KEY (`ID_LOCT`) REFERENCES `locacion` (`ID_LOCT`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_PADRE_HIJO` FOREIGN KEY (`IDPADRE_EQ`) REFERENCES `equipo` (`ID_EQ`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipo`
--

LOCK TABLES `equipo` WRITE;
/*!40000 ALTER TABLE `equipo` DISABLE KEYS */;
INSERT INTO `equipo` VALUES (0,NULL,NULL,NULL,NULL,'EQUIPO PADRE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(2,1,1,0,'EQ001','Equipo industrial pesado','eq00a','aaa3323','Equipo industrial','Activo','Pionx','2014-02-01','2016-02-01','2018-02-01','Ricardo','p1;p2;p3','c\\.....',1),(3,1,1,0,'EQ002','Equipo mecánico liviano','eeeerrr','12321321','Equipo mecánico','Activo','Pionx','2014-02-01','2014-02-01','2014-02-01','na','na','na',1),(4,2,1,0,'EQ003','Equipo eléctrico manual','eeeerrr','12321321','Equipo eléctrico','Activo','Pionx','2014-02-01','2014-02-01','2014-02-01','na','na','na',1),(5,1,1,2,'EQ004','Montacargas 10 ton.','ddsad','dsadsa','Montacargas pesado','Activo','na','2010-01-01','2010-01-01','2010-01-01','na','na','na',1),(6,2,1,3,'EQ005','Levanta Autos','hgytewtr','wqegrd','Eq. lev autos','Activo','das','2010-01-01','2010-01-01','2010-01-01','na','na','na',1),(7,1,1,4,'EQ006','Comprensor bomba','cccccsa','dffs4','Comprensor grande','Activo','na','2010-01-01','2010-01-01','2010-01-01','na','nna','b',1),(8,1,1,7,'EQ007','Comprensor g1','sdafgf','g','c1','Activo','na','2010-01-01','2010-01-01','2010-01-01','na','na','na',1),(9,1,1,7,'EQ016','Caldero baño','dsfk','fg','g2','Activo','na','2010-01-01','2010-01-01','2010-01-01','na','na','na',1),(10,1,1,8,'EQ009','Comprensor sub g1','das','fasd','Sg1','Activo','na','2010-01-01','2010-01-01','2010-01-01','na','na','na',1),(11,1,1,0,'EQ010','Caldero Gas','wretr','ythrh','Caldero grande','Activo','na','2010-01-01','2010-01-01','2010-01-01','na','na','na',1),(12,1,1,0,'EQ011','Ensambladora pcs','sdaf','fsd','Ensambla portátiles','Activo','na','2010-01-01','2010-01-01','2010-01-01','na','na','na',1),(13,1,1,12,'EQ012','Ensambla Carcasas','dsa','sadda','carcasas','na','na','2010-01-01','2010-01-01','2010-01-01','ba','ba','na',1),(14,1,1,9,'EQ013','Comprensor sub g2','DSAFS','FDS','Comprensor sub g2','NA','na','2009-01-01','2009-01-01','2009-01-01','na','na','na',1),(15,1,1,4,'EQ014','Soldadora E','das','da','sss','na','na','2009-01-01','2009-01-01','2009-01-01','na','na','na',1),(16,2,1,0,'EQ015','Martilladora','dsaf','fd','Martilladora','na','na','2008-01-01','2008-01-01','2008-01-01','na','na','na',1),(17,1,1,0,'EQ016','Caldero baño','SFD','GD','CALD','Ac','na','2008-01-01','2008-01-01','2008-01-01','na','na','na',1);
/*!40000 ALTER TABLE `equipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instr_mant`
--

DROP TABLE IF EXISTS `instr_mant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instr_mant` (
  `ID_MANT` int(11) NOT NULL,
  `ID_INST` int(11) NOT NULL,
  PRIMARY KEY (`ID_MANT`,`ID_INST`),
  KEY `FK_INSTR_MANT2` (`ID_INST`),
  CONSTRAINT `FK_INSTR_MANT` FOREIGN KEY (`ID_MANT`) REFERENCES `mantenimiento` (`ID_MANT`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_INSTR_MANT2` FOREIGN KEY (`ID_INST`) REFERENCES `instruccion` (`ID_INST`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instr_mant`
--

LOCK TABLES `instr_mant` WRITE;
/*!40000 ALTER TABLE `instr_mant` DISABLE KEYS */;
INSERT INTO `instr_mant` VALUES (1,5);
/*!40000 ALTER TABLE `instr_mant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instr_mant2`
--

DROP TABLE IF EXISTS `instr_mant2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instr_mant2` (
  `ID_MANT2` int(11) NOT NULL,
  `ID_INST2` int(11) DEFAULT NULL,
  `CAMBIO` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instr_mant2`
--

LOCK TABLES `instr_mant2` WRITE;
/*!40000 ALTER TABLE `instr_mant2` DISABLE KEYS */;
INSERT INTO `instr_mant2` VALUES (1,1,0),(1,2,0),(1,3,0),(1,1,0),(1,2,0),(1,3,0),(1,5,0),(1,1,0),(1,2,0),(1,3,0),(1,4,0),(1,5,0),(1,2,1),(1,3,1),(1,4,1),(1,5,1),(1,2,0),(1,3,0),(1,4,0),(1,5,0),(1,5,1),(1,5,2);
/*!40000 ALTER TABLE `instr_mant2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instruccion`
--

DROP TABLE IF EXISTS `instruccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instruccion` (
  `ID_INST` int(11) NOT NULL AUTO_INCREMENT,
  `NRO_INST` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DESCRIPCION_INST` varchar(40) COLLATE utf8_spanish_ci DEFAULT NULL,
  `HORAS_INST` float DEFAULT NULL,
  `NOTAS_INST` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ACTIVO` int(11) DEFAULT '1',
  PRIMARY KEY (`ID_INST`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instruccion`
--

LOCK TABLES `instruccion` WRITE;
/*!40000 ALTER TABLE `instruccion` DISABLE KEYS */;
INSERT INTO `instruccion` VALUES (1,'INST01','Instruccion 1',1,'na',1),(2,'INST02','Instruccion 2',2,'na',1),(3,'INST03','Instruccion 3',3,'na',1),(4,'INST04','Instruccion 4',4,'na',1),(5,'INST05','Instruccion 5',5,'na',1);
/*!40000 ALTER TABLE `instruccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locacion`
--

DROP TABLE IF EXISTS `locacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `locacion` (
  `ID_LOCT` int(11) NOT NULL AUTO_INCREMENT,
  `ID_DEPT` int(11) DEFAULT NULL,
  `NRO_LOCT` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DESCRIPCION_LOCT` varchar(40) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ACTIVO` int(11) DEFAULT '1',
  PRIMARY KEY (`ID_LOCT`),
  KEY `FK_DEPT_LOCT` (`ID_DEPT`),
  CONSTRAINT `FK_DEPT_LOCT` FOREIGN KEY (`ID_DEPT`) REFERENCES `departamento` (`ID_DEPT`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locacion`
--

LOCK TABLES `locacion` WRITE;
/*!40000 ALTER TABLE `locacion` DISABLE KEYS */;
INSERT INTO `locacion` VALUES (1,1,'LOC_QUI','Locación Quito',1),(2,2,'LOC_GYQ','Locación Guayaquil',1);
/*!40000 ALTER TABLE `locacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mantenimiento`
--

DROP TABLE IF EXISTS `mantenimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mantenimiento` (
  `ID_MANT` int(11) NOT NULL AUTO_INCREMENT,
  `ID_EQ` int(11) DEFAULT NULL,
  `ID_LOCT` int(11) DEFAULT NULL,
  `NROTAREA_MANT` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DESCRIPCION_MANT` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `OFICIO_MANT` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `FRECUENCIA_MANT` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DIAS_MANT` int(11) DEFAULT NULL,
  `DURACIONTAREA_MANT` int(11) DEFAULT NULL,
  `FECHAINICIO_MANT` date DEFAULT NULL,
  `FECHAPROGRAMADAINICIO_MANT` date DEFAULT NULL,
  `FECHAPROGRAMADATERMINO_MANT` date DEFAULT NULL,
  `PROXIMAFECHA_MANT` date DEFAULT NULL,
  `HORASPROGRAMADAS_MANT` float DEFAULT NULL,
  `ACTIVO` int(11) DEFAULT '1',
  PRIMARY KEY (`ID_MANT`),
  KEY `FK_EQ_MANT` (`ID_EQ`),
  KEY `FK_LOA_MANT` (`ID_LOCT`),
  CONSTRAINT `FK_EQ_MANT` FOREIGN KEY (`ID_EQ`) REFERENCES `equipo` (`ID_EQ`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_LOA_MANT` FOREIGN KEY (`ID_LOCT`) REFERENCES `locacion` (`ID_LOCT`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mantenimiento`
--

LOCK TABLES `mantenimiento` WRITE;
/*!40000 ALTER TABLE `mantenimiento` DISABLE KEYS */;
INSERT INTO `mantenimiento` VALUES (1,2,NULL,'tarea1','Mantenimiento Preventivo','Mecánico','mensual',30,12,'2009-01-01','2009-01-01','2009-01-01','2009-01-01',1000,1);
/*!40000 ALTER TABLE `mantenimiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mantenimiento2`
--

DROP TABLE IF EXISTS `mantenimiento2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mantenimiento2` (
  `ID_MANT2` int(11) NOT NULL,
  `ID_USU` int(11) DEFAULT NULL,
  `ID_EQ2` int(11) DEFAULT NULL,
  `ID_LOCT2` int(11) DEFAULT NULL,
  `NROTAREA_MANT2` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DESCRIPCION_MANT2` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `OFICIO_MANT2` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `FRECUENCIA_MANT2` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DIAS_MANT2` int(11) DEFAULT NULL,
  `DURACIONTAREA_MANT2` int(11) DEFAULT NULL,
  `FECHAINICIO_MANT2` date DEFAULT NULL,
  `FECHAPROGRAMADAINICIO_MANT2` date DEFAULT NULL,
  `FECHAPROGRAMADATERMINI_MANT2` date DEFAULT NULL,
  `PROXIMAFECHA_MANT2` date DEFAULT NULL,
  `HORACAMBIO_MANT2` datetime DEFAULT NULL,
  `ACTIVO` int(11) DEFAULT '1',
  KEY `FK_USU_MANT2` (`ID_USU`),
  CONSTRAINT `FK_USU_MANT2` FOREIGN KEY (`ID_USU`) REFERENCES `usuario` (`ID_USU`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mantenimiento2`
--

LOCK TABLES `mantenimiento2` WRITE;
/*!40000 ALTER TABLE `mantenimiento2` DISABLE KEYS */;
INSERT INTO `mantenimiento2` VALUES (1,1,16,NULL,'tarea1','Mantenimiento Preventivo','Mecánico','mensual',30,12,'2009-01-01','2009-01-01','2009-01-01','2009-01-01','2018-08-21 02:13:39',1),(1,1,16,NULL,'tarea1','Mantenimiento Preventivo','Mecánico','mensual',30,12,'2009-01-01','2009-01-01','2009-01-01','2009-01-01','2018-08-21 02:16:13',1),(1,1,16,NULL,'tarea1','Mantenimiento Preventivo','Mecánico','mensual',30,12,'2009-01-01','2009-01-01','2009-01-01','2009-01-01','2018-08-21 02:19:45',1),(1,1,2,NULL,'tarea1','Mantenimiento Preventivo','Mecánico','mensual',30,12,'2009-01-01','2009-01-01','2009-01-01','2009-01-01','2018-08-21 02:19:45',1),(1,1,2,NULL,'tarea1','Mantenimiento Preventivo','Mecánico','mensual',30,12,'2009-01-01','2009-01-01','2009-01-01','2009-01-01','2018-08-21 02:21:56',1),(1,1,2,NULL,'tarea1','Mantenimiento Preventivo','Mecánico','mensual',30,12,'2009-01-01','2009-01-01','2009-01-01','2009-01-01','2018-08-21 02:21:56',1),(1,1,2,NULL,'tarea1','Mantenimiento Preventivo','Mecánico','mensual',30,12,'2009-01-01','2009-01-01','2009-01-01','2009-01-01','2018-08-21 02:22:15',1);
/*!40000 ALTER TABLE `mantenimiento2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordentrabajo`
--

DROP TABLE IF EXISTS `ordentrabajo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordentrabajo` (
  `ID_ORDTR` int(11) NOT NULL AUTO_INCREMENT,
  `ID_MANT` int(11) DEFAULT NULL,
  `NRO_ORDTR` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DESCRIPCION_ORDTR` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ESTADO_ORDTR` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  `TIPO_ORDTR` varchar(25) COLLATE utf8_spanish_ci DEFAULT NULL,
  `PRIORIDAD_ORDTR` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  `FECHAHORASOLICITUD_ORDTR` datetime DEFAULT NULL,
  `FECHAHORAREQUERIDA_ORDTR` datetime DEFAULT NULL,
  `RESPUESTA_ORDTR` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `INICIO_ORDTR` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `TERMINO_ORDTR` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `FECHAHORAENTREGA_ORDTR` datetime DEFAULT NULL,
  `DURACIONDIAS_ORDTR` float DEFAULT NULL,
  `ACEPTADOPOR_ORDTR` varchar(40) COLLATE utf8_spanish_ci DEFAULT NULL,
  `FALLA_ORDTR` varchar(60) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DESCRIPCIONCAUSA_ORDTR` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ACCIONREALIZADA_ORDTR` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `PREVENCIONTOMADA_ORDTR` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ACTIVO` int(11) DEFAULT '1',
  PRIMARY KEY (`ID_ORDTR`),
  KEY `FK_MAN_ORD` (`ID_MANT`),
  CONSTRAINT `FK_MAN_ORD` FOREIGN KEY (`ID_MANT`) REFERENCES `mantenimiento` (`ID_MANT`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordentrabajo`
--

LOCK TABLES `ordentrabajo` WRITE;
/*!40000 ALTER TABLE `ordentrabajo` DISABLE KEYS */;
/*!40000 ALTER TABLE `ordentrabajo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordentrabajo2`
--

DROP TABLE IF EXISTS `ordentrabajo2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordentrabajo2` (
  `ID_ORDTR2` int(11) NOT NULL,
  `ID_USU2` int(11) DEFAULT NULL,
  `ID_MANT2` int(11) DEFAULT NULL,
  `NRO_ORDTR2` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DESCRIPCION_ORDTR2` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ESTADO_ORDTR2` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  `TIPO_ORDTR2` varchar(25) COLLATE utf8_spanish_ci DEFAULT NULL,
  `PRIORIDAD_ORDTR2` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  `FECHAHORASOLICITUD_ORDTR2` datetime DEFAULT NULL,
  `FECHAHORAREQUERIDA_ORDTR2` datetime DEFAULT NULL,
  `RESPUESTA_ORDTR2` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `INICIO_ORDTR2` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `TERMINO_ORDTR2` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `FECHAHORAENTREGA_ORDTR2` datetime DEFAULT NULL,
  `DURACIONDIAS_ORDTR2` float DEFAULT NULL,
  `ACEPTADOPOR_ORDTR2` varchar(40) COLLATE utf8_spanish_ci DEFAULT NULL,
  `FALLA_ORDTR2` varchar(60) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DESCRIPCIONCAUSA_ORDTR2` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ACCIONREALIZADA_ORDTR2` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `PREVENCIONTOMADA_ORDTR2` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `HORACAMBIO_ORDTR2` datetime DEFAULT NULL,
  `ACTIVO` int(11) DEFAULT '1',
  KEY `FK_RELATIONSHIP_22` (`ID_USU2`),
  CONSTRAINT `FK_RELATIONSHIP_22` FOREIGN KEY (`ID_USU2`) REFERENCES `usuario` (`ID_USU`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordentrabajo2`
--

LOCK TABLES `ordentrabajo2` WRITE;
/*!40000 ALTER TABLE `ordentrabajo2` DISABLE KEYS */;
/*!40000 ALTER TABLE `ordentrabajo2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedor` (
  `ID_PROV` int(11) NOT NULL AUTO_INCREMENT,
  `NRO_PROV` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `NOMBRE_PROV` varchar(25) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DIRECCION_PROV` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `CIUDAD_PROV` varchar(25) COLLATE utf8_spanish_ci DEFAULT NULL,
  `FAX_PROV` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `TELEFONO_PROV` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  `EMAIL_RPOV` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ACTIVO` int(11) DEFAULT '1',
  PRIMARY KEY (`ID_PROV`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES (1,'PROV01','Lubrindustriales','Av. Eloy Alfaro','Quito','lubri@gmail.com','0988756473','lubri@hotmail.com',1);
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `secuencia`
--

DROP TABLE IF EXISTS `secuencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `secuencia` (
  `ID_SEC` int(11) NOT NULL AUTO_INCREMENT,
  `ID_INST` int(11) DEFAULT NULL,
  `NRO_SEC` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DESCRIPCION_SEC` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ACTIVO` int(11) DEFAULT '1',
  PRIMARY KEY (`ID_SEC`),
  KEY `FK_INST_SEC` (`ID_INST`),
  CONSTRAINT `FK_INST_SEC` FOREIGN KEY (`ID_INST`) REFERENCES `instruccion` (`ID_INST`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `secuencia`
--

LOCK TABLES `secuencia` WRITE;
/*!40000 ALTER TABLE `secuencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `secuencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `ID_USU` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE_USU` varchar(25) COLLATE utf8_spanish_ci DEFAULT NULL,
  `APELLIDO_USU` varchar(25) COLLATE utf8_spanish_ci DEFAULT NULL,
  `PREGUNTA1_USU` varchar(25) COLLATE utf8_spanish_ci DEFAULT NULL,
  `PREGUNTA2_USU` varchar(25) COLLATE utf8_spanish_ci DEFAULT NULL,
  `USUARIO_USU` varchar(60) COLLATE utf8_spanish_ci DEFAULT NULL,
  `PASSWORD_USU` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ACTIVO` int(11) DEFAULT '1',
  PRIMARY KEY (`ID_USU`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Jhonny','Cajamarca','amarillo','rodriguez','jhonny.cajamarca1','fc72920d80bd9e3c67a80813eb2f1f58',1),(2,'Pablo','Maldonado','rojo','andrade','pablo.maldonado2','c99331028bad9372f1657ef19eb5de82',1);
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

-- Dump completed on 2018-09-24 16:54:14
