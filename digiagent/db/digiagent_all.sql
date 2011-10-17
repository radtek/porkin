/*
MySQL Backup
Source Server Version: 5.5.8
Source Database: digiagent
Date: 2011/10/3 22:09:20
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='商品信息表';

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='商品图像表';

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

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
--  Records 
-- ----------------------------
INSERT INTO `t_da_brand` VALUES ('1','戴尔','DELL','sj','2010-09-15 19:26:33','sj','2010-09-15 19:26:33','Y','3'), ('2','惠普','HP','sj','2010-09-15 19:34:31','sj','2010-09-15 19:34:31','Y','3'), ('3','三星','Samsun','sj','2010-09-15 19:35:22','sj','2010-09-15 19:35:22','Y','5'), ('4','宏碁','Acer','sj','2010-09-15 19:37:02','sj','2010-09-15 19:37:02','Y','4'), ('5','华硕','ASUS','sj','2010-09-15 19:37:44','sj','2010-09-15 19:37:44','Y','4'), ('6','联想','Lenovo','sj','2010-09-15 19:38:33','sj','2010-09-15 19:38:33','Y','1'), ('7','同方','同方','sj','2010-09-15 19:50:30','sj','2010-09-15 19:50:30','Y','1'), ('8','索尼','SONY','sj','2010-09-15 19:53:41','sj','2010-09-15 19:53:41','Y','2');
INSERT INTO `t_da_category` VALUES ('1','笔记本及配件','admin','2011-04-30 23:21:18','admin','2011-04-30 23:21:18','Y'), ('2','整机','admin','2011-04-30 23:21:44','admin','2011-04-30 23:21:44','Y'), ('3','手机通讯','admin','2011-04-30 23:22:00','admin','2011-04-30 23:22:00','Y'), ('4','照相摄像','admin','2011-04-30 23:22:16','admin','2011-04-30 23:22:16','Y'), ('5','装机配件','admin','2011-04-30 23:26:48','admin','2011-04-30 23:26:48','Y'), ('6','数码','admin','2011-04-30 23:26:58','admin','2011-04-30 23:26:58','Y');
INSERT INTO `t_da_city` VALUES ('1','大连市','DL','sj','2010-09-15 19:15:39','sj','2010-09-15 19:15:39','Y','8'), ('2','辽阳市','SY','sj','2010-09-15 19:16:00','sj','2010-09-15 19:16:00','Y','8');
INSERT INTO `t_da_commodity` VALUES ('1','对讲机','SA','2011-07-18 00:00:00','2011-07-25 00:00:00','S','111.00','2','abcd','2011-07-18 19:58:36','abcd','2011-07-18 19:58:36','Y','10','11111.00');
INSERT INTO `t_da_commodityimage` VALUES ('1','GIF89a@�\0�\0\0\0\0\0���޳����������ü�˛�������������Ģ�ϲ����������ˁ�ͼĤ�����Ĵ��������������i���������ԥ��ɍĜ�������������������绷�������������������Ƿ����������ќ�������������߶Ļ��䜤������������������ܾЮ�����������������Ĕ����Ԝ����������������������䜜���������������������ܲ����ܼ��ü��Ī�̳����������Ś������������ļ��̼�����������������ө���Լ�������������ī�̳ʵ����ĭ�Ѽ�������������Ĵ�̼��Ĵ�̼�����������܎�|����������ļļ�������������������Ŧ����ֶ�ͬ����Ĭ�̴��Ĵ������ϙ{��˯��Ĥ�̬��ʼ������������Ĵ�̼��ļ��������������䦈zշ�ͣ�|cZ繩hJ@թ�������Ĭ�̴�����qe����vq�ü������=%Ĥ��y̬�������Ĝ�̤�ջ�����te����������܏��ĿԬ����ު�ͤ�滺Ĥ�̬����������Ĭ�̴������Ԥ�����������̼�Ĵ������������������䜔������ĳ����������������ܨ�������������������Ĝ��������!�\0\0�\0,\0\0\0\0@�\0\0�\0�Hpޤ��[8� Ag�HI�\rڮ���Hj��]�H��X�W/?}���c�Ԣ��H�ly�T��KE�F��DI�*q[�DH�%*�Hc�)Svm��t\nR�5z��($H�\"M���$��ڰ�\ZI�$H�=�d��#Ix��\n�U�I�\\t#ɍ�_Y�m˦�c6�[y�Ky��H�?R#�Q��]#9^�x�\ZΛW9Z�y���j\\�N�F��۷S�a�f\r�߿Y�{r9�*ܮW=fÆ�$�Jg�С�RFI�R$�#Ƌ�&��(�LȞ�@�ꣳ�r�L)�i�%.r�l��FJew����Qw^N8)E\nTVAUU�>e�3Y4��be�SV$fMҕotMB$��\"W$M�`|��`�VB�]�Y+�a&p�YF�c���d���\\����#������Նn��\"pX�����u�m�-לuE\'�Aԑ)�1��7ze��\"IM/w�tRM���\n*5�d�L�hs�)ݕ\r��|ޣ�!�Sx�hԎS2�iUH��H=�8�N\\�E#�LR�W*N�#h��F�$���$/��_{\r��ai���c�Mƣ�@n&�\\D��M��d�O���#RN��#�a�-$���e$���Mr�1�sj^��h�i�s~�Q�gx�UOH��R/�T�J:ms\n.}6��)|(R�8�,�)ۘҨ�N���O\Z��ԥJq$�U>52U���H�t5�Ad��;2�*���0�F�d�$wE��W.���υ	�Fb����k9q찞%	\Z�5�#�����*Ԯ[l�iK��z�+]�k۹��^x�iZ�-�.^���q�HK��]�#5�M~dR�)!l�����\"�`W���D�d<^�$x��$�~ՃS�ޠƻ�BL�5�Ye��W����#���!�eI{�}	��_2J��^l�tcQO�g�$�#X��Xi�v-m\Z`�V-�ٚ-�ic�v[ȡ�d�����Qg��{�\'�PK}�Gv���T/c��3�I�Rў�T���W�<���.<\Z��R�v��t)#�3�aF8�*衪���/��B��V8!�(\Z�\\&09^���&4Ab\\�y\Zf��M�3�Y�b�Ŝ %�k�CRl�&l�oJ��̕�W�-�}`Ñ����6^!~�C�E��H�$�Ƥ4\r�p�s@�C/��6�	�`�LN��R0\'���߄\"��$N���2~�*Y�ĺ�d!�.���,@�y�A�>�R���\Z����E�j�+��� \nKG8��Zԇ,�X�39����\Z�9\"�jDr�6mz�l�	c$z~kK�1��ؖ6��~q�#�\"	ydRQ�S0��9�O\"����0S ��CELI\\��h�$b2�\\$*���.u)M�̃��(��ȅ�0��u�Cf`#�#����*�X�B\Za����x@Dڊ�vĦ%�Gc��	�ea�XӃ����A�{�C6�A�[�TE�Tβ��8lPg܎�\n{���q�<��&{��1�R��$�\Z��J��B��8\\�\'>ԇ��	���D��*F7�\r�ԣ-Y�:���H!@��1r�cx�Bla�#\Z�,�0b�`C��@�+�X?mC3L�!戗!R���d9{Y{�s;#�4TWl���*�P���6a+9��[��S���Z�����i�sl���c�#;��H%�������5�8�X�\0�r���N��7Ma#Q�F%�AO�B��h(�2��̧M��\\X�z�v/�`�*R�\n>��e��iY跢�W0�Q���F&�|i�f��=uM�3_\0D&4Q]U\\|i�j �\nA�5��xo#N Ŭ���Њr�-�Fn��8?y����X0�N(&�fl��� Ob�,�`����᧗,b�h�)��9��*��dgQ��kx�#Èa�N�a1�$(tDH�a�@E\"���I8f,d��_��W�Vӥ�����Ԕz��MWH���#4�V�\"�� �	�b�����\nڀ57b�\ny+�&��m�Tb{��.7�nn���\'��~m�����S)6���( �q(?��5qܡnB���_M��EO�ɑu��mH/�q�����0¸�?��vp�QL�)���B\"\nP�B]~U�]���nQ�D�{�_�ͯ�\r\ZM��9�W�c�aq��� MT�Q���mooYʀ���������`��p��\\7�ݐ�ϓ �d����@H��|H��q�80*hr(��$���CN��z?��� T&�gp��JF��m�^�`C&p�B��b���L1<I���x��p���!\Z׈<�^q\"�s�(��1:fԐ�h\"��D/,�@l���*\n=h]��v�׿����Kd7;�+�/��Y�;�X�y�Ş�ˇN�o:��!1y��(������H|�\'����\'ڰ��1�W�Bq��:�Q�Vq�a�  �\rƀ	��0�b�\n.�!� 	��V �{7&\\�BLt�s;�=�W|�q|�q=ɷ=�Pe��@\nj�	y���i���&��	�@	{@X%~VF~٢m1^|�e�N�vi._�\nq#7�!�Dj\"?�\'� R)u�x%�R���Z�s\n�x�����0�0��\r9�p�)�y�oJ��4i�22Xq%Q���Њ��	��� ��\n��j�� g@��s�g?D��+���t�l�k�1����JE�6dR�Cj�	�������p{`��y�	�`�\0\n�0z�m��w�m��U߶bl�R@Vvj�Md`>��^rw��AW8WmT��MQ)��\Z�9t�\r<1Y�uW��X\r�\n�\0\rh\n| ��\'A�C� t:�y��q�hWq\r� ����0�P�@�����2�?��@�8g1g��+:(\\�u�9VDL�k=G|�tj�l�\'�S�w�э�0�0��}\0\n��	�\0��Y�UQ�U^d�ْ\n�.��������m�f�Q�rW7�{��F���@�	2�GA����8!q��p0����H��t\n�x\'��0�Pg��W��A4�Y3:����y��g��i��e����D��q�JPKٔO�{����\nUyA�4Y�m�����($�iPx���pl�\n� ���	~P	{�	z���t�Z�%z���/EgǏ+4���>>w�&?�Ic\n�F� ���\ry/o�(����P�����@F9�p�!�1Ba�I-y����Qu��\r�p%�p���l�0J��!�N��9�i�� ��c��2.�G|�ITJŝHx�V%P���0��Pڰ��pٗx0y��p	{���	��Ezz��㟿1n�2�o	�.�!�3?u��o�%	Y91:F\Z1)��B�w�`�\n(��0�Ѐ��B��6:R1�Y�)���������&��]p���������\"��\n�ٜ3�4b�3<{!.WZ~!l�9���\nr�����ܰ�A\n�����	����~@�	�`��Z	y����L&V��m���Zb,�\0�dgbin#�o�s���y���F\nxE��T�����`��[1��Ph\n���p`���d�p ���9���w_7r~�S\n��!%2۠Z �&Ơ	��\nR�\nұf�g@�ƺ�Li{�*\\�c͊�b�W\n	ݸ�[�Lf���\n���0�$��\r�� ���P���\0�0�@�@m\n\ny�{0e��uec�l���Jve\'\"[��q��*\n����n�������`\n���6X�����U\n��\n5�`\rƩ�������QR������Pؑ�5�1ۊ�\0�� ��\0p����\n������Jy�P���)�z�{��|X[��m�mq+�=l\0�]��\n���\0�@R\r�зĐ�P���dj���з���\rw����{ٟZ˸*T*��J��pQ����7�fw4���a*���:a���\'�\0���\0( [�1|\n��\'� �W/���iYR\n~�����b��6q :�����i��\0�����*�K��W�(T�{(��C���fp%�+��qR�p\n���p��\n���`���	w\n�@K��a@x�������P\n�\0\n������\0>�h���|!�Z*�\"�I�uH7릨�?��n,Ţ�0e��	�0zei/��0��\n����|�P����|R\r����x_�K��&� ���~�2+)�t��;\Z\n����ⱍ�?C�n�K\ni�k<�m�c��%��� �����-c��@�0��Ǟ�0� ��m�w }�l��\0\r`��c���x\0��`�������kbe1;��<n|A�V&�b$�����.�,wzU�����<�0e2oY:a�g\n~@9��h�\n��\'-��|�������A��`z����Uݴ	��	��̀��){�O�iV�g�wȰ\n*��: A�P`�����kS�xQD�\nЋ!���B|�v|#�:|P��p\n��ow`��	�g��c�p00Ġ��\\\ncj�w��`��Ƿ1�¯_�aƏg�7-V���p\'Ni�K:w��w�)w|0�9���Mv����oT)ڀ��ԙ���\n�è��\nDhOM\nīQ�@�����x�M����0\nH�	�(\\���1�@olRȄ���]|}t�}υ���D�Ь5V���ƤT�����l �	�\0.j ��`���А	��npy@���@�u;0)��P	��\Z�a���_A�-�Zn8=�j�m��N+�u����8kY�u��������oK�w��P�����@���R�@��6!1�2U� ��m�iM��]߫���U���P��+��S�i�5Ֆ�D��a�\0�d\\�N�	1\\t#�^TX�<��\Z	_[E�	��\n��nn�0��q�� bpX���d\Zɔ������pUս$�i,D�q&�s�l!VV�vK~T�ns7/8(��V��\ri}Nq���<�p\r&yR� �R� �W��3�P��=�������ެ��\\�>�H�����8KZQ��ڡ\n���� ��� 	�H��j��Lkj,#� �~��K|l�\\i��L��z��@�����P�}���@�pxp��c�r	�0��W6�c,�������٦�shd��F�>o���5�V.�0��P�e?�@���.F����h\0 �\nʐ\n����|���H	ڌ��$�ݼ���� �\n�P�\0���k�ʠ(l_�E1�\0��`��`��`�\ZdH�(1Wn��-	0(m �$��м���\0���c{�Q��\0�P\n�\'���>፨\0���{�	\"M��� \nx+��	\\��m����		�Pv�n�*�両^bc����ƽ�u��l�X�Y+1��n��`�f�2�!e��AS�L�t*��T|R�B��ԟS�L�)U�ϟ@��ZF�!�(	Re\'�.]��)�5h�B9s�D9j٠_+c�ʄk[�DI�n#5���M�na\n�)��R��2�k4RP�Hr�F��i�@�Ե�$��ژ��H�$IQ�B��f\r_l\"\rfU��/D�-f���cȾfM�5y�)U��i,�X��Z�kU�%\0������,a�B�Q�&��#GiTe���/$v�x�[�qz�#��=r�*5�Z	��6�<+��]��ݻ$���˓T�)�DHKt�N����2�7�&A�<�1� SN��TN�㏃���\\Ni�B؀�6�D!\\�(���LFe6�I\'Vr�eF\n��\0���p��b���Oc�	%�\\��j���K,�^9�{ԪK�T\Zi��\'a$\r*�d�IT���HX�ҰH\\�ˉ��\Z�\r6Z�D\r���DAd�TNi��]A�b@�3*��P`�%�҄��F�Bk1%�P���&C��ļ�tSM�d9�{.��O-��N�+�O<��a��Ii����i\rV�3�V�0ĕ6\\q��BZ9��ZFYBQ]�\0D�A��]!qe�Q\ZD�D�i�\\tY�At5�DfQ��M�y�m�EjF�z���\\n1��R��Q+���,��J�$�z$�W��/I��K�cy�e��+�K1�hCD�Z#d�Z	��La�qQ�+RH��P�P��X����Ȉ�LG\\B���o�m7F����Lz�#���&A.��XRE��S3�Sc\r�VYu������piG@�B�|�U�a�%��b���XH(d@r$@D\\6\'C8)ĕS�H/�)Ε�[���]xyZe�z_�Ŕm̝�_R���qVPi�L�:�D���R�$ˍ�!FK�Dܨ��60�X��2�ː���N�Q�f�FPQF�p�9E�8\\�LQFDj�CP=B�h>��ؠ�E�X�fj�`D*z�\rg�������1gld{�tc��\rc�j�v���+t�n�b�Mp2!a	Kp�+V������PF.���B9aE,X��)�\r]�j�8P��`��W���OFA/A\"\r1z^�;R�ȅ�G�BwRPD��ӕ]��xc)�X�\0��)�,�+`���GX�hX��50�0DY_V�V�B��,@�u(��(;&�T����Eva_���x�%�QD)M�xL��!�@H��I�#R��(�b[�\Z��\n�MpT�:c�vcp��)�h�C\n�XJ$�D%�+p1�ɘ\'���^���	wȉXB\r�(�4�ѹs�I��&�����G\')�� 6�:]�\"_2�J/���H���H�|��3�.f�\n)&�(��Hp�(^�W�cn��\Z�X4�QYk �-�%���i�؄*��Q���H�G�\rb�!���qʤ�\0�q�2��A��9ʰe\"qUE��+;��^��/� 1/�A� Ӄl�`xP5�G�!0B{FT%��X���\n��WW�g*�IJNNp≨�<���+��]�!�)D\'H1u^�\0ƉR�O�)C��E�;R�8E��bEW݆R�Ԇ��I�C�G��6��e!�^Xa:Q-�$�X!��A���v1�ZLoN��<\"!�mh#~�E`�S��L�`�d`q(_��3�\r�0n�4�Bj�Ɍ-��Ix���D#���5T�2u�9��jU�T�v���\"�z#�����7k����=��[)aqb9a�Q�B\n��Bځ��!��`���!�I�L��:!��ϙ��E�:�RR�ZM�����;�X��Q�+mK�2��\0\n�}�!�bl��C�����$�d!��H�T���E-�1v@b�`TO���@�E��\r<$!~� ���J��&��\r#V�Z��\0&΀�a��R������k�;F&ZB#}%eqj\0�_T�+^%K\r\'�3_g,\nu�ńp�(4�g\0H�<�0�q���;�0HC��6�����S�芽S�4��S�����\"��,�a��h�Z��F���W�����m[���Bi� ��\nD��d�h���U���D-\n�y�����F-T�$j�/�p�L���.z�<d\r��Z�é]�N�SH�qV������Y���A�yVj��9�ёv�n�Nb��`A�M��`1^W��`sv٣�&r1�,\0�	�Hʹ�\0��b� q\\���\'��ʽL��%��@H��F���d�7W(ڋ~��\rn�� 1��x�.��4���5�9*4�ѩ�������--��������0\"�R�.TC��|F��)�hN�|?�&����Ҡ��z7��%$X�4b\nq1: ���L�`����U�;�����sa�a�s�6^K�����Ʉ?�@��_\0C8��[��,ec�Q��mxH�6\'0\0wp��K?�B��ߪ��29	�\0�X����&��a&�T��\n9��3�,3~{��*����2��:��Þb9A��V(�WX�%b��b�6��o1DL A�B�C!VP5pc���C���`�ǐ�Ș/���ڄ_H�� ��^�%�AT5�K?�Q�CcR�k���E��EXs��)����)\">?�-҅AC<����~j;chHp����Seh��(��`� s��(Q�H2M8c� j�s�-�\0�i\"#m�Ah�.�B7��I0��@�$|!|r�H I�B� �hX86��������eh�L�Q�E���6�R��aC�S�Ҩ���4������ˌ��>�DA܅A,?HX�VK��VP�D<&�e����E��w�E�+�J�A�55he9�N���(A��A\n��+2�@,;0B #��H�k:����y1�)�R��+jx���H(F���3#�1�V���0\\|��p2ۅE�S�>�=-��]8ø�h�N@���`��؞8��V��H LIP�[�z@�fhP8/L�C:�/U��>�\rbFPG��Y�>���\0:Mi ��H�L���ʎ�䎴�ȐT>��ٜ�l�#1� �(\n�������@����xA�_��LH��H�N� ��H�]�\'�32�@����\\�c���:�D�����S(G�\nSH�m0�D�U�FIxC\\$[�.7�kL�p�Kd��V �f�4��H�F\07�q�`@�_P�[h�G��Xm��Up�ǄL~L�K������R�\r@H�MZlHzȥ��j�]hK������D� Uq+�D+�09P��L�vxA`�%J�e3,�P!b)��	���R	AE2�����V)-�	�`;�X	{х�#��Y�vx�F��U��G�<L�^�(R�����Cp���i����D��U�ŋ�Ȟ4X8Z �H4A��X�UX�4�5XU��I��X�a8�Y�v@�t�WX�\\�[������36�Cbh4U*h\rh\05I�\r�J����A�� 5�!U::�H���S�͑�zX�R�-�I�Ӂ�\\��R�ۖ	1�o��zu�@��031��8E6\"C��	\n�l���w��z��&`�E@zê�m�7hȅ�\Z��iԱ8K(`\'0���kB��WH�.Y�MX�U��7c?!HX5XĘ�X�/�>�p�@`��:�V�Y`m�[�F�KC*�L�Sܰ���߰$��ֈ$?��\n:��\ZI�WXi��CS��EO��	�#2M,�؛�0��r�,��Ȭ-�������+���@1�%����e�U-�ą>`ءk��y�]P|���<�68�cX�F���������6�(4Ҕ�C��\\�\n��P��7c��l�E`(�p�zd�U`�+_�A�Lh�e�m�oH�eH�[����ǧ%V6L/6��>�9���Y�\n��<)�\n�ê]�*�K��ֱ5�$��t�o�F0�q��H5���ڬB8��N��(;|b�+�6`	��C�29k4\\�펤���J�\\�(�	���� #=a��5����܌yhT�Ip�DX�W �م3���Ћ6HH(UP^]9G	9GT\0��E��@�I`�v��X�vhb̅f���E�>CPX�]8��^b ���A�/���i���0�Q���Ұ5R���X�����IW!:�WKS��]9f)�8#Nze)��Eؽ�+�(]A�������~-sS2\\���@���\n%Ph(�S��k<�O(�C ��rJjTF(�(�\ZN�I��A��yL�I �0�6=��]��V�����X�O1_h��J\0��I �b�B�T�p�ohX@��(�b|42f�]�9���O�L��������y(��G �Ry���HZ���0Im؆(E�G�#�r�#NW\\�A(��b�mN6�%�9�6-�U)���N�謓8r�ӗhLȰsa�8!1�E`��\\@#t�78�&���\'�aHPf��6 [m9�]Q}��5���M�H��H�G��MȂ58H(��]��i�dp\r�Z�E32vڟ�Xx�^�.< >L��\Z@d �+�>h���#-W>��?���&tQ�\n1	fSB�5Aiلr2!n�11� �05vx�==��`.v0|��~����%-���\nX@4.�F5�W�W@j$��^�XL�Vf(��D�D�V���d��8�b8�AR�5X�F�_HkDX�I@Z0�Ax�6�XP�o0��^V��ae�Zx4�^0(���U`P��&!M���pl/+���$��V�@Z��*����98��=�A>e�3�A�m`6��-��`½�MN��,����2e�F��Ҋ�:I\0�BB薆i؃N��!��p�I]��!)ޅh��sh�@���p3�Y�D��]�,���s�68�Hp.Wh�XVP�U(0�a���P8�l���a���ō��g��\r��Z��ぞp�=h�`0���>�:��� \"ty��E���v�r��~p�\0�p��0� ����Ni�~S�����#Cء�i�!��2�|Z�$X��=j��C�(�T$T���%xj$�\0W�H`�\0K�V��J�@p.bPh`�DP���]\n��D`�,���p�+�@6�o�V�tX+(Fa\0�X��X�S��^�L(|~�h�����.8J�,�X�H��tn\ru�t�shT!q�����[i5X#r>�vp|\0E�qW��_��dNNiUI�]$��yA��T�	nЩ�o��l�nЍ�@�?+\0,��2k�a�vIX�I�_S(�x�S����ū6H�[�&��S�\'��0\05i���_��a\r]��LP�Q0ꝅ?��ށ��(l5��Dھ�0��x��\Z�ua�c�^�Wy�hO���4T>�yq����E�~ !����-�	�׮�9^zNNz-�Wbꉨ�i�7Q��*�3��(�n�`x��%�> �(��c@68{H �o#�4r�ʓ�+�1Oo�63ȳI\0_�\"�\"4OM�]}1�)+V���Tٰe�!3֫V�[�z�	�,_��I�HU�U�f��d��#G���5�\'П�&a�B�$�2U�j��Q+u�\"Y�j��yZ�r���+ت�L��H��v�9j�@J?���姶]ZS�ְZ�w�+W�&v1�!����Nz�IW&�c̮�ህ\nkE�вU	�LY @��*��Z�(�FjJUp��y���T�$�q#Ɋ4j�&=��DI�DfzR��z���\n���*_�\\MJ�R#D\nSMZ����U�=�\n�T���*68��2�0�3�-�#҂�S�,� �|-��M6AB;UP�SPAeR3��\r��=��T�eUW1�8cV��#�;�H���0bO?��H�L�<x��\n+���Fbk@���+�M�cC�4�d�U��eW��g��2�/�lR�i���K)��vW$W�����HBKUn(��!���G~��qƑ��P`!��X�o�Lb�$��*eBr�_~!�FD���H/��	\"���J+��c\n4�\Z�<1.{P�\n$����(ð��&�dbL-$%��1���`J��䈅.�X�MEM�Sc_R&TQHAb��M��b$.��V4��U<��c�8�ӏ=|p�^�D�EGE҈ �\0�$`��R�Pfv�!�y9������g�y��(��f��������)��B�!mp�J5�Lb�*��r!� ��$n��.�Y�;H����)Ֆj**_ޕz�Ɠ�a�)̱�F ��� ��\nE���<�<k+��\"J(�l�,&�P���Ƅ�`1�,̶�b�\n���#.c!���M����-�K�W���U#�p3�=r���\"m��\"�8R����A��O�ה��)2�Y\Z��Ɛq��Pc�<�f�8�!)��&j.炋���VZ���\Z�A��4� I�P��!�`��$Q���*oSnU���首�uFյRumb�q$�P�3x�m���T�P�\r�0���	e�B�E,4�	a�1�	���M�l�I��`\"ehhr]*�BDui�����f:�a%t^�\n*ȱ�E�#u�C$؀\n\\�c�P� N��opf3��y3��ŋ�HL��e�C)S`�D��|f�c� �M�f���]��6�H�I԰�&3�`�����0�T�	b�&��)�a-k��M��p\r\\��\'�R��\r�\0�\Z��U|����Deh��Q�B�(�$�&�X#Y��	���k]����a�fXC�t�\\�k�Q2�.:^T����u�q���H\"<��D>D���W)�����y^�e\\!%1Z�d����Tu���3k0��A�)�9�y��y�cWW�BJANP�^qE,:�\n�t�hE.\n�E`2���Z��?7��XO�])O�\r�!�`�D�\nD�B\r��F+��I�6a!�1�X�b�E1�3�k|���Ö|+\\�\\��r��l�Ks)���DG���t\\�#R�r�M�\Z�R��_�b�+����n0���J漒ް\\7lf����\nz�YYC�x��I4W��$�F�2}�\r��\'�Ll��p�����4Y��o���]��k__D|���4��PъG��Mم)Z�] ���+\n�Y`cV�jD�P��*���A+h�u&4��ʕ�sUs���=\'׮1+U�<Q$ }�JՊ�,c�q�b�G�P��l�aZOTyd����6#bB|�4�Q�.t1�?��\njh�\'9V�6��J\'��)٦�N2$�c�����̔p��I�bh%���r@�O1G���Q�2�*F�CCYb��5c��E2Ի�Z��@���&���hJ�g�Lǰ��Hh�)�dQ�E�8+1ʂ#Ρ`�$\0\Z\ZU�����pi��c��<譡�n�,�4GϦ�4�@Mj�g���\n6۔���]��V��!�w�C\0C��e���% \0���o3�\n�JB:���.�����\"7\"�t�s�x�4X�]2i������S�\0<1�W@�HF30�签W����*T��r�L��h�6�V�&b��EiKӫ9y�;�`G�X�	�b4��L�JV*��8�&B����5��T���L���S)x�\0y�22��LqQ�>P�W�ŲyӋ^��ؖ�JK���FA���Ny�K��:U�Dؠ�G�m�*`�8���)1	V\\���$��Q̂�0�z��X |� 4��_Dwy�s\'�l�����/b���t�$���ǰ�L��Qd�FfFΠl�6q�.�zY��3��(c:��\nlhE���tK����+���W��N��Mְ�ۭ\'�ܖ�t�W*����hW�����h��|��y�b���1x!�>����,C,l��*X�����é��/P��DE�	Ѥ}�Uܕ<dA$8C�?I�f��b���\\w��(lB+x�͑����?���V�	iIAX�\r�B��1�L�B+��Bq��o�[H�sH�L�.d�u$X�LB�%*�u \"�A\"�]\" AO Bъ�14E&h,���A)��$p-X�+��/��( ���(����V\\a-8̄����K���CQd-}��T�K�Y�~�V\\>�C=�ƃ#���`�Ʀȃ$hʕ|�fD� (�~�\\�����\"g��(ā��8T��\\�gX\n5��:���@�+��\Z$ۥB�4�qT��`��]�LY�!�����_�#���8����#@B+|�i��\0��*�B ���\n&@CC-�B2L(,�-�B\0fU�B1��4��ʗ@T\"MI�H\'�CP`AL�!?~��7��S�)��Mn�Y�*��+V��d��:lE�|�?�b,��Ǡ�ʝ	�^� ��C�$`�:H�<HFdH��f�D��A������)�=����o��mP\r�����_�M\0��$��iH���,�C7�(|���&P�4L�(h�FNC1�B�(b9�I�B�D��@�K^�\n\Z~���j��.R4�K��<ŊԤ\\�$*X�d\'��38ëe	.�V<V��XB�`R6e�����q�X��Z��4�C+@��Ccx�\"���A�B �LZ�A�cG�i�K��+Х�`��D���R��R_N8|í�B6h6��2�2ɂD�\"�F�/�4 K�3`$g&Hd�F�����u�#�P�%Zj��QD-ђ��:<����M�U\\=dA=��p`�\'�X��)H�\" ���`�U��:��r�X��Q�)a��j��;|�A�G�^�5z���E�\rGU����Z��-Y�9pm[]��}F~�$p	fA�:����F�h<����\0�&�-��(D�&p�,`1�1Ԃ�y()�&D�(,��f�P�M�L�=�hR����9pNm^ �ƪNr�>�hsVȔ `�a8� �E)\0B��l̗<)��1B��2Nj�BDI�CPF�|�dL�#��a�x��\r�A)d!�%@!�n_}W���P�+���Ϋ����z�B���.�3��fj�&�TY�4�3x�G3�R%�,$bՂ�u��B�`��B*������d��cl�j(�B�����,��fǬ�\n�a�\nf4�(�B)��/<0��$4)о�s�B΁Xg}����.�Y0Tm\n�X�#p�\",�$���&�B �A���1�¶G��g$�ſ�Î\\!N�<�s�%���`+�`c��@�zC,�\"2(H�B,�f30C�΂(Xf(�(4�!H�Ez�4��V��Qx�I��>����x�O��ɲ���(ˮ,>�T��\n\'ؘ	!lB)�B�Te!���t͔.ԛ��MV�eHd�9@B\\�y�R�B����>aV�[V��AAt�\\Ʃ�m`�%f�������.�B�B1�X.�1n-�R1x�n.<h(�\"��Yj\0Z.F�Ve��6^+��~�.Ȧ(P4���۴Kũ�뾮<x�$�,������,��4bO��Q��4+!De�\\�\"Dˍ*��F�#��+���dO)��Y�)9�e�Y[�@���c����O����@��2x�.|�5�.nςd�&���$�%x��1n3\"_d�6�F� �W+�;�E���,P@��L��)L~�Ņ0֭���n��0�)c���� �ɭb���Z�-�J)��XҶ�,q�IǬ`UlҹA@C/���-)T��Q\rn�/G��/�z�]^1��	�a�LX\'�B�B.��G��NõP�\ZC1��,��,�,���S.Vi臂�v*9�VP�����\"�?*�1r\\9r��Vp\n���$�*+�L�N\'m<L(������g�Qʸ	�]O��%�6呂�AS4�(�A�d��]J�f0ç4����e\n&�r�*63Ø.ă6d�`fHh�0��0�B�:�0�(Ԃ(�2p(��\"r(TSlŞaU�\\�T��?�;H�}��`��L�*:LW#�k����gs�H�0�2F!4t���\0%y�4\Z�?��O���6��ԚBWFߘx�\'Ɂ0*4[�\r���չ�gR(��b\n�/��4Nk�p����2dC�ZfV�,��(C(�Sb(��2�B��14l�\r�9��E6�Vcl�-*��\"¹�#i�)*�B �?;B��{���\\�\\o_]o�H�lA]L`�y��$��A=��T�#T�X LQY�G�E0؄c[�$�td���Df׉\"�\Z�tS[h[�����/q�j�P��.<�kw�7��-X�mg�mo�2e$T��25/4C(�3r�3#Vns;wmg*t��@V/L�OP�i��X.\0B��B�l���x�wyk�K9rW4��c��wa�e�`��蓬E��yF�����\"q��\\+E�r���-@4d��&/c�q\0��^�Z���eD\'�)�^<UO{�&��5�����7�0T*�N�!�,Ը,��5\\��/�( �(d�\"*7gfs�;C���Jf��B.l�.��洵T@y��\'X��y�wz���d���Lf	T�VV�s�2\\C1�<ٷ��1�����hÍ,C$<�.�r�d��\'EĀ)����9(�(�`%A��\0z\0��Ԭ+�ԥ&}f����E*�;Tɨ��iL��O��\'ä��TcB-Xz34h\Z�2��,X�9;�3��[��B���3�(i��z%�v{����7�C�{X�g��b���@c�A�-��:��1\0Ct_�\0T�h�5(���_dF~+f��F �ƍ��AH�C��}W�ydX���)��\"�AB�4��ך/��ns=��|1;Y#��;b�z(�=��w9�C<ж��_&��0@��,��+����٧Oz[�r^�7,�����/�<Y�\Zׂ���0�.x�?�TD����W�����uA���}/a\0�\0\\��;�4D�5\\�\0\08,VƜ�\r��i��)�H9��d��$����R��<|�$p�9�=����B/(���9A�9����:�i+P�Hz��U�6�B��ѤI���cǪ�7e��u�Ud1Q���V�VId+��r�r�KX!��B�	g��#u�Jfr�ϝ�fi��̂.����4�W�\\�t�R��ѪG��E�z�lX�a�ܳr�X�k��u�6-ܲg�ʳkW��u�$�z%aB��uM@bk��\r�l0W�֬Ih��\ZV�\nunՊЪA��ʅK\\�Ij$=�+I�#+r&�{ I�3i�ڜ:e�ݸ?�@�e�O)E�ܼ�;�9X{��X�Mv7	��&���m�@D�f����\"eT�kZ<c4�e*isVL�-_�LJ�D���\\v⩧d�Z���aΡ�\'d�!\n���J�*UVъ+�\"ak��H<����RE��\'����0�\\�ıe��1��j�qG��1p63Đ�0�l3�!d�A�S�I�6\\�Ƒ�$��\nu�f+���+��MwL��>v���P�5�sÊ~��\'���\"��^�N ����G b�� �D�y Q�_��$mr	駦`)	���s�\'T�)f�Zx�/�eU�B9iw�ő}����Po:�j���j��}V���R�i�!C� �@)p,�!\0�BXY#IW�\\��B@���@�g�V��G����\nj���y�y��\n>N!GEp1�L���EQ��$!(�D�\04�@�N���΍�\\aE�\Z�l\rJ�pVQ%�:��\ZP��PN��VTCQ�>E�i�ZK⥖�z0\\D�(cv�������ث>�J�z�=�h���E����i�屔j+�o�\0�V\nq�]$+cR�\'��2@LIMS�i�\n�]�+(\Z��+&9dIP��~+�3����8CcB79d��n��	U9�\Z!aRf��Y�=�Q&$k~��V�Lz�?g�O���dM�i�L�^bI�^��\Z��V6��^�ٵ��ί�k����\0w��Fo�pe��0�.%d]��L�1\nM����)N�6D���;΢XA/�#�\nߠ�J�Ѓ��^�AwҘɞ�@��P��w���0���L� �l�\"�h�\n�\ra����Vŏ,�zJ�O|���\0%�p�~n��=%��EU�\"��}�#��R�u�O\"�bb����\Z(�c��u�\ru+`�b� ��Iq��%h\n\\���D0�q,��,��4�Q�X���*rA�E����oы>�P	]rN�`C�]\n�ʝ�z��W��!Bd�$�#����5>�	\'�ĉA#Z�l���\"���~�<� ��#K�؋[+�T1:Z�>8����b$�����5�A�\\���(\"�Ȅ@�]\n�̓��*=Β�d$$�ix�	8�2\n@�W�#��h�o|�&��B	�t��!��\n\n���H6L`J���1�(�u\\af����7�X�z8b��p\Z6�f�/z�%��NĹZ��%�8�7�h���\"���g��wO}�5��)ص�	]�mo\n�_��_��D�8A�Mê�.V1�I\\c\Z�(R	6�jP6���3�@A	���PB@��ީ �L-�n8�B5g��y�!�3���ge���zԡ)����(I����km��{�K�&+�.��X\rE�dђ��oXR)�Z�	W�αs���?���e�U�{��26�WVC��T`!�4\Z�rc�oR�.� �IP���G����k\0�.�G$Pa�?��\0�\"�p&B\nޘjkhC�,;&Ȟȳ��\0q3V�R���f$�p&���\røP�1�ڟ�67V�	��wX`%B[�-��N\r�\"lB�=��]+�O�4��1�{�m��1u�� �X�C0��La�dBS���@�Z��9i�b\Z#�>�q�N��y)�$R�f	K��� m/��;¦<̩�y��*��012R�{L�L�H�`����9�\".xaբ��S@�ꬺYdd�\"��\\�-���[<%ݨ�2�F6��#WV���+5p�\Z�z���BX���{��\0\Z�\"��$*8	fZA\Z��>v�,`�G�~�\n�FN��Q��Iq����4�/q�S��� �5T�Y\0KQ�PF��d,�o�����p��@A��~�����׬{�)��\nbÍ^IG:���:+d�N[����+���T �ʆue[�A�oh�7�i�j�\0�0��\n�ȇ3���j�\n���\"<�~��~�C/��F:���y�_+b�dӜ�̧[az�B�8�><R(b����]��+&M���ɑ�F�B�(�����x���S�n���a���\'�U�\"J�cDi�������*\n}�q��N� ~�\ngT�\n`�	p�E`�xG�����\\�M��)��Fg8Q��4k����$jP)qs8��O,���с8�ƈ����c���Db�tk�k%��ʁ򘬝8O�:�B����n��J��,j�����\"!Rr/3؅I�fzg�(F���e0\"4~��X*�8DT�X!�F�`c�� �H(��*h�$�Ԏ�H�Ѣ�;�/�h�mz��0�<د�>m$�����������$2�\'�O*���\0�h$�bH�\0W��a����Ո���t�9�	���\n��f`F�2��jkgDn:mͼ��X\n���*at���\0҂�a_��СР�~���8����l���	���,��v��dPF����R&�>m��\n��:����a���z&�r�\r{�P�ii\nP�Au�������@�+Ї�\n���F���ƻ�H�A\rZ�3�$��D0����3��fAa��Ua>�F�&�`��V,D\n��$��MB�׮ޤү�c(mdJfe�\r��� ��a��,@�:�\0����r��1�@��$j��\n��$O�+�n������B�D�g�,����I��,��-�m������A\r�F~�F��r��xτ�Na�8�W!4��9(�����,\Z���a���`:��q����M��\nRkc�\"/��ð�-\nb���&\'�`~�L�@���1r�\n�p�>���⫦Hh�2�($pbi�J*Y\"�a�P+�B+������R;}if���\"(.��D��D�c/ۀ��VA��R!��p�/[��f�Р!�I��r`F4��a�!<��\0AP�\Z�MLAt�$šz:�M�\r��9��4���b2�f똾Ce�Ab����A�p3, �a\n)a�\r�S8��)�!2�&��������?2�̬֘��X^�+�&;�S;E\"��Z\0�!�-�a���.�%\04�-)p-5�/�RAƁ�S]*�Q�0�c�\n�fR�*s0;�!�S\r�!@3�΢����\n�A�~�0si�BM��@S�S74�>�\n+-Ć�h�9��f(bFA�!H@\Z; F-@F-�h�����oj��)C�Gy�WxH��-���\n���)/J�����J��4,���h��#t^�`�aQ�g���b<\'�5&�����!���N�!J,<���FL�O�C`�C�`�\n��.��R�\n���*/�a� X���]Gr�R�$;3�\0\rA��C�%G5&�J�N�/pR��!f�p�Vo67cTW{u)�g�\'��>ĉi�5�Ρ*��Yq<�����Z�&��n�K\"\"��Ĵ��\nTZ� �`:��Β<_$/^�\nA$,��\n>���ANa���=�0�r�*��Pa�D���a�<�\0��l��@265Ja|0�cA��6a!\n$�o.��;�� V�5ۀ\"���%frV��f�4g�hF�$h�\'/h�F\'�t�l�ԡ�AI�r��**��؊f�j��6��j�b��G�bf���sb\"$����F�fL��5��`r�bGȡ�2�F�$o�A��R�O~!`��6,�����`��~�!�Bra0s�A$g\0se���2!�@6�\\8��\r��<��uS�\r@�&M�v�bb���AD\0z����0gy�8��V\'�V*�0��A�$\0iˁ*������ؐ卲��,+q��In\"%��|�=p�.��\"a�!���mv\"��N!5DX�A\01�3^o��bǁ2��Ձ����\"�!s�b��\Z`A7�>�\n��4�EXs9w�0BA��$Fa�:�ڰ�}��;F�vR�/l��� �t�����V��J!.���B�8�r\'�Jhn����y������ii�&���f�!,t������j�6��c/��w!@-nh�w!,�����aRi֞3+�Z��y����\04\n�\r����.������\r�3�����\n@�!��[\r��ʔ�ّ-V�\0���R86!b88!�o�3֠j�æ��R�w�;�.�y�\0fVV�x���f�����ל�G*��\0�\Z�����Z�����i~-*�M�a����͸g���@V���V����\"VF_�,�Ap��&a\\�[�k��mW�95<�̮X�̎�a�=��M[.����C��3Xa�PtŤ�	F� �ե#A�\04��Tۑ9�\0�JLa� ��l���8� ���j�X%�:�©�	6�\02 ���A.`\Z�9���Ja�i�!�ٜ�P*�pyn��[�ٺ$�Z�ֺ8����u��Z��9\0@\r����-�[��~~��R�V��A�Z!X�^� ,;]]��ޕ�咢�ABW|�Q[�A�wd��U�r�O��@]:ss\"���!�\'���4���\Z�!��~�;gcnx\r�/Nտ\nt���x\Z�:��T������S��|%2�J����A�i%����?�Yɜ��s+��J\"�<��W����\'ҟ�V`\'�Z�Z!t�\n�C��/\\B�`�mYaj�2;��[�< �)�̧�?�\r*G�\0�,͕ͥ4y�Z\"a���55������ʩ���|\r��\\\"�}m�9�bDK�m-r~x�[�r͗���,��������Ar��N��\ZJ�΁+�ѽ��$���|�pɬ�I��)��Z�y����kr/$�9&r�ӗA������PA�����j�� ԕ��ю�]��-֔1�*���_�.\Z!���\"\0@��<6��U��\ZT�`��ʣ���`\r����ڣ@�gkD4��\"��3��d�w����\\�ѝTa���y��y�X�E@F��-��������:�l���נ��V�����>P�S��8�W0!H|/�Vf�aE�\"!��f\\��O����TA�AV�/,�~�aP��a~�S;��!���+�,�����\0����&[\Z,t�l.K��D~j���:���\ra!��s�#�!\nX�4��&��R<��T�U�>g�t�S����[�!�=\0��w�Ν�\'РA��$��P.�Ĉ�\Z�B*2d�zA3�	W.]�T�B�J]����A�G/�̙4�kڬ9i޼u��M�\'OOW��A�4i���$I�4��V�V%}�**�U��Z�U�U鍐�h�+�N_�\r�̝;{�ڽ�΃{|�-�JշU�Z�\"��=�����>,V���H��գ��79�ę�MU�;��\n�N�O���m�+�yG���P7N%Ai��x[��X×�>g�,�����q��{���{�w�,�_x^�B�\r�O|���a�6v��kX.o�L�TIK/�tS���NM�S�D��Q�@5��S@=U+�x��P�H�/����1[ArO\0�52_��O�|��;x�(�^}��J`���J+�U�� �=�HfYfN^	;��c\0_�l\'Ε��\Z!�ձFl��V�maP؛oQ���!�g�qX��rNb��,#�>�8Ӂ�e��8Д��D���\n9�TW��M��;�X��D��}�s4i�K�����J��3`L�*:	%�e�C�T�L��2�@baPJ�\n.�z��1���0ȹ�2˨���r�1���SO�?y�X�\\V��9�oDb��eg��$PV<����I]����8�fJ.��Jk��Ft|flb���okN�ƛn�)�pK��b�<]>�tϠ١�(x�z�h�՝���J�H��`@ƄB_}���H��I���R=N�\n뫲�fBM	�A�\n!�,3O�B��8�:��!�*3ʅn�3$��r�+`#��s�3��c�:��9���\Z�A��ՙ]�<��{�+�\\6	=Z�6�)���\Z�б0na�zl�e���_�F��i���y�$��c�<�УB>$���y؉C)��Q�ο�M�HZ��73���p�L���r1��K��(3��M?\r��Q�t���ړ<Wȳ�<Qe�u�_/C�VT�B�j��zr5�bn��T4�T(c��ۃ^$�d@��B+8p��ep�X�_�q*$-�^�s>��i��I��<��+�B(��TA6��t(��\n�	:��tN��<^���N ;��ڤ�1�%� �g:`����Yx��H�l �[��p���4\"�G�W4��\"0�c��\"�>���&����$	�eWA��2~1H,�)�E.~�?�1pl�h�7�q\nT����Z֡�\0p�w�\0\\�����`�*.Ǹ�9��OFe(�BH����0�i�D0���(\'\n!CȆ�����X�(�i8W���<fŐ��\n%su�7�򔱌��#Α(���������arc�\ZGzA4c葏@����Aڤu����t!���n�f������Y�{�������R7R�ӊRv��I�<D�����<�g�Yf�p��.��x4n\0���<x�$�`�0�=fp�q(S���&��4�j��؜ᱍ�v�8�S���H&~B:�g3�1<��<��8N�>�CE�<����Z��ڇ�����M�0sEf͑��+r劰�cbх+��VB��X�e���H)Tx�y,�O��hj��C]�w�V$�ȗ<��8��(���I�����_~��]UU�aSH��hvիn��67f\'ID�f�By�p��H:�C�;����o�^뙨�4�u��00��R�o���*���&T����lx��b����2�!����hS2ʊ_,�)n��hQ��HB���)�A�mv�Q��Js��_�=!��%�U�/�Ge!R�w)33��9�!��@��\Z���/�b�)���:6�I���p�(�If7�@��Dp�F4�=Σ+���(t��\n��{*`�[쓟�U7<P�1��.LH@a���IOJ䈳������;%O ԊT��Ck �/PݧLE6N�2��9�\"���<�a��;�eosz�rX�2?�ǽ��l|A��sng��z��^X�G?zh�T��(��\Zn#�2�A���V:}��c)Ȅ��������;�w�Q�T:��CO���^&�	c�B�0�\Z<�IW�}�V(D��i*�oü��*���#)�v�1��\neL\"���ED:	C��֧H�*�q�\\��\n���b��s�+/656�V!H\0E��F.q�z3�f�=.@�z��\nP��<�10T\\k\r�%\n�c;ܴI�����b�+bMge�!A�\nG��S�Ex���,t!��J\n��RxDzVq~\Z�2�.rA*l��$oڪ$+��d~H��$!?	1sW�\\y3Y��\Z�@J���㼓�PW*T�-��#/��GҙUb���+�IZa�G(��PL=��l�d&O��Q[x���2gG$��1\nel��b\'�x��̲�\"XŪ^�c��1�M����v�����x����\n2#3�6h�`��\0Ȑ�q� ��\r�7z�fz�XPtQ� r{Pj&W$V5��r� \Z�{�\0b��$\",Z�j�AQ�02�m{��p���g$�.�3��\0$�\0	�\0mV�\n�	��a-��p�Y�]W@t�pr��{B1�Q�m�wh�5;�#�2k��� oWd&#N�9s_�!��֓F�_�x�Oڰhv*W�\n�P>�G��\Z����z.�:1+�Y���dr��r26�I��:���ʠ���\n��r\" �b�P\"�:P�r#\ZU�.��S&@k ��c��dj�N�T��9���6����^�;�vf�1�g�wx{�1�1	�Pg�@0��Qh�dxp�x�q�y~4�\0*�p�\0�� ���>�@i�����A��\rT�3H������2&�M�=����\n�������0��\n<�[8B�Uh����b���W������΅mj���~XPA�W�V�H�w�^��0;݄��`���k�7Pg�}vF6���iy��=Bs���@��`\'�q.���5��i�He��?D!!(�3dC��)�J#�\r�-$���,�\n�e|��8B9��ql�0t-��8���$�p?����HFC�$��K )	m����m�nb@o��^�5;춇�m�Y���p��@����m���Ɛ�`���\0��w��a��*��*�g�6�Z)?Qa9�Fb�f�5h�H1)�\")2	��\n�u�j%�Y&0��#{!�p�p����\n��O�Л�0\0�P\0�yå/����P�̱�ev@Z5�f;��w�����BAk�1[0w�)���	�Q�N@��P�\06W��F��`�iz�9y��g�O�`w�\r��\r��0��p�-��+�*�{K����H4x��]�Y��c�\"�.�`\"3�b;�\n�`r0N�5�\"���p>�@��)	������	`����0$P�\0�@!T&�Q���i�Y�n�S�R������g1P�P�W�m�E�V�p�A)Ⱎlڦ��|i�y`!\n�@q%HS|\n �9 :q �Y�{�����Y(9@;گ�d2����\rj�����T�С�Z�z�� �� (\n@�!GAQ��p9��}�p�	�`?��\r��W�@�1O��R�Ł1�:	[`twpB�k�v[��i�\nX�:Np�FY�\'��c:)�מv��p�������\n�>���4���f�B���,\"�P�Y+����!�\Z_\Z?:�\"&ˠ\n�p%?I�Lg��U�&A�!����;�y��P�`������6��������0�d7LO	ib�\\i�xH��i�c��t�R�\n�����A��Qy��F)(��\\;�^G栉�>�0��0X�4�rn��C���t���1r��v3�B�za��)��\n���x{\Zd@����K�{��I�^C�l�Y��*砹�b�(�V@�\0m�@��0�>u?˦TO��ճ�8��^{G��ٝ���wqr�Ƃ΀)!��N�\n�dNf��׵njh�sؐ����j�`�{$��V��v�5�h� l���� �fQ{k5]̜R�ǐZ����k@�A� ����y�#�a�Q�+zY��}��N�pT|T�@6`�[�4p�PWp\rV 	*RW��GŅ?э����&����á�gŖ�Ev\"EfeP��ڪ��̣W�¼�3�@�D�iz��8)~V��=�)�\0\nY�\nސ��J	���@[<t[�K�Z�J�^�?G� �#c�K���@��\r�@&&%#�{�.?���烢�N�.A�e�Oa�P�BV�\0A�?PL���A54 �P��Kř���g?K;P!��S�Gۻ��#x��1,�#�V�x͛)���;��g���O���@���ؠ��ʧՌ�ל�6Q��<rI���LQb��c����r�R�J`�\n�B�\n��\"1�\0�.Kw#?I�r8*@ ��	�W��C��r��/	Ыy�P��P!���	�$�Yc��\'v2&������c\'~����#��B3��g�Fy�v�I<)˛��hG�q�A��z\nR�l��`iK]�H�X1s� WSչ�r�ܨ0�!lA�,c�GMA������z�,�[uAB�p|��&�Y@��\n� �s{����\"	�`?��X�\0�� $��P��\0,6�`�����:#˯W���Aa\'�^�MV�\'+��m�@z�W��V��8��YO:>��ŷ�\n�K�)�,�����܌��r�� �%����r�rjb��4�\0�\n,2q#@�\Z�6ޡ1�0�aY_f9����2�W���G%+Ɖ��\0�0��0\\$�O���n�����l/V�en���m��_2��_��VDE^��\r�P�����f��l���F���3�P>1��=�p��؀E����9����Rb\"�;�Ա��=�Э�<�Ԥ����-��(��J#\Z6��[V�[�׷�_�v���{Y��ҝ)�`on5� i�\nW�����|�ȑ�� ����dY�ΪM�P�lN�����˖^�N�X����`��\rh����#�F�(�t_��W؀\rA>�w$P,�۹. ���4��<Ք�!+��K���\"�˞?�H!F�+\0�N�����JF�\"X��:p�s����.>��\'ٰY�	��J�LY�|m�\0��\0���A�@T���\n�\0�sY	��@�Pq�V$X�\'��\nm�1����Օn�~h�g��0�P��g!��o�6=7-�oUy��@�i`04ŰEsq5Oͺ�������\r�?�\Zz��z��N�̾��8rF1Y��Ԃ\\�0�ݑ\n��kU}�LCf%~�\Zc�Ym\0��r�]����q/W�H�\0ť��1	W\0� �?�&��\01�J�+ή�C��0�I��\\�ъB�%Bq�FRF(�|���ƌn^A������%H`���s�ʑ{��=������E�Z����r�\rÖKj&dŬ!C��X�i�N3�-j7]���Z�(��t�蹥�e^\0��$�=xP�$�x\'���\n�$v���<o^�Ċ\r�e�$V�ԤQ5i�\0�XI�H4#���q��j�V�v��޸T�Z�Z�J��{��ᛷ.�����vDQ�<y�Vޓ&	��,X��/��w�\\yWoq����b(/b���;2̸эE+ ��|�dI�y)��s�t�z�\0�(gx̉G\'��\'x���9\n��j���S��*�bDƘd��&dna�cz	k,o�BK�H�i��t���4�ʣH�+�ylHvcG��[�H�$����VI3�&i.�{����D�\'�-���5�d�mrV���#w��\n,�!�V��Ѹ+�S=���|�k�g�\'g�1���\0!g��Ê��3�5:h\"�\"�#�6�ģ�6��(�`)���Aǀw�@�\0ā���;�iB�0\'\n��	�x�iC%0\'��D�e�W�+�\\t��P����q��+�I~T./\"�l2w�}72x\'K��HZieU�U�~	S��i�F\Z1���m�E�D��T��͕6.���{���s�#�G>\'�\"򁁊\Z ��|��\r�G���~XGHy��+ӄZ!��L-\"U>�@B����Y	�����hJ���\0��:�U��;le������*�h���*��J&�[t��s�e�}WQܶ&����B�.����I\"�WJ)#Y7z��GV�s_�՜1Q����1Tơg�qV�x63�YEr�.vE,��\'�y�D�(���rΉG9I�K���B|�4�Iު�U|��g�\Z���}��Y�y6��O�&zO>RM�Ȥ��ɇ�,Zm�F�q��Ǟ����⁎��̀��DG�wH����4����LC\0*�\nW��o��[��ҷ��o�����b8��e�ba Q/V��\r�`�*��|Y�r|\"��5DU|n������\ns<�a�;�\Z�:s�a\r�io\0�F܎w+^q&���P���2vp>��9ǳB<��1t��ؙ$Њ��lh�$\"�%�xJ\"��B�(�U�x�3�@��#�ZVc5���& ���Ə�O\'����\nƇXdC�z�S�ь[4�l�<V��a�B*yK��H���g1x\"�x\n�)I��INJR�؀�G�c�@=�M1��!\"��� .��8�A�\'�nu�Y�\"V���X�\rqʂs��4|��p?�BȰЈ�s��S?z�괃,��W�Y#�Q<��\np��(�\n���!~\n�B�ԑ�i�}�x�$�7�QV�L8��؃���U\'E����L�\0��$n����.���X���ʊ��	uĢ��[*�9¾�.�#�f������le,��m�I��Ü#�\ZDGQVJCr�d�H��t| q�s:�a�a�\"R	W1��ȥ|���C���g��A r�K�%� ��*,L�R���3�>N��|!d!�C7���>Y)K�Mr��0�\Z����c\'?٩���rM����P��G0���s�2t�Ժ�\r+�F���u@B�X����z|�?$��?��<J�/m����5��j�\\�xׄm�ss�f]�j%>�uj�0���T���F;����>���\Z㑏\0���a�t�pG0g/x���q�+��n�=80	��\n��[ʧ?Ҷ\r{�������0�>n`-Kau���\0\03M7���z����agp�(�\n�O�K]�:����Fy��\"P��ňE*�1	��\roe�/}�K�:�LO+L�a,V�{��������,����p��Z%GXX��F��aV����09�����s�`��|�#\"Y�=�Q��\n�����D�	��s�a\0g�CY��2P�}�C�@�B��Q3Jb|����ߊ$�#%Ɉ$\"��@9�2��m[aR�`�$<*�^ �:��\0	�MY�8����T�A%*\\-�=�>%d�jZ���\0-N_�\"�M\Z���̔V0�܋���p�O��s����=,�t����lő��|X���G��]��a��tĺ�ǉ�\0�XD>&��1b���a���Cܮ(�B�ўR�eS�pFɦ|��l����+Lqed#a�$���e�& �?��:`	�$��/�Q|Z!UҤ4�k,4Q��ڭ�O�(�P����*t����&�ʅ��+�t��|�_����&LO`�#�s�\Z���![܈T������q���:��`,b��l,\\������.��A�:�*T^�t(�\n�`�8pl�#�pZx�0�G`��ы(����yȀt�� )x�)s�A�oP�T�t2�}C.�C.��N�~�^)[�w����d��\n(�SpH��1=�Ki��X0�y�e���W�=uh�q1�eÔ Y�$�\r�0��9�\0H��Gp0�k���&j�˟곾�k���Y[�E@�H8��8��	�AQ�Z�c˂�c1��H@k�!� ��h�8�,0��B���:r�����7���Ȃe`�	�ܑ�H�7 �@@6����\",�\\����mA�)���}��4��cAÉs���8�)��05p�������H��$Be�\"�����*!�1��ٯq(�Ȣ*��X�|�1�O�����V��{�!jz�/9����۾x�5G������7���C,��ؽN�����R�P!a�Zg(��)�W�\0G�1��(�q�W���@	+��rt�(h���uXe��n��ZJqP<0s<��\Z\0�\0z�8E9�x�2Yy)���<t��t��H��<�Flp%]��V`�_(�<�IDSt�b\nrG��9ݨ�I\0��ȡ:���&0�&�\ZC|���0����|�~<>@�>��Cwq���=e*<V&�yx�3��0�+��*��XS�Hc#�B�8�{P4���	�6�	�l˶6\0�{S�҅n�FZ��A�L.�����^y�KZ3t�.X��(��.�x��zeh%��A�����0����\"T��+e�����Z4�!ǝ)G���7�B�Ĝϑ�.T��+�ܦ2�H��ȉ{���ZL��*�{L�Z\'tZ�,��,�,MHXϴk�t0xHFк�T(���L���4I�`~p�\\H��O��G�6�X�c�7����Iox%��EZ�EmXNh8�1#32�Q�.aa�qJ��qu���z�p�ٗ����lP���o�_��l �O��O����O8y�(ɗ++h0y��zTPō5��I���H�A>�4D��	�t\"�F��I+����{����H�6��T(�8�G(>P�T\0��96u �+��(e�M�P�C�m8����\"M��<�}��z}Ї���cx���Rc �\n �!3a������s0�\n�\0[I�s�Nu�Wx���A�2O�9��#�eHK�ӛ�l�o�ψTI�zJXH�!G��EL>A�GePI�J�Toꗟ�Ǡk�5Q����0�hU��HH�������TxV,�\n�yh��,�X?���B��F�����̇�e��鷥5�u��s��R�Rpu.���^������8�rh�u��rؗs�����V/��W�����/�\r��őE�@��cC�zzVp������ڦ��w����V�XLe�F ���C�Tȵ�����Y��JFHU��u����T>�JF�զ��1�u4!�ٞ\r��(U��0����ߕ�H���ڦ�����F�m؆R >\0��b�Z8�	u�J�`�9��S*��F��!T�y�[����D��EǃE؅%�)q�0٦#�y��ü\"xAǄ�����\rV#�9�\Zv����@�s@6I��sXѵ@9Q��|�\rc5sp�W\r�fZ�\r>���\"�݋`��x��էˇe-RRܧt��r����}؇��Z��YI\0q0n Gȉ\n���,e��2��4p�܊�XX�[���B�VPǸ�[��[u�6\\�U���c��]�q����swQ���&*0�,�a�5h-v�!I�uȺ=�&��@�G`��\\s�y`>h���`�|!�9U=L&�X�4Md#�C��X�<�T��TVZf֜�e(r��C�	�$��Q�K�	~ �xp%\\��)ٮd��I\nt����v��?�\n��.~ۿ���4β��2���HcA�4wyPV�4��P�� ڡ�Cx�\'��D���%�8�.\n����5��6�cB6H`�c��I(�t(�s�W��s`sh\nVs�S>�ʙu�5��=���$��]c�y��u#�}!�I�M[&E#Ýy�Ht OM��l)g����(��S��C�j���U`8b�<��)�*��5�Jt�K�0HH˭���H�X0�of�Q�0֪�q˻Ž�u_�`��*	,P�4����X�2�\'��]cIr\\�CFh�*�F�UNn�40lE>;�`?tP�1yݫ\\�̰�B�F��S^>p�@���hE����mi�8yx�b�T@q�\Z�@�t[zh�d�a����7����K�~�	�V	7rG��nP�*��O�^�\"\nh��H���S�e�״� `��}D�v��zk����=TFHsd��1�Uh����뻒�1�c7���j�\"�u�\"�� \rsX�\nVP�Ƙ��(H���-Mù�s��\rS��8�l��i��C�P�e����K�q�7(z`Q�6�3\"��^ϝ��H��WڊL�w�n��EY�\0�A<ue�\n���a�z��S�J�!F	��H�3�Mz�� n>ke`��z0��;ߪ�X�Gru�I�������Ъ/��硁���\\�\"���.G��Qb�t�T`�\Z�u���A�`> #+�\n��SV��\n�Gؾ��%u��Ve��W���H\'�e��Mf�it(B���}X�q-��S��7������;�npr���1�Z6S�p�x�7���Ur���XPHpﳫ����}�6QY�5X�y����t�H�Dt�\r>���_w�p������G�t>�	�sL��5�\\d#I�����<�Q�4V�?]\"�sx��g�r��[����iփ!������uH�����(��#�pu��*�L�ы�*H�r�~[W[�v7\nl���CQ���J&$9t�U\ruP�iX*kH�vWv��tX�e�e\'�{�s�Yø\'���ס�?t�G�/G0p�YxHp\'`�D�TIZ��;�c��qU\n����sU0�uXш4���S��}4�W_�!���!�\'��[nEu^d��/Gv���\\V��ׯ��<̈́h�\n&��bXA�6����V��v��쬇҉�\\8^�8�t����p O�O�X����{��{�wj�s4�/Ǹ�(I�x<��D�4|��;>|��	ˤ�\r���l��G\rQq��#F�\Z�������!��\'iޫF��ͻ\"I�:�*W���H��U��8�te�u<��l�s畢W�-27��<g�&��d����EW\Z�*�JyY��+O^ذW�1��R�o�t�VlX�L��e+��[���0\0�@�\n	�a1���/\\�e]��Ջg��9G��;7ϑ#U��SkZ�b�^���r�$V�n���K��T����B�.����M9��+��X�a�JͪA�*^l�ݜ9�)�z��U�Hk���#����s��Q<Ҥ�1R�(U�F�\n�w�<�4��X��dLX���:�0�H+�02m@�S>q8�K���S=4Mr�<(Ď�W�)��s�W^�5VYh�=���J*w��0���M6��J�\0�a�$PX�f@cW��X<�D�*�x��.���̖�|v���b�*�����,���ܶ�/o�2�\0\'q���r	�t���uY��9����]*�yϝ��+~�:�א#U��*�\\Z�#�|\n�<�|��$��L�H��l\rQx�$��SJrH�HL��M\'^��X��TA(5�+�,�����W7��J$@��*oe�\r1��Bd.F�V�;�TY��\Z@e��`����D�N7�!��7�<\"�*i��;��)g,�b�rx���7���p��O���+�<�l�RQ9MJi�����x�<�J�+�`�8#ÏD��}���~�0�G�.��$V�c�H���H�,���W@�\n*�82	�A��O���ҰW�%$����<�д�8Î-79�0b��_�EnV����/���1�I���v�a�%�o�/p���*��z,�l�K+�8�i��\"���)�\n�(�瞼y�\'�6�L2m(O�Ns�1JHu��\\3*|ܜJ99��\n��t�|߆�m��{�JZ<T��g�5�J+T/Ew��L��*l�b�N*ъ&LQ�9�`a�m(�\ZVK���Ueu���V`��H*�#�$�W�AX�U���%]���7�\"��/y�a1�!�l �?<W����1CdR�T�&Jl�2��4�Nb�@Ŧ�M�b6(�B+|�1e�fx�(�vA�\0\r�)�צ�P�r�9h��\"\rl��\Z�5	��qe��$�ģ\n���c*\"3F�l�Y;�V�yD�\\s�JVq��&�8G#�x��<p&K�h���-�FAK�\rv�D�p� ���� \nj�A7.�}�q�P�[�\rlİHF�K1��9�s0��F:ҡ��=X��Z7�e��G�S;�AE�	�Z�b���X�Ob$�q��2�)��[!�7�:V�4lzV��ֆ54h5d��0\":��8�F���Mm���X&��VT�ϪM����g嘣NRb�B�(Z ��B�\r�Y�8Q�2	�5��� &1��S��%�)ԟ2�r�h	/wq!6�1�(e�0V\n�7���8���6qNN��e�k�5lgE�i�(��[�$�o\0g��\"N�E9����)�1�Qj?�q�J\ZjY�@�9��E���HS�G\"��Υ�G���%���I@b?�@�$Q�G0 0A-�DJ7|x�@e�+����ba�R���c�G���I��¬����*6��\0*�+Nk�T�ǜ�K�X�\n�	WdOv�XF]�z1�iL-�F�6�א�1� �S:�2H��l\ZD#�\"n9�z����.{?�,\'Q�9���Ӱ�*�i���9|+��^с�F��6��D#�\n�f�����R؎�� �.�Z������]*A�5�Y\"N9���Q����B�0�E.�1l����x7Ǐ�9C��E/Z�֓����i���*Q\0���<����nO��ML�&de�m!�7�T�bp~�)$lګX�\nX��t\"�5�zTU(�������3%ޟ��0�V��\r�P9�r���-�PGy4�9\ZE\'��_A�Cde��KN���J�&�S�R�;N��Z�\\��]^��g����;zH�*,2�I��΋�p��NI\'\'�q50�GyG}�\ZO\\�πn�����#�]#����nA�Y�EE$�#�M[��L���0�HҠ�\nD-�(�\nI��PO)JC�h�k��k���u�#�w���Į߱����f���\Zf1����<�ɳ�r�q��=���4��e,?��]������x��\0`�ژ�8f�3��_���;k���o�uJ���\'��8� �`��6����	h��3��s��0��m]�g1���øOEbQ�d4��L}ڇjF����<f�?5�b��<Zq�-���9>IB��VyrV�[�cuX���џ�ܥ�(-�G<ꑏy�8�b�U����f�˸�סI4	0T��`��~v��L�ss=�Qֳ��z�*�q�k��/ԉ^�ß���i��������+�+��2��/�\r��8T�V�O�y��UV�<�Jd�	V��DtG�ƪ�\n��\n$T�hD9�#�$D�tG��#��\0�GJ�!_J��s����S]�-�ޥEZ��>����:X�.d[�y_wu��}�\\2��F��;���]�ڡ���]���C:L��h���(����8�8���B\"��Z: �qȃ$DAU�D����XH��D$f�H�,��]�TxŴ\\=�Ʃd}�V�L�Fp��C��ʬ՚G�G��H)�$(��d�z��D�1\"�2��9S=#S�j�$�a[(C��օ����i9,	�ya���š��I����a�HP��[�����5�+d���U!��&b����@��pBT��\'p�((� ��XA!�Q�łh��XEp�`�V���eEp�	,���QE�F*�$0\\�M��*� ���\r\n�԰]�T\r�\\�-�5�q(�Q�lG��6:Sz.hz8�;�W1�Wu�vIکc8��;������_=��5�Ba��10\\��\r8D�#�L@\0\0;','abcd','2011-07-18 19:58:37','abcd','2011-07-18 19:58:37','Y','1');
INSERT INTO `t_da_country` VALUES ('1','中国','CN','System','2010-09-15 18:54:00','System','2010-09-15 18:54:00','Y'), ('2','日本','JP','System','2010-09-15 18:54:25','System','2010-09-15 18:54:25','Y'), ('3','美国','US','System','2010-09-15 18:54:49','System','2010-09-15 18:54:49','Y'), ('4','中国台湾省','TW','System','2010-09-15 19:26:59','System','2010-09-15 19:30:38','Y'), ('5','韩国 ','KP','System','2010-09-15 19:28:33','System','2010-09-15 19:28:33','Y'), ('6','中国香港特区','HK','System','2010-09-15 19:28:50','System','2010-09-15 19:28:50','Y'), ('7','加拿大','CA','System','2010-09-15 19:29:12','System','2010-09-15 19:29:12','Y'), ('8','法国 ','FR','System','2010-09-15 19:29:37','System','2010-09-15 19:29:37','Y'), ('9','荷兰','NL','System','2010-09-15 19:30:14','System','2010-09-15 19:30:14','Y'), ('10','英国 ','UK','System','2010-09-15 19:30:56','System','2010-09-15 19:30:56','Y'), ('11','新加坡','SG','System','2010-09-15 19:31:25','System','2010-09-15 19:31:25','Y'), ('12','德国','DE','System','2010-09-15 19:31:47','System','2010-09-15 19:31:47','Y');
INSERT INTO `t_da_product` VALUES ('1','笔记本','admin','2011-04-30 23:27:56','admin','2011-04-30 23:27:56','Y','1','3'), ('2','平板电脑','admin','2011-04-30 23:28:18','admin','2011-04-30 23:28:24','Y','1','1'), ('3','上网本','admin','2011-04-30 23:29:05','admin','2011-04-30 23:29:05','Y','1','7'), ('4','笔记本包','admin','2011-04-30 23:29:36','admin','2011-04-30 23:29:36','Y','1','3'), ('5','台式机电脑','admin','2011-04-30 23:38:48','admin','2011-04-30 23:38:48','Y','2','1'), ('6','一体电脑','admin','2011-04-30 23:39:25','admin','2011-04-30 23:39:25','Y','2','1'), ('7','瘦客户机','admin','2011-04-30 23:39:43','admin','2011-04-30 23:39:43','Y','2','1'), ('8','手机','admin','2011-04-30 23:39:59','admin','2011-04-30 23:39:59','Y','3','1'), ('9','蓝牙耳机','admin','2011-04-30 23:40:15','admin','2011-04-30 23:40:15','Y','3','1'), ('10','对讲机','admin','2011-04-30 23:40:29','admin','2011-05-18 18:25:22','Y','3','7'), ('11','手机电池','admin','2011-04-30 23:40:44','admin','2011-04-30 23:40:44','Y','3','1'), ('12','手机充电器','admin','2011-04-30 23:40:58','admin','2011-04-30 23:40:58','Y','3','1');
INSERT INTO `t_da_productbrand` VALUES ('1','2','1','admin','2011-05-02 16:04:52','admin','2011-05-02 16:04:52','Y'), ('2','5','1','admin','2011-05-02 16:05:11','admin','2011-05-02 16:05:11','Y'), ('3','6','1','admin','2011-05-02 16:05:25','admin','2011-05-02 16:05:25','Y'), ('4','1','1','admin','2011-05-02 16:05:58','admin','2011-05-02 16:05:58','Y'), ('5','8','1','admin','2011-05-02 16:06:16','admin','2011-05-02 16:06:16','Y'), ('6','3','2','admin','2011-05-02 16:07:25','admin','2011-05-02 16:07:25','Y'), ('7','5','2','admin','2011-05-02 16:07:42','admin','2011-05-02 16:07:42','Y'), ('8','7','2','admin','2011-05-02 16:08:25','admin','2011-05-02 16:08:25','Y'), ('9','8','2','admin','2011-05-02 16:08:51','admin','2011-05-02 16:08:51','Y'), ('10','6','2','admin','2011-05-02 16:10:20','admin','2011-05-02 16:10:20','Y'), ('11','2','3','admin','2011-05-02 16:12:09','admin','2011-05-02 16:12:09','Y'), ('12','5','3','admin','2011-05-02 16:12:41','admin','2011-05-02 16:12:41','Y'), ('13','1','3','admin','2011-05-02 16:14:01','admin','2011-05-02 16:14:01','Y'), ('14','8','3','admin','2011-05-02 16:23:47','admin','2011-05-02 16:23:47','Y'), ('15','6','3','admin','2011-05-02 16:25:01','admin','2011-05-02 16:25:01','Y'), ('16','3','3','admin','2011-05-02 16:27:01','admin','2011-05-02 16:27:01','Y'), ('17','4','3','admin','2011-05-02 16:29:01','admin','2011-05-02 16:43:24','Y'), ('18','7','5','admin','2011-05-02 16:47:18','admin','2011-05-02 16:47:18','Y'), ('19','6','5','admin','2011-05-02 16:48:02','admin','2011-05-02 16:48:02','Y'), ('20','2','5','admin','2011-05-02 16:48:19','admin','2011-05-02 16:48:19','Y'), ('21','1','5','admin','2011-05-02 16:48:52','admin','2011-05-02 16:48:52','Y'), ('22','5','6','admin','2011-05-02 16:56:39','admin','2011-05-02 16:56:39','Y'), ('23','4','6','admin','2011-05-02 16:57:09','admin','2011-05-02 16:57:09','Y'), ('24','3','6','admin','2011-05-02 16:57:39','admin','2011-05-02 16:57:39','Y'), ('25','5','10','admin','2011-05-02 17:06:04','admin','2011-05-02 17:06:04','Y'), ('26','4','10','admin','2011-05-02 17:06:16','admin','2011-05-02 17:06:16','Y'), ('27','5','11','admin','2011-05-02 17:16:25','admin','2011-05-02 17:16:25','Y'), ('28','4','11','admin','2011-05-02 17:16:53','admin','2011-05-02 17:16:53','Y'), ('29','3','11','admin','2011-05-02 17:21:21','admin','2011-05-02 17:21:21','Y'), ('30','8','11','admin','2011-05-02 17:22:10','admin','2011-05-02 17:22:10','Y'), ('31','2','12','admin','2011-05-02 17:25:49','admin','2011-05-02 17:25:49','Y'), ('32','1','12','admin','2011-05-02 17:26:16','admin','2011-05-02 17:26:16','Y'), ('33','5','12','admin','2011-05-02 17:26:39','admin','2011-05-02 17:26:39','Y'), ('34','4','12','admin','2011-05-02 17:27:09','admin','2011-05-02 17:27:09','Y');
INSERT INTO `t_da_province` VALUES ('1','北京市','BJ','System','2010-09-15 18:57:24','System','2010-09-15 18:57:24','Y'), ('2','天津市','TJ','System','2010-09-15 18:57:47','System','2010-09-15 18:57:47','Y'), ('3','上海市','SH','System','2010-09-15 18:58:04','System','2010-09-15 18:58:04','Y'), ('4','重庆市','CQ','System','2010-09-15 18:58:16','System','2010-09-15 18:58:16','Y'), ('5','河北省','HE','System','2010-09-15 18:58:30','System','2010-09-15 19:06:22','Y'), ('6','河南省','HA','System','2010-09-15 18:58:47','System','2010-09-15 19:06:46','Y'), ('7','云南省','YN','System','2010-09-15 18:59:03','System','2010-09-15 18:59:03','Y'), ('8','辽宁省','LN','System','2010-09-15 18:59:17','System','2010-09-15 18:59:17','Y'), ('9','黑龙江省','HL','System','2010-09-15 18:59:35','System','2010-09-15 19:07:13','Y'), ('10','安徽省','AH','System','2010-09-15 19:01:48','System','2010-09-15 19:01:48','Y'), ('11','福建省','FJ','System','2010-09-15 19:02:26','System','2010-09-15 19:02:26','Y'), ('12','甘肃省','GS','System','2010-09-15 19:02:49','System','2010-09-15 19:02:49','Y'), ('13','广东省','GD','System','2010-09-15 19:03:06','System','2010-09-15 19:03:06','Y'), ('14','广西壮族自治区','GX','System','2010-09-15 19:04:34','System','2010-09-15 19:04:34','Y'), ('15','贵州省','GZ','System','2010-09-15 19:05:22','System','2010-09-15 19:05:22','Y'), ('16','海南省','HI','System','2010-09-15 19:05:54','System','2010-09-15 19:05:54','Y'), ('17','湖北省','HB','System','2010-09-15 19:07:32','System','2010-09-15 19:07:32','Y'), ('18','湖南省','HN','System','2010-09-15 19:07:50','System','2010-09-15 19:07:50','Y'), ('19','吉林省','JL','System','2010-09-15 19:08:08','System','2010-09-15 19:08:08','Y'), ('20','江苏省','JS','System','2010-09-15 19:08:27','System','2010-09-15 19:08:27','Y'), ('21','江西省','JX','System','2010-09-15 19:08:45','System','2010-09-15 19:08:45','Y'), ('22','内蒙古自治区','NM','System','2010-09-15 19:09:18','System','2010-09-15 19:09:18','Y'), ('23','宁夏回族自治区','NX','System','2010-09-15 19:10:03','System','2010-09-15 19:10:03','Y'), ('24','青海省','QH','System','2010-09-15 19:10:20','System','2010-09-15 19:10:20','Y'), ('25','山东省','SD','System','2010-09-15 19:10:42','System','2010-09-15 19:10:42','Y'), ('26','山西省','SX','System','2010-09-15 19:10:59','System','2010-09-15 19:10:59','Y'), ('27','陕西省','SN','System','2010-09-15 19:11:34','System','2010-09-15 19:11:34','Y'), ('28','四川省','SC','System','2010-09-15 19:11:58','System','2010-09-15 19:11:58','Y'), ('29','新疆维吾尔族自治区','XJ','System','2010-09-15 19:12:36','System','2010-09-15 19:12:36','Y'), ('30','西藏自治区','XZ','System','2010-09-15 19:13:07','System','2010-09-15 19:13:07','Y');
INSERT INTO `t_da_role` VALUES ('1','系统管理员','具有所有的后台权限','system','2010-01-01 01:01:00','system','2010-01-01 01:01:00','Y'), ('2','超级用户','具有基本数据维护和报表权限','system','2010-01-01 01:01:00','system','2010-01-01 01:01:00','Y'), ('3','一般用户','具有基本数据维护','system','2010-01-01 01:01:00','system','2010-01-01 01:01:00','Y'), ('4','企业会员','企业用户功能','system','2010-01-01 01:01:00','system','2010-01-01 01:01:00','Y'), ('5','个人会员','个人用户功能','system','2010-01-01 01:01:00','system','2010-01-01 01:01:00','Y');
INSERT INTO `t_da_sequence` VALUES ('advertise','1'), ('brand','1'), ('category','7'), ('city','1'), ('comments','1'), ('commodity','2'), ('commodityimage','2'), ('contact','1'), ('country','13'), ('history','1'), ('product','13'), ('productbrand','35'), ('province','31'), ('role','6'), ('sortable','53'), ('sort_order','73'), ('supplier','1'), ('supplierproduct','1'), ('user','3'), ('userrole','2');
INSERT INTO `t_da_sortable` VALUES ('1','1','60','C',NULL), ('2','2','61','C',NULL), ('3','3','62','C',NULL), ('4','4','63','C',NULL), ('5','5','64','C',NULL), ('6','6','59','C',NULL), ('7','1','66','P','1'), ('8','2','65','P','1'), ('9','3','67','P','1'), ('10','4','68','P','1'), ('11','5','11','P','2'), ('12','6','12','P','2'), ('13','7','13','P','2'), ('14','8','14','P','3'), ('15','9','15','P','3'), ('16','10','16','P','3'), ('17','11','17','P','3'), ('18','12','18','P','3'), ('19','2','19','B','7'), ('20','5','20','B','7'), ('21','6','21','B','7'), ('22','1','22','B','7'), ('23','8','23','B','7'), ('24','3','24','B','8'), ('25','5','25','B','8'), ('26','7','26','B','8'), ('27','8','27','B','8'), ('28','6','28','B','8'), ('29','2','29','B','9'), ('30','5','30','B','9'), ('31','1','31','B','9'), ('32','8','32','B','9'), ('33','6','33','B','9'), ('34','3','34','B','9'), ('35','4','35','B','7'), ('36','7','70','B','11'), ('37','6','71','B','11'), ('38','2','72','B','11'), ('39','1','69','B','11'), ('40','5','40','B','12'), ('41','4','41','B','12'), ('42','3','42','B','12'), ('43','5','43','B','16'), ('44','4','44','B','16'), ('45','5','45','B','17'), ('46','4','46','B','17'), ('47','3','47','B','17'), ('48','8','48','B','17'), ('49','2','49','B','18'), ('50','1','50','B','18'), ('51','5','51','B','18'), ('52','4','52','B','18');
INSERT INTO `t_da_user` VALUES ('1','admin','porkin@126.com','admin','2011-08-22 22:09:07','2010-09-15 20:13:55','9','System','2010-09-15 20:13:55','System','2010-09-15 20:13:55','Y'), ('2','abcd','test@125.com','abcd123','2011-07-18 19:55:06','2011-07-18 19:54:57','1','abcd','2011-07-18 19:54:57','abcd','2011-07-18 19:55:33','Y');
INSERT INTO `t_da_userrole` VALUES ('1','1'), ('2','5');
