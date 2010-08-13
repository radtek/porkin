
/* Drop Indexes */

DROP INDEX IDX_DA_PROVINCE ON T_DA_PROVINCE;



/* Drop Tables */

DROP TABLE T_DAT_CONTACT;
DROP TABLE T_DA_SUPPLIERPRODUCT;
DROP TABLE T_DA_PRODUCTBRAND;
DROP TABLE T_DA_BRAND;
DROP TABLE T_DA_PRODUCT;
DROP TABLE T_DA_CATEGORY;
DROP TABLE T_DA_SUPPLIER;
DROP TABLE T_DA_CITY;
DROP TABLE T_DA_COMMODITY;
DROP TABLE T_DA_COUNTRY;
DROP TABLE T_DA_PROVINCE;




/* Create Tables */

-- ��ϵ������
CREATE TABLE T_DAT_CONTACT
(
	CONTACT_ID INT NOT NULL AUTO_INCREMENT,
	CONTACT_CONTENT VARCHAR(30) NOT NULL,
	-- ��ϵ��ʽ: Q:qq, T: telphone, E: email, M: mobile
	CONTACT_TYPE CHAR(1) DEFAULT 'Q' NOT NULL COMMENT '��ϵ��ʽ: Q:qq, T: telphone, E: email, M: mobile',
	-- ������
	CREATED_BY VARCHAR(30) NOT NULL COMMENT '������',
	-- ����ʱ��
	CREATED_DATE DATETIME NOT NULL COMMENT '����ʱ��',
	-- ��������
	LASTUPDATED_BY VARCHAR(30) NOT NULL COMMENT '��������',
	-- ������ʱ��
	LASTUPDATED_DATE DATETIME NOT NULL COMMENT '������ʱ��',
	-- �����־λ
	ACTIVE_FLAG CHAR(1) NOT NULL COMMENT '�����־λ',
	SUPPLIER_ID INT NOT NULL,
	PRIMARY KEY (CONTACT_ID)
) COMMENT = '��ϵ������';


-- Ʒ����Ϣ��
CREATE TABLE T_DA_BRAND
(
	-- Ʒ��ϵͳ����
	BRAND_ID INT NOT NULL AUTO_INCREMENT COMMENT 'Ʒ��ϵͳ����',
	-- Ʒ��������
	BRAND_NAME VARCHAR(20) NOT NULL COMMENT 'Ʒ��������',
	-- Ʒ��Ӣ����
	BRAND_ENGLISH VARCHAR(20) NOT NULL COMMENT 'Ʒ��Ӣ����',
	-- ������
	CREATED_BY VARCHAR(30) NOT NULL COMMENT '������',
	-- ����ʱ��
	CREATED_DATE DATETIME NOT NULL COMMENT '����ʱ��',
	-- ��������
	LASTUPDATED_BY VARCHAR(30) NOT NULL COMMENT '��������',
	-- ������ʱ��
	LASTUPDATED_DATE DATETIME NOT NULL COMMENT '������ʱ��',
	-- �����־λ
	ACTIVE_FLAG CHAR(1) DEFAULT 'N' NOT NULL COMMENT '�����־λ',
	COUNTRY_ID INT NOT NULL,
	PRIMARY KEY (BRAND_ID)
) COMMENT = 'Ʒ����Ϣ��';


-- ��Ʒ�����Ϣ��
CREATE TABLE T_DA_CATEGORY
(
	-- ��Ʒ�����ϵͳ����
	CATEGORY_ID INT NOT NULL AUTO_INCREMENT COMMENT '��Ʒ�����ϵͳ����',
	-- ��Ʒ���������
	CATEGORY_NAME VARCHAR(20) NOT NULL COMMENT '��Ʒ���������',
	-- ������
	CREATED_BY VARCHAR(30) NOT NULL COMMENT '������',
	-- ����ʱ��
	CREATED_DATE DATETIME NOT NULL COMMENT '����ʱ��',
	-- ��������
	LASTUPDATED_BY VARCHAR(30) NOT NULL COMMENT '��������',
	-- ������ʱ��
	LASTUPDATED_DATE DATETIME NOT NULL COMMENT '������ʱ��',
	-- �����־λ
	ACTIVE_FLAG CHAR(1) DEFAULT 'N' NOT NULL COMMENT '�����־λ',
	PRIMARY KEY (CATEGORY_ID)
) COMMENT = '��Ʒ�����Ϣ��';


