-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 15, 2024 at 10:47 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `incomes`
--

-- --------------------------------------------------------

--
-- Table structure for table `income`
--

CREATE TABLE `income` (
  `i_id` int(11) NOT NULL,
  `i_balance` double(20,2) DEFAULT NULL,
  `i_profit_loss` int(11) DEFAULT NULL,
  `i_new_balance` int(11) DEFAULT NULL,
  `i_userid` int(11) DEFAULT NULL,
  `i_pid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `income`
--

INSERT INTO `income` (`i_id`, `i_balance`, `i_profit_loss`, `i_new_balance`, `i_userid`, `i_pid`) VALUES
(299, 566.00, 254, 311, 5, 21),
(300, 311.30, 9105, 9416, 5, 21),
(301, 9416.82, 4237, 5179, 5, 21),
(302, 5179.25, 151493, 156672, 5, 21),
(303, 156672.43, 70502, 86169, 5, 21),
(304, 86169.83, 2520467, 2606637, 5, 21),
(305, 2606637.49, 1172986, 1433650, 5, 21);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `income`
--
ALTER TABLE `income`
  ADD PRIMARY KEY (`i_id`),
  ADD KEY `fk_userid` (`i_userid`),
  ADD KEY `fk_pid` (`i_pid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `income`
--
ALTER TABLE `income`
  MODIFY `i_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=306;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `income`
--
ALTER TABLE `income`
  ADD CONSTRAINT `fk_pid` FOREIGN KEY (`i_pid`) REFERENCES `plans`.`plan` (`p_id`),
  ADD CONSTRAINT `fk_userid` FOREIGN KEY (`i_userid`) REFERENCES `users`.`userx` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
