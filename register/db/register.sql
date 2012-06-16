SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Indexes */

DROP INDEX IDX_LEVEL ON T_REG_LEVEL;



/* Drop Tables */

DROP TABLE T_REG_REGISTRATION;
DROP TABLE T_REG_AREA;
DROP TABLE T_REG_EDUCATION;
DROP TABLE T_REG_LEVEL;
DROP TABLE T_REG_LOCATION;
DROP TABLE T_REG_MEMO;
DROP TABLE T_REG_USER;




/* Create Tables */

CREATE TABLE T_REG_AREA
(
	AREA_ID INT NOT NULL AUTO_INCREMENT,
	AREA_NAME VARCHAR(40) NOT NULL UNIQUE,
	PRIMARY KEY (AREA_ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;


CREATE TABLE T_REG_EDUCATION
(
	EDUCATION_ID INT NOT NULL AUTO_INCREMENT,
	EDUCATION_NAME VARCHAR(20),
	PRIMARY KEY (EDUCATION_ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;


CREATE TABLE T_REG_LEVEL
(
	LEVEL_ID INT NOT NULL AUTO_INCREMENT,
	LEVEL_NAME VARCHAR(20) NOT NULL UNIQUE,
	PRIMARY KEY (LEVEL_ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;


CREATE TABLE T_REG_LOCATION
(
	LOCATION_ID INT NOT NULL AUTO_INCREMENT,
	LOCATION_NAME VARCHAR(60) NOT NULL,
	PRIMARY KEY (LOCATION_ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;


CREATE TABLE T_REG_MEMO
(
	MEMO_ID INT NOT NULL UNIQUE AUTO_INCREMENT,
	MEMO_DESCRIPTION VARCHAR(200),
	PRIMARY KEY (MEMO_ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE T_REG_REGISTRATION
(
	REGISTRATION_ID INT NOT NULL AUTO_INCREMENT,
	-- 注册者
	REGISTER VARCHAR(10) NOT NULL COMMENT '注册者',
	-- 性别
	GENDER VARCHAR(2) NOT NULL COMMENT '性别',
	-- 学历
	EDUCATION VARCHAR(20) COMMENT '学历',
	-- 原等级
	OLD_LEVEL VARCHAR(10) NOT NULL COMMENT '原等级',
	-- 申报等级
	NEW_LEVEL VARCHAR(10) NOT NULL COMMENT '申报等级',
	-- 身份证号
	ID_CARD VARCHAR(18) NOT NULL COMMENT '身份证号',
	-- 联系电话
	PHONE VARCHAR(20) COMMENT '联系电话',
	-- 工作单位
	WORK_UNIT VARCHAR(60) COMMENT '工作单位',
	-- 失业编号
	UNEMPLOYED_NO VARCHAR(20) COMMENT '失业编号',
	-- 登记时间
	REGISTRATION_DATE DATE NOT NULL COMMENT '登记时间',
	-- 开课时间
	START_DATE DATE COMMENT '开课时间',
	-- 培训专
	AREA_ID INT NOT NULL COMMENT '培训专',
	-- 培训地址
	LOCATION_ID INT NOT NULL COMMENT '培训地址',
	PRIMARY KEY (REGISTRATION_ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;


CREATE TABLE T_REG_USER
(
	USER_ID INT NOT NULL UNIQUE AUTO_INCREMENT,
	USERNAME VARCHAR(20) NOT NULL,
	PASSWORD VARCHAR(255) NOT NULL,
	EMAIL VARCHAR(40),
	-- A: Administrator
	-- U: User
	ROLE_FLAG CHAR(1) CHARACTER SET utf8 NOT NULL COMMENT 'A: Administrator
U: User',
	-- Y: active
	-- N: inactive
	ACTIVE CHAR(1) COMMENT 'Y: active
N: inactive',
	PRIMARY KEY (USER_ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;



/* Create Foreign Keys */

ALTER TABLE T_REG_REGISTRATION
	ADD FOREIGN KEY (AREA_ID)
	REFERENCES T_REG_AREA (AREA_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE T_REG_REGISTRATION
	ADD FOREIGN KEY (LOCATION_ID)
	REFERENCES T_REG_LOCATION (LOCATION_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



/* Create Indexes */

CREATE INDEX IDX_LEVEL ON T_REG_LEVEL (LEVEL_ID ASC);



