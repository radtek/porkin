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

<script type="text/javascript">
	
	function closeWindow(){
		window.opener.location.reload();
		window.close();
		
	}
	
</script>

</head>
<body>
	<div id="list-book" class="content scaffold-list" role="main">
		<br/>
		<form action="${ctx}/user/create" method="post" name="userForm" id="userForm">
			<fieldset class="form">
				<div class="fieldcontain  required">
					<label for="name">
						<b><spring:message code="registration.adduser" /></b>
					</label> 
				</div>
				<div class="fieldcontain  required">
					<label for="userName">
						&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="${user.text}" />
					</label> 
				</div>
			<fieldset class="fieldcontain  required">
				<label for="submit">&nbsp;<span class="required-indicator"></span>
					</label> 
					<input type="button" name="submit" 
						class=btn3_mouseout onmouseover="this.className='btn3_mouseover'" 
						onmouseout="this.className='btn3_mouseout'"
						onmousedown="this.className='btn3_mousedown'"
						onmouseup="this.className='btn3_mouseup'"
						title='<spring:message code="button.register.close"/>'  onclick="closeWindow()" value='<spring:message code="button.register.close"/>' id="submit" />
						<span class="required-indicator">&nbsp;&nbsp;&nbsp;</span>
						
			</fieldset>
		</form>
	</div>
</body>
</html>