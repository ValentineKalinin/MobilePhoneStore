-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema MobilePhoneStore
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema MobilePhoneStore
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `MobilePhoneStore` DEFAULT CHARACTER SET utf8 ;
USE `MobilePhoneStore` ;

-- -----------------------------------------------------
-- Table `MobilePhoneStore`.`Models`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MobilePhoneStore`.`Models` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `model` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MobilePhoneStore`.`StoreAdress`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MobilePhoneStore`.`StoreAdress` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `adress` VARCHAR(225) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MobilePhoneStore`.`StoresSquare`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MobilePhoneStore`.`StoresSquare` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `square` DOUBLE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MobilePhoneStore`.`PhoneStores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MobilePhoneStore`.`PhoneStores` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `StoreAdress_id` INT NOT NULL,
  `StoresSquare_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_PhoneStores_StoreAdress1_idx` (`StoreAdress_id` ASC) VISIBLE,
  INDEX `fk_PhoneStores_StoresSquare1_idx` (`StoresSquare_id` ASC) VISIBLE,
  CONSTRAINT `fk_PhoneStores_StoreAdress1`
    FOREIGN KEY (`StoreAdress_id`)
    REFERENCES `MobilePhoneStore`.`StoreAdress` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PhoneStores_StoresSquare1`
    FOREIGN KEY (`StoresSquare_id`)
    REFERENCES `MobilePhoneStore`.`StoresSquare` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MobilePhoneStore`.`WorkersExperience`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MobilePhoneStore`.`WorkersExperience` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `experience` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MobilePhoneStore`.`WorkersPosition`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MobilePhoneStore`.`WorkersPosition` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `position` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MobilePhoneStore`.`Workers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MobilePhoneStore`.`Workers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `WorkersExperience_id` INT NOT NULL,
  `WorkersPosition_id` INT NOT NULL,
  `PhoneStores_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Workers_WorkersExperience1_idx` (`WorkersExperience_id` ASC) VISIBLE,
  INDEX `fk_Workers_WorkerPosition1_idx` (`WorkersPosition_id` ASC) VISIBLE,
  INDEX `fk_Workers_PhoneStores1_idx` (`PhoneStores_id` ASC) VISIBLE,
  CONSTRAINT `fk_Workers_WorkersExperience1`
    FOREIGN KEY (`WorkersExperience_id`)
    REFERENCES `MobilePhoneStore`.`WorkersExperience` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Workers_WorkerPosition1`
    FOREIGN KEY (`WorkersPosition_id`)
    REFERENCES `MobilePhoneStore`.`WorkersPosition` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Workers_PhoneStores1`
    FOREIGN KEY (`PhoneStores_id`)
    REFERENCES `MobilePhoneStore`.`PhoneStores` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MobilePhoneStore`.`Ages`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MobilePhoneStore`.`Ages` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `age` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MobilePhoneStore`.`Clients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MobilePhoneStore`.`Clients` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `Ages_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Clients_Ages1_idx` (`Ages_id` ASC) VISIBLE,
  CONSTRAINT `fk_Clients_Ages1`
    FOREIGN KEY (`Ages_id`)
    REFERENCES `MobilePhoneStore`.`Ages` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MobilePhoneStore`.`Years`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MobilePhoneStore`.`Years` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `year` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MobilePhoneStore`.`Prices`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MobilePhoneStore`.`Prices` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `price` DOUBLE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MobilePhoneStore`.`Countries`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MobilePhoneStore`.`Countries` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `country` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MobilePhoneStore`.`Techniques`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MobilePhoneStore`.`Techniques` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `PhoneStores_id` INT NOT NULL,
  `Models_id` INT NOT NULL,
  `Years_id` INT NOT NULL,
  `Prices_id` INT NOT NULL,
  `Countries_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Techniques_PhoneStore1_idx` (`PhoneStores_id` ASC) VISIBLE,
  INDEX `fk_Techniques_Models1_idx` (`Models_id` ASC) VISIBLE,
  INDEX `fk_Techniques_Year1_idx` (`Years_id` ASC) VISIBLE,
  INDEX `fk_Techniques_Prices1_idx` (`Prices_id` ASC) VISIBLE,
  INDEX `fk_Techniques_Countries1_idx` (`Countries_id` ASC) VISIBLE,
  CONSTRAINT `fk_Techniques_PhoneStore1`
    FOREIGN KEY (`PhoneStores_id`)
    REFERENCES `MobilePhoneStore`.`PhoneStores` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Techniques_Models1`
    FOREIGN KEY (`Models_id`)
    REFERENCES `MobilePhoneStore`.`Models` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Techniques_Year1`
    FOREIGN KEY (`Years_id`)
    REFERENCES `MobilePhoneStore`.`Years` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Techniques_Prices1`
    FOREIGN KEY (`Prices_id`)
    REFERENCES `MobilePhoneStore`.`Prices` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Techniques_Countries1`
    FOREIGN KEY (`Countries_id`)
    REFERENCES `MobilePhoneStore`.`Countries` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MobilePhoneStore`.`Orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MobilePhoneStore`.`Orders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `price` DOUBLE NOT NULL,
  `PhoneStores_id` INT NOT NULL,
  `Clients_id` INT NOT NULL,
  INDEX `fk_PhoneStore_has_Clients_Clients1_idx` (`Clients_id` ASC) VISIBLE,
  INDEX `fk_PhoneStore_has_Clients_PhoneStore1_idx` (`PhoneStores_id` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_PhoneStore_has_Clients_PhoneStore1`
    FOREIGN KEY (`PhoneStores_id`)
    REFERENCES `MobilePhoneStore`.`PhoneStores` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PhoneStore_has_Clients_Clients1`
    FOREIGN KEY (`Clients_id`)
    REFERENCES `MobilePhoneStore`.`Clients` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
