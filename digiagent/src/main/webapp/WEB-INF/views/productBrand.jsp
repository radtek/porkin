﻿<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>品牌产品信息维护</title>
	<link rel="stylesheet" type="text/css" href="../styles/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../styles/icon.css">
	<script type="text/javascript" src="../scripts/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="../scripts/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../scripts/jquery.form.js"></script>
	<script type="text/javascript" src="../scripts/service/productBrand.js"></script>
	<script type="text/javascript" src="../scripts/common/datetime.js"></script>
</head>
<body>
	<table id="productBrandList"></table>
	<div id="productBrandEdit" icon="icon-edit" style="width:400px;height:200px;display:none">
		<div style="background:#fafafa;padding:10px;text-align:center">
		<form id="productBrandForm" action="../productBrand/create" method="post"> 
		  <div>
		  		<label for="name">国家:</label>
		  		<input type="hidden" name="productbrandId"/>
              	<select id="countryId" name="countryId"> 
              	</select>
              	<label for="name">品牌:</label>
              	<select id="brandId" name="brandId"> 
              	</select>
          </div>
          <div>
          		<label for="name">类别:</label>
              	<select id="categoryId" name="categoryId"> 
              	</select>
              	<label for="name">产品:</label>
              	<select id="productId" name="productId"> 
              	</select>
          </div> 
          <div>
              	<label for="name">状态:</label>
              	<select class="easyui-validatebox" id="activeFlag" name="activeFlag"> 
                      <option value="Y">开启</option> 
                      <option value="N">禁用</option>
              	</select>
          </div>
          <div>
              <input type="submit"  name="submitButton" value="确定" /> 
              <input type="reset"   name="resetButton " value="重置" />
          </div> 
      </form> 
      </div>
	</div>
</body>
</html>