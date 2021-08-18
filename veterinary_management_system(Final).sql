

DROP DATABASE IF EXISTS `veterinary_management_system`;
CREATE DATABASE `veterinary_management_system`;
USE `veterinary_management_system`;


SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `veterinary_management_system`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `customer`
--

CREATE TABLE `customer` (
  `custID` varchar(11) NOT NULL,
  `fName` varchar(50) NOT NULL,
  `lName` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `customer`
--

INSERT INTO `customer` (`custID`, `fName`, `lName`) VALUES
('C1', 'Ali', 'Mahmut'),
('C10', 'Harun', 'Cihan'),
('C11', 'Mesile Kiraz', 'Erdogmus'),
('C12', 'Busra', 'Uzeyir'),
('C13', 'Ozcan', 'Nargil'),
('C14', 'Tarkan Ergun', 'Leman'),
('C15', 'Yahya', 'Bengu'),
('C16', 'Fatih', 'Sebil'),
('C17', 'Hande', 'Zuhre'),
('C18', 'Timur', 'Nezih'),
('C19', 'Erhan Mustafa', 'Mutlu'),
('C2', 'Mansur Kursat', 'Pekefendi'),
('C20', 'Ozlem', 'Kale'),
('C3', 'Nihal', 'Melda'),
('C4', 'Orkun', 'Isik'),
('C5', 'Demet', 'Songul'),
('C6', 'Derya Coskun', 'Ulu'),
('C7', 'Mehmet Halil', 'Hocoglu'),
('C8', 'Berkay', 'Cetin'),
('C9', 'Erkan Kerim', 'Durmaz');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `customerphonenumber`
--

CREATE TABLE `customerphonenumber` (
  `custID` varchar(11) NOT NULL,
  `cusPhoneNumber` varchar(13) NOT NULL 
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;
--
-- Tablo döküm verisi `customerphonenumber`
--

INSERT INTO `customerphonenumber` (`custID`, `cusPhoneNumber`) VALUES
('C1', '505-558-8545'),
('C1', '505-558-8548'),
('C1', '505-558-8549'),
('C10', '545-553-4143'),
('C10', '545-553-4144'),
('C11', '555-555-5391'),
('C11', '555-555-5396'),
('C12', '505-554-8371'),
('C12', '505-554-9422'),
('C13', '505-556-3788'),
('C14', '555-551-6657'),
('C15', '555-554-8753'),
('C16', '505-553-6374'),
('C17', '505-559-4079'),
('C18', '505-559-4181'),
('C19', '545-552-0325'),
('C19', '555-550-5782'),
('C2', '505-550-3017'),
('C2', '505-550-3216'),
('C2', '505-550-3319'),
('C20', '505-555-8524'),
('C20', '505-558-3208'),
('C3', '505-559-7868'),
('C4', '545-555-7571'),
('C5', '535-551-4488'),
('C6', '555-550-1944'),
('C7', '545-550-2854'),
('C8', '505-556-52737'),
('C8', '545-550-4911'),
('C8', '545-559-8170'),
('C9', '505-556-5001');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `invoice`
--

CREATE TABLE `invoice` (
  `invoiceID` varchar(11) NOT NULL,
  `serviceID` varchar(11) NOT NULL,
  `custID` varchar(11) NOT NULL,
  `paymentMethod` varchar(12) DEFAULT NULL,
  `paymentDate` date DEFAULT NULL,
  `cost` decimal(6,2) NOT NULL CHECK (`cost` >= 0.00)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `invoice`
--

INSERT INTO `invoice` (`invoiceID`, `serviceID`, `custID`, `paymentMethod`, `paymentDate`, `cost`) VALUES
('I1', 'S1', 'C1', 'Cash', '2019-08-25', '50.00'),
('I10', 'S10', 'C3', 'Cash', '2021-03-12', '60.00'),
('I11', 'S11', 'C4', 'Cash', '2020-12-12', '62.00'),
('I12', 'S12', 'C4', 'Cash', '2021-03-12', '50.00'),
('I13', 'S13', 'C5', 'Credit Card', '2019-06-25', '100.00'),
('I14', 'S14', 'C5', 'Credit Card', '2020-05-24', '150.00'),
('I15', 'S15', 'C5', 'Cash', '2021-03-12', '32.00'),
('I16', 'S16', 'C6', 'Credit Card', '2021-08-11', '80.00'),
('I17', 'S17', 'C7', 'Cash', '2021-03-12', '58.00'),
('I18', 'S18', 'C8', 'Cash', '2021-08-13', '18.00'),
('I19', 'S19', 'C9', 'Credit Card', '2021-07-17', '65.00'),
('I2', 'S2', 'C1', 'Cash', '2020-07-20', '56.00'),
('I20', 'S20', 'C10', 'Credit Card', '2020-06-25', '40.00'),
('I21', 'S21', 'C11', 'Cash', '2021-09-12', '48.00'),
('I22', 'S22', 'C12', 'Credit Card', '2021-09-25', '40.00'),
('I23', 'S23', 'C13', 'Cash', '2021-08-21', '52.00'),
('I24', 'S24', 'C14', 'Cash', '2021-08-21', '52.00'),
('I25', 'S25', 'C15', 'Credit Card', '2021-08-25', '100.00'),
('I26', 'S26', 'C16', 'Credit Card', '2021-08-24', '200.00'),
('I27', 'S27', 'C17', 'Credit Card', '2021-08-24', '140.00'),
('I28', 'S28', 'C18', 'Credit Card', '2021-03-20', '300.00'),
('I29', 'S29', 'C19', 'Cash', '2021-08-25', '50.00'),
('I30', 'S30', 'C20', 'Cash', '2021-06-25', '200.00'),
('I31', 'S31', 'C1', 'Cash', '2021-06-25', '150.00'),
('I32', 'S32', 'C11', 'Cash', '2021-06-25', '180.00'),
('I4', 'S4', 'C1', 'Credit Card', '2021-01-02', '60.00'),
('I5', 'S5', 'C1', 'Credit Card', '2021-03-12', '60.00'),
('I6', 'S6', 'C2', 'Credit Card', '2021-01-02', '60.00'),
('I7', 'S7', 'C2', 'Cash', '2019-06-28', '55.00'),
('I8', 'S8', 'C3', 'Cash', '2020-08-20', '26.00'),
('I9', 'S9', 'C3', 'Credit Card', '2021-02-26', '400.00');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `needs`
--

CREATE TABLE `needs` (
  `petID` varchar(11) NOT NULL,
  `serviceID` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `needs`
--

INSERT INTO `needs` (`petID`, `serviceID`) VALUES
('P1', 'S1'),
('P1', 'S31'),
('P10', 'S10'),
('P11', 'S11'),
('P11', 'S32'),
('P12', 'S12'),
('P13', 'S13'),
('P14', 'S14'),
('P15', 'S15'),
('P16', 'S16'),
('P17', 'S17'),
('P18', 'S18'),
('P19', 'S19'),
('P2', 'S2'),
('P20', 'S20'),
('P21', 'S21'),
('P22', 'S22'),
('P23', 'S23'),
('P24', 'S24'),
('P25', 'S25'),
('P26', 'S26'),
('P27', 'S27'),
('P28', 'S28'),
('P29', 'S29'),
('P3', 'S3'),
('P30', 'S30'),
('P4', 'S4'),
('P5', 'S5'),
('P6', 'S6'),
('P7', 'S7'),
('P8', 'S8'),
('P9', 'S9');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `pet`
--

CREATE TABLE `pet` (
  `petID` varchar(11) NOT NULL,
  `custID` varchar(11) NOT NULL,
  `PetCharID` varchar(11) NOT NULL,
  `petBirthDate` date NOT NULL,
  `petGender` varchar(1) NOT NULL,
  `petType` varchar(11) NOT NULL,
  `adoptionDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `pet`
--

INSERT INTO `pet` (`petID`, `custID`, `PetCharID`, `petBirthDate`, `petGender`, `petType`, `adoptionDate`) VALUES
('P1', 'C1', 'PC1', '2015-04-10', 'M', 'Duck', '2015-04-11'),
('P10', 'C3', 'PC10', '2012-04-10', 'M', 'Hamster', '2012-04-28'),
('P11', 'C4', 'PC11', '2016-06-09', 'F', 'Cat', '2016-06-09'),
('P12', 'C4', 'PC12', '2019-09-10', 'M', 'Bird', '2019-12-01'),
('P13', 'C5', 'PC13', '2021-01-02', 'M', 'Dog', '2021-10-19'),
('P14', 'C5', 'PC14', '2006-09-01', 'F', 'Horse', '2010-12-15'),
('P15', 'C5', 'PC15', '2008-05-10', 'M', 'Cat', '2009-07-13'),
('P16', 'C6', 'PC16', '2009-02-01', 'M', 'Duck', '2011-11-11'),
('P17', 'C7', 'PC17', '2020-01-11', 'M', 'Hamster', '2020-05-17'),
('P18', 'C8', 'PC18', '2017-04-08', 'F', 'Bird', '2018-01-02'),
('P19', 'C9', 'PC19', '2015-08-10', 'F', 'Dog', '2015-09-09'),
('P2', 'C1', 'PC2', '2019-06-11', 'F', 'Cat', '2019-06-11'),
('P20', 'C10', 'PC20', '2015-04-10', 'M', 'Dog', '2018-02-07'),
('P21', 'C11', 'PC21', '2021-03-04', 'M', 'Cat', '2021-07-07'),
('P22', 'C12', 'PC22', '2020-02-05', 'F', 'Duck', '2020-03-13'),
('P23', 'C13', 'PC23', '2015-04-10', 'F', 'Bird', '2015-06-29'),
('P24', 'C14', 'PC24', '2011-01-10', 'M', 'Bird', '2011-11-27'),
('P25', 'C15', 'PC25', '2018-04-10', 'M', 'Cat', '2018-07-19'),
('P26', 'C16', 'PC26', '2016-06-06', 'F', 'Dog', '2016-06-17'),
('P27', 'C17', 'PC27', '2019-02-10', 'M', 'Dog', '2019-05-23'),
('P28', 'C18', 'PC28', '2012-02-05', 'M', 'Horse', '2017-08-13'),
('P29', 'C19', 'PC29', '2021-07-05', 'F', 'Hamster', '2021-09-03'),
('P3', 'C1', 'PC3', '2019-01-01', 'M', 'Horse', '2019-02-01'),
('P30', 'C20', 'PC30', '2020-06-08', 'M', 'Dog', '2020-09-12'),
('P4', 'C1', 'PC4', '2017-05-12', 'M', 'Dog', '2017-07-10'),
('P5', 'C1', 'PC5', '2016-03-04', 'F', 'Cat', '2016-03-04'),
('P6', 'C2', 'PC6', '2018-08-09', 'M', 'Dog', '2019-08-07'),
('P7', 'C2', 'PC7', '2021-04-11', 'M', 'Cat', '2021-04-11'),
('P8', 'C3', 'PC8', '2015-04-10', 'M', 'Dog', '2015-08-16'),
('P9', 'C3', 'PC9', '2017-07-01', 'F', 'Horse', '2020-10-12');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `petcharacteristic`
--

CREATE TABLE `petcharacteristic` (
  `PetCharID` varchar(11) NOT NULL,
  `petHeight` decimal(5,2) DEFAULT NULL,
  `petWeight` decimal(4,1) NOT NULL,
  `petLength` decimal(5,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `petcharacteristic`
--

INSERT INTO `petcharacteristic` (`PetCharID`, `petHeight`, `petWeight`, `petLength`) VALUES
('PC1', '90.20', '50.1', '120.40'),
('PC10', '2.50', '1.2', '5.40'),
('PC11', '27.70', '7.0', '40.40'),
('PC12', '9.90', '0.7', '2.40'),
('PC13', '50.20', '4.4', '60.40'),
('PC14', '170.50', '129.1', '124.60'),
('PC15', '20.60', '11.2', '40.70'),
('PC16', '100.50', '5.7', '50.80'),
('PC17', '0.80', '0.1', '1.40'),
('PC18', '14.40', '0.2', '2.50'),
('PC19', '50.20', '8.1', '70.40'),
('PC2', '10.20', '1.2', '20.40'),
('PC20', '40.40', '5.1', '70.40'),
('PC21', '14.40', '2.1', '20.90'),
('PC22', '92.50', '3.5', '40.40'),
('PC23', '26.60', '1.2', '7.40'),
('PC24', '20.20', '0.6', '7.50'),
('PC25', '14.60', '4.5', '20.40'),
('PC26', '100.20', '52.4', '125.40'),
('PC27', '12.20', '5.1', '18.50'),
('PC28', '200.20', '69.9', '150.50'),
('PC29', '1.20', '0.7', '2.40'),
('PC3', '100.20', '52.5', '150.60'),
('PC30', '42.00', '54.5', '70.40'),
('PC4', '70.20', '40.2', '97.60'),
('PC5', '14.30', '3.4', '22.50'),
('PC6', '40.20', '10.1', '60.70'),
('PC7', '20.20', '1.5', '23.70'),
('PC8', '63.70', '7.8', '80.80'),
('PC9', '140.20', '45.3', '120.40');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `provides`
--

CREATE TABLE `provides` (
  `vetID` varchar(11) NOT NULL,
  `serviceID` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `provides`
--

INSERT INTO `provides` (`vetID`, `serviceID`) VALUES
('V1', 'S1'),
('V1', 'S2'),
('V1', 'S3'),
('V1', 'S4'),
('V2', 'S1'),
('V2', 'S2'),
('V2', 'S3'),
('V2', 'S8'),
('V3', 'S1'),
('V3', 'S10'),
('V3', 'S11'),
('V3', 'S12'),
('V3', 'S2'),
('V3', 'S3'),
('V3', 'S9'),
('V4', 'S13'),
('V4', 'S14'),
('V4', 'S15'),
('V4', 'S16'),
('V4', 'S17'),
('V4', 'S6'),
('V5', 'S18'),
('V5', 'S19'),
('V5', 'S20'),
('V5', 'S7'),
('V6', 'S21'),
('V6', 'S22'),
('V6', 'S23'),
('V6', 'S24'),
('V6', 'S25'),
('V6', 'S26'),
('V6', 'S27'),
('V6', 'S28'),
('V6', 'S29'),
('V7', 'S30'),
('V7', 'S31'),
('V7', 'S32'),
('V7', 'S5');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `service`
--

CREATE TABLE `service` (
  `serviceID` varchar(11) NOT NULL,
  `custID` varchar(11) NOT NULL,
  `rDate` datetime NOT NULL,
  `serviceType` varchar(80) NOT NULL,
  `serviceDesp` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `service`
--

INSERT INTO `service` (`serviceID`, `custID`, `rDate`, `serviceType`, `serviceDesp`) VALUES
('S1', 'C1', '2019-08-25 12:30:00', 'Radiology', 'X-ray, CT scan and MRI scan'),
('S10', 'C3', '2021-03-12 13:30:00', 'Electrotherapy', 'Electrotherapy for neorological diseases'),
('S11', 'C4', '2020-12-12 18:45:00', 'Skin disease', 'Laser surgery'),
('S12', 'C4', '2021-03-12 08:45:00', 'Blood haematology', 'Blood-realted testing and diseases'),
('S13', 'C5', '2019-06-25 08:30:00', 'Faecal assay', ''),
('S14', 'C5', '2020-05-24 13:15:00', 'Hydrotherapy', 'Treatment for conditions such as arthritis or partial paralysis'),
('S15', 'C5', '2021-03-12 19:00:00', 'Biochemistry', 'Biochemistry tests'),
('S16', 'C6', '2021-08-11 13:00:00', 'Allergy management', 'Allergy management & cultures'),
('S17', 'C7', '2021-03-12 11:00:00', 'Examination', 'Examined'),
('S18', 'C8', '2021-08-13 13:45:00', 'Electrotherapy', 'Electrotherapy for neorological diseases'),
('S19', 'C9', '2021-07-17 13:00:00', 'Medical therapies', 'Medical therapies'),
('S2', 'C1', '2020-07-20 13:00:00', 'Medical therapies', 'Medical therapies'),
('S20', 'C10', '2020-06-25 09:15:00', 'Blood haematology', 'Blood-realted testing and diseases'),
('S21', 'C11', '2021-09-12 09:45:00', 'Allergies', 'Allergies & intolerances'),
('S22', 'C12', '2021-09-25 12:15:00', 'Allergy management', 'Allergy management & cultures'),
('S23', 'C13', '2021-08-21 15:15:00', 'Medical therapies', 'Medical therapies'),
('S24', 'C14', '2021-08-21 15:45:00', 'Medical therapies', 'Medical therapies'),
('S25', 'C15', '2021-08-25 16:50:00', 'Radiology', 'X-ray, CT scan and MRI scan'),
('S26', 'C16', '2021-08-24 17:45:00', 'Hydrotherapy', 'treatment for conditions such as arthritis or partial paralysis'),
('S27', 'C17', '2021-08-24 13:45:00', 'Cryo surgery', 'Cryo surgery'),
('S28', 'C18', '2021-03-20 13:00:00', 'Surgery', 'Surgical procedure was performed'),
('S29', 'C19', '2021-08-25 16:00:00', 'Examination', 'Examined'),
('S3', 'C1', '2020-05-15 12:30:00', 'Cryo surgery', 'Cryo surgery'),
('S30', 'C20', '2021-06-25 13:00:00', 'Medical therapies', 'Medical therapies'),
('S31', 'C1', '2019-08-24 17:30:00', 'Medical therapies', 'Medical therapies'),
('S32', 'C11', '2020-12-11 13:45:00', 'Cryo surgery', 'Cryo surgery'),
('S4', 'C1', '2021-01-02 09:30:00', 'Biochemistry', 'Biochemistry tests'),
('S5', 'C1', '2021-03-12 16:45:00', 'Skin analysis', 'Analysis of skin'),
('S6', 'C2', '2019-08-25 16:00:00', 'Radiology', 'X-ray, CT scan and MRI scan'),
('S7', 'C2', '2019-06-28 15:30:00', 'Cytology', 'Study and testing of cell structure'),
('S8', 'C3', '2020-08-20 12:45:00', 'Medical therapies', 'Medical therapies'),
('S9', 'C3', '2021-02-26 13:00:00', 'Histology', 'Microscopic anatomy (microanatomy)');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `vet`
--

CREATE TABLE `vet` (
  `vetID` varchar(11) NOT NULL,
  `fName` varchar(50) NOT NULL,
  `lName` varchar(20) NOT NULL,
  `vetEmail` varchar(255) NOT NULL UNIQUE,
  `vetAddress` varchar(260) NOT NULL,
  `vetWorkPhone` varchar(13) NOT NULL,
  `vetPosition` varchar(30) NOT NULL,
  `vetQualification` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `vet`
--

INSERT INTO `vet` (`vetID`, `fName`, `lName`, `vetEmail`, `vetAddress`, `vetWorkPhone`, `vetPosition`, `vetQualification`) VALUES
('V1', 'Cahit', 'Pekgöz', 'cahitpekgoz@example.com', 'Cevatbey Mah. Tekgöz Sok. No:26/4 Istanbul/Kadıköy', '542-675-2378', 'Veterinerian', 'Bachelor'),
('V2', 'Cihan', 'Koç', 'cihankoc@example.com', 'Atatürk Mah. Canan Sok. No:12/2 İstanbul/Esenler', '542-675-4387', 'Veterinerian', 'Bachelor'),
('V3', 'Canan', 'Karakoç', 'canankarakoc@example.com', 'Kanun Mah. Efendi Sok. No:4/1 İstanbul/Kadıköy', '542-675-2689', 'Veterinerian', 'Assistant'),
('V4', 'Gözde Ela', 'Perçin', 'elagozde@example.com', ' Kurşunyemez Mah. Sonbahar Sok. No:26/4 Istanbul/Üsküdar', '542-675-2355', 'Manager', 'Masters Degree'),
('V5', 'Altay', 'Perçin', 'altaypercin@example.com', 'Kurşunyemez Mah. Sonbahar Sok. No:26/4 Istanbul/Üsküdar', '542-675-2198', 'Manager', 'Masters Degree'),
('V6', 'Cenk', 'Dümenci', 'cenkdumenci@example.com', 'Cevatbey Mah. Çokgöz Sok. No:26/4 Istanbul/Kadıköy', '542-675-2973', 'Veterinerian', 'Bachelor'),
('V7', 'Berk', 'Tosun', 'tosunberk@example.com', 'Tosun Mah. Biriki Sok. No:14/8 Istanbul/Kadıköy', '542-675-2612', 'Veterinerian', 'Bachelor');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`custID`);

--
-- Tablo için indeksler `customerphonenumber`
--
ALTER TABLE `customerphonenumber`
  ADD PRIMARY KEY (`custID`,`cusPhoneNumber`),
  ADD UNIQUE KEY `cusPhoneNumber` (`cusPhoneNumber`);

--
-- Tablo için indeksler `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`invoiceID`),
  ADD KEY `custID` (`custID`),
  ADD KEY `serviceID` (`serviceID`);

--
-- Tablo için indeksler `needs`
--
ALTER TABLE `needs`
  ADD PRIMARY KEY (`petID`,`serviceID`),
  ADD KEY `serviceID` (`serviceID`);

--
-- Tablo için indeksler `pet`
--
ALTER TABLE `pet`
  ADD PRIMARY KEY (`petID`),
  ADD KEY `custID` (`custID`),
  ADD KEY `PetCharID` (`PetCharID`);

--
-- Tablo için indeksler `petcharacteristic`
--
ALTER TABLE `petcharacteristic`
  ADD PRIMARY KEY (`PetCharID`);

--
-- Tablo için indeksler `provides`
--
ALTER TABLE `provides`
  ADD PRIMARY KEY (`vetID`,`serviceID`),
  ADD KEY `serviceID` (`serviceID`);

--
-- Tablo için indeksler `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`serviceID`),
  ADD UNIQUE KEY `rDate` (`rDate`),
  ADD KEY `custID` (`custID`);

--
-- Tablo için indeksler `vet`
--
ALTER TABLE `vet`
  ADD PRIMARY KEY (`vetID`),
  ADD UNIQUE KEY `vetWorkPhone` (`vetWorkPhone`);

--
-- Dökümü yapılmış tablolar için kısıtlamalar
--

--
-- Tablo kısıtlamaları `customerphonenumber`
--
ALTER TABLE `customerphonenumber`
  ADD CONSTRAINT `customerphonenumber_ibfk_1` FOREIGN KEY (`custID`) REFERENCES `customer` (`custID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Tablo kısıtlamaları `invoice`
--
ALTER TABLE `invoice`
  ADD CONSTRAINT `invoice_ibfk_1` FOREIGN KEY (`custID`) REFERENCES `customer` (`custID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `invoice_ibfk_2` FOREIGN KEY (`serviceID`) REFERENCES `service` (`serviceID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Tablo kısıtlamaları `needs`
--
ALTER TABLE `needs`
  ADD CONSTRAINT `needs_ibfk_1` FOREIGN KEY (`petID`) REFERENCES `pet` (`petID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `needs_ibfk_2` FOREIGN KEY (`serviceID`) REFERENCES `service` (`serviceID`) ON DELETE CASCADE ON UPDATE CASCADE ;

--
-- Tablo kısıtlamaları `pet`
--
ALTER TABLE `pet`
  ADD CONSTRAINT `pet_ibfk_1` FOREIGN KEY (`custID`) REFERENCES `customer` (`custID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pet_ibfk_2` FOREIGN KEY (`PetCharID`) REFERENCES `petcharacteristic` (`PetCharID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Tablo kısıtlamaları `provides`
--
ALTER TABLE `provides`
  ADD CONSTRAINT `provides_ibfk_1` FOREIGN KEY (`vetID`) REFERENCES `vet` (`vetID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `provides_ibfk_2` FOREIGN KEY (`serviceID`) REFERENCES `service` (`serviceID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Tablo kısıtlamaları `service`
--
ALTER TABLE `service`
  ADD CONSTRAINT `service_ibfk_1` FOREIGN KEY (`custID`) REFERENCES `customer` (`custID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
