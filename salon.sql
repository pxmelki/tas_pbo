-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 27, 2024 at 02:43 PM
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
-- Database: `salon`
--

-- --------------------------------------------------------

--
-- Table structure for table `data_petugas`
--

CREATE TABLE `data_petugas` (
  `Id_Pelanggan` varchar(50) NOT NULL,
  `Nama` varchar(100) NOT NULL,
  `Telepon` varchar(15) NOT NULL,
  `Alamat` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `data_petugas`
--

INSERT INTO `data_petugas` (`Id_Pelanggan`, `Nama`, `Telepon`, `Alamat`) VALUES
('PTGS001', 'Revalina Saputera', '682023108', 'Bandung'),
('PTGS002', 'Vero', '682023109', 'Bali'),
('PTGS003', 'Rudy', '682023110', 'Semarang'),
('PTGS004', 'Novesa', '6820231004', 'Bandung');

-- --------------------------------------------------------

--
-- Table structure for table `pembookingan`
--

CREATE TABLE `pembookingan` (
  `No_Antrian` varchar(11) NOT NULL,
  `Nama` varchar(50) NOT NULL,
  `Tanggal_Booking` date NOT NULL,
  `Telephone` int(15) NOT NULL,
  `Alamat` varchar(100) NOT NULL,
  `Jenis_Layanan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pembookingan`
--

INSERT INTO `pembookingan` (`No_Antrian`, `Nama`, `Tanggal_Booking`, `Telephone`, `Alamat`, `Jenis_Layanan`) VALUES
('BKG001', 'Putri', '2024-06-14', 682023108, 'Salatiga', 'Potong rambut'),
('BKG002', 'Revalina', '2024-06-16', 682023109, 'Malang', 'Cat rambut'),
('BKG003', 'Melki', '2024-06-24', 682023110, 'Bandung', 'Potong rambut');

-- --------------------------------------------------------

--
-- Table structure for table `stok_barang`
--

CREATE TABLE `stok_barang` (
  `Kode_barang` varchar(10) NOT NULL,
  `Nama_barang` varchar(100) NOT NULL,
  `Tanggal_masuk` date NOT NULL,
  `Jumlah_stok` int(11) NOT NULL,
  `Harga_barang` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `stok_barang`
--

INSERT INTO `stok_barang` (`Kode_barang`, `Nama_barang`, `Tanggal_masuk`, `Jumlah_stok`, `Harga_barang`) VALUES
('KD001', 'Vitamin', '2024-06-07', 21, 15000.00),
('KD002', 'Vitamin rambut', '2024-06-06', 30, 45000.00),
('KD003', 'Cat rambut', '2024-06-06', 25, 45000.00);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `No_antrian` varchar(11) NOT NULL,
  `Nama` varchar(100) NOT NULL,
  `Jenis_layanan` varchar(100) NOT NULL,
  `Harga` double NOT NULL,
  `Bayar` double NOT NULL,
  `Kembali` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`No_antrian`, `Nama`, `Jenis_layanan`, `Harga`, `Bayar`, `Kembali`) VALUES
('BKG001', 'Putri', 'Potong rambut', 25000, 50000, 25000),
('BKG002', 'Revalina', 'Cat rambut', 60000, 100000, 40000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data_petugas`
--
ALTER TABLE `data_petugas`
  ADD PRIMARY KEY (`Id_Pelanggan`);

--
-- Indexes for table `pembookingan`
--
ALTER TABLE `pembookingan`
  ADD PRIMARY KEY (`No_Antrian`);

--
-- Indexes for table `stok_barang`
--
ALTER TABLE `stok_barang`
  ADD PRIMARY KEY (`Kode_barang`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`No_antrian`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
