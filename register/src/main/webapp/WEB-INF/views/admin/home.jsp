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
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="/racetrack/">Home</a></li>
				<li><a href="/racetrack/book/create" class="create">New Book</a></li>
			</ul>
		</div>
		<div id="list-book" class="content scaffold-list" role="main">
			<h1>Book List</h1>
			
			<table>
				<thead>
					<tr>
					
						<th class="sortable" ><a href="/racetrack/book/list?sort=bname&amp;max=10&amp;order=asc">Bname</a></th>
					
						<th class="sortable" ><a href="/racetrack/book/list?sort=btype&amp;max=10&amp;order=asc">Btype</a></th>
					
						<th class="sortable" ><a href="/racetrack/book/list?sort=counter&amp;max=10&amp;order=asc">Counter</a></th>
					
						<th class="sortable" ><a href="/racetrack/book/list?sort=inTime&amp;max=10&amp;order=asc">In Time</a></th>
					
						<th class="sortable" ><a href="/racetrack/book/list?sort=memo&amp;max=10&amp;order=asc">Memo</a></th>
					
						<th class="sortable" ><a href="/racetrack/book/list?sort=price&amp;max=10&amp;order=asc">Price</a></th>
					
					</tr>
				</thead>
				<tbody>
				
					<tr class="even">
					
						<td><a href="/racetrack/book/show/1">abc</a></td>
					
						<td>da</td>
					
						<td>1</td>
					
						<td>2012-06-09 00:00:00 CST</td>
					
						<td>dfa</td>
					
						<td>111</td>
					
					</tr>
				
				</tbody>
			</table>
			<div class="pagination">
				
			</div>
		</div>

		<jsp:include page="/common/footer.jsp" />
</body>
</html>