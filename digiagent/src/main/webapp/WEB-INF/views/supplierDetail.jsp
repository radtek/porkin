<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商讯网--商家信息--<c:out value="${supplier.supplierName}"/></title>
<link href="${ctx}/styles/main2.css" rel="stylesheet" type="text/css">
<script language="javascript">
function showImage(getMethod){
	window.open ('${ctx}/supplier/image?getMethod=' + getMethod + '&id=${supplier.supplierId}');
}

function showCommentForm(){
	window.open ('${ctx}/supplier/commentForm?id=${supplier.supplierId}','','height=390,width=520,top=50,left=200,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no,status=no,depended=yes,titlebar=no,scrollbars=no,toolbar=no');
}

function goBack() {
	window.location.href="${ctx}/goBack?categoryId=${categoryId}&productId=${productId}&productBrandId=${productBrandId}";
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
  <tr valign="top">
    <td width="160"><table width="160" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr valign="top">
        <td width="10" background="${ctx}/images/bg_pic00f.gif"><img src="${ctx}/images/bg_pic03a.gif" /></td>
        <td width="10" class="title_left"></td>
        <td width="120" bgcolor="#FFFFFF">
		  <!-- 商家名称 -->
		  <table width="110" border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td class="title_left"><c:out value="${supplier.supplierName}"/></td>
            </tr>
            <tr>
              <td><img src="${ctx}/images/line_left.gif" /></td>
            </tr>
          </table>
		  <!-- 商家名称 end -->
		  
		  <!-- 提出评价 -->
          <table width="120" border="0" cellpadding="2" cellspacing="0">
            <tr>
              <td colspan="2" align="center"><a href="javascript:showCommentForm();"><img src="${ctx}/images/btn_comments.gif" /></a></td>
              </tr>
            <tr>
              <td width="72" class="text_line">&nbsp;&nbsp;访问次数：</td>
              <td width="48" class="text_line"><c:out value="${supplier.supplierAccess}" /></td>
            </tr>
            <tr>
              <td class="text_line">&nbsp;&nbsp;评价数量：</td>
              <td class="text_line"><c:out value="${countComments}" /></td>
            </tr>
            <tr>
              <td class="text_line">&nbsp;&nbsp;实名认证：</td>
              <td class="text_line">
              	<c:choose>
                  	<c:when test="${empty supplier.supplierCertify }">否</c:when>
                  	<c:otherwise>
                  		<a href="javascript:showImage('getImage1')">是</a>
                  	</c:otherwise>
                </c:choose></td>
            </tr>
            <tr>
              <td class="text_line">&nbsp;&nbsp;资质认证：</td>
              <td class="text_line">
              	<c:choose>
                	<c:when test="${empty supplier.supplierQualify }">否</c:when>
                	<c:otherwise><a href="javascript:showImage('getImage2')">是</a></c:otherwise>
                </c:choose></td>
            </tr>
            <tr>
              <td class="text_line">&nbsp;&nbsp;信誉等级：</td>
              <td class="text_line"><c:out value="${creditScore}"/></td>
            </tr>
          </table>
		  <!-- 提出评价 end -->

          <br />

		  <!-- 在线联系 -->
          <table width="120" border="0" cellpadding="2" cellspacing="0">
            <tr>
              <td colspan="2" align="center"><img src="${ctx}/images/btn_contact.gif" /></td>
            </tr>
            
            <c:forEach var="qq" items="${qqList}">
             <tr>
              <td width="25" class="text_line">
              <a href="http://wpa.qq.com/msgrd?V=1&Uin=<c:out value='${qq}'/>Site=商讯网&Menu=yes" target="blank">
              <img id="qq_2" height="16" alt="点击这里给我发消息" src="http://wpa.qq.com/pa?p=1:<c:out value='${qq}'/>:4" align="absmiddle" 
      border="no" /></a></td>
              <td width="95" class="text_line"> <c:out value='${qq}'/></td>
            </tr>
                 </c:forEach>
          </table>
		  <!-- 在线联系 end -->
		</td>
        <td width="10" class="title_left" style="vertical-align:top; padding-top:50px"><img src="${ctx}/images/left_pic01.gif" />
            <br /><br /><br /><br /><br /><br /><br /><br /><br />
            <img src="${ctx}/images/left_pic01.gif" /></td>
        <td width="10" background="${ctx}/images/bg_pic00g.gif"><img src="${ctx}/images/bg_pic03c.gif" /><br />
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
		  <!-- 基本信息 -->
		  <table width="700" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr valign="top">
              <td colspan="3" class="title_color07"><img src="${ctx}/images/dot04.gif" />&nbsp;&nbsp; 基本信息</td>
            </tr>
			<tr>
			  <td colspan="3" style="text-align:right; font-weight:bold; padding-right:50px"><a href="javascript:void(0)" onclick="goBack()" class="Aorange"><img src="${ctx}/images/dot01.gif" /> 返回</a></td>
			</tr>
            <tr valign="top">
			  <td><table border="0" cellspacing="0" cellpadding="0">
				  <tr>
					<td class="img_border_w"><img src="${ctx}/supplier/getImage?id=${supplier.supplierId}" width="180" height="200" /></td>
				  </tr>
				</table></td>
              <td width="20">&nbsp;</td>
              <td width="480"><table width="100%" border="0" cellspacing="0" cellpadding="4">
                <tr>
                  <td colspan="2" class="text_14size"><b><c:out value="${supplier.supplierName}"/></b></td>
                </tr>
                <tr>
                  <td width="60">所在地区：</td>
                  <td><c:out value="${area}" /></td>
                </tr>
                <tr>
                  <td>联系电话：</td>
                  <td><c:forEach var="telephone" items="${telephoneList}"><c:out value="${telephone}"/>&nbsp;&nbsp;</c:forEach></td>
                </tr>
                <tr>
                  <td>手机号码：</td>
                  <td><c:forEach var="mobile" items="${mobileList}"><c:out value="${mobile}"/>&nbsp;&nbsp;</c:forEach></td>
                </tr>
                <tr>
                  <td>邮政编码：</td>
                  <td><c:out value="${supplier.supplierZip}" /></td>
                </tr>
                <tr>
                  <td>商家地址：</td>
                  <td><c:out value="${supplier.supplierAddress}" /></td>
                </tr>
                <tr>
                  <td>联 系 人：</td>
                  <td>${supplier.supplierContactname}</td>
                </tr>
                <tr>
                  <td>电子信箱：</td>
                  <td><c:forEach var="email" items="${emailList}"><c:out value="${email}"/>&nbsp;&nbsp;</c:forEach></td>
                </tr>
                <tr>
                  <td>QQ号码：</td>
                  <td><c:forEach var="qq" items="${qqList}"><c:out value="${qq}"/>&nbsp;&nbsp;</c:forEach></td>
                </tr>
                <tr>
                  <td>MSN号：</td>
                  <td><c:forEach var="msn" items="${msnList}"><c:out value="${msn}"/>&nbsp;&nbsp;</c:forEach></td>
                </tr>
              </table></td>
            </tr>
          </table>
		  <!-- 基本信息 end -->
		  
          <br />
		  
		  <!-- 公司介绍 -->
          <table width="700" border="0" align="center" cellpadding="0" cellspacing="0" class="user_list">
            <tr>
              <th>公司介绍</th>
              </tr>
            <tr>
              <td><c:out value="${supplier.supplierDescription}"/></td>
            </tr>
          </table>
		  <!-- 公司介绍 end -->
		  
          <br />
		  
		  <!-- 评价 -->
		  <iframe id="frame_content"  name="frame_content" src="${ctx}/supplier/comments/${supplier.supplierId}?page=1&rows=10" width="100%" height="0" scrolling="no" frameborder="0"></iframe>
		  <!-- 评价 end -->
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
<jsp:include page="footer.jsp"></jsp:include>
<!-- foot end -->

</body>
</html>
