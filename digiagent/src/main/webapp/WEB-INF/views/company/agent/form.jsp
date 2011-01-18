<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商讯网--商家信息 --</title>
<link href="${ctx}/styles/main2.css" rel="stylesheet" type="text/css">
<script src="${ctx}/scripts/Calendar.js"></script>
<script src="${ctx}/scripts/menu.js"></script>
<script type="text/javascript" src="${ctx}/scripts/jquery-1.4.2.min.js"></script>
<script>
function setProductSelect(productId) {
	$.ajax({
		url:"${ctx}/productBrand/getProductList",
		data:"id=" + $('select[name="categoryId"]').val(),
		dataType:"html",
		type: "GET",
		success: function(data) {
			$('select[name="productId"]').empty().append(data).val(productId);
		},
		error:function(err) {
	    	alert('数据读取失败！');
		}
	});
}

function setBrandSelect(brandId) {
	$.ajax({
		url:"${ctx}/productBrand/getBrandList",
		data:"id=" + $('select[name="countryId"]').val(),
		dataType:"html",
		type: "GET",
		success: function(data) {
			$('select[name="brandId"]').empty().append(data).val(brandId);
		},
		error:function(err) {
	    	$.messager.alert('消息',err,'error');
		}
	});
}
</script>
</head>

<body>

<!-- head -->
<jsp:include page="../../header.jsp"></jsp:include>
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
          <jsp:include page="../menu.jsp"></jsp:include>
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

		<form action="${ctx}/company/agent/create">
          <table width="650" border="0" align="center" cellpadding="0" cellspacing="0" class="list">
             <tr>
             <td class="text_14size" style="border-bottom:1px solid #95b9e9; text-align:center; padding-left:60px"></td>
             <td class="text_14size" style="border-bottom:1px solid #95b9e9; text-align:center; padding-left:60px"></td>
              <td class="text_14size" style="border-bottom:1px solid #95b9e9; text-align:center; padding-left:60px"><b>代理产品信息</b></td>
              <td class="text_14size" style="border-bottom:1px solid #95b9e9; text-align:center; padding-left:60px"></td>
              <td class="text_14size" style="border-bottom:1px solid #95b9e9; text-align:center; padding-left:60px"></td>
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
				<td><strong>国家</strong></td>
				<td><select  name="countryId" id="countryId" onchange="setBrandSelect()">
					<option value="0" selected>请选择</option>
					<c:forEach items="${countryList}" var="country">
						<option value="${country.countryId}">${country.countryName}</option>
					</c:forEach>
				</select></td>

				<td><strong>品牌</strong></td>
				<td align="left"><select name="brandId" id="brandId"></select></td>
			</tr>
		
			<tr>
				<td><strong>类别</strong></td>
				<td>
					<select name="categoryId" id="categoryId" onchange="setProductSelect()" >
						<option value="0" selected>请选择</option>
							<c:forEach items="${categoryList}" var="category">
								<option value="${category.categoryId}">${category.categoryName}</option>
							</c:forEach>
						</select>
					</td>
				<td><strong>产品</strong></td>
				<td	><select name="productId" id="productId"></select></td>

			</tr>
		    
		    <tr>
		      <td></td>
		      <td></td>
               <td align="center"><input name="btnAdd" type="submit" value="增加" class="btn_02"/></td>
              <td></td>
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
<jsp:include page="../../footer.jsp"></jsp:include>
<!-- foot end -->

</body>
</html>
