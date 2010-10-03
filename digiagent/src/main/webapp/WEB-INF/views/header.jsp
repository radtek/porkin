<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人会员</title>
<link href="styles/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="headTop">
  <div class="headCity">切换城市
    <select name="select3" style="width:60px;">
        <option>大连</option>
        <option>上海</option>
      </select>
      <c:choose>
      <c:when test="${empty sessionScope.username}">
     <form name="loginForm" action="login" method="post">
      用户<input type="text" name="username" size="10" width="10"/>&nbsp;
      密码<input type="password" name="password" size="10" width="10"/>&nbsp;
      <input class="btn_login" type="submit" value="登录"/>
      </form>
   			<span class="leftLink"><a href="registerForm">注册</a> | <a href="passwordForm">忘记密码</a></span>
      </c:when>
      <c:otherwise>
       <span class="leftLink">欢迎您 ，<c:out value="${sessionScope.username}" /> | <a href="member">会员</a> | <a href="logout">退出</a></span>
      </c:otherwise>
      </c:choose>
      
    <span class="rightLink">帮助 | 设为首页</span>
    </div>
 
</div>
<div class="redLine"></div>
<div style="clear: both"></div>
</body>
</html>