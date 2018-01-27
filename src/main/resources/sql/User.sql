-- auto Generated on 2018-01-25 18:30:42 
-- DROP TABLE IF EXISTS `user`; 
CREATE TABLE `user`(
	`id` BIGINT (15) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`username` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'username',
	`password` VARCHAR (100) NOT NULL DEFAULT '' COMMENT 'password',
UNIQUE `ux_username`(username),
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`user`';
