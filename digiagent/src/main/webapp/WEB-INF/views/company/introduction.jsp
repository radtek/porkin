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
<form action="${ctx}/company/introduction" method="post">
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
      <td>公司名称</td>
      <td><input type="text" name="supplierName" id="supplierName" value='<c:out value="${supplier.supplierName}" />' /></td>
    </tr>
    <tr>
      <td>联系人姓名</td>
      <td><input type="text" name="supplierContactname" id="supplierContactname" value='<c:out value="${supplier.supplierContactname}" />' /></td>
    </tr>
    <tr>
      <td>邮政编码</td>
      <td><input type="text" name="supplierZip" id="supplierZip" value='<c:out value="${supplier.supplierZip}" />' /></td>
    </tr>
    <tr>
      <td>联系地址</td>
      <td><input type="text" name="supplierAddress" id="supplierAddress" value='<c:out value="${supplier.supplierAddress}" />' /></td>
    </tr>
    <tr>
      <td>联系电话</td>
      <td><input type="text" name="supplierTelephone" id="supplierTelephone" value='<c:out value="${supplier.supplierTelephone}" />' /></td>
    </tr>
    <tr>
      <td>手机</td>
      <td><input type="text" name="supplierMobile" id="supplierMobile" value='<c:out value="${supplier.supplierMobile}" />' /></td>
    </tr>
    <tr>
      <td>传真</td>
      <td><input type="text" name="supplierFax" id="supplierFax" value='<c:out value="${supplier.supplierFax}" />' /></td>
    </tr>
     <tr>
      <td>简介</td>
      <td><input type="text" name="supplierDescription" id="supplierDescription" value='<c:out value="${supplier.supplierDescription}" />' /></td>
    </tr>
    <tr>
      <td></td>
    </tr>
    <tr>
      <td colspan="2" align="center"><span class="headCity">
        <input class="btn_login" type="submit" value="提交" />
            </span><span class="headCity">
      <input class="btn_login" type="reset" value="取消" />
                  </span></td>
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
