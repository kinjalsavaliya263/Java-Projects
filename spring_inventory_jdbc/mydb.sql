/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.0-m2-community : Database - spring_inventory
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`spring_inventory` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `spring_inventory`;

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `cid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cname` varchar(45) NOT NULL,
  `phone` varchar(11) NOT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `customer` */

insert  into `customer`(`cid`,`cname`,`phone`) values (9,'Kishor Kadam','7276763516'),(10,'Sagar Kharmale','9856324517');

/*Table structure for table `orderdetails` */

DROP TABLE IF EXISTS `orderdetails`;

CREATE TABLE `orderdetails` (
  `odid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `oid` int(10) unsigned NOT NULL,
  `pid` int(10) unsigned NOT NULL,
  `price` double NOT NULL,
  `qty` int(10) unsigned NOT NULL,
  PRIMARY KEY (`odid`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

/*Data for the table `orderdetails` */

insert  into `orderdetails`(`odid`,`oid`,`pid`,`price`,`qty`) values (1,1,1,500,1),(2,0,0,0,0),(3,2,2,700,10),(4,1,4,700,2),(5,1,1,500,1),(6,1,1,500,2),(7,2,8,1600,10),(8,3,1,500,10),(9,3,1,500,10),(10,4,1,500,10),(11,5,9,300,10),(12,6,9,300,10),(13,7,9,300,10),(14,7,8,1600,10),(15,8,1,500,200),(16,9,1,500,1),(17,9,4,700,2),(18,10,1,500,1),(19,11,1,500,2),(20,12,1,500,6),(21,13,1,500,1),(22,13,1,500,11),(23,14,1,500,18800),(24,14,1,500,9),(25,16,1,500,12),(26,17,1,500,88),(27,18,1,500,0),(28,19,1,500,1),(29,20,1,500,1),(30,21,1,500,2),(31,22,1,500,2),(32,23,1,500,1),(33,24,1,500,1),(34,25,1,500,1),(35,26,10,5500,1),(36,26,9,300,1),(37,27,4,700,2),(38,27,1,500,1),(39,28,5,15000,1),(40,28,1,500,1),(41,29,7,76000,1),(42,29,1,500,4),(43,29,8,1600,1),(44,30,1,500,5),(45,31,7,76000,14),(46,32,6,4000,5),(47,33,9,300,1),(48,34,5,15000,1);

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `oid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cid` int(10) unsigned NOT NULL,
  `total` double NOT NULL,
  `orderType` varchar(45) NOT NULL,
  `orderDate` date NOT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

/*Data for the table `orders` */

insert  into `orders`(`oid`,`cid`,`total`,`orderType`,`orderDate`) values (1,1,1000,'sell','2017-09-19'),(2,6,166000,'sell','2017-09-01'),(3,1,5000,'sell','2017-09-21'),(4,1,5000,'sell','2017-09-19'),(5,2,3000,'sell','2017-09-30'),(6,4,19000,'sell','2017-09-20'),(7,3,19000,'sell','2017-09-01'),(8,1,100000,'purchase','2017-09-27'),(9,1,1900,'sell','2017-09-01'),(10,1,500,'sell','2017-09-01'),(11,1,1000,'sell','2017-09-01'),(12,2,3000,'sell','2017-09-19'),(13,1,5500,'purchase','2017-09-19'),(14,1,9400000,'sell','2017-09-19'),(15,1,4500,'purchase','2017-09-19'),(16,1,6000,'purchase','2017-09-19'),(17,1,44000,'purchase','2017-09-19'),(18,0,0,'sell','2017-09-20'),(19,0,500,'sell','2017-09-20'),(20,1,500,'sell','2017-09-20'),(21,1,1000,'sell','2017-09-20'),(22,2,1000,'sell','2017-09-20'),(23,1,500,'sell','2017-09-20'),(24,1,500,'sell','2017-09-20'),(25,1,500,'sell','2017-09-20'),(26,7,5800,'sell','2017-09-15'),(27,1,1900,'sell','2017-09-22'),(28,1,15500,'sell','2017-09-24'),(29,1,79600,'sell','2017-09-30'),(30,2,6500,'sell','2017-10-11'),(31,9,1064000,'purchase','2018-09-25'),(32,4,20000,'purchase','2018-09-25'),(33,9,300,'sell','2018-10-14'),(34,10,15000,'purchase','2018-10-14');

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `pid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `pname` varchar(45) NOT NULL,
  `price` double NOT NULL,
  `qty` int(10) unsigned NOT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `product` */

insert  into `product`(`pid`,`pname`,`price`,`qty`) values (1,'shirt',500,80),(4,'pant',700,16),(5,'mobile',15000,50),(6,'sunglass',4000,45),(7,'laptop',76000,93),(8,'bag',1600,189),(9,'mouse',300,118),(10,'hdd',5500,119),(11,'Mouse',300,10);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `userId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `users` */

insert  into `users`(`userId`,`userName`,`email`,`password`) values (1,'admin','admin@gmail.com','1234');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
