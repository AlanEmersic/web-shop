-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema webshop
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema webshop
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `webshop` DEFAULT CHARACTER SET cp1250 COLLATE cp1250_croatian_ci ;
USE `webshop` ;

-- -----------------------------------------------------
-- Table `webshop`.`brand`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `webshop`.`brand`;
CREATE TABLE IF NOT EXISTS `webshop`.`brand` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webshop`.`product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `webshop`.`product`;
CREATE TABLE IF NOT EXISTS `webshop`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  `price` DECIMAL(10,2) NOT NULL,
  `quantity` INT NOT NULL,
  `brandId` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_product_brand_idx` (`brandId` ASC) VISIBLE,
  CONSTRAINT `fk_product_brand`
    FOREIGN KEY (`brandId`)
    REFERENCES `webshop`.`brand` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webshop`.`paymentMethod`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `webshop`.`paymentMethod`;
CREATE TABLE IF NOT EXISTS `webshop`.`paymentMethod` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webshop`.`discountCode`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `webshop`.`discountCode`;
CREATE TABLE IF NOT EXISTS `webshop`.`discountCode` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(255) NOT NULL,
  `discount` DECIMAL(10,2) NOT NULL,
  `used` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webshop`.`orders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `webshop`.`orders`;
CREATE TABLE IF NOT EXISTS `webshop`.`orders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` DATETIME NOT NULL,
  `totalPriceWithDiscount` DECIMAL(10,2) NOT NULL,
  `totalPriceWithoutDiscount` DECIMAL(10,2) NULL,
  `paymentMethodId` INT NOT NULL,
  `cardNumber` VARCHAR(255) NULL,
  `email` VARCHAR(255) NOT NULL,
  `phoneNumber` INT NOT NULL,
  `deliveryAddress` VARCHAR(255) NOT NULL,
  `remark` TEXT NULL,
  `discountCodeId` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_order_paymentMethod1_idx` (`paymentMethodId` ASC) VISIBLE,
  INDEX `fk_order_discountCode1_idx` (`discountCodeId` ASC) VISIBLE,
  CONSTRAINT `fk_order_paymentMethod1`
    FOREIGN KEY (`paymentMethodId`)
    REFERENCES `webshop`.`paymentMethod` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_discountCode1`
    FOREIGN KEY (`discountCodeId`)
    REFERENCES `webshop`.`discountCode` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webshop`.`orderProducts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `webshop`.`orderProducts`;
CREATE TABLE IF NOT EXISTS `webshop`.`orderProducts` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `orderId` INT NOT NULL,
  `productId` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_orderProducts_order1_idx` (`orderId` ASC) VISIBLE,
  INDEX `fk_orderProducts_product1_idx` (`productId` ASC) VISIBLE,
  CONSTRAINT `fk_orderProducts_order1`
    FOREIGN KEY (`orderId`)
    REFERENCES `webshop`.`orders` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orderProducts_product1`
    FOREIGN KEY (`productId`)
    REFERENCES `webshop`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
