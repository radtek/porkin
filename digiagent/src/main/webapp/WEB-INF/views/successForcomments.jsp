<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>错误异常</title>
<link href="${ctx}/styles/main.css" rel="stylesheet" type="text/css" />
<script src="${ctx}/scripts/Calendar.js"></script>
<script src="${ctx}/scripts/menu.js"></script>
<script language="javascript">

function Home() {
	var url = "${ctx}/supplier/${id}";
	opener.document.location=url;
	window.close();  
}
</script>
</head>
<body>
<div class="companyTitle">操作提示</div>
<div id="companyLeft">

  <table width="60%" border="0" align="center" cellpadding="0" cellspacing="0">
  	<tr>
  		<td><br></td>
  	</tr>
    <tr>
      <td colspan="2">
      	<H3>
      		操作成功!

      	</H3>
      </td>
    </tr>
    
    <tr>
  		<td><br></td>
  	</tr>
    <tr>
      <td colspan="2" align="center">
      	<span class="headCity">
      		<input class="btn_login" type="button" value="确定" onClick="Home()" />
        	
        </span>
 
      </td>
    </tr>
    <tr>
      <td></td>
    </tr>
  </table>

  <p class="tagContent">&nbsp;</p>
</div>
</body>
</html>
