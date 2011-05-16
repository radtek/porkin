<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商讯网--商讯导购</title>
<link href="${ctx}/styles/main3.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${ctx}/scripts/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="${ctx}/scripts/searchbar.js"></script>
<script type="text/javascript" src="${ctx}/scripts/common/common.js"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<table border="0" cellspacing="0" cellpadding="0" width="100%" align="center">
  <tr><td height="25"></td></tr>
</table>

<!-- left menu -->
<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="10">&nbsp;</td>
	<td width="15"></td>
    <td width="170"><table width="170" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff">
        <tr>
          <td width="10" rowspan="2" valign="top" background="${ctx}/images/bg_pic00f.gif"><img src="${ctx}/images/bg_pic00a.gif" /></td>
          <td rowspan="2" width="45" style="border-top:1px solid #cccccc"><img src="${ctx}/images/icon_left01.gif" /></td>
          <td class="text_left_en" style="border-top:1px solid #cccccc">Commerce Net Guide</td>
          <td width="10" rowspan="2" valign="top" background="${ctx}/images/bg_pic00g.gif"><img src="${ctx}/images/bg_pic00b.gif" /></td>
        </tr>
        <tr>
          <td bgcolor="#ffffff" class="text_left_on">商讯导购</td>
        </tr>
      </table></td>
    <td width="15"></td>
    <td width="170"><table width="170" border="0" cellspacing="0" cellpadding="0" bgcolor="#f8f8f8">
      <tr>
        <td width="10" rowspan="2" valign="top" background="${ctx}/images/bg_pic02f.gif"><img src="${ctx}/images/bg_pic02a.gif" /></td>
        <td rowspan="2" width="45" style="border-top:1px solid #e2e2e2"><img src="${ctx}/images/icon_left02.gif" /></td>
        <td class="text_left_en" style="border-top:1px solid #e2e2e2">Goods Promotion</td>
        <td width="10" rowspan="2" valign="top" background="${ctx}/images/bg_pic02g.gif"><img src="${ctx}/images/bg_pic02b.gif" /></td>
      </tr>
      <tr>
        <td class="text_left_on"><a href="#" class="Aleft">商品促销 <img src="${ctx}/images/btn_more.gif" /></a></td>
      </tr>
    </table>    </td>
    <td width="15"></td>
    <td width="170"><table width="170" border="0" cellspacing="0" cellpadding="0" bgcolor="#f8f8f8">
      <tr>
        <td width="10" rowspan="2" valign="top" background="${ctx}/images/bg_pic02f.gif"><img src="${ctx}/images/bg_pic02a.gif" /></td>
        <td rowspan="2" width="45" style="border-top:1px solid #e2e2e2"><img src="${ctx}/images/icon_left03.gif" /></td>
        <td class="text_left_en" style="border-top:1px solid #e2e2e2">Second-hand</td>
        <td width="10" rowspan="2" valign="top" background="${ctx}/images/bg_pic02g.gif"><img src="${ctx}/images/bg_pic02b.gif" /></td>
      </tr>
      <tr>
        <td class="text_left_on"><a href="#" class="Aleft">二手信息 <img src="${ctx}/images/btn_more.gif" /></a></td>
      </tr>
    </table>      </td>
    <td width="15"></td>
    <td width="170"><table width="170" border="0" cellspacing="0" cellpadding="0" bgcolor="#f8f8f8">
      <tr>
        <td width="10" rowspan="2" valign="top" background="${ctx}/images/bg_pic02f.gif"><img src="${ctx}/images/bg_pic02a.gif" /></td>
        <td rowspan="2" width="45" style="border-top:1px solid #e2e2e2"><img src="${ctx}/images/icon_left04.gif" /></td>
        <td class="text_left_en" style="border-top:1px solid #e2e2e2">Seller Ranking</td>
        <td width="10" rowspan="2" valign="top" background="${ctx}/images/bg_pic02g.gif"><img src="${ctx}/images/bg_pic02b.gif" /></td>
      </tr>
      <tr>
        <td class="text_left_on"><a href="#" class="Aleft">商家排行 <img src="${ctx}/images/btn_more.gif" /></a></td>
      </tr>
    </table>    </td>
	<td width="15"></td>
    <td><table border="0" cellspacing="0" cellpadding="0" align="right">
      <tr>
        <td width="50"><img src="${ctx}/images/icon_seach.gif" /></td>
        <td><label>
          <input type="text" name="textfield3" class="seach_input" />
        </label></td>
        <td width="15"></td>
        <td><img src="${ctx}/images/btn_seachgo.gif" width="41" height="41" /></td>
      </tr>
    </table></td>
    <td width="10">&nbsp;</td>
  </tr>
  <tr>
    <td height="10" width="10"><img src="${ctx}/images/bg_pic00a.gif" /></td>
    <td background="${ctx}/images/bg_pic00e.gif"></td>
    <td bgcolor="#FFFFFF"></td>
    <td background="${ctx}/images/bg_pic00e.gif"></td>
    <td background="${ctx}/images/bg_pic00e.gif"></td>
    <td background="${ctx}/images/bg_pic00e.gif"></td>
    <td background="${ctx}/images/bg_pic00e.gif"></td>
    <td background="${ctx}/images/bg_pic00e.gif"></td>
    <td background="${ctx}/images/bg_pic00e.gif"></td>
    <td background="${ctx}/images/bg_pic00e.gif"></td>
    <td background="${ctx}/images/bg_pic00e.gif"></td>
    <td><img src="${ctx}/images/bg_pic00b.gif" /></td>
  </tr>
