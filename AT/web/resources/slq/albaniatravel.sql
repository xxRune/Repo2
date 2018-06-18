-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 18, 2018 at 03:47 PM
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
(1, '\"Albania Travel\" is an application that made to help its users find touristic spots to visit based entirely on their own criteria. The application is very simple to use and this is exactly it\'s strong point. The user can select different tags from a list (and category of places), the software will process the information and then display a list of toursim spot that fulfill the user previous selected criteria.');

-- --------------------------------------------------------

--
-- Table structure for table `places`
--

DROP TABLE IF EXISTS `places`;
CREATE TABLE IF NOT EXISTS `places` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `category` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `plc_fk` int(5) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `plc_fk` (`plc_fk`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `places`
--

INSERT INTO `places` (`id`, `category`, `name`, `plc_fk`) VALUES
(1, 'city', 'Tirane', 1),
(2, 'city', 'Durres', 1),
(3, 'village', 'Valbona Valley', 2),
(4, 'village', 'Voskopoj', 2),
(5, 'point', 'Albanian Riviera', 3),
(6, 'point', 'Apollonia', 3),
(7, 'city', 'Sarande', 1);

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
