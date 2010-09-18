<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<link href="styles/main.css" rel="stylesheet" type="text/css" />
<style>
.supplierInfo {
	height:100px; width:100%; border-color:maroon; border-style:solid; border-width:1px;float:left;
}
li {list-style-type:none;}
</style>
<script src="scripts/Calendar.js"></script>
<script src="scripts/menu.js"></script>
<script type="text/javascript" src="scripts/jquery-1.4.2.min.js"></script>
<script language="javascript">

var getCategoryJson = function() {
	$.ajax({
		url:"searchComponentBar/getCategoryList",
		dataType:"json",
		type: "GET",
		success: function(data) {
			if (data.length==0) return;
			$('<div id="categoryBar" style="height:30px"></div>').empty().append('类别: ').appendTo('#searchBar');
			$.each(data, function(index, category) {
				$('#categoryBar').append($('<a></a>').attr('href', '#').text(category.categoryName).click(function() {
					var param = encodeURI($(this).text());
			        getProductJson(param);
		        }));
		        if ((index + 1) < data.length) {
		        	$('#categoryBar').append(" | ");
		        }
		    });
		},
		error: function(xhr, ajaxOptions, thrownError){
            alert("数据读取失败！");
        }
	});
};

var getProductJson = function(categoryName) {
	$('#supplierInfo').remove();
	$('#brandBar').remove();
	$('#productBar').remove();
	$.ajax({
		url: "searchComponentBar/getProductList",
		dataType: "json",
		type: "GET",
		data:{categoryName:categoryName},
		success: function(data) {
			if (data.length==0) return;
			$('<div id="productBar" style="height:30px"></div>').empty().append('产品: ').appendTo('#searchBar');
			$.each(data, function(index, product) {
		        $('#productBar').append($('<a></a>').attr('href', '#').text(product.productName).click(function() {
		        	var param = encodeURI($(this).text());
		        	getBrandJson(param);
		        }));
		        if ((index + 1) < data.length) {
		        	$('#productBar').append(" | ");
		        }
		    });
		},
		error: function(xhr, ajaxOptions, thrownError){
            alert("数据读取失败！");
        }
	});
};

var getBrandJson = function(productName) {
	$('#supplierInfo').remove();
	$('#brandBar').remove();
	$.ajax({
		url: "searchComponentBar/getBrandList",
		dataType: "json",
		type: "GET",
		data: {productName:productName},
		success: function(data) {
			if (data.length==0) return;
			$('<div id="brandBar" style="height:30px"></div>').empty().append('品牌: ').appendTo('#searchBar');
			$.each(data, function(index, brand) {
		        $('#brandBar').append($('<a></a>').attr('href', '#').text(brand.brandName).click(function() {
		        	var param = encodeURI($(this).text());
		        	getSupplierJson(param);
		        }));
		        if ((index + 1) < data.length) {
		        	$('#brandBar').append(" | ");
		        }
		    });
		},
		error: function(xhr, ajaxOptions, thrownError){
            alert("数据读取失败！");
        }
	});
};

