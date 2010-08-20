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
	<div id="productWindow" class="easyui-window" title="已有品牌产品列表" icon="icon-save" style="width:700px;height:450px;padding:5px;background: #fafafa;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false" style="padding:10px;background:#fff;border:1px solid #ccc;">
				<table id="ownProductList"></table>
			</div>
<!--			<div region="south" border="false" style="text-align:center;height:30px;line-height:30px;">-->
<!--				<a class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" onclick="resize()">Save</a>-->
<!--				<a class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0)" onclick="resize()">Cancel</a>-->
<!--			</div>-->
		</div>
	</div>
	<div id="productWin" class="easyui-window" closed="true" modal="true" title="品牌产品列表" style="width:700px;height:450px;padding:5px;background: #fafafa;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false" style="padding:10px;background:#fff;border:1px solid #ccc;">
				<table id="targetProductList"></table>
				<input type="hidden" id="supplierId"/>
			</div>
			<div region="south" border="false" style="text-align:center;height:30px;line-height:30px;">
				<a class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" onclick="addSupplierProduct()">追加</a>
			</div>
		</div>
	</div>
</body>
</html>