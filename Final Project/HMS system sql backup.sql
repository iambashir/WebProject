-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.41-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema hospital_management_system
--

CREATE DATABASE IF NOT EXISTS hospital_management_system;
USE hospital_management_system;

--
-- Definition of table `add_service`
--

DROP TABLE IF EXISTS `add_service`;
CREATE TABLE `add_service` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `servicename` varchar(45) default NULL,
  `servicecode` varchar(45) default NULL,
  `fee` double default NULL,
  `duration` varchar(45) default NULL,
  `category` varchar(45) default NULL,
  `tax` double default NULL,
  `doctorcode` varchar(45) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `add_service`
--

/*!40000 ALTER TABLE `add_service` DISABLE KEYS */;
INSERT INTO `add_service` (`id`,`servicename`,`servicecode`,`fee`,`duration`,`category`,`tax`,`doctorcode`) VALUES 
 (8,'Blood Group Test','101',120,'00','Pathology',18,''),
 (9,'Ambulance 1','201',300,'Per hour','Ambulance',45,NULL),
 (10,'Dr. Mahbub Mansur','301',1500,'00','Doctor Visit',225,'201'),
 (11,'Dr. Md. Towhiduzzaman','302',1000,'00','Doctor Visit',150,'202'),
 (13,'Blood Culture Test','102',500,'','Pathology',75,''),
 (14,'CBC / Hemogram Test','103',800,'00','Pathology',120,''),
 (15,'DNA Test','104',1020,'00','Pathology',153,''),
 (16,'CRP (C-Reactive Protein) Test','105',620,'00','Pathology',93,'');
/*!40000 ALTER TABLE `add_service` ENABLE KEYS */;


--
-- Definition of table `appoinment_approved`
--

DROP TABLE IF EXISTS `appoinment_approved`;
CREATE TABLE `appoinment_approved` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `firstname` varchar(45) default NULL,
  `lastname` varchar(45) default NULL,
  `doctorname` varchar(45) default NULL,
  `mobile` varchar(45) default NULL,
  `date` date default NULL,
  `address` varchar(45) default NULL,
  `department` varchar(45) default NULL,
  `email` varchar(45) default NULL,
  `gender` varchar(45) default NULL,
  `branch` varchar(45) default NULL,
  `time` varchar(45) default NULL,
  `code` varchar(45) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `appoinment_approved`
--

/*!40000 ALTER TABLE `appoinment_approved` DISABLE KEYS */;
INSERT INTO `appoinment_approved` (`id`,`firstname`,`lastname`,`doctorname`,`mobile`,`date`,`address`,`department`,`email`,`gender`,`branch`,`time`,`code`) VALUES 
 (24,'Shamim','Hossain','Dr. Mahbub Mansur','1682498725','2020-08-27','Soniakhra','Cardiology','shamim@gmail.com','Male','Dhaka','10:00','201'),
 (25,'Roni','Hossain','Dr. Md. Towhiduzzaman','1685479858','2020-08-27','Kajla','Orthopedics','roni@gmail.com','Male','Dhaka','09:00','202'),
 (26,'Nusrat','Jahan','Dr. Mahbub Mansur','1758965878','2020-08-29','Gendaria','Cardiology','Nusrat@gmail.com','Female','Dhaka','10:21','201'),
 (28,'Abdul','Baten','Dr. Md. Towhiduzzaman','1732452541','2020-08-31','Golisthan','Orthopedics','Baten@gmail.com','Male','Dhaka','10:40','202'),
 (31,'Tipu','Sultan','Dr. Md. Towhiduzzaman','1452698745','2020-08-31','Rupgang','Orthopedics','tipu@gmail.com','Male','Dhaka','17:32','202'),
 (32,'Ashikur','Rahman','Dr. Md. Towhiduzzaman','1856988821','2020-09-10','Madhabdi','Orthopedics','ashikur@gmail.com','Male','Dhaka','09:45','202'),
 (37,'Md','Rahman','Dr. Mahbub Mansur','1452698745','2020-09-06','Narsingdi','Cardiology','rahman@gmail.com','Male','Dhaka','','201'),
 (38,'Roni','Hossain','Dr. Md. Towhiduzzaman','1685479858','2020-08-27','Kajla','Orthopedics','roni@gmail.com','Male','Dhaka','','202'),
 (39,'Roni','Hossain','Dr. Md. Towhiduzzaman','1685479858','2020-08-27','Kajla','Orthopedics','roni@gmail.com','Male','Dhaka','22:37','202');
/*!40000 ALTER TABLE `appoinment_approved` ENABLE KEYS */;


