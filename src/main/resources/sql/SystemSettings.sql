-- auto Generated on 2018-01-28 19:05:25 
-- DROP TABLE IF EXISTS `system_settings`; 
CREATE TABLE `system_settings`(
	`id` BIGINT (15) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`key` VARCHAR (100) NOT NULL DEFAULT '' COMMENT 'key',
	`value` VARCHAR (255) NOT NULL DEFAULT '' COMMENT 'value',
	`description` VARCHAR (255) NOT NULL DEFAULT '' COMMENT 'description',
UNIQUE `ux_key`(key),
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`system_settings`';
