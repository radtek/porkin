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
	$('input[name="btnAdd"]').bind('click', agentAddClickHandler);
});

var agentAddClickHandler = function() {
	window.location.href='productBrandList';
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
    <tr><td>已代理的商品</td></tr>
 	<tr>
      <td>
      <table>
      <tr>
      	<th>国家</th>
      	<th>品牌</th>
      	<th>类别</th>
      	<th>产品</th>
      	<th>开始时间</th>
      	<th>操作</th>
      </tr>
      <c:choose>
	      <c:when test="${not empty supplierProductList}">
			<c:forEach items="${supplierProductList}" var="supplierProduct">
					<tr>
						<td>${supplierProduct.countryName}</td>
						<td>${supplierProduct.brandName}</td>
						<td>${supplierProduct.categoryName}</td>
						<td>${supplierProduct.productName}</td>
						<td>
							<fmt:formatDate value="${supplierProduct.startDate}" pattern="yyyy/MM/dd"/>
						</td>
						<td>
							<form action="${ctx}/company/agent/delete/${supplierProduct.productbrandId}">
								<input type="image"  src="${ctx}/images/datagrid/icon_list_delete.gif" onclick="javascript:confirm('您确认要删除?')" />
							</form>
						</td>
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
      <td colspan="8" align="center"><span class="headCity">
      <form action="${ctx}/company/agent/form" >
        <input name="btnAdd" type="submit" value="增加"/>
       </form>
            </span>
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