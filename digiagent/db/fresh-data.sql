-- sequence
insert into t_da_sequence(name,nextid) value('brand',1);
insert into t_da_sequence(name,nextid) value('category',1);
insert into t_da_sequence(name,nextid) value('city',1);
insert into t_da_sequence(name,nextid) value('commodity',1);
insert into t_da_sequence(name,nextid) value('commodityimage',1);
insert into t_da_sequence(name,nextid) value('contact',1);
insert into t_da_sequence(name,nextid) value('country',13);
insert into t_da_sequence(name,nextid) value('history',1);
insert into t_da_sequence(name,nextid) value('product',1);
insert into t_da_sequence(name,nextid) value('productbrand',1);
insert into t_da_sequence(name,nextid) value('province',31);
insert into t_da_sequence(name,nextid) value('role',6);
insert into t_da_sequence(name,nextid) value('supplier',1);
insert into t_da_sequence(name,nextid) value('supplierproduct',1);
insert into t_da_sequence(name,nextid) value('user',2);
insert into t_da_sequence(name,nextid) value('userrole',2);
insert into t_da_sequence(name,nextid) value('comments',1);
insert into t_da_sequence(name,nextid) value('advertise',1);

-- country
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
(12, '德国', 'DE', 'System', '2010-09-15 19:31:47', 'System', '2010-09-15 19:31:47', 'Y');

-- province
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
(30, '西藏自治区', 'XZ', 'System', '2010-09-15 19:13:07', 'System', '2010-09-15 19:13:07', 'Y');

-- role
INSERT INTO `t_da_role` (`ROLE_ID`, `ROLE_NAME`, `ROLE_DESCRIPTION`, `CREATED_BY`, `CREATED_DATE`, `LASTUPDATED_BY`, `LASTUPDATED_DATE`, `ACTIVE_FLAG`) VALUES
(1, '系统管理员', '具有所有的后台权限', 'system', '2010-01-01 01:01:00', 'system', '2010-01-01 01:01:00', 'Y'),
(2, '超级用户', '具有基本数据维护和报表权限', 'system', '2010-01-01 01:01:00', 'system', '2010-01-01 01:01:00', 'Y'),
(3, '一般用户', '具有基本数据维护', 'system', '2010-01-01 01:01:00', 'system', '2010-01-01 01:01:00', 'Y'),
(4, '企业会员', '企业用户功能', 'system', '2010-01-01 01:01:00', 'system', '2010-01-01 01:01:00', 'Y'),
(5, '个人会员', '个人用户功能', 'system', '2010-01-01 01:01:00', 'system', '2010-01-01 01:01:00', 'Y');

-- user
INSERT INTO `t_da_user` (`USER_ID`, `USER_NAME`, `USER_EMAIL`, `USER_PASSWORD`, `LASTLOGINTIME`, `REGISTERTIME`, `LOGONSUM`, `CREATED_BY`, `CREATED_DATE`, `LASTUPDATED_BY`, `LASTUPDATED_DATE`, `ACTIVE_FLAG`) VALUES
(1, 'admin', 'porkin@126.com', 'admin', '2010-09-15 20:13:55', '2010-09-15 20:13:55', 0, 'System', '2010-09-15 20:13:55', 'System', '2010-09-15 20:13:55', 'Y');

-- roleuser
INSERT INTO `t_da_userrole` (`USER_ID`, `ROLE_ID`) VALUES
(1, 1);



