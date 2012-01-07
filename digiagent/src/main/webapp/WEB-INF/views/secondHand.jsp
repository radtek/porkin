<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商讯网--二手信息</title>
<link href="${ctx}/styles/main3.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${ctx}/scripts/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="${ctx}/scripts/searchbar.js"></script>
<script type="text/javascript" src="${ctx}/scripts/common/common.js"></script>
<script type="text/javascript" src="${ctx}/scripts/commoditylist.js"></script>
<script>
function setCategorySelect(categoryId, productId) {
	$.ajax({
		url:"${ctx}/product/getCategoryList",
		dataType:"html",
		type: "GET",
		success: function(data) {
			$('select[name="categoryId"]').empty().append(data).val(categoryId);
			if (categoryId > 0) {
				setProductSelect(productId);
			}
		},
		error:function(err) {
	    	$.messager.alert('消息',err,'error');
		}
	});
}

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
	    	$.messager.alert('消息',err,'error');
		}
	});
}
$(document).ready(function() {;
	setCategorySelect('${param.categoryId}', '${param.productId}');
	$('select[name="categoryId"]').bind('change', setProductSelect);
});
function goPage(pageNum) {
	$('input[name=pageNum]').val(pageNum);
	search();
}
function search() {
	$('input[name=pageNum]').hide();
	$('form[name=secondHandForm]').append($('input[name=pageNum]'));
	document.secondHandForm.submit();
}
</script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<table border="0" cellspacing="0" cellpadding="0" width="100%" align="center">
  <tr><td height="25"></td></tr>
</table>
<!-- left menu -->
<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="10">&nbsp;</td>
	<td width="15"></td>
    <td width="170"><table width="170" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff">
        <tr>
          <td width="10" rowspan="2" valign="top" background="${ctx}/images/bg_pic00f.gif"><img src="${ctx}/images/bg_pic00a.gif" /></td>
          <td rowspan="2" width="45" style="border-top:1px solid #cccccc"><img src="${ctx}/images/icon_left01.gif" /></td>
          <td class="text_left_en" style="border-top:1px solid #cccccc">Commerce Net Guide</td>
          <td width="10" rowspan="2" valign="top" background="${ctx}/images/bg_pic00g.gif"><img src="${ctx}/images/bg_pic00b.gif" /></td>
        </tr>
        <tr>
          <td class="text_left_on"><a href="${ctx}" class="Aleft">商讯导购 <img src="${ctx}/images/btn_more.gif" /></a></td>
        </tr>
      </table></td>
    <td width="15"></td>
    <td width="170"><table width="170" border="0" cellspacing="0" cellpadding="0" bgcolor="#f8f8f8">
      <tr>
        <td width="10" rowspan="2" valign="top" background="${ctx}/images/bg_pic02f.gif"><img src="${ctx}/images/bg_pic02a.gif" /></td>
        <td rowspan="2" width="45" style="border-top:1px solid #e2e2e2"><img src="${ctx}/images/icon_left02.gif" /></td>
        <td class="text_left_en" style="border-top:1px solid #e2e2e2">Goods Promotion</td>
        <td width="10" rowspan="2" valign="top" background="${ctx}/images/bg_pic02g.gif"><img src="${ctx}/images/bg_pic02b.gif" /></td>
      </tr>
      <tr>
        <td class="text_left_on"><a href="${ctx}/promotion" class="Aleft">商品促销 <img src="${ctx}/images/btn_more.gif" /></a></td>
      </tr>
    </table>    </td>
    <td width="15"></td>
    <td width="170"><table width="170" border="0" cellspacing="0" cellpadding="0" bgcolor="#f8f8f8">
      <tr>
        <td width="10" rowspan="2" valign="top" background="${ctx}/images/bg_pic02f.gif"><img src="${ctx}/images/bg_pic02a.gif" /></td>
        <td rowspan="2" width="45" style="border-top:1px solid #e2e2e2"><img src="${ctx}/images/icon_left03.gif" /></td>
        <td class="text_left_en" style="border-top:1px solid #e2e2e2">Second-hand</td>
        <td width="10" rowspan="2" valign="top" background="${ctx}/images/bg_pic02g.gif"><img src="${ctx}/images/bg_pic02b.gif" /></td>
      </tr>
      <tr>
        <td bgcolor="#ffffff" class="text_left_on">二手信息 </td>
      </tr>
    </table>      </td>
    <td width="15"></td>
    <td width="170"><table width="170" border="0" cellspacing="0" cellpadding="0" bgcolor="#f8f8f8">
      <tr>
        <td width="10" rowspan="2" valign="top" background="${ctx}/images/bg_pic02f.gif"><img src="${ctx}/images/bg_pic02a.gif" /></td>
        <td rowspan="2" width="45" style="border-top:1px solid #e2e2e2"><img src="${ctx}/images/icon_left04.gif" /></td>
        <td class="text_left_en" style="border-top:1px solid #e2e2e2">Seller Ranking</td>
        <td width="10" rowspan="2" valign="top" background="${ctx}/images/bg_pic02g.gif"><img src="${ctx}/images/bg_pic02b.gif" /></td>
      </tr>
      <tr>
        <td class="text_left_on"><a href="${ctx }/report/rankList" class="Aleft">商家排行 <img src="${ctx}/images/btn_more.gif" /></a></td>
      </tr>
    </table>    </td>
	<td width="15"></td>
    <td>
    <form name="searchForm" action="${ctx}/freeSearch" method="post" target="_blank">
    <table border="0" cellspacing="0" cellpadding="0" align="right">
      <tr>
        <td width="50"><img src="${ctx}/images/icon_seach.gif" /></td>
        <td><label>
          <input type="text" name="searchkw" class="seach_input" value="${searchkw}"/>
          <input type="hidden" name="productId" id="productId"/>
          <input type="hidden" name="brandId" id="brandId"/>
        </label></td>
        <td width="15"></td>
        <td><img src="${ctx}/images/btn_seachgo.gif" width="41" height="41" onclick="javascript:document.searchForm.submit()" style="cursor:pointer"/></td>
      </tr>
    </table>
    </form>
    </td>
    <td width="10">&nbsp;</td>
  </tr>
  <tr>
    <td height="10" width="10"><img src="${ctx}/images/bg_pic00a.gif" /></td>
    <td background="${ctx}/images/bg_pic00e.gif"></td>
    <td background="${ctx}/images/bg_pic00e.gif"></td>
    <td background="${ctx}/images/bg_pic00e.gif"></td>
    <td background="${ctx}/images/bg_pic00e.gif"></td>
    <td background="${ctx}/images/bg_pic00e.gif"></td>
    <td bgcolor="#FFFFFF"></td>
    <td background="${ctx}/images/bg_pic00e.gif"></td>
    <td background="${ctx}/images/bg_pic00e.gif"></td>
    <td background="${ctx}/images/bg_pic00e.gif"></td>
    <td background="${ctx}/images/bg_pic00e.gif"></td>
    <td><img src="${ctx}/images/bg_pic00b.gif" /></td>
  </tr>
