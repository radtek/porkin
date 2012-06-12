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
		
		window.location.href = "${ctx}/registration/display?pageNo=" + obj.value;
	}

	/**
	 * 翻页
	 * @param pageNum
	 * @return
	 */
	function skip(pageNum) {
		window.location.href = "${ctx}/registration/display?pageNo=" + pageNum;
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
		<br />
		<form action="${ctx}/registration/search" name="searchForm" id ="searchForm" method="POST">
		<input type="hidden" id="pageNo" name="pageNo" value="" />
		<div class="searchbar">
			<table>
				<tr>
					<td><spring:message code="label.register.name" />
						&nbsp;&nbsp;<input type="text" name="register" value="${register}" id="register" /></td>
					<td><spring:message code="label.register.id_card" />&nbsp;&nbsp;<input
						type="text" name="id_card" value="${id_card}" id="name" /></td>
					<td><spring:message code="label.register.telephone" />&nbsp;&nbsp;<input
						type="text" name="telephone" value="${telephone}" id="name" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.register.area" />&nbsp;&nbsp;
						<select name="area_id" id="area_id">
							<c:choose>
								<c:when test="${empty areaCache}">
									<option value="0">
										<spring:message code="label.register.no_data" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="0"><spring:message code="label.register.no_limit" /></option>
									<c:forEach var="area" items="${areaCache}" varStatus="status">
										<c:choose>
											<c:when test="$(area_id==area.areaId)">
												<option value='<c:out value="${area.areaId}"/>' selected="selected">
													<c:out value="${area.areaName}" />
												</option>
											</c:when>
											<c:otherwise>
												<option value='<c:out value="${area.areaId}"/>'>
													<c:out value="${area.areaName}" />
												</option>
											</c:otherwise>
										</c:choose>
										
									</c:forEach>
								</c:otherwise>
							</c:choose>
					</select></td>
					<td><spring:message code="label.register.old_level" /> <select
						name="old_level" id="old_level">
							<c:choose>
								<c:when test="${empty levelCache}">
									<option value="0">
										<spring:message code="label.register.no_data" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="0"><spring:message code="label.register.no_limit" /></option>
									<c:forEach var="level" items="${levelCache}" varStatus="status">
										<c:choose>
											<c:when test="${old_level==level.levelName} }">
												<option value='<c:out value="${level.levelName}"/>' selected="selected">
													<c:out value="${level.levelName}" />
												</option>
											</c:when>
											<c:otherwise>
												<option value='<c:out value="${level.levelName}"/>'>
													<c:out value="${level.levelName}" />
												</option>
											</c:otherwise>
										</c:choose>
										
									</c:forEach>
								</c:otherwise>
							</c:choose>
					</select></td>
					<td><spring:message code="label.register.new_level" /> <select
						name="new_level" id="new_level">
							<c:choose>
								<c:when test="${empty levelCache}">
									<option value="0">
										<spring:message code="label.register.no_data" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="0"><spring:message code="label.register.no_limit" /></option>
									<c:forEach var="level" items="${levelCache}" varStatus="status">
										<c:choose>
											<c:when test="${new_level==level.levelName}">
												<option value='<c:out value="${level.levelName}"/>' selected="selected">
													<c:out value="${level.levelName}" />
												</option>
											</c:when>
											<c:otherwise>
												<option value='<c:out value="${level.levelName}"/>'>
													<c:out value="${level.levelName}" />
												</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</c:otherwise>
							</c:choose>
					</select></td>
					
				</tr>
				<tr>
					<td>
						<spring:message code="label.register.start_date" /><br />
						<spring:message code="label.register.start_time" />&nbsp;:&nbsp;
						<input type="text" name="start_date" value="${start_date}" id="start_date" /><br />
						<spring:message code="label.register.end_time" />&nbsp;:&nbsp;
						<input type="text" name="end_date" value="${end_date}" id="end_date" />
					</td>
					<td><spring:message code="label.register.reg_date" /><br />
						<spring:message code="label.register.start_time" />&nbsp;:&nbsp;
						<input type="text" name="start_time"  value="${start_time}" id="start_time" /><br />
						<spring:message code="label.register.end_time" />&nbsp;:&nbsp;
						<input type="text" name="end_time"  value="${end_time}" id="end_time" /></td>
					<td>
					<spring:message code="label.register.location"/> <span class="required-indicator">*</span>
					<select name="location_id" id="location_id">
						<c:choose>
							<c:when test="${empty locationCache}">
								<option value="0"><spring:message code="label.register.no_data"/></option>
							</c:when>
							<c:otherwise>
								<option value="0"><spring:message code="label.register.no_limit" /></option>
								<c:forEach var="location" items="${locationCache}" varStatus="status">
									<c:choose>
										<c:when test="${location_id==location.locationId}">
											<option value="${location.locationId}" selected="selected">
												<c:out value="${location.locationName}"/>
											</option>
										</c:when>
										<c:otherwise>
											<option value="${location.locationId}"><c:out value="${location.locationName}"/></option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</select><br/><br/>
					<input type="submit" name="submit" 
						class=btn3_mouseout onmouseover="this.className='btn3_mouseover'" 
						onmouseout="this.className='btn3_mouseout'"
						onmousedown="this.className='btn3_mousedown'"
						onmouseup="this.className='btn3_mouseup'"
						title='<spring:message code="button.register.search"/>' value='<spring:message code="button.register.search"/>' id="submit" />
						<span class="required-indicator">&nbsp;&nbsp;&nbsp;</span>
						<input type="reset" name="reset" 
						class=btn3_mouseout onmouseover="this.className='btn3_mouseover'" 
						onmouseout="this.className='btn3_mouseout'"
						onmousedown="this.className='btn3_mousedown'"
						onmouseup="this.className='btn3_mouseup'"
						title='<spring:message code="button.register.export"/>' value='<spring:message code="button.register.export"/>' id="reset" />
					</td>
				</tr>
			</table>
		</div>
		</form>
		<br />

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
								<td>
									<form action="${ctx}/registration/show/${custom.registrationId}">
										<input type="submit" value='<spring:message code="label.register.view" />' class="delete"/>
									</form>
								</td>
								<td>
									<form action="${ctx}/registration/delete">
										<input type="hidden" name="id" value="${custom.registrationId}" id="id" />
										<input type="submit" name="_action_delete" value='<spring:message code="label.register.delete" />' class="delete" onclick="return confirm(&#39;<spring:message code="label.register.confirm_delete" />&#39;);" />
									</form>
							
								</td>
								
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:otherwise>
				<div class="info_title"><spring:message code="label.register.no_data" />
				<br/><br/><br/>
				</div>
				
			</c:otherwise>
		</c:choose>

		<div class="pagination">
			<a
						href="javascript:void(0)" onclick="skip(1)">首页</a> &nbsp;&nbsp; <a
						href="javascript:void(0)" onclick="skip(${page.prePage})">前一页</a>
						&nbsp;&nbsp; 第<input type="text" name="pageNo" size=2
						value="${page.pageNo}" class="page_input"
						onkeyup="CheckInputInt(this);"
						onchange="go(this, ${page.pageNo });" />&nbsp;/&nbsp;${page.totalPages}
						&nbsp;&nbsp; <a href="javascript:void(0)"
						onclick="skip(${page.nextPage})">后一页</a> &nbsp;&nbsp; <a
						href="javascript:void(0)" onclick="skip(${page.totalPages})">尾页</a>
						&nbsp;&nbsp; 每页${page.pageSize}条&nbsp;/&nbsp; 共${page.totalCount
						}条记录</td>
		</div>
	</div>

	<jsp:include page="/common/footer.jsp" />
</body>
</html>