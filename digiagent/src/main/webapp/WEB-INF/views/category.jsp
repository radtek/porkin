<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="common/common.jsp" %>
<html>
<head>
	<script type="text/javascript" src="../scripts/service/category.js"></script>
</head>
<body>
	<table id="categoryList"></table>
	<div id="categoryEdit" icon="icon-edit" style="width:400px;height:150px;display:none">
		<div style="background:#fafafa;padding:10px;text-align:center">
		<form id="categoryForm" action="../category/create" method="post"> 
          <div>
              	<label for="name">类别名:</label>
              	<input type="hidden" name="categoryId"/>
              	<input class="easyui-validatebox" type="text" name="categoryName" maxlength="20"/>
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