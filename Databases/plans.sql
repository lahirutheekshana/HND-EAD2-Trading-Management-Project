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
-- Database: `plans`
--

-- --------------------------------------------------------

--
-- Table structure for table `plan`
--

DROP TABLE IF EXISTS `plan`;
CREATE TABLE IF NOT EXISTS `plan` (
  `p_id` int NOT NULL AUTO_INCREMENT,
  `p_name` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `p_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `p_accstart` double(20,2) DEFAULT NULL,
  `p_typicalrisk` int DEFAULT NULL,
  `p_riskreward` int DEFAULT NULL,
  `p_winloss` int DEFAULT NULL,
  `p_userid` int DEFAULT NULL,
  PRIMARY KEY (`p_id`),
  KEY `fk_userid` (`p_userid`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `plan`
--

INSERT INTO `plan` (`p_id`, `p_name`, `p_date`, `p_accstart`, `p_typicalrisk`, `p_riskreward`, `p_winloss`, `p_userid`) VALUES
(8, 'paln3', '2024-03-15 17:36:59', 500.32, 8, 8, 56, 1),
(9, 'paln4', '2024-03-15 17:36:59', 760.32, 8, 8, 56, 1),
(10, 'planAsiri', '2024-03-15 17:36:59', 100.00, 5, 2, 40, 1),
(13, 'paasdasd', '2024-03-15 17:36:59', 2333.00, 45, 45, 45, 5),
(19, 'dsf', '2024-03-15 17:36:59', 2000.00, 43, 34, 34, 5),
(20, 'Plan A', '2024-03-15 17:36:59', 4000.00, 6666, 0, 0, 5),
(21, 'Chirstmas', '2024-03-15 17:36:59', 566.00, 45, 65, 656, 5),
(22, 'sadas', '2024-03-15 17:36:59', 3444.00, 0, 0, 0, 5),
(23, 'hello', '2024-03-15 17:36:59', 231.00, 23, 23, 54, 5),
(24, 'my', '2024-03-15 17:36:59', 231.00, 23, 23, 54, 11),
(27, 'Asiri', '2024-03-15 17:36:59', 343.00, 34, 23, 565, 13),
(28, 'hello', '2024-03-15 17:36:59', 343.00, 34, 23, 565, 13),
(30, 'hhhh', '2024-03-15 17:36:59', 36.00, 900, 56, 34, 5),
(32, 'Plan Yap', '2024-03-15 17:36:59', 12000.00, 5, 4, 75, 15),
(34, 'Plan Lahiru', '2024-03-15 17:36:59', 7000.00, 97, 57, 78, 16),
(42, 'estgsd', '2024-03-15 17:36:59', 345.00, 346, 346, 45, 5);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
