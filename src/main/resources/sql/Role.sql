-- auto Generated on 2018-01-26 11:03:47 
-- DROP TABLE IF EXISTS `role`; 
CREATE TABLE `role`(
	`id` BIGINT (15) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`name` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'name',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`role`';