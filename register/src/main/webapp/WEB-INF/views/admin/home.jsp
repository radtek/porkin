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
</script>

</head>
<body>
	<jsp:include page="/common/banner.jsp" />

	<a href="#list-book" class="skip" tabindex="-1">Skip to content&hellip;</a>
	<jsp:include page="/common/menu.jsp" />

		<div id="list-book" class="content scaffold-list" role="main">
			<h1><spring:message code="registration.list" /></h1>
			
			<table>
				<thead>
					<tr>
						<th class="sortable" ><spring:message code="label.register.name" /></th>
						<th class="sortable" ><spring:message code="label.register.gender" /></th>
						<th class="sortable" ><spring:message code="label.register.id_card" /></th>
						<th class="sortable" ><spring:message code="label.register.area" /></th>
						<th class="sortable" ><spring:message code="label.register.new_level" /></th>
						<th class="sortable" ><spring:message code="label.register.telephone" /></th>
						<th class="sortable" >&nbsp;</th>
						<th class="sortable" >&nbsp;</th>
					</tr>
				</thead>
				<tbody>
				
					<tr class="even">
						<td>da</td>
						<td>1</td>
						<td>2012-06-09 00:00:00 CST</td>
						<td>dfa</td>
						<td>111</td>
						<td><a href="/racetrack/book/show/1">abc</a></td>
					
					</tr>
				
				</tbody>
			</table>
			<div class="pagination">
				
			</div>
		</div>

		<jsp:include page="/common/footer.jsp" />
</body>
</html>