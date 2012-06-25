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

	<div id="show-book" class="content scaffold-show" role="main">
		<h1>
			<spring:message code="registration.list" />
		</h1>

		<ol class="property-list book">


			<li class="fieldcontain"><span id="bname-label"
				class="property-label"><spring:message code="label.register.name"/></span> <span class="property-value"
				aria-labelledby="bname-label">${custom.register}</span></li>



			<li class="fieldcontain"><span id="bname-label"
				class="property-label"><spring:message code="label.register.gender"/></span> <span class="property-value"
				aria-labelledby="bname-label">${custom.gender}</span></li>



			<li class="fieldcontain"><span id="bname-label"
				class="property-label"><spring:message code="label.register.education"/></span> <span class="property-value"
				aria-labelledby="bname-label">${custom.education}</span></li>


			<li class="fieldcontain"><span id="bname-label"
				class="property-label"><spring:message code="label.register.area"/></span> <span class="property-value"
				aria-labelledby="bname-label">${custom.areaName}</span></li>




			<li class="fieldcontain"><span id="bname-label"
				class="property-label"><spring:message code="label.register.old_level"/></span> <span class="property-value"
				aria-labelledby="bname-label">${custom.oldLevel}</span></li>



			<li class="fieldcontain"><span id="bname-label"
				class="property-label"><spring:message code="label.register.new_level"/></span> <span class="property-value"
				aria-labelledby="bname-label">${custom.newLevel}</span></li>

			<li class="fieldcontain"><span id="bname-label"
				class="property-label"><spring:message code="label.register.id_card"/></span> <span class="property-value"
				aria-labelledby="bname-label">${custom.idCard}</span></li>
				
			<li class="fieldcontain"><span id="bname-label"
				class="property-label"><spring:message code="label.register.post_address"/></span> <span class="property-value"
				aria-labelledby="bname-label">${custom.postAddress}</span></li>
			
			<li class="fieldcontain"><span id="bname-label"
				class="property-label"><spring:message code="label.register.telephone"/></span> <span class="property-value"
				aria-labelledby="bname-label">${custom.phone}</span></li>
				
			<li class="fieldcontain"><span id="bname-label"
				class="property-label"><spring:message code="label.register.work_unit"/></span> <span class="property-value"
				aria-labelledby="bname-label">${custom.workUnit}</span></li>
				
			<li class="fieldcontain"><span id="bname-label"
				class="property-label"><spring:message code="label.register.unemployee_no"/></span> <span class="property-value"
				aria-labelledby="bname-label">${custom.unemployedNo}</span></li>
				
<!-- 			<li class="fieldcontain"><span id="bname-label" -->
<%-- 				class="property-label"><spring:message code="label.register.start_date"/></span> <span class="property-value" --%>
<!-- 				aria-labelledby="bname-label"> -->
<%-- 				<fmt:formatDate value="${custom.startDate}" type="time" timeStyle="full" pattern="yyyy-MM-dd"/> --%>
<!-- 				</span></li> -->
				
			<li class="fieldcontain"><span id="bname-label"
				class="property-label"><spring:message code="label.register.reg_date"/></span> <span class="property-value"
				aria-labelledby="bname-label">
				<fmt:formatDate value="${custom.registrationDate}" type="time" timeStyle="full" pattern="yyyy-MM-dd"/> 
				</span></li>
				
				<li class="fieldcontain"><span id="bname-label"
				class="property-label"><spring:message code="label.register.location"/></span> <span class="property-value"
				aria-labelledby="bname-label">${custom.locationName}</span></li>
		</ol>
		
		<br/>
		<div class="return_url">
			<a href="${ctx}/registration/list"><spring:message code="button.register.return"/></a>
		</div>
		
	</div>


	<jsp:include page="/common/footer.jsp" />
</body>
</html>