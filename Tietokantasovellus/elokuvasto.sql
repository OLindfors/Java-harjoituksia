-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 01.12.2019 klo 20:35
-- Palvelimen versio: 8.0.13-4
-- PHP Version: 7.2.24-0ubuntu0.18.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `z6Pn05QVw8`
--

-- --------------------------------------------------------

--
-- Rakenne taululle `elokuvasto`
--

CREATE TABLE `elokuvasto` (
  `nimi` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `ohjaaja` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `vuosi` int(4) NOT NULL,
  `genre` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=COMPACT;

--
-- Vedos taulusta `elokuvasto`
--

INSERT INTO `elokuvasto` (`nimi`, `ohjaaja`, `vuosi`, `genre`) VALUES
('Kauas pilvet karkaavat', 'Kaurismäki Aki', 1996, 'Draama'),
('Paistetut vihreät tomaatit', 'Avnet Jon', 1991, 'Draama'),
('Yön ritari', 'Nolan Christopher', 2008, 'Toiminta'),
('Peppi Pitkätossu', 'Hellbom Olle', 1970, 'Lapset'),
('Rambo', 'Unknown', 1982, 'Toiminta'),
('Liisa ihmemaassa', 'Burton Tim', 2010, 'Fantasia'),
('Dirty Dancing', 'Ardolino Emile', 1987, 'Draama'),
('Olli oppivuodet', 'Puro Teuvo', 1920, 'Draama'),
('Poliisiopisto', 'Wilson Hugh', 1984, 'Komedia'),
('Risto Räppääjä', 'Rantasila Mari', 2008, 'Lasten'),
('Tuulen viemää', 'Unknown', 1965, 'Draama'),
('Alien', 'Scott R.', 1979, 'Kauhu');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
