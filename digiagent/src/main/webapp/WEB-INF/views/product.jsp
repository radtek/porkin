<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="common/common.jsp" %>
<html>
<head>
	<script type="text/javascript" src="../scripts/service/product.js"></script>
</head>
<body>
	<div><label for="name">类别:</label><select id="categoryId" name="categoryId"> </select>
	<label for="name">产品名:</label><input id="productName" name="productName" />
	<input type="button" value="查询" onclick="search()"/></div>
	<table id="productList"></table>
	<div id="productEdit" icon="icon-edit" style="width:400px;height:220px;display:none">
		<div style="background:#fafafa;padding:10px;text-align:center">
		<form id="productForm" action="../product/search" method="post"> 
		  <div>
              	<label for="name">类别:</label>
              	<select id="categoryId" name="categoryId"> 
              	</select>
          </div>
          <div>
              	<label for="name">产品名:</label>
              	<input type="hidden" name="productId"/>
              	<input class="easyui-validatebox" type="text" name="productName" maxlength="20"/>
          </div>
          <div>
              	<label for="name">显示方式:</label>
              	<select class="easyui-validatebox" id="displayType" name="displayType"> 
              		<option value="1">导购</option>
              		<option value="2">二手</option>
              		<option value="3">导购+二手</option>
              		<option value="4">促销</option>
              		<option value="5">导购+促销</option>
              		<option value="6">二手+促销</option>
              		<option value="7">导购+二手+促销</option>              		
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