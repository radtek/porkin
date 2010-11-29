<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户注册</title>
<link href="styles/main.css" rel="stylesheet" type="text/css" />
<script src="scripts/Calendar.js"></script>
<script src="scripts/menu.js"></script>
<script type="text/javascript" src="${ctx}/scripts/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="${ctx}/scripts/password.complexity.js"></script>

<script language="javascript">

function whenDelete() {
	var isDelete=true;
	if (!confirm("sure to delete")) {
		isDelete=false;
	}
	window.location = 'contractSearch.html'; 
	return isDelete;
}

function reloadcaptcha(){
	var elem=document.getElementById('captcha');	
		elem.src='captcha?r='+(new Date());
}

function showAgreement(){
	window.open ('${ctx}/agreement','商讯网服务协议','height=610,width=800,top=50,left=200,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no,status=no,depended=yes,titlebar=no,scrollbars=no,toolbar=no');
}

function agreementConfirm(value){

	if(document.registerForm.agreement.checked){
		document.registerForm.submit();
	}
	else{
		alert("请阅读并接受商讯网服务协议");
	}		
}

$(document).ready(function() {
	// $('<span/>').text('检测').css('text-decoration','underline').css('color', 'red').bind('mouseover', function() {$(this).css('cursor','pointer')}).bind('click', validateUserName).insertAfter('#username');
	$('#username').bind('change', validateUserName);
	$('#email').bind('change', validateEmail);
});


var validateUserName = function() {
	$('#validateUserName').remove();
	if ($('#username').val() == "") return;
	$('<span></span>').css('padding-left', '10px').attr('id', 'validateUserName').append('<image id="loader" src="images/datagrid/tree_loading.gif"/>').insertAfter('#username');
	$.get('validateUserName', {username:$('#username').val()}, function(data) {
		if (data) {
			$('#validateUserName').empty().append('<image id="loader" src="images/icons/no.png"/>');
		} else {
			$('#validateUserName').empty().append('<image id="loader" src="images/icons/ok.png"/>');
		}
	});
};

var validateEmail = function() {
	$('#validateEmail').remove();
	if ($('#email').val() == "") return;
	$('<span></span>').css('padding-left', '10px').attr('id', 'validateEmail').append('<image id="loader" src="images/datagrid/tree_loading.gif"/>').insertAfter('#email');
	// 对Email地址格式的验证
	var regEmail = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	if(!regEmail.test($('#email').val())){
		$('#validateEmail').empty().append('<image id="loader" src="images/icons/no.png"/>');
		return;
	}
	// 是否存在验证
	$.get('validateEmail', {email:$('#email').val()}, function(data) {
		if (data) {
			$('#validateEmail').empty().append('<image id="loader" src="images/icons/no.png"/>');
		} else {
			$('#validateEmail').empty().append('<image id="loader" src="images/icons/ok.png"/>');
		}
	});
};

</script>
</head>
<body>
<div class="headTop">
  <div class="headCity">切换城市
    <select name="select3" style="width:60px;">
        <option>大连</option>
        <option>上海</option>
      </select>
     <span class="leftLink"><a href="${ctx}/">首页</a></span>
     <span class="rightLink">帮助 | 设为首页</span> </div>
  <div class="logo"></div>
</div>
<div class="redLine"></div>
<DIV style="CLEAR: both"></DIV>
</DIV>
</DIV>
<div class="dfcenterTitle">用户注册</div>

<div id="loginCenter">
  <form action="${ctx}/register" name="registerForm" method="post">
  <table width="80%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td colspan="2">
		</td>
    </tr>
 	<tr>
      <td></td>
    </tr>
    <tr>
      <td>用户类型</td>
      <td colspan="2"><input type="radio" name="type" id="radio" value="个人会员" <c:if test="${user_type=='个人会员'}">checked</c:if>/>
      个人会员
        <input type="radio" name="type" id="radio2" value="企业会员" <c:if test="${user_type=='企业会员'}">checked</c:if>/>
      企业会员</td>
    </tr>
    <tr>
      <td>用户帐号</td>
      <td><input type="text" name="username" id="username" value="${user_username }"/>&nbsp;&nbsp;<font color="red"><c:if test="${not empty username}"><fmt:message key="${username.text}" /></c:if></font></td> 
      </tr>
    <tr>
      <td>请输入密码</td>
      <td><input type="password" name="password1" id="password1" onKeyUp="pwStrength(this.value)" onBlur="pwStrength(this.value)" />&nbsp;&nbsp;<font color="red"><c:if test="${not empty password}"><fmt:message key="${password.text}" /></c:if></font></td>
      <td></td>
    </tr>
    <tr>
    	<td>密码强度</td>
    	<td>
    		<table width="100" border="1" cellspacing="0" cellpadding="1" bordercolor="#cccccc" height="5" style='display:inline'>     
				<tr align="center" bgcolor="#eeeeee">     
					<td width="33%" id="strength_L">弱</td>     
					<td width="33%" id="strength_M">中</td>     
					<td width="33%" id="strength_H">强</td>     
				</tr>     
			  </table>   
    	</td>
    </tr>
    <tr>
      <td>再确认密码</td>
      <td><input type="password" name="password2" id="password2" /></td>
    </tr>
    <tr>
      <td>电子邮件</td>
      <td><input type="text" name="email" id="email" value="${user_email }"/>&nbsp;&nbsp;<font color="red"><c:if test="${not empty email}"><fmt:message key="${email.text}" /></c:if></font></td>
    </tr>
    <tr>
      <td>验证码显示</td>
      <td><img src="captcha" width="140" height="35" id="captcha" /><a href="javascript:void(0);"  onclick="reloadcaptcha();"/>&nbsp;&nbsp;换一张</a></td>
    </tr>
     <tr>
      <td>输入验证码</td>
      <td><input type="text" name="captcha" id="captcha" />&nbsp;&nbsp;<font color="red"><c:if test="${not empty captcha}"><fmt:message key="${captcha.text}" /></c:if></font></td>
    </tr>
    <tr>
      <td>
      </td>
      <td><input type="checkbox" name="agreement" id="agreement" value="checkbox" style="width:20px; float:left; margin-top:3px;"/>已阅读并接受<a href="javascript:showAgreement();">商讯网服务协议</a></td>
    </tr>
    <tr>
      <td colspan="2" align="center"><span class="headCity">
        <input class="btn_login" type="button" value="提交" onClick = "agreementConfirm('value')"/>
            </span><span class="headCity">
      <input class="btn_login" type="reset" value="取消" />
                  </span></td>
    </tr>
    <tr>
      <td></td>
    </tr>
  </table>
</form>
  <p class="tagContent">&nbsp;</p>
</div>

</body>
</html>
