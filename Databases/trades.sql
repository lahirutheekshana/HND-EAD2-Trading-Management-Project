-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Mar 15, 2024 at 05:45 PM
-- Server version: 8.2.0
-- PHP Version: 8.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `trades`
--

-- --------------------------------------------------------

--
-- Table structure for table `trade`
--

DROP TABLE IF EXISTS `trade`;
CREATE TABLE IF NOT EXISTS `trade` (
  `t_id` int NOT NULL AUTO_INCREMENT,
  `t_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `t_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `t_capital` double(20,2) DEFAULT NULL,
  `t_market` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `t_risk_amount` double(20,2) DEFAULT NULL,
  `t_win_loss` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `t_buy_sell` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `t_userid` int DEFAULT NULL,
  PRIMARY KEY (`t_id`),
  KEY `fk_userid` (`t_userid`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `trade`
--

INSERT INTO `trade` (`t_id`, `t_name`, `t_date`, `t_capital`, `t_market`, `t_risk_amount`, `t_win_loss`, `t_buy_sell`, `t_userid`) VALUES
(7, 'Trade2', '2024-03-15 17:43:10', 453.00, 'dcgv', 0.00, 'ww', 'reer', 1),
(9, 'Trade4', '2024-03-15 17:43:10', 1000.00, 'JPY', 20.00, 'loss', 'buy', 5),
(16, 'HellowBro', '2024-03-15 17:43:10', 20000.00, 'aud', 3442.00, 'win', 'sell', 1),
(17, 'abcd', '2024-03-15 17:43:10', 4000.00, 'ggg', 455.00, 'win', 'sell', 5),
(18, 'myTrade', '2024-03-15 17:43:10', 8000.00, 'usd', 56444.00, 'loss', 'buy', 1),
(19, 'Trade2', '2024-03-15 17:43:10', 453.00, 'dcgv', 0.00, 'ww', 'reer', 5),
(20, 'Trade One', '2024-03-15 17:43:10', 23000.00, 'AUD', 0.00, 'Win', 'Buy', 15),
(21, 'Trade My', '2024-03-15 17:43:10', 25000.00, 'AUD', 0.00, 'win', 'Loss', 16),
(24, 'ghjgh', '2024-03-15 17:43:10', 5433.00, 'JPY', 0.00, 'Loss', 'Buy', 16),
(27, 'My', '2024-03-15 17:43:10', 5433.00, 'JPY', 0.00, 'Loss', 'Buy', 16);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
