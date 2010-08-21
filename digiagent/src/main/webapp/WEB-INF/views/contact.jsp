<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="common/common.jsp" %>
<html>
<head>
	<script type="text/javascript" src="../scripts/service/contact.js"></script>
</head>
<body>
	<table id="contactList"></table>
	<div id="contactEdit" icon="icon-edit" style="width:400px;height:250px;display:none">
		<div style="background:#fafafa;padding:10px;text-align:center">
		<form id="contactForm" action="../contact/create" method="post">
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
              	<label for="name">商家:</label>
              	<select id="supplierId" name="supplierId"> 
              	</select>
          </div>
          <div>
              	<label for="name">联系方式:</label>
              	<input type="hidden" name="contactId"/>
              	<select id="contactType" name="contactType">
              		<option value="Q">qq</option> 
                    <option value="T">电话</option>
                    <option value="E">电子邮件</option>
                    <option value="M">手机</option> 
              	</select>
          </div> 
          <div>
              	<label for="name">联系内容:</label>
              	<input class="easyui-validatebox" type="text" name="contactContent" maxlength="30"/>
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