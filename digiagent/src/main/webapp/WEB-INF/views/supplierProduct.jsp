﻿<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="common/common.jsp" %>
<html>
<head>
	<script type="text/javascript" src="../scripts/service/supplierProduct.js"></script>
</head>
<body>
	<div><label for="name">省份:</label><select id="provinceId" name="provinceId"> </select>
	<label for="name">城市:</label><select id="cityId" name="cityId"></select>
	<label for="name">商家:</label><input id="supplierName" name="supplierName" />
	<input type="button" value="查询" onclick="search()"/></div>
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
		<div id="productSearch"><label for="name">国家:</label><select id="countryId" name="countryId"> </select>
	<label for="name">品牌:</label><select id="brandId" name="brandId"></select>
	<label for="name">类别:</label><select id="categoryId" name="categoryId" ></select>
	<label for="name">产品:</label><select id="productId" name="productId"></select>
	<input type="button" value="查询" onclick="searchProduct()"/></div>
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
		<div id="productWinSearch"><label for="name">国家:</label><select id="countryIdWin" name="countryIdWin"> </select>
		<label for="name">品牌:</label><select id="brandIdWin" name="brandIdWin"></select>
		<label for="name">类别:</label><select id="categoryIdWin" name="categoryIdWin" ></select>
		<label for="name">产品:</label><select id="productIdWin" name="productIdWin"></select>
		<input type="button" value="查询" onclick="openProductBrand()"/></div>
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