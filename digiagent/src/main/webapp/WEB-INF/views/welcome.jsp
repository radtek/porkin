<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<script type="text/javascript" src="${ctx}/scripts/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="${ctx}/scripts/searchbar.js"></script>
<script type="text/javascript" src="${ctx}/scripts/common/common.js"></script>
<script type="text/javascript" src="${ctx}/scripts/commoditylist.js"></script>
<script type="text/javascript" src="${ctx}/scripts/login.js"></script>
<script type="text/javascript" src="${ctx}/scripts/index.js"></script>
<style>
.supplierInfo {
	width:100%; border-color:maroon; float:left;
}
li {list-style-type:none;}
#commodityP,#commodityS {
	padding-top: 20px;
}
#searchBar, #searchBar1, #searchBar2, #searchBar3 {
	font-size: 14px; 
}
#searchBar a, #searchBar1 a, #searchBar2 a, #searchBar3 a{
	font-size: 14px; 
}
</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="commodityTemplate.jsp"></jsp:include>
<div class="indexCenter">
  <div class="logoCenter"></div>
    <div id="dfright2">
	<div id="con">
  <ul id="tags">
    <li class="selectTag"><a onclick="selectTag('tagContent0',this)" href="javascript:void(0)">&nbsp;导购&nbsp;</a></li>
    <li><a onclick="selectTag('tagContent2',this)" href="javascript:void(0)">&nbsp;促销&nbsp;</a></li>
    <li><a onclick="selectTag('tagContent3',this)" href="javascript:void(0)">&nbsp;二手&nbsp;</a></li>
    <li><a onclick="selectTag('tagContent4',this)" href="javascript:void(0)">&nbsp;排名&nbsp;</a></li>
<!--     <li><a onclick="selectTag('tagContent1',this)" href="javascript:void(0)">&nbsp;商家&nbsp;</a></li>-->
  </ul>
  <div id="tagContent" >
    <div class="tagContent selectTag" id="tagContent0">
    <form action="freeSearch" method="post">
      <table border="0" cellpadding="0" cellspacing="0" align="center">
        <tr>
        	<td colspan="3">&nbsp;</td>
        </tr>
        <tr>
          <td><input name="searchkw" type="text" size="70" width="200px" value="${searchkw}"/></td>
          <td>&nbsp;</td>
          <td width="80"> <input type="submit" style="width:100px" name="Reset212222" onmouseout="this.className='button01'" onmouseover="this.className=' button02'" value="搜索" class="button01" /></td>  
        </tr>
        <tr>
        	<td colspan="3">&nbsp;<input type="hidden" name="categoryName" value="${categoryName}"/><input type="hidden" name="productName" value="${productName}"/><input type="hidden" name="brandName" value="${brandName}"/></td>
        </tr>
        <tr>
        	<td colspan="3"><div id="searchBar"></div></td>
        </tr>
         <tr>
        	<td colspan="3">
        	<c:choose>
	        	<c:when test="${empty supplierList}">
	        		<div id="supplierInfo" style="height: 30px; padding: 30px;">暂无数据!</div>        
	        	</c:when>
	        	<c:otherwise>
	        		<div id="supplierInfo" style="height: 30px; padding: 30px;">
	        		<c:forEach var="supplier" items="${supplierList}">
	        			<div id="supplierInfo_${supplier.supplierId}" class="supplierInfo" style="padding-top: 30px;">
		        			<div id="contentLeft__${supplier.supplierId}" style="float:left">
		        				<img id="pic" width="50" height="50" src="supplier/getImage?id=${supplier.supplierId}"/>
		        			</div>
							<div id="contentRight_${supplier.supplierId}">
								<li id="supplierName_${supplier.supplierId}"><a href="supplier/${supplier.supplierId}" style="text-decoration: underline;">${supplier.supplierName}</a></li>
								<li>地址：${supplier.supplierAddress}</li>
								<li id="tel_0">联系电话：${supplier.supplierTelephone}<span style="padding-left: 100px;">&gt;&gt;</span><a href="supplier/${supplier.supplierId}">详情</a></li>
							</div>
						</div>
	        	 	</c:forEach>
	        	 	</div>
	        	</c:otherwise>
        	</c:choose>
			</td>
        </tr>
        
      </table>
    </form>
   
    </div>
    <div class="tagContent" id="tagContent1">
     <table border="0" cellpadding="0" cellspacing="0" align="center">
        <tr>
        	<td colspan="3">&nbsp;</td>
        </tr>
        <tr>
          <td><input name="textfield" type="text" size="70" width="200px" value="${searchkw}" /></td>
          <td>&nbsp;</td>
          <td width="80"> <input type="reset" style="width:100px" name="Reset212222" onmouseout="this.className='button01'" onmouseover="this.className=' button02'" value="搜索" class="button01" /></td>  
                  
        </tr>
        <tr>
        	<td colspan="3">&nbsp;</td>
        </tr>
      </table>
    </div>
    <div class="tagContent" id="tagContent2">
    	<form action="freeSearch" method="post">
	      <table border="0" cellpadding="0" cellspacing="0" align="center">
	        <tr>
	        	<td colspan="3">&nbsp;</td>
	        </tr>
	        <tr>
	          <td><input name="searchkw" type="text" size="70" width="200px" value="${searchkw}" /></td>
	          <td>&nbsp;</td>
	          <td width="80"> <input type="submit" style="width:100px" name="Reset212222" onmouseout="this.className='button01'" onmouseover="this.className=' button02'" value="搜索" class="button01" /></td>  
	        </tr>
	        <tr>
	        	<td colspan="3">&nbsp;</td>
	        </tr>
        </table>
        </form>
    	<div id="searchBar2"></div>
    	<div id="commodityP">
	    </div>
	    <div></div>
    </div>
    <div class="tagContent" id="tagContent3">
    	<form action="freeSearch" method="post">
	      <table border="0" cellpadding="0" cellspacing="0" align="center">
	        <tr>
	        	<td colspan="3">&nbsp;</td>
	        </tr>
	        <tr>
	          <td><input name="searchkw" type="text" size="70" width="200px"/></td>
	          <td>&nbsp;</td>
	          <td width="80"> <input type="submit" style="width:100px" name="Reset212222" onmouseout="this.className='button01'" onmouseover="this.className=' button02'" value="搜索" class="button01" /></td>  
	        </tr>
	        <tr>
	        	<td colspan="3">&nbsp;</td>
	        </tr>
        </table>
        </form>
    	<div id="searchBar3"></div>
      	<div id="commodityS">
	    </div>
	    <div></div>
    </div>
  </div>
  <div class="purductList" id="tagContent4">
	  <br/>
	  <br/>
	  <br/>
	  <div id="searchBar4"></div>
  </div>
</div>
</div>
</div>
</body>
</html>
