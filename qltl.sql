-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1:3307
-- Thời gian đã tạo: Th9 29, 2025 lúc 03:21 AM
-- Phiên bản máy phục vụ: 10.4.27-MariaDB
-- Phiên bản PHP: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qltl`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `book`
--

CREATE TABLE `book` (
  `id` bigint(20) NOT NULL,
  `masach` varchar(255) DEFAULT NULL,
  `ten` varchar(255) DEFAULT NULL,
  `tgia` varchar(255) DEFAULT NULL,
  `slg` int(11) NOT NULL,
  `danhmuc` varchar(255) DEFAULT NULL,
  `noidung` varchar(255) DEFAULT NULL,
  `gia` int(11) NOT NULL,
  `nxb` varchar(255) DEFAULT NULL,
  `namxb` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `book`
--

INSERT INTO `book` (`id`, `masach`, `ten`, `tgia`, `slg`, `danhmuc`, `noidung`, `gia`, `nxb`, `namxb`) VALUES
(1, 'TL001', 'LẬP TRÌNH JAVA ', 'ANTHONY JAME', 10, 'KHOA HỌC ', 'ABCDEFGHIJ', 150000, 'NXB LT', '2012'),
(2, 'TL002', ' NGÔN NGỮ SQL', 'JOHN BROWN', 9, 'KHOA HỌC', 'ABCDEFGHJ', 190000, 'NXB GD', '2025'),
(3, 'TL003', 'LEARN PHP', 'YELLOW CAPY', 80, 'KHOA HỌC ', 'ABCDEFGHKLMNO', 160000, 'NXB GD', '2018'),
(4, 'TL004', 'Lập trình C#', 'John David', 30, 'KHOA HỌC ', 'ABCDEFGHILKM', 180000, 'NXB KH', '2014');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `id` bigint(20) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`id`, `password`, `username`) VALUES
(1, '$2a$10$C5DOqKGlPxROGjOjM0U6QOnpJJt/ViB0LClFamhVe/V6.VuXcPJLe', 'capy');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK9rrdg0nicwf847tn9cx6dg2cv` (`username`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `book`
--
ALTER TABLE `book`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
