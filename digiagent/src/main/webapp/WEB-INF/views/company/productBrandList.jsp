<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ include file="/common/taglibs.jsp" %>

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
$(document).ready(function() {
	$('img').css('cursor', 'pointer');
	$('input[name="btnBack"]').bind('click', agentBackClickHandler);
});

var agentBackClickHandler = function() {
	window.location.href='agent';
};
</script>
</head>
<body>
<div class="companyTitle">代理申请</div>
<div id="companyLeft">
  <table width="80%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td colspan="2">
      <strong>
      	<c:if test="${not empty message}">
			<fmt:message key="${message.text}" />
		 </c:if>
	</strong>
</td>
    </tr>
    <tr><td>品牌商品列表</td></tr>
 	<tr>
      <td>
      <table>
      <tr>
      	<th>国家</th>
      	<th>品牌</th>
      	<th>类别</th>
      	<th>产品</th>
      	<th>操作</th>
      </tr>
      <c:choose>
	      <c:when test="${not empty productBrandList}">
			<c:forEach items="${productBrandList}" var="productBrand">
					<tr>
						<td>${productBrand.countryName}</td>
						<td>${productBrand.brandName}</td>
						<td>${productBrand.categoryName}</td>
						<td>${productBrand.productName}</td>
						<td><img src="${ctx}/images/datagrid/icon_list_edit.gif"/>&nbsp;<img src="${ctx}/images/datagrid/icon_list_delete.gif"/></td>
					</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
				<td>暂无数据</td>
			</tr>
		</c:otherwise>
  	</c:choose>
	</table>
      </td>
    </tr>
    <tr>
      <td colspan="8" align="center">
        <input name="btnAdd" type="button" value="追加品牌商品"/>
        <input name="btnBack" type="button" value="返回"/>
      	</td>
    </tr>
    <tr>
      <td></td>
    </tr>
  </table>
  <p class="tagContent">&nbsp;</p>
</div>
</body>
</html>
