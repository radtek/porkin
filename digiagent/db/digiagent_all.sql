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
  `ADVERTISE_ID` int(11) NOT NULL COMMENT 'å¹¿å‘Šè¯è¡¨ç³»ç»Ÿä¸»é”®',
  `ADVERTISE_DESCRIPTION` varchar(300) NOT NULL DEFAULT 'NA' COMMENT 'å¹¿å‘Šè¯å†…å®¹',
  `CREATED_BY` varchar(30) DEFAULT NULL COMMENT 'åˆ›å»ºè€…',
  `CREATED_DATE` datetime DEFAULT NULL COMMENT 'åˆ›å»ºæ—¶é—´',
  `LASTUPDATED_BY` varchar(30) DEFAULT NULL COMMENT 'æœ€åæ›´æ–°è€…',
  `LASTUPDATED_DATE` datetime DEFAULT NULL COMMENT 'æœ€åæ›´æ–°æ—¶é—´',
  `ACTIVE_FLAG` char(1) DEFAULT NULL COMMENT 'æ¿€æ´»æ ‡å¿—ä½',
  PRIMARY KEY (`ADVERTISE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='å¹¿å‘Šè¯è¡¨';

-- ----------------------------
--  Table structure for `t_da_brand`
-- ----------------------------
DROP TABLE IF EXISTS `t_da_brand`;
CREATE TABLE `t_da_brand` (
  `BRAND_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'å“ç‰Œç³»ç»Ÿä¸»é”®',
  `BRAND_NAME` varchar(20) NOT NULL COMMENT 'å“ç‰Œä¸­æ–‡å',
  `BRAND_ENGLISH` varchar(20) NOT NULL COMMENT 'å“ç‰Œè‹±æ–‡å',
  `CREATED_BY` varchar(30) NOT NULL COMMENT 'åˆ›å»ºè€…',
  `CREATED_DATE` datetime NOT NULL COMMENT 'åˆ›å»ºæ—¶é—´',
  `LASTUPDATED_BY` varchar(30) NOT NULL COMMENT 'æœ€åæ›´æ–°è€…',
  `LASTUPDATED_DATE` datetime NOT NULL COMMENT 'æœ€åæ›´æ–°æ—¶é—´',
  `ACTIVE_FLAG` char(1) NOT NULL DEFAULT 'N' COMMENT 'æ¿€æ´»æ ‡å¿—ä½',
  `COUNTRY_ID` int(10) unsigned NOT NULL COMMENT 'å›½å®¶ä¿¡æ¯çš„ç³»ç»Ÿä¸»é”®',
  PRIMARY KEY (`BRAND_ID`),
  KEY `COUNTRY_ID` (`COUNTRY_ID`),
  CONSTRAINT `t_da_brand_ibfk_1` FOREIGN KEY (`COUNTRY_ID`) REFERENCES `t_da_country` (`COUNTRY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='å“ç‰Œä¿¡æ¯è¡¨';

-- ----------------------------
--  Table structure for `t_da_category`
-- ----------------------------
DROP TABLE IF EXISTS `t_da_category`;
CREATE TABLE `t_da_category` (
  `CATEGORY_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'äº§å“ç±»åˆ«åç³»ç»Ÿä¸»é”®',
  `CATEGORY_NAME` varchar(20) NOT NULL COMMENT 'äº§å“ç±»åˆ«ä¸­æ–‡å',
  `CREATED_BY` varchar(30) NOT NULL COMMENT 'åˆ›å»ºè€…',
  `CREATED_DATE` datetime NOT NULL COMMENT 'åˆ›å»ºæ—¶é—´',
  `LASTUPDATED_BY` varchar(30) NOT NULL COMMENT 'æœ€åæ›´æ–°è€…',
  `LASTUPDATED_DATE` datetime NOT NULL COMMENT 'æœ€åæ›´æ–°æ—¶é—´',
  `ACTIVE_FLAG` char(1) NOT NULL DEFAULT 'N' COMMENT 'æ¿€æ´»æ ‡å¿—ä½',
  PRIMARY KEY (`CATEGORY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='äº§å“ç±»åˆ«ä¿¡æ¯è¡¨';

-- ----------------------------
--  Table structure for `t_da_city`
-- ----------------------------
DROP TABLE IF EXISTS `t_da_city`;
CREATE TABLE `t_da_city` (
  `CITY_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'åŸå¸‚ç³»ç»Ÿä¸»é”®',
  `CITY_NAME` varchar(20) NOT NULL COMMENT 'åŸå¸‚ä¸­æ–‡å',
  `CITY_ABBREVIATION` varchar(5) DEFAULT NULL COMMENT 'åŸå¸‚ç¼©å†™(å¦‚å¤§è¿,DL)',
  `CREATED_BY` varchar(30) NOT NULL COMMENT 'åˆ›å»ºè€…',
  `CREATED_DATE` datetime NOT NULL COMMENT 'åˆ›å»ºæ—¶é—´',
  `LASTUPDATED_BY` varchar(30) NOT NULL COMMENT 'æœ€åæ›´æ–°è€…',
  `LASTUPDATED_DATE` datetime NOT NULL COMMENT 'æœ€åæ›´æ–°æ—¶é—´',
  `ACTIVE_FLAG` char(1) DEFAULT 'N' COMMENT 'æ¿€æ´»æ ‡å¿—ä½',
  `PROVINCE_ID` int(10) unsigned NOT NULL COMMENT 'çœä»½çš„ç³»ç»Ÿä¸»é”®',
  PRIMARY KEY (`CITY_ID`),
  KEY `PROVINCE_ID` (`PROVINCE_ID`),
  CONSTRAINT `t_da_city_ibfk_1` FOREIGN KEY (`PROVINCE_ID`) REFERENCES `t_da_province` (`PROVINCE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='åŸå¸‚ä¿¡æ¯è¡¨ï¼Œè®°å½•ä¸­åŸå¸‚çš„åŸºæœ¬ä¿¡æ¯ã€‚';

-- ----------------------------
--  Table structure for `t_da_comments`
-- ----------------------------
DROP TABLE IF EXISTS `t_da_comments`;
CREATE TABLE `t_da_comments` (
  `COMMENT_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'å•†å®¶è¯„ä»·çš„ç³»ç»Ÿä¸»é”®',
  `COMMENT_RANK` char(1) NOT NULL COMMENT 'è¯„ä»·ç­‰çº§',
  `COMMENT_CONTENT` varchar(3000) DEFAULT NULL COMMENT 'è¯„ä»·å†…å®¹',
  `COMMENT_STATUS` char(1) NOT NULL DEFAULT 'N' COMMENT 'è¯„ä»·çŠ¶æ€,N:æ— å‘ç¥¨,Y:æœ‰å‘ç¥¨',
  `CREATED_BY` varchar(30) NOT NULL COMMENT 'åˆ›å»ºè€…',
  `CREATED_DATE` datetime NOT NULL COMMENT 'åˆ›å»ºæ—¶é—´',
  `LASTUPDATED_BY` varchar(30) NOT NULL COMMENT 'æœ€åæ›´æ–°è€…',
  `LASTUPDATED_DATE` datetime NOT NULL COMMENT 'æœ€åæ›´æ–°æ—¶é—´',
  `SUPPLIER_ID` int(10) unsigned NOT NULL COMMENT 'ä¾›åº”å•†ç³»ç»Ÿä¸»é”®',
  `USER_ID` int(10) unsigned NOT NULL COMMENT 'ç”¨æˆ·ç³»ç»Ÿä¸»é”®',
  PRIMARY KEY (`COMMENT_ID`),
  KEY `SUPPLIER_ID` (`SUPPLIER_ID`),
  KEY `USER_ID` (`USER_ID`),
  CONSTRAINT `t_da_comments_ibfk_1` FOREIGN KEY (`SUPPLIER_ID`) REFERENCES `t_da_supplier` (`SUPPLIER_ID`),
  CONSTRAINT `t_da_comments_ibfk_2` FOREIGN KEY (`USER_ID`) REFERENCES `t_da_user` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='å•†å®¶è¯„ä»·ä¿¡æ¯';

-- ----------------------------
--  Table structure for `t_da_commodity`
-- ----------------------------
DROP TABLE IF EXISTS `t_da_commodity`;
CREATE TABLE `t_da_commodity` (
  `COMMODITY_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'å•†å“ç³»ç»Ÿä¸»é”®',
  `COMMODITY_NAME` varchar(30) NOT NULL COMMENT 'å•†å“åç§°',
  `COMMODITY_DESCRIPTION` varchar(3000) NOT NULL COMMENT 'å•†å“ä»‹ç»',
  `START_DATE` datetime DEFAULT NULL COMMENT 'æœ‰æ•ˆæœŸå¼€å§‹æ—¶é—´',
  `END_DATE` datetime DEFAULT NULL COMMENT 'æœ‰æ•ˆæœŸç»“æŸæ—¶é—´',
  `COMMODITY_TYPE` char(1) NOT NULL DEFAULT 'P' COMMENT 'å•†å“ç±»å‹(S:äºŒæ‰‹ï¼ŒP:ä¿ƒé”€)',
  `COMMODITY_PRICE` float(10,2) unsigned DEFAULT NULL COMMENT 'å•†å“çš„ä»·æ ¼',
  `USER_ID` int(10) unsigned NOT NULL COMMENT 'ç”¨æˆ·ç³»ç»Ÿä¸»é”®',
  `CREATED_BY` varchar(30) NOT NULL COMMENT 'åˆ›å»ºè€…',
  `CREATED_DATE` datetime NOT NULL COMMENT 'åˆ›å»ºæ—¶é—´',
  `LASTUPDATED_BY` varchar(30) NOT NULL COMMENT 'æœ€åæ›´æ–°è€…',
  `LASTUPDATED_DATE` datetime NOT NULL COMMENT 'æœ€åæ›´æ–°æ—¶é—´',
  `ACTIVE_FLAG` char(1) NOT NULL DEFAULT 'N' COMMENT 'æ¿€æ´»æ ‡å¿—ä½',
  `PRODUCT_ID` int(10) unsigned NOT NULL DEFAULT '1' COMMENT 'äº§å“',
  `COMMODITY_PRICE_OLD` float(10,2) unsigned DEFAULT '0.00' COMMENT 'ä¿ƒé”€é¡µé¢åŸä»·',
  PRIMARY KEY (`COMMODITY_ID`),
  KEY `USER_ID` (`USER_ID`),
  CONSTRAINT `t_da_commodity_ibfk_1` FOREIGN KEY (`USER_ID`) REFERENCES `t_da_user` (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='å•†å“ä¿¡æ¯è¡¨';

-- ----------------------------
--  Table structure for `t_da_commodityimage`
-- ----------------------------
DROP TABLE IF EXISTS `t_da_commodityimage`;
CREATE TABLE `t_da_commodityimage` (
  `COMMODITYIMAGE_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'å•†å“å›¾åƒç³»ç»Ÿä¸»é”®',
  `COMMODITYIMAGE_CONTENT` blob NOT NULL COMMENT 'å•†å“å›¾åƒå†…å®¹',
  `CREATED_BY` varchar(30) DEFAULT NULL COMMENT 'åˆ›å»ºè€…',
  `CREATED_DATE` datetime DEFAULT NULL COMMENT 'åˆ›å»ºæ—¶é—´',
  `LASTUPDATED_BY` varchar(30) DEFAULT NULL COMMENT 'æœ€åæ›´æ–°è€…',
  `LASTUPDATED_DATE` datetime DEFAULT NULL COMMENT 'æœ€åæ›´æ–°æ—¶é—´',
  `ACTIVE_FLAG` char(1) DEFAULT NULL COMMENT 'æ¿€æ´»æ ‡å¿—ä½',
  `COMMODITY_ID` int(10) unsigned NOT NULL COMMENT 'å•†å“ç³»ç»Ÿä¸»é”®',
  PRIMARY KEY (`COMMODITYIMAGE_ID`),
  KEY `COMMODITY_ID` (`COMMODITY_ID`),
  CONSTRAINT `t_da_commodityimage_ibfk_1` FOREIGN KEY (`COMMODITY_ID`) REFERENCES `t_da_commodity` (`COMMODITY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='å•†å“å›¾åƒè¡¨';

-- ----------------------------
--  Table structure for `t_da_contact`
-- ----------------------------
DROP TABLE IF EXISTS `t_da_contact`;
CREATE TABLE `t_da_contact` (
  `CONTACT_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'è”ç³»æ–¹æ³•ç³»ç»Ÿä¸»é”®',
  `CONTACT_CONTENT` varchar(30) NOT NULL COMMENT 'è”ç³»æ–¹å¼å†…å®¹',
  `CONTACT_TYPE` char(1) NOT NULL DEFAULT 'Q' COMMENT 'è”ç³»æ–¹å¼: Q:qq, N:MSN',
  `CREATED_BY` varchar(30) NOT NULL COMMENT 'åˆ›å»ºè€…',
  `CREATED_DATE` datetime NOT NULL COMMENT 'åˆ›å»ºæ—¶é—´',
  `LASTUPDATED_BY` varchar(30) NOT NULL COMMENT 'æœ€åæ›´æ–°è€…',
  `LASTUPDATED_DATE` datetime NOT NULL COMMENT 'æœ€åæ›´æ–°æ—¶é—´',
  `ACTIVE_FLAG` char(1) NOT NULL COMMENT 'æ¿€æ´»æ ‡å¿—ä½',
  `SUPPLIER_ID` int(10) unsigned NOT NULL COMMENT 'ä¾›åº”å•†ç³»ç»Ÿä¸»é”®',
  PRIMARY KEY (`CONTACT_ID`),
  KEY `SUPPLIER_ID` (`SUPPLIER_ID`),
  CONSTRAINT `t_da_contact_ibfk_1` FOREIGN KEY (`SUPPLIER_ID`) REFERENCES `t_da_supplier` (`SUPPLIER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='è”ç³»æ–¹æ³•è¡¨';

-- ----------------------------
--  Table structure for `t_da_country`
-- ----------------------------
DROP TABLE IF EXISTS `t_da_country`;
CREATE TABLE `t_da_country` (
  `COUNTRY_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'å›½å®¶ä¿¡æ¯çš„ç³»ç»Ÿä¸»é”®',
  `COUNTRY_NAME` varchar(30) NOT NULL COMMENT 'å›½å®¶ä¸­æ–‡å',
  `COUNTRY_ABBREVIATION` varchar(5) NOT NULL COMMENT 'å›½å®¶åå­—æ¯ç¼©å†™',
  `CREATED_BY` varchar(30) NOT NULL COMMENT 'åˆ›å»ºè€…',
  `CREATED_DATE` datetime NOT NULL COMMENT 'åˆ›å»ºæ—¶é—´',
  `LASTUPDATED_BY` varchar(30) NOT NULL COMMENT 'æœ€åæ›´æ–°è€…',
  `LASTUPDATED_DATE` datetime NOT NULL COMMENT 'æœ€åæ›´æ–°æ—¶é—´',
  `ACTIVE_FLAG` char(1) NOT NULL DEFAULT 'N' COMMENT 'æ¿€æ´»æ ‡å¿—ä½',
  PRIMARY KEY (`COUNTRY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='å›½å®¶ä¿¡æ¯è¡¨';

-- ----------------------------
--  Table structure for `t_da_history`
-- ----------------------------
DROP TABLE IF EXISTS `t_da_history`;
CREATE TABLE `t_da_history` (
  `HISTORY_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'è®¿é—®å†å²ç³»ç»Ÿä¸»é”®',
  `HISTORY_TYPE` char(1) NOT NULL COMMENT 'è®¿é—®å†…å®¹ç±»å‹(B:å“ç‰Œ,C:å¤§ç±»,P:äº§å“,E:å“ç‰Œäº§å“,S:ä¾›åº”å•†)',
  `HISTORY_TYPEID` int(10) unsigned NOT NULL COMMENT 'æ‰€å¯¹åº”çš„ID,å¦‚äº§å“ID,ä¾›åº”å•†ID',
  `HISTORY_ACCESSDATE` datetime NOT NULL COMMENT 'è®¿é—®æ—¶é—´',
  `HISTORY_FROMIP` varchar(128) NOT NULL DEFAULT '255.255.255.255',
  PRIMARY KEY (`HISTORY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='è®¿é—®å†å²è¡¨';

-- ----------------------------
--  Table structure for `t_da_product`
-- ----------------------------
DROP TABLE IF EXISTS `t_da_product`;
CREATE TABLE `t_da_product` (
  `PRODUCT_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'äº§å“ç³»ç»Ÿä¸»é”®',
  `PRODUCT_NAME` varchar(20) NOT NULL COMMENT 'äº§å“ä¸­æ–‡å',
  `CREATED_BY` varchar(30) NOT NULL COMMENT 'åˆ›å»ºè€…',
  `CREATED_DATE` datetime NOT NULL COMMENT 'åˆ›å»ºæ—¶é—´',
  `LASTUPDATED_BY` varchar(30) NOT NULL COMMENT 'æœ€åæ›´æ–°è€…',
  `LASTUPDATED_DATE` datetime NOT NULL COMMENT 'æœ€åæ›´æ–°æ—¶é—´',
  `ACTIVE_FLAG` char(1) NOT NULL DEFAULT 'N' COMMENT 'æ¿€æ´»æ ‡å¿—ä½',
  `CATEGORY_ID` int(10) unsigned NOT NULL COMMENT 'äº§å“ç±»åˆ«åç³»ç»Ÿä¸»é”®',
  `DISPLAY_TYPE` char(1) NOT NULL DEFAULT '1' COMMENT 'æ˜¾ç¤ºçš„ç±»åˆ«ï¼Œ1:å¯¼è´­, 2:äºŒæ‰‹, 3:å¯¼è´­+äºŒæ‰‹, 4:ä¿ƒé”€, 5:å¯¼è´­+ä¿ƒé”€, 6:äºŒæ‰‹+:ä¿ƒé”€, 7:å¯¼è´­+äºŒæ‰‹+ä¿ƒé”€',
  PRIMARY KEY (`PRODUCT_ID`),
  KEY `CATEGORY_ID` (`CATEGORY_ID`),
  CONSTRAINT `t_da_product_ibfk_1` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `t_da_category` (`CATEGORY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='äº§å“ä¿¡æ¯è¡¨';

-- ----------------------------
--  Table structure for `t_da_productbrand`
-- ----------------------------
DROP TABLE IF EXISTS `t_da_productbrand`;
CREATE TABLE `t_da_productbrand` (
  `PRODUCTBRAND_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'å“ç‰Œäº§å“ç³»ç»Ÿä¸»é”®',
  `BRAND_ID` int(10) unsigned NOT NULL COMMENT 'å“ç‰Œç³»ç»Ÿä¸»é”®',
  `PRODUCT_ID` int(10) unsigned NOT NULL COMMENT 'äº§å“ç³»ç»Ÿä¸»é”®',
  `CREATED_BY` varchar(30) DEFAULT NULL COMMENT 'åˆ›å»ºè€…',
  `CREATED_DATE` datetime DEFAULT NULL COMMENT 'åˆ›å»ºæ—¶é—´',
  `LASTUPDATED_BY` varchar(30) DEFAULT NULL COMMENT 'æœ€åæ›´æ–°è€…',
  `LASTUPDATED_DATE` datetime DEFAULT NULL COMMENT 'æœ€åæ›´æ–°æ—¶é—´',
  `ACTIVE_FLAG` char(1) DEFAULT 'N' COMMENT 'æ¿€æ´»æ ‡å¿—ä½',
  PRIMARY KEY (`PRODUCTBRAND_ID`),
  KEY `BRAND_ID` (`BRAND_ID`),
  KEY `PRODUCT_ID` (`PRODUCT_ID`),
  CONSTRAINT `t_da_productbrand_ibfk_1` FOREIGN KEY (`BRAND_ID`) REFERENCES `t_da_brand` (`BRAND_ID`),
  CONSTRAINT `t_da_productbrand_ibfk_2` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `t_da_product` (`PRODUCT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COMMENT='å“ç‰Œäº§å“å…³ç³»è¡¨';

-- ----------------------------
--  Table structure for `t_da_province`
-- ----------------------------
DROP TABLE IF EXISTS `t_da_province`;
CREATE TABLE `t_da_province` (
  `PROVINCE_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'çœä»½çš„ç³»ç»Ÿä¸»é”®',
  `PROVINCE_NAME` varchar(20) NOT NULL COMMENT 'çœä»½çš„ä¸­æ–‡åç§°ï¼›å¦‚è¾½å®çœç­‰',
  `PROVINCE_ABBREVIATION` varchar(3) NOT NULL COMMENT 'çœä»½çš„å­—æ¯ç¼©å†™,å¦‚è¾½å®çœä¸ºLN,å‡ä¸ºå¤§å†™',
  `CREATED_BY` varchar(30) NOT NULL COMMENT 'åˆ›å»ºè€…',
  `CREATED_DATE` datetime NOT NULL COMMENT 'åˆ›å»ºæ—¶é—´',
  `LASTUPDATED_BY` varchar(30) NOT NULL COMMENT 'æœ€åæ›´æ–°è€…',
  `LASTUPDATED_DATE` datetime NOT NULL COMMENT 'æœ€åæ›´æ–°æ—¶é—´',
  `ACTIVE_FLAG` char(1) NOT NULL DEFAULT 'N' COMMENT 'æ¿€æ´»æ ‡å¿—ä½',
  PRIMARY KEY (`PROVINCE_ID`),
  KEY `IDX_DA_PROVINCE_ID` (`PROVINCE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='çœä»½ä¿¡æ¯è¡¨ï¼Œè®°å½•ä¸­å›½æ¯ä¸ªçœçš„åŸºæœ¬ä¿¡æ¯ã€‚';

-- ----------------------------
--  Table structure for `t_da_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_da_role`;
CREATE TABLE `t_da_role` (
  `ROLE_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'è§’è‰²ç³»ç»Ÿä¸»é”®',
  `ROLE_NAME` varchar(30) NOT NULL COMMENT 'è§’è‰²åç§°',
  `ROLE_DESCRIPTION` varchar(300) NOT NULL COMMENT 'è§’è‰²æè¿°',
  `CREATED_BY` varchar(30) NOT NULL COMMENT 'åˆ›å»ºè€…',
  `CREATED_DATE` datetime NOT NULL COMMENT 'åˆ›å»ºæ—¶é—´',
  `LASTUPDATED_BY` varchar(30) NOT NULL COMMENT 'æœ€åæ›´æ–°è€…',
  `LASTUPDATED_DATE` datetime NOT NULL COMMENT 'æœ€åæ›´æ–°æ—¶é—´',
  `ACTIVE_FLAG` char(1) NOT NULL DEFAULT 'N' COMMENT 'æ¿€æ´»æ ‡å¿—ä½',
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='è§’è‰²ä¿¡æ¯è¡¨';

-- ----------------------------
--  Table structure for `t_da_sequence`
-- ----------------------------
DROP TABLE IF EXISTS `t_da_sequence`;
CREATE TABLE `t_da_sequence` (
  `NAME` varchar(30) NOT NULL COMMENT 'ç³»ç»Ÿä¸»é”®å',
  `NEXTID` int(10) unsigned NOT NULL COMMENT 'ç³»ç»Ÿä¸»é”®å€¼',
  PRIMARY KEY (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ä¸»è¦ç”¨äºç³»ç»Ÿä¸»é”®IDç”Ÿæˆ.';

-- ----------------------------
--  Table structure for `t_da_sortable`
-- ----------------------------
DROP TABLE IF EXISTS `t_da_sortable`;
CREATE TABLE `t_da_sortable` (
  `SORTABLE_ID` int(11) NOT NULL COMMENT 'æ’åºè¡¨ç³»ç»Ÿçš„ä¸»é”®',
  `SORTABLE_KEY` int(11) NOT NULL COMMENT 'éœ€è¦æ’åºçš„è¡¨çš„ç³»ç»Ÿå·¥ä¸»é”®ï¼Œä¸»è¦æ¥æºäºcategory,brand,product',
  `SORTABLE_ORDER` int(11) NOT NULL DEFAULT '0' COMMENT 'æ‰€å¯¹åº”çš„æ’åºä½',
  `SORTABLE_TYPE` char(1) NOT NULL COMMENT 'æ‰€å¯¹åº”çš„æ’åºç±»å‹, Cä¸ºcategory, Bä¸ºBrand, Pä¸ºProduct',
  `PARENT_ID` int(11) DEFAULT NULL COMMENT 'æ’åºè¡¨ç³»ç»Ÿçš„ä¸»é”®',
  PRIMARY KEY (`SORTABLE_ID`),
  KEY `PARENT_ID` (`PARENT_ID`),
  CONSTRAINT `t_da_sortable_ibfk_1` FOREIGN KEY (`PARENT_ID`) REFERENCES `t_da_sortable` (`SORTABLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='æ’åºè¡¨';

-- ----------------------------
--  Table structure for `t_da_supplier`
-- ----------------------------
DROP TABLE IF EXISTS `t_da_supplier`;
CREATE TABLE `t_da_supplier` (
  `SUPPLIER_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ä¾›åº”å•†ç³»ç»Ÿä¸»é”®',
  `SUPPLIER_NAME` varchar(20) NOT NULL COMMENT 'ä¾›åº”å•†åç§°',
  `SUPPLIER_CONTACTNAME` varchar(30) NOT NULL COMMENT 'è”ç³»äºº',
  `SUPPLIER_ZIP` varchar(6) NOT NULL COMMENT 'é‚®æ”¿ç¼–ç ',
  `SUPPLIER_IMAGE` blob NOT NULL COMMENT 'å›¾ç‰‡',
  `SUPPLIER_DESCRIPTION` varchar(3000) NOT NULL COMMENT 'ç®€ä»‹',
  `SUPPLIER_FAX` varchar(30) NOT NULL COMMENT 'ä¼ çœŸ',
  `SUPPLIER_MOBILE` varchar(30) NOT NULL COMMENT 'æ‰‹æœº',
  `SUPPLIER_TELEPHONE` varchar(30) NOT NULL COMMENT 'è”ç³»ç”µè¯',
  `SUPPLIER_ADDRESS` varchar(30) NOT NULL COMMENT 'è”ç³»åœ°å€',
  `SUPPLIER_CERTIFY` blob COMMENT 'å®åè®¤è¯',
  `SUPPLIER_QUALIFY` blob COMMENT 'èµ„è´¨è®¤è¯',
  `SUPPLIER_ACCESS` int(10) unsigned NOT NULL DEFAULT '0',
  `SUPPLIER_SCORE` int(10) unsigned NOT NULL DEFAULT '0',
  `CITY_ID` int(10) unsigned NOT NULL COMMENT 'åŸå¸‚ç³»ç»Ÿä¸»é”®',
  `USER_ID` int(10) unsigned NOT NULL COMMENT 'ç”¨æˆ·ç³»ç»Ÿä¸»é”®',
  `CREATED_BY` varchar(30) NOT NULL COMMENT 'åˆ›å»ºè€…',
  `CREATED_DATE` datetime NOT NULL COMMENT 'åˆ›å»ºæ—¶é—´',
  `LASTUPDATED_BY` varchar(30) NOT NULL COMMENT 'æœ€åæ›´æ–°è€…',
  `LASTUPDATED_DATE` datetime NOT NULL COMMENT 'æœ€åæ›´æ–°æ—¶é—´',
  `ACTIVE_FLAG` char(1) NOT NULL COMMENT 'æ¿€æ´»æ ‡å¿—ä½',
  `SUPPLIER_WEBSITE` varchar(300) DEFAULT NULL COMMENT 'ä¾›åº”å•†å®˜æ–¹ç½‘ç«™',
  PRIMARY KEY (`SUPPLIER_ID`),
  KEY `CITY_ID` (`CITY_ID`),
  KEY `USER_ID` (`USER_ID`),
  CONSTRAINT `t_da_supplier_ibfk_1` FOREIGN KEY (`CITY_ID`) REFERENCES `t_da_city` (`CITY_ID`),
  CONSTRAINT `t_da_supplier_ibfk_2` FOREIGN KEY (`USER_ID`) REFERENCES `t_da_user` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ä»£ç†å•†ä¿¡æ¯ï¼Œæ²¡æœ‰å®Œæˆ.';

-- ----------------------------
--  Table structure for `t_da_supplierproduct`
-- ----------------------------
DROP TABLE IF EXISTS `t_da_supplierproduct`;
CREATE TABLE `t_da_supplierproduct` (
  `SUPPLIER_ID` int(10) unsigned NOT NULL COMMENT 'ä¾›åº”å•†ç³»ç»Ÿä¸»é”®',
  `PRODUCTBRAND_ID` int(10) unsigned NOT NULL COMMENT 'å“ç‰Œäº§å“ç³»ç»Ÿä¸»é”®',
  `CREATE_DATE` date DEFAULT NULL COMMENT 'ä¾›åº”å•†äº§å“ä»£ç†å¼€å§‹æ—¶é—´',
  `START_DATE` date DEFAULT NULL COMMENT 'ä¾›åº”å•†äº§å“ä»£ç†å¼€å§‹æ—¶é—´',
  `END_DATE` date DEFAULT NULL COMMENT 'ä¾›åº”å•†äº§å“ä»£ç†ç»“æŸæ—¶é—´',
  PRIMARY KEY (`SUPPLIER_ID`,`PRODUCTBRAND_ID`),
  KEY `PRODUCTBRAND_ID` (`PRODUCTBRAND_ID`),
  CONSTRAINT `t_da_supplierproduct_ibfk_1` FOREIGN KEY (`PRODUCTBRAND_ID`) REFERENCES `t_da_productbrand` (`PRODUCTBRAND_ID`),
  CONSTRAINT `t_da_supplierproduct_ibfk_2` FOREIGN KEY (`SUPPLIER_ID`) REFERENCES `t_da_supplier` (`SUPPLIER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ä¾›åº”å•†ä¸å“ç‰Œäº§å“å…³ç³»è¡¨';

-- ----------------------------
--  Table structure for `t_da_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_da_user`;
CREATE TABLE `t_da_user` (
  `USER_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ç”¨æˆ·ç³»ç»Ÿä¸»é”®',
  `USER_NAME` varchar(30) NOT NULL COMMENT 'ç”¨æˆ·å',
  `USER_EMAIL` varchar(100) NOT NULL COMMENT 'ç”µå­é‚®ä»¶',
  `USER_PASSWORD` varchar(30) NOT NULL COMMENT 'ç”¨æˆ·å¯†ç ',
  `LASTLOGINTIME` datetime NOT NULL COMMENT 'ä¸Šæ¬¡ç™»å½•æ—¶é—´',
  `REGISTERTIME` datetime NOT NULL COMMENT 'æ³¨å†Œæ—¶é—´',
  `LOGONSUM` int(10) unsigned NOT NULL COMMENT 'ç™»å½•æ¬¡æ•°',
  `CREATED_BY` varchar(30) NOT NULL COMMENT 'åˆ›å»ºè€…',
  `CREATED_DATE` datetime NOT NULL COMMENT 'åˆ›å»ºæ—¶é—´',
  `LASTUPDATED_BY` varchar(30) NOT NULL COMMENT 'æœ€åæ›´æ–°è€…',
  `LASTUPDATED_DATE` datetime NOT NULL COMMENT 'æœ€åæ›´æ–°æ—¶é—´',
  `ACTIVE_FLAG` char(1) NOT NULL DEFAULT 'N' COMMENT 'æ¿€æ´»æ ‡å¿—ä½',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='ç”¨æˆ·ä¿¡æ¯è¡¨';

-- ----------------------------
--  Table structure for `t_da_userrole`
-- ----------------------------
DROP TABLE IF EXISTS `t_da_userrole`;
CREATE TABLE `t_da_userrole` (
  `USER_ID` int(10) unsigned NOT NULL COMMENT 'ç”¨æˆ·ç³»ç»Ÿä¸»é”®',
  `ROLE_ID` int(10) unsigned NOT NULL COMMENT 'è§’è‰²ç³»ç»Ÿä¸»é”®',
  KEY `ROLE_ID` (`ROLE_ID`),
  KEY `USER_ID` (`USER_ID`),
  CONSTRAINT `t_da_userrole_ibfk_1` FOREIGN KEY (`ROLE_ID`) REFERENCES `t_da_role` (`ROLE_ID`),
  CONSTRAINT `t_da_userrole_ibfk_2` FOREIGN KEY (`USER_ID`) REFERENCES `t_da_user` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ç”¨æˆ·å’Œè§’è‰²å…³ç³»è¡¨';

-- ----------------------------
--  Records 
-- ----------------------------
INSERT INTO `t_da_brand` VALUES ('1','æˆ´å°”','DELL','sj','2010-09-15 19:26:33','sj','2010-09-15 19:26:33','Y','3'), ('2','æƒ æ™®','HP','sj','2010-09-15 19:34:31','sj','2010-09-15 19:34:31','Y','3'), ('3','ä¸‰æ˜Ÿ','Samsun','sj','2010-09-15 19:35:22','sj','2010-09-15 19:35:22','Y','5'), ('4','å®ç¢','Acer','sj','2010-09-15 19:37:02','sj','2010-09-15 19:37:02','Y','4'), ('5','åç¡•','ASUS','sj','2010-09-15 19:37:44','sj','2010-09-15 19:37:44','Y','4'), ('6','è”æƒ³','Lenovo','sj','2010-09-15 19:38:33','sj','2010-09-15 19:38:33','Y','1'), ('7','åŒæ–¹','åŒæ–¹','sj','2010-09-15 19:50:30','sj','2010-09-15 19:50:30','Y','1'), ('8','ç´¢å°¼','SONY','sj','2010-09-15 19:53:41','sj','2010-09-15 19:53:41','Y','2');
INSERT INTO `t_da_category` VALUES ('1','ç¬”è®°æœ¬åŠé…ä»¶','admin','2011-04-30 23:21:18','admin','2011-04-30 23:21:18','Y'), ('2','æ•´æœº','admin','2011-04-30 23:21:44','admin','2011-04-30 23:21:44','Y'), ('3','æ‰‹æœºé€šè®¯','admin','2011-04-30 23:22:00','admin','2011-04-30 23:22:00','Y'), ('4','ç…§ç›¸æ‘„åƒ','admin','2011-04-30 23:22:16','admin','2011-04-30 23:22:16','Y'), ('5','è£…æœºé…ä»¶','admin','2011-04-30 23:26:48','admin','2011-04-30 23:26:48','Y'), ('6','æ•°ç ','admin','2011-04-30 23:26:58','admin','2011-04-30 23:26:58','Y');
INSERT INTO `t_da_city` VALUES ('1','å¤§è¿å¸‚','DL','sj','2010-09-15 19:15:39','sj','2010-09-15 19:15:39','Y','8'), ('2','è¾½é˜³å¸‚','SY','sj','2010-09-15 19:16:00','sj','2010-09-15 19:16:00','Y','8');
INSERT INTO `t_da_commodity` VALUES ('1','å¯¹è®²æœº','SA','2011-07-18 00:00:00','2011-07-25 00:00:00','S','111.00','2','abcd','2011-07-18 19:58:36','abcd','2011-07-18 19:58:36','Y','10','11111.00');
INSERT INTO `t_da_commodityimage` VALUES ('1','GIF89a@´\0÷\0\0\0\0\0ÿÿÿŞ³´ôÊËüãäùÎÕÃ¼½Ë›¤°”œ»´¶¼¤¬ğÓİÄ¢®Ï²¾ßÁÍèÊÖüãîË£Í¼Ä¤”œğÚåÄ´¼ÔÄÌäÔÜôâíùìô¹iŸ¶¬´®¤¬ÖÌÔ¥œ¤ÉÄœ”œ”Œ”ÌÄÌüôüìäìÍÇØÛÕç»·ÇôòüÃÂÍìëõ””œœœ¤ããí©¬Ç·ÅæÏ×ÜËåñÂÏÑœ¤¤ëõõôüüáîíÛäß¶Ä»ãìäœ¤œôüôÃÍÁÔİÒÌÔÊìôêâìÜ¾Ğ®ôüìáìÓÔÜÄìôÜôüäÜßÄ””„ììÔœœŒüüäÔÔÄÜÜÌììÜääÔüüìôôäœœ”””ŒÌÌÄÔÔÌüüôôôìììäääÜ²¬”úôÜ¼µœÃ¼¤ÌÄªÔÌ³äÜÃìäÌôìÔÖÅš³¬œûèÀœ”„¤œŒÄ¼¬ÔÌ¼ÜÔÄìäÔäÜÌôìÜüôäüíÓ©š‚ãÔ¼©¤œ¼¬”ìÜÄôäÌ×Ä«ŞÌ³Êµ›º¤ŒÄ­”Ñ¼¤¼´«¬œŒ´¤”¼¬œÄ´¤Ì¼¬ÔÄ´ÜÌ¼äÔÄìÜÌôäÔüìÜ…|œ”Œ¤œ”´¬¤ÌÄ¼Ä¼´ÔÌÄÜÔÌìäÜäÜÔüôìôìäÅ¦Š¶œƒÖ¶›Í¬’¼¤”Ä¬œÌ´¤ÜÄ´ìÔÃüäÔÏ™{õÚË¯’ƒÄ¤”Ì¬œåÊ¼¤”Œ¬œ”´¤œ¼¬¤Ä´¬Ì¼´ÔÄ¼ÜÌÄìÜÔäÔÌôäÜüìä¦ˆzÕ·«Í£“|cZç¹©hJ@Õ©›¸—Œ¼¤œÄ¬¤Ì´¬˜‹‡›qe­“ŒˆvqÜÃ¼ìÓÌüãÜ=%Ä¤œ˜yÌ¬¤·›”ôÛÕÄœ“Ì¤œÕ»µåËÅÊte¾„ÛÕÔí¥›¦‹‡Ü‡øÄ¿Ô¬¨÷²°ŞªªÍ¤¤æ»ºÄ¤¤Ì¬¬·œœ¬””¼¤¤Ä¬¬Ì´´ÜÄÄìÔÔ¤””¬œœ´¤¤¼¬¬Ì¼¼Ä´´ÔÄÄÜÌÌìÜÜäÔÔüììôääœ””¤œœÌÄÄ³¬¬ÔÌÌüôôôìììääãÜÜ¨¤¤üüüôôôìììäääÌÌÌÄÄÄœœœ”””ÿÿÿ!ù\0\0ÿ\0,\0\0\0\0@´\0\0ÿ\0¯HpŞ¤ƒÎ[8 Ag¥HIŒ\rÚ®‹‘ÒHj—Ä]½HõòXªW/?}úúcêÔ¢–‹HµlyÊT©–KEÜFªâ®DI•*q[ÄDHÃ%*¥Hc¢)Svm‹út\nR«5z¬ò($Hõ\"Mº‚Ë$ƒ“Ú°ù\ZI¬$H‘=‚döÊ#Ixºú\nÉU›I®\\t#É½_YµmË¦•c6Œ[yåKyÍâH?R#÷Q«Î]#9^Üx³\ZÎ›W9Zİy•ëÓj\\¯N“F•íÛ·S©aµf\råß¿Y¥{r9Ò*Ü®W=fÃ† $‡JgØĞ¡ÀRFIR$±#Æ‹‘&ÿò(ÑLÈ»@áê£³årL)ºiª%.rİlŞÔFJew‹‰œ·Qw^N8)E\nTVAUUƒ>e‘3Y4âÌbeÍSV$fMÒ•otMB$¨\"W$M’`|ù˜`“VB‰]–Y+a&p¾YFšcŸšd¢©£\\¨™¶š#Åöš“³Õ†nºñ\"pX¦³ÆŠµuÜmÉ-×œuE\'İAÔ‘)1½°7zeõ\"IM/wætRMõ™‚\n*5½dŒL¥hsÊ)İ•\r‚Ğ|Ş£İ!ÅSxÛhÔS2¨iUHıÔH=8’N\\•E#LRãW*N‰#h¬ÿF¡$‘ğÁ$/®Ø_{\r†×aiÕøãc‘MÆ£@n&¤\\D’Mª±d“O¦š#RN™Û#¼aé-$½­Ñe$¿ÜöMr1Ésj^šh¦iİs~ôQgx—UOHÁ©R/·TJ:ms\n.}6âÇ)|(RŸ8¦,Â)Û˜Ò¨N÷ÓO\Z½‰Ô¥Jq$U>52UîòHt5×AdÁõ;2ã*‰«Œ0ÂF‘d…$wE¡—W.îõ×Ï…	İFbã™£k9qì°%	\ZŠ5ö#´œ†í*Ô®[l³iKå‡ßzÛ+]–kÛ¹®¥^x‘iZÑ-Ô.^Œøÿq¯HKéû]Æ#5ºM~dRï)!l ‡ÖÔÈ\"§`Wåáˆã±D½d<^ç$x©É$“~ÕƒSŒŞ Æ»˜BLÊ5‰YeÕ—W«À¨ª#Œ¤Â!…eI{ó‹}	¶ô_2J¢ô^lûtcQOÙg­$ä#XëÈXiÊv-m\Z`›V-”Ùš-Úic¹v[È¡ËdòĞÍîÏQg¿Ş{ë\'”PK}—GvêîT/cøá€3¹IåRÑšT®š»W€<Á­.<\Z¦”Rºv¬t)#…3œaF8ƒ*è¡ª¯´‚/“ÈB‘ŠV8!õ(\ZÑ\\&09^Œÿè&4Ab\\™y\Zf¢÷Mï3§YÖbœÅœ %ÉkàCRlÆ&l•oJ‚Ì•ÒW™-§}`Ã‘ºäÁÆ6^!~¹CÜE¦çH¢$ÓÆ¤4\r pŒs@éC/¶á‘6±	½`ÉLNŠR0\'ú¹Éß„\"•ı$Nâá§2~°*Y„Äº¥d!¡Â….°ğˆ,@Â•‰yˆA…>ÂR³«\ZÁ½ìÅEªjÃ+¢¼ \nKG8²ÑZÔ‡,ÍX­39ÒÚ‰\Z²9\"ŠjDrÄ6mzÑl¶	c$z~kK˜1ºÔØ–6º“~q”#ş\"	ydRQ‰S0Òÿ9ñO\"Á›„²0S Ò‘CELI\\è¤ÚhÅ$b2ñ\\$*¥™É.u)M‘Ìƒ‰è(ê°îÈ…¨0Úâu¤Cf`#Ñ#ªà¸Ü*†X¸B\Za˜´üĞx@DÚŠ–vÄ¦%óGcä‹‘	Åea¯XÓƒ–ø˜›AÂ{°C6ñ‹A¤[àTE­TÎ²œ“8lPgÜÊ\n{¾‘q«<«£&{êÄ1‚Ræ”ğ$¢\Z¤½J¼BÃ¦8\\é\'>Ô‡Ä	…²“D„Ã*F7Õ\r†Ô£-Yê:«©ïH!@©è…1rcxåBla„#\Záª,ÿ0b¬`Cª°@—+¬X?mC3Lù!æˆ—!R½…Äd9{Y{s;#ˆ4TWl‚€Í*öP®‚6a+9ËÊ[µ¥SßĞæZŸæÎö–isl—»üc„#;òH%ñù¨‡úÁ€5…8æXš\0¢r”‹¬N¨“7Ma#QÙF%œAO’B õh(Ÿ2ºïÌ§M·Æ\\X‘zğv/`„*R±\n>ÈáeÆÉiYè·¢àW0ÉQ›×åF&©|i®f›=uMó3_\0D&4Q]U\\|iğj ±\nAˆ5İÌxo#N Å¬ĞŠrÁ-Fn«Û8?yÎËÿX0ÊN(&¿fl¢ûÊ Ob–,ì`©¨ ¸á§—,b€h)Œ¡9‰ì*™ÊdgQçÉkxÒ#ÃˆaŒNãa1Å$(tDH¨a@E\"”ªI8f,d‰_áÓWÉVÓ¥Ì§¬€„Ô”z»íMWH¤‘î#4¾V¨\"¨® ¡	¬b‚Èö²¬\nÚ€57b²\ny+æ&’ùmëTb{İÉ.7¤nn¼‚œ\'‚~m„¿¤¸ïS)6ıÁ( ¸q(?˜¢5qÜ¡nBŠš¢_MÊEO–É‘uÖÂmH/œqŒÂÕÆ0Â¸Š?ĞÃvpÿQL )ªˆ˜B\"\nP°B]~Uë]õêònQ¤DÌ{Ø_ñÍ¯\r\ZM±´9ÍWñcÌaq¸Ãæ MTÛQ¶ƒÑmooYÊ€Œ—ËÂÒãìå×Ô`›äpæ¨í\\7ÛİºÏ“ îœ‡œdŠÌö§@HÑÉ|HÁÎq§80*hr(ÇŞ$Á’üCN´¿z?ˆÂı T&Êgp´¿JF¶m”^ä›`C&pÁB¶´bü‰L1<IÄüİx¡µp¸´!\Z×ˆ<†^q\"ñsà(“è1:fÔ†h\"‚ÀD/,ˆ@l ¨„*\n=h]±Øvÿ×¿úõ°Kd7;Ú+ó„/ÁYê–;ãX¦yáÅñË‡N•o:‘¢!1yƒ’(öÒ¦ğ¶ÒH|À\'©À©Æ\'Ú°€í1ûWBq¥³:ÇQ•Vq·a—  ‡\rÆ€	˜„0¸bá\n.ã!¥ 	´öV ò£{7&\\¸BLt£s;·=ÃW|¿q|šq=É·=PeÔ @\nj€	yà¾Ği àĞ& €	 @	{@X%~VF~Ù¢m1^|eÇN€vi._¢\nq#7‹!ğDj\"?ø\'õ R)uÒx%“Rˆ¥¡Zs\n³x¨ÿÛá€ã0‹0•Ã\r9ñpÈ)ƒy•oJÑ4i›22Xq%Q¸¸ĞŠš°	„ğ¹ ºĞ\n¯àjĞ¤ g@ƒ“s·g?DÃÅ+“àƒtƒlÓk¢1„ÀƒJEÆ6dR„Cj°	¥°ˆ€¾Ğ…p{`ÛØy€	°`™\0\n 0z€mƒ°wm´ñUß¶blğR@Vvjè†Md`>Á^rw‡ĞAW8WmTŠàMQ)áà\ZÑ9tí°\r<1Y”uWÄX\rˆ\n©\0\rh\n| –Ø\'AC± t:Åy’–q¨hWq\râ ÿ·Š¸0ÆP‚@€°‚¦Ğ2Ã?¡Š@ƒ8g1gÂø+:(\\ÃuŒ9VDLÓk=G|Ïtj—lÈ\'ÌSÖwèÑ¥0„0éè}\0\n·€	·\0• Y•UQçU^dÙ’\nù.ÀÁìà•m‡f˜Q‡rW7ò…{õÄFøğá@–	2€GA–ÑáÀ8!q€½p0¥ÀõÁHĞŒt\n¸x\'õá0ãPg”·W™„A4éY3:´‰Š¸yıÑg¬Øi™€eàºD“€q”JPKÙ”O™{ÄøÂõ\nUyA×4YémÀ•àâ•Ô($…iPxÿ…¦pl€\n¬ –€	~P	{	z –€t‰Z‚%z™‘/EgÇ+4 ÿØ>>wì&?‹Ic\nÉF û“ó±\ry/o’(õ£¸PÚĞ’€@F9õpô!ã1Ba–I-yŠ·™¢Qu£§\rÆp%ÙpáĞ’l“0J †!N¹¤9˜i® òc•à2.ÃG|ØITJÅHx„V%P…Ä0¦ÄPÚ°Œ¾pÙ—x0y•p	{–°	ƒàEzz¾ãŸ¿1n¦2 o	í“.Å!ñ3?u¤‡oÿ%	Y91:F\Z1)ö©BÑw§`’\n(”Å0§Ğ€‘šBÁ“6:R1êY´)ŠÉ–•›ı‚Æ&ª¥]píğŒ¸Â“Š \"¯ğ\nÌÙœ3ò¤4bò3<{!.WZ~!lƒ9­\nrá†€Ü°ØA\nÄàˆ°	®À˜ ~@âŠ	™`‚éZ	yğ· L&V›àm«ÁŸZb,ˆ\0¨dgbin#‡o×sˆª˜y¨‡ñF\nxE‘ùT”šˆ¸Û`¨ğ[1‹ÇPh\n©€¨p`Œ…’dÛp ÛÀé9“âñw_7r~ÿS\nù!%2Û Z Ç&Æ 	»Š\nRĞ\nÒ±fg@¬Æº¤Li{É*\\cÍŠâb¥W\n	İ¸µ[«Lfà¾°\n¾Àƒ0Ù$ãĞ\ráÂ ‘à·P¾°Ä\0³0¾@µ@m\n\nyğ{0eĞuec¾lˆÀÿJve\'\"[„Èq°‡*\n»¨÷·n‘™€¸¥ğ˜`\nö±ô6XØš¦€U\n“\n5Ñ`\rÆ©–Êş„›¥QRŠ…¹¼àPØ‘³5™1ÛŠ¹\0—· ´«\0p§…“ğ\n®€´¤°´Jy¬P°½Î)µzá{Éÿ|X[¬àmàmq+è´=l\0¶]¾Ğ\n„ğİ\0â@R\rÂĞ·Ä“P›°·dj»àµĞ·°À\rw·ìÀ{ÙŸZË¸*T*ªâJ°ÔpQ¨Ø–»7Ëfw4•Â‡a*Ñ…·:a‰€ò\'¥\0¨Àæ\0( [ª1|\nãĞ\'‰ ãW/»³µiYR\n~°Šº b‰Â6q :«¦ê˜™Ği¯¨\0·¨°¢*âK¹¤Wğ´¾(Tû{(¶ŒCØÁÖfp%‹+˜qRŒp\n¾Œp³\nÛğÊ`‚  	w\nÄ@Kÿ“a@x ¦Äà¶û¶¾P\n¾\0\n™°¦€¸¨\0>÷h†Á–|!€Z*¦\"¹I¹uH7ë¦¨Ö?°¼n,Å¢§0e› 	0zei/³0‡\n¤©±²| PÚš„õ|R\r·’¹ëx_¼K¬Ù&› Êº~£2+)út™;\Z\nƒ‹€½â±æ¡?CÆnà´K\niœk<ŒmÌc—Ñ%Š± ­ ÒÅ-c¶­@Ü0²’Ç€0µ —üm°w }ˆlÀÂ\0\r`‹ÑcÚ°€x\0³`­°¯ˆ«ÁŒkbe1;¦ÿ<n|A¨V&‡b$—¨‰Ú.±,wzU£¢ø¹Ü<›0e2oY:a€g\n~@9ª°h\n¤ğ\'-Ã|‚²”—²±ÉA‡Û`z²¨ÚÜUİ´	¿°	İüÍ€ Î){¼OÑiVÑgÒwÈ°\n*ğÌ: AÏP`Ïøì”ú¬kS¾xQDÏ\nĞ‹!ĞÏØB|ñv|#Ø:|PÑßp\nËğow`š 	Òg¥€cĞp00Ä ·‘\\\ncj·wÒ¡`”ğÇ·1ÒÂ¯_±aÆg¨7-V…¹Óp\'NiÜK:w®Œw)w|0×9™Ö×MvÀÍı§oT)Ú€™ŒÔ™Œÿ”\nªÃ¨‰š\nDhOM\nÄ«QÒ@Œ²€ÍxÚM„‚ƒ0\nH½	ß(\\¼¤Ø1¸@olRÈ„¹à×]|}t‡}Ï…­ÏûD®Ğ¬5V¥ãÙÆ¤T–ÑÁÉòl æ	¯\0.j –Ê`ĞÀ®Ğ	“€npy@½à³@¦u;0)á¢P	¯è\Z¶aª¡Û_A¾-€Zn8=Üj°m‘ÜN+ÂuÕÜëÆ8kYu€ğ“õ§£ÿ—oKÑw’…P£úº ª@š¨R­@¥ğ6!1÷2U ¼ñmâiMßõ]ß«°÷ÍUİáìPÆÿ+ˆƒS°iª5Õ–åDû×aí\0µd\\ØNéœ	1\\t#¡^TXÛ<¼\Z	_[EŸ	§¡\nèÀnn¤0¤€q·° bpX˜¼Úd\ZÉ”¼· „pUÕ½$üi,Dq&³sÊl!VVævK~Tšns7/8(åëVôİ\ri}NqğçšÀ<ñp\r&yR­ ‹R¨ ²WÌ3áPùš=û¹¾ßßüïŞ¬Öí\\î>èHíÍàìæ8KZQ‚Ú¡\nš «¹ ”®à¤ 	ÂHÆÇjØúLkj,#‰ ¡~µäK|l\\i©L›ñzßü@Ûÿ°·¦PÉ}€¿±@•pxpÂìcêr	µ0˜ãW6½c,½íì»ğÛæÜÙ¦Óshd…ÍFÚ>oæíí5ÔV.0ğ…Pöe?…@Êàû.F¡©€òh\0 ‰\nÊ\nØæÎ|±íÑH	ÚŒÔİ$øİ¼Íİü¿ ß\nÀPÀ\0„°õk­Ê (l_E1Æ\0Æ±`‚™`ù¦`ñ\ZdHÛ(1WnĞñ†-	0(m ò$ï¬ÌĞ¼¶Œ¬\0ì‡êc{„Q¦Å\0šP\nà\'»€…>á¨\0°Àó{€	\"MÉë· \nx+š	\\ÿ×mßÖôÿ		ìPvÏnä*„ä¸¡^bc¨‘õÆ½íuäÓl”XÒY+1öçnö¬`öfƒ2ù!eª”AS¸L™t*•®T|R¥BµÈÔŸS¨Lù)UªÏŸ@ª­ZF¨!”(	Re\'.]”)û5h¡B9sD9jÙ _+céÊ„k[»DI“n#5…”¦Mšna\nµ)¬R’’2³k4RP¬HrãF’´i­@‘ÔµÍ$¸“Ú˜•”H$IQäB‚´f\r_l\"\rfU˜•/D»-fŒÈ×cÈ¾fM®5yò)U©´i,¥XØçZ kUö%\0€ÏÄËëÖ,a°BÙQ•&ÿ#GiTe”/$vì°x[Ëqz¿#íŞ=rÕ*5Z	¤6­<+òä]áŞİ»$íáÅË“TŠ)©DHKt“N¡Âğ×2ä7ş&AÆ<ö1† SNÉ•TNùãƒüøÃ\\Ni¥BØ€6ÑD!\\¦(¥LFe6¹I\'Vr¥eF\n¿¡\0Á¥”p’šb«ÁOcŒ	%–\\úÁj«¤¼K,²^9­{ÔªK‘T\Zi¤É\'a$\r*¤dÄITøĞ²HXéÒ°H\\‘Ë‰ßú\ZŒ\r6Z‰D\r›şÈDAdåTNi…”]A¤b@ñƒ3*±ÃP`›%²Ò„ÿF“Bk1%“P±Ë&C¬±Ä¼ÒtSMƒd9æ{.ºéO-í¼ãN’+ÀO<´äa¤£Ii‡¡Éi\rVê3ÄVÖ0Ä•6\\q¥¯BZ9©“ZFYBQ]ş\0DÁA©•]!qe“Q\ZD‘DÂiç\\tYèAt5¬DfQ´é—M”yémÌEjFôzÑäß\\n1æÃRúñQ+¥ºë,¶ÊJë$Ñz$‘WŠ‹/IØÂK®cyõe•Á+¬K1ÛhCDøZ#dÁZ	ª–LašqQÅ+RHÑ”Pğ¸Pü™XîàÅĞÈˆùLG\\Bƒ“˜oËm7F”‰ÿ¤Lz#Îâã&A.¹åXREÔç¤S3’Sc\rãVYuõÕñ°àˆ”piG@‰BÃ|ıUØa%ÖØbõÖXH(d@r$@D\\6\'C8)Ä•SÒH/½)Î•İ[•Áé]xyZeŞz_ÊÅ”mÌ‚_RüÈÄqVPiä–L°:½DğÜÅR$Ë‡!FK‰DÜ¨¸¸60ÖXû2ÃËÁì¸NÆQÊf„FPQFœp 9E“8\\ÄLQFDj±CP=B‹h>“Ø ¹E“XØfjª`D*zó›¬\rg“˜×à‚œÄ1gld{„tcë¬\rc¬j•vŞÿ·+t„nèbÈMp2!a	Kp„+Våò“­„PF.”ñ‡B9aE,X¢”)Ø\r]új‡8P±¸`ù…WñáÉOFA/A\"\r1z^×;R”È…±GôBwRPDÎĞÓ•]‚xc)‹X¬\0±ˆ)Á,Ë+`“¤„GX©hX… 50±0DY_V²V¨B¦Æ,@¡u(Ã®(;&‰Tø‚¸€Eva_ÔâšxÅ%„QD)M½xLÿŒ!Š@HÍÌIÅ#RÆá(Ğb[ó\Z’Ã\n±MpTÊ:c•vcpƒ›)Œh¶C\n¥XJ$”D%ÿ+p1œÉ˜\'¸Â¢^š°ƒ	wÈ‰XB\rš(¢4ÛÑ¹sÕIãĞ&€ÁŠÙG\')ùÉ 6‘:]œ\"_2ÚJ/ú“‹HäñˆH„|¤ˆ3ô.fè\n)&(”åHpÄ(^–WĞcnàØ\ZšX4ùQYk ä-Ù%—­¢i¾Ø„*–ñ©QĞäĞH£Gˆ\rbü!”›ˆqÊ¤•\0qš2†‘Aà‘9Ê°e\"qUE¸Ã+îƒ;¸š^ú²/¤ 1/˜Aí Óƒlë`xP5Gø!0B{FT%ªìXİäØ\n½ÙWWÌg*²IJNNpâ‰¨<œ±+¼ÿ]™!Ÿ)D\'H1u^…\0Æ‰RäO÷)C¹ÀEŒ;R™8Eá†bEWİ†R„Ô†šIÆC‹GÅÒ6¼âe!é^Xa:Q-£$„X!É”AôÈë¡v1‹ZLoN ƒ<\"!Ómh#~èE`ñS¥ÁL†`Ãd`q(_¨æ3ñ\r¥0nË4¤BjºÉŒ-ˆ…Ix¥œD#øÀãŒ5T¢2u˜9¼´jUÌT›v°Ğº\"…z#„„òª²Ãö7kà‹±ä’=Á‚[)aqb9a‡Q”B\n‘ÀBÚ…×!¥‚`ƒ–!ÈI”L‰ğ:!úùÏ™èÂEÿ:­RR»ZM¨¬±•‚;ÈXŠœQô+mKÃ2†–\0\nÂ}Å!‘blàCâÒÄÙ$Ád!ûò„H˜T¦½¸E-ˆ1v@bé`TOÑùÁ@İE¢ \r<$!~„ Ÿˆ¡Jú&˜À\r#VZú—\0&Î€ça€÷R¬Ìù¥ãàkğ;F&ZB#}%eqj\0¤_TÆ+^%K\r\'¤3_g,\nu–Å„pñ(4‘g\0H¡<¿0«qè¢Áš;Ú0HC¹È6Áû¦øSÄèŠ½S­4¡ŠS°â»ÀŠ\"¦©,›a¢ĞhŞZ†çFˆôW†ğÿ¦ôm[¯¤ŒBiÚ Ë\nD˜Ádh‚Êğ¼†U¨½ÀD-\nÁyÜÁ¹¤ÕF-TÄ$j/ÌpŞL‰òÅ.zš<d\r·‘Z¨Ã©]¼NèSHõqV½²­¢‚êY¬‘¹A·yVj‹Õ9ÄÑ‘v¸n×Nb‰â`AäMŠ›`1^W¸Â`svÙ£Å&r1,\0Ø	ğHÊ¹Ô\0 b­ q\\Šîù\'ÿ´Ê½LÁ»%¥˜@H·ŠF„ƒŒdÄ7W(Ú‹~³Ñ\rnÚ 1¢†xÅ.°—4“¶5Ì9*4Ñ©Á’“öˆ--â—ÅÑşÿĞ0\"âRÌ.TCŒĞ|Fù¥)ÅhN™|?§&¾¡¹…Ò ¨‚z7µ¼%$Xê¸4b\nq1: Áç”íL¿`ÚÔÊÁUá;ÙÁàü³saòaÅs‚6^Kö•øÇÉ„?˜@ø…_\0C8†³[Öã,ec±Q°ƒmxH6\'0\0wp†ëK?øB¸§ßª˜Â29	›\0­X­ÕÁ²&ãöa&°T Ä\n9‚3è…,3~{…Ş*’Œ2„à:„ÒÃb9AğƒV(³WX½%bƒóŠbÚ6Ä¤o1DL A°BC!VP5pc¸´ãCŒÿÏ`¥Ç¾È˜/ÖàûÚ„_Hƒ Şè¾^â%›AT5óK?²QöCcRøk›Îë¼EŒ•EXs‰¦)à¿«÷¡)\">?-Ò…AC<»ú€ä~j;chHp££‡½Seh’(„·` s…ú(QüH2M8cè j²sé-¾\0™i\"#mèAh©.ƒB7ÈÅI0‹²@Â$|!|rƒH IBÃ †hX86ğ’Ç¤½àÂÁèeh…Lè…Q˜EØà6R€¢aCšSÒ¨¯ ¯4†ş©ÅÛíËŒçò>£DAÜ…A,?HX…VKºÿVP‡D<&ëeêù³¿E”‡wàE˜+ÓJ„Aà55he9N¼ˆ‰(AÊœA\n¬´+2”@,;0B #Ë˜H‰k:½¬´ã§y1·)¨R‘+jx ´ˆH(F ‚É3#Ş1ƒV ‹²0\\|‹ìp2Û…ESĞ>À=-‘ƒ]8Ã¸…hØN@“ïò…`ÅØ8¬ËV€‡H LIP…[€z@†fhP8/LƒC:¤/Uº´>€\rbFPGˆªYÚ>ˆÃÅ\0:Mi Š¼HŒLÄêÉÊä´êÈT>€òÙœ•lÉ#1å „(\n„ÿö…²ã¡ú@»ø€ÀxA§_ø†LH—†H¨Nà ›îHÊ]Ô\'µ32 @À™˜¢\\øcÊÓ:—D¸‚±€„S(GÈ\nSH„m0ÆD€U¨FIxC\\$[“.7ØkL½pœKdø”V šfˆ4‰H€F\07•qÁ`@ğ§_Pƒ[hƒGÌXmÀ…Up…Ç„L~LK£¹¤‘¾ÌRĞ\r@HÏMZlHzÈ¥ÄÄj ]hK°¤•õ™êˆDì Uq+×D+í09P„ÜLvxA`œ%J–e3,P!b)¿Ğ	‚àäR	AE2õ–ÿ¸˜V)-Õ	`; X	{Ñ…Æ#ˆÍY·vx‡F¸‹UàƒG˜<L„^ (RĞÆÏû•CpõŒ•i†²®D€‹UàÅ‹²È4X8Z †H4A““XUX„4€5XUˆ„Iˆ¹X“a8…Y°v@…tWX…\\˜[…Çì…üñ36¤Cbh4U*h\rh\05IÉ\rşJß®á¥A”È 5¿!U::“H¤¿ğ¸‚S™Í‘ÔzX„R˜-ĞIƒÓ\\¢ÍRÅÛ–	1±oÛÒzuÃ@Åø031¸ğ8E6\"C‘Ó	\n§l‚°•wšÊz°‚&`„E@zÃªÿmÀ7hÈ…à\Z¸’iÔ±8K(`\'0åù¨kB¼ĞWH™.Y…MX†U˜7c?!HX5XÄ˜‡Xè…/ğ>ÕpŒ@`Ïã:´VˆY`m†[è…FªKC*¼LŞSÜ°ıÍß°$¸°Öˆ$?ÚÖ\n:›³\ZIµWXiÒúCS‡µEO¤°	®#2M,”Ø›”0Îßr,‘ÂÈ¬-¶Âğ‹¿ÂÎ+˜‡î@1‚%²“€ÙeøU-ñÄ…>`Ø¡k¨y’]P|›¦¨<„68„cXÀFø„æÁ‹’„6˜(4Ò”ƒC¸Ò\\ƒ\n‰†PÈÄ7c…•lƒE`(¾pŒzdÿU`…+_ğAÓLh…eèmĞoH‡eHÚ[¸…ØàÇ§%V6L/6„>à9«ŒYğ\n¥<)ğ\nÊÃª]À*ıK°íÖ±5¦$İt¿oµF0ˆq°¥H5¸¦ÍÚ¬B8¿ NˆŸ(;|b +ø6`	ÜÓCœ29k4\\Ãí¤”¡ÍJ‰\\‰(Š	áĞº¤ #=a¨Í5å½ÑûÜŒyhTçIp‚DXƒW Ù…3€·Ğ‹6HH(UP^]9G	9GT\0âŞE„Á@ŒI`âvˆ„XˆvhbÌ…f…¤E†>CPX´]8¥ì½^b ä†ÿAØ/£¥i¥‡¸0õQ¯¥öÒ°5R´­°X‹ßú•ÖIW!:—WKSà]9f)à8#Nze)ìÜEØ½Ø+à(]A¼‚µ–~-sS2\\ğƒ£@—ÊÅ\n%Ph(…S¸ªk<†O(„C –árJjTF((ˆ\ZN‡I¨†A …yLßI ƒ0™6=æÊ]ù®Vàˆ›½·XâO1_h‡ëJ\0¸ğ’I ±bˆBøTÈpohX@†Ğ(†b|42fÃ]9ë…Øà¹OóLşÊ¬‘¶­éÑy(º¯G ÒRyßúóHZ«ßì0ImØ†(EÿGø#Îr±#NW\\ƒA(„Âb±mN6¤%‹9é6-ÜU)ÜìÙNÃè¬“8r³Ó—hLÈ°sa¬8!1…E`„ü\\@#táš78¤&¶ ¿\' aHPf°Æ6 Âˆ[m9Ú]Q}„À5á³À›M¹H˜…H¸G˜„MÈ‚58H(“ø]ˆ„i˜dp\rìZÚE32vÚŸêXx´^À.< >L…ö\Z@d ‚+ƒ>hõ£#-W>¦ß?¶ºŠ&tQ–\n1	fSBø5AiÙ„r2!ná11Ü «05vx­==‹©`.v0|õì~‚¢ÿ„%-œÏÑ\nX@4.›F5™WˆW@j$¤‹^¶XLŸVf(•ËD˜DîVæˆÓ×d¹§8âb8ÇARâ5XŒFˆ_HkDX„I@Z0„Ax‚6è¡XP–o0’»^VÁaeÚZx4ğ^0(şù´U`P³Ñ&!MÓÔãpl/+±½ì³$ËşVí@ZÑì*…–Ø98…ü=—A>e 3òAÌm`6“ş-¿›`Â½íMNÎâ‰,·àÔÒ2eáF—†ÒŠŸ:I\0áBBè–†iØƒN€î!ìå³pêI]Æ!)Ş…h¡ƒsh…@àÛÅp3¿YÿD ]à,ø‚šs†68†Hp.Wh…XVP‡U(0aÀéP8¥l ÑëaàŸªÅèègÄö\r‡ÜZ‰œãpö=hÜ`0÷ıã>¦:‡–ó \"ty„ÎE‹ƒvr ‡~p‡\0pÀû0é óäÀ”NiÛ~SÄÕ×Òñ#CØ¡­i!÷œ2Ú|Zƒ$Xƒ’=j¤†Cè„(ÀT$T³«œ%xj$²\0W€H`„\0K„V¸†Jè@p.bPh`ïDPÇÕå]\n‰„D`„,ø”Äp„+°@6¸oV†tX+(Fa\0…X†©XÚSƒš^ÿL(|~Üh…ª¥¥Ä.8JŸ,°X¬H‹Ïtn\ruàt§shT!q¸ØÏùœ[i5X#r>Ävp|\0E”qWÄá•_­dNNiUIú]$ØåyAÀàT²	nĞ©·oúÂl„nĞ²@Â•?+\0,Øö2kƒaùvIX…I¸_S(½x‡Sø©éÙÅ«6Hï[ê’&„S˜\'°Ä0\05i›™_°óa\r]ø…LP†Q0ê…?ğéŞÑÉ(l5¸DÚ¾ÿ0ïx÷\ZöuaÊc…^è”WyµhO³›—4T>€yqÀ‚ÿÂE—~ !œ–çú-Ä	Ü×®í9^zNNz-İWbê‰¨§iª7Q†*¶3„³(ènƒ`x…˜%ƒ> ®(†c@68{H ‹o#–4rÊ“â+ìƒ1Ooı63È³I\0_¾\"¹\"4OM¤]}1š)+V‘ıÊTÙ°eš!3Ö«V­[·z‰	ä,_¥IãHUšUªf¦‚d“#Gñ¨ìÚ5ï\'ĞŸ“&aÁB$™2U­júèQ+u‘\"Y©jõªyZ·r•‡õ+ØªL•§H‘”ví9j”@J?µ°å§¶]ZS…Ö°ZÃw+Wì&v1¢!À‡ÿNzèIW&ÏcÌ®°áˆ…\nkEˆĞ²U	¤LY @¹È*ºëZí(œFjJUpÖµyõª®T‘$¹q#ÉŠ4jë&=Á¢DI¢DfzRz¢‰\nè—Õ*_»\\MJÅR#D\nSMZõˆĞÔU=š\n©T›ê–Í*68±è2Ì0Æ3Ë-Æ#Ò‚˜SÌ,³ âˆ|-µôM6AB;UPçSPAeR3Íô\r…î=¢Tê„eUW1¾8cV¨ˆ#;îH±£Œ0bO?î¨õHL’<x¹“\n+…ôµFbk@Ø„æ+‰MÙcCı4Ùd’UÖÿeW¶™g 2Ê/›lRši©ıK)¥¼vW$WĞÁ‰“HBKUn(¢Ê!“ôÒG~°áqÆ‘‡…P`!…’Xê†o¯Lb©$··*eBr˜_~!ÂFD®´±H/¤°	\"¾œÒJ+ ¤c\n4îµ¢†\Z€<1.{Pã\n$¾ü¢‰(Ã°¢Œ&±dbL-$%˜ 1˜„ò`Jàääˆ….™XÓMEMÒSc_R&TQHAb¢‰M¹Çb$.ÒãV4¾¨U<§ŒcŠ8öÓ=|p€^¨D’EGEÒˆ ¬\0ã$`‰±R˜Pfvç—!äy9˜¥©•¢gy¶Ì(ƒòfœº¨öÿ‡ÛÜ)…òB‡!mpÂJ5ÕLbÅ*¦Œr!˜ ºÊ$n´â†.·Yé;H§˜‚Ì)Õ–j**_Ş•z˜Æ“¬aÆ)Ì±¡F ”ÒÊ «¢\nE½ğÉ<œ<k+¿Ä\"J(élâ,&ÈP» ‚Æ„â`1Ê,Ì¶İb¨\n¸°#.c!Š˜®MìÎäîŠ-ÚK¯Wö‚ÅU#§p3=räèÎ\"mµ\"¨8R†ƒ¤AëÃOé×”®Œ)2ÉY\Z’±Æqü˜Pc†<²fÀ8ÿ!)¯ü&j.ç‚‹¥„£VZ°µÌ\ZÆA²†4¹ I“PóÊ!˜`’ñ$Qø¥É*oSnU—ÿé¦–ê¿uFÕµRumbŒq$ØPŠ3x†m¼…ÊT¦Pƒ\ró0„ä¸	eˆBéˆE,4‘	aÂ1œ	¯¥‰MŒlÈI·Ò`\"ehhr]*˜BDuiîœƒ—¼f:Ña%t^Ñ\n*È±ˆEØ#uîC$Ø€\n\\ˆcºP† N¡Šopf3éİy3‘ñÅ‹…HLÆÓeC)S` D²Î|fÒc™ ¡Mäf¥èŞ]ª´6ãH‚IÔ°Å&3‰`¼Â€„×0ˆTÂ	b»&óÇ)şa-k’£MşÂŠñp\r\\šÇ\'ˆR´‚\r\0„\ZšËU|ƒÿ´ˆDeh‘QB±(Æ$ş&ŠX#YÃœ	‘Œk]±…¬€a·fXCºtÉ\\Èk£Q2Ç.:^TùœŒîuÄqÒëæH\"<˜ØD>D¢ªĞW)´¡ÓÂy^Ìe\\!%1Z‰d›ùçÄTuÃäİ3k0êÁAÀ)©9…y´£yÈcWWÀBJANPã^qE,:ñ\n¶t‚hE.\n…E`2“‘ªZ¦©?7¼‘XOâ])O‰\r­!¾`ƒD³\nD¬B\r€F+Ò‰IÔ6a!”1‹X´b«E1ü3Œk|±êÃ–|+\\Ô\\ãñrˆ®l®Ks)ÿê‹DG¯°t\\±#RárMì\ZÛR‘Š_übÎ+‘õn0•¹šJæ¼’Ş°\\7lfãØ‡Ñ\nz¢YYCõx½ìI4WğŒ$èFÓ2}¢\ré›Ì\'á›LlÂËp­–á«´4Y³šoü§¿]´‚k__D|í4”‘PÑŠG¨ÁMÙ…)Záˆ] Âó•+\nñ‹Y`cV•jD P°×*†±–A+h’u&4ÜåÊ•ÖsUséèá=\'×®1+Uİ<Q$ }…JÕŠ¦,cŸq’bÅG›Pé±úlÒaZOTydŠãÿ×6#bB|–4¦Q†.t1Ú?òè\njhÅ\'9Vœ6â…J\'¢€)Ù¦âN2$c…–À·›Ì”p¡°I˜bh%¶¡˜r@îO1G¤¢òQƒ2Œ*F˜CCYb±‹5c¼±E2Ô»ÕZÀ‚@ÅàÅ&äûÌhJ¿g…LÇ°™ÍHh)İdQçEà8+1Ê‚#Î¡`·$\0\Z\ZU“¼˜¥Åpi±½cğºø<è­¡šn¬,£4GÏ¦Œ4¿@Mj®g´ìè\n6Û”¹Šó‡]¢VÄ!ĞwˆC\0C†Øe²†›% \0÷ˆÔo3õ\náJB:¯àÃ.Îÿ Ïã\"7\"§tˆs£x¶4XÂ]2iÅÁ†±‚S†\0<1ŠW@¿HF30¢ç­¾WÊøÅâ*TßºrÖLôˆÂh·6…V&b½êEiKÓ«9yÇ;À`Gä“Xß	èb4†ÅL¢JV*£“8£&B¨±²•5¨ÄTœ¦³L€˜S)x\0y¸22‘LqQì>PíW Å²yÓ‹^ìöØ–ªJK¯íFAÙ–’Ny–KÊó€:U¥DØ öGƒm„*`Ñ8´ãğ)1	V\\ã´¸$ ÁQÌ‚É0¦zóœÕX |¬ 4Ãé‘_Dwy˜s\'»lçÿ¸ø®/bŒêñtì$äŒ‘Ç°…LŸ‹Qd™FfFÎ l­6qú.»zYëü3Íõ(c:ñú\nlhE•tKé‚­¨Ô+¢ğ‰W”©NÅÁMÖ°ŞÛ­\'¦Ü–Ät–W*´›ıhW÷ñ«ë‹ÂĞhçÙ|‘ˆy¸b–ø»1x!Â>É¡ÿ‰,C,lÂÃ*X»€‹äÚÃ©æ¬Â/PœŠDE¤	Ñ¤}ŞUÜ•<dA$8Cì?I—fİÜb‘§¼\\wÈÜ(lB+x‰Í‘ÉîùÅ?¥ÉïVÉ	iIAX\r¸BÇ‡1°L‘B+¤ÿBq¸öoÀ[HÁsH‡LÇ.dáu$XŠLBì%*¨u \"˜A\"ä]\" AO BÑŠú14E&h,¨­üA)ÈÃ$p-X‚+ÀÂ/Á‚( Ãàƒ(øßáÁV\\a-8Ì„••¡‰KˆœÌCQd-}»¼TÄKçYš~…V\\>ĞC=ÔÆƒ# à•`ÉÆ¦Èƒ$hÊ•|ÇfDÏ (ƒ~¹\\üĞàêñ\"gàà(ÄÊ‚8T±†\\ÁgX\n5À:„ÉÏ@Á+øÁ\Z$Û¥BÃ4ŠqT…ÿ`µ]ÛLYÍ!‡ş‡›_¤#˜ˆ8¯ÿ·¨#@B+|Ãiø’\0¤Ä* B ‚Úñ\n&@CC-ØB2L(,Â-ÈB\0fU‰B1€Ä4€Ê—@T\"MI¸H\'æCP`AL!?~ƒ™7©ÁS´)¢MnàYÁ*²¢+VÁşdë¹Â:lE•|˜?ùb,øÇ àÊ	ù^µ ŸÌC‚$`Á:HÂ<HFdHÆÂfƒD†øA˜Á¥Œ£Õ)Ù=œ£“ío°ãmP\r¦ÀÑø_„M\0Ï$äÍiHŒéÂ,”C7Ì(|À€Â&PÂ4Lƒ(hÂFNC1ØBñÂƒ(b9âIÔB„Dÿˆ@°K^Á\n\Z~È¤¦j®æ.R4ÅK…<ÅŠÔ¤\\İ$*Xèd\'²¢38Ã«e	.ÆV<V¨‰XB½`R6eØÜêÁãqŠX…ÕZğÉ4ÎC+@ÂŒCcx¥\"¹‚¨AB ‡LZöAˆcGÖiİKÉå+Ğ¥§`Š•D‰”RªœR_N8|Ã­ÅB6h6è‚ø2ƒ2É‚D€\"ÃFŠ/À4 KÉ3`$g&HdÕFÆÂÁ—uÑ#¸På%Zjş„QD-Ñ’‰¤:<…€áæMî¦U\\=dA=€‰p`Å\'†X¢Ì)H\" ÜßÄ`ËUÿÆ:ÌÃrœX¬ÉQï)aµÌj”‚;|—A´G“^Á5z¥¥E½\rGU¬¢ ÂZ‡´-YÖ9pm[]şÖ}F~$p	fAÂ:¤ƒ±œFŒh<œƒşÃ\0ê&à¡-€õ(D¦&p¦,`1ø1Ô‚ÿy()Ã&DÈ(,ƒ•fâPåM†L=¨hR´ÍšÈ9pNm^ ÆªNr¢>ìhsVÈ” `Ôa8Ì  E)\0BôølÌ—<)ª”1Bš‚2Nj BDI£CPF˜|’dLÂ#˜‚axª\rœA)d!±%@!›n_}W§Ôå¥PŸ+ ¡¼Î«¼¾ÿ¡zøB„ø©.¨3 Ãfj‚&ÃTYÂ4Ø3xõG3üR%ƒ,$bÕ‚áu¦ÆB„`ãıB*…‰î×àÃd¤æcl®j(®BŒ¾ª¬®,ŒôfÇ¬Ì\n§a¨\nf4É( B)œÂ/<0ğÓ$4)Ğ¾ÑsºBÎXg}†Êôœ.àY0Tm\n˜XÊ#pÀ\",©$ ‚&¸B Aœ1Â¶G§Äg$ÀÅ¿ôÃ\\!N‡<ÇsØ%¼Æî`+œ`c°ƒ@ô‚ŸzC,¸\"2(HèB,€f30CÂÎ‚(Xf(ˆ(4ƒ!HŞEzè4®¦V§²QxÿIÇà>ÈÃØÃx×O¤ªÉ²‹«Î(Ë®,>äT“\n\'Ø˜	!lB)äB Te!ë‰ÆğtÍ”.Ô›ˆñMVâeHd€9@B\\ÁyÂR¬BÔÉ…­>aVİ[V›ÖAAtÇ\\Æ©Üm`è%f Şú€ú’. B˜B1ÄX.Ô1n-üR1xÂn.<h(Ì\"ÿYj\0Z.FÎVeêæ6^+øÎ~.È¦(P4ÜÍÄÛ´KÅ©ìë¾®<x¬$À,ğæêŞÔÃ,ƒŞ4bOQ‘É4+!Deõ\\©\"DË* ƒF­#¸+ôÁ¡dO)ôÿY¤)9ºeµY[ş@‡ù®c»ÎÔòOŞş¥@ø£2xƒ.| 5¦.nÏ‚d°&€ÄŞ$Ã%xÂá1n3\"_d‡6ˆFğ ÈW+€;°E‰îˆ,P@‚ÊLà‹)L~ğÅ…0Ö­¬¯‘n˜˜0Ì)c¬¿Â ¨É­báëÁZ²-ÑJ)š¬XÒ¶Ì,qæIÇ¬`UlÒ¹A@C/ƒö†-)T’Q\rn„/GŠ›/œzŠ]^1óÔ	úa¬LX\'ÇB B.ñGôÿNÃµPÂ\ZC1ÜÂ,À‚,Ü,ôŸçS.Viè‡‚¨v*î€ƒ9äƒVPÿÁÀ¹Â\"ò?*ò1r\\9r®Vp\n§˜ğ$ä*+ L§N\'m<L(ÿ¤úŠó§gØQÊ¸	Œ]OĞı%Ô6ï¦€éAS4€(œAöd½]JÙf0Ã§4×³»Şe\n&órÉ*63Ã˜.Äƒ6dƒ`fHhÂ0ÌÂ0ğB‚:°0®(Ô‚(Ü2p(Ÿó\"r(TSlÅaUî\\ÀT´ƒ?ä;H }†`¥ÂL´*:LW#§k›˜ÖÁgsÅH—0ğ2F!4tîôü\0%yÜ4\Zå?‰˜O‚6­ÔšBWFß˜xé\'É0*4[\ršÿÇÕ¹ôgR(Á»b\n¢/¦Ü4NkŒp—óõ´2dC„ZfVñ,€‚(C(àSb(€‚2‰BÀ…14l\rÃ9ƒÄE6÷Vcl…-*è¾\"Â¹ô#iø)*èB ¤?;BŒÑ{·è\\Û\\o_]oÅHÇlA]L`óyüñ$ü±A=‰ğT¨#TºX LQY¼GòE0Ø„c[Ê$Ètd ÂDf×‰\"Ã\ZtS[h[ş–÷¢/q‚jÚP´Ã.<Âkw²7ÄÃ-XƒmgÕmoÕ2e$T³×25/4C(„3r›3#Vns;wmg*t‚@V/LÁOP„iÈÿX.\0BŒ¥B£lçÄËx“wykŸK9rW4Ìúcí¹ÁwaÆeø`¶”è“¬EçÎyF³†òö\"q¥¥\\+EÅr›õÁ-@4dï×&/cŸq\0³ø^øZúúÚeD\'³)¡^<UO{ƒ&˜¸5¨¸ŠóÍ7Ã0T*‹Nû!€,Ô¸,ˆ‚5\\µÿ/Ô( °(dÂ\"*7gfsµ;C›ø’Jf÷åB.l·.¨õæ´µT@y”¿\'X ÷y£wz«·¥d¹¦€Lf	T²VV˜sÂ2\\C1Ã<Ù·É1¦ùñêÂhÃ,C$<õ.¶rŒd¤û\'EÄ€)¸ƒÜÿ9(è¹(‚`%A¿”\0z\0èÀÔ¬+¦Ô¥&}f´ïúòE*ì‚;TÉ¨ôãiLƒ‰O¦Š\'Ã¤ş™TcB-Xz34h\Zğ2±—,Xä9;ğ©3°ª[µ†Bèâæ‚3€(i¾ˆz%ùv{·£¡ƒ7©C°{XÀg°Ÿb•‹Ó@cùA§-Úâ:¸Â1\0Ct_ƒ\0TÃhƒ5(ƒó†_dF~+fš“F ¬Æ”‚AH®Cúˆ}WÆydX Â)˜‚\"üABö4Ôû×š/“ãns=ôÃ|1;Y#™à;b±z(Â=àÃw9ŸC<Ğ¶¤ÿ_&ŒĞ0@ƒ©,Ü+ÓÇãÿÙ§Oz[ªr^ä7,àøåºø/µ<Yæ\Z×‚ûàÂ0äº.x¯?ÚTDÂÎÇõWäşöñ¼¬ÚuA¯ƒ–}/a\0Ã\0\\ƒò;ı4D½5\\Ã\0\08,VÆœÜ\r¦¹iüœ)ÜH9Äàdàâ$ˆƒŒÃR°<|‚$p‰9´=¼ç£îB/(‚ƒó9Aû9„ïŞ×:üi+P HzÕÆUÂ6“B‚„Ñ¤I÷äÍcÇªÕ7e±¦u¸Ud1Q¢†•V«VId+‘…rùr˜KX!‹İB™	g¦‘#uŠJfrØÏµfiš–Ì‚.š¢ˆ¡4†W®\\¨t¥R¥ÊÑªGêÔEòzÿlX±a­Ü³ríXµkÁ¢uû6-Ü²gÍÊ³kW’¤uë$¾z%aBÁÇuM@bk¥Æ\r°l0WÇÖ¬Ih¨ò\ZV¬\nunÕŠĞªA›”Ê…K\\êIj$=Ê+IŞ#+r&¥{ IÀ3i¬Úœ:eÊİ¸?¤@íeÊO)E‰Ü¼Î;°9X{ı´XĞMv7	”ä&°«…mÚ@Dµf¡•Š\"eT¦kZ<c4‹e*isVL–-_ÂLJD¹©˜\\vâ©§dê¾Z’©˜aÎ¡é\'d„!\n“¨¦JÅ*UVÑŠ+¯\"ak­·H<‘¬´ÆRE°î’\'¯½ø’0Á\\ùÄ±e®Ù1ÿ±j´qGš1p63ÄË0Ûl3Ï!dAS´IÍ6\\ñÆ‘ç$Ä\nu¨f+°€š+ÄùMwLùãŒ>vÉ“ä¤P‚5ç¼sÃŠ~ª¸\'€êÎ\"è»ì^éN ‚À¬G b’Ê ™D½y Q_ŞÓ$mr	é§¦`)	–ıøsé\'T“)f–Zx©/¤eUğ§’B9iwÂÅ‘}ªšµÑPo:Ìj«®¾j®}V­²ÄR¯i¼!C€ È@)p,˜!\0æ˜BXY#IW’\\²ÉB@ƒ’´@ØgØVæÁG³Ôãë\nj°‘çŠyªyæÿ\n>N!GEp1åLŒ»¥EQÂç$!(ŠD \04Ğ@ÅN»ºÎƒ\\aE†\ZÚl\rJå™pVQ%:àÆ\ZP†—PN½ÕVTCQ>EéiÖZKâ¥–£z0\\D°(cv¦–§†™ÊØ«>ÜJÄz =íh¥µE±ª•äŠi½å±”j+€oÇ\0˜V\nq×]$+cRŞ\'—‘2@LIMS¸iå\n¸]¼ÂŠ+(\ZàŠ+&9dIP„à~+å3 ¦å”8CcB79d´Õn»“	U9¡\Z!aRfšÕYå=Q&$k~ÖïV—Lzé?g¢Oÿ”údMĞi¢LÆ^bIë^Œñ\ZìÇV6³Ó^ÿÙµÏ¯Î¯ık’•íæ\0wÜÑFo¾pe‰0¡.%d]šáLà1\nMéâ‡)N‘6Dâè×;Î¢XA/Ç#\nß ÆJ¥Ğƒ Š^øAwÒ˜É²@ù‹P¸ãw¾˜…0Ä¿ÛLğ álä\"Îhò\n„\ra¥ÒƒVÅ,¥zJã‰O|²½˜\0%pÉ~n±ñ=%¹ĞEUÄ\"ˆ}í‹#ÚìR¹uĞO\"îbb¬à\Z(€cuø\ru+`»b™ ÆëIqÿ%h\n\\œ­ˆD0–q,Ğã,ãÆ4‚Q€X¼“à*rAEˆã©ñoÑ‹>ÀP	]rN­`C‘]\n†Êîz¨W¸!BdÅ$ä—#‚¤Œ†5>•	\'šÄ‰A#Zól“—‹\"©Şõ~µ<• ã¹#KÊØ‹[+T1:Z>8ÎŸùüb$·ú±‚‡5é·A \\ƒÌÑ(\"ÃÈ„@Â]\näÌ“¨Œ*=Î’˜d$$¡ixã	8‹2\n@W¬#„’h„o|³&à˜B	ît¡ë!»¼\n\n¾€íH6L`JâÁÏ1(Äu\\afÎü…ÿ7XŒz8bšØp\Z6fÎ/zÓ%ÔçNÄ¹Zıì%Æ8‡7ÉhÆñá\"˜gˆÒwO}¾5ê)Øµş	]Ômo\nõ_ßó‹_‚ŒD·8Aè‚MÃª .V1I\\c\ZÙ(R	6jP6’€‡3¬@A	şÆâPB@áÂŞ© »L-ín8²B5g‡ŞyÅ!Ä3‰”‘ge¬¨ÈzÔ¡)äâñ(I„”çÄkmŠÏ{ŞK’&+ç.ŠX\rE÷dÑ’²ŠoXR)ÖZí	WïÎ±s­ß?“”eäU{…Ì26ñWVC°T`!4\Z‹rc‚oR£.Ø ‰IP£ëÀGç¬ÿ€k\0Ğ.ó˜G$PaŠ?ã\0\"Îp&B\nŞ˜jkhC¡,;&ÈÈ³ì\0q3V˜Ré‰¥f$úp&‚’å\rÃ¸P„1¬ÚŸ¬67Vê	Çè’wX`%B[É-ÚùN\r¡\"lB‡=İú]+·OÁ4ºÌ1Ş{Œm¡×1uÓÔ €X±C0‘ÒLa¥dBS¼ù€@…Z×Ğ9iœb\Z#¸>îq…N°ƒy)˜$Ráf	Kø¥Š m/¡„;Â¦<Ì©‡yªÃ*ê‡012R™{L¢LóHñ`œÓø¸9†\".xaÕ¢ıçS@îê¬ºYddÜ\"ë\\ò-ˆÿ[<%İ¨Š2ÄF6¯Ô#WVöÙÄ+5pç\Zäzßó×BX†®õ{¨Ù\0\ZÆ\"‚Ä$*8	fZA\Z‡¸>v€,`¡G­~À\n–FN‚©Q´…Iq†ËÁ¦4ä“/qØS“íĞ µ5T§Y\0KQèPF©éd,Šoµ«±ÊÄpÎú@AÁê~´Áˆïíš×¬{Ê)„\nbÃ^IG:ª³–:+dËN[ò¸íÌÈ+‘ÑT şÊ†ue[ËAœoh¡7¿iÜj²\0·0íÀ\nÈ‡3ø•‘jî\nŒøÍ\"<ë~¤Æ~èC/ášF:µ½ÌyÁ_+bÿdÓœÖÌ§[az´Bº8¢><R(b¹€âÆ]ı’+&M‹šêÉ‘ÁFÈBÉ(ïµø¢Òò«xÈØéSûn®óõaÁè³\'¯Uü\"J‚cDi´ÏÍÍ­÷¶*\n}ŠqøäN… ~Á\ngTî\n`’	p…E`ğxGŸËñàß\\²M©é‡)ò°öFg8Q¯‘4k­“Ãì$jP)qs8½²O,ş†àÑ8âÆˆ—Šâßc—€òDbÖtk–k%ŒáÊò˜¬8O»:æBÙÄÂÃn¨ôJç,jÎôÖœ\"!Rr/3Ø…IŒfzgî(Fÿšíe0\"4~¡÷X*ø8DTáX!àFĞ`c²€ úH(øá’*hÜ$ûÔíHÁÑ¢À;Ä/îh‡mzêÒ0<Ø¯¨>m$áğÁ¼”¡şöáîÏ$2á\'öO*úÏÿ\0ò²h$„bHÂ\0WâŞa™¬ÌÈÕˆ»”ÙtŠ9ğ	®¡¥\nÌf`F¢2ÃÌjkgDn:mÍ¼ÍéX\n“¤î*atù®€\0Ò‚Şa_øàĞ¡Ğ Á~ãÍô8ÜÄú€l©¤ 	Âï¦¥,æÎvêîdPFÓÚà˜R&™>m’Í\nş:ÀÁâa¬‚ÿz&ÖrÁ\r{¬PËii\nP×AuûğŒˆ…Ø@+Ğ‡æ\nã±ûŒFæ¡æÚÆ»ÂHíA\rZ3˜$D0®ˆ3èëfAaÆÍUa>„Fò&`¬€V,D\nÀ³$´ä MB«×®Ş¤Ò¯âc(mdJfe«\ráò‚Ó áæa¾¡,@Í:À\0âÁş„r¬®1ñ¤¢@¶Ñ$jÅñ\n¤¹$Oä–+ónÁòöğĞñ¬¦BÖDĞgå,å˜IÜÇ,¬£-úmĞÁ ìÁÄA\rÈF~ˆFğ¨çrËõxÏ„ÿNa•8äW!4æá9(‹Á°÷¥,\Z‚Æa¬Ää`:‚ãqÖÎüàMøà\nRkcÎ\"/ÈïÃ°Ğ-\nb¶ŒÑ&\'¯`~¡L®@ª ¦1r³\nâpì·>¥ª€â«¦Hhœ2Ò($pbi¾J*Y\"ŞaäP+¡B+¹²¼òÃR;}ifæÁŸ\"(.ÎÒDĞòDªc/Û€–ğVAöğR!æpË/[áõfĞ !òIªr`F4Áğaä!<¯À\0AP\Z¬MLAt€$Å¡z:óMâ¬\r¨ğ9¬ğ4ƒéüb2˜fë˜¾CeîAb“ÿæèAÆp3, œa\n)aÁ\r™S8±Á)‹!2&¤‹¢’òÁôğ?2ïÖ˜Ì¬²«X^®+Ë&;·S;E\"¼óZ\0Í!Ä-äaÀøÅ.¤%\04‡-)p-5æ/RAÆÜS]*ƒQô0ÂcÍ\náfR*s0;ä!İS\rê!@3ëÎ¢ìşó\nàAÈ~ï0si‘BMÒş@SS74ü>Æ\n+-Ä†Óh²9¾ƒf(bFAò!H@\Z; F-@F- h•¾¦²oj¾Š)CáGyÂWxH¥Ò-ÀäÈ\nåÚé)/J¥Œ­­Jÿ­4,éêöh„Ø#t^„`æaQï‚g¦Àîb<\'ò5&ÁáäÀÆ!“ü‘NÅ!J,<–¤êFLÈO¡C`ïC¡`ä\nÌá.àÆRä¡\nÔã*/äa® XÊäÀ]Gr‚RÃ$;3Î\0\rA®Cõ%G5&JÓNõ/pRêò!fë¡p“Vo67cTW{u)ÄgŸ\'ÖÄ>Ä‰i5óÎ¡*­ÒYq<½²²ÀZ·&á¤önÂK\"\"ÒÜÄ´‹\nTZ® `:‡²Î’<_$/^Á\nA$,´Ä\n>ãË²ANaÿó=Ä0–r*œ¡PaãDê‚Áaá¦<Ç\0Şl‚ä@265Ja|0¡cAìÀ6a!\n$áo.µ£;ĞÂ V¶5Û€\"Àáö%frV“ôf“4gµhF¥$hÅ\'/h•F\'„t‰lÉÔ¡ŞAI§r×Ì**ä©ØØŠfÓjà¦6ç¬Àjõb†äGÛbfÅĞÖsb\"$â©À•FàfLÕã5öÖ`r¡bGÈ¡€2ÃF$oòAÂşR‡O~!`¶Ğ6,Ø„Òõ®`° ~å!ìBra0sÄA$g\0seÉŒÿ2!¼@6á\\8„\rÖÀ<ÓÏuSÖ\r@§&M”våbb–ğâAD\0zøÈÎ0gyá8«‚V\'ˆV*ì0ºA¬$\0iË*„ŒœÔ¡ŒØå²—¼,+q†úIn\"%°à|çŠ=p—.äÁ\"aÔ!°Ìòmv\"ßöN!5DXúA\01Ã3^oìÁbÇ2ÉíÕ™‰ÀÀ\"®!sîbäá\Z`A7€>í\nêŞ4„EXs9w‚0BAá¢$Faâ€:ãÚ°À}‚ñ;FÓvRÆ/l™ÔÃ £tˆ‰‰˜V¬J!.ãÿB 8r\'ÀJhnÁÎááyËÁäÆèØiiÁ&Œµâfè!,tŠµºÁ¢j±6ƒc/òèw!@-nhæw!,êÌÁèaRiÖ3+áZ¡”yõÇø\04\n\rêëÜÁ.³‘×¬‚\ró3ü‘Àäá\n@–!¼Õ[\r€ÏÊ”ƒÙ‘-Vä\0±ÄR86!b88!¨o¹3Ö jõÃ¦ğüR˜wø;Á.Šy°\0fVVx™¡÷fÃÁÎÁ€×œ´G*°¹\0Ã\ZĞá›Á¹ÖZœ¿§œÙi~-*†MÊaŒµ·ŒÍ¸g¥ÿê@VĞô™V¡Ÿ½Ó\"VF_ú,êApÀá&a\\¡[õkûºmWæ95< Ì®XÀÌÜa´=À´M[.íá‘ÍçC–á3XaÀPtÅ¤¡	F  ÷Õ¥#AÅ\04¿äTÛ‘9´\0ùJLaæ öàl™›8Â ¨ jßX%—:ÿÂ©‘	6°\02 ¡ªóA.`\Z½9«ÌJaÎiÏ!ÊÙœØP*ÒpyníĞ[œÙº$ ZùÖº8®¡Ôå¤uñZ¯á9\0@\r¥ªÁ-Ò[­¥~~ÇËR¼VæÆAZ!Xá¤^ã ,;]]ÿŞ•‘å’¢İABW|ÅQ[µAºwdøU·rì‚O¶³@]:ss\"å¡íƒí!´\'„ßì4Áî€ˆ\Zº!ª¼~è;gcnx\rÂ/NÕ¿\ntê¶…x\Z±:½“T¶ÁòÜû½SÁ×|%2î¸J‚•ŸÂŠAÜi%€¿ÿü?ÊYÉœô¨s+¯—J\"¯<çâWı‹Ä\'ÒŸŞV`\'ÅZáZ!tÎ\nÁCòØ/\\B¥`ÄmYajú2;ÛÅ[İ< µ)“Ì§Æ?ƒ\r*G®\0ô,Í¥Í•4yZ\"a¸Öß55„£öÀ…ˆÊ©û¹©|\rÿ®\\\"Ğ}m«9ŞbDK´m-r~xÆ[ÆrÍ—ù¶Á,²ØÍËÁ½ÑArØNŞÙ\ZJÎ+¨Ñ½¡—$Àßÿ|­pÉ¬«I¡á)¸ZÛyÑİá¥kr/$Û9&rõÓ—A²ë§ÓÛÄó¢®PAü‘ËÄÌjƒÙ Ô•”áƒÑÕ]¢-Ö”1É*²Ö×_Á.Â\Z!ê¢×ó\"\0@ƒ…<6†ÉU»’\ZTî`À Ê£şÙÃ`\rÂÀ²”Ú£@ëgkD4å»Û\"“ï3À½dµwÑûˆ×\\œÑTa­ÏáyÕúy‹X«E@FÏ-À›ÿÉñ›ıàÙ:˜l˜Ì× ”ØV°“á>PºSÁø8ŸW0!H|/ÍVfºaEù\"!€áf\\¡ÁO¸¡”áTA”AVÁ/,»~€aPœ£a~ÅS;ÆÉ!¤òæ+Ç,®€ ŞÁ\0¤¶×í¢&[\Z,t½l.KøÍD~j¹Êë :ã–ë ê\ra!²¼s²#Ó!\nX’4ı¢&±ƒR<§€TàUË>g“t™SãÖİù[î!Ø=\0âÀwñÎ‹\'Ğ AŒ$¼“P.¢Äˆ\ZİB*2d·zA3†	W.]ÊT­B×J]¤•õÒA¢G/€Ì™4ÿkÚ¬9iŞ¼uëäM’\'OOW®ØA‚4iİë$Iš4É«VŞV%}õ**°U¿½Z‡Uê²Ué×h‘+¦N_‰\räÌ;{äÚ½ëÎƒ{|Ç-â“JÕ·UËZº\"éŞ= õà“§>,V½ŒóˆH—éÕ£«×79âÄ™×MU«;œè\n¦N˜OŸÂºmê¼+¼yG‰òêP7N%Ai‹Õx[ “XÃ—ïŠ>gñ,ˆˆı¸qŒº{—èİ{ªwç,_x^¡B†\r»O|¿á¦aÃ6vüˆkX.oªL¢TIK/ÁtS“NMÅSëDÅÊQ¬@5‰ÿS@=U+¿x“”PëHÌ/¸‚Ü1[ArO\0‹52_ñôOì|£Î;xİ(×^}ù…J`ƒ¬ÒJ+ˆUÔæ Ù=HfYfN^	;—¥c\0_öl\'Î•¦å¢\Z!­Õ±Fl³ÑVÇmaPØ›oQ¸ÑÆ!“gÜqX½ârNbÅ,#™>õ8Ó×e§8Ğ”ãŞDáõ§\n9ñTWêMŠŞ;ŒXúŞDƒ}Ès4iƒKı”ÒJéÔ3`L¾*:	%Ée¦C”T¬LÕÊ2à@baPJµ\n.ÀzøÊ1…¬¢0È¹Ì2Ë¨€­°rÌ1ö”¨SOÿ?yİX—\\VÚã9¦oDbæÄegĞ$PV<‰™œÙI]ö˜ÂÍ8î˜fJ.¿ÂJk…à¶Ft|flbèÖÛokNÒÆ›nÔ)§pKÂæb“<]>õtÏ Ù¡¦(x‰z÷hÌÕ“¥•JÀH¦å`@Æ„B_} îÒH™ ÂŸI¨£R=N·\në«²îfBM	¯AÓ\n!„,3O­B¸Œ8Î:õ¡!Ñ*3Ê…n3$Êür­+`#·°sŒ3ˆ‹c:¢»9æ¶Š\Z¼A†¯Õ™]À<­à{¯+\\6	=Z6°)¦ ¢\Z…Ğ±0na‚zl·eœÓÿ_ÜF¿ÕiœÂÑyœ$¯ÜcÅ<¬Ğ£B>$œœ²yØ‰C)ŠæQÎÎ¿£MÌHZ³Í73ÿæpƒLĞõİr1Ğô‚K©©(3ØÒM?\r“«QÛtÏ­×Ú“<WÈ³Î<QeÍu_/CˆVTèBÃjÅÜzr5©bnµŠT4¤T(c¬¸Ûƒ^$d@óÀB+8p¾àepöXÄ_Ìq*$-æ^s>¦…iÔïIÖ›<Ş‰+™B(ÍçTA6¬t(“™\nñ	:ÀætN Ğ<^…Ø‚N ;íÚ¤İ1î%ø g:`ë¤äĞYx¥ŠHÑl Ö[ÿÍp†½‰4\"ñGÂW4‘è\"0écšª\"Ñ>÷½&÷ĞÉâœ$	ıeWAòß2~1H,È)úE.~‚?²1pl®hÅ7”q\nTü®ÀÛZÖ¡˜\0p°wî\0\\îš¾`Ä*.Ç¸ª9‰…OFe(ØBH¸‚—ô0€i²D0Ğ¢¬(\'\n!CÈ†ˆ…€ÍÂX—(¶i8W î<fÅõî\n%su¦7½ò”±Œïù#Î‘(õ¤§ëÁ”ÎÊarc™\ZGzA4cè‘@ò£ÓêÈAÚ¤u‡¼ıt!­…nÀf…„’¢´¢Y÷{Ê•¡±éÎËR7RÿÓŠRvè‰Iå<D°ŒàÅ°<gûYfñpÆı.“…x4n\0ù†<xù$¤`ã0…=fp¥q(Sˆ¬ &˜Â4ºj®Øœá±ÇvÁ8„SÜœÈH&~B:§g31<å¨ç<é¹Æ8N¤>ëCEŒ<„ ©Z•ÓÚ‡…Îä²âM°0sEfÍ‘ƒ¸+råŠ°écbÑ…+‚âVBİé‡X±e˜‚ÊH)Txòy,ÖOñàhj›C]w…V$ È—<èÑ8İÍ(øé“èI ¤ƒÜÈ_~ˆ°]UU‰aSH›ÿhvÕ«nˆâ67f\'ID¬f…ByÛp…ÅH:ÄCç;îé²ğà¬o^ë™¨÷4‚uìç00Á‘RŒoŸƒÌ*˜¦Ã&T±’•…lx™Èb‘èß2€!¨°Ã“hS2ÊŠ_,£)nÄhQñŠËHB©Ç)”AÊmvŠQîÑJsÍÅ_º=!âì%UÜ/•Ge!R‰w)33ÆÌ9è!šš@ÚÕ\ZÂÄİ/¿b·)…¼ú:6µI¬¹Îp¬(ŞIf7ú@™ DpF4Ï=Î£+¢ºó(t¶ñ®\nùÎ{*`[ì“ŸU7<Pû1«š.LH@aıíÿIOJäˆ³æËîêÌù;%O ÔŠTèCk Ä/Pİ§LE6NÅ2Á9½\"©”É<êaèˆÈ;šeosz¿rX¡2?‰Ç½–½l|Aâ‹sngæÔzˆí^X G?zhŠTˆú(®Ó\Zn#†2‰A«£ÙV:}ì±c)È„“˜µæƒÔÁôò;×wQˆT:ÿ»COÄñé^&Œ	c€BÆ0©\Z<˜IWº}˜V(DÃÆi*ëoÃ¼Òî„*Ô¡°#)§vÅ1À±\neL\"´®ÖED:	C´‚Ö§HÅ*€qŒ\\±Â\n‰•‰b²Às•+/656âV!H\0EÿĞF.q›z3ØfÇ=.@ÃzğÒ\nPÉÌ<è10T\\k\r˜%\n»c;Ü´Iğ‚üb±+bMge“!A´\nGóõS¿Exï,t!½·J\n¯–RxDzVq~\Z 2†.rA*lŒ¤$oÚª$+…æd~H²á½$!?	1sWÂ\\y3Yâ¦‹\ZÄ@JÅò›ã¼“¿PW*TŒ-£#/„¤GÒ™Ub§‹‡+‡IZa…G(ÚèPL=š´lÊd&OïÀQ[x²ãò2gG$‚1\nelÍ‹b\'±x£ùÌ²‹\"XÅª^¶cÁ°1³Mø Á“vÿ–Ò‹ÒxêÁª€\n2#3‚6h•`——\0ÈŞq· ©\r¡7z’fz¬XPtQ“ r{Pj&W$V5º“rò \ZÔ{ß\0b´$\",ZñjüAQ…02õm{ápìÀÏg$”.‡3«\0$’\0	ç\0mV \n’	÷€a-´“pèY‘]W@tôprù£{B1ÃQ€mğwhã5;¶#€2k‚‡ oWd&#Nã9s_Ş!ªàÖ“Fè_§xˆOÚ°hv*W\nºP>¢G‚\Z§‚ôz.¸:1+ºYóÀ‹dr¸²r26ÿI’:áŠİÂÊ …¿À\n†r\" ¥bÀP\"ä:P…r#\ZU’.¨€S&@k çĞc¼ódjèN¢Tù’9ˆáäˆ6’°ù§^ì;ëvfäµ1şg‡wx{·1Â1	õPgú@0İQhïdxp–x‰q„y~4¡\0*ĞpÊ\0Š¸ Šˆ£>‘@i§˜Š¯ÂA½±\rT†3Hƒ°¬°Â„ƒ2&ƒM=±ôóğ\nÇŒ…ğ”ä¿0…\n<„[8B…Uhğ„Ã¦b†ñWğ•¡İøÎ…mjØëÇ~XPA’WğVíHÿw€^Ù®0;İ„‡†`–¿‘k 7Pg}vF6ãˆiyåá=BsÛ‘º@¹Ğ`\'¡q.±‚ó5†´iÃHe°§?D!!(Ù3dCÅá)’J#À\rç-$Ö†°,¶\nãe|á®8B9óğqlª0t-€8ô…ßè$p?“ÀHFCâ$­£K )	m÷¸‡mÀnb@oˆÈ^å5;ì¶‡¿m°Yğ–…˜p¨å@‰‘——m´—‰Æô` âŞ\0Š¢w‚ˆa”Ö*Œù*¬g6ôZ)?Qa9äFb±fÿ5hÃH1)¢\")2	¨€\n¢u…j%ÁY&0¯‰#{!§pÎp”©¿°\nÄØOĞ›ò0\0÷P\0¾yÃ¥/’ğµèPò°Ì±Ëev@Z5œf;ååw°‡àBAk²1[0wÚ)ˆ†Ğ	²QàN@úàPè\06W”’Fè€ñ`¦iz¦9y”âg¡Oñ‰`w„\rŸ˜\rå“İ0Š«p‘-¡˜+ø*†{K¡™ˆ”H4x ¹]‘YÃÈcÔ\"ò .º`\"3‡b;§\n§`r0Nè¡5Õ\"¨Œp>§@³·)	Ğ¿ĞËğ	`õ€ÿ÷0$P÷\0œ@!T&¹Q†ø³išYnSRä¥™å¥øg1PŠPğWàmàEİVæpáA)â°lÚ¦Öó¦|iñy`!\nÃ@q%HS|\n ü9 :q øYå¨{“´ ‡ŠY(9@;Ú¯Òd2Š¡¨Ğ\rj“ ²ªàTãĞ¡ŸZ…z±æ î (\n@¨!GAQÆå›p9øğ}Îpó	ù`?×ğ\rÀWğ@‘1O¢³RÅ1Ë:	[`twpB¬kòv[À–iù\nXà:NpûFYğ\'Àc:)®×v©ÿp˜÷—Ãà \nİ>ù‘ğª4óê–f¯B†Éš,\"å³PY+·¨Œê!…\Z_\Z?:š\"&Ë \n‹p%?I±Lg¦òU€&A†!¹ÒÚØ;¾yï€“Pò`ü ú€ŒĞ6“ğğ“€¯ù0 d7LO	ib\\i‡xH´Òi´cõÛt¬Rô\n¬àåóAõÔQyå¦F)(³µ\\;®^Gæ ‰¹>·0‡Ü0Xñº4ªrnëŸğC¬ˆÁt›ƒÅ1r–Ãv3×BÄzaµò)Á‡\nºÀ°x{\Zd@‹À©ŠK±{±ÿIâ^C¹l—Y÷À*ç ¹ùb­( V@ù\0mù@“€0ò€>u?Ë¦TO¶Õ³è8¸Ë^{G¿ĞÙŞ­ğwqrİÆ‚Î€)!ûÕNç \nædNfº×µnjhÚsØöòğj¨`‚{$¾“V¾—v¾5 h£ lÁœ°÷ ŸfQ{k5]ÌœRòÇZŸè¥´k@¡Aè Àº¸y¡#€a…QË+zYìğ}‘óNpT|T†@6`®[²4pÎPWp\rV 	*RWÁGÅ…?ÑÈÕšÙ&ôö—¤Ã¡•gÅ–¸Ev\"EfePÿÚª’¬Ì£WˆÂ¼ü3è@ÄDÜiz•8)~V™ç=ñ)·\0\nY \nŞ¡¾J	–Åô@[<t[KñZûJ°^¼?GÑ #côK¿«à@àà\r…@&&%#Ğ{ã€.?”ĞØçƒ¢¤N³.AÈeÉOaÈPÙBV\0A±?PLñğŠA54 ÎPÃºKÅ™ãÇ„g?K;P!±S¤GÛ»Ü¹#x€·1,è#ëVÛxÍ›)‚½Ñ;½ág˜çÄOü«@§ğ½Ø §¥Ê§ÕŒ‘×œÍ6Q»İ<rIÕùÃLQb‰ªcª™ÛrRÿJ`á\nİBì°\nƒğ\"1¶\0€.Kw#?Ièr8*@ ÆŒ	³W¾C·—r³/	Ğ«yPñ€P!óğŒ	ä°$œYcÆé\'v2&¥±“éÃï…c\'~¸’ Ã#›–B3ºìgİFyvI<)Ë›‰›hGöqA¤¾z\nRÔlÍô`iK]ÃH¿X1sâ WSÕ¹’r©Ü¨0â!lAÕ,c½GMA•ŠÖö¼Œz‘,€[uAB‹p|…²&Y@‘Ğ\n ¨s{Ëå×ö\"	×`?õğX¹\0ğ $…ÔPÿ\0,6ì`ùâ˜„Ğ:#Ë¯W€˜ƒAa\'î…^ŸMV€\'+õĞmŒ@z¥W©ğVû°8—YO:>¶Å·\nİK‘)¾,¡˜¨§ÍÜŒÎï¸rëû °%¯…ÎšrÛrjbù’4°\0 \n,2q#@¬\ZÄ6Ş¡1æ0…aY_f9“€2¬WÀ€G%+Æ‰“ğ\0ñ0°÷0\\$€O”ŒğnÃÄ‡l/Vğen¸ªÏméç†_2Êá_ø…VDE^ù‡\râP—¨ŞÑfÚ¿lê§şËFÌâò”3P>1şÿ= pàã½Ø€Eã²ã‹9ÜéëÜRb\"–;ñÔ±˜Ñ=ŒĞ­ä<ñÔ¤ù’ôì-óÀ(µ’J#\Z6 [V’[ç²×·¢_Æv±ã¢{YôğÒ)Á`on5ú iä\nWğéø°ò€|ĞÈ‘«ä Ÿ õÒdYé–ÎªMËP°lN‘áËö”Ë–^NìXàÁÔ`ŞÁ\rhÚ¥ê#ïFü(ôt_øäWØ€\rA>á—w$P,ÏÛ¹. ôÀã4±è<Õ”ô!+§·Kş´\"İË?¬H!F+\0ĞNùğ€«€JF§\"X å:pÏsÁÿ«‰.>×À\'Ù°Yà	€ƒJ»LY†|mã\0—‘\0ù Aø@TÀºĞ\n÷\0è¼sY	€×@°PqÖV$X“\'Ÿè¬\nm¾1–áîÕ•n°~h¼g‡ç0ğPñğg!¤àoş6=7-®oUy¦ğ@øi`04Å°Esq5OÍºşõºÅÄíÜ\r”?ˆ\Zz›ôz»ÀNìÌ¾¾¬8rF1Y«Ô‚\\ø0ªİ‘\n‰ÕkU}÷LCf%~¡\ZcYm\0ÒÁrÄ]êàœq/WĞH•\0Å¥÷ˆ1	W\0ü ª?æ&Œ•\01éJ¤+Î®ÈC˜ÿ0¡I†¬\\±ÑŠB„%BqãFRF(¡|Äøê•ÆŒn^Aªç¬½”êĞ%H`ÎÀ¹sïÊ‘{—ó=ãıú³º EƒZ ™ô£ræ†\rÃ–Kj&dÅ¬!C–¬X±iÈN3¦-j7]©”©Zõ(ÒÚtè¹¥‡e^\0ºó$İ=xP$„x\'ıä\nÒ$v€ÿº<o^âÄŠ\rÿeÇ$V­Ô¤Q5iİ\0ğ²XIÇH4#÷èŞqÏŞjãV¿v÷ÚŞ¸TËZ±ZãJ÷î{ôîá›·.ø•»Åï†vDQù<y÷VŞ“&	‹¤,X¹Ç/Á½w÷\\yWoq¾Êûºb(/bÅÿõ;2Ì¸ÑE+ ¡ˆ|µdIÆy)éÑs¦tˆzÇ\0™(gxÌ‰G\'„°\'x’Ğ£9\n©¤j’ œS†‘*—bDÆ˜d¬±&dnañcz	k,oÌBK­Hêi‹tş“ë4ãÊ£H’+ÖylHvcG·Â[²HÀ$›Œ•ÊVI3Ì&i.€{æÁç•ÑD»\'Ì-éñà5×d“mrV¹•#wƒä\n,î!áŠVìúÑ¸+áS=óä¡ç|ªkägâ©\'gæ1 ƒÒ\0!g°àÃŠôú3¡5:h\"ó\"ê#6’Ä£6©¤(°`)ÿœAÇ€w¨@Ğ\0Ä‡ƒÿ;øiB…0\'\n‘ê	ÃxéiC%0\'ª­DÌe˜W¼+¬\\t—¨P™ñ¬´ÖÂqÇãš+€I~T./\"l2wß}72x\'K‡•HZieUöU…~	SËè¡i´F\Z1çœ™mœEÎD³áTÚÌÍ•6.§»{®˜ç‘s‹#ïG>\'ñ”\"òŠ\Z ÒÀ|ôé\rGæ±ÂÖ~XGHyˆÛ+Ó„Z!™äL-\"U>ú@BõŒòY	Àßù‰ŠhJ«áÙ\0:àU¾;le•Êé¦ºÙ*íh‡™æ*¬J&™[tÉ»sÑeÆ}WQÜ¶&û¹Bò.ÿŠˆÒI\"›WJ)#Y7zíµ·•GVás_ûÕœ1Q›‡‘‚1TÆ¡gµqV‡x63ÇYErİ.vE,ğÁ\'yî‰D’(òùŠrÎ‰G9IÙK±À¹B|¶4§IŞª‡U|°g\ZîÁà}€ôYy6íÙO…&zO>RMıÈ¤‘æÉ‡,Zm°FŞq„€Ç«áÁÓâ„Í€”€DG“wH ÅĞÅ4…§LC\0*Ò\nW¦oÚÂ[·ĞÒ·¥ão›ËÇğb8…àeëba Q/V°\r‘`Ã*Òò|YÎr|\"çø5DU|nóà“Ùÿ\ns<ìa«;ë\Zö:s°a\r“io\0„FÜw+^q&¡Šä´Pø ‡2vp>Ôã9Ç³B<øĞ1tÜØ™$ĞŠ•lh±$\"‚%åxJ\"ÉûBòŠ(äƒUôx„3Á@¦Ø#°ZVc5 ˆ & ×ÂÆŞO\'¦¤‰†\nÆ‡XdCÏzÊSÑŒ[4·l†<V‘aàB*yKÅŞHèÆşg1x\"Îx\nÇ)I¼ğINJR”Ø€¯G c»@=±M1ˆ˜!\"¿Œˆ .‘§8ÅA\'²nu³YÄ\"V‘›ÉX¬\rqÊ‚s®À4|ô®p?ºBÈ°Ğˆÿs¨ÃS?zòê´ƒ,À£W€Y#èQ<¸â\np„§(À\nğıé!~\nÌBşÔ‘¢i„}’xÅ$É7ºQVçL8°˜Øƒ¦öĞU\'EùÅÃLå\0„$n¨ˆ….²±•XâÂÕÊŠµ	uÄ¢¾Ä[*‚9Â¾¹.#fğ²¼†Ğle,³ÍmŠI›–Ãœ#â\ZDGQVJCrÂd…H”Ót| qŠs:¬a®aİ\"R	W1ÁĞÈ¥|æ¿âŠCáá±gÅáA r…KÚ%ó ‡í*,L¢Rù¸‡3ò>N‰Ô|!d!áC7¼ÿÇ>Y)K´MrÀ¤0É\ZÖà¬Ác\'?Ù©ÎáêrM’èØæP‰òG0°”¢s„2t¡ÔºÙ\r+šFÛâ·u@B¼XæŞÑÕz|õ?$ÈÙ?ºß<Jâ/mŒ“²‰5°j¸\\Àx×„mªssõf]ñj%>åujÀ0ŸÌÁTğÃF;İéÎÁ>‹¹\Zã‘\0¬Œ£a£t²pG0g/xùìêq+Àã´nÂ=80	àã\nñÓ[Ê§?Ò¶\r{Éíù  ¾Œ0Ù>n`-Kau ğÃ\0\03M7Àæz€ôé×agp­(É\nêO†K]¢:âÿãÍFyÊ\"PÀªÅˆE*ğ1	ñÖ\roe‘/}íK:LO+Léa,V¤{®¡„Ğá´¤¥,°¡Á†p„óZ%GXX‡§FğåaV‡¸Ãä09ØéÄÕÅsª`Åì|ä#\"Y¨=äQçé\n“Ÿ’§½DÂ	òøsÆa\0gàCYˆÉ2P}ğC“@…BĞÓQ3Jb|¹ÇøâßŠ$¤#%Éˆ$\"‰@9ù2€—m[aR¹`Î$<*ğ^ Í:±Õ\0	MYñ8ª“ºT»A%*\\-­=ñ>%dÙjZú–î¾\0-N_î\"ÚM\ZÀÿÿÌ”V0ºÜ‹­¡pÎOês“û«‡=,ëtÆÓèëlÅ‘œ”|X¡°½GœŠ]œùaätÄºÇ‰Ü\0’XD>&ñš1bÂèa€‡®CÜ®(¤BîÑRíeS“pFÉ¦|Ÿ’l¤ô’+Lqed#a¸$âùıeå& ¹?±•:`	ä$ˆ/‡Q|Z!UÒ¤4–k,4QŒòÚ­âO¹(PÇÚê*tá­ùâ¨ä&§Ê…¤Ù+¤tÀö|ù_œ¯™›&LO`ë#äšsæ£\ZÃÏç![ÜˆT¬¨¸ş«ÉqŠí×:ª`,b‚l,\\÷›È×ÿ§.¤ŞA¢:é®*T^œt(Ã\nŸ`ˆ8pl¬#ïpZxæ0€G`¡¡Ñ‹( †ˆÀyÈ€tÜÁ )xã‹)s„A‡oP…T t2…}C.ÇC.«¸NÒ~ˆ^)[³w°£ˆÁd‘€\n(åSpHª´1=ÓKi¹…X0¿yøeÀ¨ÈW¢=uh©q1¹eÃ” Y—$Ù\rİ0µš9Î\0H°œGp0æk¾äÛ&jê¡ËŸê³¾ëkÀ’µY[§E@…H8±Ç8¶İ	“AQ¡Z¡cË‚òc1‡H@kÓ!à «‰h„8˜,0€°B‡½:rÿ£ˆôØ7¸‡õÈ‚e`‡	„Ü‘‡H¸7 „@@6ˆıâÂ\",´\\à†×ÓmAä¢)ş¹š}€4³‚cAÃ‰sˆÁ£8‡)º05p…‰“Š´›­H†ˆ$BeÈ\"‹³ø†ù*!À1¹ÂÙ¯q(ÀÈ¢*¾ÉXƒ|Á1¡O»œ‹°ÃV°¡{´!jz„/9­º¾¡Û¾xš5G¨§ñã˜ıú7ÁéC,ÈØ½N‰ˆ¹“‚R…P!aÿZg(€™)WÈ\0G³1Ÿé(q…Wˆ€»@	+Àrtƒ(hƒıÂuXeğÀnè†ÿÂ…ZJqP<0s<¬É\Z\0–\0zš8E9”xø2Yy)‡«Ì<t¸ÊtÀœH˜¸<ƒFlp%]°†V`½_(Â<óIDStèªb\nrG¿€9İ¨§I\0°ÉÈ¡:“á&0ô&ì\ZC|±¡µ0ÌÇÁ¡|É~<>@ã>ŒCwq’€Ú=e*<V&³yx§3³ò0«+€„*˜ÀXS€Hc#ÚBˆ8Á{P4ø„è	´6Ü	¨lË¶6\0{SñÒ…nÈFZ‹åA£L.ü©çú•^y‡KZ3t .Xé¤(‡’.šx„¼zeh%ÒëA©€ àÿ0²€ú†\"TªØ+eø·¼‘úZ4Ä!Ç)G¼´Ë7±B½ÄœÏ‘‡.TÀŒ+ÁÜ¦2ÌH’È‰{±¡ºZLÑĞ*ì{LÀZ\'tZÿ,ÌÌ,Ô,MHXÏ´k“t0xHFĞºâ€T(µ³L·Ø4I„`~pƒ\\H€„O™„G°6…XÏc‹7à’øÑIox%©˜EZ¬EmXNh8®1#32³Q‚.aaÊqJÁqu€•¡z„pÌÙ—¬‹“ŠlP†²o…_ğ†l ¢O¯ºO¹ÇÅàO8y“(É—++h0yô¦zTPÅ5ÔIÿµ—HÀA>4D˜Ò	¬t\"‡FÃI+üü‘Ü{„¼¨¯Hø6úà«T(‡8™G(>PÑT\0¨Ş96u ’+ˆË(e’M„PŒC€m8Ÿ½À®\"Mˆ™<¶}šêz}Ğ‡Ÿğcx½ ¤Rc …\n ÿ!3a®éÒçâ•s0\n¨\0[IÆsÀNu€Wx…„ËAñ2OÓ9åÖ#ÂeHKÙÓ›¶l…o¼ÏˆTIŒzJXHÈ!GøœEL>AĞGePIJµToê—ŸëÇ kÃ5Qº’Ëñ0âhUÀ‘HH¡±‚Ø¬¬‰TxV,­\n£yhÂÉ,ÅX?àÿ¡B’„FØŠèÍõÌ‡£eš§é·¥5€u…šsøŠR¨Rpu.ˆÁ^Œ‡‚šŸ8‡rhÚuµÁrØ—sø†µª«V/ŠÃWúóãÅø/€\r¹Å‘E£@µÌcCØzzVp°‡õÂÌáÚ¦ÔwŒ…œVXLeŠF Æ¬C…TÈµú‹ıº’YÔÔJFHU„uˆˆüÙT>ÀJF°Õ¦˜êƒ1u4!áÙ\r£¿(Uàƒ0É‘Öß•ÖH‰ìÌÚ¦ıÅûùÅF‡mØ†R >\0è¤bÔZ8³	uÅJ´`Ì9ÙúS*°ŒFú†!TŒyˆ[÷ÿ¤ÛD»ÛEÇƒEØ…%°)qØ0Ù¦#£y¤ÇÃ¼\"xAÇ„µÔúÍü\rV#Ó9Ó\Zv¿ÇÈ»@¶s@6I¨¦sXÑµ@9Q‡«|„\rc5spÕW\rfZ‡\r>‡ÛÃ\"Çİ‹`Û£x±âÕ§Ë‡e-RRÜ§tø†r ®áí¤}Ø‡¯ñZãí·YI\0q0n GÈ‰\nŠœŠ,eÁÊ2ıÂ4pòÜŠäŠXXò…[¹¯øB‹VPÇ¸Ô[¾í[u”6\\úU¾Ì¢c«]Éq—„ı«swQ¾…ó&*0 ,Óa„5h-v!I‡uÈº=Ù&Ñÿ@ÍG`µ\\sğy`>hµƒ¹`Ó|!„9U=L&Xü4Md#œC—„X¹<„T€ĞTVZfÖœüe(r¨‚CÑ	ê$¥¯Q¼KÊ	~ ¥xp%\\è†Ñ)Ù®d×ûI\ntˆ„´ vø…?³\nÙâ.~Û¿ø…ö4Î²¨Û2†ËÿHcA•4wyPVÀ4€áÂPÑØ Ú¡•Cxù\'À‚DæÏÿ%ª8î.\n¦àƒ‰5›˜6ŒcB6H`Ñc»œI(‡t(s¸Wåäs`sh\nVs„S>å€Ê™u€5‚à=¡±Ó$À]cÛyu#}!‡IèM[&E#ÃyÿHt OMÈÆl)gøá‡(ÄS×ÅCêj„ñÒU`8bÜ<âé)Ÿ*‡€5¬Jt K½0HHË­°†­H¯X0Ëof‡Qç0Öª½qË»Å½¼u_À`Ü½*	,P¾4ø’¿–X¶2Ì\'àß]cIr\\åCFh­*‡F˜UNn„40lE>;–`?tPû1yİ«\\ÃÌ°×B˜Fé±éS^>p„@ı„hEÎíÜÍmiã8yx…b‡T@qÈ\Z–@Ğt[zh÷dªa€šœè7ÉËÚÄK¼~ƒ	¤V	7rG½nP€*˜¼O²^¡\"\nhŠ˜HìºåÿS‡e°×´Ñ `ò}D¶vÏñzk´ ÏÁ=TFHsdÜÇ1°Uh™ìëıë»’«1¼c7ÉãÆj’\"‰u¢\"ª¥ \rsXÃ\nVPèÆ˜‡·(HÀœ®-MÃ¹‹sØì\rS…ˆ8ÇlãÎi°ƒC¼PŒeÀ–Kàq…7(z`QŞ6…3\"Úà^ÏÁ‚HÈåWÚŠL‘wĞnêâEYÙ\0¯A<ueÚ\n°ØaêzÓÑSˆJ¯!F	©ÊH¢3ğMzäô n>ke`÷z0ö†;ßªùXûGru†I­¡şú­«ÑĞª/ÁŸç¡Åã»ÿ\\ğ\"ÁÄ.G¨¨QbÆtÌT`Æ\Z«u˜¤áAã `> #+˜\náSVŒü\néGØ¾…œ%uñüVe¹¨W°¨ñH\'ó«e„àMfåit(Bõ‘}XÁq-¤SÄë7®±öìÌÎ;Ïnpr®­Ê1ïZ6S‡p‰x¸7ËÁ´Ur³†XPHpï³«óøÆó}ù6QY¼5XyŒ„ôÄt°H¸Dtë\r>¹çµØ_wÉpÃàëú­îG¸t>±	ësLÑ„5Ğ\\d#I˜‡µØÇ<¼QÔ4V?]\"‡sx¡•gùrïİ[Á‚ÈÔiÖƒ!Åàõˆÿ„uH¨õ±¶(Äé#İpuÈå¥*†L›Ñ‹‡*H ræ~[W[±v7\nlç–ñâ†CQ¥†»J&$9tğ´U\ruP†iX*kH¯vWvˆ÷tX†eÈe\'ã{ßs¼YÃ¸\'Áˆ€×¡?tìGû/G0pÈYxHp\'`—D¶TIZ¸…;–c¹ûqU\nŸ˜ŸsU0œuXÑˆ4ØİñS•‡}4íW_ù!‰õÓ!‰\'“æ[nEu^düŞ/GvŠ“ü\\Vœæ×¯Öì<Í„h‰\n&‡ bXAğ6€‘öçVê´vçŠì¬‡Ò‰½\\8^ñ©8ët˜óğÔp O£OûXÿˆ¶¶{ô–{ºwjæs4Ş/Ç¸Â(IÌx<òÅDÃ4|„ç¡;>|€€	Ë¤‚\r¶Éâl¡£G\rQq‘‘#FŒ\Z™³¨ŠÕÁ!•›\'iŞ«FèæÍ»\"IÒ:•*W®„ôH’¼U­ø8’teÊu<çılésç•¢WÔ-27éÊ<gô&¹™d…©Á”EW\Z¥*ÕJyY‹â+O^Ø°Wğ1‡R«oÊtÃVlX¦L¹Še+¦«[•ñŞ0\0Ø@‚\n	Üa1ãÆñ/\\è­e]ÜÊÕ‹gáÜ9GèÅ;7Ï‘#Uª¥SkZ±bÓ^Çú†rö$VËnÿŠ¥K—·T¦¿­ÿB§.½âÆéM9¯£+¬X±aÓJÍªA“*^l¤İœ9í)®zô¨U¤Hk¢‡ä±#½…‘©säÌQ<Ò¤Ï1RÕ(UªFå\n­wĞ<é4¢ÓX‘°dLX­ÄÈ:‘0åH+ä02m@ÕS>q8ÔK§Œ£S=4MrŒ<(Ä‡WÉ)§ÄsÖW^•5VYh…=‘´¢J*wÓË0­µ–M6šè‚Jïˆ\0Øaü$PX†f@cWúõX<èDæ*İx“¤.¹èâÌ–è|vÁ«¬bš*©­öšœ,“ŠàÜ¶Ì/oí¦Œ2ª\0\'qÇ—Ür	´t­´òuY´9ÿ¨ Ò]*‘yÏ—+~ôˆ:â‰×#UÔ©*\\Z#«|\nê<|õÊ$úõLH‚Ål\rQxÅ$ÎöSJrHÔHL³M\'^ÅXóÄTA(5‰+‹,‚ÎúäÖW7–•J$@¢Î*oeƒ\r1°àBd.FîVÌ;ÎTYÁù\Z@e¿ñ`‰¥–ñD¦N7»!¬›7‘<\"è*i˜Æ;›Ä)g,´bçrxâö–7½ıèp„ÇO±“²+®<£l®RQ9MJi¥şåÇæx­<ÇJ§+¯`8#ÃD‚}õ‘Æ~0âG .…’$VÈc…H«¤âˆHÿ,„à²W@²\n*‹82	²Aµ¡O“˜¬Ò°WŒ%$‹¨’’<éĞ´È8Ã-79‹0b•¸_EnVøèÈã/©À•1ĞI¤‘ôvóaˆ%Öoç/pè¼*ºè†z,ÊlòK+é8±i®ü\"€œ°)Ã\n¶(“ç¼yã\' 6L2m(OÂNsÏ1JHu§Í\\3*|ÜœJ99ÛÔ\nœşt®|ß†øm°òˆ{â¥JZ<T¼ãgØ5¢J+T/EwÖòL¢®*l¸b‘N*ÑŠ&LQÅ9ø`a©m(‡\ZVKŠµµUeu¸¥¶V`ÁãH*ğ—#¯$ÀWÊAXÈU®ÿ©%]«ø…7ò\"¹Ü/y‘a1Ì!Âl åˆ?<W¥¾€1CdRT¨&Jlİ2Öñˆ4ÈNb£@Å¦‹M¸b6(ÁB+|ç1eøfx­(¡vAƒ\0\rÏ)œ×¦‹PŠrä9hş¨\"\rlÒŞ\Z†5	¤qeãß$‡Ä£\nô©Ïc*\"3FÌlêY;ÈV·yD‚\\sÕJVq¬„&’8G#äx<p&KåµhóÀÒ-–FAKÁ\rv¤D¥p† ¼âœÄ \njÁA7.Å}¥qèPÅ[ä…\rlÄ°HFÂK1ÊÎ9És0€èF:Ò¡ÿÉ=X×êZ7Še°ƒG²S;–AE‹	àZÜb–á–XïOb$ãqüˆ2 )ŠÍ[!§7Ç:VÏ4lzVİêÖ†54h5dÑÙ0\":Äï8ÇFóµøMmÁåX&‘VTªÏªMÌæ¡²½gå˜£NRbB§(Z ¶ÆBÂ\r«Y‹8Q–2	¿5‚˜“ &1±õS²˜%™)ÔŸ2òr—h	/wq!6Ş1˜(e³0V\nâ7‡ˆ¦8£ê¨ë6qNN¸âe²kç5lgEĞi(©§[ü$¼o\0gŒƒ\"NåœE9ïú™Ş)È1¸Qj?ùq„J\ZjY¯@¢9ÿ™EÏÑÖHSÙG\"öùÎ¥áGı±%£ÆI@b?ª@‡$QG0Â 0A-ıDJ7|xå§@eŠ+„‰‚°baªR™êÔc¢G†ÓÑIİÒÂ¬æâ…òÊ*6†‘\0*ä+Nk³TÖÇœ•KõXï\nÏ	WdOvëXF]ñz1ŒiL-·Fï6á×í1 ÙS:¢2H¤±l\ZD#û\"n9–zû¡¬Ş.{?¯,\'Qç9šùìÓ°‹*²i©È9|+ŞÒ^ÑŠF°£6ª˜D#±\nØfÒ¥ä„²RØğÔ ö.âZÙÔâ„¹Ì]*A†5ÂY\"N9ËÙÿQ›ØÃìBóª0ÌE.†1là‚ûÌx7Ç€9CˆçE/Z²Ö“º¾Ò„iÖŒú*Q\0›Ğİ<±°şönOÂML²&de‡m!œ7ˆT bp~ê)$lÚ«XÖ\nX«Öt\"‰5€zTU(•ûƒ¾ĞŞÇ3%ŞŸ€²0‰V¤¤\rP9”r«…-«PGy4‰9\ZE\'ş¤_A’Cde¥ØKN²’•J&ÏS¸R;Nº®ZË\\Ë]^èågÃàåÇ;zH*,2ŒIóèÎ‹pÉÍNI\'\'€q50ªGyG}ñ\ZO\\ÏÏ€n‹ à“Ì#š]#£ÿŸÇnA¼YEE$–#’M[ø²L¹‚Ï0ŠHÒ ¯\nD-Ó(’\nIªíPO)JCèhÚkµÂk¢Ääuú#ÇwüÏØÄ®ß±£…–àf…˜Â\Zf1›…§<ÛÉ³‰rêq‚Ù=èøİ4‹Áe,?óê]öò—Áü¿xµğ¨\0`ĞÚ˜…8fÍï·3Öê_¥ÃŞ;kÄæÁoãuJ×âŸ­\'áı8Ë Ï`û¹6¬¡¨Í	h£«3ˆ‡sË‹0…äm]g1”Ó÷Ã¸OEbQ‡d4¥úL}Ú‡jF¤á¸¡Ç<f‚?5¤b¨Ğ<Zq‰-å©à9>IBŞèVyrV‚[ÿcuXÌö£ÑŸİÜ¥ç(-ô€G<ê‘y¤8ëb—UŸéıìf÷Ë¸À×¡I4	0T€‡`ºä~v¯ùLæss=ÒQÖ³ãz™*äqŒkôÛ/Ô‰^ÍÃŸıiüÌ…¦Å+°+°Ì2¬Ğ/ø\rå™Â8TœVØOÆy…¦UVİ<‹JdÔ	VœŠDtG‘Æª°\nÊÍ\n$TÒhD9À#¬$D¥tG¥Ğ#›¹\0ŸGJ´!_JèÃs™‹“İS]³-ÕŞ¥EZÀÃ>°ö¥ƒ:X—.d[Öy_wu×ø}›\\2ğØFÃ;ÔÃû]‰Ú¡Éüµ]ÿıÑC:LÂŞhÿùß(ÔÕÅü8ß8 üB\"›ğZ: ÜqÈƒ$DAUÔDâµÁÿXHıˆD$fşH,‹ğ]ÁTxÅ´\\=€Æ©d}„VûL–FpÄ°CÚÌÊ¬ÕšG G®ùH)½$(ˆ¹dËzáîDÛ1\"ß2™ò9S=#SµjÑ$Üa[(C˜ÌÖ…á’¡—i9,	¹ya¬—ûÅ¡»¡I¼©ÃØaÊHPÙä[…¸‚âÕ5ü+dÀ´íU!²Â&bà±Éàñš@ÌpBT„Ô\'pÂ((Ñ ¨ÖXA!‚QÅ‚hš…XEp…`VŒ„§eEp 	,’†éQEF*Û$0\\ÇMÃ*ş ÍàÌ\r\nıÔ°]‹T\rö\\”-À5Ûq(“QãlGÒì‰6:Sz.hz8Ã;ìƒW1‰WuÀvIÚ©c8µ;ÀÍÃà£ô_=Ö×5ŒBaò×10\\ à\r8D‚#’L@\0\0;','abcd','2011-07-18 19:58:37','abcd','2011-07-18 19:58:37','Y','1');
INSERT INTO `t_da_country` VALUES ('1','ä¸­å›½','CN','System','2010-09-15 18:54:00','System','2010-09-15 18:54:00','Y'), ('2','æ—¥æœ¬','JP','System','2010-09-15 18:54:25','System','2010-09-15 18:54:25','Y'), ('3','ç¾å›½','US','System','2010-09-15 18:54:49','System','2010-09-15 18:54:49','Y'), ('4','ä¸­å›½å°æ¹¾çœ','TW','System','2010-09-15 19:26:59','System','2010-09-15 19:30:38','Y'), ('5','éŸ©å›½ ','KP','System','2010-09-15 19:28:33','System','2010-09-15 19:28:33','Y'), ('6','ä¸­å›½é¦™æ¸¯ç‰¹åŒº','HK','System','2010-09-15 19:28:50','System','2010-09-15 19:28:50','Y'), ('7','åŠ æ‹¿å¤§','CA','System','2010-09-15 19:29:12','System','2010-09-15 19:29:12','Y'), ('8','æ³•å›½ ','FR','System','2010-09-15 19:29:37','System','2010-09-15 19:29:37','Y'), ('9','è·å…°','NL','System','2010-09-15 19:30:14','System','2010-09-15 19:30:14','Y'), ('10','è‹±å›½ ','UK','System','2010-09-15 19:30:56','System','2010-09-15 19:30:56','Y'), ('11','æ–°åŠ å¡','SG','System','2010-09-15 19:31:25','System','2010-09-15 19:31:25','Y'), ('12','å¾·å›½','DE','System','2010-09-15 19:31:47','System','2010-09-15 19:31:47','Y');
INSERT INTO `t_da_product` VALUES ('1','ç¬”è®°æœ¬','admin','2011-04-30 23:27:56','admin','2011-04-30 23:27:56','Y','1','3'), ('2','å¹³æ¿ç”µè„‘','admin','2011-04-30 23:28:18','admin','2011-04-30 23:28:24','Y','1','1'), ('3','ä¸Šç½‘æœ¬','admin','2011-04-30 23:29:05','admin','2011-04-30 23:29:05','Y','1','7'), ('4','ç¬”è®°æœ¬åŒ…','admin','2011-04-30 23:29:36','admin','2011-04-30 23:29:36','Y','1','3'), ('5','å°å¼æœºç”µè„‘','admin','2011-04-30 23:38:48','admin','2011-04-30 23:38:48','Y','2','1'), ('6','ä¸€ä½“ç”µè„‘','admin','2011-04-30 23:39:25','admin','2011-04-30 23:39:25','Y','2','1'), ('7','ç˜¦å®¢æˆ·æœº','admin','2011-04-30 23:39:43','admin','2011-04-30 23:39:43','Y','2','1'), ('8','æ‰‹æœº','admin','2011-04-30 23:39:59','admin','2011-04-30 23:39:59','Y','3','1'), ('9','è“ç‰™è€³æœº','admin','2011-04-30 23:40:15','admin','2011-04-30 23:40:15','Y','3','1'), ('10','å¯¹è®²æœº','admin','2011-04-30 23:40:29','admin','2011-05-18 18:25:22','Y','3','7'), ('11','æ‰‹æœºç”µæ± ','admin','2011-04-30 23:40:44','admin','2011-04-30 23:40:44','Y','3','1'), ('12','æ‰‹æœºå……ç”µå™¨','admin','2011-04-30 23:40:58','admin','2011-04-30 23:40:58','Y','3','1');
INSERT INTO `t_da_productbrand` VALUES ('1','2','1','admin','2011-05-02 16:04:52','admin','2011-05-02 16:04:52','Y'), ('2','5','1','admin','2011-05-02 16:05:11','admin','2011-05-02 16:05:11','Y'), ('3','6','1','admin','2011-05-02 16:05:25','admin','2011-05-02 16:05:25','Y'), ('4','1','1','admin','2011-05-02 16:05:58','admin','2011-05-02 16:05:58','Y'), ('5','8','1','admin','2011-05-02 16:06:16','admin','2011-05-02 16:06:16','Y'), ('6','3','2','admin','2011-05-02 16:07:25','admin','2011-05-02 16:07:25','Y'), ('7','5','2','admin','2011-05-02 16:07:42','admin','2011-05-02 16:07:42','Y'), ('8','7','2','admin','2011-05-02 16:08:25','admin','2011-05-02 16:08:25','Y'), ('9','8','2','admin','2011-05-02 16:08:51','admin','2011-05-02 16:08:51','Y'), ('10','6','2','admin','2011-05-02 16:10:20','admin','2011-05-02 16:10:20','Y'), ('11','2','3','admin','2011-05-02 16:12:09','admin','2011-05-02 16:12:09','Y'), ('12','5','3','admin','2011-05-02 16:12:41','admin','2011-05-02 16:12:41','Y'), ('13','1','3','admin','2011-05-02 16:14:01','admin','2011-05-02 16:14:01','Y'), ('14','8','3','admin','2011-05-02 16:23:47','admin','2011-05-02 16:23:47','Y'), ('15','6','3','admin','2011-05-02 16:25:01','admin','2011-05-02 16:25:01','Y'), ('16','3','3','admin','2011-05-02 16:27:01','admin','2011-05-02 16:27:01','Y'), ('17','4','3','admin','2011-05-02 16:29:01','admin','2011-05-02 16:43:24','Y'), ('18','7','5','admin','2011-05-02 16:47:18','admin','2011-05-02 16:47:18','Y'), ('19','6','5','admin','2011-05-02 16:48:02','admin','2011-05-02 16:48:02','Y'), ('20','2','5','admin','2011-05-02 16:48:19','admin','2011-05-02 16:48:19','Y'), ('21','1','5','admin','2011-05-02 16:48:52','admin','2011-05-02 16:48:52','Y'), ('22','5','6','admin','2011-05-02 16:56:39','admin','2011-05-02 16:56:39','Y'), ('23','4','6','admin','2011-05-02 16:57:09','admin','2011-05-02 16:57:09','Y'), ('24','3','6','admin','2011-05-02 16:57:39','admin','2011-05-02 16:57:39','Y'), ('25','5','10','admin','2011-05-02 17:06:04','admin','2011-05-02 17:06:04','Y'), ('26','4','10','admin','2011-05-02 17:06:16','admin','2011-05-02 17:06:16','Y'), ('27','5','11','admin','2011-05-02 17:16:25','admin','2011-05-02 17:16:25','Y'), ('28','4','11','admin','2011-05-02 17:16:53','admin','2011-05-02 17:16:53','Y'), ('29','3','11','admin','2011-05-02 17:21:21','admin','2011-05-02 17:21:21','Y'), ('30','8','11','admin','2011-05-02 17:22:10','admin','2011-05-02 17:22:10','Y'), ('31','2','12','admin','2011-05-02 17:25:49','admin','2011-05-02 17:25:49','Y'), ('32','1','12','admin','2011-05-02 17:26:16','admin','2011-05-02 17:26:16','Y'), ('33','5','12','admin','2011-05-02 17:26:39','admin','2011-05-02 17:26:39','Y'), ('34','4','12','admin','2011-05-02 17:27:09','admin','2011-05-02 17:27:09','Y');
INSERT INTO `t_da_province` VALUES ('1','åŒ—äº¬å¸‚','BJ','System','2010-09-15 18:57:24','System','2010-09-15 18:57:24','Y'), ('2','å¤©æ´¥å¸‚','TJ','System','2010-09-15 18:57:47','System','2010-09-15 18:57:47','Y'), ('3','ä¸Šæµ·å¸‚','SH','System','2010-09-15 18:58:04','System','2010-09-15 18:58:04','Y'), ('4','é‡åº†å¸‚','CQ','System','2010-09-15 18:58:16','System','2010-09-15 18:58:16','Y'), ('5','æ²³åŒ—çœ','HE','System','2010-09-15 18:58:30','System','2010-09-15 19:06:22','Y'), ('6','æ²³å—çœ','HA','System','2010-09-15 18:58:47','System','2010-09-15 19:06:46','Y'), ('7','äº‘å—çœ','YN','System','2010-09-15 18:59:03','System','2010-09-15 18:59:03','Y'), ('8','è¾½å®çœ','LN','System','2010-09-15 18:59:17','System','2010-09-15 18:59:17','Y'), ('9','é»‘é¾™æ±Ÿçœ','HL','System','2010-09-15 18:59:35','System','2010-09-15 19:07:13','Y'), ('10','å®‰å¾½çœ','AH','System','2010-09-15 19:01:48','System','2010-09-15 19:01:48','Y'), ('11','ç¦å»ºçœ','FJ','System','2010-09-15 19:02:26','System','2010-09-15 19:02:26','Y'), ('12','ç”˜è‚ƒçœ','GS','System','2010-09-15 19:02:49','System','2010-09-15 19:02:49','Y'), ('13','å¹¿ä¸œçœ','GD','System','2010-09-15 19:03:06','System','2010-09-15 19:03:06','Y'), ('14','å¹¿è¥¿å£®æ—è‡ªæ²»åŒº','GX','System','2010-09-15 19:04:34','System','2010-09-15 19:04:34','Y'), ('15','è´µå·çœ','GZ','System','2010-09-15 19:05:22','System','2010-09-15 19:05:22','Y'), ('16','æµ·å—çœ','HI','System','2010-09-15 19:05:54','System','2010-09-15 19:05:54','Y'), ('17','æ¹–åŒ—çœ','HB','System','2010-09-15 19:07:32','System','2010-09-15 19:07:32','Y'), ('18','æ¹–å—çœ','HN','System','2010-09-15 19:07:50','System','2010-09-15 19:07:50','Y'), ('19','å‰æ—çœ','JL','System','2010-09-15 19:08:08','System','2010-09-15 19:08:08','Y'), ('20','æ±Ÿè‹çœ','JS','System','2010-09-15 19:08:27','System','2010-09-15 19:08:27','Y'), ('21','æ±Ÿè¥¿çœ','JX','System','2010-09-15 19:08:45','System','2010-09-15 19:08:45','Y'), ('22','å†…è’™å¤è‡ªæ²»åŒº','NM','System','2010-09-15 19:09:18','System','2010-09-15 19:09:18','Y'), ('23','å®å¤å›æ—è‡ªæ²»åŒº','NX','System','2010-09-15 19:10:03','System','2010-09-15 19:10:03','Y'), ('24','é’æµ·çœ','QH','System','2010-09-15 19:10:20','System','2010-09-15 19:10:20','Y'), ('25','å±±ä¸œçœ','SD','System','2010-09-15 19:10:42','System','2010-09-15 19:10:42','Y'), ('26','å±±è¥¿çœ','SX','System','2010-09-15 19:10:59','System','2010-09-15 19:10:59','Y'), ('27','é™•è¥¿çœ','SN','System','2010-09-15 19:11:34','System','2010-09-15 19:11:34','Y'), ('28','å››å·çœ','SC','System','2010-09-15 19:11:58','System','2010-09-15 19:11:58','Y'), ('29','æ–°ç–†ç»´å¾å°”æ—è‡ªæ²»åŒº','XJ','System','2010-09-15 19:12:36','System','2010-09-15 19:12:36','Y'), ('30','è¥¿è—è‡ªæ²»åŒº','XZ','System','2010-09-15 19:13:07','System','2010-09-15 19:13:07','Y');
INSERT INTO `t_da_role` VALUES ('1','ç³»ç»Ÿç®¡ç†å‘˜','å…·æœ‰æ‰€æœ‰çš„åå°æƒé™','system','2010-01-01 01:01:00','system','2010-01-01 01:01:00','Y'), ('2','è¶…çº§ç”¨æˆ·','å…·æœ‰åŸºæœ¬æ•°æ®ç»´æŠ¤å’ŒæŠ¥è¡¨æƒé™','system','2010-01-01 01:01:00','system','2010-01-01 01:01:00','Y'), ('3','ä¸€èˆ¬ç”¨æˆ·','å…·æœ‰åŸºæœ¬æ•°æ®ç»´æŠ¤','system','2010-01-01 01:01:00','system','2010-01-01 01:01:00','Y'), ('4','ä¼ä¸šä¼šå‘˜','ä¼ä¸šç”¨æˆ·åŠŸèƒ½','system','2010-01-01 01:01:00','system','2010-01-01 01:01:00','Y'), ('5','ä¸ªäººä¼šå‘˜','ä¸ªäººç”¨æˆ·åŠŸèƒ½','system','2010-01-01 01:01:00','system','2010-01-01 01:01:00','Y');
INSERT INTO `t_da_sequence` VALUES ('advertise','1'), ('brand','1'), ('category','7'), ('city','1'), ('comments','1'), ('commodity','2'), ('commodityimage','2'), ('contact','1'), ('country','13'), ('history','1'), ('product','13'), ('productbrand','35'), ('province','31'), ('role','6'), ('sortable','53'), ('sort_order','73'), ('supplier','1'), ('supplierproduct','1'), ('user','3'), ('userrole','2');
INSERT INTO `t_da_sortable` VALUES ('1','1','60','C',NULL), ('2','2','61','C',NULL), ('3','3','62','C',NULL), ('4','4','63','C',NULL), ('5','5','64','C',NULL), ('6','6','59','C',NULL), ('7','1','66','P','1'), ('8','2','65','P','1'), ('9','3','67','P','1'), ('10','4','68','P','1'), ('11','5','11','P','2'), ('12','6','12','P','2'), ('13','7','13','P','2'), ('14','8','14','P','3'), ('15','9','15','P','3'), ('16','10','16','P','3'), ('17','11','17','P','3'), ('18','12','18','P','3'), ('19','2','19','B','7'), ('20','5','20','B','7'), ('21','6','21','B','7'), ('22','1','22','B','7'), ('23','8','23','B','7'), ('24','3','24','B','8'), ('25','5','25','B','8'), ('26','7','26','B','8'), ('27','8','27','B','8'), ('28','6','28','B','8'), ('29','2','29','B','9'), ('30','5','30','B','9'), ('31','1','31','B','9'), ('32','8','32','B','9'), ('33','6','33','B','9'), ('34','3','34','B','9'), ('35','4','35','B','7'), ('36','7','70','B','11'), ('37','6','71','B','11'), ('38','2','72','B','11'), ('39','1','69','B','11'), ('40','5','40','B','12'), ('41','4','41','B','12'), ('42','3','42','B','12'), ('43','5','43','B','16'), ('44','4','44','B','16'), ('45','5','45','B','17'), ('46','4','46','B','17'), ('47','3','47','B','17'), ('48','8','48','B','17'), ('49','2','49','B','18'), ('50','1','50','B','18'), ('51','5','51','B','18'), ('52','4','52','B','18');
INSERT INTO `t_da_user` VALUES ('1','admin','porkin@126.com','admin','2011-08-22 22:09:07','2010-09-15 20:13:55','9','System','2010-09-15 20:13:55','System','2010-09-15 20:13:55','Y'), ('2','abcd','test@125.com','abcd123','2011-07-18 19:55:06','2011-07-18 19:54:57','1','abcd','2011-07-18 19:54:57','abcd','2011-07-18 19:55:33','Y');
INSERT INTO `t_da_userrole` VALUES ('1','1'), ('2','5');
