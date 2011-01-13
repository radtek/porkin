-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2010 年 12 月 26 日 07:13
-- 服务器版本: 5.1.41
-- PHP 版本: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `digiagent`
--

-- --------------------------------------------------------

--
-- 表的结构 `t_da_brand`
--

CREATE TABLE IF NOT EXISTS `t_da_brand` (
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
  KEY `COUNTRY_ID` (`COUNTRY_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='品牌信息表' AUTO_INCREMENT=5 ;


-- --------------------------------------------------------

--
-- 表的结构 `t_da_category`
--

CREATE TABLE IF NOT EXISTS `t_da_category` (
  `CATEGORY_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '产品类别名系统主键',
  `CATEGORY_NAME` varchar(20) NOT NULL COMMENT '产品类别中文名',
  `CREATED_BY` varchar(30) NOT NULL COMMENT '创建者',
  `CREATED_DATE` datetime NOT NULL COMMENT '创建时间',
  `LASTUPDATED_BY` varchar(30) NOT NULL COMMENT '最后更新者',
  `LASTUPDATED_DATE` datetime NOT NULL COMMENT '最后更新时间',
  `ACTIVE_FLAG` char(1) NOT NULL DEFAULT 'N' COMMENT '激活标志位',
  PRIMARY KEY (`CATEGORY_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='产品类别信息表' AUTO_INCREMENT=6 ;


-- --------------------------------------------------------

--
-- 表的结构 `t_da_city`
--

CREATE TABLE IF NOT EXISTS `t_da_city` (
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
  KEY `PROVINCE_ID` (`PROVINCE_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='城市信息表，记录中城市的基本信息。' AUTO_INCREMENT=3 ;



-- --------------------------------------------------------

--
-- 表的结构 `t_da_comments`
--

CREATE TABLE IF NOT EXISTS `t_da_comments` (
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
  KEY `USER_ID` (`USER_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='商家评价信息' AUTO_INCREMENT=10 ;



-- --------------------------------------------------------

--
-- 表的结构 `t_da_commodity`
--

CREATE TABLE IF NOT EXISTS `t_da_commodity` (
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
  KEY `USER_ID` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品信息表' AUTO_INCREMENT=1 ;


-- --------------------------------------------------------

--
-- 表的结构 `t_da_commodityimage`
--

CREATE TABLE IF NOT EXISTS `t_da_commodityimage` (
  `COMMODITYIMAGE_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '商品图像系统主键',
  `COMMODITYIMAGE_CONTENT` blob NOT NULL COMMENT '商品图像内容',
  `CREATED_BY` varchar(30) DEFAULT NULL COMMENT '创建者',
  `CREATED_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `LASTUPDATED_BY` varchar(30) DEFAULT NULL COMMENT '最后更新者',
  `LASTUPDATED_DATE` datetime DEFAULT NULL COMMENT '最后更新时间',
  `ACTIVE_FLAG` char(1) DEFAULT NULL COMMENT '激活标志位',
  `COMMODITY_ID` int(10) unsigned NOT NULL COMMENT '商品系统主键',
  PRIMARY KEY (`COMMODITYIMAGE_ID`),
  KEY `COMMODITY_ID` (`COMMODITY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品图像表' AUTO_INCREMENT=1 ;


-- --------------------------------------------------------

--
-- 表的结构 `t_da_contact`
--

CREATE TABLE IF NOT EXISTS `t_da_contact` (
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
  KEY `SUPPLIER_ID` (`SUPPLIER_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='联系方法表' AUTO_INCREMENT=4 ;



-- --------------------------------------------------------

--
-- 表的结构 `t_da_country`
--

CREATE TABLE IF NOT EXISTS `t_da_country` (
  `COUNTRY_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '国家信息的系统主键',
  `COUNTRY_NAME` varchar(30) NOT NULL COMMENT '国家中文名',
  `COUNTRY_ABBREVIATION` varchar(5) NOT NULL COMMENT '国家名字母缩写',
  `CREATED_BY` varchar(30) NOT NULL COMMENT '创建者',
  `CREATED_DATE` datetime NOT NULL COMMENT '创建时间',
  `LASTUPDATED_BY` varchar(30) NOT NULL COMMENT '最后更新者',
  `LASTUPDATED_DATE` datetime NOT NULL COMMENT '最后更新时间',
  `ACTIVE_FLAG` char(1) NOT NULL DEFAULT 'N' COMMENT '激活标志位',
  PRIMARY KEY (`COUNTRY_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='国家信息表' AUTO_INCREMENT=14 ;

--
-- 转存表中的数据 `t_da_country`
--

INSERT INTO `t_da_country` (`COUNTRY_ID`, `COUNTRY_NAME`, `COUNTRY_ABBREVIATION`, `CREATED_BY`, `CREATED_DATE`, `LASTUPDATED_BY`, `LASTUPDATED_DATE`, `ACTIVE_FLAG`) VALUES
(1, '中国', 'CN', 'System', '2010-09-15 18:54:00', 'System', '2010-09-15 18:54:00', 'Y'),
(2, '日本', 'JP', 'System', '2010-09-15 18:54:25', 'System', '2010-09-15 18:54:25', 'Y'),
(3, '美国', 'US', 'System', '2010-09-15 18:54:49', 'System', '2010-09-15 18:54:49', 'Y'),
(4, '中国台湾省', 'TW', 'System', '2010-09-15 19:26:59', 'System', '2010-09-15 19:30:38', 'Y'),
(5, '韩国 ', 'KP', 'System', '2010-09-15 19:28:33', 'System', '2010-09-15 19:28:33', 'Y'),
(6, '中国香港特区', 'HK', 'System', '2010-09-15 19:28:50', 'System', '2010-09-15 19:28:50', 'Y'),
(7, '加拿大', 'CA', 'System', '2010-09-15 19:29:12', 'System', '2010-09-15 19:29:12', 'Y'),
(8, '法国 ', 'FR', 'System', '2010-09-15 19:29:37', 'System', '2010-09-15 19:29:37', 'Y'),
(9, '荷兰', 'NL', 'System', '2010-09-15 19:30:14', 'System', '2010-09-15 19:30:14', 'Y'),
(10, '英国 ', 'UK', 'System', '2010-09-15 19:30:56', 'System', '2010-09-15 19:30:56', 'Y'),
(11, '新加坡', 'SG', 'System', '2010-09-15 19:31:25', 'System', '2010-09-15 19:31:25', 'Y'),
(12, '德国', 'DE', 'System', '2010-09-15 19:31:47', 'System', '2010-09-15 19:31:47', 'Y'),
(13, '澳大利亚', 'AU', 'admin', '2010-10-17 22:28:42', 'admin', '2010-10-17 22:28:42', 'Y');

-- --------------------------------------------------------

--
-- 表的结构 `t_da_history`
--

CREATE TABLE IF NOT EXISTS `t_da_history` (
  `HISTORY_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '访问历史系统主键',
  `HISTORY_TYPE` char(1) NOT NULL COMMENT '访问内容类型(B:品牌,C:大类,P:产品,E:品牌产品,S:供应商)',
  `HISTORY_TYPEID` int(10) unsigned NOT NULL COMMENT '所对应的ID,如产品ID,供应商ID',
  `HISTORY_ACCESSDATE` datetime NOT NULL COMMENT '访问时间',
  `HISTORY_FROMIP` varchar(128) NOT NULL DEFAULT '255.255.255.255',
  PRIMARY KEY (`HISTORY_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='访问历史表' AUTO_INCREMENT=244 ;



--
-- 表的结构 `t_da_product`
--

CREATE TABLE IF NOT EXISTS `t_da_product` (
  `PRODUCT_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '产品系统主键',
  `PRODUCT_NAME` varchar(20) NOT NULL COMMENT '产品中文名',
  `CREATED_BY` varchar(30) NOT NULL COMMENT '创建者',
  `CREATED_DATE` datetime NOT NULL COMMENT '创建时间',
  `LASTUPDATED_BY` varchar(30) NOT NULL COMMENT '最后更新者',
  `LASTUPDATED_DATE` datetime NOT NULL COMMENT '最后更新时间',
  `ACTIVE_FLAG` char(1) NOT NULL DEFAULT 'N' COMMENT '激活标志位',
  `CATEGORY_ID` int(10) unsigned NOT NULL COMMENT '产品类别名系统主键',
  PRIMARY KEY (`PRODUCT_ID`),
  KEY `CATEGORY_ID` (`CATEGORY_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='产品信息表' AUTO_INCREMENT=8 ;


-- --------------------------------------------------------

--
-- 表的结构 `t_da_productbrand`
--

CREATE TABLE IF NOT EXISTS `t_da_productbrand` (
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
  KEY `PRODUCT_ID` (`PRODUCT_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='品牌产品关系表' AUTO_INCREMENT=7 ;



-- --------------------------------------------------------

--
-- 表的结构 `t_da_province`
--

CREATE TABLE IF NOT EXISTS `t_da_province` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='省份信息表，记录中国每个省的基本信息。' AUTO_INCREMENT=32 ;

--
-- 转存表中的数据 `t_da_province`
--

INSERT INTO `t_da_province` (`PROVINCE_ID`, `PROVINCE_NAME`, `PROVINCE_ABBREVIATION`, `CREATED_BY`, `CREATED_DATE`, `LASTUPDATED_BY`, `LASTUPDATED_DATE`, `ACTIVE_FLAG`) VALUES
(1, '北京市', 'BJ', 'System', '2010-09-15 18:57:24', 'System', '2010-09-15 18:57:24', 'Y'),
(2, '天津市', 'TJ', 'System', '2010-09-15 18:57:47', 'System', '2010-09-15 18:57:47', 'Y'),
(3, '上海市', 'SH', 'System', '2010-09-15 18:58:04', 'System', '2010-09-15 18:58:04', 'Y'),
(4, '重庆市', 'CQ', 'System', '2010-09-15 18:58:16', 'System', '2010-09-15 18:58:16', 'Y'),
(5, '河北省', 'HE', 'System', '2010-09-15 18:58:30', 'System', '2010-09-15 19:06:22', 'Y'),
(6, '河南省', 'HA', 'System', '2010-09-15 18:58:47', 'System', '2010-09-15 19:06:46', 'Y'),
(7, '云南省', 'YN', 'System', '2010-09-15 18:59:03', 'System', '2010-09-15 18:59:03', 'Y'),
(8, '辽宁省', 'LN', 'System', '2010-09-15 18:59:17', 'System', '2010-09-15 18:59:17', 'Y'),
(9, '黑龙江省', 'HL', 'System', '2010-09-15 18:59:35', 'System', '2010-09-15 19:07:13', 'Y'),
(10, '安徽省', 'AH', 'System', '2010-09-15 19:01:48', 'System', '2010-09-15 19:01:48', 'Y'),
(11, '福建省', 'FJ', 'System', '2010-09-15 19:02:26', 'System', '2010-09-15 19:02:26', 'Y'),
(12, '甘肃省', 'GS', 'System', '2010-09-15 19:02:49', 'System', '2010-09-15 19:02:49', 'Y'),
(13, '广东省', 'GD', 'System', '2010-09-15 19:03:06', 'System', '2010-09-15 19:03:06', 'Y'),
(14, '广西壮族自治区', 'GX', 'System', '2010-09-15 19:04:34', 'System', '2010-09-15 19:04:34', 'Y'),
(15, '贵州省', 'GZ', 'System', '2010-09-15 19:05:22', 'System', '2010-09-15 19:05:22', 'Y'),
(16, '海南省', 'HI', 'System', '2010-09-15 19:05:54', 'System', '2010-09-15 19:05:54', 'Y'),
(17, '湖北省', 'HB', 'System', '2010-09-15 19:07:32', 'System', '2010-09-15 19:07:32', 'Y'),
(18, '湖南省', 'HN', 'System', '2010-09-15 19:07:50', 'System', '2010-09-15 19:07:50', 'Y'),
(19, '吉林省', 'JL', 'System', '2010-09-15 19:08:08', 'System', '2010-09-15 19:08:08', 'Y'),
(20, '江苏省', 'JS', 'System', '2010-09-15 19:08:27', 'System', '2010-09-15 19:08:27', 'Y'),
(21, '江西省', 'JX', 'System', '2010-09-15 19:08:45', 'System', '2010-09-15 19:08:45', 'Y'),
(22, '内蒙古自治区', 'NM', 'System', '2010-09-15 19:09:18', 'System', '2010-09-15 19:09:18', 'Y'),
(23, '宁夏回族自治区', 'NX', 'System', '2010-09-15 19:10:03', 'System', '2010-09-15 19:10:03', 'Y'),
(24, '青海省', 'QH', 'System', '2010-09-15 19:10:20', 'System', '2010-09-15 19:10:20', 'Y'),
(25, '山东省', 'SD', 'System', '2010-09-15 19:10:42', 'System', '2010-09-15 19:10:42', 'Y'),
(26, '山西省', 'SX', 'System', '2010-09-15 19:10:59', 'System', '2010-09-15 19:10:59', 'Y'),
(27, '陕西省', 'SN', 'System', '2010-09-15 19:11:34', 'System', '2010-09-15 19:11:34', 'Y'),
(28, '四川省', 'SC', 'System', '2010-09-15 19:11:58', 'System', '2010-09-15 19:11:58', 'Y'),
(29, '新疆维吾尔族自治区', 'XJ', 'System', '2010-09-15 19:12:36', 'System', '2010-09-15 19:12:36', 'Y'),
(31, '西藏自治区', 'XZ', 'admin', '2010-10-17 22:21:45', 'admin', '2010-10-17 22:21:45', 'Y');

-- --------------------------------------------------------

--
-- 表的结构 `t_da_role`
--

CREATE TABLE IF NOT EXISTS `t_da_role` (
  `ROLE_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '角色系统主键',
  `ROLE_NAME` varchar(30) NOT NULL COMMENT '角色名称',
  `ROLE_DESCRIPTION` varchar(300) NOT NULL COMMENT '角色描述',
  `CREATED_BY` varchar(30) NOT NULL COMMENT '创建者',
  `CREATED_DATE` datetime NOT NULL COMMENT '创建时间',
  `LASTUPDATED_BY` varchar(30) NOT NULL COMMENT '最后更新者',
  `LASTUPDATED_DATE` datetime NOT NULL COMMENT '最后更新时间',
  `ACTIVE_FLAG` char(1) NOT NULL DEFAULT 'N' COMMENT '激活标志位',
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='角色信息表' AUTO_INCREMENT=6 ;

--
-- 转存表中的数据 `t_da_role`
--

INSERT INTO `t_da_role` (`ROLE_ID`, `ROLE_NAME`, `ROLE_DESCRIPTION`, `CREATED_BY`, `CREATED_DATE`, `LASTUPDATED_BY`, `LASTUPDATED_DATE`, `ACTIVE_FLAG`) VALUES
(1, '系统管理员', '具有所有的后台权限', 'system', '2010-01-01 01:01:00', 'system', '2010-01-01 01:01:00', 'Y'),
(2, '超级用户', '具有基本数据维护和报表权限', 'system', '2010-01-01 01:01:00', 'system', '2010-01-01 01:01:00', 'Y'),
(3, '一般用户', '具有基本数据维护', 'system', '2010-01-01 01:01:00', 'system', '2010-01-01 01:01:00', 'Y'),
(4, '企业会员', '企业用户功能', 'system', '2010-01-01 01:01:00', 'system', '2010-01-01 01:01:00', 'Y'),
(5, '个人会员', '个人用户功能', 'system', '2010-01-01 01:01:00', 'system', '2010-01-01 01:01:00', 'Y');

-- --------------------------------------------------------

--
-- 表的结构 `t_da_sequence`
--

CREATE TABLE IF NOT EXISTS `t_da_sequence` (
  `NAME` varchar(30) NOT NULL COMMENT '系统主键名',
  `NEXTID` int(10) unsigned NOT NULL COMMENT '系统主键值',
  PRIMARY KEY (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='主要用于系统主键ID生成.';

--
-- 转存表中的数据 `t_da_sequence`
--

INSERT INTO `t_da_sequence` (`NAME`, `NEXTID`) VALUES
('brand', 1),
('category', 1),
('city', 1),
('comments', 1),
('commodity', 1),
('commodityimage', 1),
('contact', 1),
('country', 14),
('history', 1),
('product', 1),
('productbrand', 1),
('province', 32),
('role', 6),
('sortable', 1),
('sort_order', 1),
('supplier', 1),
('supplierproduct', 1),
('user', 2),
('userrole', 2);

-- --------------------------------------------------------

--
-- 表的结构 `t_da_sortable`
--

CREATE TABLE IF NOT EXISTS `t_da_sortable` (
  `SORTABLE_ID` int(11) NOT NULL COMMENT '排序表系统的主键',
  `SORTABLE_KEY` int(11) NOT NULL COMMENT '需要排序的表的系统工主键，主要来源于category,brand,product',
  `SORTABLE_ORDER` int(11) NOT NULL DEFAULT '0' COMMENT '所对应的排序位',
  `SORTABLE_TYPE` char(1) NOT NULL COMMENT '所对应的排序类型, C为category, B为Brand, P为Product',
  `PARENT_ID` int(11) DEFAULT NULL COMMENT '排序表系统的主键',
  PRIMARY KEY (`SORTABLE_ID`),
  KEY `FK_PARENT` (`PARENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='排序表';



-- --------------------------------------------------------

--
-- 表的结构 `t_da_supplier`
--

CREATE TABLE IF NOT EXISTS `t_da_supplier` (
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
  KEY `USER_ID` (`USER_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='代理商信息，没有完成.' AUTO_INCREMENT=3 ;



-- --------------------------------------------------------

--
-- 表的结构 `t_da_supplierproduct`
--

CREATE TABLE IF NOT EXISTS `t_da_supplierproduct` (
  `SUPPLIER_ID` int(10) unsigned NOT NULL COMMENT '供应商系统主键',
  `PRODUCTBRAND_ID` int(10) unsigned NOT NULL COMMENT '品牌产品系统主键',
  `CREATE_DATE` date DEFAULT NULL COMMENT '供应商产品代理开始时间',
  `START_DATE` date DEFAULT NULL COMMENT '供应商产品代理开始时间',
  `END_DATE` date DEFAULT NULL COMMENT '供应商产品代理结束时间',
  PRIMARY KEY (`SUPPLIER_ID`,`PRODUCTBRAND_ID`),
  KEY `PRODUCTBRAND_ID` (`PRODUCTBRAND_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供应商与品牌产品关系表';


-- --------------------------------------------------------

--
-- 表的结构 `t_da_user`
--

CREATE TABLE IF NOT EXISTS `t_da_user` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='用户信息表' AUTO_INCREMENT=11 ;

--
-- 转存表中的数据 `t_da_user`
--

INSERT INTO `t_da_user` (`USER_ID`, `USER_NAME`, `USER_EMAIL`, `USER_PASSWORD`, `LASTLOGINTIME`, `REGISTERTIME`, `LOGONSUM`, `CREATED_BY`, `CREATED_DATE`, `LASTUPDATED_BY`, `LASTUPDATED_DATE`, `ACTIVE_FLAG`) VALUES
(1, 'admin', 'porkin@126.com', 'admin', '2010-12-22 21:27:44', '2010-09-15 20:13:55', 93, 'System', '2010-09-15 20:13:55', 'System', '2010-09-15 20:13:55', 'Y');

-- --------------------------------------------------------

--
-- 表的结构 `t_da_userrole`
--

CREATE TABLE IF NOT EXISTS `t_da_userrole` (
  `USER_ID` int(10) unsigned NOT NULL COMMENT '用户系统主键',
  `ROLE_ID` int(10) unsigned NOT NULL COMMENT '角色系统主键',
  KEY `ROLE_ID` (`ROLE_ID`),
  KEY `USER_ID` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户和角色关系表';

--
-- 转存表中的数据 `t_da_userrole`
--

INSERT INTO `t_da_userrole` (`USER_ID`, `ROLE_ID`) VALUES
(1, 1);

--
-- 限制导出的表
--

--
-- 限制表 `t_da_brand`
--
ALTER TABLE `t_da_brand`
  ADD CONSTRAINT `t_da_brand_ibfk_1` FOREIGN KEY (`COUNTRY_ID`) REFERENCES `t_da_country` (`COUNTRY_ID`);

--
-- 限制表 `t_da_city`
--
ALTER TABLE `t_da_city`
  ADD CONSTRAINT `t_da_city_ibfk_1` FOREIGN KEY (`PROVINCE_ID`) REFERENCES `t_da_province` (`PROVINCE_ID`);

--
-- 限制表 `t_da_comments`
--
ALTER TABLE `t_da_comments`
  ADD CONSTRAINT `t_da_comments_ibfk_1` FOREIGN KEY (`SUPPLIER_ID`) REFERENCES `t_da_supplier` (`SUPPLIER_ID`),
  ADD CONSTRAINT `t_da_comments_ibfk_2` FOREIGN KEY (`USER_ID`) REFERENCES `t_da_user` (`USER_ID`);

--
-- 限制表 `t_da_commodity`
--
ALTER TABLE `t_da_commodity`
  ADD CONSTRAINT `t_da_commodity_ibfk_1` FOREIGN KEY (`USER_ID`) REFERENCES `t_da_user` (`USER_ID`);

--
-- 限制表 `t_da_commodityimage`
--
ALTER TABLE `t_da_commodityimage`
  ADD CONSTRAINT `t_da_commodityimage_ibfk_1` FOREIGN KEY (`COMMODITY_ID`) REFERENCES `t_da_commodity` (`COMMODITY_ID`);

--
-- 限制表 `t_da_contact`
--
ALTER TABLE `t_da_contact`
  ADD CONSTRAINT `t_da_contact_ibfk_1` FOREIGN KEY (`SUPPLIER_ID`) REFERENCES `t_da_supplier` (`SUPPLIER_ID`);

--
-- 限制表 `t_da_product`
--
ALTER TABLE `t_da_product`
  ADD CONSTRAINT `t_da_product_ibfk_1` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `t_da_category` (`CATEGORY_ID`);

--
-- 限制表 `t_da_productbrand`
--
ALTER TABLE `t_da_productbrand`
  ADD CONSTRAINT `t_da_productbrand_ibfk_1` FOREIGN KEY (`BRAND_ID`) REFERENCES `t_da_brand` (`BRAND_ID`),
  ADD CONSTRAINT `t_da_productbrand_ibfk_2` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `t_da_product` (`PRODUCT_ID`);

--
-- 限制表 `t_da_sortable`
--
ALTER TABLE `t_da_sortable`
  ADD CONSTRAINT `t_da_sortable_ibfk_1` FOREIGN KEY (`PARENT_ID`) REFERENCES `t_da_sortable` (`SORTABLE_ID`) ON DELETE CASCADE;

--
-- 限制表 `t_da_supplier`
--
ALTER TABLE `t_da_supplier`
  ADD CONSTRAINT `t_da_supplier_ibfk_1` FOREIGN KEY (`CITY_ID`) REFERENCES `t_da_city` (`CITY_ID`),
  ADD CONSTRAINT `t_da_supplier_ibfk_2` FOREIGN KEY (`USER_ID`) REFERENCES `t_da_user` (`USER_ID`);

--
-- 限制表 `t_da_supplierproduct`
--
ALTER TABLE `t_da_supplierproduct`
  ADD CONSTRAINT `t_da_supplierproduct_ibfk_1` FOREIGN KEY (`PRODUCTBRAND_ID`) REFERENCES `t_da_productbrand` (`PRODUCTBRAND_ID`),
  ADD CONSTRAINT `t_da_supplierproduct_ibfk_2` FOREIGN KEY (`SUPPLIER_ID`) REFERENCES `t_da_supplier` (`SUPPLIER_ID`);

--
-- 限制表 `t_da_userrole`
--
ALTER TABLE `t_da_userrole`
  ADD CONSTRAINT `t_da_userrole_ibfk_1` FOREIGN KEY (`ROLE_ID`) REFERENCES `t_da_role` (`ROLE_ID`),
  ADD CONSTRAINT `t_da_userrole_ibfk_2` FOREIGN KEY (`USER_ID`) REFERENCES `t_da_user` (`USER_ID`);
  
 

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