</table>
<!-- left menu end -->

<!-- center -->
<table border="0" cellspacing="0" cellpadding="0" width="95%" align="center">
  <tr valign="top">
	<td><table border="0" cellspacing="0" cellpadding="0" width="100%">
	  <tr>
		<td width="10" background="${ctx}/images/bg_pic00f.gif"></td>
		<td valign="top" bgcolor="#ffffff"><br />
		<table width="80%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td colspan="12">
				<form name="secondHandForm" action="${ctx }/secondHand" method="post">
				<label for="name">类别:</label><select id="categoryId" name="categoryId" ></select>
				<label for="name">产品:</label><select id="productId" name="productId"></select>
				<label for="name">名称:</label><input type="text" name="commodityName" value="${param.commodityName }"/>
				<input type="button" value="查询" onclick="search()"/>
			</form>
			</td>
		</tr>
	<c:choose>
	<c:when test="${empty secondHandList}">
			<tr>
			<th colspan="12">暂无数据!</th>
			</tr>
	</c:when>
	<c:otherwise>
		<tr>
			<th width="140">类别</th>
			<th>产品</th>
			<th>名称</th>
			<th>描述</th>
			<th>单价</th>
			<th>供应商</th>
			<th>联系人</th>
			<th>电话</th>
			<th>手机</th>
			<th>地址</th>
			<th>开始时间</th>
			<th>结束时间</th>
		</tr>
		<c:forEach var="secondHand" items="${secondHandList}" varStatus="status">
			<tr valign="top">
				<td width="140">${secondHand.categoryName}</td>
				<td>${secondHand.productName}</td>
				<td>${secondHand.commodityName}</td>
				<td>${secondHand.commodityDescription}</td>
				<td>${secondHand.commodityPrice }元</td>
				<td>${secondHand.supplierName }</td>
				<td>${secondHand.supplierContactname }</td>
				<td>${secondHand.supplierTelephone }</td>
				<td>${secondHand.supplierMobile }</td>
				<td>${secondHand.supplierAddress }</td>
				<td>${secondHand.startDate }</td>
				<td>${secondHand.endDate }</td>
			</tr>
			<tr>
				<td  colspan="12" background="${ctx}/images/line_01a.jpg" align="right"><img src="${ctx}/images/line_01b.jpg" /></td>
			</tr>
		</c:forEach>
	</c:otherwise>
</c:choose>
		<tr>
		<td colspan="12" style="text-align:center">
		<a href="javascript:goPage(1);" >首页</a>&nbsp;
		<a href="javascript:goPage(${pageNum - 1});">前一页</a>&nbsp;
		共<input type="text" name="pageNum" size=2 value="${pageNum }" onkeyup="CheckInputInt(this);" onchange="goPage(this.value);"/>/${pageCount}页&nbsp;
		<a href="javascript:goPage(${pageNum + 1});" >后一页</a>&nbsp;
		<a href="javascript:goPage(${pageCount})">尾页</a>&nbsp;
		共${total }条记录
		</td>
		</tr>
		</table>
		  </td>
		<td width="10" background="${ctx}/images/bg_pic00g.gif"></td>
	  </tr>
	  <tr>
		<td height="10"><img src="${ctx}/images/bg_pic00c.gif" /></td>
		<td background="${ctx}/images/bg_pic00h.gif"></td>
		<td><img src="${ctx}/images/bg_pic00d.gif" /></td>
	  </tr>
    </table></td>
  </tr>
</table>
<!-- center end -->

<br />

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
