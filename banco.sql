-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema db1
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db1` ;
USE `db1` ;

-- -----------------------------------------------------
-- Table `db1`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db1`.`cliente` (
  `id` BIGINT(20) NOT NULL,
  `endereco` VARCHAR(255) NULL DEFAULT NULL,
  `nome` VARCHAR(255) NULL DEFAULT NULL,
  `telefone` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db1`.`hibernate_sequence`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db1`.`hibernate_sequence` (
  `next_val` BIGINT(20) NULL DEFAULT NULL)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db1`.`locacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db1`.`locacao` (
  `id` BIGINT(20) NOT NULL,
  `data` DATETIME NULL DEFAULT NULL,
  `devolucao` DATETIME NULL DEFAULT NULL,
  `filme` VARCHAR(255) NULL DEFAULT NULL,
  `valor` DECIMAL(19,2) NULL DEFAULT NULL,
  `cliente_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKf0b8q1vsp55ou4mtqiwrkyqis` (`cliente_id` ASC) VISIBLE)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
