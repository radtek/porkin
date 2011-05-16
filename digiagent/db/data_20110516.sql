/*
MySQL Backup
Source Server Version: 5.1.41
Source Database: digiagent
Date: 2011/5/10 21:58:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
--  Table structure for `t_da_advertise`
-- ----------------------------
DROP TABLE IF EXISTS `t_da_advertise`;
CREATE TABLE `t_da_advertise` (
  `ADVERTISE_ID` int(11) NOT NULL COMMENT '广告词表系统主键',
  `ADVERTISE_DESCRIPTION` varchar(300) NOT NULL DEFAULT 'NA' COMMENT '广告词内容',
  `CREATED_BY` varchar(30) DEFAULT NULL COMMENT '创建者',
  `CREATED_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `LASTUPDATED_BY` varchar(30) DEFAULT NULL COMMENT '最后更新者',
  `LASTUPDATED_DATE` datetime DEFAULT NULL COMMENT '最后更新时间',
  `ACTIVE_FLAG` char(1) DEFAULT NULL COMMENT '激活标志位',
  PRIMARY KEY (`ADVERTISE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='广告词表';

-- ----------------------------
--  Table structure for `t_da_brand`
-- ----------------------------
DROP TABLE IF EXISTS `t_da_brand`;
CREATE TABLE `t_da_brand` (
  `BRAND_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '品牌系统主键',
  `BRAND_NAME` varchar(20) NOT NULL COMMENT '品牌中文名',
  `BRAND_ENGLISH` varchar(20) NOT NULL COMMENT '品牌英文名',
  `CREATED_BY` varchar(30) NOT NULL COMMENT '创建者',
  `CREATED_DATE` datetime NOT NULL COMMENT '创建时间',
  `LASTUPDATED_BY` varchar(30) NOT NULL COMMENT '最后更新者',
  `LASTUPDATED_DATE` datetime NOT NULL COMMENT '最后更新时间',
  `ACTIVE_FLAG` char(1) NOT NULL DEFAULT 'N' COMMENT '激活标志位',
  `COUNTRY_ID` int(10) unsigned NOT NULL COMMENT '国家信息的系统主键',
  PRIMARY KEY (`BRAND_ID`),
  KEY `COUNTRY_ID` (`COUNTRY_ID`),
  CONSTRAINT `t_da_brand_ibfk_1` FOREIGN KEY (`COUNTRY_ID`) REFERENCES `t_da_country` (`COUNTRY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='品牌信息表';

-- ----------------------------
--  Table structure for `t_da_category`
-- ----------------------------
DROP TABLE IF EXISTS `t_da_category`;
CREATE TABLE `t_da_category` (
  `CATEGORY_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '产品类别名系统主键',
  `CATEGORY_NAME` varchar(20) NOT NULL COMMENT '产品类别中文名',
  `CREATED_BY` varchar(30) NOT NULL COMMENT '创建者',
  `CREATED_DATE` datetime NOT NULL COMMENT '创建时间',
  `LASTUPDATED_BY` varchar(30) NOT NULL COMMENT '最后更新者',
  `LASTUPDATED_DATE` datetime NOT NULL COMMENT '最后更新时间',
  `ACTIVE_FLAG` char(1) NOT NULL DEFAULT 'N' COMMENT '激活标志位',
  PRIMARY KEY (`CATEGORY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='产品类别信息表';

-- ----------------------------
--  Table structure for `t_da_city`
-- ----------------------------
DROP TABLE IF EXISTS `t_da_city`;
CREATE TABLE `t_da_city` (
  `CITY_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '城市系统主键',
  `CITY_NAME` varchar(20) NOT NULL COMMENT '城市中文名',
  `CITY_ABBREVIATION` varchar(5) DEFAULT NULL COMMENT '城市缩写(如大连,DL)',
  `CREATED_BY` varchar(30) NOT NULL COMMENT '创建者',
  `CREATED_DATE` datetime NOT NULL COMMENT '创建时间',
  `LASTUPDATED_BY` varchar(30) NOT NULL COMMENT '最后更新者',
  `LASTUPDATED_DATE` datetime NOT NULL COMMENT '最后更新时间',
  `ACTIVE_FLAG` char(1) DEFAULT 'N' COMMENT '激活标志位',
  `PROVINCE_ID` int(10) unsigned NOT NULL COMMENT '省份的系统主键',
  PRIMARY KEY (`CITY_ID`),
  KEY `PROVINCE_ID` (`PROVINCE_ID`),
  CONSTRAINT `t_da_city_ibfk_1` FOREIGN KEY (`PROVINCE_ID`) REFERENCES `t_da_province` (`PROVINCE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='城市信息表，记录中城市的基本信息。';

-- ----------------------------
--  Table structure for `t_da_comments`
-- ----------------------------
DROP TABLE IF EXISTS `t_da_comments`;
CREATE TABLE `t_da_comments` (
  `COMMENT_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '商家评价的系统主键',
  `COMMENT_RANK` char(1) NOT NULL COMMENT '评价等级',
  `COMMENT_CONTENT` varchar(3000) DEFAULT NULL COMMENT '评价内容',
  `COMMENT_STATUS` char(1) NOT NULL DEFAULT 'N' COMMENT '评价状态,N:无发票,Y:有发票',
  `CREATED_BY` varchar(30) NOT NULL COMMENT '创建者',
  `CREATED_DATE` datetime NOT NULL COMMENT '创建时间',
  `LASTUPDATED_BY` varchar(30) NOT NULL COMMENT '最后更新者',
  `LASTUPDATED_DATE` datetime NOT NULL COMMENT '最后更新时间',
  `SUPPLIER_ID` int(10) unsigned NOT NULL COMMENT '供应商系统主键',
  `USER_ID` int(10) unsigned NOT NULL COMMENT '用户系统主键',
  PRIMARY KEY (`COMMENT_ID`),
  KEY `SUPPLIER_ID` (`SUPPLIER_ID`),
  KEY `USER_ID` (`USER_ID`),
  CONSTRAINT `t_da_comments_ibfk_1` FOREIGN KEY (`SUPPLIER_ID`) REFERENCES `t_da_supplier` (`SUPPLIER_ID`),
  CONSTRAINT `t_da_comments_ibfk_2` FOREIGN KEY (`USER_ID`) REFERENCES `t_da_user` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商家评价信息';

-- ----------------------------
--  Table structure for `t_da_commodity`
-- ----------------------------
DROP TABLE IF EXISTS `t_da_commodity`;
CREATE TABLE `t_da_commodity` (
  `COMMODITY_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '商品系统主键',
  `COMMODITY_NAME` varchar(30) NOT NULL COMMENT '商品名称',
  `COMMODITY_DESCRIPTION` varchar(3000) NOT NULL COMMENT '商品介绍',
  `START_DATE` datetime DEFAULT NULL COMMENT '有效期开始时间',
  `END_DATE` datetime DEFAULT NULL COMMENT '有效期结束时间',
  `COMMODITY_TYPE` char(1) NOT NULL DEFAULT 'P' COMMENT '商品类型(S:二手，P:促销)',
  `COMMODITY_PRICE` float(10,2) unsigned DEFAULT NULL COMMENT '商品的价格',
  `USER_ID` int(10) unsigned NOT NULL COMMENT '用户系统主键',
  `CREATED_BY` varchar(30) NOT NULL COMMENT '创建者',
  `CREATED_DATE` datetime NOT NULL COMMENT '创建时间',
  `LASTUPDATED_BY` varchar(30) NOT NULL COMMENT '最后更新者',
  `LASTUPDATED_DATE` datetime NOT NULL COMMENT '最后更新时间',
  `ACTIVE_FLAG` char(1) NOT NULL DEFAULT 'N' COMMENT '激活标志位',
  `PRODUCT_ID` int(10) unsigned NOT NULL DEFAULT '1' COMMENT '产品',
  `COMMODITY_PRICE_OLD` float(10,2) unsigned DEFAULT '0.00' COMMENT '促销页面原价',
  PRIMARY KEY (`COMMODITY_ID`),
  KEY `USER_ID` (`USER_ID`),
  CONSTRAINT `t_da_commodity_ibfk_1` FOREIGN KEY (`USER_ID`) REFERENCES `t_da_user` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品信息表';

-- ----------------------------
--  Table structure for `t_da_commodityimage`
-- ----------------------------
DROP TABLE IF EXISTS `t_da_commodityimage`;
CREATE TABLE `t_da_commodityimage` (
  `COMMODITYIMAGE_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '商品图像系统主键',
  `COMMODITYIMAGE_CONTENT` blob NOT NULL COMMENT '商品图像内容',
  `CREATED_BY` varchar(30) DEFAULT NULL COMMENT '创建者',
  `CREATED_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `LASTUPDATED_BY` varchar(30) DEFAULT NULL COMMENT '最后更新者',
  `LASTUPDATED_DATE` datetime DEFAULT NULL COMMENT '最后更新时间',
  `ACTIVE_FLAG` char(1) DEFAULT NULL COMMENT '激活标志位',
  `COMMODITY_ID` int(10) unsigned NOT NULL COMMENT '商品系统主键',
  PRIMARY KEY (`COMMODITYIMAGE_ID`),
  KEY `COMMODITY_ID` (`COMMODITY_ID`),
  CONSTRAINT `t_da_commodityimage_ibfk_1` FOREIGN KEY (`COMMODITY_ID`) REFERENCES `t_da_commodity` (`COMMODITY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品图像表';

-- ----------------------------
--  Table structure for `t_da_contact`
-- ----------------------------
DROP TABLE IF EXISTS `t_da_contact`;
CREATE TABLE `t_da_contact` (
  `CONTACT_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '联系方法系统主键',
  `CONTACT_CONTENT` varchar(30) NOT NULL COMMENT '联系方式内容',
  `CONTACT_TYPE` char(1) NOT NULL DEFAULT 'Q' COMMENT '联系方式: Q:qq, N:MSN',
  `CREATED_BY` varchar(30) NOT NULL COMMENT '创建者',
  `CREATED_DATE` datetime NOT NULL COMMENT '创建时间',
  `LASTUPDATED_BY` varchar(30) NOT NULL COMMENT '最后更新者',
  `LASTUPDATED_DATE` datetime NOT NULL COMMENT '最后更新时间',
  `ACTIVE_FLAG` char(1) NOT NULL COMMENT '激活标志位',
  `SUPPLIER_ID` int(10) unsigned NOT NULL COMMENT '供应商系统主键',
  PRIMARY KEY (`CONTACT_ID`),
  KEY `SUPPLIER_ID` (`SUPPLIER_ID`),
  CONSTRAINT `t_da_contact_ibfk_1` FOREIGN KEY (`SUPPLIER_ID`) REFERENCES `t_da_supplier` (`SUPPLIER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='联系方法表';

-- ----------------------------
--  Table structure for `t_da_country`
-- ----------------------------
DROP TABLE IF EXISTS `t_da_country`;
CREATE TABLE `t_da_country` (
  `COUNTRY_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '国家信息的系统主键',
  `COUNTRY_NAME` varchar(30) NOT NULL COMMENT '国家中文名',
  `COUNTRY_ABBREVIATION` varchar(5) NOT NULL COMMENT '国家名字母缩写',
  `CREATED_BY` varchar(30) NOT NULL COMMENT '创建者',
  `CREATED_DATE` datetime NOT NULL COMMENT '创建时间',
  `LASTUPDATED_BY` varchar(30) NOT NULL COMMENT '最后更新者',
  `LASTUPDATED_DATE` datetime NOT NULL COMMENT '最后更新时间',
  `ACTIVE_FLAG` char(1) NOT NULL DEFAULT 'N' COMMENT '激活标志位',
  PRIMARY KEY (`COUNTRY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='国家信息表';

-- ----------------------------
--  Table structure for `t_da_history`
-- ----------------------------
DROP TABLE IF EXISTS `t_da_history`;
CREATE TABLE `t_da_history` (
  `HISTORY_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '访问历史系统主键',
  `HISTORY_TYPE` char(1) NOT NULL COMMENT '访问内容类型(B:品牌,C:大类,P:产品,E:品牌产品,S:供应商)',
  `HISTORY_TYPEID` int(10) unsigned NOT NULL COMMENT '所对应的ID,如产品ID,供应商ID',
  `HISTORY_ACCESSDATE` datetime NOT NULL COMMENT '访问时间',
  `HISTORY_FROMIP` varchar(128) NOT NULL DEFAULT '255.255.255.255',
  PRIMARY KEY (`HISTORY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='访问历史表';

-- ----------------------------
--  Table structure for `t_da_product`
-- ----------------------------
DROP TABLE IF EXISTS `t_da_product`;
CREATE TABLE `t_da_product` (
  `PRODUCT_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '产品系统主键',
  `PRODUCT_NAME` varchar(20) NOT NULL COMMENT '产品中文名',
  `CREATED_BY` varchar(30) NOT NULL COMMENT '创建者',
  `CREATED_DATE` datetime NOT NULL COMMENT '创建时间',
  `LASTUPDATED_BY` varchar(30) NOT NULL COMMENT '最后更新者',
  `LASTUPDATED_DATE` datetime NOT NULL COMMENT '最后更新时间',
  `ACTIVE_FLAG` char(1) NOT NULL DEFAULT 'N' COMMENT '激活标志位',
  `CATEGORY_ID` int(10) unsigned NOT NULL COMMENT '产品类别名系统主键',
  `DISPLAY_TYPE` char(1) NOT NULL DEFAULT '1' COMMENT '显示的类别，1:导购, 2:二手, 3:导购+二手, 4:促销, 5:导购+促销, 6:二手+:促销, 7:导购+二手+促销',
  PRIMARY KEY (`PRODUCT_ID`),
  KEY `CATEGORY_ID` (`CATEGORY_ID`),
  CONSTRAINT `t_da_product_ibfk_1` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `t_da_category` (`CATEGORY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='产品信息表';

-- ----------------------------
--  Table structure for `t_da_productbrand`
-- ----------------------------
DROP TABLE IF EXISTS `t_da_productbrand`;
CREATE TABLE `t_da_productbrand` (
  `PRODUCTBRAND_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '品牌产品系统主键',
  `BRAND_ID` int(10) unsigned NOT NULL COMMENT '品牌系统主键',
  `PRODUCT_ID` int(10) unsigned NOT NULL COMMENT '产品系统主键',
  `CREATED_BY` varchar(30) DEFAULT NULL COMMENT '创建者',
  `CREATED_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `LASTUPDATED_BY` varchar(30) DEFAULT NULL COMMENT '最后更新者',
  `LASTUPDATED_DATE` datetime DEFAULT NULL COMMENT '最后更新时间',
  `ACTIVE_FLAG` char(1) DEFAULT 'N' COMMENT '激活标志位',
  PRIMARY KEY (`PRODUCTBRAND_ID`),
  KEY `BRAND_ID` (`BRAND_ID`),
  KEY `PRODUCT_ID` (`PRODUCT_ID`),
  CONSTRAINT `t_da_productbrand_ibfk_1` FOREIGN KEY (`BRAND_ID`) REFERENCES `t_da_brand` (`BRAND_ID`),
  CONSTRAINT `t_da_productbrand_ibfk_2` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `t_da_product` (`PRODUCT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COMMENT='品牌产品关系表';

-- ----------------------------
--  Table structure for `t_da_province`
-- ----------------------------
DROP TABLE IF EXISTS `t_da_province`;
CREATE TABLE `t_da_province` (
  `PROVINCE_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '省份的系统主键',
  `PROVINCE_NAME` varchar(20) NOT NULL COMMENT '省份的中文名称；如辽宁省等',
  `PROVINCE_ABBREVIATION` varchar(3) NOT NULL COMMENT '省份的字母缩写,如辽宁省为LN,均为大写',
  `CREATED_BY` varchar(30) NOT NULL COMMENT '创建者',
  `CREATED_DATE` datetime NOT NULL COMMENT '创建时间',
  `LASTUPDATED_BY` varchar(30) NOT NULL COMMENT '最后更新者',
  `LASTUPDATED_DATE` datetime NOT NULL COMMENT '最后更新时间',
  `ACTIVE_FLAG` char(1) NOT NULL DEFAULT 'N' COMMENT '激活标志位',
  PRIMARY KEY (`PROVINCE_ID`),
  KEY `IDX_DA_PROVINCE_ID` (`PROVINCE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='省份信息表，记录中国每个省的基本信息。';

-- ----------------------------
--  Table structure for `t_da_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_da_role`;
CREATE TABLE `t_da_role` (
  `ROLE_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '角色系统主键',
  `ROLE_NAME` varchar(30) NOT NULL COMMENT '角色名称',
  `ROLE_DESCRIPTION` varchar(300) NOT NULL COMMENT '角色描述',
  `CREATED_BY` varchar(30) NOT NULL COMMENT '创建者',
  `CREATED_DATE` datetime NOT NULL COMMENT '创建时间',
  `LASTUPDATED_BY` varchar(30) NOT NULL COMMENT '最后更新者',
  `LASTUPDATED_DATE` datetime NOT NULL COMMENT '最后更新时间',
  `ACTIVE_FLAG` char(1) NOT NULL DEFAULT 'N' COMMENT '激活标志位',
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='角色信息表';

-- ----------------------------
--  Table structure for `t_da_sequence`
-- ----------------------------
DROP TABLE IF EXISTS `t_da_sequence`;
CREATE TABLE `t_da_sequence` (
  `NAME` varchar(30) NOT NULL COMMENT '系统主键名',
  `NEXTID` int(10) unsigned NOT NULL COMMENT '系统主键值',
  PRIMARY KEY (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='主要用于系统主键ID生成.';

-- ----------------------------
--  Table structure for `t_da_sortable`
-- ----------------------------
DROP TABLE IF EXISTS `t_da_sortable`;
CREATE TABLE `t_da_sortable` (
  `SORTABLE_ID` int(11) NOT NULL COMMENT '排序表系统的主键',
  `SORTABLE_KEY` int(11) NOT NULL COMMENT '需要排序的表的系统工主键，主要来源于category,brand,product',
  `SORTABLE_ORDER` int(11) NOT NULL DEFAULT '0' COMMENT '所对应的排序位',
  `SORTABLE_TYPE` char(1) NOT NULL COMMENT '所对应的排序类型, C为category, B为Brand, P为Product',
  `PARENT_ID` int(11) DEFAULT NULL COMMENT '排序表系统的主键',
  PRIMARY KEY (`SORTABLE_ID`),
  KEY `PARENT_ID` (`PARENT_ID`),
  CONSTRAINT `t_da_sortable_ibfk_1` FOREIGN KEY (`PARENT_ID`) REFERENCES `t_da_sortable` (`SORTABLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='排序表';

-- ----------------------------
--  Table structure for `t_da_supplier`
-- ----------------------------
DROP TABLE IF EXISTS `t_da_supplier`;
CREATE TABLE `t_da_supplier` (
  `SUPPLIER_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '供应商系统主键',
  `SUPPLIER_NAME` varchar(20) NOT NULL COMMENT '供应商名称',
  `SUPPLIER_CONTACTNAME` varchar(30) NOT NULL COMMENT '联系人',
  `SUPPLIER_ZIP` varchar(6) NOT NULL COMMENT '邮政编码',
  `SUPPLIER_IMAGE` blob NOT NULL COMMENT '图片',
  `SUPPLIER_DESCRIPTION` varchar(3000) NOT NULL COMMENT '简介',
  `SUPPLIER_FAX` varchar(30) NOT NULL COMMENT '传真',
  `SUPPLIER_MOBILE` varchar(30) NOT NULL COMMENT '手机',
  `SUPPLIER_TELEPHONE` varchar(30) NOT NULL COMMENT '联系电话',
  `SUPPLIER_ADDRESS` varchar(30) NOT NULL COMMENT '联系地址',
  `SUPPLIER_CERTIFY` blob COMMENT '实名认证',
  `SUPPLIER_QUALIFY` blob COMMENT '资质认证',
  `SUPPLIER_ACCESS` int(10) unsigned NOT NULL DEFAULT '0',
  `SUPPLIER_SCORE` int(10) unsigned NOT NULL DEFAULT '0',
  `CITY_ID` int(10) unsigned NOT NULL COMMENT '城市系统主键',
  `USER_ID` int(10) unsigned NOT NULL COMMENT '用户系统主键',
  `CREATED_BY` varchar(30) NOT NULL COMMENT '创建者',
  `CREATED_DATE` datetime NOT NULL COMMENT '创建时间',
  `LASTUPDATED_BY` varchar(30) NOT NULL COMMENT '最后更新者',
  `LASTUPDATED_DATE` datetime NOT NULL COMMENT '最后更新时间',
  `ACTIVE_FLAG` char(1) NOT NULL COMMENT '激活标志位',
  `SUPPLIER_WEBSITE` varchar(300) DEFAULT NULL COMMENT '供应商官方网站',
  PRIMARY KEY (`SUPPLIER_ID`),
  KEY `CITY_ID` (`CITY_ID`),
  KEY `USER_ID` (`USER_ID`),
  CONSTRAINT `t_da_supplier_ibfk_1` FOREIGN KEY (`CITY_ID`) REFERENCES `t_da_city` (`CITY_ID`),
  CONSTRAINT `t_da_supplier_ibfk_2` FOREIGN KEY (`USER_ID`) REFERENCES `t_da_user` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='代理商信息，没有完成.';

-- ----------------------------
--  Table structure for `t_da_supplierproduct`
-- ----------------------------
DROP TABLE IF EXISTS `t_da_supplierproduct`;
CREATE TABLE `t_da_supplierproduct` (
  `SUPPLIER_ID` int(10) unsigned NOT NULL COMMENT '供应商系统主键',
  `PRODUCTBRAND_ID` int(10) unsigned NOT NULL COMMENT '品牌产品系统主键',
  `CREATE_DATE` date DEFAULT NULL COMMENT '供应商产品代理开始时间',
  `START_DATE` date DEFAULT NULL COMMENT '供应商产品代理开始时间',
  `END_DATE` date DEFAULT NULL COMMENT '供应商产品代理结束时间',
  PRIMARY KEY (`SUPPLIER_ID`,`PRODUCTBRAND_ID`),
  KEY `PRODUCTBRAND_ID` (`PRODUCTBRAND_ID`),
  CONSTRAINT `t_da_supplierproduct_ibfk_1` FOREIGN KEY (`PRODUCTBRAND_ID`) REFERENCES `t_da_productbrand` (`PRODUCTBRAND_ID`),
  CONSTRAINT `t_da_supplierproduct_ibfk_2` FOREIGN KEY (`SUPPLIER_ID`) REFERENCES `t_da_supplier` (`SUPPLIER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供应商与品牌产品关系表';

-- ----------------------------
--  Table structure for `t_da_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_da_user`;
CREATE TABLE `t_da_user` (
  `USER_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户系统主键',
  `USER_NAME` varchar(30) NOT NULL COMMENT '用户名',
  `USER_EMAIL` varchar(100) NOT NULL COMMENT '电子邮件',
  `USER_PASSWORD` varchar(30) NOT NULL COMMENT '用户密码',
  `LASTLOGINTIME` datetime NOT NULL COMMENT '上次登录时间',
  `REGISTERTIME` datetime NOT NULL COMMENT '注册时间',
  `LOGONSUM` int(10) unsigned NOT NULL COMMENT '登录次数',
  `CREATED_BY` varchar(30) NOT NULL COMMENT '创建者',
  `CREATED_DATE` datetime NOT NULL COMMENT '创建时间',
  `LASTUPDATED_BY` varchar(30) NOT NULL COMMENT '最后更新者',
  `LASTUPDATED_DATE` datetime NOT NULL COMMENT '最后更新时间',
  `ACTIVE_FLAG` char(1) NOT NULL DEFAULT 'N' COMMENT '激活标志位',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
--  Table structure for `t_da_userrole`
-- ----------------------------
DROP TABLE IF EXISTS `t_da_userrole`;
CREATE TABLE `t_da_userrole` (
  `USER_ID` int(10) unsigned NOT NULL COMMENT '用户系统主键',
  `ROLE_ID` int(10) unsigned NOT NULL COMMENT '角色系统主键',
  KEY `ROLE_ID` (`ROLE_ID`),
  KEY `USER_ID` (`USER_ID`),
  CONSTRAINT `t_da_userrole_ibfk_1` FOREIGN KEY (`ROLE_ID`) REFERENCES `t_da_role` (`ROLE_ID`),
  CONSTRAINT `t_da_userrole_ibfk_2` FOREIGN KEY (`USER_ID`) REFERENCES `t_da_user` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户和角色关系表';

-- ----------------------------
--  Procedure definition for `GET_SORTABLE_CHILD`
-- ----------------------------
DROP PROCEDURE IF EXISTS `GET_SORTABLE_CHILD`;
DELIMITER ;;
CREATE DEFINER=`digiagent`@`%` PROCEDURE `GET_SORTABLE_CHILD`(IN IN_ID INT,OUT OUT_IDS VARCHAR(10000))
BEGIN
DECLARE V_STOP BOOLEAN DEFAULT FALSE;
DECLARE V_ID INT;
DECLARE V_SUB_IDS VARCHAR(10000);
DECLARE V_IDS VARCHAR(10000);

DECLARE CUR1 CURSOR FOR SELECT SORTABLE_ID FROM T_DA_SORTABLE WHERE PARENT_ID = IN_ID;
DECLARE CONTINUE HANDLER FOR SQLSTATE '02000' SET V_STOP = TRUE;

SET @@max_sp_recursion_depth = 10;

OPEN CUR1;

LAB1:WHILE NOT V_STOP DO
    FETCH CUR1 INTO V_ID;
    IF V_STOP THEN
      LEAVE LAB1;
    END IF;
    CALL GET_SORTABLE_CHILD(V_ID,V_SUB_IDS);
    SET V_IDS = CONCAT_WS(',',V_IDS,V_ID,V_SUB_IDS);
END WHILE LAB1;
SET OUT_IDS = V_IDS;
END
;;
DELIMITER ;

-- ----------------------------
--  Records 
-- ----------------------------
INSERT INTO `t_da_brand` VALUES ('1','戴尔','DELL','sj','2010-09-15 19:26:33','sj','2010-09-15 19:26:33','Y','3'), ('2','惠普','HP','sj','2010-09-15 19:34:31','sj','2010-09-15 19:34:31','Y','3'), ('3','三星','Samsun','sj','2010-09-15 19:35:22','sj','2010-09-15 19:35:22','Y','5'), ('4','宏碁','Acer','sj','2010-09-15 19:37:02','sj','2010-09-15 19:37:02','Y','4'), ('5','华硕','ASUS','sj','2010-09-15 19:37:44','sj','2010-09-15 19:37:44','Y','4'), ('6','联想','Lenovo','sj','2010-09-15 19:38:33','sj','2010-09-15 19:38:33','Y','1'), ('7','同方','同方','sj','2010-09-15 19:50:30','sj','2010-09-15 19:50:30','Y','1'), ('8','索尼','SONY','sj','2010-09-15 19:53:41','sj','2010-09-15 19:53:41','Y','2');
INSERT INTO `t_da_category` VALUES ('1','笔记本及配件','admin','2011-04-30 23:21:18','admin','2011-04-30 23:21:18','Y'), ('2','整机','admin','2011-04-30 23:21:44','admin','2011-04-30 23:21:44','Y'), ('3','手机通讯','admin','2011-04-30 23:22:00','admin','2011-04-30 23:22:00','Y'), ('4','照相摄像','admin','2011-04-30 23:22:16','admin','2011-04-30 23:22:16','Y'), ('5','装机配件','admin','2011-04-30 23:26:48','admin','2011-04-30 23:26:48','Y'), ('6','数码','admin','2011-04-30 23:26:58','admin','2011-04-30 23:26:58','Y');
INSERT INTO `t_da_city` VALUES ('1','大连市','DL','sj','2010-09-15 19:15:39','sj','2010-09-15 19:15:39','Y','8'), ('2','辽阳市','SY','sj','2010-09-15 19:16:00','sj','2010-09-15 19:16:00','Y','8');
INSERT INTO `t_da_country` VALUES ('1','中国','CN','System','2010-09-15 18:54:00','System','2010-09-15 18:54:00','Y'), ('2','日本','JP','System','2010-09-15 18:54:25','System','2010-09-15 18:54:25','Y'), ('3','美国','US','System','2010-09-15 18:54:49','System','2010-09-15 18:54:49','Y'), ('4','中国台湾省','TW','System','2010-09-15 19:26:59','System','2010-09-15 19:30:38','Y'), ('5','韩国 ','KP','System','2010-09-15 19:28:33','System','2010-09-15 19:28:33','Y'), ('6','中国香港特区','HK','System','2010-09-15 19:28:50','System','2010-09-15 19:28:50','Y'), ('7','加拿大','CA','System','2010-09-15 19:29:12','System','2010-09-15 19:29:12','Y'), ('8','法国 ','FR','System','2010-09-15 19:29:37','System','2010-09-15 19:29:37','Y'), ('9','荷兰','NL','System','2010-09-15 19:30:14','System','2010-09-15 19:30:14','Y'), ('10','英国 ','UK','System','2010-09-15 19:30:56','System','2010-09-15 19:30:56','Y'), ('11','新加坡','SG','System','2010-09-15 19:31:25','System','2010-09-15 19:31:25','Y'), ('12','德国','DE','System','2010-09-15 19:31:47','System','2010-09-15 19:31:47','Y');
INSERT INTO `t_da_product` VALUES ('1','笔记本','admin','2011-04-30 23:27:56','admin','2011-04-30 23:27:56','Y','1','3'), ('2','平板电脑','admin','2011-04-30 23:28:18','admin','2011-04-30 23:28:24','Y','1','1'), ('3','上网本','admin','2011-04-30 23:29:05','admin','2011-04-30 23:29:05','Y','1','7'), ('4','笔记本包','admin','2011-04-30 23:29:36','admin','2011-04-30 23:29:36','Y','1','3'), ('5','台式机电脑','admin','2011-04-30 23:38:48','admin','2011-04-30 23:38:48','Y','2','1'), ('6','一体电脑','admin','2011-04-30 23:39:25','admin','2011-04-30 23:39:25','Y','2','1'), ('7','瘦客户机','admin','2011-04-30 23:39:43','admin','2011-04-30 23:39:43','Y','2','1'), ('8','手机','admin','2011-04-30 23:39:59','admin','2011-04-30 23:39:59','Y','3','1'), ('9','蓝牙耳机','admin','2011-04-30 23:40:15','admin','2011-04-30 23:40:15','Y','3','1'), ('10','对讲机','admin','2011-04-30 23:40:29','admin','2011-04-30 23:40:29','Y','3','1'), ('11','手机电池','admin','2011-04-30 23:40:44','admin','2011-04-30 23:40:44','Y','3','1'), ('12','手机充电器','admin','2011-04-30 23:40:58','admin','2011-04-30 23:40:58','Y','3','1');
INSERT INTO `t_da_productbrand` VALUES ('1','2','1','admin','2011-05-02 16:04:52','admin','2011-05-02 16:04:52','Y'), ('2','5','1','admin','2011-05-02 16:05:11','admin','2011-05-02 16:05:11','Y'), ('3','6','1','admin','2011-05-02 16:05:25','admin','2011-05-02 16:05:25','Y'), ('4','1','1','admin','2011-05-02 16:05:58','admin','2011-05-02 16:05:58','Y'), ('5','8','1','admin','2011-05-02 16:06:16','admin','2011-05-02 16:06:16','Y'), ('6','3','2','admin','2011-05-02 16:07:25','admin','2011-05-02 16:07:25','Y'), ('7','5','2','admin','2011-05-02 16:07:42','admin','2011-05-02 16:07:42','Y'), ('8','7','2','admin','2011-05-02 16:08:25','admin','2011-05-02 16:08:25','Y'), ('9','8','2','admin','2011-05-02 16:08:51','admin','2011-05-02 16:08:51','Y'), ('10','6','2','admin','2011-05-02 16:10:20','admin','2011-05-02 16:10:20','Y'), ('11','2','3','admin','2011-05-02 16:12:09','admin','2011-05-02 16:12:09','Y'), ('12','5','3','admin','2011-05-02 16:12:41','admin','2011-05-02 16:12:41','Y'), ('13','1','3','admin','2011-05-02 16:14:01','admin','2011-05-02 16:14:01','Y'), ('14','8','3','admin','2011-05-02 16:23:47','admin','2011-05-02 16:23:47','Y'), ('15','6','3','admin','2011-05-02 16:25:01','admin','2011-05-02 16:25:01','Y'), ('16','3','3','admin','2011-05-02 16:27:01','admin','2011-05-02 16:27:01','Y'), ('17','4','3','admin','2011-05-02 16:29:01','admin','2011-05-02 16:43:24','Y'), ('18','7','5','admin','2011-05-02 16:47:18','admin','2011-05-02 16:47:18','Y'), ('19','6','5','admin','2011-05-02 16:48:02','admin','2011-05-02 16:48:02','Y'), ('20','2','5','admin','2011-05-02 16:48:19','admin','2011-05-02 16:48:19','Y'), ('21','1','5','admin','2011-05-02 16:48:52','admin','2011-05-02 16:48:52','Y'), ('22','5','6','admin','2011-05-02 16:56:39','admin','2011-05-02 16:56:39','Y'), ('23','4','6','admin','2011-05-02 16:57:09','admin','2011-05-02 16:57:09','Y'), ('24','3','6','admin','2011-05-02 16:57:39','admin','2011-05-02 16:57:39','Y'), ('25','5','10','admin','2011-05-02 17:06:04','admin','2011-05-02 17:06:04','Y'), ('26','4','10','admin','2011-05-02 17:06:16','admin','2011-05-02 17:06:16','Y'), ('27','5','11','admin','2011-05-02 17:16:25','admin','2011-05-02 17:16:25','Y'), ('28','4','11','admin','2011-05-02 17:16:53','admin','2011-05-02 17:16:53','Y'), ('29','3','11','admin','2011-05-02 17:21:21','admin','2011-05-02 17:21:21','Y'), ('30','8','11','admin','2011-05-02 17:22:10','admin','2011-05-02 17:22:10','Y'), ('31','2','12','admin','2011-05-02 17:25:49','admin','2011-05-02 17:25:49','Y'), ('32','1','12','admin','2011-05-02 17:26:16','admin','2011-05-02 17:26:16','Y'), ('33','5','12','admin','2011-05-02 17:26:39','admin','2011-05-02 17:26:39','Y'), ('34','4','12','admin','2011-05-02 17:27:09','admin','2011-05-02 17:27:09','Y');
INSERT INTO `t_da_province` VALUES ('1','北京市','BJ','System','2010-09-15 18:57:24','System','2010-09-15 18:57:24','Y'), ('2','天津市','TJ','System','2010-09-15 18:57:47','System','2010-09-15 18:57:47','Y'), ('3','上海市','SH','System','2010-09-15 18:58:04','System','2010-09-15 18:58:04','Y'), ('4','重庆市','CQ','System','2010-09-15 18:58:16','System','2010-09-15 18:58:16','Y'), ('5','河北省','HE','System','2010-09-15 18:58:30','System','2010-09-15 19:06:22','Y'), ('6','河南省','HA','System','2010-09-15 18:58:47','System','2010-09-15 19:06:46','Y'), ('7','云南省','YN','System','2010-09-15 18:59:03','System','2010-09-15 18:59:03','Y'), ('8','辽宁省','LN','System','2010-09-15 18:59:17','System','2010-09-15 18:59:17','Y'), ('9','黑龙江省','HL','System','2010-09-15 18:59:35','System','2010-09-15 19:07:13','Y'), ('10','安徽省','AH','System','2010-09-15 19:01:48','System','2010-09-15 19:01:48','Y'), ('11','福建省','FJ','System','2010-09-15 19:02:26','System','2010-09-15 19:02:26','Y'), ('12','甘肃省','GS','System','2010-09-15 19:02:49','System','2010-09-15 19:02:49','Y'), ('13','广东省','GD','System','2010-09-15 19:03:06','System','2010-09-15 19:03:06','Y'), ('14','广西壮族自治区','GX','System','2010-09-15 19:04:34','System','2010-09-15 19:04:34','Y'), ('15','贵州省','GZ','System','2010-09-15 19:05:22','System','2010-09-15 19:05:22','Y'), ('16','海南省','HI','System','2010-09-15 19:05:54','System','2010-09-15 19:05:54','Y'), ('17','湖北省','HB','System','2010-09-15 19:07:32','System','2010-09-15 19:07:32','Y'), ('18','湖南省','HN','System','2010-09-15 19:07:50','System','2010-09-15 19:07:50','Y'), ('19','吉林省','JL','System','2010-09-15 19:08:08','System','2010-09-15 19:08:08','Y'), ('20','江苏省','JS','System','2010-09-15 19:08:27','System','2010-09-15 19:08:27','Y'), ('21','江西省','JX','System','2010-09-15 19:08:45','System','2010-09-15 19:08:45','Y'), ('22','内蒙古自治区','NM','System','2010-09-15 19:09:18','System','2010-09-15 19:09:18','Y'), ('23','宁夏回族自治区','NX','System','2010-09-15 19:10:03','System','2010-09-15 19:10:03','Y'), ('24','青海省','QH','System','2010-09-15 19:10:20','System','2010-09-15 19:10:20','Y'), ('25','山东省','SD','System','2010-09-15 19:10:42','System','2010-09-15 19:10:42','Y'), ('26','山西省','SX','System','2010-09-15 19:10:59','System','2010-09-15 19:10:59','Y'), ('27','陕西省','SN','System','2010-09-15 19:11:34','System','2010-09-15 19:11:34','Y'), ('28','四川省','SC','System','2010-09-15 19:11:58','System','2010-09-15 19:11:58','Y'), ('29','新疆维吾尔族自治区','XJ','System','2010-09-15 19:12:36','System','2010-09-15 19:12:36','Y'), ('30','西藏自治区','XZ','System','2010-09-15 19:13:07','System','2010-09-15 19:13:07','Y');
INSERT INTO `t_da_role` VALUES ('1','系统管理员','具有所有的后台权限','system','2010-01-01 01:01:00','system','2010-01-01 01:01:00','Y'), ('2','超级用户','具有基本数据维护和报表权限','system','2010-01-01 01:01:00','system','2010-01-01 01:01:00','Y'), ('3','一般用户','具有基本数据维护','system','2010-01-01 01:01:00','system','2010-01-01 01:01:00','Y'), ('4','企业会员','企业用户功能','system','2010-01-01 01:01:00','system','2010-01-01 01:01:00','Y'), ('5','个人会员','个人用户功能','system','2010-01-01 01:01:00','system','2010-01-01 01:01:00','Y');
INSERT INTO `t_da_sequence` VALUES ('advertise','1'), ('brand','1'), ('category','7'), ('city','1'), ('comments','1'), ('commodity','1'), ('commodityimage','1'), ('contact','1'), ('country','13'), ('history','1'), ('product','13'), ('productbrand','35'), ('province','31'), ('role','6'), ('sortable','53'), ('sort_order','73'), ('supplier','1'), ('supplierproduct','1'), ('user','2'), ('userrole','2');
INSERT INTO `t_da_sortable` VALUES ('1','1','60','C',NULL), ('2','2','61','C',NULL), ('3','3','62','C',NULL), ('4','4','63','C',NULL), ('5','5','64','C',NULL), ('6','6','59','C',NULL), ('7','1','66','P','1'), ('8','2','65','P','1'), ('9','3','67','P','1'), ('10','4','68','P','1'), ('11','5','11','P','2'), ('12','6','12','P','2'), ('13','7','13','P','2'), ('14','8','14','P','3'), ('15','9','15','P','3'), ('16','10','16','P','3'), ('17','11','17','P','3'), ('18','12','18','P','3'), ('19','2','19','B','7'), ('20','5','20','B','7'), ('21','6','21','B','7'), ('22','1','22','B','7'), ('23','8','23','B','7'), ('24','3','24','B','8'), ('25','5','25','B','8'), ('26','7','26','B','8'), ('27','8','27','B','8'), ('28','6','28','B','8'), ('29','2','29','B','9'), ('30','5','30','B','9'), ('31','1','31','B','9'), ('32','8','32','B','9'), ('33','6','33','B','9'), ('34','3','34','B','9'), ('35','4','35','B','7'), ('36','7','70','B','11'), ('37','6','71','B','11'), ('38','2','72','B','11'), ('39','1','69','B','11'), ('40','5','40','B','12'), ('41','4','41','B','12'), ('42','3','42','B','12'), ('43','5','43','B','16'), ('44','4','44','B','16'), ('45','5','45','B','17'), ('46','4','46','B','17'), ('47','3','47','B','17'), ('48','8','48','B','17'), ('49','2','49','B','18'), ('50','1','50','B','18'), ('51','5','51','B','18'), ('52','4','52','B','18');
INSERT INTO `t_da_user` VALUES ('1','admin','porkin@126.com','admin','2011-05-02 21:24:40','2010-09-15 20:13:55','3','System','2010-09-15 20:13:55','System','2010-09-15 20:13:55','Y');
INSERT INTO `t_da_userrole` VALUES ('1','1');
