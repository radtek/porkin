<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ include file="/common/taglibs.jsp"%>

<!doctype html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title>Welcome to Grails</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${ctx}/images/favicon.ico" type="image/x-icon">
		<link rel="apple-touch-icon" href="${ctx}/images/apple-touch-icon.png">
		<link rel="apple-touch-icon" sizes="114x114" href="/racetrack/static/images/apple-touch-icon-retina.png">
		<link rel="stylesheet" href="${ctx}/styles/main.css" type="text/css">
		<link rel="stylesheet" href="${ctx}/styles/mobile.css" type="text/css">
		
		<meta name="layout" content="main"/>
		
		<style type="text/css" media="screen">
			#status {
				background-color: #eee;
				border: .2em solid #fff;
				margin: 2em 2em 1em;
				padding: 1em;
				width: 12em;
				float: left;
				-moz-box-shadow: 0px 0px 1.25em #ccc;
				-webkit-box-shadow: 0px 0px 1.25em #ccc;
				box-shadow: 0px 0px 1.25em #ccc;
				-moz-border-radius: 0.6em;
				-webkit-border-radius: 0.6em;
				border-radius: 0.6em;
			}

			.ie6 #status {
				display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
			}

			#status ul {
				font-size: 0.9em;
				list-style-type: none;
				margin-bottom: 0.6em;
				padding: 0;
			}
            
			#status li {
				line-height: 1.3;
			}

			#status h1 {
				text-transform: uppercase;
				font-size: 1.1em;
				margin: 0 0 0.3em;
			}

			#page-body {
				margin: 2em 1em 1.25em 18em;
			}

			h2 {
				margin-top: 1em;
				margin-bottom: 0.3em;
				font-size: 1em;
			}

			p {
				line-height: 1.5;
				margin: 0.25em 0;
			}

			#controller-list ul {
				list-style-position: inside;
			}

			#controller-list li {
				line-height: 1.3;
				list-style-position: inside;
				margin: 0.25em 0;
			}

			@media screen and (max-width: 480px) {
				#status {
					display: none;
				}

				#page-body {
					margin: 0 1em 1em;
				}

				#page-body h1 {
					margin-top: 0;
				}
			}
		</style>


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