<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<link href="styles/main.css" rel="stylesheet" type="text/css" />
<script src="scripts/Calendar.js"></script>
<script src="scripts/menu.js"></script>
<script type="text/javascript" src="scripts/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="scripts/searchbar.js"></script>
<script type="text/javascript" src="scripts/common/common.js"></script>
<script type="text/javascript" src="scripts/commoditylist.js"></script>
<script type="text/javascript" src="scripts/login.js"></script>
<script type="text/javascript" src="scripts/index.js"></script>
</head>
<body>
<div class="headTop">
    <div class="headCity">切换城市           
      <select name="city" style="width:60px;">
        <option>大连</option>
        <option>上海</option>
      </select>
      <c:choose>
      <c:when test="${empty sessionScope.username}">
     <form name="loginForm" action="login" method="post">
      用户<input type="text" name="username" size="10" width="10"/>&nbsp;
      密码<input type="password" name="password" size="10" width="10"/>&nbsp;
      <input class="btn_login" type="submit" value="登录" "/>
      </form>
    <span class="leftLink"><a href="registerForm">注册</a> | <a href="passwordForm">忘记密码</a></span>
      </c:when>
      <c:otherwise>
       <span class="leftLink">欢迎您 ，<c:out value="${sessionScope.username}" /> | <a href="member">会员</a> | <a href="logout">退出</a></span>
      </c:otherwise>
      </c:choose>
      
    <span class="rightLink">帮助 | 设为首页</span>
    </div>
   
	
</div>
<div class="redLine"></div>
<div style="clear: both"></div>

<!-- commodity layout template start -->
<div id="commodityTemplate">
   <div class="liststyle">
    	<div style="float:left; width:100px; padding:20px; height:auto">
        	<div>
				<span>rowNum</span><img src="commodity/getImage?id=imageId" width="80" height="80" style="cursor:pointer" alt="commodityName"/>
			</div>
			<div style="paddingTop:5px;text-align:center">￥commodityPrice</div>
		</div>  
		<div>
			<div>商品名称：commodityName</div>
			<div>联 系 人：supplierContactname</div>
			<div>联系电话：<span class=hong14b>supplierMobile</span></div>
			<div>手机号码：<span class=hong14b>supplierTelephone</span></div>
			<div>电子邮箱：userEmail</div>
			<div>联系地址：supplierAddress</div>
		</div>
	</div>
</div>
<!-- commodity layout template end -->

<div class="indexCenter">
  <div class="logoCenter"></div>
    <div id="dfright2">
	<div id="con">
  <ul id="tags">
    <li class="selectTag"><a onclick="selectTag('tagContent0',this)" href="javascript:void(0)">&nbsp;搜索&nbsp;</a></li>
    <li><a onclick="selectTag('tagContent1',this)" href="javascript:void(0)">&nbsp;店铺&nbsp;</a></li>
    <li><a onclick="selectTag('tagContent2',this)" href="javascript:void(0)">&nbsp;促销&nbsp;</a></li>
    <li><a onclick="selectTag('tagContent3',this)" href="javascript:void(0)">&nbsp;二手&nbsp;</a></li>
    <li><a onclick="selectTag('tagContent4',this)" href="javascript:void(0)">&nbsp;排名&nbsp;</a></li>
  </ul>
  <div id="tagContent" >
    <div class="tagContent selectTag" id="tagContent0">
      <table border="0" cellpadding="0" cellspacing="0" align="center">
        <tr>
        	<td colspan="3">&nbsp;</td>
        </tr>
        <tr>
          <td><input name="textfield" type="text" size="70" width="200px" /></td>
          <td>&nbsp;</td>
          <td width="80"> <input type="reset" style="width:100px" name="Reset212222" onmouseout="this.className='button01'" onmouseover="this.className=' button02'" value="搜索" class="button01" onclick="window.location.href='purductList.html'" /></td>  
                  
        </tr>
        <tr>
        	<td colspan="3">&nbsp;</td>
        </tr>
        <tr>
        	<td colspan="3"><div id="searchBar"></div></td>
        </tr>
      </table>
    </div>
    <div class="tagContent" id="tagContent1">
     <table border="0" cellpadding="0" cellspacing="0" align="center">
        <tr>
        	<td colspan="3">&nbsp;</td>
        </tr>
        <tr>
          <td><input name="textfield" type="text" size="70" width="200px" /></td>
          <td>&nbsp;</td>
          <td width="80"> <input type="reset" style="width:100px" name="Reset212222" onmouseout="this.className='button01'" onmouseover="this.className=' button02'" value="搜索" class="button01" /></td>  
                  
        </tr>
        <tr>
        	<td colspan="3">&nbsp;</td>
        </tr>
      </table>
    </div>
    <div class="tagContent" id="tagContent2">
    	<table id="commodityP">
	    </table>
	    <div></div>
    </div>
    <div class="tagContent" id="tagContent3">
      	<table id="commodityS">
	    </table>
	    <div></div>
    </div>
    <div class="tagContent" id="tagContent4">
      <table border="0" cellpadding="0" cellspacing="0" align="center">
        <tr>
        	<td colspan="3">&nbsp;</td>
        </tr>
        <tr>
          <td><input name="textfield" type="text" size="70" width="200px" /></td>
          <td>&nbsp;</td>
          <td width="80"> <input type="reset" style="width:100px" name="Reset212222" onmouseout="this.className='button01'" onmouseover="this.className=' button02'" value="搜索" class="button01" /></td>  
                  
        </tr>
        <tr>
        	<td colspan="3">&nbsp;</td>
        </tr>
      </table>
    </div>
  </div>
</div>
</div>
</div>
</body>
</html>
