﻿<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="common/common.jsp" %>
<html>
<head>
	<script type="text/javascript" src="../scripts/service/brand.js"></script>
</head>
<body>
	<table id="brandList"></table>
	<div id="brandEdit" icon="icon-edit" style="width:400px;height:200px;display:none">
		<div style="background:#fafafa;padding:10px;text-align:center">
		<form id="brandForm" action="../brand/create" method="post"> 
		  <div>
              	<label for="name">国家:</label>
              	<select id="countryId" name="countryId"> 
              	</select>
          </div>
          <div>
              	<label for="name">品牌中文名:</label>
              	<input type="hidden" name="brandId"/>
              	<input class="easyui-validatebox" type="text" name="brandName" maxlength="20"/>
          </div> 
          <div>
              	<label for="name">品牌英文名:</label>
              	<input class="easyui-validatebox" type="text" name="brandEnglish" maxlength="20"/>
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