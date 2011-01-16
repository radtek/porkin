<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商讯网--商品促销</title>
<link href="${ctx}/styles/main2.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${ctx}/scripts/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="${ctx}/scripts/searchbar.js"></script>
<script type="text/javascript" src="${ctx}/scripts/common/common.js"></script>
<script type="text/javascript" src="${ctx}/scripts/commoditylist.js"></script>
<script type="text/javascript">
/**
 * 页面加载初始化
 */
$(document).ready(function() {
	commodityType = 'P';
	addAD('#searchBar');
	getCategoryJson('#categoryTR');
});
</script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<table border="0" cellspacing="0" cellpadding="0" width="100%" align="center">
  <tr><td height="25"></td></tr>
</table>

<!-- center -->
<table border="0" cellspacing="0" cellpadding="0" width="950" align="center">
  <tr valign="top">
    <td width="190">
	
<!-- left menu -->
	  <table border="0" cellspacing="0" cellpadding="0">
	  	<tr valign="top">
		  <td>
		  <!-- left menu on -->
		  <table border="0" cellspacing="0" cellpadding="0" width="190">
            <tr>
              <td height="10" width="10"><img src="images/bg_pic02a.gif" /></td>
              <td background="images/bg_pic02e.gif" colspan="2"></td>
              <td width="10"><img src="images/bg_pic02b.gif" /></td>
              <td width="20"></td>
            </tr>
            <tr>
              <td background="images/bg_pic02f.gif" rowspan="2"></td>
              <td bgcolor="#f8f8f8" rowspan="2" width="45"><img src="images/icon_left01.gif" /></td>

              <td bgcolor="#f8f8f8" class="text_left_en">Commerce Net Guide</td>
              <td background="images/bg_pic02g.gif" rowspan="2"></td>
              <td rowspan="2"></td>
            </tr>
            <tr>
              <td bgcolor="#f8f8f8" class="text_left"><a href="${ctx}" class="Aleft">商讯导购 <img src="images/btn_more.gif" /></a></td>
            </tr>
            <tr>

              <td height="10"><img src="images/bg_pic02c.gif" /></td>
              <td background="images/bg_pic02h.gif" colspan="2"></td>
              <td><img src="images/bg_pic02d.gif" /></td>
              <td></td>
            </tr>
            <tr>
              <td height="10"></td>
              <td colspan="2"></td>
              <td></td>
              <td><img src="images/bg_pic01g.gif"></td>
            </tr>

          </table>
		  <!-- left menu on end --></td>
        </tr>
	    <tr>
		  <td>
		  <!-- left menu off -->
		  <table border="0" cellspacing="0" cellpadding="0" width="190">
			<tr>
			  <td height="10" width="10"><img src="images/bg_pic00a.gif" /></td>
              <td background="images/bg_pic00e.gif" colspan="2"></td>
              <td background="images/bg_pic00e.gif" width="10"></td>
              <td width="20"><img src="images/bg_pic01f.gif" /></td>
			</tr>
			<tr>
			  <td background="images/bg_pic00f.gif" rowspan="2"></td>
              <td bgcolor="#ffffff" rowspan="2" width="45"><img src="images/icon_left04.gif" /></td>
              <td bgcolor="#ffffff" class="text_left_en">Goods Promotion</td>
              <td bgcolor="#ffffff" rowspan="2"></td>
              <td bgcolor="#ffffff" rowspan="2"></td>
			</tr>
			<tr>
			  <td bgcolor="#ffffff" class="text_left_on">商品促销</td>
			</tr>
			<tr>
			  <td height="10"><img src="images/bg_pic00c.gif" /></td>
              <td background="images/bg_pic00h.gif" colspan="2"></td>
              <td background="images/bg_pic00h.gif"></td>
              <td><img src="images/bg_pic01d.gif" /></td>
			</tr>
			<tr>
			  <td height="10"></td>
              <td colspan="2"></td>
              <td></td>
              <td><img src="images/bg_pic01e.gif" /></td>
			</tr>
		  </table>
		  <!-- left menu off end -->
		</td>
	    </tr>
	    <tr>
		  <td>
		  <!-- left menu off -->
		  <table border="0" cellspacing="0" cellpadding="0" width="190">
			<tr>
			  <td height="10" width="10"><img src="images/bg_pic02a.gif" /></td>
			  <td background="images/bg_pic02e.gif" colspan="2"></td>
			  <td width="10"><img src="images/bg_pic02b.gif" /></td>
			  <td width="20"></td>
			</tr>
			<tr>
			  <td background="images/bg_pic02f.gif" rowspan="2"></td>
			  <td bgcolor="#f8f8f8" rowspan="2" width="45"><img src="images/icon_left03.gif" /></td>
			  <td bgcolor="#f8f8f8" class="text_left_en">Second-hand</td>
			  <td background="images/bg_pic02g.gif" rowspan="2"></td>
			  <td rowspan="2"></td>
			</tr>
			<tr>
			  <td bgcolor="#f8f8f8" class="text_left"><a href="${ctx }/secondHand" class="Aleft">二手信息<img src="images/btn_more.gif" /></a></td>
			</tr>
			<tr>
			  <td height="10"><img src="images/bg_pic02c.gif" /></td>
			  <td background="images/bg_pic02h.gif" colspan="2"></td>
			  <td><img src="images/bg_pic02d.gif" /></td>
			  <td></td>
			</tr>
			<tr>
			  <td height="10"></td>
			  <td colspan="2"></td>
			  <td></td>
			  <td></td>
			</tr>
		  </table>
		<!-- left menu off end -->
		</td>
	    </tr>
	    <tr>
		  <td>
		  <!-- left menu off -->
		  <table border="0" cellspacing="0" cellpadding="0" width="190">
            <tr>
              <td height="10" width="10"><img src="images/bg_pic02a.gif" /></td>
              <td background="images/bg_pic02e.gif" colspan="2"></td>
              <td width="10"><img src="images/bg_pic02b.gif" /></td>
              <td width="20"></td>
            </tr>
            <tr>
              <td background="images/bg_pic02f.gif" rowspan="2"></td>
              <td bgcolor="#f8f8f8" rowspan="2" width="45"><img src="images/icon_left04.gif" /></td>
              <td bgcolor="#f8f8f8" class="text_left_en">Seller Ranking</td>
              <td background="images/bg_pic02g.gif" rowspan="2"></td>
              <td rowspan="2"></td>
            </tr>
            <tr>
              <td bgcolor="#f8f8f8" class="text_left"><a href="${ctx}" class="Aleft">商家排行<img src="images/btn_more.gif" /></a></td>
            </tr>
            <tr>
              <td height="10"><img src="images/bg_pic02c.gif" /></td>
              <td background="images/bg_pic02h.gif" colspan="2"></td>
              <td><img src="images/bg_pic02d.gif" /></td>
              <td></td>
            </tr>
            <tr>
              <td height="10"></td>
              <td colspan="2"></td>
              <td></td>
              <td></td>
            </tr>
          </table>
		  <!-- left menu off end --></td>
	    </tr>
      </table>
