<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>省份维护</title>
	<link rel="stylesheet" type="text/css" href="../styles/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../styles/icon.css">
	<script type="text/javascript" src="../scripts/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="../scripts/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../scripts/jquery.form.js"></script>
	<script type="text/javascript" src="../scripts/service/province.js"></script>
	<script type="text/javascript" src="../scripts/common/datetime.js"></script>
</head>
<body>
	<table id="provinceList"></table>
	<div id="provinceEdit" icon="icon-edit" style="width:400px;height:200px;display:none">
		<div style="background:#fafafa;padding:10px;text-align:center">
		<form id="provinceForm" action="../province/create" method="post"> 
          <div>
              	<label for="name">省份名称:</label>
              	<input type="hidden" name="provinceId"/>
              	<input class="easyui-validatebox" type="text" name="provinceName" maxlength="20"/>
          </div>  
          <div>
              	<label for="name">省份缩写:</label>
              	<input class="easyui-validatebox" type="text" name="provinceAbbreviation" maxlength="3"/>
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