<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
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
  <form action="${ctx}/register" method="post">
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
      <td><img src="captcha" width="140" height="35" /></td>
    </tr>
     <tr>
      <td>输入验证码</td>
      <td><input type="text" name="captcha" id="captcha" />&nbsp;&nbsp;<font color="red"><c:if test="${not empty captcha}"><fmt:message key="${captcha.text}" /></c:if></font></td>
    </tr>
    <tr>
      <td></td>
    </tr>
    <tr>
      <td colspan="2" align="center"><span class="headCity">
        <input class="btn_login" type="submit" value="提交" />
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