var getSupplierJson = function(brandName) {
	$('#supplierInfo').remove();
	$.ajax({
		url: "searchComponentBar/getSupplierList",
		dataType: "json",
		type: "GET",
		data: {brandName:brandName},
		success: function(data) {
			if (data.length==0) return;
			$('<div id="supplierInfo" style="height:30px;padding:20px"></div>').empty().append('商家: ').appendTo('#searchBar');
			$.each(data, function(index, supplier) {
		        $('<div class="supplierInfo"></div>').appendTo('#supplierInfo').attr('id', "supplierInfo_" + index).ready(function() {
		        });
		        $('<div style="float:left"></div>').attr('id', "contentRight_" + index).appendTo("#supplierInfo_" + index);
		        $('<li></li>').text("供应商：" + supplier.supplierName).appendTo("#contentRight_" + index);
		        $('<li></li>').text("地址：" + supplier.supplierAddress).appendTo("#contentRight_" + index);
		        $('<li></li>').text("联系人：" + supplier.supplierContactname).appendTo("#contentRight_" + index);
		        $('<li></li>').text("手机：" + supplier.supplierMobile).appendTo("#contentRight_" + index);
		        $('<li></li>').text("联系电话：" + supplier.supplierTelephone).appendTo("#contentRight_" + index);
		        $('<li></li>').text("传真：" + supplier.supplierFax).appendTo("#contentRight_" + index);
		        $('<li></li>').text("邮编：" + supplier.supplierZip).appendTo("#contentRight_" + index);
		        $('<li></li>').text("简介：" + supplier.supplierDescription).appendTo("#contentRight_" + index);

		        $('<div></div>').attr('id', "contentLeft_" + index).appendTo("#supplierInfo_" + index);
		        $('<img id="pic" width="100" height="100"/>').attr('src', "supplier/getImage?id=" + supplier.supplierId).appendTo("#contentLeft_" + index);
		    });
		},
		error: function(xhr, ajaxOptions, thrownError){
            alert("数据读取失败！");
        }
	});
};

$(document).ready(function() {
	getCategoryJson();
});

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
</head>
<body>
<div class="headTop">
    <div class="headCity">切换城市&nbsp;           
      <select name="select3" style="width:60px;">
        <option>大连</option>
        <option>上海</option>
        </select>
      &nbsp;您好,&nbsp;用户姓名&nbsp;
      <select name="select4" style="width:80px;">
        <option>个人中心</option>
        </select> 
        &nbsp;
      <input class="btn_login" type="submit" value="登录" />
    </div>
  <div class="logo"></div>
    <div class="rightLink">登录 | 注册 | 帮助</div>
    <div class="redLine"></div>
</div>

<DIV style="CLEAR: both"></DIV>
<DIV id=dfleft>
<DIV class=sidebar>
    <DIV class=blk>
    <H3>用户操作</H3>
        <DIV class=c>                   
            <DIV class=blk2>                       
                <UL>
                  <LI><b><A href="http://dl.bbs.house.sina.com.cn/forumdisplay.php?fid=9395" 
                  target=_blank>个人信息 </A></b>
                  <ul>
                  <LI><A href="http://dl.bbs.house.sina.com.cn/forumdisplay.php?fid=44127" 
                  target=_blank>账户信息</A>
                  <LI><A href="http://dl.bbs.house.sina.com.cn/forumdisplay.php?fid=36551" 
                  target=_blank>会员相关</A>
                  <LI><A href="http://dl.bbs.house.sina.com.cn/forumdisplay.php?fid=9693" 
                  target=_blank>个人资料</A>
                  <LI><A href="http://dl.bbs.house.sina.com.cn/forumdisplay.php?fid=9386" 
                  target=_blank>兴趣爱好</A>
                  <LI><A href="http://dl.bbs.house.sina.com.cn/forumdisplay.php?fid=28498" 
                  target=_blank>上传头像</A>
                  <LI><A href="http://dl.bbs.house.sina.com.cn/forumdisplay.php?fid=14214" 
                  target=_blank>实名认证</A>
                  </ul>
                  <LI><b><A href="http://dl.bbs.house.sina.com.cn/forumdisplay.php?fid=22866" 
                  target=_blank>二手发布</A></b></LI></UL></DIV></DIV></DIV>
        </DIV>
    </DIV>
</DIV>
</DIV>
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
          <td width="80"> <input type="reset" style="width:100px" name="Reset212222" onmouseout="this.className='button01'" onmouseover="this.className=' button02'" value="搜索" class="button01" /></td>  
                  
        </tr>
        <tr>
        	<td colspan="3"><div id="searchBar"></div></td>
        </tr>
      </table>
    </div>
    <div class="tagContent" id="tagContent1">
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
        	<td colspan="3"></td>
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
</body>
</html>
