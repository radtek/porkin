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
		$( "#start_date" ).datepicker();
	});
</script>

</head>
<body>
	<div id="grailsLogo" role="banner">
		<a href="http://grails.org"><img
			src="${ctx}/images/grails_logo.png" alt="Grails" /></a>
	</div>


	<a href="#create-race" class="skip" tabindex="-1">Skip to
		content&hellip;</a>
	<!-- 	<div class="nav" role="navigation"> -->
	<!-- 		<ul> -->
	<!-- 			<li><a class="home" href="/racetrack/">Home</a></li> -->
	<!-- 			<li><a href="/racetrack/race/list" class="list">Race List</a></li> -->
	<!-- 		</ul> -->
	<!-- 	</div> -->

	<div id="create-race" class="content scaffold-create" role="main">
		<h1>
			<spring:message code="label.register.welcome" />
		</h1>
		<br /> <br /> 

		<div>
			<div class="info_title">
				${name}: <spring:message code="registration.hello" />	
			</div>
			<br/> <br/>
			<div class="info_content"><spring:message code="registration.success" />			
			</div>
		</div>
		<br/><br/>
		<div class="return_url">
			<a href="${ctx}/enroll/welcome"><spring:message code="button.register.return"/></a>
		</div>
	</div>

	<div class="footer" role="contentinfo"></div>
	<div id="spinner" class="spinner" style="display: none;">Loading&hellip;</div>

	<script src="${ctx}/scripts/application.js" type="text/javascript"></script>

</body>
</html>