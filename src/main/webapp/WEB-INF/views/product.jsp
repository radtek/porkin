<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="common/common.jsp" %>
<html>
<head>
	<script type="text/javascript" src="../scripts/service/product.js"></script>
</head>
<body>
	<table id="productList"></table>
	<div id="productEdit" icon="icon-edit" style="width:400px;height:170px;display:none">
		<div style="background:#fafafa;padding:10px;text-align:center">
		<form id="productForm" action="../product/create" method="post"> 
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