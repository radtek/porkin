<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
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
function CheckInputInt(oInput)
{
    if('' != oInput.value.replace(/\d{1,}/,''))
    {
        oInput.value = oInput.value.match(/\d{1,}/) == null ? '' :oInput.value.match(/\d{1,}/);
    }
}

function go(obj) {
	if (event.keyCode == 13) {
		queryCommodityList(obj.value);
	}
}

$(document).ready(function() {
	$('#commodityTemplate').css('display', 'none');
});

function queryCommodityList(pageNum) {
	$.ajax({
		url:"commodity/queryCommodityList",
		dataType:"json",
		data:"page=" + pageNum + "&commodityType=S",
		type: "GET",
		success: function(data) {
			if (data.total==0) return;
			$('#commodityS').empty();
			var result = jQuery.parseJSON(data.resultList);
			$.each(result, function(index, commodity) {
				var str = $('#commodityTemplate').html();
				str = str.replace('rowNum', (pageNum - 1) * 10 + index + 1);
				str = str.replace(/commodityName/g, commodity.commodityName == null ? '暂无' : commodity.commodityName);
				str = str.replace(/commodityPrice/g, commodity.commodityPrice == null ? '暂无' : commodity.commodityPrice);
				str = str.replace(/imageId/g, commodity.imageId);
				str = str.replace(/supplierContactname/g, commodity.supplierContactname == null ? '暂无' : commodity.supplierContactname);
				str = str.replace(/supplierMobile/g, commodity.supplierMobile == null ? '暂无' : commodity.supplierMobile);
				str = str.replace(/supplierTelephone/g, commodity.supplierTelephone == null ? '暂无' : commodity.supplierTelephone);
				str = str.replace(/supplierAddress/g, commodity.supplierAddress == null ? '暂无' : commodity.supplierAddress);
				str = str.replace(/userEmail/g, commodity.userEmail == null ? '暂无' : commodity.userEmail);
				$('#commodityS').append('<tr><td>' + str + '</td></tr>');
		    });
			var totalPage = Math.ceil(data.total/10.0);
			var prePageNum = pageNum - 1 < 1 ? 1 : pageNum - 1;
			var nextPageNum = pageNum + 1 > totalPage ? totalPage : pageNum + 1;
			$('#commodityS').next().empty().append('<a href="javascript:void(0)" onclick="queryCommodityList(1)">首页</a>&nbsp;<a href="javascript:void(0)" onclick="queryCommodityList('+prePageNum+')">前一页</a>&nbsp;共<input type="text" name="pageNum" size=2 value="'+pageNum+'" onkeyup="CheckInputInt(this);" onkeypress="go(this);"/>/' + totalPage + '页&nbsp;<a href="javascript:void(0)" onclick="queryCommodityList('+nextPageNum+')">后一页</a>&nbsp;<a href="javascript:void(0)" onclick="queryCommodityList('+totalPage+')">末页</a>&nbsp;共'+data.total+'条记录');
		},
		error: function(xhr, ajaxOptions, thrownError){
	        alert("数据读取失败！");
	    }
	});
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
	if (showContent == 'tagContent2') {
		queryCommodityList(1);
	}
	document.getElementById(showContent).style.display = "block";
}
</script>
</head>
<body>
<div class="headTop">
    <div class="headCity">切换城市           
      <select name="select3" style="width:60px;">
        <option>大连</option>
        <option>上海</option>
      </select>
      您好,用户姓名
      <select name="select4" style="width:80px;">
        <option>个人中心</option>
      </select> 
        <input class="btn_login" type="submit" value="登录" />
    <span class="leftLink"><a href="security/registerForm">注册</a> | <a href="security/passwordForm">忘记密码</a></span>
    <span class="rightLink">帮助 | 设为首页</span>
    </div>
   
	
</div>
<div style="clear: both"></div>

<!-- commodity layout template start -->
<div id="commodityTemplate">
   <div class="liststyle">
    	<div style="float:left; width:100px; padding:20px; height:auto">
        	<div>
				<span>rowNum</span><img src="commodity/getImage?id=imageId" width="80" height="80" style="cursor:pointer" alt="commodityName"/>
			</div>
			<div style="paddingTop:5px;text-align:center">￥commodityPrice</div>
		</div>  
		<div>
			<div>商品名称：commodityName</div>
			<div>联 系 人：supplierContactname</div>
			<div>联系电话：<span class=hong14b>supplierMobile</span></div>
			<div>手机号码：<span class=hong14b>supplierTelephone</span></div>
			<div>电子邮箱：userEmail</div>
			<div>联系地址：supplierAddress</div>
		</div>
	</div>
</div>
<!-- commodity layout template end -->

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
    <div class="tagContent selectTag" id="tagContent0" style="background-color:red">
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
    <div class="tagContent" id="tagContent1" style="background-color:green">
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
	    <table id="commodityS">
	    </table>
	    <div></div>
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
