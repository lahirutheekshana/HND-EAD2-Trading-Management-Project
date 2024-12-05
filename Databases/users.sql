-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 15, 2024 at 10:48 AM
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
-- Database: `users`
--

-- --------------------------------------------------------

--
-- Table structure for table `userx`
--

CREATE TABLE `userx` (
  `user_id` int(11) NOT NULL,
  `user_fname` varchar(100) DEFAULT NULL,
  `user_lname` varchar(100) DEFAULT NULL,
  `user_email` varchar(100) DEFAULT NULL,
  `user_password` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `userx`
--

INSERT INTO `userx` (`user_id`, `user_fname`, `user_lname`, `user_email`, `user_password`) VALUES
(1, 'hbcfhgf', 'hy', 'gjgh', '3'),
(5, 'asasd', 'asdsa', 'b', '2'),
(8, 'hbcfhgf', 'hy', 'gjttgh', '4'),
(11, 'kkkkk', 'kkkkk', 'kkk@gmail.com', 'kkkkk'),
(12, 'asiri sadaruwan', 'kukukla', 'kukku@gmail.com', 'kukku'),
(13, 'Asiri', 'Sandaruwan', 'asiriduos@gmail.com', '12345678'),
(15, 'Jhonathan', 'Abeham', 'j@gmail.com', '1234'),
(16, 'Lahiru', 'Theekshana', 'l@gmail.com', '1234'),
(17, 'bgg', 'ddd', 'g', '3'),
(19, 'lll', 'lll', 'lll', 'lll'),
(20, 'oo', 'oo', 'oo', 'oo'),
(21, 'pp', 'pp', 'pp', 'pp'),
(22, 'Heli', 'Copter', 'h', '1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `userx`
--
ALTER TABLE `userx`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `userx`
--
ALTER TABLE `userx`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
