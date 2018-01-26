-- auto Generated on 2018-01-26 10:52:12 
-- DROP TABLE IF EXISTS `user_role`; 
CREATE TABLE `user_role`(
	`id` BIGINT (15) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`user_id` BIGINT (15) NOT NULL DEFAULT -1 COMMENT 'userId',
	`role_id` BIGINT (15) NOT NULL DEFAULT -1 COMMENT 'roleId',
INDEX `ix_user_id`(user_id),
INDEX `ix_role_id`(role_id),
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`user_role`';
