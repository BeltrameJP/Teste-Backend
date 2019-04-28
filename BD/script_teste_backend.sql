-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema teste_backend
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `teste_backend` ;

-- -----------------------------------------------------
-- Schema teste_backend
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `teste_backend` DEFAULT CHARACTER SET utf8 ;
USE `teste_backend` ;

-- -----------------------------------------------------
-- Table `teste_backend`.`filme`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teste_backend`.`filme` ;

CREATE TABLE IF NOT EXISTS `teste_backend`.`filme` (
  `id_filme` INT(11) NOT NULL,
  `diretor` VARCHAR(255) NULL DEFAULT NULL,
  `genero` VARCHAR(255) NULL DEFAULT NULL,
  `nome` VARCHAR(255) NULL DEFAULT NULL,
  `quantidade` INT(11) NULL DEFAULT NULL,
  `tag_deletado` BIT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id_filme`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `teste_backend`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teste_backend`.`usuario` ;

CREATE TABLE IF NOT EXISTS `teste_backend`.`usuario` (
  `id_usuario` INT(11) NOT NULL,
  `cpf` VARCHAR(255) NULL DEFAULT NULL,
  `data_nascimento` DATETIME NULL DEFAULT NULL,
  `nome` VARCHAR(255) NULL DEFAULT NULL,
  `sexo` VARCHAR(255) NULL DEFAULT NULL,
  `tag_deletado` BIT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `teste_backend`.`historico`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teste_backend`.`historico` ;

CREATE TABLE IF NOT EXISTS `teste_backend`.`historico` (
  `id_historico` INT(11) NOT NULL,
  `id_filme` INT(11) NOT NULL,
  `id_usuario` INT(11) NOT NULL,
  `data_evento` VARCHAR(45) NOT NULL,
  `evento_tipo` INT(1) NOT NULL,
  PRIMARY KEY (`id_historico`),
  INDEX `FK2er1l3o6xv51vsk3owa3amtiu` (`id_filme` ASC) VISIBLE,
  INDEX `FKjw57nw892vca68le5tacfwwj9` (`id_usuario` ASC) VISIBLE,
  CONSTRAINT `FK2er1l3o6xv51vsk3owa3amtiu0`
    FOREIGN KEY (`id_filme`)
    REFERENCES `teste_backend`.`filme` (`id_filme`),
  CONSTRAINT `FKjw57nw892vca68le5tacfwwj90`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `teste_backend`.`usuario` (`id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `teste_backend`.`locacao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teste_backend`.`locacao` ;

CREATE TABLE IF NOT EXISTS `teste_backend`.`locacao` (
  `id_locacao` INT(11) NOT NULL,
  `data_devolucao` DATETIME NULL DEFAULT NULL,
  `data_locacao` DATETIME NULL DEFAULT NULL,
  `tag_deletado` BIT(1) NULL DEFAULT NULL,
  `tag_devolvido` BIT(1) NULL DEFAULT NULL,
  `id_filme` INT(11) NULL DEFAULT NULL,
  `id_usuario` INT(11) NULL DEFAULT NULL,
  `renovacao` INT(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_locacao`),
  INDEX `FK2er1l3o6xv51vsk3owa3amtiu` (`id_filme` ASC) VISIBLE,
  INDEX `FKjw57nw892vca68le5tacfwwj9` (`id_usuario` ASC) VISIBLE,
  CONSTRAINT `FK2er1l3o6xv51vsk3owa3amtiu`
    FOREIGN KEY (`id_filme`)
    REFERENCES `teste_backend`.`filme` (`id_filme`),
  CONSTRAINT `FKjw57nw892vca68le5tacfwwj9`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `teste_backend`.`usuario` (`id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
