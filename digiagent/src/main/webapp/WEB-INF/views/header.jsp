<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ include file="/common/taglibs.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人会员</title>
<link href="styles/main.css" rel="stylesheet" type="text/css" />

<script language="javascript">
/**
 * 登录
 * @param username
 * @param password
 * @return
 */

function logout() {
	var url = "${ctx}/logout";
	//document.location.href = "${ctx}/logout";
	window.parent.location.href= url;
	//window.location.href=url;
	//window.location.reload();

}

function homepage() {
	var url = "${ctx}/";
	//document.location.href = "${ctx}/logout";
	window.parent.location.href= url;

}

function about() {
	var url = "${ctx}/about";
	//document.location.href = "${ctx}/logout";
	window.parent.location.href= url;

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
      <c:choose>
      <c:when test="${empty sessionScope.userName}">
     <form name="loginForm" action="${ctx}/login" method="post">
      用户<input type="text" name="username" size="10" width="10"/>&nbsp;
      密码<input type="password" name="password" size="10" width="10"/>&nbsp;
      <select name="type">
      	<option value="">通行证</option>
      	<option value="个人会员">个人会员</option>
      	<option value="企业会员">企业会员</option>
      	<option value="一般用户">一般用户</option>
      	<option value="超级用户">超级用户</option>
      	<option value="系统管理员">系统管理员</option>
      </select>&nbsp;
      <input class="btn_login" type="button" value="登录" onclick="login(${ctx}/)"/>
      </form>
   			<span class="leftLink"> <a href="javascript:void(0);" onclick="homepage()"><fmt:message key="label.common.homepage"/></a> | <a href="${ctx}/registerForm">注册</a> | <a href="${ctx}/passwordForm">忘记密码</a> </span>
      </c:when>
      <c:otherwise>
       <span class="leftLink"></a>&nbsp;&nbsp;欢迎您 ，<c:out value="${sessionScope.userName}" /> | <a href="javascript:void(0);" onclick="homepage()"><fmt:message key="label.common.homepage"/></a> | <a href="${ctx}/member">会员</a> | <a href="javascript:void(0);" onclick="logout()" ></><fmt:message key="label.common.logout"/></a></span>
      </c:otherwise>
      </c:choose>
      
    <span class="rightLink"><a href="javascript:void(0);" onclick="about()"><fmt:message key="label.common.about"/> </a> | <a href=# onClick="this.style.behavior='url(#default#homepage)'; this.setHomePage('${ctx}/');event.returnValue=false;">设为首页</a></span>
    </div>
 
</div>
<div class="redLine"></div>
<div style="clear: both"></div>
</body>
</html>