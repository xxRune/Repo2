-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 18, 2018 at 08:03 PM
-- Server version: 5.7.19
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `albaniatravel`
--

-- --------------------------------------------------------

--
-- Table structure for table `categ`
--

DROP TABLE IF EXISTS `categ`;
CREATE TABLE IF NOT EXISTS `categ` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `categ`
--

INSERT INTO `categ` (`id`, `name`) VALUES
(1, 'City'),
(2, 'Village'),
(3, 'Tourist Point');

-- --------------------------------------------------------

--
-- Table structure for table `descri`
--

DROP TABLE IF EXISTS `descri`;
CREATE TABLE IF NOT EXISTS `descri` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `de` varchar(1500) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `descri`
--

INSERT INTO `descri` (`id`, `de`) VALUES
(1, '\"Albania Travel\" is an application that made to help its users find touristic spots to visit based entirely on their own criteria. The application is very simple to use and this is exactly it\'s strong point. The user can select different tags from a list (and category of places), the software will process the information and then display a list of toursim spot that fulfill the user previous selected criteria. ');

-- --------------------------------------------------------

--
-- Table structure for table `places`
--

DROP TABLE IF EXISTS `places`;
CREATE TABLE IF NOT EXISTS `places` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `category` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `posURL` varchar(200) NOT NULL,
  `plc_fk` int(5) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `plc_fk` (`plc_fk`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `places`
--

INSERT INTO `places` (`id`, `category`, `name`, `posURL`, `plc_fk`) VALUES
(1, 'City', 'Tirane', 'https://www.google.com/maps/place/Tirana,+Albania/@41.3310413,19.7828038,13z/data=!3m1!4b1!4m5!3m4!1s0x1350310470fac5db:0x40092af10653720!8m2!3d41.3275459!4d19.8186982', 1),
(2, 'City', 'Durres', 'https://www.google.com/maps/place/Durr%C3%ABs,+Albania/@41.3313949,19.4313379,13z/data=!3m1!4b1!4m5!3m4!1s0x134fd97c5fbbbcc7:0x77f377eae6cd81ee!8m2!3d41.3245904!4d19.4564686', 1),
(3, 'Village', 'Valbona Valley', 'https://www.google.com/maps/place/Valbona+Valley+National+Park/@42.4258685,19.9236793,17z/data=!3m1!4b1!4m5!3m4!1s0x1352429cf2d8ef07:0x9792c5b26d99a589!8m2!3d42.4258646!4d19.925868', 2),
(4, 'Village', 'Voskopoj', 'https://www.google.com/maps/place/Voskopoj%C3%AB,+Albania/@40.6319402,20.5809759,15z/data=!3m1!4b1!4m5!3m4!1s0x135a766688c1c12b:0x231668987d97e538!8m2!3d40.6335639!4d20.5885853', 2),
(5, 'Tourist Point', 'Albanian Riviera', 'https://www.google.com/maps/place/Dhermi+Beach/@40.1415863,19.6373749,17z/data=!3m1!4b1!4m5!3m4!1s0x135b2b8ac84d3775:0x92fb0751199900ef!8m2!3d40.1415822!4d19.6395636', 3),
(6, 'Tourist Point', 'Apollonia', 'https://www.google.com/maps/place/Apollonia+Archaeological+Park/@40.7219247,19.4705742,17z/data=!3m1!4b1!4m5!3m4!1s0x134551ff9d67761d:0x8ffa6f789cdcdc2e!8m2!3d40.7219207!4d19.4727629', 3),
(7, 'City', 'Sarande', 'https://www.google.com/maps/place/Sarand%C3%AB,+Albania/@39.8673863,19.9890447,14z/data=!3m1!4b1!4m5!3m4!1s0x135b14ffafac5431:0xd6d55e7e08a21910!8m2!3d39.8592119!4d20.0271001', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tgs`
--

DROP TABLE IF EXISTS `tgs`;
CREATE TABLE IF NOT EXISTS `tgs` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `id_fk` int(5) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_fk` (`id_fk`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tgs`
--

INSERT INTO `tgs` (`id`, `name`, `id_fk`) VALUES
(1, 'Beach', 2),
(4, 'Club', 1),
(5, 'Historical', 6);

-- --------------------------------------------------------

--
-- Table structure for table `usr`
--

DROP TABLE IF EXISTS `usr`;
CREATE TABLE IF NOT EXISTS `usr` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `role` int(2) NOT NULL,
  `name` varchar(20) NOT NULL,
  `surname` varchar(20) NOT NULL,
  `up` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usr`
--

INSERT INTO `usr` (`id`, `username`, `password`, `role`, `name`, `surname`, `up`) VALUES
(1, 'admin', 'admin', 1, 'Jon', 'Jakova', '2018-06-05 18:44:39');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tgs`
--
ALTER TABLE `tgs`
  ADD CONSTRAINT `tgs_ibfk_1` FOREIGN KEY (`id_fk`) REFERENCES `places` (`id`) ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
