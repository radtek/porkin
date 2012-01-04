<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta  http-equiv="Content-Type"  content="text/html;charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" /> 
<title><fmt:message key="welcome.title" /></title>
<link rel="shortcut icon" href="${ctx}/images/common/star.gif" />
<link rel="stylesheet" type="text/css" href="${ctx}/styles/easyui.css">
<link rel="stylesheet" type="text/css" href="${ctx}/styles/icon.css">
<link rel="stylesheet" type="text/css" href="${ctx}/styles/common.css">
<script type="text/javascript" src="${ctx}/scripts/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="${ctx}/scripts/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx}/scripts/jquery.form.js"></script>
<script type="text/javascript" src="${ctx}/scripts/common/datetime.js"></script>
<script type="text/javascript" src="${ctx}/scripts/common/common.js"></script>
<script>
// 操作成功窗口提示停留时间(2秒)
var optSuccessTime = 2000;
</script>
</head>
</html>