</table>
<!-- left menu end -->

<!-- center -->
<table border="0" cellspacing="0" cellpadding="0" width="95%" align="center">
  <tr valign="top">
	<td><table border="0" cellspacing="0" cellpadding="0" width="100%">
	  <tr>
		<td width="10" background="${ctx}/images/bg_pic00f.gif"></td>
		<td valign="top" bgcolor="#ffffff"><br />
		  
<c:choose>
	<c:when test="${empty navigationList}">
			暂无数据!
	</c:when>
	<c:otherwise>
		<c:set var="category" value=""/>
		<c:set var="product" value=""/>
		<c:set var="brand" value=""/>
		<c:forEach var="navigation" items="${navigationList}" varStatus="status">
			<c:if test="${navigation.CATEGORY_NAME != category}">
				<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
	            <tr valign="top">
	              <td width="140"><table width="130" border="0" cellpadding="0" cellspacing="0">
	                <tr>
	                  <td width="14" height="43"><img src="${ctx}/images/title_bg03a.gif" /></td>
	                  <td background="${ctx}/images/title_bg03c.gif" class="title_color01">${navigation.CATEGORY_NAME}</td>
	                  <td width="14"><img src="${ctx}/images/title_bg03b.gif" /></td>
	                </tr>
	              </table></td>
	              <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
				<c:set var="category" value="${navigation.CATEGORY_NAME}"/>
			</c:if>
			
			<c:set var="tmpProduct" value="${category}_${navigation.PRODUCT_NAME}"/>
			<c:if test="${tmpProduct != product}">
				<tr>
                  <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="100"><table width="100" border="0" cellpadding="0" cellspacing="0">
                          <tr>
                            <td width="6" height="23"><img src="${ctx}/images/title_bg04a.gif" /></td>
                            <td background="${ctx}/images/title_bg04c.gif" class="title_color02">${navigation.PRODUCT_NAME}</td>
                            <td width="14"><img src="${ctx}/images/title_bg04b.gif" /></td>
                          </tr>
                      </table></td>
                      <td class="title_color03" style="background-color:#f4f8fe;">&nbsp;&nbsp;
				<c:set var="product" value="${category}_${navigation.PRODUCT_NAME}"/>
			</c:if>
			
			<a href="#" class="Agray">${navigation.BRAND_NAME}</a> | 
			
			<c:set var="nextIndex" value="${status.index + 1}"/>
			<c:if test="${nextIndex <= status.count}">
				<c:set var="tmpNextProduct" value="${navigationList[nextIndex].CATEGORY_NAME}_${navigationList[nextIndex].PRODUCT_NAME}"/>
				
				<c:if test="${tmpNextProduct != tmpProduct}">
						</td>
	                    </tr>
	                  </table></td>
	                </tr>
	                <tr>
	                  <td height="7"></td>
	                </tr>
				</c:if>
			
				<c:if test="${category != navigationList[nextIndex].CATEGORY_NAME}">
						</table></td>
		              </tr>
		          </table>
				  <table width="100%" border="0" cellspacing="0" cellpadding="0">
		            <tr>
		              <td background="${ctx}/images/line_01a.jpg" align="right"><img src="${ctx}/images/line_01b.jpg" /></td>
		            </tr>
		          </table>
				  <br />
				</c:if>
			</c:if>
		</c:forEach>
	</c:otherwise>
