<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>代理申请</title>
<link href="${ctx}/styles/main.css" rel="stylesheet" type="text/css" />
<script src="${ctx}/scripts/Calendar.js"></script>
<script src="${ctx}/scripts/menu.js"></script>
<script type="text/javascript" src="${ctx}/scripts/jquery-1.4.2.min.js"></script>
<script>
function setProductSelect(productId) {
	$.ajax({
		url:"${ctx}/productBrand/getProductList",
		data:"id=" + $('select[name="categoryId"]').val(),
		dataType:"html",
		type: "GET",
		success: function(data) {
			$('select[name="productId"]').empty().append(data).val(productId);
		},
		error:function(err) {
	    	alert('数据读取失败！');
		}
	});
}

function setBrandSelect(brandId) {
	$.ajax({
		url:"${ctx}/productBrand/getBrandList",
		data:"id=" + $('select[name="countryId"]').val(),
		dataType:"html",
		type: "GET",
		success: function(data) {
			$('select[name="brandId"]').empty().append(data).val(brandId);
		},
		error:function(err) {
	    	$.messager.alert('消息',err,'error');
		}
	});
}
</script>
</head>
<body>
<div class="companyTitle">代理申请</div>
<div id="companyLeft">
<form action="${ctx}/company/agent/create">
<table width="80%" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td colspan="2"><strong> <c:if
			test="${not empty message}">
			<fmt:message key="${message.text}" />
		</c:if> </strong></td>
	</tr>
	<tr>
		<td>代理商品申请</td>
	</tr>
	<tr>
		<td>
		
		<table>
			<tr>
				<td><strong>国家</strong></td>
				<td><select name="countryId" id="countryId" onchange="setBrandSelect()">
					<option value="0" selected>请选择</option>
					<c:forEach items="${countryList}" var="country">
						<option value="${country.countryId}">${country.countryName}</option>
					</c:forEach>
				</select></td>

				<td><strong>品牌</strong></td>
				<td><select name="brandId" id="brandId"></select></td>
			</tr>
			<tr>
				<td><strong>类别</strong></td>
				<td>
					<select name="categoryId" id="categoryId" onchange="setProductSelect()" >
						<option value="0" selected>请选择</option>
							<c:forEach items="${categoryList}" var="category">
								<option value="${category.categoryId}">${category.categoryName}</option>
							</c:forEach>
						</select>
					</td>
				<td><strong>产品</strong></td>
				<td><select name="productId" id="productId"></select></td>

			</tr>

		</table>
		</td>
	</tr>
	<tr>
		<td></td>
	</tr>
	<tr>
		<td colspan="8" align="center">
			<span class="headCity">

					<input class="btn_login" type="submit" value="确认" />
			</span>
		</td>
		<td>
		</td>
		
	</tr>
	<tr>
		<td></td>
	</tr>
</table>
</form>
<p class="tagContent">&nbsp;</p>
</div>
</body>
</html>