--
-- Definition of table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
CREATE TABLE `appointment` (
  `appointment_id` int(10) unsigned NOT NULL auto_increment,
  `firstname` varchar(45) default NULL,
  `lastname` varchar(45) default NULL,
  `doctorname` varchar(45) default NULL,
  `mobile` int(11) default NULL,
  `date` date default NULL,
  `time` varchar(45) default NULL,
  `address` varchar(45) default NULL,
  `department` varchar(45) default NULL,
  `email` varchar(45) default NULL,
  `gender` varchar(45) default NULL,
  `branch` varchar(45) default NULL,
  `code` varchar(45) default NULL,
  PRIMARY KEY  USING BTREE (`appointment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `appointment`
--

/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
INSERT INTO `appointment` (`appointment_id`,`firstname`,`lastname`,`doctorname`,`mobile`,`date`,`time`,`address`,`department`,`email`,`gender`,`branch`,`code`) VALUES 
 (80,'Shamim','Hossain','Dr. Mahbub Mansur',1682498725,'2020-08-27',NULL,'Soniakhra','Cardiology','shamim@gmail.com','Male','Dhaka','201'),
 (81,'Roni','Hossain','Dr. Md. Towhiduzzaman',1685479858,'2020-08-27',NULL,'Kajla','Orthopedics','roni@gmail.com','Male','Dhaka','202'),
 (82,'Nusrat','Jahan','Dr. Mahbub Mansur',1758965878,'2020-08-29',NULL,'Gendaria','Cardiology','Nusrat@gmail.com','Female','Dhaka','201'),
 (83,'Tipu','Sultan','Dr. Md. Towhiduzzaman',1452698745,'2020-08-31',NULL,'Rupgang','Orthopedics','tipu@gmail.com','Male','Dhaka','202'),
 (86,'Sajib','Mia','Dr. Md. Towhiduzzaman',1856988821,'2020-08-31',NULL,'Araihazar','Orthopedics','sajib@gmail.com','Male','Dhaka','202'),
 (87,'Shahina','Akter','Dr. Mahbub Mansur',16523456,'2020-08-31',NULL,'Golapbug','Cardiology','shahina@gmail.com','Female','Dhaka','201'),
 (88,'Ashikur','Rahman','Dr. Md. Towhiduzzaman',1856988821,'2020-09-10',NULL,'Madhabdi','Orthopedics','ashikur@gmail.com','Male','Dhaka','202'),
 (93,'Md','Rahman','Dr. Mahbub Mansur',1452698745,'2020-09-06',NULL,'Narsingdi','Cardiology','rahman@gmail.com','Male','Dhaka','201');
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;


--
-- Definition of table `audits`
--

DROP TABLE IF EXISTS `audits`;
CREATE TABLE `audits` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `action` varchar(45) default NULL,
  `time` varchar(45) default NULL,
  `date` date default NULL,
  `username` varchar(45) default NULL,
  `role` varchar(45) default NULL,
  `email` varchar(45) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `audits`
--

/*!40000 ALTER TABLE `audits` DISABLE KEYS */;
INSERT INTO `audits` (`id`,`action`,`time`,`date`,`username`,`role`,`email`) VALUES 
 (1,'save','10:10am','2020-08-10','admin','admin','nnakib78@gmail.com'),
 (2,'update','11:30am','2020-09-10','admin','admin','admin@gmail.com'),
 (3,'delete','9:15am','2020-09-12','admin','admin','admin@gmail.com');
/*!40000 ALTER TABLE `audits` ENABLE KEYS */;


--
-- Definition of table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
CREATE TABLE `invoice` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `firstname` varchar(45) default NULL,
  `lastname` varchar(45) default NULL,
  `mobile` int(10) unsigned default NULL,
  `address` varchar(45) default NULL,
  `email` varchar(45) default NULL,
  `gender` varchar(45) default NULL,
  `date` date default NULL,
  `time` varchar(45) default NULL,
  `branch` varchar(45) default NULL,
  `doctorname` varchar(45) default NULL,
  `department` varchar(45) default NULL,
  `code` varchar(45) default NULL,
  `servicename` varchar(45) default NULL,
  `servicecode` varchar(45) default NULL,
  `fee` double default NULL,
  `duration` varchar(45) default NULL,
  `category` varchar(45) default NULL,
  `tax` double default NULL,
  `status` varchar(45) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `invoice`
--

/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
INSERT INTO `invoice` (`id`,`firstname`,`lastname`,`mobile`,`address`,`email`,`gender`,`date`,`time`,`branch`,`doctorname`,`department`,`code`,`servicename`,`servicecode`,`fee`,`duration`,`category`,`tax`,`status`) VALUES 
 (7,'Shamim','Hossain',1682498725,'Soniakhra','shamim@gmail.com','Male','2020-08-27','10:00','Dhaka','Dr. Mahbub Mansur','Cardiology','201','Dr. Mahbub Mansur','301',1500,'00','Doctor Visit',225,'1'),
 (9,'Nusrat','Jahan',1758965878,'Gendaria','Nusrat@gmail.com','Female','2020-08-29','10:21','Dhaka','Dr. Mahbub Mansur','Cardiology','201','Dr. Mahbub Mansur','301',1500,'00','Doctor Visit',225,'1'),
 (11,'Shahina','Akter',16523456,'Golapbug','shahina@gmail.com','Female','2020-08-31','08:15','Dhaka','Dr. Mahbub Mansur','Cardiology','201','Dr. Mahbub Mansur','301',1500,'00','Doctor Visit',225,'1'),
 (18,'Roni','Hossain',1685479858,'Kajla','roni@gmail.com','Male','2020-08-27','09:00','Dhaka','Dr. Md. Towhiduzzaman','Orthopedics','202','Dr. Md. Towhiduzzaman','302',1000,'00','Doctor Visit',150,'1'),
 (19,'Ashikur','Rahman',1856988821,'Madhabdi','ashikur@gmail.com','Male','2020-09-10','09:45','Dhaka','Dr. Md. Towhiduzzaman','Orthopedics','202','Dr. Md. Towhiduzzaman','302',1000,'00','Doctor Visit',150,'1'),
 (24,'Md','Rahman',1452698745,'Narsingdi','rahman@gmail.com','Male','2020-09-06','','Dhaka','Dr. Mahbub Mansur','Cardiology','201','Dr. Mahbub Mansur','301',1500,'00','Doctor Visit',225,'1');
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;


--
-- Definition of table `invoice_total`
--

DROP TABLE IF EXISTS `invoice_total`;
CREATE TABLE `invoice_total` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `firstname` varchar(45) default NULL,
  `lastname` varchar(45) default NULL,
  `doctorname` varchar(45) default NULL,
  `date` date default NULL,
  `department` varchar(45) default NULL,
  `branch` varchar(45) default NULL,
  `category` varchar(45) default NULL,
  `servicename` varchar(45) default NULL,
  `fee` double default NULL,
  `tax` double default NULL,
  `total_bill` double default NULL,
  `invoice_code` varchar(45) default NULL,
  `time` time default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `invoice_total`
--

/*!40000 ALTER TABLE `invoice_total` DISABLE KEYS */;
INSERT INTO `invoice_total` (`id`,`firstname`,`lastname`,`doctorname`,`date`,`department`,`branch`,`category`,`servicename`,`fee`,`tax`,`total_bill`,`invoice_code`,`time`) VALUES 
 (110,'Md','Rahman','Dr. Mahbub Mansur','2020-09-06','Cardiology','Dhaka','Doctor Visit','Dr. Mahbub Mansur',1500,225,3956,'525565','06:00:00'),
 (111,'Md','Rahman','Dr. Mahbub Mansur','2020-09-06','Cardiology','Dhaka','Pathology','DNA Test',1020,153,3956,'525565','06:00:00'),
 (112,'Md','Rahman','Dr. Mahbub Mansur','2020-09-06','Cardiology','Dhaka','Ambulance','Ambulance 1',300,45,3956,'525565','06:00:00'),
 (113,'Md','Rahman','Dr. Mahbub Mansur','2020-09-06','Cardiology','Dhaka','Pathology','CRP (C-Reactive Protein) Test',620,93,3956,'525565','06:00:00');
/*!40000 ALTER TABLE `invoice_total` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `firstname` varchar(45) default NULL,
  `lastname` varchar(45) default NULL,
  `username` varchar(45) default NULL,
  `email` varchar(45) default NULL,
  `password` varchar(45) default NULL,
  `roleid` varchar(45) default NULL,
  `address` varchar(45) default NULL,
  `mobile` int(11) default NULL,
  `gender` varchar(45) default NULL,
  `date` date default NULL,
  `city` varchar(45) default NULL,
  `cnp` varchar(45) default NULL,
  `qualification` varchar(45) default NULL,
  `specialization` varchar(45) default NULL,
  `roleid1` varchar(45) default NULL,
  `roleid2` varchar(45) default NULL,
  `code` varchar(45) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`,`firstname`,`lastname`,`username`,`email`,`password`,`roleid`,`address`,`mobile`,`gender`,`date`,`city`,`cnp`,`qualification`,`specialization`,`roleid1`,`roleid2`,`code`) VALUES 
 (130,'Nazrul','Islam','admin','mansur@gmail.com','123','1','Bonani',1685789548,'','1986-02-11','','','','',NULL,NULL,'101'),
 (137,'Dr.','Mahbub Mansur','mahabubmansur','mansur@gmail.com','123','2','Bonani',1725789465,'Male','1988-06-27','Dhaka','abc','MBBS,BCS','Cardiology',NULL,NULL,'201'),
 (138,'Dr. Md.','Towhiduzzaman','towhiduzzaman','towhiduzzaman@gmail.com','123','2','Dhaka',1724589658,'Male','1988-01-27','Dhaka','abcd','MBBS,BCS','Medicine',NULL,NULL,'202'),
 (139,'Abdul','Korim','abdulkarim','korim@gmail.com','123','3','Narsingdi',1759684878,'Male','1990-01-01','Dhaka','FBC','MSS','Receptionist',NULL,NULL,'301');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
