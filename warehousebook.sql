-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 12, 2023 at 08:48 AM
-- Server version: 8.0.32
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `warehousebook`
--

-- --------------------------------------------------------

--
-- Table structure for table `amenity`
--

CREATE TABLE `amenity` (
  `AmenityId` int NOT NULL,
  `AmenityName` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `amenity`
--

INSERT INTO `amenity` (`AmenityId`, `AmenityName`) VALUES
(1, 'Lift / Elevator'),
(2, 'Truck Parking'),
(3, 'Power Backup'),
(4, 'Office Space'),
(5, 'DG Space'),
(6, 'Lights'),
(7, 'Fans'),
(8, 'Dock Levellers'),
(9, 'Pallettes'),
(10, 'Hand Pallette Trucks');

-- --------------------------------------------------------

--
-- Table structure for table `amenityincluded`
--

CREATE TABLE `amenityincluded` (
  `amenityIncludedId` int NOT NULL,
  `amenityId` int NOT NULL,
  `warehouseId` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `BookingId` int NOT NULL,
  `StartDate` date NOT NULL,
  `EndDate` date NOT NULL,
  `WarehouseId` int NOT NULL,
  `ParticipateId` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE `city` (
  `CityId` int NOT NULL,
  `CityName` varchar(45) NOT NULL,
  `CountryId` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `city`
--

INSERT INTO `city` (`CityId`, `CityName`, `CountryId`) VALUES
(1, 'Surat', 1),
(2, 'Hydrabad', 1),
(3, 'Ahemdabad', 1),
(4, 'Maharastra', 1);

-- --------------------------------------------------------

--
-- Table structure for table `compliances`
--

CREATE TABLE `compliances` (
  `CompliancesId` int NOT NULL,
  `CompliancName` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `compliances`
--

INSERT INTO `compliances` (`CompliancesId`, `CompliancName`) VALUES
(1, 'Extinguisher'),
(2, 'Hydrants'),
(3, 'Sprinklers'),
(4, 'Fire Detectors');

-- --------------------------------------------------------

--
-- Table structure for table `compliencesincluded`
--

CREATE TABLE `compliencesincluded` (
  `compliencesincludedId` int NOT NULL,
  `compliencesId` int NOT NULL,
  `warehouseId` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `construction`
--

CREATE TABLE `construction` (
  `ConstructionId` int NOT NULL,
  `ConstructionType` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `construction`
--

INSERT INTO `construction` (`ConstructionId`, `ConstructionType`) VALUES
(1, 'PEB'),
(2, 'Cold Storage'),
(3, 'RCC'),
(4, 'Shed'),
(5, 'Other');

-- --------------------------------------------------------

--
-- Table structure for table `country`
--

CREATE TABLE `country` (
  `CountryId` int NOT NULL,
  `CountryName` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `country`
--

INSERT INTO `country` (`CountryId`, `CountryName`) VALUES
(1, 'India'),
(2, 'Austria'),
(3, 'France'),
(4, 'Canada'),
(5, 'China');

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE `invoice` (
  `InvoiceId` int NOT NULL,
  `BookingId` int NOT NULL,
  `CurrentTime` datetime NOT NULL,
  `InvoiceAmount` double NOT NULL,
  `PaymentId` varchar(45) NOT NULL,
  `PaymentStatus` tinyint NOT NULL,
  `PaymentType` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `invoiceitem`
--

CREATE TABLE `invoiceitem` (
  `InvoiceItemId` int NOT NULL,
  `ItemName` varchar(100) NOT NULL,
  `Item_Price` double NOT NULL,
  `InvoiceId` int NOT NULL,
  `ServiceIncludedId` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

CREATE TABLE `location` (
  `LocationId` int NOT NULL,
  `LocationName` varchar(100) NOT NULL,
  `CityId` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `participate`
--

CREATE TABLE `participate` (
  `ParticipateId` int NOT NULL,
  `PersonId` int NOT NULL,
  `RoleId` int NOT NULL,
  `Password` varchar(1080) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Username` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `participate`
--

INSERT INTO `participate` (`ParticipateId`, `PersonId`, `RoleId`, `Password`, `Username`) VALUES
(34, 66, 2, 'PBKDF2WithHmacSHA256:2048:f/kQuPo64DP70uonawBwVws0f9gwrC6Fu3r0cxTURLE=:78bh0AB29WS5lAVmo+PjStAvkKqh5Wa7SWbInHjdhVg=', 'zeel@gmail.com'),
(35, 67, 2, 'PBKDF2WithHmacSHA256:2048:Hraj9Uc8EQe6Ss+4hEbl0YehoktW+N0Pc2twjjSsHPU=:WfxOP8t1KcOff1l/NmruhrUwbdXKToeDrygT+NqVecw=', 'k@gmail.com'),
(36, 68, 2, 'PBKDF2WithHmacSHA256:2048:z+PRt3r9MsNAtBQzaauc8lUq8fWBrWo92XAHGYl09YY=:NPY9E51mA2/jHhXFFHoRMFFcARg8KymnZiqnKmomSmk=', 'ansh@gmail.com'),
(37, 69, 2, 'PBKDF2WithHmacSHA256:2048:/AIjuIBYKbBzqgdI7Sap2vdYFdcmtzb7fnD27eEyw/I=:bjpqaiV2fBnzmfjnpPOntl9DUaTvXDqtMnQQZq6WhsY=', 'jankipainter@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE `person` (
  `PersonId` int NOT NULL,
  `FirstName` varchar(45) NOT NULL,
  `LastName` varchar(45) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Phone` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`PersonId`, `FirstName`, `LastName`, `Email`, `Phone`) VALUES
(66, 'zeel', 'gamit', 'zeel@gmail.com', '8796759687'),
(67, 'kinjal', 'patel', 'k@gmail.com', '8767690767'),
(68, 'ansh', 'patel', 'ansh@gmail.com', '8796759687'),
(69, 'Janki', 'Painter', 'jankipainter@gmail.com', '7788669955');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `ProductId` int NOT NULL,
  `ProductCode` varchar(45) NOT NULL,
  `ProductName` varchar(100) NOT NULL,
  `ProductDescription` varchar(100) NOT NULL,
  `ProductPicture` varchar(100) DEFAULT NULL,
  `ProductPrice` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `productincluded`
--

CREATE TABLE `productincluded` (
  `ProductIncludedId` int NOT NULL,
  `WarehouseId` int NOT NULL,
  `ProductProvidedId` int NOT NULL,
  `Price` double DEFAULT NULL,
  `StatusId` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `producttype`
--

CREATE TABLE `producttype` (
  `ProductTypeId` int NOT NULL,
  `ProductType` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `producttype`
--

INSERT INTO `producttype` (`ProductTypeId`, `ProductType`) VALUES
(1, 'Accessories'),
(2, 'Apparel'),
(3, 'Automotives'),
(4, 'Construction Material'),
(5, 'Cosmetics'),
(6, 'Electronics'),
(7, 'Food & Beverages'),
(8, 'Food Grains'),
(9, 'Footware'),
(10, 'Furniture'),
(11, 'Grocery'),
(12, 'Heavy Equipments'),
(13, 'IT Equipments & Peripherals'),
(14, 'Lifestyle'),
(15, 'Luxury Items'),
(16, 'Oil & Gas'),
(17, 'Vehicles'),
(18, 'Others');

-- --------------------------------------------------------

--
-- Table structure for table `producttypeincluded`
--

CREATE TABLE `producttypeincluded` (
  `productTypeIncludedId` int NOT NULL,
  `productTypeId` int NOT NULL,
  `warehouseId` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `provideproduct`
--

CREATE TABLE `provideproduct` (
  `ProvideProductId` int NOT NULL,
  `ServicerId` int NOT NULL,
  `ProductId` int NOT NULL,
  `isActive` tinyint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `provideservice`
--

CREATE TABLE `provideservice` (
  `ProvideServiceId` int NOT NULL,
  `ServiceId` int NOT NULL,
  `ServicerId` int NOT NULL,
  `isActive` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `RoleId` int NOT NULL,
  `RoleName` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`RoleId`, `RoleName`) VALUES
(1, 'Admin'),
(2, 'Customer'),
(3, 'Service Provider');

-- --------------------------------------------------------

--
-- Table structure for table `service`
--

CREATE TABLE `service` (
  `ServiceId` int NOT NULL,
  `ServiceName` varchar(100) NOT NULL,
  `ServicePicture` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ServicePrice` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `serviceincluded`
--

CREATE TABLE `serviceincluded` (
  `ServiceIncludedId` int NOT NULL,
  `WarehouseId` int NOT NULL,
  `ProvideServiceId` int NOT NULL,
  `Price` double NOT NULL,
  `CurrentStatusId` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `status`
--

CREATE TABLE `status` (
  `StatusId` int NOT NULL,
  `StatusName` varchar(45) NOT NULL,
  `Status` tinyint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `status`
--

INSERT INTO `status` (`StatusId`, `StatusName`, `Status`) VALUES
(1, 'Active', 1),
(2, 'Inactive', 0);

-- --------------------------------------------------------

--
-- Table structure for table `warehouse`
--

CREATE TABLE `warehouse` (
  `WarehouseId` int NOT NULL,
  `ConstructionTypeId` int NOT NULL,
  `Area` double NOT NULL,
  `LocationId` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `amenity`
--
ALTER TABLE `amenity`
  ADD PRIMARY KEY (`AmenityId`);

--
-- Indexes for table `amenityincluded`
--
ALTER TABLE `amenityincluded`
  ADD PRIMARY KEY (`amenityIncludedId`),
  ADD KEY `FK_Amenityid_idx` (`amenityId`),
  ADD KEY `FK_Warehouseid_idx` (`warehouseId`);

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`BookingId`),
  ADD KEY `WarehouseID_idx` (`WarehouseId`),
  ADD KEY `ParticipateId` (`ParticipateId`);

--
-- Indexes for table `city`
--
ALTER TABLE `city`
  ADD PRIMARY KEY (`CityId`),
  ADD KEY `CountyId_idx` (`CountryId`);

--
-- Indexes for table `compliances`
--
ALTER TABLE `compliances`
  ADD PRIMARY KEY (`CompliancesId`);

--
-- Indexes for table `compliencesincluded`
--
ALTER TABLE `compliencesincluded`
  ADD PRIMARY KEY (`compliencesincludedId`),
  ADD KEY `FK_CompliencesId_idx` (`compliencesId`),
  ADD KEY `FK_WarehouseID_idx` (`warehouseId`);

--
-- Indexes for table `construction`
--
ALTER TABLE `construction`
  ADD PRIMARY KEY (`ConstructionId`);

--
-- Indexes for table `country`
--
ALTER TABLE `country`
  ADD PRIMARY KEY (`CountryId`);

--
-- Indexes for table `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`InvoiceId`),
  ADD KEY `BookingID_idx` (`BookingId`);

--
-- Indexes for table `invoiceitem`
--
ALTER TABLE `invoiceitem`
  ADD PRIMARY KEY (`InvoiceItemId`),
  ADD KEY `invoiceID_idx` (`InvoiceId`),
  ADD KEY `serviceIncludedId_idx` (`ServiceIncludedId`);

--
-- Indexes for table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`LocationId`),
  ADD KEY `CityId_idx` (`CityId`);

--
-- Indexes for table `participate`
--
ALTER TABLE `participate`
  ADD PRIMARY KEY (`ParticipateId`),
  ADD UNIQUE KEY `Username` (`Username`),
  ADD UNIQUE KEY `Username_2` (`Username`),
  ADD KEY `PersonID_idx` (`PersonId`),
  ADD KEY `RoleID_idx` (`RoleId`);

--
-- Indexes for table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`PersonId`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`ProductId`);

--
-- Indexes for table `productincluded`
--
ALTER TABLE `productincluded`
  ADD PRIMARY KEY (`ProductIncludedId`);

--
-- Indexes for table `producttype`
--
ALTER TABLE `producttype`
  ADD PRIMARY KEY (`ProductTypeId`);

--
-- Indexes for table `producttypeincluded`
--
ALTER TABLE `producttypeincluded`
  ADD PRIMARY KEY (`productTypeIncludedId`),
  ADD KEY `FK_ProductType_idx` (`productTypeId`),
  ADD KEY `FK_Warehouse_idx` (`warehouseId`);

--
-- Indexes for table `provideproduct`
--
ALTER TABLE `provideproduct`
  ADD PRIMARY KEY (`ProvideProductId`),
  ADD KEY `ServicerID_idx` (`ServicerId`),
  ADD KEY `ProductID_idx` (`ProductId`);

--
-- Indexes for table `provideservice`
--
ALTER TABLE `provideservice`
  ADD PRIMARY KEY (`ProvideServiceId`),
  ADD KEY `ServiceIdFK_idx` (`ServiceId`),
  ADD KEY `ServicerIdFK_idx` (`ServicerId`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`RoleId`);

--
-- Indexes for table `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`ServiceId`);

--
-- Indexes for table `serviceincluded`
--
ALTER TABLE `serviceincluded`
  ADD PRIMARY KEY (`ServiceIncludedId`),
  ADD KEY `WarehouseIdFK_idx` (`WarehouseId`),
  ADD KEY `ServiceProvidedIdFK_idx` (`ProvideServiceId`),
  ADD KEY `StatusIdFK_idx` (`CurrentStatusId`);

--
-- Indexes for table `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`StatusId`);

--
-- Indexes for table `warehouse`
--
ALTER TABLE `warehouse`
  ADD PRIMARY KEY (`WarehouseId`),
  ADD KEY `ConstructionIdFK_idx` (`ConstructionTypeId`),
  ADD KEY `LocationIdFK_idx` (`LocationId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `amenity`
--
ALTER TABLE `amenity`
  MODIFY `AmenityId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `amenityincluded`
--
ALTER TABLE `amenityincluded`
  MODIFY `amenityIncludedId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `booking`
--
ALTER TABLE `booking`
  MODIFY `BookingId` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `city`
--
ALTER TABLE `city`
  MODIFY `CityId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `compliances`
--
ALTER TABLE `compliances`
  MODIFY `CompliancesId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `compliencesincluded`
--
ALTER TABLE `compliencesincluded`
  MODIFY `compliencesincludedId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `construction`
--
ALTER TABLE `construction`
  MODIFY `ConstructionId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `country`
--
ALTER TABLE `country`
  MODIFY `CountryId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `invoice`
--
ALTER TABLE `invoice`
  MODIFY `InvoiceId` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `invoiceitem`
--
ALTER TABLE `invoiceitem`
  MODIFY `InvoiceItemId` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `location`
--
ALTER TABLE `location`
  MODIFY `LocationId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `participate`
--
ALTER TABLE `participate`
  MODIFY `ParticipateId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT for table `person`
--
ALTER TABLE `person`
  MODIFY `PersonId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=72;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `ProductId` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `productincluded`
--
ALTER TABLE `productincluded`
  MODIFY `ProductIncludedId` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `producttype`
--
ALTER TABLE `producttype`
  MODIFY `ProductTypeId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `producttypeincluded`
--
ALTER TABLE `producttypeincluded`
  MODIFY `productTypeIncludedId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `provideproduct`
--
ALTER TABLE `provideproduct`
  MODIFY `ProvideProductId` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `provideservice`
--
ALTER TABLE `provideservice`
  MODIFY `ProvideServiceId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `RoleId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `service`
--
ALTER TABLE `service`
  MODIFY `ServiceId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `serviceincluded`
--
ALTER TABLE `serviceincluded`
  MODIFY `ServiceIncludedId` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `status`
--
ALTER TABLE `status`
  MODIFY `StatusId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `warehouse`
--
ALTER TABLE `warehouse`
  MODIFY `WarehouseId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `amenityincluded`
--
ALTER TABLE `amenityincluded`
  ADD CONSTRAINT `FK_Amenityid` FOREIGN KEY (`amenityId`) REFERENCES `amenity` (`AmenityId`),
  ADD CONSTRAINT `FK_Warehouseid` FOREIGN KEY (`warehouseId`) REFERENCES `warehouse` (`WarehouseId`);

--
-- Constraints for table `booking`
--
ALTER TABLE `booking`
  ADD CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`ParticipateId`) REFERENCES `participate` (`ParticipateId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `WarehouseID` FOREIGN KEY (`WarehouseId`) REFERENCES `warehouse` (`WarehouseId`);

--
-- Constraints for table `city`
--
ALTER TABLE `city`
  ADD CONSTRAINT `CountyId` FOREIGN KEY (`CountryId`) REFERENCES `country` (`CountryId`);

--
-- Constraints for table `compliencesincluded`
--
ALTER TABLE `compliencesincluded`
  ADD CONSTRAINT `FK_CompliencesId` FOREIGN KEY (`compliencesId`) REFERENCES `compliances` (`CompliancesId`),
  ADD CONSTRAINT `FkWarehouseid` FOREIGN KEY (`warehouseId`) REFERENCES `warehouse` (`WarehouseId`);

--
-- Constraints for table `invoice`
--
ALTER TABLE `invoice`
  ADD CONSTRAINT `BookingID` FOREIGN KEY (`BookingId`) REFERENCES `booking` (`BookingId`);

--
-- Constraints for table `invoiceitem`
--
ALTER TABLE `invoiceitem`
  ADD CONSTRAINT `invoiceID` FOREIGN KEY (`InvoiceId`) REFERENCES `invoice` (`InvoiceId`),
  ADD CONSTRAINT `serviceIncludedId` FOREIGN KEY (`ServiceIncludedId`) REFERENCES `serviceincluded` (`ServiceIncludedId`);

--
-- Constraints for table `location`
--
ALTER TABLE `location`
  ADD CONSTRAINT `CityId` FOREIGN KEY (`CityId`) REFERENCES `city` (`CityId`);

--
-- Constraints for table `participate`
--
ALTER TABLE `participate`
  ADD CONSTRAINT `PersonID` FOREIGN KEY (`PersonId`) REFERENCES `person` (`PersonId`),
  ADD CONSTRAINT `RoleID` FOREIGN KEY (`RoleId`) REFERENCES `role` (`RoleId`);

--
-- Constraints for table `producttypeincluded`
--
ALTER TABLE `producttypeincluded`
  ADD CONSTRAINT `FK_ProductType` FOREIGN KEY (`productTypeId`) REFERENCES `producttype` (`ProductTypeId`),
  ADD CONSTRAINT `FK_Warehouse` FOREIGN KEY (`warehouseId`) REFERENCES `warehouse` (`WarehouseId`);

--
-- Constraints for table `provideservice`
--
ALTER TABLE `provideservice`
  ADD CONSTRAINT `ServiceIdFK` FOREIGN KEY (`ServiceId`) REFERENCES `service` (`ServiceId`),
  ADD CONSTRAINT `ServicerIdFK` FOREIGN KEY (`ServicerId`) REFERENCES `participate` (`ParticipateId`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Constraints for table `serviceincluded`
--
ALTER TABLE `serviceincluded`
  ADD CONSTRAINT `ServiceProvidedIdFK` FOREIGN KEY (`ProvideServiceId`) REFERENCES `provideservice` (`ProvideServiceId`),
  ADD CONSTRAINT `StatusIdFK` FOREIGN KEY (`CurrentStatusId`) REFERENCES `status` (`StatusId`),
  ADD CONSTRAINT `WarehouseIdFK` FOREIGN KEY (`WarehouseId`) REFERENCES `warehouse` (`WarehouseId`);

--
-- Constraints for table `warehouse`
--
ALTER TABLE `warehouse`
  ADD CONSTRAINT `ConstructionIdFK` FOREIGN KEY (`ConstructionTypeId`) REFERENCES `construction` (`ConstructionId`),
  ADD CONSTRAINT `LocationIdFK` FOREIGN KEY (`LocationId`) REFERENCES `location` (`LocationId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
