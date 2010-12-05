<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>关于我们</title>
<link href="styles/main.css" rel="stylesheet" type="text/css" />
<script src="scripts/Calendar.js"></script>
<script src="scripts/menu.js"></script>
<script language="javascript">

function whenDelete() {
	var isDelete=true;
	if (!confirm("sure to delete")) {
		isDelete=false;
	}
	window.location = 'contractSearch.html'; 
	return isDelete;
}

function reloadcaptcha(){
	var elem=document.getElementById('captcha');	
		elem.src='captcha?r='+(new Date());
}
</script>
</head>
<body>
<div class="headTop">
  <div class="headCity">切换城市
    <select name="select3" style="width:60px;">
        <option>大连</option>
        <option>上海</option>
      </select>
     <span class="leftLink"><a href="${ctx}/">首页</a></span>
     <span class="rightLink">设为首页</span> </div>
  <div class="logo"></div>
</div>
<div class="redLine"></div>
<DIV style="CLEAR: both"></DIV>
</DIV>
</DIV>
<div class="dfcenterTitle" >
<p style="font-size:12pt; font-weight: bold; TEXT-ALIGN: center;">关于我们</p>
</div>



<div id="loginCenter">

<img src="${ctx}/images/about.jpg" width=500px;/>
<br>  

<P style="font-size:12pt; font-weight: bold;">
&nbsp;大连•商讯网是一款以提供商业产品信息的地域性信息类门户网站。<br>
&nbsp;商讯网是为了用户更方便、快捷的查找产品的信息为所建立的网站，商讯网力争做到：保证信息的准确性、方便快捷的查询、保障用户信息的安全。<br>
&nbsp;我们的服务理念是:用方便、快捷的服务带给您准确无误的信息！<br>

</p>
</div>

</body>
</html>
