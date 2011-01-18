<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商讯网--商家排行</title>
<link href="${ctx}/styles/main2.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${ctx}/scripts/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="${ctx}/scripts/searchbar.js"></script>
<script type="text/javascript" src="${ctx}/scripts/common/common.js"></script>
<script type="text/javascript" src="${ctx}/scripts/commoditylist.js"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<table border="0" cellspacing="0" cellpadding="0" width="100%"
	align="center">
	<tr>
		<td height="25"></td>
	</tr>
</table>

<!-- center -->
<table border="0" cellspacing="0" cellpadding="0" width="950"
	align="center">
	<tr valign="top">
		<td width="190"><!-- left menu -->
		<table border="0" cellspacing="0" cellpadding="0">
			<tr valign="top">
				<td><!-- left menu on -->
				<table border="0" cellspacing="0" cellpadding="0" width="190">
					<tr>
						<td height="10" width="10"><img src="../images/bg_pic02a.gif" /></td>
						<td background="../images/bg_pic02e.gif" colspan="2"></td>
						<td width="10"><img src="../images/bg_pic02b.gif" /></td>
						<td width="20"></td>
					</tr>
					<tr>
						<td background="../images/bg_pic02f.gif" rowspan="2"></td>
						<td bgcolor="#f8f8f8" rowspan="2" width="45"><img
							src="../images/icon_left01.gif" /></td>

						<td bgcolor="#f8f8f8" class="text_left_en">Commerce Net Guide</td>
						<td background="../images/bg_pic02g.gif" rowspan="2"></td>
						<td rowspan="2"></td>
					</tr>
					<tr>
						<td bgcolor="#f8f8f8" class="text_left"><a href="${ctx}"
							class="Aleft">商讯导购 <img src="../images/btn_more.gif" /></a></td>
					</tr>
					<tr>

						<td height="10"><img src="../images/bg_pic02c.gif" /></td>
						<td background="../images/bg_pic02h.gif" colspan="2"></td>
						<td><img src="../images/bg_pic02d.gif" /></td>
						<td></td>
					</tr>
					<tr>
						<td height="10"></td>
						<td colspan="2"></td>
						<td></td>
						<td></td>
					</tr>
				</table>
				<!-- left menu on end --></td>
			</tr>
			<tr>
				<td><!-- left menu off -->
				<table border="0" cellspacing="0" cellpadding="0" width="190">
					<tr>
						<td height="10" width="10"><img src="../images/bg_pic02a.gif" /></td>
						<td background="../images/bg_pic02e.gif" colspan="2"></td>
						<td width="10"><img src="../images/bg_pic02b.gif" /></td>
						<td width="20"></td>
					</tr>
					<tr>
						<td background="../images/bg_pic02f.gif" rowspan="2"></td>
						<td bgcolor="#f8f8f8" rowspan="2" width="45"><img
							src="../images/icon_left02.gif" /></td>
						<td bgcolor="#f8f8f8" class="text_left_en">Goods Promotion</td>
						<td background="../images/bg_pic02g.gif" rowspan="2"></td>
						<td rowspan="2"></td>
					</tr>
					<tr>
						<td bgcolor="#f8f8f8" class="text_left"><a
							href="${ctx }/promotion" class="Aleft">商品促销 <img
							src="../images/btn_more.gif" /></a></td>
					</tr>
					<tr>
						<td height="10"><img src="../images/bg_pic02c.gif" /></td>
						<td background="../images/bg_pic02h.gif" colspan="2"></td>
						<td><img src="../images/bg_pic02d.gif" /></td>
						<td></td>
					</tr>
					<tr>
						<td height="10"></td>
						<td colspan="2"></td>
						<td></td>
						<td><img src="../images/bg_pic01g.gif"></td>
					</tr>
				</table>
				<!-- left menu off end --></td>
			</tr>
			<tr>
				<td><!-- left menu off -->
				<table border="0" cellspacing="0" cellpadding="0" width="190">
					<tr>
						<td height="10" width="10"><img src="../images/bg_pic02a.gif" /></td>
						<td background="../images/bg_pic02e.gif" colspan="2"></td>
						<td width="10"><img src="../images/bg_pic02b.gif" /></td>
						<td width="20"></td>
					</tr>
					<tr>
						<td background="../images/bg_pic02f.gif" rowspan="2"></td>
						<td bgcolor="#f8f8f8" rowspan="2" width="45"><img
							src="../images/icon_left03.gif" /></td>
						<td bgcolor="#f8f8f8" class="text_left_en">Second-hand</td>
						<td background="../images/bg_pic02g.gif" rowspan="2"></td>
						<td rowspan="2"></td>
					</tr>
					<tr>
						<td bgcolor="#f8f8f8" class="text_left"><a
							href="${ctx}/secondHand" class="Aleft">二手信息<img
							src="../images/btn_more.gif" /></a></td>
					</tr>
					<tr>
						<td height="10"><img src="../images/bg_pic02c.gif" /></td>
						<td background="../images/bg_pic02h.gif" colspan="2"></td>
						<td><img src="../images/bg_pic02d.gif" /></td>
						<td></td>
					</tr>
					<tr>
						<td height="10"></td>
						<td colspan="2"></td>
						<td></td>
						<td><img src="../images/bg_pic01g.gif" /></td>
					</tr>
				</table>
				<!-- left menu off end --></td>
			</tr>
			<tr>
				<td><!-- left menu off -->
				<table border="0" cellspacing="0" cellpadding="0" width="190">
					<tr>
						<td height="10" width="10"><img src="../images/bg_pic00a.gif" /></td>
						<td background="../images/bg_pic00e.gif" colspan="2"></td>
						<td background="../images/bg_pic00e.gif" width="10"></td>
						<td width="20"><img src="../images/bg_pic01f.gif" /></td>
					</tr>
					<tr>

						<td background="../images/bg_pic00f.gif" rowspan="2"></td>
						<td bgcolor="#ffffff" rowspan="2" width="45"><img
							src="../images/icon_left04.gif" /></td>
						<td bgcolor="#ffffff" class="text_left_en">Seller Ranking</td>
						<td bgcolor="#ffffff" rowspan="2"></td>
						<td bgcolor="#ffffff" rowspan="2"></td>
					</tr>
					<tr>
						<td bgcolor="#ffffff" class="text_left_on">商家排行</td>

					</tr>
					<tr>
						<td height="10"><img src="../images/bg_pic00c.gif" /></td>
						<td background="../images/bg_pic00h.gif" colspan="2"></td>
						<td background="../images/bg_pic00h.gif"></td>
						<td><img src="../images/bg_pic01d.gif" /></td>
					</tr>
					<tr>
						<td height="10"></td>

						<td colspan="2"></td>
						<td></td>
						<td><img src="../images/bg_pic01e.gif" /></td>
					</tr>
				</table>

				<!-- left menu off end --></td>
			</tr>
		</table>
		<!-- left menu end --></td>

		<td>
		<table border="0" cellspacing="0" cellpadding="0" width="100%">
			<tr>
				<td height="10" width="10"><img src="../images/bg_pic00a.gif" /></td>
				<td background="../images/bg_pic00e.gif"></td>
				<td width="10"><img src="../images/bg_pic00b.gif" /></td>
			</tr>
			<tr>

				<td valign="top" background="../images/bg_pic00f.gif"
					style="padding-top: 194px"><img
					src="../images/color_white.gif" width="10" height="72" /></td>
				<td bgcolor="#ffffff" valign="top">
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
											<td width="63"><img src="../images/dot02.gif" />第<c:out
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
							background="../images/line_02a.jpg"><img
							src="../images/line_02b.jpg" /></td>
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
											<td width="63"><img src="../images/dot02.gif" />第<c:out
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
							background="../images/line_02a.jpg"><img
							src="../images/line_02b.jpg" /></td>
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
											<td width="63"><img src="../images/dot02.gif" />第<c:out
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
						<td valign="top"><img src="../images/ad_pic/ad003.jpg" width="210"
							height="140" /></td>
						<td valign="top"><img src="../images/ad_pic/ad004.jpg" width="210"
							height="140" /></td>
						<td valign="top"><img src="../images/ad_pic/ad005.jpg" width="210"
							height="140" /></td>
					</tr>

				</table>
				<!-- 广告 end --></td>
				<td background="../images/bg_pic00g.gif"></td>
			</tr>
			<tr>
				<td height="10"><img src="../images/bg_pic00c.gif" /></td>
				<td background="../images/bg_pic00h.gif"></td>
				<td><img src="../images/bg_pic00d.gif" /></td>

			</tr>
		</table>
		</td>
	</tr>
</table>
<!-- center end -->

<br />



<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
