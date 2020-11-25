CREATE DATABASE `pkp_foods`;
  
CREATE TABLE `pkp_foods`.`family` (
  `family_id` VARCHAR(10) NOT NULL,
  `family_name` VARCHAR(45) NOT NULL,
  `family_image` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`family_id`));
  
CREATE TABLE `pkp_foods`.`products` (
  `product_id` VARCHAR(10) NOT NULL,
  `family_id` VARCHAR(10) NOT NULL,
  `product_name` VARCHAR(45) NOT NULL,
  `product_image` VARCHAR(100) NOT NULL,
  `class` VARCHAR(45),
  `brick` VARCHAR(45),
  `brand` VARCHAR(45),
  `expiry` INT NOT NULL,
  CONSTRAINT `product_identifier` PRIMARY KEY (`product_id`, `family_id`),
  INDEX `family_id_idx` (`product_id` ASC) VISIBLE,
  CONSTRAINT `family_id`
    FOREIGN KEY (`family_id`)
    REFERENCES `pkp_foods`.`family` (`family_Id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT);
    
CREATE TABLE `pkp_foods`.`weights` (
  `weight_code` VARCHAR(1) NOT NULL,
  `weight` INT NOT NULL,
  `unit_of_measurement` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`weight_code`));
  
CREATE TABLE `pkp_foods`.`child_articles` (
  `family_id` VARCHAR(10) NOT NULL,
  `product_id` VARCHAR(10) NOT NULL,
  `weight_code` VARCHAR(1) NOT NULL,
  `cost_price` FLOAT(10,2) NOT NULL,
  `margin` FLOAT(10,2) NOT NULL,
  `tax_code` VARCHAR(10) NOT NULL,
  `maximum_retail_price` FLOAT(10,2) NOT NULL,
  `EAN_code` VARCHAR(60) NULL,
  `inventory` INT NOT NULL,
  `display` TINYINT(1) NOT NULL,
  PRIMARY KEY (`family_id`, `product_id`, `weight_code`),
  INDEX `product_id_idx` (`product_id` ASC) VISIBLE,
  INDEX `weight_code_idx` (`weight_code` ASC) VISIBLE,
  INDEX `fk_tax_code_idx` (`tax_code` ASC) VISIBLE,
  CONSTRAINT `fk_family_id`
    FOREIGN KEY (`family_id`)
    REFERENCES `pkp_foods`.`products` (`family_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_id`
    FOREIGN KEY (`product_id`)
    REFERENCES `pkp_foods`.`products` (`product_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_weight_code`
    FOREIGN KEY (`weight_code`)
    REFERENCES `pkp_foods`.`weights` (`weight_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tax_code`
    FOREIGN KEY (`tax_code`)
    REFERENCES `pkp_foods`.`tax_lookup` (`tax_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

commit;
