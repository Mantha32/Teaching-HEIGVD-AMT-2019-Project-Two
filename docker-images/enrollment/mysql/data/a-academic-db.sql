
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema academic_api
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `academic_api` ;

-- -----------------------------------------------------
-- Schema academic_api
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `academic_api` DEFAULT CHARACTER SET utf8 ;
USE `academic_api` ;

-- -----------------------------------------------------
-- Table `academic_api`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `academic_api`.`User` ;

CREATE TABLE IF NOT EXISTS `academic_api`.`User` (
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`email`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `academic_api`.`Course`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `academic_api`.`Course` ;

CREATE TABLE IF NOT EXISTS `academic_api`.`Course` (
  `idCourse` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`idCourse`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `academic_api`.`Salle`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `academic_api`.`Salle` ;

CREATE TABLE IF NOT EXISTS `academic_api`.`Salle` (
  `idSalle` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idSalle`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `academic_api`.`Enrollment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `academic_api`.`Enrollment` ;

CREATE TABLE IF NOT EXISTS `academic_api`.`Enrollment` (
  `idEnrollment` INT NOT NULL AUTO_INCREMENT,
  `User_email` VARCHAR(45) NOT NULL,
  `Salle_idSalle` INT NOT NULL,
  `Course_idCourse` INT NOT NULL,
  PRIMARY KEY (`idEnrollment`),
  INDEX `fk_Enrollment_User_idx` (`User_email` ASC) VISIBLE,
  INDEX `fk_Enrollment_Salle1_idx` (`Salle_idSalle` ASC) VISIBLE,
  INDEX `fk_Enrollment_Course1_idx` (`Course_idCourse` ASC) VISIBLE,
  CONSTRAINT `fk_Enrollment_User`
    FOREIGN KEY (`User_email`)
    REFERENCES `academic_api`.`User` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Enrollment_Salle1`
    FOREIGN KEY (`Salle_idSalle`)
    REFERENCES `academic_api`.`Salle` (`idSalle`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Enrollment_Course1`
    FOREIGN KEY (`Course_idCourse`)
    REFERENCES `academic_api`.`Course` (`idCourse`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
