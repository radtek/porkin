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
    <li class="selectTag"><a onclick="selectTag('tagContent0',this)" href="javascript:void(0)">&nbsp;搜索&nbsp;</a></li>
    <li><a onclick="selectTag('tagContent2',this)" href="javascript:void(0)">&nbsp;促销&nbsp;</a></li>
    <li><a onclick="selectTag('tagContent3',this)" href="javascript:void(0)">&nbsp;二手&nbsp;</a></li>
    <li><a onclick="selectTag('tagContent4',this)" href="javascript:void(0)">&nbsp;排名&nbsp;</a></li>
<!--     <li><a onclick="selectTag('tagContent1',this)" href="javascript:void(0)">&nbsp;商家&nbsp;</a></li>-->
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
    	<div id="searchBar2"></div>
    	<div id="commodityP">
	    </div>
	    <div></div>
    </div>
    <div class="tagContent" id="tagContent3">
    	<div id="searchBar3"></div>
      	<div id="commodityS">
	    </div>
	    <div></div>
    </div>
    <div class="tagContent" id="tagContent4">
      <table border="0" cellpadding="0" cellspacing="0" align="center">
        <tr>
        	<td colspan="3"></td>
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
