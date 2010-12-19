<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Sortable</title>
<script type="text/javascript" src="${ctx}/scripts/jquery-1.4.2.min.js"></script>
<script type="text/javascript"
	src="${ctx}/scripts/jquery-ui-1.8.6.custom.min.js"></script>
<link rel="stylesheet" href="${ctx}/styles/jquery-ui-1.8.6.custom.css" />
<style>
#sortable0,#sortable1,#sortable2,#sortable3 {
	list-style-type: none;
	margin: 0;
	padding: 0;
	width: 60%;
}

li {
	margin: 0 3px 3px 3px;
	padding: 0.4em;
	padding-left: 1.5em;
	font-size: 1.4em;
	height: 18px;
}

li span {
	position: absolute;
	margin-left: -1.3em;
}

* {
	font-size: 12px;
	margin: 0;
	padding: 0;
}
</style>

<script>
	$(function() {
		$("#tabs").tabs().find(".ui-tabs-nav").sortable({axis:'x'});
		$("#sortable0").sortable({
			placeholder: "ui-state-highlight"
		});
		$("#sortable0").disableSelection();
		$("#sortable1").sortable({
			placeholder: "ui-state-highlight"
		});
		$("#sortable1").disableSelection();
		$("#sortable2").sortable({
			placeholder: "ui-state-highlight"
		});
		$("#sortable2").disableSelection();
		$("#sortable3").sortable({
			placeholder: "ui-state-highlight"
		});
		$("#sortable3").disableSelection();
	});

	function setValue(ind) {
		var data = [];
		$.each($("#sortable" + ind).children(), function (index, item) {
			data.push($(item).find(".ui-icon").text());
		});
		$('input[name="items"]').eq(ind).val(JSON.stringify(data));
	}

	function showChild(type, parentId) {
		window.location.href = "${ctx}/sortable/" + type + "/" +parentId;
	}

	$(document).ready(function() {
		var ind = ${type};
		var parentId = ${parentId};
		$('input[name="parentId"]').eq(ind).val(parentId);
		// 给选中的上级加入背景颜色
		if (ind > 0) {
			$.each($('#sortable' + (ind - 1)).children(), function (index, item) {
				if ($(item).find(".ui-icon").text() == parentId) {
					$(item).css('background-color', '#F78181');
					<c:if test="${not empty categoryId}">
					var categoryId = ${categoryId};
					$('input[name="parentId"]').eq(1).val(categoryId);
					if (ind > 1) {
						$.each($('#sortable0').children(), function (index1, item1) {
							if ($(item1).find(".ui-icon").text() == categoryId) {
								$(item1).css('background-color', '#F78181');
							}
						});
					}
					</c:if>
					<c:if test="${not empty productId && productId > 0}">
					var productId = ${productId};
					$('input[name="parentId"]').eq(2).val(productId);
					if (ind > 1) {
						$.each($('#sortable1').children(), function (index1, item1) {
							if ($(item1).find(".ui-icon").text() == productId) {
								$(item1).css('background-color', '#F78181');
							}
						});
					}
					</c:if>
				}
			});
		}
		$("#tabs").tabs("option", "selected", ind);
	});
</script>
</head>
<body>

<div id="tabs" style="padding: 10px;margin: 10px">
<ul>
	<li style="height: 25px"><a href="#tabs-0">类 别</a></li>
	<li style="height: 25px"><a href="#tabs-1">产 品</a></li>
	<li style="height: 25px"><a href="#tabs-2">品 牌</a></li>
	<li style="height: 25px"><a href="#tabs-3">商 家</a></li>
</ul>
<div id="tabs-0">
<ul id=sortable0>
	<c:forEach var="item" items="${categoryList}">
		<li class="ui-state-default"
			ondblclick="showChild(1, ${item.categoryId});"><span
			class="ui-icon">${item.categoryId}</span>${item.categoryName}</li>
	</c:forEach>
</ul>
<c:if test="${not empty categoryList}">
	<form action="../../save" method=post name="test0"
		onsubmit="setValue(0)"><input name="items" type="hidden" /> <input
		name="parentId" value="0" type="hidden" /> <input name="type"
		value="0" type="hidden" /> <input type="submit" value="保存" />(双击类别查看产品)
	</form>
</c:if></div>
<div id="tabs-1">
<ul id=sortable1>
	<c:forEach var="item" items="${productList}">
		<li class="ui-state-default"
			ondblclick="showChild(2, ${item.productId});"><span
			class="ui-icon">${item.productId}</span>${item.productName}</li>
	</c:forEach>
</ul>
<c:if test="${not empty productList}">
	<form action="../../save" method=post name="test1"
		onsubmit="setValue(1)"><input name="items" type="hidden" /> <input
		name="parentId" type="hidden" /> <input name="type" value="1"
		type="hidden" /> <input type="submit" value="保存" /> (双击产品查看品牌)</form>
</c:if></div>
<div id="tabs-2">
<ul id=sortable2>
	<c:forEach var="item" items="${brandList}">
		<li class="ui-state-default"
			ondblclick="showChild(3, ${item.brandId});"><span
			class="ui-icon">${item.brandId}</span>${item.brandName}</li>
	</c:forEach>
</ul>
<c:if test="${not empty brandList}">
	<form action="../../save" method=post name="test2"
		onsubmit="setValue(2)"><input name="items" type="hidden" /> <input
		name="parentId" type="hidden" /> <input name="type" value="2"
		type="hidden" /> <input type="submit" value="保存" />(双击品牌查看商家)</form>
</c:if></div>
<div id="tabs-3">
<ul id=sortable3>
	<c:forEach var="item" items="${supplierList}">
		<li class="ui-state-default"><span class="ui-icon">${item.supplierId}</span>${item.supplierName}</li>
	</c:forEach>
</ul>
<c:if test="${not empty supplierList}">
	<form action="../../save" method=post name="test3"
		onsubmit="setValue(3)"><input name="items" type="hidden" /> <input
		name="parentId" type="hidden" /> <input name="type" value="3"
		type="hidden" /> <input type="submit" value="保存" /></form>
</c:if></div>
</div>
</body>
</html>
