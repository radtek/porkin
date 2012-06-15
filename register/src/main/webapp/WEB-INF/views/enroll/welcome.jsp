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

		<form action="${ctx}/enroll/registration" method="post">
			<fieldset class="form">

				<div class="fieldcontain  required">
					<label for="name">
						<spring:message code="label.register.name"/><span class="required-indicator">*</span>
					</label> 
					<input type="text" name="name" required="" value="${name}" id="name" />
					<font color="red"><c:if test="${not empty register}"><fmt:message key="${register.text}" /></c:if></font>
				</div>
				
				<div class="fieldcontain  required">
					<label for="gender"> 
						<spring:message code="label.register.gender"/> <span class="required-indicator">*</span>
					</label> 
					<select name="gender" required="" id="gender">
						<option value='<spring:message code="label.register.gender.male"/>' selected="selected"><spring:message code="label.register.gender.male"/></option>
						<option value='<spring:message code="label.register.gender.female"/>'><spring:message code="label.register.gender.female"/></option>
					</select>
				</div>
				
				<div class="fieldcontain  required">
					<label for="education"> 
						<spring:message code="label.register.education"/> <span class="required-indicator">*</span>
					</label> 
					<select name="education" required="" id="education">
						<c:choose>
							<c:when test="${empty educationCache}">
								<option value="0"><spring:message code="label.register.no_data"/></option>
							</c:when>
							<c:otherwise>
								<c:forEach var="education" items="${educationCache}" varStatus="status">
									<option value='<c:out value="${education.educationName}"/>'><c:out value="${education.educationName}"/></option>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</select>
				</div>
				
				<div class="fieldcontain  required">
					<label for="area"> 
						<spring:message code="label.register.area"/> <span class="required-indicator">*</span>
					</label> 
					<select name="area" required="" id="area">
						<c:choose>
							<c:when test="${empty areaCache}">
								<option value="0"><spring:message code="label.register.no_data"/></option>
							</c:when>
							<c:otherwise>
								<c:forEach var="area" items="${areaCache}" varStatus="status">
									<option value='<c:out value="${area.areaId}"/>'><c:out value="${area.areaName}"/></option>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</select>
				</div>

				<div class="fieldcontain  required">
					<label for="old_level"> <spring:message code="label.register.old_level"/> <span class="required-indicator">*</span>
					</label> <select name="old_level" required="" id="old_level">
						<c:choose>
							<c:when test="${empty levelCache}">
								<option value="0"><spring:message code="label.register.no_data"/></option>
							</c:when>
							<c:otherwise>
								<c:forEach var="level" items="${levelCache}" varStatus="status">
									<option value='<c:out value="${level.levelName}"/>'><c:out value="${level.levelName}"/></option>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</select>
				</div>
				
				<div class="fieldcontain  required">
					<label for="new_level"> <spring:message code="label.register.new_level"/> <span class="required-indicator">*</span>
					</label> <select name="new_level" required="" id="new_level">
						<c:choose>
							<c:when test="${empty levelCache}">
								<option value="0"><spring:message code="label.register.no_data"/></option>
							</c:when>
							<c:otherwise>
								<c:forEach var="level" items="${levelCache}" varStatus="status">
									<option value='<c:out value="${level.levelName}"/>'><c:out value="${level.levelName}"/></option>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</select>
				</div>
				
				<div class="fieldcontain  required">
					<label for="id_card">
						<spring:message code="label.register.id_card"/><span class="required-indicator">*</span>
					</label> 
					<input type="text" name="id_card" required="" value="${id_card}" id="id_card" />
					<font color="red"><c:if test="${not empty idcard}"><fmt:message key="${idcard.text}" /></c:if></font>
				</div>
				
				<div class="fieldcontain  ">
					<label for="unemployee_no">
						<spring:message code="label.register.unemployee_no"/><span class="required-indicator"></span>
					</label> 
					<input type="text" name="unemployee_no" value="" id="unemployee_no" />
				</div>
				
				<div class="fieldcontain  required">
					<label for="telephone">
						<spring:message code="label.register.telephone"/><span class="required-indicator">*</span>
					</label> 
					<input type="text" name="telephone" required="" value="" id="telephone" />
					<font color="red"><c:if test="${not empty phone}"><fmt:message key="${phone.text}" /></c:if></font>
				</div>
				
				<div class="fieldcontain  ">
					<label for="work_unit">
						<spring:message code="label.register.work_unit"/><span class="required-indicator"></span>
					</label> 
					<input type="text" name="work_unit"  value="" id="work_unit" />
				</div>

				<div class="fieldcontain  required">
					<label for="location"> <spring:message code="label.register.location"/> <span class="required-indicator">*</span>
					</label> <select name="location" required="" id="location">
						<c:choose>
							<c:when test="${empty locationCache}">
								<option value="0"><spring:message code="label.register.no_data"/></option>
							</c:when>
							<c:otherwise>
								<c:forEach var="location" items="${locationCache}" varStatus="status">
									<option value='<c:out value="${location.locationId}"/>'><c:out value="${location.locationName}"/></option>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</select>
				</div>
				
				<div class="fieldcontain  required">
					<label for="start_date"> <spring:message code="label.register.start_date"/> <span class="required-indicator">*</span>
					</label> 
						<input type="text" name="start_date" required="" value="" id="start_date" />
						<font color="red"><c:if test="${not empty start_course}"><fmt:message key="${start_course.text}" /></c:if></font>
				</div>

			</fieldset>

			<fieldset class="fieldcontain  required">
				<label for="submit">&nbsp;<span class="required-indicator"></span>
					</label> 
					<input type="submit" name="submit" value='<spring:message code="button.register.submit"/>' id="submit" />
						<span class="required-indicator">&nbsp;&nbsp;&nbsp;</span>
						<input type="reset" name="reset" value='<spring:message code="button.register.reset"/>' id="reset" />
			</fieldset>
		</form>
	</div>

	<jsp:include page="/common/footer.jsp" />

</body>
</html>