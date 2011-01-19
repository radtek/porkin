<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商讯网--找回密码</title>
<link href="${ctx}/styles/main2.css" rel="stylesheet" type="text/css">
<script src="${ctx}/scripts/Calendar.js"></script>
<script src="${ctx}/scripts/menu.js"></script>
<script language="javascript">

function reloadcaptcha()
{
	var elem = document.getElementById('icaptcha');
	elem.src='captcha?r='+(new Date());
}

</script>
</head>

<body>

<!-- head -->
<jsp:include page="header.jsp"></jsp:include>
<!-- head end -->

<table border="0" cellspacing="0" cellpadding="0" width="100%" align="center">
  <tr><td height="25"></td></tr>
</table>

<!-- center -->
<table width="950" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="10" width="10"><img src="${ctx}/images/bg_pic00a.gif" /></td>
    <td background="${ctx}/images/bg_pic00e.gif"></td>
    <td width="10"><img src="${ctx}/images/bg_pic00b.gif" /></td>
  </tr>
  <tr>
    <td valign="top" background="${ctx}/images/bg_pic00f.gif" style="padding-top:194px">&nbsp;</td>
    <td bgcolor="#ffffff" valign="top"><table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
	  <tr valign="top">
		<td width="240" rowspan="2"><img src="${ctx}/images/icon_registered.jpg" width="240" height="320" /></td>
		<td class="title_color07"><img src="${ctx}/images/dot03.gif" />&nbsp;&nbsp; 用户找回密码</td>
	  </tr>
	  <tr valign="top">
	    <td>
		<!-- 注册 -->
		<form action="${ctx}/password">
		<table width="100%" border="0" cellspacing="0" cellpadding="5" class="text_13size">
		 <tr>
		 	<td ></td>
            <td />
		 	<td>
		 		<strong>用户找回密码成功,请到邮箱查收密码!</strong>
		 	</td>
		 </tr>
		 
		 <tr>
		 	<td ></td>
            <td />
		 	<td>
		 		</strong>
		 	</td>
		 </tr>
         
        </table>
        </form>
		<!-- 注册 end -->
		</td>
	    </tr>
	</table>
	<br />
    </td>
	<td background="${ctx}/images/bg_pic00g.gif"></td>
  </tr>
  <tr>
    <td height="10"><img src="${ctx}/images/bg_pic00c.gif" /></td>
    <td background="${ctx}/images/bg_pic00h.gif"></td>
    <td><img src="${ctx}/images/bg_pic00d.gif" /></td>
  </tr>
</table>
<!-- center end -->
<br />

<!-- foot -->
<table border="0" cellspacing="0" cellpadding="0" width="100%">
	<tr><td bgcolor="#cccccc" height="1"></td></tr>
	<tr><td height="30" class="text_foot">&copy; 2011年 商讯网版权所有</td></tr>
</table>
<!-- foot end -->

</body>
</html>