<!-- left menu end -->
	</td>

	<td>
	<table id="tagContent" border="0" cellspacing="0" cellpadding="0" width="100%">
	  <tr>
		<td width="10" height="10"><img src="images/bg_pic00a.gif"></td>
		<td background="images/bg_pic00e.gif"></td>
		<td width="10"><img src="images/bg_pic00b.gif"></td>
	  </tr>
	  <tr>
		<td valign="top" background="images/bg_pic00f.gif" style="padding-top:54px;"><img src="images/color_white.gif" width="10" height="72" /></td>
		<td bgcolor="#ffffff" valign="top">
		  <table border="0" cellspacing="0" cellpadding="0" align="center">
			<tr>
			  <td height="15" colspan="4"></td>
			</tr>
			<tr>
			  <td width="50"><img src="images/icon_seach.gif" /></td>
			  <td><label>
				<input type="text" name="searchkw" class="seach_input" value="${searchkw}"/>
			  </label></td>
			  <td width="15"></td>
			  <td><input type="image" src="images/btn_seachgo.jpg" name="btnP"/></td>
			</tr>
			<tr>
			  <td height="20" colspan="4"><input type="hidden" name="categoryId" value="${categoryId}"/><input type="hidden" name="productId" value="${productId}"/><input type="hidden" name="productBrandId" value="${productBrandId}"/></td>
			</tr>
		  </table>
		  <table id="searchBar" border="0" cellspacing="0" cellpadding="0" width="620" align="center">
		  </table>
		  
		  <br /><br id="supplierBR"/>
		</td>
		<td background="images/bg_pic00g.gif"></td>
	  </tr>
	  <tr>
		<td height="10"><img src="images/bg_pic00c.gif" /></td>
		<td background="images/bg_pic00h.gif"></td>
		<td><img src="images/bg_pic00d.gif" /></td>
	  </tr>
    </table></td>
  </tr>
</table>
<!-- center end -->

<br />

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
