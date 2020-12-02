-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th7 21, 2020 lúc 11:05 AM
-- Phiên bản máy phục vụ: 10.4.11-MariaDB
-- Phiên bản PHP: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `banhang`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietdonhang`
--

CREATE TABLE `chitietdonhang` (
  `id` int(11) NOT NULL,
  `madonhang` int(11) NOT NULL,
  `masanpham` int(11) NOT NULL,
  `tensanpham` varchar(200) NOT NULL,
  `giasanpham` int(11) NOT NULL,
  `soluongsanpham` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `chitietdonhang`
--

INSERT INTO `chitietdonhang` (`id`, `madonhang`, `masanpham`, `tensanpham`, `giasanpham`, `soluongsanpham`) VALUES
(1, 1, 5, 'ULTRABOOST 20 SHOES', 3000000, 1),
(2, 2, 3, 'CLIMACOOL VENTO SHOES', 2750000, 1),
(3, 2, 4, 'Nike Air Zoom Pegasus 37 FlyEase', 4500000, 1),
(4, 3, 7, 'Air Max 90 Premium', 8200000, 2),
(5, 4, 5, 'ULTRABOOST 20 SHOES', 3000000, 1),
(6, 5, 5, 'ULTRABOOST 20 SHOES', 3000000, 1),
(7, 6, 15, 'Nike Air Zoom BB NXT', 5300000, 1),
(8, 7, 15, 'Nike Air Zoom BB NXT', 5300000, 1),
(9, 7, 7, 'Air Max 90 Premium', 4100000, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `donhang`
--

CREATE TABLE `donhang` (
  `id` int(11) NOT NULL,
  `tenkhachhang` varchar(200) NOT NULL,
  `sodienthoai` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `donhang`
--

INSERT INTO `donhang` (`id`, `tenkhachhang`, `sodienthoai`, `email`) VALUES
(1, 'Quy', '0396537184', 'quybui49'),
(2, 'Dung', '0396537184', 'quybui23'),
(3, 'quy', '0396537184', 'quytram'),
(4, 'Bui Van Van Quy', '0396537184', 'quybui49@gmail.com'),
(5, 'Quy', '0396537184', 'quybui49@gmail.com'),
(6, 'Duy', '039778245', 'quybui49@gmail.com'),
(7, 'Ha', '123456789', 'buiquy@gmail.com');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaisanpham`
--

CREATE TABLE `loaisanpham` (
  `Id` int(11) NOT NULL,
  `tenloaisanpham` varchar(200) NOT NULL,
  `hinhanhsanpham` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `loaisanpham`
--

INSERT INTO `loaisanpham` (`Id`, `tenloaisanpham`, `hinhanhsanpham`) VALUES
(1, 'Adias', 'https://cdn1.iconfinder.com/data/icons/logos-and-brands-3/512/5_Adidas_logo_logos-128.png'),
(2, 'Nike', 'https://img.icons8.com/ios-filled/50/000000/nike.png');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `Id` int(11) NOT NULL,
  `tensanpham` varchar(200) NOT NULL,
  `giasanpham` int(15) NOT NULL,
  `hinhansanpham` varchar(200) NOT NULL,
  `motasanpham` varchar(1000) NOT NULL,
  `Idsanpham` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`Id`, `tensanpham`, `giasanpham`, `hinhansanpham`, `motasanpham`, `Idsanpham`) VALUES
