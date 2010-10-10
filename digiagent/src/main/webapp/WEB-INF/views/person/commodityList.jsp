<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<link href="${ctx}/styles/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx}/scripts/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="${ctx}/scripts/commoditylist.js"></script>
<script type="text/javascript" src="${ctx}/scripts/common/common.js"></script>
<script>
$(document).ready(function() {
	queryCommodityList(1, 'S', true, '');
});
</script>
</head>
<body>
<jsp:include page="../historyTemplate.jsp"></jsp:include>
<div class="companyTitle">二手历史 </div>
<div id="commodityS">
</div>
<div></div>
</body>
</html>