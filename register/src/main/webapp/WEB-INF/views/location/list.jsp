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
	
	$(function() {
		$("#end_date").datepicker();
	});
	
	$(function() {
		$("#start_time").datepicker();
	});
	
	$(function() {
		$("#end_time").datepicker();
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
		
		window.location.href = "${ctx}/location/display?pageNo=" + obj.value;
	}

	/**
	 * 翻页
	 * @param pageNum
	 * @return
	 */
	function skip(pageNum) {
		window.location.href = "${ctx}/location/display?pageNo=" + pageNum;
	}
	
</script>

<script type="text/javascript">
	
	function doDelete(id){
		var confirm1 = confirm(' <spring:message code="label.register.confirm_delete" /> ');
		var formid = "locationform"+id;
		document.getElementById(formid).action ="${ctx}/location/delete";
		document.getElementById(formid).submit();
	}
	
	function doSave(id){
		var formid = "locationform"+id;
		document.getElementById(formid).action ="${ctx}/location/save";
		document.getElementById(formid).submit();
	}
	
	function showlocationForm(){
		window.open ('${ctx}/location/addForm','<spring:message code="label.register.create" />','height=185,width=550,top=50,left=200,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no,status=no,depended=yes,titlebar=no,scrollbars=no,toolbar=no');
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
			<spring:message code="location.list" />
		</h1>
		<br />
		<div class="searchbar">
			<input type="button" name="_action_delete"
				value='<spring:message code="label.register.create" />'
				class="delete" onclick="showlocationForm()" />
		</div>

		<br />
		<c:choose>
			<c:when test="${page.totalCount>0}">
				<table>
					<thead>
						<tr>
							<th class="sortable"><spring:message code="lable.list.no" /></th>
							<th class="sortable"><spring:message
									code="label.register.location" /></th>
							<th class="sortable">&nbsp;</th>
							<th class="sortable">&nbsp;</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach var="location" items="${page.result}" varStatus="status">
							<form id="locationform${location.locationId}" name="locationform${location.locationId}"
								method="post">
								<tr class="even">

									<td>${location.locationId}</td>
									<td><input type="hidden" name="id" value="${location.locationId}"
										id="id" /> <input type="text" name="locationName" required=""
										value="${location.locationName}" id="locationName" /></td>
									<td><input type="button" name="_action_delete"
										value='<spring:message code="label.register.delete" />'
										class="delete" onclick="doDelete(${location.locationId});" /></td>
									<td><input type="button" name="_action_delete"
										value='<spring:message code="label.register.save" />'
										class="delete" onclick="doSave(${location.locationId});" /></td>
								</tr>
							</form>

						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:otherwise>
				<div class="info_title">
					<spring:message code="label.register.no_data" />
					<br />
					<br />
					<br />
				</div>

			</c:otherwise>
		</c:choose>
		<div class="pagination">
			<a href="javascript:void(0)" onclick="skip(1)"><spring:message
					code="label.register.firstpage" /></a> &nbsp;&nbsp; <a
				href="javascript:void(0)" onclick="skip(${page.prePage})"><spring:message
					code="label.register.prevpage" /></a> &nbsp;&nbsp;
			<spring:message code="label.register.thepage" />
			<input type="text" name="pageNo" size=2 value="${page.pageNo}"
				class="page_input" onkeyup="CheckInputInt(this);"
				onchange="go(this, ${page.totalPages });" />
			&nbsp;/&nbsp;${page.totalPages} &nbsp;&nbsp; <a
				href="javascript:void(0)" onclick="skip(${page.nextPage})"><spring:message
					code="label.register.nextpage" /></a> &nbsp;&nbsp; <a
				href="javascript:void(0)" onclick="skip(${page.totalPages})"><spring:message
					code="label.register.lastpage" /></a> &nbsp;&nbsp;
			<spring:message code="label.register.everypage" />
			${page.pageSize}
			<spring:message code="label.register.items" />
			&nbsp;/&nbsp;
			<spring:message code="label.register.total" />
			${page.totalCount}
			<spring:message code="label.register.records" />
		</div>
	</div>

	<jsp:include page="/common/footer.jsp" />
</body>
</html>