<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户找回密码</title>
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
<div class="headTop">
  <div class="headCity">切换城市
    <select name="select3" style="width:60px;">
        <option>大连</option>
        <option>上海</option>
      </select>
     <span class="leftLink"><a href="${ctx}/">首页</a></span>
     <span class="rightLink">帮助 | 设为首页</span> </div>
  <div class="logo"></div>
</div>
<div class="redLine"></div>
<DIV style="CLEAR: both"></DIV>
</DIV>
</DIV>
<div class="dfcenterTitle">商家不存在！</div>
<div id="loginCenter">
<form action="${ctx}/">
  <table width="60%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td colspan="2"></td>
    </tr>
    <tr>
      <td><strong>您要找的商家不存在,<strong/></td>
      <td></td>
    </tr>
    <tr>
      <td><strong>请确认返回首页！<strong/></td>
      <td></td>
    </tr>
 
    <tr>
    	<td>&nbsp;</td>
    	<td>&nbsp;</td>
    </tr>
    <tr>
      <td colspan="2" align="center"><span class="headCity">

      		<input class="btn_login" type="submit" value="确认" />
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
