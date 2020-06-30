-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 23-Jun-2020 às 23:18
-- Versão do servidor: 10.4.13-MariaDB
-- versão do PHP: 7.2.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `restaurantejdbc`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `billpayment`
--

CREATE TABLE `billpayment` (
  `PaymentID` int(10) UNSIGNED NOT NULL,
  `IndividualBillID` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `billpayment`
--

INSERT INTO `billpayment` (`PaymentID`, `IndividualBillID`) VALUES
(1, 15),
(2, 15),
(3, 17),
(4, 17),
(5, 19),
(6, 19),
(7, 21),
(8, 21),
(9, 24);

-- --------------------------------------------------------

--
-- Estrutura da tabela `bills`
--

CREATE TABLE `bills` (
  `BillID` int(11) UNSIGNED NOT NULL,
  `TableNumber` int(11) UNSIGNED DEFAULT NULL,
  `StatusBill` int(11) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `bills`
--

INSERT INTO `bills` (`BillID`, `TableNumber`, `StatusBill`) VALUES
(1, 6, 0),
(2, 25, 0),
(3, 7, 0),
(4, 9, 0),
(5, 6, 0),
(6, 3, 0),
(7, 7, 0),
(8, 9, 0),
(9, 6, 0),
(10, 3, 0),
(11, 7, 0),
(12, 9, 1),
(13, 39, 0),
(14, 3, 0),
(15, 7, 0),
(16, 9, 0),
(17, 6, 0),
(18, 3, 0),
(19, 7, 0),
(20, 9, 0),
(23, 12, 0),
(24, 39, 0),
(25, 39, 1),
(26, 99, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `categories`
--

CREATE TABLE `categories` (
  `CategoryID` int(11) UNSIGNED NOT NULL,
  `CategoryName` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `categories`
--

INSERT INTO `categories` (`CategoryID`, `CategoryName`) VALUES
(1, 'Massas'),
(2, 'Massas'),
(3, 'Saladas');

-- --------------------------------------------------------

--
-- Estrutura da tabela `individualbills`
--

CREATE TABLE `individualbills` (
  `IndividualBillID` int(11) UNSIGNED NOT NULL,
  `BillID` int(11) UNSIGNED DEFAULT NULL,
  `Observation` varchar(255) DEFAULT NULL,
  `TabPosition` int(11) UNSIGNED NOT NULL,
  `StatusBill` int(11) UNSIGNED DEFAULT 0,
  `TotalPaid` double DEFAULT 0,
  `TipPaid` double DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `individualbills`
--

INSERT INTO `individualbills` (`IndividualBillID`, `BillID`, `Observation`, `TabPosition`, `StatusBill`, `TotalPaid`, `TipPaid`) VALUES
(15, 1, 'Henrique', 2, 0, 0, 0),
(16, 1, 'Debora', 1, 0, 0, 0),
(17, 1, 'Henrique', 2, 0, 0, 0),
(18, 1, 'Debora', 1, 0, 0, 0),
(19, 1, 'Henrique', 2, 0, 0, 0),
(20, 1, 'Debora', 1, 0, 0, 0),
(21, 1, 'Henrique', 2, 0, 0, 0),
(22, 1, 'Debora', 1, 0, 0, 0),
(23, 24, 'Oswaldo', 3, 0, 0, 0),
(24, 25, 'Oswaldo', 3, 0, 0, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `orderitem`
--

CREATE TABLE `orderitem` (
  `OrderItemID` int(11) UNSIGNED NOT NULL,
  `ItemPrice` double DEFAULT NULL,
  `Observation` varchar(255) DEFAULT NULL,
  `OrderID` int(11) UNSIGNED DEFAULT NULL,
  `ProductID` int(11) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `orderitem`
--

INSERT INTO `orderitem` (`OrderItemID`, `ItemPrice`, `Observation`, `OrderID`, `ProductID`) VALUES
(1, 24.99, NULL, 1, 1),
(2, 19.99, NULL, 1, 2),
(3, 24.99, NULL, 2, 3),
(4, 19.99, NULL, 2, 4),
(5, 15, NULL, 3, 5);

-- --------------------------------------------------------

--
-- Estrutura da tabela `orders`
--

CREATE TABLE `orders` (
  `OrderID` int(11) UNSIGNED NOT NULL,
  `Moment` timestamp NULL DEFAULT NULL,
  `IndividualBillID` int(11) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `orders`
--

INSERT INTO `orders` (`OrderID`, `Moment`, `IndividualBillID`) VALUES
(1, '2020-06-09 14:40:30', 19),
(2, '2020-06-09 14:51:01', 21),
(3, '2020-06-10 15:14:33', 24);

-- --------------------------------------------------------

--
-- Estrutura da tabela `payments`
--

CREATE TABLE `payments` (
  `PaymentID` int(10) UNSIGNED NOT NULL,
  `PaymentMoment` timestamp NULL DEFAULT NULL,
  `PaymentValue` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `payments`
--

INSERT INTO `payments` (`PaymentID`, `PaymentMoment`, `PaymentValue`) VALUES
(1, '2020-06-07 21:00:00', 150),
(2, '2020-06-07 21:00:00', 50),
(3, '2020-06-09 13:45:14', 150),
(4, '2020-06-09 13:45:14', 50),
(5, '2020-06-09 14:40:30', 150),
(6, '2020-06-09 14:40:30', 50),
(7, '2020-06-09 14:51:01', 150),
(8, '2020-06-09 14:51:01', 50),
(9, '2020-06-10 15:14:33', 60);

-- --------------------------------------------------------

--
-- Estrutura da tabela `products`
--

CREATE TABLE `products` (
  `ProductID` int(11) UNSIGNED NOT NULL,
  `ProductName` varchar(50) DEFAULT NULL,
  `ProductPrice` double DEFAULT NULL,
  `ProductDesc` varchar(255) DEFAULT NULL,
  `CategoryID` int(11) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `products`
--

INSERT INTO `products` (`ProductID`, `ProductName`, `ProductPrice`, `ProductDesc`, `CategoryID`) VALUES
(1, 'Macarrão a bolonhesa', 24.99, 'Macarrão feito com molho de tomate e carne moída', 1),
(2, 'Macarrão ao pesto', 19.99, 'Macarrão com molho a base de ervas', 1),
(3, 'Macarrão a bolonhesa', 24.99, 'Macarrão feito com molho de tomate e carne moída', 2),
(4, 'Macarrão ao pesto', 19.99, 'Macarrão com molho a base de ervas', 2),
(5, 'Ceasar Salad', 15, 'Salada com croutons', 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `waiters`
--

CREATE TABLE `waiters` (
  `WaiterID` int(11) UNSIGNED NOT NULL,
  `WaiterName` varchar(55) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `billpayment`
--
ALTER TABLE `billpayment`
  ADD PRIMARY KEY (`PaymentID`,`IndividualBillID`),
  ADD KEY `IndividualBillID` (`IndividualBillID`);

--
-- Índices para tabela `bills`
--
ALTER TABLE `bills`
  ADD PRIMARY KEY (`BillID`);

--
-- Índices para tabela `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`CategoryID`);

--
-- Índices para tabela `individualbills`
--
ALTER TABLE `individualbills`
  ADD PRIMARY KEY (`IndividualBillID`),
  ADD KEY `individualbills_ibfk_1` (`BillID`);

--
-- Índices para tabela `orderitem`
--
ALTER TABLE `orderitem`
  ADD PRIMARY KEY (`OrderItemID`),
  ADD KEY `OrderID` (`OrderID`),
  ADD KEY `ProductID` (`ProductID`);

--
-- Índices para tabela `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`OrderID`),
  ADD KEY `IndividualBillID` (`IndividualBillID`);

--
-- Índices para tabela `payments`
--
ALTER TABLE `payments`
  ADD PRIMARY KEY (`PaymentID`);

--
-- Índices para tabela `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`ProductID`),
  ADD KEY `CategoryID` (`CategoryID`);

--
-- Índices para tabela `waiters`
--
ALTER TABLE `waiters`
  ADD PRIMARY KEY (`WaiterID`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `bills`
--
ALTER TABLE `bills`
  MODIFY `BillID` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT de tabela `categories`
--
ALTER TABLE `categories`
  MODIFY `CategoryID` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `individualbills`
--
ALTER TABLE `individualbills`
  MODIFY `IndividualBillID` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT de tabela `orderitem`
--
ALTER TABLE `orderitem`
  MODIFY `OrderItemID` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `orders`
--
ALTER TABLE `orders`
  MODIFY `OrderID` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `payments`
--
ALTER TABLE `payments`
  MODIFY `PaymentID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de tabela `products`
--
ALTER TABLE `products`
  MODIFY `ProductID` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `waiters`
--
ALTER TABLE `waiters`
  MODIFY `WaiterID` int(11) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `billpayment`
--
ALTER TABLE `billpayment`
  ADD CONSTRAINT `billpayment_ibfk_1` FOREIGN KEY (`PaymentID`) REFERENCES `payments` (`PaymentID`),
  ADD CONSTRAINT `billpayment_ibfk_2` FOREIGN KEY (`IndividualBillID`) REFERENCES `individualbills` (`IndividualBillID`);

--
-- Limitadores para a tabela `individualbills`
--
ALTER TABLE `individualbills`
  ADD CONSTRAINT `individualbills_ibfk_1` FOREIGN KEY (`BillID`) REFERENCES `bills` (`BillID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `orderitem`
--
ALTER TABLE `orderitem`
  ADD CONSTRAINT `orderitem_ibfk_1` FOREIGN KEY (`OrderID`) REFERENCES `orders` (`OrderID`),
  ADD CONSTRAINT `orderitem_ibfk_2` FOREIGN KEY (`ProductID`) REFERENCES `products` (`ProductID`);

--
-- Limitadores para a tabela `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`IndividualBillID`) REFERENCES `individualbills` (`IndividualBillID`);

--
-- Limitadores para a tabela `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `products_ibfk_1` FOREIGN KEY (`CategoryID`) REFERENCES `categories` (`CategoryID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
