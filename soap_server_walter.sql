-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-01-2022 a las 22:59:28
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `soap_server_walter`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `DELETE_PRODUCT` (IN `product_id` INT)  NO SQL
BEGIN
	DELETE FROM products WHERE id = product_id;
    SELECT 1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GET_ALL_PRODUCTS` ()  SELECT * FROM products$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GET_PRODUCT_BY_ID` (IN `product_id` INT)  BEGIN
    SELECT * FROM products WHERE id = product_id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `SAVE_PRODUCT` (IN `name` VARCHAR(255), IN `price` INT, IN `description` VARCHAR(255))  NO SQL
BEGIN
	DECLARE product_id INT unsigned default 0;
 	INSERT INTO products (`name`, `price`, `description`) VALUES (name, price, description);
    SET product_id = last_insert_id();
	SELECT * FROM products WHERE id = product_id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `UPDATE_PRODUCT` (IN `product_id` INT, IN `name` VARCHAR(255), IN `price` INT, IN `description` VARCHAR(255))  NO SQL
BEGIN
 	UPDATE products SET 
    `name` = name,
    `price` = price,
    `description` = description
    WHERE id = product_id;
	SELECT * FROM products WHERE id = product_id;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `products`
--

INSERT INTO `products` (`id`, `description`, `name`, `price`) VALUES
(7, 'HUAWEI P30 DESCRIPCION', 'HUAWEI P30 LITE', 50),
(8, 'HUAWEI P30 DESCRIPCION', 'HUAWEI P30 LITE', 50),
(9, 'HUAWEI P30 DESCRIPCION', 'HUAWEI P30 LITE', 50),
(10, 'HUAWEI P30 DESCRIPCION', 'HUAWEI P30 LITE', 50),
(11, 'HUAWEI P30 DESCRIPCION', 'HUAWEI P30 LITE', 50),
(12, 'HUAWEI P30 DESCRIPCION', 'HUAWEI P30 LITE', 50),
(13, 'HUAWEI P30 DESCRIPCION', 'HUAWEI P30 LITE', 50),
(14, 'HUAWEI P30 DESCRIPCION', 'HUAWEI P30 LITE', 50),
(15, 'HUAWEI P30 DESCRIPCION', 'HUAWEI P30 LITE', 50),
(16, 'HUAWEI P30 DESCRIPCION', 'HUAWEI P30 LITE', 50),
(17, 'HUAWEI P30 DESCRIPCION', 'HUAWEI P30 LITE', 50),
(18, 'HUAWEI P30 DESCRIPCION', 'HUAWEI P30 LITE', 50);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
