/*
MySQL Backup
Source Server Version: 5.5.16
Source Database: register
Date: 2012/6/3 22:01:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
--  Table structure for `t_reg_area`
-- ----------------------------
DROP TABLE IF EXISTS `t_reg_area`;
CREATE TABLE `t_reg_area` (
  `AREA_ID` int(11) NOT NULL AUTO_INCREMENT,
  `AREA_NAME` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`AREA_ID`),
  UNIQUE KEY `AREA_NAME` (`AREA_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Table structure for `t_reg_education`
-- ----------------------------
DROP TABLE IF EXISTS `t_reg_education`;
CREATE TABLE `t_reg_education` (
  `EDUCATION_ID` int(11) NOT NULL AUTO_INCREMENT,
  `EDUCATION_NAME` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`EDUCATION_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Table structure for `t_reg_level`
-- ----------------------------
DROP TABLE IF EXISTS `t_reg_level`;
CREATE TABLE `t_reg_level` (
  `LEVEL_ID` int(11) NOT NULL AUTO_INCREMENT,
  `LEVEL_NAME` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`LEVEL_ID`),
  UNIQUE KEY `LEVEL_NAME` (`LEVEL_NAME`),
  KEY `IDX_LEVEL` (`LEVEL_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Table structure for `t_reg_location`
-- ----------------------------
DROP TABLE IF EXISTS `t_reg_location`;
CREATE TABLE `t_reg_location` (
  `LOCATION_ID` int(11) NOT NULL AUTO_INCREMENT,
  `LOCATION_NAME` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`LOCATION_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Table structure for `t_reg_registration`
-- ----------------------------
DROP TABLE IF EXISTS `t_reg_registration`;
CREATE TABLE `t_reg_registration` (
  `REGISTRATION_ID` int(11) NOT NULL AUTO_INCREMENT,
  `REGISTER` varchar(10) COLLATE utf8_unicode_ci NOT NULL COMMENT '???',
  `GENDER` varchar(2) COLLATE utf8_unicode_ci NOT NULL COMMENT '??',
  `EDUCATION` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '??',
  `OLD_LEVEL` varchar(10) COLLATE utf8_unicode_ci NOT NULL COMMENT '???',
  `NEW_LEVEL` varchar(10) COLLATE utf8_unicode_ci NOT NULL COMMENT '????',
  `ID_CARD` varchar(18) COLLATE utf8_unicode_ci NOT NULL COMMENT '????',
  `PHONE` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '????',
  `WORK_UNIT` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '????',
  `UNEMPLOYED_NO` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '????',
  `REGISTRATION_DATE` date NOT NULL COMMENT '????',
  `START_DATE` date NOT NULL COMMENT '????',
  `AREA_ID` int(11) NOT NULL COMMENT '???',
  `LOCATION_ID` int(11) NOT NULL COMMENT '????',
  PRIMARY KEY (`REGISTRATION_ID`),
  KEY `AREA_ID` (`AREA_ID`),
  KEY `LOCATION_ID` (`LOCATION_ID`),
  CONSTRAINT `t_reg_registration_ibfk_1` FOREIGN KEY (`AREA_ID`) REFERENCES `t_reg_area` (`AREA_ID`),
  CONSTRAINT `t_reg_registration_ibfk_2` FOREIGN KEY (`LOCATION_ID`) REFERENCES `t_reg_location` (`LOCATION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Table structure for `t_reg_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_reg_user`;
CREATE TABLE `t_reg_user` (
  `USER_ID` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `USERNAME` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `PASSWORD` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `EMAIL` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ROLE_FLAG` char(1) CHARACTER SET utf8 NOT NULL COMMENT 'A: Administrator\r\nU: User',
  `ACTIVE` char(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Y: active\r\nN: inactive',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Records 
-- ----------------------------
INSERT INTO `t_reg_area` VALUES ('6','其他'), ('3','加工中心操作'), ('1','商品营业员'), ('2','数控车床加工'), ('5','焊工'), ('4','维修电工');
INSERT INTO `t_reg_education` VALUES ('1','小学'), ('2','初中'), ('3','普通高中'), ('4','中专'), ('5','职业高中'), ('6','技校'), ('7','大专'), ('8','本科'), ('9','研究生');
INSERT INTO `t_reg_level` VALUES ('2','中级'), ('1','初级'), ('4','技师'), ('3','高级'), ('5','高级技师');
INSERT INTO `t_reg_location` VALUES ('1','开发区佳远职业技术学校'), ('2','金州劳动局技工学校');
INSERT INTO `t_reg_user` VALUES ('1','admin','admin','admin@localhost','A','Y');
