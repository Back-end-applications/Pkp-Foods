CREATE DATABASE `pkp_foods`;
  
CREATE TABLE `pkp_foods`.`weights` (
  `weight_code` VARCHAR(1) NOT NULL,
  `weight` INT NOT NULL,
  `unit_of_measurement` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`weight_code`));
    
CREATE TABLE `pkp_foods`.`tax_lookup` (
  `tax_code` VARCHAR(10) NOT NULL,
  `tax_percentage` INT NOT NULL,
  PRIMARY KEY (`tax_code`));
  
CREATE TABLE `pkp_foods`.`family` (
  `family_id` VARCHAR(10) NOT NULL,
  `family_name` VARCHAR(45) NOT NULL,
  `family_image` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`family_id`));
  
CREATE TABLE `pkp_foods`.`class` (
  `class_id` VARCHAR(10) NOT NULL,
  `family_id` VARCHAR(10) NOT NULL,
  `class_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`class_id`, `family_id`),
  CONSTRAINT `fk_class_family_familyId`
    FOREIGN KEY (`family_id`)
    REFERENCES `pkp_foods`.`family` (`family_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
CREATE TABLE `pkp_foods`.`brick` (
  `brick_id` VARCHAR(10) NOT NULL,
  `family_id` VARCHAR(10) NOT NULL,
  `class_id` VARCHAR(10) NOT NULL,
  `brick_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`brick_id`, `family_id`, `class_id`),
  INDEX `fk_brick_class_familyId_idx` (`family_id` ASC) VISIBLE,
  INDEX `fk_brick_class_classId_idx` (`class_id` ASC) VISIBLE,
  CONSTRAINT `fk_brick_class_familyId`
    FOREIGN KEY (`family_id`)
    REFERENCES `pkp_foods`.`class` (`family_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_brick_class_classId`
    FOREIGN KEY (`class_id`)
    REFERENCES `pkp_foods`.`class` (`class_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `pkp_foods`.`brand` (
  `brand_id` VARCHAR(10) NOT NULL,
  `brand_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`brand_id`));
  
CREATE TABLE `pkp_foods`.`products` (
  `product_id` VARCHAR(10) NOT NULL,
  `family_id` VARCHAR(10) NOT NULL,
  `product_name` VARCHAR(45) NOT NULL,
  `product_image` VARCHAR(45) NOT NULL,
  `class_id` VARCHAR(10) NULL,
  `brick_id` VARCHAR(10) NULL,
  `brand_id` VARCHAR(10) NULL,
  `expiry` INT(3) NOT NULL,
  PRIMARY KEY (`product_id`, `family_id`),
  INDEX `fk_products_family_familyId_idx` (`family_id` ASC) VISIBLE,
  INDEX `fk_products_class_classId_idx` (`class_id` ASC) VISIBLE,
  INDEX `fk_products_brand_brandId_idx` (`brand_id` ASC) VISIBLE,
  INDEX `fk_products_brick_brickId_idx` (`brick_id` ASC) VISIBLE,
  CONSTRAINT `fk_products_family_familyId`
    FOREIGN KEY (`family_id`)
    REFERENCES `pkp_foods`.`family` (`family_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_products_class_classId`
    FOREIGN KEY (`class_id`)
    REFERENCES `pkp_foods`.`class` (`class_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_products_brick_brickId`
    FOREIGN KEY (`brick_id`)
    REFERENCES `pkp_foods`.`brick` (`brick_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_products_brand_brandId`
    FOREIGN KEY (`brand_id`)
    REFERENCES `pkp_foods`.`brand` (`brand_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
  
CREATE TABLE `pkp_foods`.`child_articles` (
  `family_id` VARCHAR(10) NOT NULL,
  `product_id` VARCHAR(10) NOT NULL,
  `weight_code` VARCHAR(1) NOT NULL,
  `cost_price` FLOAT(10,2) NOT NULL,
  `margin` FLOAT(10,2) NOT NULL,
  `tax_code` VARCHAR(10) NOT NULL,
  `maximum_retail_price` FLOAT(10,2) NOT NULL,
  `EAN_code` VARCHAR(60) NOT NULL,
  `inventory` INT NOT NULL,
  `display` TINYINT(1) NOT NULL,
  PRIMARY KEY (`family_id`, `product_id`, `weight_code`),
  INDEX `fk_child_articles_products_productId_idx` (`product_id` ASC) VISIBLE,
  INDEX `fk_child_articles_products_weightCode_idx` (`weight_code` ASC) VISIBLE,
  INDEX `fk_child_articles_tax_lookup_taxCode_idx` (`tax_code` ASC) VISIBLE,
  CONSTRAINT `fk_child_articles_products_familyId`
    FOREIGN KEY (`family_id`)
    REFERENCES `pkp_foods`.`products` (`family_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_child_articles_products_productId`
    FOREIGN KEY (`product_id`)
    REFERENCES `pkp_foods`.`products` (`product_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_child_articles_weights_weightCode`
    FOREIGN KEY (`weight_code`)
    REFERENCES `pkp_foods`.`weights` (`weight_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_child_articles_tax_lookup_taxCode`
    FOREIGN KEY (`tax_code`)
    REFERENCES `pkp_foods`.`tax_lookup` (`tax_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
ALTER TABLE `pkp_foods`.`child_articles` 
CHANGE COLUMN `EAN_code` `EAN_code` VARCHAR(60) NULL ;

CREATE TABLE `pkp_foods`.`coupons` (
  `coupon_code` VARCHAR(20) NOT NULL,
  `description` VARCHAR(100) NOT NULL,
  `discount` FLOAT(10,2) NOT NULL,
  `discount_type` VARCHAR(45) NOT NULL,
  `valid_from` DATE NOT NULL,
  `valid_to` DATE NOT NULL,
  PRIMARY KEY (`coupon_code`));

commit;
