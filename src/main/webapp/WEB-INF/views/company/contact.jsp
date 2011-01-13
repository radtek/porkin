<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>公司情况</title>
<link href="${ctx}/styles/main.css" rel="stylesheet" type="text/css" />
<script src="${ctx}/scripts/Calendar.js"></script>
<script src="${ctx}/scripts/menu.js"></script>
<script language="javascript">

function whenDelete() {
	var isDelete=true;
	if (!confirm("sure to delete")) {
		isDelete=false;
	}
	window.location = 'contractSearch.html'; 
	return isDelete;
}
</script>
</head>
<body>
<div class="companyTitle">联系方式</div>
<div id="companyLeft">

  <table width="60%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td colspan="2">
      <strong>
      	<c:if test="${not empty message}">
			<fmt:message key="${message.text}" />
		 </c:if>
	</strong>
</td>
    </tr>
 	<tr>
      <td></td>
    </tr>
    <tr>
      <th>联系类别</th>
      <th>联系方式</th>
      <th>操作</td>

    </tr>
   
    <c:choose>
    	<c:when test="${empty contactList}">
    	 <tr>
    		<td>暂无数据!</td><td></td>
    	</tr>
    	</c:when>
    	<c:otherwise>
    		<c:forEach items="${contactList}" var="contact">
    			<tr>
    			<c:if test="${contact.contactType eq 'Q'}">
    				<td>QQ</td>
    			</c:if>
    			<c:if test="${contact.contactType eq 'E'}">
    				<td>电子邮件</td>
    			</c:if>
    			<c:if test="${contact.contactType eq 'T'}">
    				<td>电话</td>
    			</c:if>
    			<c:if test="${contact.contactType eq 'M'}">
    				<td>手机</td>
    			</c:if>
    			<c:if test="${contact.contactType eq 'N'}">
    				<td>MSN</td>
    			</c:if>
    			<td><c:out value="${contact.contactContent}" /></td>
    			<td>
    			<span class="headCity">
    				<form action="${ctx}/company/contact/delete/<c:out value="${contact.contactId}"/>" >
    					<input type="image"  src="${ctx}/images/datagrid/icon_list_delete.gif" onclick="javascript:confirm('您确认要删除?')" />
    				</form>
    			 </span>
    			</tr>
    		</c:forEach>
    	</c:otherwise>
    </c:choose>
    </tr>
    
    <tr>
    	<td></td>
    </tr>
 
    <tr>
    <form action="${ctx}/company/contact/form" />
      <td colspan="2" align="center">
      	<span class="headCity">
        	<input class="btn_login" type="submit" value="新增" />
        </span>
      </td>
    </form> 
    </tr>
    <tr>
      <td></td>
    </tr>
  </table>

  <p class="tagContent">&nbsp;</p>
</div>
</body>
</html>















</body>
</html>
