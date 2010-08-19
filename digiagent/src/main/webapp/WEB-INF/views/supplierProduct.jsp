<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商家与产品关系维护</title>
	<link rel="stylesheet" type="text/css" href="../styles/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../styles/icon.css">
	<script type="text/javascript" src="../scripts/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="../scripts/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../scripts/jquery.form.js"></script>
	<script type="text/javascript" src="../scripts/service/supplierProduct.js"></script>
	<script type="text/javascript" src="../scripts/common/datetime.js"></script>
</head>
<body>
	<table id="supplierProductList"></table>
	<div id="supplierProductEdit" icon="icon-edit" style="width:400px;height:200px;display:none">
		<div style="background:#fafafa;padding:10px;text-align:center">
		<form id="supplierProductForm" action="../supplierProduct/create" method="post"> 
        </form> 
	    </div>
	</div>
</body>
</html>