-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Sep 22, 2019 at 08:38 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.1.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gym1`
--

-- --------------------------------------------------------

--
-- Table structure for table `add_member`
--

CREATE TABLE `add_member` (
  `name` varchar(50) NOT NULL,
  `age` varchar(11) NOT NULL,
  `gender` varchar(50) NOT NULL,
  `dob` varchar(20) NOT NULL,
  `contact` varchar(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `t_address` varchar(50) NOT NULL,
  `p_address` varchar(50) NOT NULL,
  `height` varchar(11) NOT NULL,
  `weight` varchar(11) NOT NULL,
  `chest` varchar(11) NOT NULL,
  `belly` varchar(11) NOT NULL,
  `j_date` varchar(20) NOT NULL,
  `membership` varchar(50) NOT NULL,
  `e_date` varchar(20) NOT NULL,
  `total` varchar(11) NOT NULL,
  `paid` varchar(11) NOT NULL,
  `due` varchar(50) NOT NULL,
  `p_method` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL,
  `staff` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `add_member`
--

INSERT INTO `add_member` (`name`, `age`, `gender`, `dob`, `contact`, `email`, `t_address`, `p_address`, `height`, `weight`, `chest`, `belly`, `j_date`, `membership`, `e_date`, `total`, `paid`, `due`, `p_method`, `username`, `pass`, `role`, `staff`) VALUES
('Nitesh Mandal', '23', 'Male', '1997/04/17', '9810400649', 'sweetb695@gmail.com', 'Kathmandu', 'Biratnagar', '5.5', '52', '32', '30', '2019/05/20', 'One Month', '2019/06/20', '1000', '1000', '0', 'Online', 'nit', 'nitu', 'Member', 'Darko'),
('Diya Raut', '17', 'Female', '2059/12/9', '9825781867', 'diyaraut2059@gmail.com', 'Kathmandu', 'Biratnagar', '5.4', '45', '32', '28', '2076/05/20', 'One Month', '2076/06/20', '1000', '1000', '0', 'Card', 'diya', 'raut', 'Member', 'Nitesh');

-- --------------------------------------------------------

--
-- Table structure for table `diya`
--

CREATE TABLE `diya` (
  `month` varchar(20) DEFAULT NULL,
  `height` varchar(20) DEFAULT NULL,
  `weight` varchar(10) DEFAULT NULL,
  `chest` varchar(10) DEFAULT NULL,
  `belly` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `diya`
--

INSERT INTO `diya` (`month`, `height`, `weight`, `chest`, `belly`) VALUES
('1', '5.4', '45', '32', '28'),
('2', '5.4', '45', '33', '27');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `usr` varchar(20) NOT NULL,
  `pass` varchar(20) NOT NULL,
  `role` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`usr`, `pass`, `role`) VALUES
('dark', 'soul', 'Admin'),
('nit', 'nitu', 'Member'),
('diya', 'raut', 'Member');

-- --------------------------------------------------------

--
-- Table structure for table `nit`
--

CREATE TABLE `nit` (
  `month` varchar(20) DEFAULT NULL,
  `height` varchar(20) DEFAULT NULL,
  `weight` varchar(10) DEFAULT NULL,
  `chest` varchar(10) DEFAULT NULL,
  `belly` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `nit`
--

INSERT INTO `nit` (`month`, `height`, `weight`, `chest`, `belly`) VALUES
('1', '5.5', '52', '32', '30'),
('2', '5.6', '51', '32', '30');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
