-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Ven 17 Novembre 2017 à 19:41
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `antika`
--

--
-- Contenu de la table `dieu`
--

INSERT INTO `dieu` (`ID_DIEU`, `POUVOIR_SECONDAIRE`, `POUVOIR_PRINCIPAL`, `NOM`, `URL_IMG`) VALUES
(1, 16, 11, 'Aphrodite', 'aphrodite.jpg'),
(2, 28, 43, 'Apollon', 'Apollon.png'),
(3, 37, 49, 'Arès', 'Arès.jpg'),
(4, 29, 18, 'Artémis', 'Artémis.jpg'),
(5, 25, 60, 'Athéna', 'Athéna.png'),
(6, 32, 84, 'Dionysos', 'Dionysos.jpg'),
(7, 52, 17, 'Hadès', 'Hadès.jpg'),
(8, 1, 53, 'Héphaïstos', 'Héphaïstos.jpg'),
(9, 83, 85, 'Hermès', 'Hermès.jpg'),
(10, 14, 65, 'Poséidon', 'Poséidon.jpg'),
(11, 36, 20, 'Zeus', 'Zeus.jpg');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
