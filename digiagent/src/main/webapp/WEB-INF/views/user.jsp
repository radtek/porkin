<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="common/common.jsp" %>
<html>
<head>
	<script type="text/javascript" src="../scripts/service/user.js"></script>
</head>
<body>
	<table id="userList"></table>
	<div id="userEdit" icon="icon-edit" style="width:400px;height:300px;display:none">
		<div style="background:#fafafa;padding:10px;text-align:center">
		<form id="userForm" action="../user/create" method="post"> 
          <div>
              	<input type="hidden" name="userId"/>
              	<label for="name">用户名:</label>
              	<input class="easyui-validatebox" type="text" name="userName" maxlength="20"/>
          </div> 
          <div>
              	<label for="name" style="text-align:right">密码:</label>
              	<input class="easyui-validatebox" type="password" name="userPassword" maxlength="20"/>
          </div>  
          <div>
              	<label for="name">确认密码:</label>
              	<input class="easyui-validatebox" type="password" name="userPassword2" maxlength="20"/>
          </div>
          <div>
              	<label for="name">邮件:</label>
              	<input class="easyui-validatebox" type="text" name="userEmail" maxlength="20"/>
          </div>  
          <div>
              	<label for="name">角色:</label>
              	<select id="roleId" name="roleId"> 
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