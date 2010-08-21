﻿<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="common/common.jsp" %>
<html>
<head>
	<script type="text/javascript" src="../scripts/service/supplierProduct.js"></script>
</head>
<body>
	<table id="supplierProductList"></table>
	<div id="productWindow" class="easyui-window" title="已有品牌产品列表" icon="icon-save" style="width:700px;height:400px;padding:5px;background: #fafafa;">
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
	<div id="productWin" class="easyui-window" closed="true" modal="true" title="品牌产品列表" style="width:700px;height:400px;padding:5px;background: #fafafa;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false" style="padding:10px;background:#fafafa;border:1px solid #000;">
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