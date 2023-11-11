CREATE TABLE `restman`.`monan423` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ten` VARCHAR(45) NOT NULL,
  `gia` FLOAT NOT NULL,
  `donVi` VARCHAR(45) NOT NULL,
  `mota` LONGTEXT NULL,
  PRIMARY KEY (`id`));

  
 CREATE TABLE `restman`.`khachhang423` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `ten` VARCHAR(45) NOT NULL,
  `ngaySinh` DATE NOT NULL,
  `email` VARCHAR(45) NULL,
  `diachi` VARCHAR(45) NULL,
  `ghiChu` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE);
  
  
  CREATE TABLE `restman`.`ban423` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `viTri` VARCHAR(45) NOT NULL,
  `sucChua` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);
  
  
  CREATE TABLE `restman`.`combo423` (
  `id` INT NOT NULL,
  `tenComBo` VARCHAR(45) NOT NULL,
  `giaBan` VARCHAR(45) NOT NULL,
  `mota` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);

  
  
  
CREATE TABLE `restman`.`combomonan` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_monan` INT NOT NULL,
  `id_combo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);

ALTER TABLE `restman`.`combomonan` 
ADD INDEX `fk_monan_idx` (`id_monan` ASC) VISIBLE;
;
ALTER TABLE `restman`.`combomonan` 
ADD CONSTRAINT `fk_monan`
  FOREIGN KEY (`id_monan`)
  REFERENCES `restman`.`monan423` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `restman`.`combomonan` 
CHANGE COLUMN `id_combo` `id_combo` INT NOT NULL ;



CREATE TABLE `restman`.`bandat423` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `trangThai` VARCHAR(45) NOT NULL,
  `ghiChu` VARCHAR(45) NULL,
  `id_khachhang` INT NOT NULL,
  `id_ban` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);
  ALTER TABLE `restman`.`bandat423` 
ADD INDEX `fk_khachahng_idx` (`id_khachhang` ASC) VISIBLE;
;
ALTER TABLE `restman`.`bandat423` 
ADD CONSTRAINT `fk_khachahng`
  FOREIGN KEY (`id_khachhang`)
  REFERENCES `restman`.`khachhang423` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
ALTER TABLE `restman`.`bandat423` 
ADD INDEX `fk_ban_idx` (`id_ban` ASC) VISIBLE;
;
ALTER TABLE `restman`.`bandat423` 
ADD CONSTRAINT `fk_ban`
  FOREIGN KEY (`id_ban`)
  REFERENCES `restman`.`ban423` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

  
  CREATE TABLE `restman`.`monandat423` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `soLuong` INT NOT NULL,
  `id_monan` INT NOT NULL,
  `id_bandat` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);
