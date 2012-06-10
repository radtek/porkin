<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ include file="/common/taglibs.jsp"%>

<!doctype html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title><spring:message code="label.register.welcome" /></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="shortcut icon" href="${ctx}/images/favicon.ico"
	type="image/x-icon">
<link rel="apple-touch-icon" href="${ctx}/images/apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="114x114"
	href="${ctx}/images/apple-touch-icon-retina.png">
<link rel="stylesheet" href="${ctx}/styles/main.css" type="text/css">
<link rel="stylesheet" href="${ctx}/styles/mobile.css" type="text/css">

<link rel="stylesheet" href="${ctx}/styles/base/jquery.ui.all.css">
<script src="${ctx}/scripts/jquery/jquery-1.7.2.js"></script>
<script src="${ctx}/scripts/external/jquery.bgiframe-2.1.2.js"></script>
<script src="${ctx}/scripts/ui/jquery.ui.core.js"></script>
<script src="${ctx}/scripts/ui/jquery.ui.widget.js"></script>
<script src="${ctx}/scripts/ui/jquery.ui.mouse.js"></script>
<script src="${ctx}/scripts/ui/jquery.ui.datepicker.js"></script>

<script src="${ctx}/scripts/ui/i18n/jquery.ui.datepicker-zh-CN.js"></script>

<meta name="layout" content="main">
<script>
	$(function() {
		$("#start_date").datepicker();
	});
	
	/**
	 * 验证输入页码
	 * @param oInput
	 * @return
	 */
	function CheckInputInt(oInput)
	{
	    if('' != oInput.value.replace(/\d{1,}/,''))
	    {
	        oInput.value = oInput.value.match(/\d{1,}/) == null ? '' :oInput.value.match(/\d{1,}/);
	    }
	}
	/**
	 * 跳页
	 * @param obj
	 * @param totalPage
	 * @return
	 */
	function go(obj, totalPage) {
		if (obj.value - 0 > totalPage) {
			obj.value = totalPage;
	    }
		if (obj.value - 0 < 1) {
			obj.value = 1;
	    }
		window.location.href = "${ctx}/supplier/comments/${supplierId}?page=" + obj.value + "&rows=10";
	}

	/**
	 * 翻页
	 * @param pageNum
	 * @return
	 */
	function skip(pageNum) {
		window.location.href = "${ctx}/supplier/comments/${supplierId}?page=" + pageNum + "&rows=10";
	}
	
	function skip(pageNum) {
		window.location.href = "${ctx}/supplier/comments/${supplierId}?page=" + pageNum + "&rows=10";
	}
	
	
</script>

</head>
<body>
	<jsp:include page="/common/banner.jsp" />

	<a href="#list-book" class="skip" tabindex="-1">Skip to
		content&hellip;</a>
	<jsp:include page="/common/menu.jsp" />

	<div id="list-book" class="content scaffold-list" role="main">
		<h1>
			<spring:message code="registration.list" />
		</h1>

		<c:choose>
			<c:when test="${page.totalCount>0}">
				<table>
					<thead>
						<tr>
							<th class="sortable"><spring:message
									code="label.register.name" /></th>
							<th class="sortable"><spring:message
									code="label.register.gender" /></th>
							<th class="sortable"><spring:message
									code="label.register.id_card" /></th>
							<th class="sortable"><spring:message
									code="label.register.area" /></th>
							<th class="sortable"><spring:message
									code="label.register.new_level" /></th>
							<th class="sortable"><spring:message
									code="label.register.telephone" /></th>
							<th class="sortable">&nbsp;</th>
							<th class="sortable">&nbsp;</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach var="custom" items="${page.result}" varStatus="status">
							<tr class="even">
								<td>${custom.register}</td>
								<td>${custom.gender}</td>
								<td>${custom.idCard}</td>
								<td>${custom.areaName}</td>
								<td>${custom.newLevel}</td>
								<td>${custom.phone}</td>
								<td><a
									href="${ctx}/registration/show/${custom.registrationId}"><spring:message
											code="label.register.view" /></a></td>
								<td><a
									href="${ctx}/registration/detele/${custom.registrationId}"><spring:message
											code="label.register.delete" /></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:otherwise>
				<spring:message code="label.register.no_data" />
			</c:otherwise>
		</c:choose>

		<div class="pagination">
			<table width="560" border="0" align="center" cellpadding="0" cellspacing="0">
				<tr style="font-size:12px">
					<td align="center" class="page_number">
					<a href="javascript:void(0)" onclick="skip(1)">首页</a> &nbsp;&nbsp; 
					<a href="javascript:void(0)" onclick="skip(${page.prePage})">前一页</a> &nbsp;&nbsp;
					 第<input type="text" name="pageNum" size=2 value="${page.pageNo}" class="page_input" onkeyup="CheckInputInt(this);" onchange="go(this, ${page.pageNo });" />&nbsp;/&nbsp;${page.totalPages}
			&nbsp;&nbsp; <a href="javascript:void(0)"
				onclick="skip(${page.nextPage})">后一页</a>
			&nbsp;&nbsp; <a href="javascript:void(0)" onclick="skip(${page.totalPages})">尾页</a>
			&nbsp;&nbsp; 每页${page.pageSize}条&nbsp;/&nbsp; 共${page.totalCount }条记录</td>
		</tr>
	</table>
	</div>
	</div>

	<jsp:include page="/common/footer.jsp" />
</body>
</html>