(1, 'SUPERSTAR SHOES', 2750000, 'https://assets.adidas.com/images/h_840,f_auto,q_auto:sensitive,fl_lossy/7ed0855435194229a525aad6009a0497_9366/Superstar_Shoes_White_EG4958_01_standard.jpg', 'THE AUTHENTIC LOW TOP WITH THE SHELL TOE.\r\nOriginally made for basketball courts in the \'70s. Celebrated by hip hop royalty in the \'80s. The adidas Superstar shoe is now a lifestyle staple for streetwear enthusiasts. The world-famous shell toe feature remains, providing style and protection. Just like it did on the B-ball courts back in the day.    Now, whether at a festival or walking in the street you can enjoy yourself without the fear of being stepped on. The serrated 3-Stripes detail and adidas Superstar box logo adds OG authenticity to your look.', 1),
(2, 'Nike Air Zoom Pegasus 37', 3519000, 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,b_rgb:f5f5f5/e8aa7537-5848-4418-9ab4-1ff9cc27c17c/air-zoom-pegasus-37-running-shoe-mwrTCc.jpg', 'Reinvigorate your stride with the Nike Air Zoom Pegasus 37. Delivering the same fit and feel that runners love, the shoe has an all-new forefoot cushioning unit and foam for maximum responsiveness. The result is a durable, lightweight trainer designed for everyday running.', 2),
(3, 'CLIMACOOL VENTO SHOES', 2750000, 'https://assets.adidas.com/images/h_840,f_auto,q_auto:sensitive,fl_lossy/4dbf8f0fbde54b09aaa3ab4f0130027e_9366/Climacool_Vento_Shoes_Black_FX7841_01_standard.jpg', 'You check the forecast. Hot and sunny. Again. But your routine stays on track in these adidas Climacool Vento Shoes. They have a breathable upper and responsive cushioning that keep you looking and feeling fresh in the heat.', 1),
(4, 'Nike Air Zoom Pegasus 37 FlyEase', 4500000, 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,b_rgb:f5f5f5/61f32dc1-0fbe-4cb5-b973-b2c813d6a00f/air-zoom-pegasus-37-flyease-running-shoe-sGHXXb.jpg', 'Reinvigorate your stride with the Nike Air Zoom Pegasus 37. Delivering the same fit and feel that runners love, the shoe has an all-new forefoot cushioning unit and foam for maximum responsiveness. The result is a durable, lightweight trainer designed for everyday running.', 2),
(5, 'ULTRABOOST 20 SHOES', 3000000, 'https://assets.adidas.com/images/h_2000,f_auto,q_auto:sensitive,fl_lossy/cd1631e9d6fb48ccaedcaafc0106320f_9366/Ultraboost_20_Shoes_White_EF1042_01_standard.jpg', 'A new day. A new run. Make it your best. These high-performance shoes feature a foot-hugging knit upper. Stitched-in reinforcement is precisely placed to give you support in the places you need it most. The soft elastane heel delivers a more comfortable fit. Responsive cushioning returns energy to your stride with every footstrike for that I-could-run-forever feeling.', 1),
(7, 'Air Max 90 Premium', 4100000, 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,b_rgb:f5f5f5/f86e3592-ea55-4cb0-94d3-a6da79641feb/air-max-90-shoe-hTsX5h.jpg', 'Nothing as fly, nothing as comfortable, nothing as proven—the Nike Air Max 90 stays true to its OG roots with the iconic Waffle outsole, stitched overlays and classic TPU accents. Celebrating the home and away kits of your favourite teams, the soft leather upper features a rub-away material that reveals a secondary colour through normal wear while Max Air cushioning adds comfort to your journey.', 2),
(9, 'ULTRABOOST DNA X DISNEY SHOES', 4200000, 'https://assets.adidas.com/images/h_2000,f_auto,q_auto:sensitive,fl_lossy/3b08c0bf07214183acaeabb100a9c5f3_9366/Ultraboost_DNA_x_Disney_Shoes_Black_FV6050_01_standard.jpg', 'ULTRABOOST DNA X DISNEY SHOES\r\nRESPONSIVE RUNNING SHOES FEATURING DISNEY\'S GOOFY.\r\nJoin Disney\'s Goofy as he tries to learn new sports in these adidas Ultraboost Running Shoes. Graphics on the textile upper feature the lovable cartoon dog practising karate, baseball, rock climbing, skating and surfing. Responsive cushioning returns energy to your stride with every footstrike for that I-could-run-forever feeling.', 1),
(11, 'ULTRABOOST SUMMER.RDY SHOES', 5000000, 'https://assets.adidas.com/images/h_840,f_auto,q_auto:sensitive,fl_lossy/eec9e5a976ad422999aeab96011f6e3e_9366/Ultraboost_SUMMER.RDY_Shoes_White_FW9771_01_standard.jpg', 'ULTRABOOST SUMMER.RDY SHOES\r\nLIGHT AND BREATHABLE SHOES MADE FOR HOT-WEATHER RUNNING.\r\nThe sun is shining, warming your skin. Your muscles feel loose and limber. Your spirits are high. Optimism courses through your body. This is going to be a great run. Don\'t avoid the heat. Embrace it in these adidas Ultraboost S.RDY Shoes. Designed to help you run your best in hot conditions, the shoes have a super light and breathable knit upper with transparent windows that let bright socks show though. Make pink your power colour. Inspired by the global movement for change that unites all of us, no matter our gender.', 1),
(12, 'SUPERNOVA SHOES', 2700000, 'https://assets.adidas.com/images/h_840,f_auto,q_auto:sensitive,fl_lossy/f8f5bc121aa54eb29886ab96015fd703_9366/Supernova_Shoes_Pink_FW0704_01_standard.jpg', 'SUPERNOVA SHOES\r\nSUPPORTIVE RUNNING SHOES WITH A BREATHABLE MESH UPPER.\r\nEveryone runs for different reasons. Whatever drives you to hit the path or the pavement, these adidas shoes are designed to help you reach your goals. Flexible cushioning in the forefoot combines with responsive cushioning in the heel to give you a comfortable ride. And because we\'re serious about creating a healthier environment, these shoes are built with recycled materials.', 1),
(15, 'Nike Air Zoom BB NXT', 5300000, 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,b_rgb:f5f5f5/8e52a15d-76ca-49ea-8566-60f751c3ecc4/air-zoom-bb-nxt-basketball-shoe-wRmJMz.jpg', 'Keep your focus on the game in the new Air Zoom BB NXT from Nike Basketball. It\'s designed to help players feel light, secure and responsive. You get energy back with every step, helping to turn your force into momentum when it matters most.', 2),
(16, 'Nike Blazer Mid \'77 Vintage', 2900000, 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,b_rgb:f5f5f5/kxmb3lab5dmy00qpoyul/blazer-mid-77-vintage-shoe-dNWPTj.jpg', 'The Nike Blazer Mid \'77 Vintage harnesses the old-school look of Nike Basketball with a vintage midsole finish, making it look like you\'ve been saving them for years.', 2),
(19, 'LeBron 17 Low', 5300000, 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,b_rgb:f5f5f5/60511dfe-09e5-40cc-81f4-1b3287f64781/lebron-17-low-basketball-shoe-kFcJdF.jpg', 'Fine-tuned for LeBron\'s ferocious game, the LeBron 17 Low gives the King another sensation to add to his arsenal. The combined cushioning platform provides a balanced mix of impact absorption and responsiveness. A precisely crafted low-top design offers a lightweight, conforming fit with ankle mobility and a look that resonates on the street.', 2),
(20, 'ADIDAS 4D RUN 1.0 SHOES', 3800000, 'https://assets.adidas.com/images/h_840,f_auto,q_auto:sensitive,fl_lossy/ae99cef75be04e089032ab25010d4dfa_9366/adidas_4D_Run_1.0_Shoes_White_EG6264_01_standard.jpg', 'FROM ATHLETE DATA TO CUSHIONING REVOLUTION.\r\nThe future of running starts today. The adidas 4D Run 1.0 has a digitally-printed midsole that\'s crafted based on 17 years of athlete data – an innovation in the world of sports. These insights created a unique 3D-printed lattice structure tuned to cushion and support your feet exactly where needed when you\'re on the move. Take these sneakers for a spin and feel the future.', 1),
(21, 'LeBron 7 QS', 4700000, 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,b_rgb:f5f5f5/i1-3174faf0-d70e-4b78-952e-4e97bac904ee/lebron-7-qs-shoe-pCXwfk.jpg', 'Make your head-turning journey to the top comfortable. Built strong and sleek, the LeBron 7 QS features a mix of materials on the upper for a look that lasts. Metal accents and multiple LeBron crests celebrate a king, while full-length cushioning graces your every step.', 2);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `donhang`
--
ALTER TABLE `donhang`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `loaisanpham`
--
ALTER TABLE `loaisanpham`
  ADD PRIMARY KEY (`Id`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `donhang`
--
ALTER TABLE `donhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `loaisanpham`
--
ALTER TABLE `loaisanpham`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
