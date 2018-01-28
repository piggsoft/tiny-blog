ALTER TABLE user
	ADD enabled TINYINT(3) NOT NULL DEFAULT 1 COMMENT 'enabled';ALTER TABLE user
	ADD account_non_expired TINYINT(3) NOT NULL DEFAULT 1 COMMENT 'accountNonExpired';ALTER TABLE user
	ADD credentials_non_expired TINYINT(3) NOT NULL DEFAULT 1 COMMENT 'credentialsNonExpired';ALTER TABLE user
	ADD account_non_locked TINYINT(3) NOT NULL DEFAULT 1 COMMENT 'accountNonLocked';
