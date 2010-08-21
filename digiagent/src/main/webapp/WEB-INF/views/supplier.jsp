<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="common/common.jsp" %>
<html>
<head>
	<script type="text/javascript" src="../scripts/service/supplier.js"></script>
</head>
<body>
	<table id="supplierList"></table>
	<div id="supplierEdit" icon="icon-edit" style="width:400px;height:200px;display:none">
		<div style="background:#fafafa;padding:10px;text-align:center">
		<form id="supplierForm" action="../supplier/create" method="post"> 
		  <div>
              	<label for="name">省份:</label>
              	<select id="provinceId" name="provinceId"> 
              	</select>
          </div>
          <div>
              	<label for="name">城市:</label>
              	<select id="cityId" name="cityId"> 
              	</select>
          </div>
          <div>
              	<label for="name">商家名称:</label>
              	<input type="hidden" name="supplierId"/>
              	<input class="easyui-validatebox" type="text" name="supplierName" maxlength="20"/>
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