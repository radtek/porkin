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

<script language="javascript">

function login(username,password) {
	$.ajax({
		url: "security/login",
		dataType: "text",
		type: "POST",
		data:{username:username, password:password},
		success: function(data) {
			if(data==null){
				alert("用户名或密码错误！");
			}
			else{
				alert(22);
				//window.location.href("/");
			}		
		},
		error: function(xhr, ajaxOptions, thrownError){
			 alert("数据读取失败！");
        }
	});
}

function validate() {
	var username = $("input[name='username']").val();
	var password = $("input[name='password']").val();
	login(username, password);
}
function selectTag(showContent,selfObj){
	// 操作标签
	var tag = document.getElementById("tags").getElementsByTagName("li");
	var taglength = tag.length;
	for(i=0; i<taglength; i++){
		tag[i].className = "";
	}
	selfObj.parentNode.className = "selectTag";
	// 操作内容
	for(i=0; j=document.getElementById("tagContent"+i); i++){
		j.style.display = "none";
	}
	document.getElementById(showContent).style.display = "block";
}</script>
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
<DIV style="CLEAR: both"></DIV>
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
        <tr>
          <td colspan="3"><strong>促销产品1标题</strong></td>
        </tr>
        <tr>
          <td colspan="3">&nbsp;</td>
        </tr>
        <tr>
          <td colspan="3">促销产吕介绍促销产吕介绍促销产吕介绍促销产吕介绍促销产吕介绍促销产吕介绍促销产吕介绍促销产吕介绍</td>
        </tr>
        <tr>
          <td colspan="3">&nbsp;</td>
  </tr>
        <tr>
          <td colspan="3"><strong>促销产品1标题</strong></td>
  </tr>
        <tr>
          <td colspan="3">&nbsp;</td>
  </tr>
        <tr>
          <td colspan="3">促销产吕介绍促销产吕介绍促销产吕介绍促销产吕介绍促销产吕介绍促销产吕介绍促销产吕介绍促销产吕介绍</td>
        </tr>
        <tr>
          <td colspan="3">&nbsp;</td>
        </tr>
      </table>
    </div>
    <div class="tagContent" id="tagContent3">
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
        <tr>
          <td colspan="3"><strong>促销产品1标题</strong></td>
        </tr>
        <tr>
          <td colspan="3">&nbsp;</td>
        </tr>
        <tr>
          <td colspan="3">促销产吕介绍促销产吕介绍促销产吕介绍促销产吕介绍促销产吕介绍促销产吕介绍促销产吕介绍促销产吕介绍</td>
        </tr>
        <tr>
          <td colspan="3">&nbsp;</td>
  </tr>
        <tr>
          <td colspan="3"><strong>促销产品1标题</strong></td>
  </tr>
        <tr>
          <td colspan="3">&nbsp;</td>
  </tr>
        <tr>
          <td colspan="3">促销产吕介绍促销产吕介绍促销产吕介绍促销产吕介绍促销产吕介绍促销产吕介绍促销产吕介绍促销产吕介绍</td>
        </tr>
        <tr>
          <td colspan="3">&nbsp;</td>
        </tr>
      </table>
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