-- ������Ϣ������¼�г��еĻ�����Ϣ��
CREATE TABLE T_DA_CITY
(
	-- ����ϵͳ����
	CITY_ID INT NOT NULL AUTO_INCREMENT COMMENT '����ϵͳ����',
	-- ����������
	CITY_NAME VARCHAR(20) NOT NULL COMMENT '����������',
	CITY_ABBREVIATION VARCHAR(3),
	-- ������
	CREATED_BY VARCHAR(30) NOT NULL COMMENT '������',
	-- ����ʱ��
	CREATED_DATE DATETIME NOT NULL COMMENT '����ʱ��',
	-- ��������
	LASTUPDATED_BY VARCHAR(30) NOT NULL COMMENT '��������',
	-- ������ʱ��
	LASTUPDATED_DATE DATETIME NOT NULL COMMENT '������ʱ��',
	-- �����־λ
	ACTIVE_FLAG CHAR(1) COMMENT '�����־λ',
	-- ʡ�ݵ�ϵͳ����
	PROVINCE_ID INT NOT NULL COMMENT 'ʡ�ݵ�ϵͳ����',
	PRIMARY KEY (CITY_ID)
) COMMENT = '������Ϣ������¼�г��еĻ�����Ϣ��';


CREATE TABLE T_DA_COMMODITY
(
	COMMODITY_ID INT NOT NULL AUTO_INCREMENT,
	COMMODITY_NAME VARCHAR(30) NOT NULL,
	COMMODITY_DESCRIPTION VARCHAR(3000) NOT NULL,
	COMMODITY_IMAGE BLOB NOT NULL,
	-- ������
	CREATED_BY VARCHAR(30) NOT NULL COMMENT '������',
	-- ����ʱ��
	CREATED_DATE DATETIME NOT NULL COMMENT '����ʱ��',
	-- ��������
	LASTUPDATED_BY VARCHAR(30) NOT NULL COMMENT '��������',
	-- ������ʱ��
	LASTUPDATED_DATE DATETIME NOT NULL COMMENT '������ʱ��',
	-- �����־λ
	ACTIVE_FLAG CHAR(1) NOT NULL COMMENT '�����־λ',
	START_DATE DATETIME,
	END_DATE DATETIME,
	PRIMARY KEY (COMMODITY_ID)
);


CREATE TABLE T_DA_COUNTRY
(
	COUNTRY_ID INT NOT NULL AUTO_INCREMENT,
	-- ����������
	COUNTRY_NAME VARCHAR(30) NOT NULL COMMENT '����������',
	-- ��������ĸ��д
	COUNTRY_ABBREVIATION VARCHAR(5) NOT NULL COMMENT '��������ĸ��д',
	-- ������
	CREATED_BY VARCHAR(30) NOT NULL COMMENT '������',
	-- ����ʱ��
	CREATED_DATE DATETIME NOT NULL COMMENT '����ʱ��',
	-- ��������
	LASTUPDATED_BY VARCHAR(30) NOT NULL COMMENT '��������',
	-- ������ʱ��
	LASTUPDATED_DATE DATETIME NOT NULL COMMENT '������ʱ��',
	-- �����־λ
	ACTIVE_FLAG CHAR(1) DEFAULT 'N' NOT NULL COMMENT '�����־λ',
	PRIMARY KEY (COUNTRY_ID)
);


-- ��Ʒ��Ϣ��
CREATE TABLE T_DA_PRODUCT
(
	-- ��Ʒϵͳ����
	PRODUCT_ID INT NOT NULL AUTO_INCREMENT COMMENT '��Ʒϵͳ����',
	-- ��Ʒ������
	PRODUCT_NAME VARCHAR(20) NOT NULL COMMENT '��Ʒ������',
	-- ������
	CREATED_BY VARCHAR(30) NOT NULL COMMENT '������',
	-- ����ʱ��
	CREATED_DATE DATETIME NOT NULL COMMENT '����ʱ��',
	-- ��������
	LASTUPDATED_BY VARCHAR(30) NOT NULL COMMENT '��������',
	-- ������ʱ��
	LASTUPDATED_DATE DATETIME NOT NULL COMMENT '������ʱ��',
	-- �����־λ
	ACTIVE_FLAG CHAR(1) DEFAULT 'N' NOT NULL COMMENT '�����־λ',
	-- ��Ʒ�����ϵͳ����
	CATEGORY_ID INT NOT NULL COMMENT '��Ʒ�����ϵͳ����',
	PRIMARY KEY (PRODUCT_ID)
) COMMENT = '��Ʒ��Ϣ��';


-- Ʒ�Ʋ�Ʒ��Ϣ��
CREATE TABLE T_DA_PRODUCTBRAND
(
	-- Ʒ�Ʋ�Ʒϵͳ����
	PRODUCTBRAND_ID INT NOT NULL AUTO_INCREMENT COMMENT 'Ʒ�Ʋ�Ʒϵͳ����',
	-- Ʒ��ϵͳ����
	BRAND_ID INT NOT NULL COMMENT 'Ʒ��ϵͳ����',
	-- ��Ʒϵͳ����
	PRODUCT_ID INT NOT NULL COMMENT '��Ʒϵͳ����',
	-- ������
	CREATED_BY VARCHAR(30) COMMENT '������',
	-- ����ʱ��
	CREATED_DATE DATETIME COMMENT '����ʱ��',
	-- ��������
	LASTUPDATED_BY VARCHAR(30) COMMENT '��������',
	-- ������ʱ��
	LASTUPDATED_DATE DATETIME COMMENT '������ʱ��',
	-- �����־λ
	ACTIVE_FLAG CHAR(1) COMMENT '�����־λ',
	PRIMARY KEY (PRODUCTBRAND_ID)
) COMMENT = 'Ʒ�Ʋ�Ʒ��Ϣ��';


