<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商讯网--商家信息</title>
<link href="${ctx}/styles/main2.css" rel="stylesheet" type="text/css">
</head>

<body>

<!-- head -->
<jsp:include page="../header.jsp"></jsp:include>
<!-- head end -->

<table border="0" cellspacing="0" cellpadding="0" width="100%" align="center">
  <tr><td height="25"></td></tr>
</table>

<!-- center -->
<table width="950" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr valign="top">
    <td width="160"><table width="160" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr valign="top">
        <td width="10" background="${ctx}/images/bg_pic00f.gif"><img src="${ctx}/images/bg_pic04a.gif" /></td>
        <td width="10" class="title_left_b"></td>
        <td width="120" bgcolor="#FFFFFF">
		  <!-- 标题 -->
		  <table width="110" border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td class="title_left_b">用户注册</td>
            </tr>
            <tr>
              <td><img src="${ctx}/images/line_left.gif" /></td>
            </tr>
          </table>
		  <!-- 标题 end -->
		  
		  <!-- 用户连接 -->
          <jsp:include page="menu.jsp"></jsp:include>
		  <!-- 用户连接 end -->
        </td>
        <td width="10" class="title_left_b" style="vertical-align:top; padding-top:50px"><img src="${ctx}/images/left_pic01.gif" />
            <br /><br /><br /><br /><br /><br /><br /><br /><br />
            <img src="${ctx}/images/left_pic01.gif" /></td>
        <td width="10" background="${ctx}/images/bg_pic00g.gif"><img src="${ctx}/images/bg_pic04c.gif" /><br />
            <img src="${ctx}/images/left_pic02.gif" />
            <br /><br /><br /><br /><br /><br /><br /><br /><br />
            <img src="${ctx}/images/left_pic02.gif" /></td>
      </tr>
      <tr valign="top">
        <td><img src="${ctx}/images/bg_pic00c.gif" /></td>
        <td background="${ctx}/images/bg_pic00h.gif" style="background-position: top; background-repeat: repeat-x;"></td>
        <td background="${ctx}/images/bg_pic00h.gif" style="background-position: top; background-repeat: repeat-x;"></td>
        <td background="${ctx}/images/bg_pic00h.gif" style="background-position: top; background-repeat: repeat-x;"></td>
        <td><img src="${ctx}/images/bg_pic00d.gif" /></td>
      </tr>
    </table></td>
    <td width="10" style="padding-top:50px"><img src="${ctx}/images/left_pic03.gif" />
            <br /><br /><br /><br /><br /><br /><br /><br /><br />
            <img src="${ctx}/images/left_pic03.gif" /></td>
    <td width="780"><table width="780" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr valign="top">
        <td width="10" height="10"><img src="${ctx}/images/bg_pic00a.gif" /></td>
        <td width="10" background="${ctx}/images/bg_pic00e.gif"></td>
        <td width="750" background="${ctx}/images/bg_pic00e.gif"></td>
        <td width="10"><img src="${ctx}/images/bg_pic00b.gif" /></td>
      </tr>
	  <tr valign="top">
        <td width="10" style="padding-top:40px" background="${ctx}/images/bg_pic00f.gif"><img src="${ctx}/images/left_pic04.gif" />
            <br /><br /><br /><br /><br /><br /><br /><br /><br />
            <img src="${ctx}/images/left_pic04.gif" /></td>
        <td width="10" bgcolor="#FFFFFF" style="padding-top:40px"><img src="${ctx}/images/left_pic05.gif" />
            <br /><br /><br /><br /><br /><br /><br /><br /><br />
            <img src="${ctx}/images/left_pic05.gif" /></td>
        <td width="750" bgcolor="#FFFFFF">
          <br />
		  <!-- 已代理的商品 -->
		  <form action="${ctx}/company/introduction" method="post">
          <table width="500" border="0" align="center" cellpadding="0" cellspacing="0" class="list2">
            <tr>
              <td colspan="2" class="text_14size" style="border-bottom:1px solid #95b9e9; text-align:center; padding-left:30px"><b>公司情况</b></td>
            </tr>
            <c:if test="${not empty message}">
            <tr>
      			<th>
      				<strong>
      				<font color="red"><fmt:message key="${message.text}" /></font>
			 		</strong>
				</th>
				<td></td>
   			 </tr>
   			 </c:if>
			<tr>
              <th>公司名称：</th>
              	<td>
              		<input type="text" name="supplierName" id="supplierName" value='<c:out value="${supplier.supplierName}" />' />
				</td>
			</tr>
            <tr>
      			<th>所在城市：</th>
	      		<td> 
	      			<select id="cityId" name="cityId">
	      				<c:forEach items="${cityList}" var="city">
	      				<c:choose>
	      					<c:when test="${city.cityId eq supplier.cityId}">
	      						<option value='<c:out value="${city.cityId}" />' SELECTED><c:out value="${city.cityName}" /></option>
	      					</c:when>
	      					<c:otherwise>
	      						<option value='<c:out value="${city.cityId}" />' ><c:out value="${city.cityName}" /></option>
	      					</c:otherwise>
	      				</c:choose>
	      				</c:forEach>
	     
	                </select>
				</td>
    		</tr>
            <tr>
     			<th>联系人：</th>
      			<td><input type="text" name="supplierContactname" id="supplierContactname" value='<c:out value="${supplier.supplierContactname}" />' /></td>
    		</tr>
    		
    		<tr>
      			<th>邮政编码：</th>
      			<td><input type="text" name="supplierZip" id="supplierZip" value='<c:out value="${supplier.supplierZip}" />' /></td>
    		</tr>
    		
    		<tr>
      			<th>联系地址：</th>
      			<td><input type="text" name="supplierAddress" id="supplierAddress" value='<c:out value="${supplier.supplierAddress}" />' /></td>
    		</tr>
    		
    		<tr>
      			<th>联系电话：</th>
      			<td><input type="text" name="supplierTelephone" id="supplierTelephone" value='<c:out value="${supplier.supplierTelephone}" />' /></td>
    		</tr>
    		
    		<tr>
      			<th>手机：</th>
      			<td><input type="text" name="supplierMobile" id="supplierMobile" value='<c:out value="${supplier.supplierMobile}" />' /></td>
    		</tr>
    		
    		<tr>
      			<th>传真：</th>
      			<td><input type="text" name="supplierFax" id="supplierFax" value='<c:out value="${supplier.supplierFax}" />' /></td>
    		</tr>
    		
     		<tr>
      			<th>简介：</th>
      			<td><textarea cols="25" rows="5" name="supplierDescription" id="supplierDescription"  ><c:out value="${supplier.supplierDescription}" /></textarea></td>
    		</tr>
    		
    		<tr>
              <th>
			  </th>
              <td><input type="submit" value="提交" name="Submit" class="btn_02">&nbsp;&nbsp;&nbsp;<input type="reset" value="取消" name="reset" class="btn_02"></td>
            </tr>
    		
          </table>
          </form>
		  <!-- 已代理的商品 end -->
		  <br />
		  
        </td>
        <td width="10" background="${ctx}/images/bg_pic00g.gif"></td>
      </tr>
      <tr valign="top">
        <td><img src="${ctx}/images/bg_pic00c.gif" /></td>
        <td background="${ctx}/images/bg_pic00h.gif"></td>
        <td background="${ctx}/images/bg_pic00h.gif"></td>
        <td><img src="${ctx}/images/bg_pic00d.gif" /></td>
      </tr>
    </table>
    </td>
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
