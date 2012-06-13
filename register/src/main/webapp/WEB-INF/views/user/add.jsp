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
function doExport(){
	document.searchForm.action="${ctx}/registration/export";
	document.searchForm.submit();
}

function doSearch(){
	document.searchForm.action="${ctx}/registration/search";
	document.searchForm.submit();
}

</script>

</head>
<body>
	<jsp:include page="/common/banner.jsp" />

	<a href="#list-book" class="skip" tabindex="-1">Skip to
		content&hellip;</a>
	<jsp:include page="/common/menu.jsp" />

	<div id="create-race" class="content scaffold-create" role="main">
		<h1><spring:message code="registration.adduser"/>&nbsp;&nbsp;&nbsp;</h1>
		
		<c:if test="${not empty useradd}">
			<div class="searchbar">
			<br/>
			<h3>&nbsp;&nbsp;&nbsp;&nbsp;<font color="red"><fmt:message key="${useradd.text}" /></font>
			</h3>
			</div>
		</c:if>
		<br/>
		<form action="${ctx}/user/create" method="post">
			<fieldset class="form">

				<div class="fieldcontain  required">
					<label for="username">
						<spring:message code="user.username"/><span class="required-indicator">*</span>
					</label> 
					<input type="text" name="username" required="" value="" id="username" />
				</div>
				
				<div class="fieldcontain  required">
					<label for="password">
						<spring:message code="user.password"/><span class="required-indicator">*</span>
					</label> 
					<input type="password" name="password" required="" value="" id="password" />
				</div>
				
				<div class="fieldcontain  required">
					<label for="password2">
						<spring:message code="user.password"/><span class="required-indicator">*</span>
					</label> 
					<input type="password" name="password2" required="" value="" id="password2" />
				</div>
				
				<div class="fieldcontain  required">
					<label for="email">
						<spring:message code="user.email"/><span class="required-indicator"></span>
					</label> 
					<input type="text" name="email"  value="" id="email" />
				</div>

				<div class="fieldcontain  required">
					<label for="roleFlag"> 
						<spring:message code="user.role"/> <span class="required-indicator">*</span>
					</label> 
					<select name="roleFlag" required="" id="roleFlag">
						<option value="A" selected="selected"><spring:message code="user.role.admin"/></option>
						<option value="U"> <spring:message code="user.role.user"/></option>
					</select>
				</div>
				
				<div class="fieldcontain  required">
					<label for="active"> 
						<spring:message code="user.active"/> <span class="required-indicator">*</span>
					</label> 
					<select name="active" required="" id="active">
						<option value="Y" selected="selected"><spring:message code="user.active.yes"/></option>
						<option value="N"> <spring:message code="user.active.no"/></option>
					</select>
				</div>

			</fieldset>

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