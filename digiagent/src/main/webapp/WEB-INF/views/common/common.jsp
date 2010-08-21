<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<META  http-equiv="Content-Type"  content="text/html;charset=UTF-8">
<title><fmt:message key="welcome.title" /></title>
<%
	String jspName = request.getRequestURL().toString().replaceAll(
			"^.*/", "").replaceAll(".jsp", "");
	if (!jspName.equals("admin")) {
%>
<link rel="stylesheet" type="text/css" href="../styles/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../tyles/icon.css">
<script type="text/javascript" src="../scripts/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="../scripts/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/jquery.form.js"></script>
<%
	} else {
%>
<link rel="stylesheet" type="text/css" href="styles/default/easyui.css">
<link rel="stylesheet" type="text/css" href="tyles/icon.css">
<script type="text/javascript" src="scripts/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="scripts/jquery.easyui.min.js"></script>
<script type="text/javascript" src="scripts/jquery.form.js"></script>
<%
	}
%>

<script>
// 操作成功窗口提示停留时间(2秒)
var optSuccessTime = 2000;
</script>
</head>
</html>