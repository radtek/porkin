<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="${ctx }/styles/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../scripts/menu.js"></script>
</head>
<body>
<div class="companyTitle">基本信息 </div>
<div id="companyLeft">
	<ul class="userInfo">
    	<li onmousemove=splash(this); ><span class="userInfoBlue">用户昵称</span><span class="userInfoYellow">Porkin</span></li>
        <li onmousemove=splash(this); ><span class="userInfoBlue">用户类型</span><span class="userInfoYellow">高级VIP用户</span></li>
        <li onmousemove=splash(this); ><span class="userInfoBlue">上次登录时间</span><span class="userInfoYellow">2010-08-25  19:45</span></li>
		<li onmousemove=splash(this); ><span class="userInfoBlue">注册时间</span><span class="userInfoYellow">06-05-06   19:45</span></li>
		<li onmousemove=splash(this); ><span class="userInfoBlue">登录次数</span><span class="userInfoYellow">12</span></li>
    </ul>
</div>
</body>
</html>