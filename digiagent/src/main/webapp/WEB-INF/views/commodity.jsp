<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="common/common.jsp" %>
<html>
<head>
	<script type="text/javascript" src="../scripts/service/commodity.js"></script>
</head>
<body>
<form id="commodityForm" action="../commodity/create" method="post" enctype="multipart/form-data">
    <input type="hidden" name="MAX_FILE_SIZE" value="100000" />
    File: <input type="file" name="file" />
    <input id="commodityId" type="hidden"/>
    <input type="submit" value="上传" name="submitButton"/>
</form>
<div id="image"></div>
</body>
</html>