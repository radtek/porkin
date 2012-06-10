<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ include file="/common/taglibs.jsp"%>

<c:choose>
	<c:when test="${count<=0}">
		<spring:message code="label.register.no_data" />
	</c:when>
	<c:otherwise>
		<div class="pagination">
			
		</div>
	</c:otherwise>
</c:choose>

