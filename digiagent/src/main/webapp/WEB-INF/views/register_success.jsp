<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商讯网--用户注册</title>
<link href="${ctx}/styles/main2.css" rel="stylesheet" type="text/css">
<script src="${ctx}/scripts/Calendar.js"></script>
<script src="${ctx}/scripts/menu.js"></script>
<script type="text/javascript" src="${ctx}/scripts/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="${ctx}/scripts/password.complexity.js"></script>

<script language="javascript">

function reloadcaptcha(){
	var elem = document.getElementById('icaptcha');
	elem.src='captcha?r='+(new Date());
}

function showAgreement(){
	window.open ('${ctx}/agreement','商讯网服务协议','height=610,width=800,top=50,left=200,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no,status=no,depended=yes,titlebar=no,scrollbars=no,toolbar=no');
}

function agreementConfirm(value){

	if(document.registerForm.agreement.checked){
		document.registerForm.submit();
	}
	else{
		alert("请阅读并接受商讯网服务协议");
	}		
}

$(document).ready(function() {
	// $('<span/>').text('检测').css('text-decoration','underline').css('color', 'red').bind('mouseover', function() {$(this).css('cursor','pointer')}).bind('click', validateUserName).insertAfter('#username');
	$('#username').bind('change', validateUserName);
	$('#email').bind('change', validateEmail);
});


var validateUserName = function() {
	$('#validateUserName').remove();
	if ($('#username').val() == "") return;
	$('<span></span>').css('padding-left', '10px').attr('id', 'validateUserName').append('<image id="loader" src="images/datagrid/tree_loading.gif"/>').insertAfter('#username');
	$.get('validateUserName', {username:$('#username').val()}, function(data) {
		if (data) {
			$('#validateUserName').empty().append('<image id="loader" src="images/icons/no.png"/>');
		} else {
			$('#validateUserName').empty().append('<image id="loader" src="images/icons/ok.png"/>');
		}
	});
};

var validateEmail = function() {
	$('#validateEmail').remove();
	if ($('#email').val() == "") return;
	$('<span></span>').css('padding-left', '10px').attr('id', 'validateEmail').append('<image id="loader" src="images/datagrid/tree_loading.gif"/>').insertAfter('#email');
	// 对Email地址格式的验证
	var regEmail = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	if(!regEmail.test($('#email').val())){
		$('#validateEmail').empty().append('<image id="loader" src="images/icons/no.png"/>');
		return;
	}
	// 是否存在验证
	$.get('validateEmail', {email:$('#email').val()}, function(data) {
		if (data) {
			$('#validateEmail').empty().append('<image id="loader" src="images/icons/no.png"/>');
		} else {
			$('#validateEmail').empty().append('<image id="loader" src="images/icons/ok.png"/>');
		}
	});
};

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
		<td class="title_color07"><img src="${ctx}/images/dot03.gif" />&nbsp;&nbsp; 用户注册</td>
	  </tr>
	  <tr valign="top">
	    <td>
		<!-- 注册 -->
		
		<form action="${ctx}/autologin" method="post">

		<table width="100%" border="0" cellspacing="0" cellpadding="5" class="text_13size">
          <tr>
            <td width="5" ></td>
            <td width="70"> </td>
            <td width="180" class="text_red"><strong>用户<c:out value="${username}" />注册成功!</strong></td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td width="5" ></td>
            <td width="70"> </td>
            <td width="180" class="text_red"><strong>请点击确认到首页.</strong></td>
            <td>&nbsp;</td>
          </tr>
          
          
          <tr>
      			<td><input type="hidden" name="username" value='<c:out value="${username}" />'/></td>
      			<td><input type="hidden" name="password" value='<c:out value="${password}" />'/></td>
        </tr>
 
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td height="40" colspan="2">
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			  <input type="submit" value="确定" class="btn_01" style="width:80px" /></td>
            </tr>
        </table>
        </form>
		<!-- 注册 end -->
		</td>
	    </tr>
	</table>
	<br />
	<!-- 广告 -->
	<table width="100%" height="160" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr align="center">
        <td valign="top"><img src="${ctx}/images/ad_pic/ad003.jpg" width="210" height="140" /></td>
        <td valign="top"><img src="${ctx}/images/ad_pic/ad004.jpg" width="210" height="140" /></td>
        <td valign="top"><img src="${ctx}/images/ad_pic/ad005.jpg" width="210" height="140" /></td>
      </tr>
    </table>
    <!-- 广告 end -->
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
