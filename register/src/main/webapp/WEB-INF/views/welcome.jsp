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
<title>Create Race</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="shortcut icon" href="${ctx}/images/favicon.ico"
	type="image/x-icon">
<link rel="apple-touch-icon" href="${ctx}/images/apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="114x114"
	href="${ctx}/images/apple-touch-icon-retina.png">
<link rel="stylesheet" href="${ctx}/styles/main.css" type="text/css">
<link rel="stylesheet" href="${ctx}/styles/mobile.css" type="text/css">

<meta name="layout" content="main">




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
		<h1>欢迎使用网上报名系统</h1>


		<form action="/racetrack/race/save" method="post">
			<fieldset class="form">

				<div class="fieldcontain  required">
					<label for="name"><spring:message code="label.register.name"/><span class="required-indicator">*</span>
					</label> <input type="text" name="name" required="" value="" id="name" />
				</div>

				<div class="fieldcontain  required">
					<label for="startDateTime"> Start Date Time <span
						class="required-indicator">*</span>
					</label> <input type="hidden" name="startDateTime" value="date.struct" />

					<select name="startDateTime_day" id="startDateTime_day"><option
							value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4" selected="selected">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>

						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="15">15</option>
						<option value="16">16</option>
						<option value="17">17</option>
						<option value="18">18</option>

						<option value="19">19</option>
						<option value="20">20</option>
						<option value="21">21</option>
						<option value="22">22</option>
						<option value="23">23</option>
						<option value="24">24</option>
						<option value="25">25</option>
						<option value="26">26</option>
						<option value="27">27</option>

						<option value="28">28</option>
						<option value="29">29</option>
						<option value="30">30</option>
						<option value="31">31</option>
					</select> 

				</div>

				<div class="fieldcontain  required">
					<label for="city"> City <span class="required-indicator">*</span>

					</label> <input type="text" name="city" required="" value="" id="city" />
				</div>

				<div class="fieldcontain  required">
					<label for="state"> <spring:message code="label.level_class"/> <span class="required-indicator">*</span>
					</label> <select name="state" required="" id="state">
						<c:choose>
							<c:when test="${empty areaCache}">
								<c:if test="${type == 'areaCache' }"><option value="0">暂无数据!</option></c:if>
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
					<label for="distance"> Distance <span
						class="required-indicator">*</span>

					</label> <input type="number" name="distance" step="any" min="3.0"
						max="100.0" required="" value="" id="distance" />
				</div>

				<div class="fieldcontain  required">
					<label for="cost"> Cost <span class="required-indicator">*</span>
					</label> <input type="number" name="cost" step="any" min="0.0" max="999.99"
						required="" value="" id="cost" />

				</div>

				<div class="fieldcontain  required">
					<label for="maxRunners"> Max Runners <span
						class="required-indicator">*</span>
					</label> <input type="number" name="maxRunners" required="" value="10000"
						id="maxRunners" />
				</div>

				<div class="fieldcontain  ">
					<label for="registrations"> Registrations </label>

					<ul class="one-to-many">

						<li class="add"><a
							href="/racetrack/registration/create?race.id=">Add
								Registration</a></li>
					</ul>

				</div>


			</fieldset>

			<!-- <fieldset class="buttons">
				<input type="submit" name="create" class="save" value="Create"
					id="create" />
			</fieldset> -->
		</form>
	</div>

	<div class="footer" role="contentinfo"></div>
	<div id="spinner" class="spinner" style="display: none;">Loading&hellip;</div>

	<script src="${ctx}/scripts/application.js" type="text/javascript"></script>

</body>
</html>