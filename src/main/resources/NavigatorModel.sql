-- MySQL Script generated by MySQL Workbench
-- Wed Feb 15 12:41:16 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema navigatordb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `navigatordb` ;

-- -----------------------------------------------------
-- Schema navigatordb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `navigatordb` DEFAULT CHARACTER SET utf8 ;
USE `navigatordb` ;

-- -----------------------------------------------------
-- Table `navigatordb`.`City`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `navigatordb`.`City` (
  `idCity` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCity`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `navigatordb`.`Street`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `navigatordb`.`Street` (
  `idStreet` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `idCity` INT NULL,
  PRIMARY KEY (`idStreet`),
  INDEX `fk_Street_City_idx` (`idCity` ASC) VISIBLE,
  CONSTRAINT `fk_Street_City`
    FOREIGN KEY (`idCity`)
    REFERENCES `navigatordb`.`City` (`idCity`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `navigatordb`.`StreetLocation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `navigatordb`.`StreetLocation` (
  `idStreetLocation` INT NOT NULL AUTO_INCREMENT,
  `streetNumber` INT NOT NULL,
  `xCoordinate` DOUBLE NOT NULL,
  `yCoordinate` DOUBLE NOT NULL,
  `idStreet` INT NULL,
  PRIMARY KEY (`idStreetLocation`),
  INDEX `fk_StreetLocation_Street1_idx` (`idStreet` ASC) VISIBLE,
  CONSTRAINT `fk_StreetLocation_Street1`
    FOREIGN KEY (`idStreet`)
    REFERENCES `navigatordb`.`Street` (`idStreet`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `navigatordb`.`PublicTransport`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `navigatordb`.`PublicTransport` (
  `idPublicTransport` INT NOT NULL AUTO_INCREMENT,
  `publicTransportNumber` INT NOT NULL,
  `averageSpeed` DOUBLE NOT NULL,
  PRIMARY KEY (`idPublicTransport`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `navigatordb`.`Car`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `navigatordb`.`Car` (
  `idCar` INT NOT NULL,
  `averageSpeed` DOUBLE NOT NULL,
  `make` VARCHAR(45) NULL,
  `model` VARCHAR(45) NULL,
  `productionYear` INT NULL,
  `bodyType` VARCHAR(45) NULL,
  PRIMARY KEY (`idCar`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `navigatordb`.`PublicTransportDirections`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `navigatordb`.`PublicTransportDirections` (
  `idPublicTransportDirections` INT NOT NULL AUTO_INCREMENT,
  `idPublicTransport` INT NOT NULL,
  `idStreetLocation` INT NOT NULL,
  PRIMARY KEY (`idPublicTransportDirections`, `idPublicTransport`, `idStreetLocation`),
  INDEX `fk_PublicTransport_has_StreetLocation_StreetLocation1_idx` (`idStreetLocation` ASC) VISIBLE,
  INDEX `fk_PublicTransport_has_StreetLocation_PublicTransport1_idx` (`idPublicTransport` ASC) VISIBLE,
  CONSTRAINT `fk_PublicTransport_has_StreetLocation_PublicTransport1`
    FOREIGN KEY (`idPublicTransport`)
    REFERENCES `navigatordb`.`PublicTransport` (`idPublicTransport`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_PublicTransport_has_StreetLocation_StreetLocation1`
    FOREIGN KEY (`idStreetLocation`)
    REFERENCES `navigatordb`.`StreetLocation` (`idStreetLocation`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `navigatordb`.`Directions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `navigatordb`.`Directions` (
  `idDirections` INT NOT NULL AUTO_INCREMENT,
  `idStreetLocation1` INT NOT NULL,
  `idStreetLocation2` INT NOT NULL,
  `trafficLight` TINYINT NOT NULL,
  PRIMARY KEY (`idDirections`, `idStreetLocation1`, `idStreetLocation2`),
  INDEX `fk_StreetLocation_has_StreetLocation_StreetLocation2_idx` (`idStreetLocation2` ASC) VISIBLE,
  INDEX `fk_StreetLocation_has_StreetLocation_StreetLocation1_idx` (`idStreetLocation1` ASC) VISIBLE,
  CONSTRAINT `fk_StreetLocation_has_StreetLocation_StreetLocation1`
    FOREIGN KEY (`idStreetLocation1`)
    REFERENCES `navigatordb`.`StreetLocation` (`idStreetLocation`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_StreetLocation_has_StreetLocation_StreetLocation2`
    FOREIGN KEY (`idStreetLocation2`)
    REFERENCES `navigatordb`.`StreetLocation` (`idStreetLocation`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
