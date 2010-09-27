<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企业会员</title>
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
</script>
</head>
<body>
<div class="headTop">
  <div class="headCity">切换城市
    <select name="select3" style="width:60px;">
        <option>大连</option>
        <option>上海</option>
      </select>
      <span class="leftLink">欢迎您 ，<c:out value="${sessionScope.username}" /> | <a href="member">会员</a> | <a href="logout">退出</a></span>
     <span class="rightLink">帮助 | 设为首页</span> </div>
  <div class="logo"></div>
</div>
<div class="redLine"></div>

<DIV style="CLEAR: both"></DIV>
<DIV id=dfleft>
<DIV class=sidebar>
    <DIV class=blk>
    <H3>企业会员</H3>
        <DIV class=c>                   
            <DIV class=blk2>                       
                <UL>
                  <LI><b><A href="http://dl.bbs.house.sina.com.cn/forumdisplay.php?fid=9395" 
                  target=_blank>基本信息 </A></b>
                  <LI><b><A href="http://dl.bbs.house.sina.com.cn/forumdisplay.php?fid=9395" 
                  target=_blank>密码管理 </A></b>
                   <LI><b><A href="http://dl.bbs.house.sina.com.cn/forumdisplay.php?fid=9395" 
                  target=_blank>电子邮件 </A></b>
                  <LI><b><A href="http://dl.bbs.house.sina.com.cn/forumdisplay.php?fid=9395" 
                  target=_blank>公司简介 </A></b>
                  <LI><b><A href="http://dl.bbs.house.sina.com.cn/forumdisplay.php?fid=9395" 
                  target=_blank>联系方式 </A></b>
                  <LI><b><A href="http://dl.bbs.house.sina.com.cn/forumdisplay.php?fid=9395" 
                  target=_blank>代理申请</A></b>
                  <LI><b><A href="http://dl.bbs.house.sina.com.cn/forumdisplay.php?fid=9395" 
                  target=_blank>资质认证 </A></b>
                  <LI><b><A href="http://dl.bbs.house.sina.com.cn/forumdisplay.php?fid=9395" 
                  target=_blank>促销发布 </A></b>	
                  <LI><b><A href="http://dl.bbs.house.sina.com.cn/forumdisplay.php?fid=22866" 
                  target=_blank>促销历史</A></b></LI></UL></DIV></DIV></DIV>
                  
        </DIV>
    </DIV>
</DIV>
</DIV>
<div id="dfright">
	<ul class="userInfo">
    	<li onmousemove=splash(this); ><span class="userInfoBlue">用户昵称</span><span class="userInfoYellow">Porkin</span></li>
        <li onmousemove=splash(this); ><span class="userInfoBlue">用户类型</span><span class="userInfoYellow">高级VIP用户</span></li>
        <li onmousemove=splash(this); ><span class="userInfoBlue">上次登录时间</span><span class="userInfoYellow">2010-08-25  19:45</span></li>
		<li onmousemove=splash(this); ><span class="userInfoBlue">注册时间</span><span class="userInfoYellow">06-05-06   19:45</span></li>
		<li onmousemove=splash(this); ><span class="userInfoBlue">登录次数</span><span class="userInfoYellow">12</span></li>
    </ul>
</div>

</body>
</html>
