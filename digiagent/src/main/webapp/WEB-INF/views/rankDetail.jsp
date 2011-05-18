<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商讯网--商家排行</title>
<link href="${ctx}/styles/main2.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<table border="0" cellspacing="0" cellpadding="0" width="100%"
	align="center">
	<tr>
		<td height="25"></td>
	</tr>
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
        <td class="text_left_on"><a href="${ctx}/secondHand" class="Aleft">二手信息 <img src="${ctx}/images/btn_more.gif" /></a></td>
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
        <td bgcolor="#ffffff" class="text_left_on">商家排行 </td>
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
    <td background="${ctx}/images/bg_pic00e.gif"></td>
    <td background="${ctx}/images/bg_pic00e.gif"></td>
    <td bgcolor="#FFFFFF"></td>
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
				<table border="0" align="center" cellpadding="0" cellspacing="0">
					<tr valign="top">
						<td width="220"><!-- 日访问量 Top10 -->
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td class="title_color04">日访问量 Top10</td>

							</tr>
							<tr>
								<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<!-- 每一条信息循环 -->
									<c:set var="dayNo" value="0" />
									<c:forEach items="${daily}" var="dataMap">
										<tr>
											<td height="8" colspan="3"></td>
										</tr>
										<tr>
											<c:set var="supplierName" value="" />
											<c:set var="supplierId" value="0" />
											<c:set var="supplierCount" value="0" />
											<c:set var="dayNo" value="${dayNo +1 }" />
											<c:forEach var="mapItem" items="${dataMap}">
												<c:if test="${mapItem.key =='SUPPLIER'}">
													<c:set var="supplierName" value="${mapItem.value}" />
												</c:if>
												<c:if test="${mapItem.key =='SUPPLIER_ID'}">
													<c:set var="supplierId" value="${mapItem.value}" />
												</c:if>
												<c:if test="${mapItem.key =='COUNT'}">
													<c:set var="supplierCount" value="${mapItem.value}" />
												</c:if>
											</c:forEach>
											<td width="63"><img src="${ctx}/images/dot02.gif" />第<c:out
												value="${dayNo}" />名：</td>
											<td><a
												href='${ctx}/supplier/<c:out value= "${supplierId}" />'><c:out
												value="${supplierName}" /></a></td>
											<td width="60">共<c:out value="${supplierCount}" />次</td>
										</tr>
										<tr>
											<td height="1" colspan="3" bgcolor="#d6d6d6"></td>
										</tr>

										<!-- 每一条信息循环 end -->
									</c:forEach>
								</table>
								</td>
							</tr>
						</table>

						<!-- 日访问量 Top10 end --></td>
						<td width="25" rowspan="2" valign="bottom"
							background="${ctx}/images/line_02a.jpg"><img
							src="${ctx}/images/line_02b.jpg" /></td>
						<td width="220">
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td class="title_color05">周访问量 Top10</td>
							</tr>
							<tr>

								<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<!-- 每一条信息循环 -->
									<c:set var="weekNo" value="0" />
									<c:forEach items="${weekly}" var="dataMap">
										<tr>
											<td height="8" colspan="3"></td>
										</tr>
										<c:set var="supplierName" value="" />
										<c:set var="supplierId" value="0" />
										<c:set var="supplierCount" value="0" />
										<c:set var="weekNo" value="${weekNo +1}" />
										<c:forEach var="mapItem" items="${dataMap}">
											<c:if test="${mapItem.key =='SUPPLIER'}">
												<c:set var="supplierName" value="${mapItem.value}" />
											</c:if>
											<c:if test="${mapItem.key =='SUPPLIER_ID'}">
												<c:set var="supplierId" value="${mapItem.value}" />
											</c:if>
											<c:if test="${mapItem.key =='COUNT'}">
												<c:set var="supplierCount" value="${mapItem.value}" />
											</c:if>
										</c:forEach>
										<tr>
											<td width="63"><img src="${ctx}/images/dot02.gif" />第<c:out
												value="${weekNo}" />名：</td>
											<td><a
												href='${ctx}/supplier/<c:out value= "${supplierId}" />'><c:out
												value="${supplierName}" /></a></td>

											<td width="60">共<c:out value="${supplierCount}" />次</td>
										</tr>
										<tr>
											<td height="1" colspan="3" bgcolor="#d6d6d6"></td>
										</tr>
										<!-- 每一条信息循环 end -->
									</c:forEach>
								</table>
								</td>
							</tr>
						</table>
						</td>
						<td width="25" rowspan="2" valign="bottom"
							background="${ctx}/images/line_02a.jpg"><img
							src="${ctx}/images/line_02b.jpg" /></td>
						<td width="220">
						<table width="100%" border="0" cellpadding="0" cellspacing="0">

							<tr>
								<td class="title_color06">月访问量 Top10</td>
							</tr>
							<tr>
								<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<!-- 每一条信息循环 -->
									<c:set var="monthNo" value="0" />
									<c:forEach items="${monthly}" var="dataMap">
										<tr>
											<td height="8" colspan="3"></td>
										</tr>
										<c:set var="supplierName" value="" />
										<c:set var="supplierId" value="0" />
										<c:set var="supplierCount" value="0" />
										<c:set var="monthNo" value="${monthNo+1}" />
										<c:forEach var="mapItem" items="${dataMap}">
											<c:if test="${mapItem.key =='SUPPLIER'}">
												<c:set var="supplierName" value="${mapItem.value}" />
											</c:if>
											<c:if test="${mapItem.key =='SUPPLIER_ID'}">
												<c:set var="supplierId" value="${mapItem.value}" />
											</c:if>
											<c:if test="${mapItem.key =='COUNT'}">
												<c:set var="supplierCount" value="${mapItem.value}" />
											</c:if>
										</c:forEach>
										<tr>
											<td width="63"><img src="${ctx}/images/dot02.gif" />第<c:out
												value="${monthNo}" />名：</td>
											<td><a
												href='${ctx}/supplier/<c:out value= "${supplierId}" />'><c:out
												value="${supplierName}" /></a></td>
											<td width="60">共<c:out value="${supplierCount}" />次</td>
										</tr>
										<tr>
											<td height="1" colspan="3" bgcolor="#d6d6d6"></td>
										</tr>
									</c:forEach>
								</table>
								</td>
							</tr>
						</table>
						</td>
					</tr>
					<tr valign="top">
						<td height="30"></td>
						<td></td>
						<td></td>

					</tr>
				</table>
				<!-- 广告 -->
				<table width="100%" height="160" border="0" align="center"
					cellpadding="0" cellspacing="0">
					<tr align="center">
						<td valign="top"><img src="${ctx}/images/ad_pic/ad003.jpg" width="210"
							height="140" /></td>
						<td valign="top"><img src="${ctx}/images/ad_pic/ad004.jpg" width="210"
							height="140" /></td>
						<td valign="top"><img src="${ctx}/images/ad_pic/ad005.jpg" width="210"
							height="140" /></td>
					</tr>

				</table>
				<!-- 广告 end -->
				 <!-- seller introduction end -->
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
