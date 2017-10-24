-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 23, 2017 at 02:18 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `computerscience`
--

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE `courses` (
  `c_ID` int(4) NOT NULL,
  `c_name` varchar(20) NOT NULL,
  `instructor` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`c_ID`, `c_name`, `instructor`) VALUES
(300, 'C300', 2),
(301, 'java', 1),
(302, 'discrete', 3),
(303, 'DB', 2),
(304, 'TOC', 3),
(305, 'OS', 1),
(306, 'java2', 1),
(307, 'network', 1),
(308, 'machine learning ', 2),
(309, 'AI', 2),
(310, 'quantom', 3),
(409, 'DL', 2);

-- --------------------------------------------------------

--
-- Table structure for table `instructors`
--

CREATE TABLE `instructors` (
  `ID_2` int(4) NOT NULL,
  `name` varchar(20) NOT NULL,
  `lastname` varchar(20) NOT NULL,
  `BD` date NOT NULL,
  `usr_ID2` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `instructors`
--

INSERT INTO `instructors` (`ID_2`, `name`, `lastname`, `BD`, `usr_ID2`) VALUES
(1, 'ashraf', 'samir', '2017-05-02', 200),
(2, 'yasser', 'fouad', '2017-05-30', 201),
(3, 'ahmed', 'youniss', '2017-05-22', 202);

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `ID_1` char(4) NOT NULL,
  `name` varchar(20) NOT NULL,
  `lastname` varchar(20) NOT NULL,
  `BD` date NOT NULL,
  `usr_ID1` int(4) NOT NULL,
  `grade` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`ID_1`, `name`, `lastname`, `BD`, `usr_ID1`, `grade`) VALUES
('1', 'anas', 'hassan', '1996-07-27', 100, 'A'),
('2', 'mohamed', 'ahmed', '2017-05-18', 101, 'B'),
('3', 'mariam', 'mohsen', '2017-05-09', 103, 'C'),
('4', 'mayar', 'mohamed', '2017-05-04', 102, 'C');

-- --------------------------------------------------------

--
-- Table structure for table `studentscourses`
--

CREATE TABLE `studentscourses` (
  `ID_11` int(4) NOT NULL,
  `C_ID1` int(4) NOT NULL,
  `gpa` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `studentscourses`
--

INSERT INTO `studentscourses` (`ID_11`, `C_ID1`, `gpa`) VALUES
(1, 300, 'A'),
(1, 301, 'A'),
(1, 302, 'A-'),
(1, 303, 'B'),
(2, 300, 'B'),
(2, 303, 'B'),
(2, 305, 'C'),
(3, 300, 'B+'),
(4, 300, 'A'),
(4, 301, 'D'),
(4, 303, 'H'),
(1, 304, 'H'),
(1, 305, 'H');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `ID` int(4) NOT NULL,
  `userName` text NOT NULL,
  `password` text NOT NULL,
  `type` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`ID`, `userName`, `password`, `type`) VALUES
(100, 'anas.hassan', 'anas.hassan', 1),
(101, 'mohamed.ahmed', 'mohamed.ahmed', 1),
(102, 'mayar.mohamed', 'mayar.mohamed', 1),
(103, 'mariam.mohsen', 'mariam.mohsen', 1),
(200, 'ashraf.samir', 'ashraf.samir', 2),
(201, 'yasser.fouad', 'yasser.fouad', 2),
(202, 'ahmed.youniss', 'ahmed.youniss', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`c_ID`);

--
-- Indexes for table `instructors`
--
ALTER TABLE `instructors`
  ADD PRIMARY KEY (`ID_2`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`ID_1`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
