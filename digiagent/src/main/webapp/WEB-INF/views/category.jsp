<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>类别维护</title>
	<link rel="stylesheet" type="text/css" href="../styles/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../styles/icon.css">
	<script type="text/javascript" src="../scripts/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="../scripts/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../scripts/jquery.form.js"></script>
	<script type="text/javascript" src="../scripts/service/category.js"></script>
</head>
<body>
	<table id="tt"></table>
	<div id="dd" icon="icon-edit" style="padding:5px;width:500px;height:300px;">
		<form id="caetgoryForm" action="../category/update" method="post"> 
          <table> 
              <tr><td>类别名:</td><td>
              	<input type="text" name="categoryName"></td></tr> 
              <tr><td>状态:</td><td>
              	<select name="activeFlag"> 
                      <option value="0" selected="selected">开启</option> 
                      <option value="1">禁用</option>
              	</select></td></tr>
              </table> 
              <input type="submit"  name="submitButton" value="确定" /> 
              <input type="reset"   name="resetButton " value="重置" /> 
      </form> 
	</div>
</body>
</html>