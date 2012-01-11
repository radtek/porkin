<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="common/common.jsp" %>
<html>
<head>
	<script type="text/javascript" src="../scripts/service/productBrand.js"></script>
</head>
<body>
	<div><label for="name">国家:</label><select id="countryId" name="countryIdWin"> </select>
	<label for="name">品牌:</label><select id="brandId" name="brandIdWin"></select>
	<label for="name">类别:</label><select id="categoryId" name="categoryIdWin"></select>
	<label for="name">产品:</label><select id="productId" name="productIdWin"></select>
	<input type="button" value="查询" onclick="search()"/></div>
	<table id="productBrandList"></table>
	<div id="productBrandEdit" icon="icon-edit" style="width:400px;height:170px;display:none">
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