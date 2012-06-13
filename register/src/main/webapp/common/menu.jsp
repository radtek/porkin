<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ include file="/common/taglibs.jsp"%>

<a href="#list-book" class="skip" tabindex="-1">Skip to
	content&hellip;</a>
<div class="nav" role="navigation">
	<ul>
		<li><a class="home" href="${ctx}/registration/list"><spring:message
					code="menu.sub.registration" /></a></li>
		<li><a href="${ctx}/area/list" class="list"><spring:message
					code="menu.sub.area" /></a></li>
		<li><a href="${ctx}/location/list" class="list"><spring:message
					code="label.register.location" /></a></li>

		<li><a href="${ctx}/user/list" class="create"><spring:message
					code="menu.sub.user" /></a></li>

	</ul>
</div>