</c:choose>
		
		
		
		  <!-- seller introduction -->
		  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
			  <td rowspan="3" width="70"><img src="${ctx}/images/ad_pic/ad002.jpg" width="70" height="55" class="img_border" /></td>
			  <td rowspan="3" width="15"></td>
			  <td colspan="2"><a href="#"><strong>大连鹏程电脑专卖</strong></a></td>
			</tr>
			<tr>
			  <td colspan="2">地址：大连市友好路；介绍：高性价比宏碁台式电脑，京东商城网罗笔记本，台式机，移动硬盘等...</td>
			</tr>
			<tr>
			  <td>电话：4564714656，4564714656 </td>
			  <td width="75"><a href="#" class="Aorange">&gt;&gt; 查看详情</a></td>
			</tr>
			<tr>
			  <td height="5" colspan="4"></td>
			</tr>
			<tr>
			  <td height="25" background="${ctx}/images/line_01a.jpg" colspan="4" align="right"><img src="${ctx}/images/line_01b.jpg" /></td>
			</tr>
		  </table>
		  <!-- seller introduction end -->
		  
		  <!-- seller introduction -->
		  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
              <td rowspan="3" width="70"><img src="${ctx}/images/ad_pic/ad002.jpg" width="70" height="55" class="img_border" /></td>
              <td rowspan="3" width="15"></td>
              <td colspan="2"><a href="#"><strong>大连鹏程电脑专卖</strong></a></td>
            </tr>
            <tr>
              <td colspan="2">地址：大连市友好路；介绍：高性价比宏碁台式电脑，京东商城网罗笔记本，台式机，移动硬盘等...</td>
            </tr>
            <tr>
              <td>电话：4564714656，4564714656 </td>
              <td width="75"><a href="#" class="Aorange">&gt;&gt; 查看详情</a></td>
            </tr>
            <tr>
              <td height="5" colspan="4"></td>
            </tr>
            <tr>
              <td height="25" background="${ctx}/images/line_01a.jpg" colspan="4" align="right"><img src="${ctx}/images/line_01b.jpg" /></td>
            </tr>
          </table>
		  <!-- seller introduction end -->

		  <!-- seller introduction -->
		  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
              <td rowspan="3" width="70"><img src="${ctx}/images/ad_pic/ad002.jpg" width="70" height="55" class="img_border" /></td>
              <td rowspan="3" width="15"></td>
              <td colspan="2"><a href="#"><strong>大连鹏程电脑专卖</strong></a></td>
            </tr>
            <tr>
              <td colspan="2">地址：大连市友好路；介绍：高性价比宏碁台式电脑，京东商城网罗笔记本，台式机，移动硬盘等...</td>
            </tr>
            <tr>
              <td>电话：4564714656，4564714656 </td>
              <td width="75"><a href="#" class="Aorange">&gt;&gt; 查看详情</a></td>
            </tr>
            <tr>
              <td height="5" colspan="4"></td>
            </tr>
            <tr>
              <td height="25" background="${ctx}/images/line_01a.jpg" colspan="4" align="right"><img src="${ctx}/images/line_01b.jpg" /></td>
            </tr>
          </table>
		  <!-- seller introduction end -->		</td>
		<td width="10" background="${ctx}/images/bg_pic00g.gif"></td>
	  </tr>
	  <tr>
		<td height="10"><img src="${ctx}/images/bg_pic00c.gif" /></td>
		<td background="${ctx}/images/bg_pic00h.gif"></td>
		<td><img src="${ctx}/images/bg_pic00d.gif" /></td>
	  </tr>
    </table></td>
  </tr>
</table>
<!-- center end -->

<br />

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
