<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="common/common.jsp" %>
<html>
<head>
	<script type="text/javascript" src="../scripts/service/commodity.js"></script>
</head>
<body>
<table id="commodityList"></table>
<div id="commodityEdit" icon="icon-edit" style="width:500px;height:300px;display:none">
	<div style="background: #fafafa; padding: 10px; text-align: center">
		<form id="commodityForm" action="../commodity/create" method="post"	enctype="multipart/form-data">
			  <div>
	              	<label for="name">商品名称:</label>
	              	<input class="easyui-validatebox" type="text" name="commodityName" maxlength="20"/>
	          </div> 
	          <div>
	              	<label for="name">商品描述:</label>
	              	<input class="easyui-validatebox" type="text" name="commodityDescription" maxlength="20"/>
	          </div> 
	          <div>
	              	<label for="name">开始时间:</label>
	              	<input class="easyui-validatebox" type="text" name="startDate" maxlength="20"/>
	          </div> 
	          <div>
	              	<label for="name">结束时间:</label>
	              	<input class="easyui-validatebox" type="text" name="endDate" maxlength="20"/>
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
			<input type="hidden" name="MAX_FILE_SIZE" value="100000" /> 
			File: <input type="file" name="file" id="file"/> 
			<input id="commodityId" name="commodityId" type="hidden" /> 
			<input	type="submit" value="上传" name="submitButton" />
		</form>
		<div id="image"></div>
	</div>
</div>
</body>
</html>