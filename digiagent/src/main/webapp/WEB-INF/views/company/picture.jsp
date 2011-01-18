<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商讯网--商家信息--资质认证</title>
<link href="${ctx}/styles/main2.css" rel="stylesheet" type="text/css">
<script src="${ctx}/scripts/common/common.js"></script>
<script src="${ctx}/scripts/Calendar.js"></script>
<script src="${ctx}/scripts/menu.js"></script>
<script type="text/javascript" src="${ctx}/scripts/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="${ctx}/scripts/jquery.form.js"></script>
<script type="text/javascript" src="${ctx}/scripts/common/upload.preview.js"></script>
<script>

$(document).ready(function() {
	var url = "../supplier/getImage1?id=${supplierId}&uuid=" + createUUID();
	$('#image1').attr('src', url);
	var url = "../supplier/getImage2?id=${supplierId}&uuid=" + createUUID();
	$('#image2').attr('src', url);
	formSubmit();
});

//edit event
function formSubmit() {
	$('#supplierForm').ajaxForm({ 
		url: '../supplier/updatePicture',
		beforeSubmit: validate, 
		dataType:  'html', 
      success:   processJson,
      error:   function(err){
	    	alert('更新操作失败！');
		} 
	});
}

function validate(formData, jqForm, options) {
	var form = jqForm[0];
	if (form.file1.value != "") {
		var ext = form.file1.value.split('.').pop().toLowerCase(); 
		var allow = new Array('gif','png','jpg','jpeg'); 
		if(form.file1.value.length > 0 && jQuery.inArray(ext, allow) == -1) {
		
		   alert('请选择图片格式为：gif,png,jpg,jpeg！');
		   return false;
		} 
	}
	if (form.file2.value != "") {
		var ext = form.file2.value.split('.').pop().toLowerCase(); 
		var allow = new Array('gif','png','jpg','jpeg'); 
		if(form.file2.value.length > 0 && jQuery.inArray(ext, allow) == -1) {
		
		   alert('请选择图片格式为：gif,png,jpg,jpeg！');
		   return false;
		} 
	}
	$('#image1_fake').append('<image id="loader" src="../images/datagrid/tree_loading.gif"/> ');
	$('#image2_fake').append('<image id="loader" src="../images/datagrid/tree_loading.gif"/> ');
}
/**
* 字符串转JSON对象
* @param strData
* @return
*/
function parseObj(strData){
	return (new Function( "return " + strData ))();
}

function processJson(data) {
	data = parseObj($(data).text().replace(/=/g,":"));
  if (data.supplierId == -2) {
  	$('#loader').remove();
		alert('商品图片大小应小于65K，请重新操作！');
  	return;
  }
  alert('更新成功！');
  window.location.href = '${ctx}/company/picture';
}
</script>
<style>
#image1_wrapper, #image2_wrapper, #image3_wrapper, #image4_wrapper, #image5_wrapper{   
    display:inline-block;   
    width:300px;   
    height:300px;   
    background-color:#CCC;   
}   
#image1_fake, #image2_fake, #image3_fake, #image4_fake, #image5_fake{ /* 该对象用于在IE下显示预览图片 */   
    filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale);   
}   
#image1_size_fake, #image2_size_fake, #image3_size_fake, #image4_size_fake, #image5_size_fake{ /* 该对象只用来在IE下获得图片的原始尺寸，无其它用途 */   
    filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image);     
    visibility:hidden;   
}   
#image1, #image2, #image3, #image4, #image5{ /* 该对象用于在FF下显示预览图片 */   
    width:300px;   
    height:300px;   
}  
</style>
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
		 <form id="supplierForm" action="${ctx}/company/updatePicture" method="post" enctype="multipart/form-data">
          <table width="500" border="0" align="center" cellpadding="0" cellspacing="0" class="list2">
            <tr>
              <td  class="text_14size" style="border-bottom:1px solid #95b9e9; text-align:center; padding-left:30px"><b>资质认证</b></td>
            </tr>
            <c:if test="${not empty message}">
            	<tr>
      			<td align="left">
      				<strong>
      				<font color="red"><fmt:message key="${message.text}" /></font>
			 		</strong>
				</td>

   			 </tr>
   			 </c:if>
   			 
   			 <tr>
				<td>实名认证:<input value="浏览" type="file" class="btn_02" name="file1" id="file1" onchange="onUploadImgChange(this, 'image1');"/></td>
			</tr>
			<tr>
				<td>
					<div id="image1_wrapper">  
			        	<div id="image1_fake">  
			            	<img id="image1" onload="onPreviewLoad(this)"/>  
			        	</div>  
			    	</div> 
				</td>
			</tr>
			
			 <tr>
				<td>资质认证:<input type="file" class="btn_02" name="file2" id="file2" onchange="onUploadImgChange(this, 'image2');"/></td>
			</tr>
			
			<tr>
				<td>
					<div id="image2_wrapper">  
		      		  <div id="image2_fake">  
		       		     <img id="image2" onload="onPreviewLoad(this)"/>  
		       		 </div>  
		  		  </div> 
		  		</td>
			</tr>
	
				<tr>
					<td class="text_14size" style="border-bottom:1px solid #95b9e9; text-align:center; padding-left:30px">
						<input type="hidden" name="supplierId" value="${supplierId }"/>
						<input class="btn_02" type="submit" value="确认" />
					</td>
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
