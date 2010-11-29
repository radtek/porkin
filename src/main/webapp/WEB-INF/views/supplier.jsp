<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="common/common.jsp" %>
<html>
<head>
	<script type="text/javascript" src="../scripts/service/supplier.js"></script>
	<script type="text/javascript" src="../scripts/common/common.js"></script>
	<script type="text/javascript" src="../scripts/common/upload.preview.js"></script>
<style>
#image_wrapper, #image1_wrapper, #image2_wrapper, #image3_wrapper, #image4_wrapper, #image5_wrapper{   
    display:inline-block;   
    width:200px;   
    height:200px;   
    background-color:#CCC;   
} 
#image_fake, #image1_fake, #image2_fake, #image3_fake, #image4_fake, #image5_fake{ /* 该对象用于在IE下显示预览图片 */   
    filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale);   
}   
#image_size_fake, #image1_size_fake, #image2_size_fake, #image3_size_fake, #image4_size_fake, #image5_size_fake{ /* 该对象只用来在IE下获得图片的原始尺寸，无其它用途 */   
    filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image);     
    visibility:hidden;   
}   
#image, #image1, #image2, #image3, #image4, #image5{ /* 该对象用于在FF下显示预览图片 */   
    width:100px;   
    height:100px;   
}
</style>
</head>
<body>
	<table id="supplierList"></table>
	<div id="supplierEdit" icon="icon-edit" style="width:500px;height:400px;display:none">
		<div style="background:#fafafa;padding:10px;text-align:center">
		<form id="supplierForm" action="../supplier/create" method="post" enctype="multipart/form-data"> 
		  <div>
              	<label for="name">省份:</label>
              	<select id="provinceId" name="provinceId"> 
              	</select>
              	<label for="name">城市:</label>
              	<select id="cityId" name="cityId"> 
              	</select>
          </div>
          <div>
              	<label for="name">商家名称:</label>
              	<input type="hidden" name="supplierId"/>
              	<input type="hidden" name="supplierAccess"/>
              	<input type="hidden" name="supplierScore"/>
              	<input class="easyui-validatebox" type="text" name="supplierName" maxlength="20"/>
          		<label for="name">联系人:</label>
              	<input class="easyui-validatebox" type="text" name="supplierContactname" maxlength="30"/>
          </div> 
          <div>
              	<label for="name">邮件:</label>
              	<input class="easyui-validatebox" type="text" name="userEmail" maxlength="30"/>
          		<label for="name">邮编:</label>
              	<input class="easyui-validatebox" type="text" name="supplierZip" maxlength="30"/>
          </div> 
          <div>
              	<label for="name">传真:</label>
              	<input class="easyui-validatebox" type="text" name="supplierFax" maxlength="30"/>
          		<label for="name">手机:</label>
              	<input class="easyui-validatebox" type="text" name="supplierMobile" maxlength="30"/>
          </div> 
          <div>
              	<label for="name">联系电话:</label>
              	<input class="easyui-validatebox" type="text" name="supplierTelephone" maxlength="30"/>
          		<label for="name">联系地址:</label>
              	<input class="easyui-validatebox" type="text" name="supplierAddress" maxlength="30"/>
          </div> 
	      <div>
             	<label for="name">图片: </label>
		  		<div id="image_wrapper">  
			        <div id="image_fake">  
			            <img id="image" onload="onPreviewLoad(this)"/>  
			        </div>  
			    </div> 
	    		<input type="file" name="file" id="file" onchange="onUploadImgChange(this, 'image');"/>
	      </div>
	      <div>
             	<label for="name">实名认证: </label>
	          	<div id="image1_wrapper">  
			        <div id="image1_fake">  
			            <img id="image1" onload="onPreviewLoad(this)"/>  
			        </div>  
			    </div> 
	    		<input type="file" name="file1" id="file1" onchange="onUploadImgChange(this, 'image1');"/>
	      </div>
	      <div>
             	<label for="name">资质认证: </label>
	          	<div id="image2_wrapper">  
			        <div id="image2_fake">  
			            <img id="image2" onload="onPreviewLoad(this)"/>  
			        </div>  
			    </div> 
	    		<input type="file" name="file2" id="file2" onchange="onUploadImgChange(this, 'image2');"/>
	      </div>
	      <div>
              	<label for="name">简介:</label>
              	<textarea rows="5" cols="20" name="supplierDescription" id="supplierDescription"></textarea>
	      </div>
          <div>
              	<label for="name">状态:</label>
              	<select class="easyui-validatebox" id="activeFlag" name="activeFlag"> 
                      <option value="Y">开启</option> 
                      <option value="N">禁用</option>
              	</select>
          </div>
          <div>
              	<input type="hidden" name="supplierWebsite" value="NONE"/>
              <input type="submit"  name="submitButton" value="确定" /> 
              <input type="reset"   name="resetButton " value="重置" />
          </div> 
      </form> 
      </div>
	</div>
</body>
</html>