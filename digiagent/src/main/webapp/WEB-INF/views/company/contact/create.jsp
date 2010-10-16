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
<div class="companyTitle">公司情况</div>
<div id="companyLeft">
<form action="${ctx}/company/contact/create" >
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
      <td>联系类别</td>
      <td>
	      <select id="contactType" name="contactType">
	      	<option value='Q' SELECTED>QQ</option>
	      	<option value='E' >电子邮件</option>
	      	<option value='T' >电话</option>
	      	<option value='M' >手机</option>
	      </select>
	  </td>
    </tr>
    <tr>
      <td>联系方式</td>
      <td>
	      <input type="text" name="contactContent" id="contactContent"  />
	  </td>
    </tr>
   
 
    <tr>
      <td colspan="2" align="center">
      	<span class="headCity">
        	<input class="btn_login" type="submit" value="新增" />
        </span>
 
      </td>
    </tr>
    <tr>
      <td></td>
    </tr>
  </table>
</form>
  <p class="tagContent">&nbsp;</p>
</div>
</body>
</html>















</body>
</html>
