-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 21, 2020 at 11:35 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ustensile`
--

-- --------------------------------------------------------

--
-- Table structure for table `assiettecarree`
--

CREATE TABLE `assiettecarree` (
  `id` int(11) NOT NULL,
  `year` int(11) NOT NULL,
  `valeur` double NOT NULL,
  `cote` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `assietteronde`
--

CREATE TABLE `assietteronde` (
  `id` int(11) NOT NULL,
  `year` int(4) NOT NULL,
  `rayon` double NOT NULL,
  `valeur` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `cuillere`
--

CREATE TABLE `cuillere` (
  `id` int(11) NOT NULL,
  `year` int(11) NOT NULL,
  `valeur` double NOT NULL,
  `longeur` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `assiettecarree`
--
ALTER TABLE `assiettecarree`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `assietteronde`
--
ALTER TABLE `assietteronde`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cuillere`
--
ALTER TABLE `cuillere`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `assiettecarree`
--
ALTER TABLE `assiettecarree`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `assietteronde`
--
ALTER TABLE `assietteronde`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `cuillere`
--
ALTER TABLE `cuillere`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
