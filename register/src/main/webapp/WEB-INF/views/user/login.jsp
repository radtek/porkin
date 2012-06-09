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
<title><spring:message code="label.register.welcome"/></title>
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
<jsp:include page="/common/banner.jsp" />


	<a href="#create-race" class="skip" tabindex="-1">Skip to
		content&hellip;</a>
<!-- 	<div class="nav" role="navigation"> -->
<!-- 		<ul> -->
<!-- 			<li><a class="home" href="/racetrack/">Home</a></li> -->
<!-- 			<li><a href="/racetrack/race/list" class="list">Race List</a></li> -->
<!-- 		</ul> -->
<!-- 	</div> -->

	<div id="create-race" class="content scaffold-create" role="main">
		<h1><spring:message code="label.register.welcome"/></h1>

		<form action="${ctx}/user/login" method="post">
			<fieldset class="form">
			
				<div class="fieldcontain  required">
					<label for="login">
						<h3><spring:message code="user.login"/></h3>
					</label> 
				</div>
				<br/>

				<div class="fieldcontain  required">
					<label for="username">
						<spring:message code="user.username"/><span class="required-indicator">*</span>
					</label> 
					<input type="text" name="username" required="" value="" id="username" />
					<font color="red"><c:if test="${not empty userlogin}"><fmt:message key="${userlogin.text}" /></c:if></font>
				</div>
				
				<div class="fieldcontain  required">
					<label for="password">
						<spring:message code="user.password"/><span class="required-indicator">*</span>
					</label> 
					<input type="password" name="password" required="" value="" id="password" />
				</div>
				
				<br/>
				
			<fieldset class="fieldcontain  required">
				<label for="submit">&nbsp;<span class="required-indicator"></span>
					</label> 
					<input type="submit" name="submit" 
						class=btn3_mouseout onmouseover="this.className='btn3_mouseover'" 
						onmouseout="this.className='btn3_mouseout'"
						onmousedown="this.className='btn3_mousedown'"
						onmouseup="this.className='btn3_mouseup'"
						title='<spring:message code="button.register.submit"/>' value='<spring:message code="button.register.submit"/>' id="submit" />
						<span class="required-indicator">&nbsp;&nbsp;&nbsp;</span>
						<input type="reset" name="reset" 
						class=btn3_mouseout onmouseover="this.className='btn3_mouseover'" 
						onmouseout="this.className='btn3_mouseout'"
						onmousedown="this.className='btn3_mousedown'"
						onmouseup="this.className='btn3_mouseup'"
						title='<spring:message code="button.register.reset"/>' value='<spring:message code="button.register.reset"/>' id="reset" />
			</fieldset>
		</form>
	</div>

	<jsp:include page="/common/footer.jsp" />

</body>
</html>