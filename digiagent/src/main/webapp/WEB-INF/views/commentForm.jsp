<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>加入评论</title>
<link href="${ctx}/styles/main.css" rel="stylesheet" type="text/css" />
<script src="${ctx}/scripts/Calendar.js"></script>
<script src="${ctx}/scripts/menu.js"></script>
<script language="javascript">

function Home() {
	var url = "${ctx}/";
	window.parent.location.href= url;
}
</script>
</head>
<body>
<div class="companyTitle">发表评论</div>
<div id="companyLeft">

<form action="${ctx}/supplier/comments">	
  <table width="80%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td colspan="2"></td>
    </tr>
    <tr >
    <input type="hidden" name="id" id="id" value="${id}" />		
     <c:choose>
     	<c:when test="${empty sessionScope.userName}">
     		<td>帐号</td>
      		<td><input type="text" size="20" width="20"name="username" id="username" /></td>
      		<td>密码</td>
      		<td><input type="password" size="20" width="20" name="password" id="password" /><input type="hidden" name="logined" id="logined" value="N" /></td>
     	</c:when>
     	<c:otherwise>
     		<td>&nbsp;</td>
      		<td>&nbsp;欢迎您 ，<c:out value="${sessionScope.userName}" /><input type="hidden" name="username" id="username" value="${sessionScope.userName}" /><input type="hidden" name="password" id="password" value="" /><input type="hidden" name="logined" id="logined" value="Y" /></td>
      		<td></td>
      		<td></td>
     	
     	</c:otherwise>
     </c:choose>
      
    </tr>
    
     <tr >
      	<td colspan="4">评分: &nbsp;
      		<select size="1" id="rank" name="rank">
      			<c:forEach var="current" begin="1" end="9">
      				<option value="${current}" ><c:out value="${current}"/>&nbsp;分</option>
      			</c:forEach>
      			<option value="10" selected>10分</option>
      			
            </select>
		</td>
    </tr>
    
    <tr >
      <td colspan="4"></td>
    </tr>
    
    <tr >
      <td valign="top">评论</td>
      <td colspan="3"><textarea rows="10" cols="37" name="comments"></textarea>	</td>
   
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