-- ʡ����Ϣ������¼�й�ÿ��ʡ�Ļ�����Ϣ��
CREATE TABLE T_DA_PROVINCE
(
	-- ʡ�ݵ�ϵͳ����
	PROVINCE_ID INT NOT NULL AUTO_INCREMENT COMMENT 'ʡ�ݵ�ϵͳ����',
	-- ʡ�ݵ��������ƣ�������ʡ��
	PROVINCE_NAME VARCHAR(20) NOT NULL COMMENT 'ʡ�ݵ��������ƣ�������ʡ��',
	-- ʡ�ݵ���ĸ��д,������ʡΪLN,��Ϊ��д
	PROVINCE_ABBREVIATION VARCHAR(3) NOT NULL COMMENT 'ʡ�ݵ���ĸ��д,������ʡΪLN,��Ϊ��д',
	-- ����ʱ��
	CREATED_DATE DATETIME NOT NULL COMMENT '����ʱ��',
	-- ������
	CREATED_BY VARCHAR(30) NOT NULL COMMENT '������',
	-- ������ʱ��
	LASTUPDATED_DATE DATETIME NOT NULL COMMENT '������ʱ��',
	-- ��������
	LASTUPDATED_BY VARCHAR(30) NOT NULL COMMENT '��������',
	-- �����־λ
	ACTIVE_FLAG CHAR(1) DEFAULT 'N' NOT NULL COMMENT '�����־λ',
	PRIMARY KEY (PROVINCE_ID)
) ENGINE = InnoDB COMMENT = 'ʡ����Ϣ������¼�й�ÿ��ʡ�Ļ�����Ϣ��' DEFAULT CHARACTER SET utf8;


-- ��������Ϣ��û�����.
CREATE TABLE T_DA_SUPPLIER
(
	SUPPLIER_ID INT NOT NULL AUTO_INCREMENT,
	SUPPLIER_NAME VARCHAR(20),
	-- ����ϵͳ����
	CITY_ID INT NOT NULL COMMENT '����ϵͳ����',
	-- ������
	CREATED_BY VARCHAR(30) COMMENT '������',
	-- ����ʱ��
	CREATED_DATE DATETIME COMMENT '����ʱ��',
	-- ��������
	LASTUPDATED_BY VARCHAR(30) COMMENT '��������',
	-- ������ʱ��
	LASTUPDATED_DATE DATETIME COMMENT '������ʱ��',
	-- �����־λ
	ACTIVE_FLAG CHAR(1) COMMENT '�����־λ',
	PRIMARY KEY (SUPPLIER_ID)
) COMMENT = '��������Ϣ��û�����.';


CREATE TABLE T_DA_SUPPLIERPRODUCT
(
	SUPPLIER_ID INT NOT NULL,
	-- Ʒ�Ʋ�Ʒϵͳ����
	PRODUCTBRAND_ID INT NOT NULL COMMENT 'Ʒ�Ʋ�Ʒϵͳ����',
	PRIMARY KEY (SUPPLIER_ID, PRODUCTBRAND_ID)
);



/* Create Foreign Keys */

ALTER TABLE T_DA_PRODUCTBRAND
	ADD FOREIGN KEY (BRAND_ID)
	REFERENCES T_DA_BRAND (BRAND_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE T_DA_PRODUCT
	ADD FOREIGN KEY (CATEGORY_ID)
	REFERENCES T_DA_CATEGORY (CATEGORY_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE T_DA_SUPPLIER
	ADD FOREIGN KEY (CITY_ID)
	REFERENCES T_DA_CITY (CITY_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE T_DA_BRAND
	ADD FOREIGN KEY (COUNTRY_ID)
	REFERENCES T_DA_COUNTRY (COUNTRY_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE T_DA_PRODUCTBRAND
	ADD FOREIGN KEY (PRODUCT_ID)
	REFERENCES T_DA_PRODUCT (PRODUCT_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE T_DA_SUPPLIERPRODUCT
	ADD FOREIGN KEY (PRODUCTBRAND_ID)
	REFERENCES T_DA_PRODUCTBRAND (PRODUCTBRAND_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE T_DA_CITY
	ADD FOREIGN KEY (PROVINCE_ID)
	REFERENCES T_DA_PROVINCE (PROVINCE_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE T_DAT_CONTACT
	ADD FOREIGN KEY (SUPPLIER_ID)
	REFERENCES T_DA_SUPPLIER (SUPPLIER_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE T_DA_SUPPLIERPRODUCT
	ADD FOREIGN KEY (SUPPLIER_ID)
	REFERENCES T_DA_SUPPLIER (SUPPLIER_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



/* Create Indexes */

CREATE INDEX IDX_DA_PROVINCE USING BTREE ON T_DA_PROVINCE (PROVINCE_ID ASC);


