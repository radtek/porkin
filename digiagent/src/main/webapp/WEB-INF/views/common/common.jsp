<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta  http-equiv="Content-Type"  content="text/html;charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" /> 
<title><fmt:message key="welcome.title" /></title>
<%
	String jspName = request.getRequestURL().toString().replaceAll(
			"^.*/", "").replaceAll(".jsp", "");
	if (!jspName.equals("admin")) {
%>
<link rel="stylesheet" type="text/css" href="../styles/easyui.css">
<link rel="stylesheet" type="text/css" href="../styles/icon.css">
<script type="text/javascript" src="../scripts/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="../scripts/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/jquery.form.js"></script>
<script type="text/javascript" src="../scripts/common/datetime.js"></script>
<%
	} else {
%>
<link rel="stylesheet" type="text/css" href="styles/easyui.css">
<link rel="stylesheet" type="text/css" href="styles/icon.css">
<script type="text/javascript" src="scripts/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="scripts/jquery.easyui.min.js"></script>
<script type="text/javascript" src="scripts/jquery.form.js"></script>
<script type="text/javascript" src="scripts/common/datetime.js"></script>
<%
	}
%>

<script>
// 操作成功窗口提示停留时间(2秒)
var optSuccessTime = 2000;
</script>
</head>
</html>