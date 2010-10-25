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
      <td colspan="2"><input type="radio" name="type" id="radio" value="个人会员" checked/>
      个人会员
        <input type="radio" name="type" id="radio2" value="企业会员" />
      企业会员</td>
    </tr>
    <tr>
      <td>用户帐号</td>
      <td><input type="text" name="username" id="username" />&nbsp;&nbsp;<font color="red"><c:if test="${not empty username}"><fmt:message key="${username.text}" /></c:if></font></td> 
      </tr>
    <tr>
      <td>请输入密码</td>
      <td><input type="password" name="password1" id="password1" />&nbsp;&nbsp;<font color="red"><c:if test="${not empty password}"><fmt:message key="${password.text}" /></c:if></font></td>
      <td></td>
    </tr>
    <tr>
      <td>再确认密码</td>
      <td><input type="password" name="password2" id="password2" /></td>
    </tr>
    <tr>
      <td>电子邮件</td>
      <td><input type="text" name="email" id="email" />&nbsp;&nbsp;<font color="red"><c:if test="${not empty email}"><fmt:message key="${email.text}" /></c:if></font></td>
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
