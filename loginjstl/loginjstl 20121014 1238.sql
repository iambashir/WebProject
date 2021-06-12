
CREATE DATABASE IF NOT EXISTS jstlcrud;
USE jstlcrud;


DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `pname` varchar(45) NOT NULL,
  `quantity` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `product` (`id`,`pname`,`quantity`) VALUES
 (1,'Mouse',30),
 (2,'Keyboard',5),
 (3,'Monitor',34);

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `users` (`id`,`username`,`password`) VALUES
 (1,'user','123'),
 (2,'admin','111');