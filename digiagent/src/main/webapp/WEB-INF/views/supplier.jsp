<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="common/common.jsp" %>
<html>
<head>
	<script type="text/javascript" src="../scripts/service/supplier.js"></script>
</head>
<body>
	<table id="supplierList"></table>
	<div id="supplierEdit" icon="icon-edit" style="width:500px;height:400px;display:none">
		<div style="background:#fafafa;padding:10px;text-align:center">
		<form id="supplierForm" action="../supplier/create" method="post" enctype="multipart/form-data"> 
		  <div>
              	<label for="name">省份:</label>
              	<select id="provinceId" name="provinceId"> 
              	</select>
              	<label for="name">城市:</label>
              	<select id="cityId" name="cityId"> 
              	</select>
          </div>
          <div>
              	<label for="name">商家名称:</label>
              	<input type="hidden" name="supplierId"/>
              	<input class="easyui-validatebox" type="text" name="supplierName" maxlength="20"/>
          		<label for="name">联系人:</label>
              	<input class="easyui-validatebox" type="text" name="supplierContactname" maxlength="30"/>
          </div> 
          <div>
              	<label for="name">邮件:</label>
              	<input class="easyui-validatebox" type="text" name="userEmail" maxlength="30"/>
          		<label for="name">邮编:</label>
              	<input class="easyui-validatebox" type="text" name="supplierZip" maxlength="30"/>
          </div> 
          <div>
              	<label for="name">传真:</label>
              	<input class="easyui-validatebox" type="text" name="supplierFax" maxlength="30"/>
          		<label for="name">手机:</label>
              	<input class="easyui-validatebox" type="text" name="supplierMobile" maxlength="30"/>
          </div> 
          <div>
              	<label for="name">联系电话:</label>
              	<input class="easyui-validatebox" type="text" name="supplierTelephone" maxlength="30"/>
          		<label for="name">联系地址:</label>
              	<input class="easyui-validatebox" type="text" name="supplierAddress" maxlength="30"/>
          </div> 
	          <div>
	              	<label for="name">图片: </label>
					<input type="file" name="file" id="file"/> 
	          <div id="image"></div>
	          </div>
	      <div>
              	<label for="name">简介:</label>
              	<textarea rows="5" cols="20" name="supplierDescription" id="supplierDescription"></textarea>
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