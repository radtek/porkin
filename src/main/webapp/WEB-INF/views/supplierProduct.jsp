﻿<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="common/common.jsp" %>
<html>
<head>
	<script type="text/javascript" src="../scripts/service/supplierProduct.js"></script>
</head>
<body>
	<table id="supplierProductList"></table>
	<div id="productPeriodWin" class="easyui-window" closed="true" modal="true" title="有效时间设置" style="width:300px;height:150px;padding:5px;background: #fafafa;">
		<form id="productForm" action="../supplierProduct/updateSupplierProduct" method="post">
			<div>
				<input type="hidden" name="productbrandId"/>
				<input type="hidden" name="supplierId"/>
              	<label for="name">开始时间:</label>
              	<input id="startDate" name="startDate" class="easyui-datebox" required="true" readonly="readonly"/>
          </div> 
          <div>
              	<label for="name">结束时间:</label>
              	<input id="endDate" name="endDate" class="easyui-datebox" required="true" readonly="readonly"/>
          </div> 
          <div>
	              <input type="submit"  name="submitButton" value="确定" /> 
	              <input type="reset"   name="resetButton " value="重置" />
	          </div> 
         </form>
	</div>
	<div id="productWindow" class="easyui-window" title="已有品牌产品列表" icon="icon-save" style="width:840px;height:400px;padding:5px;background: #fafafa;">
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