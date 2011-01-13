<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="common/common.jsp" %>
<html>
<head>
	<script type="text/javascript" src="../scripts/service/commodity.js"></script>
	<script type="text/javascript" src="../scripts/common/common.js"></script>
	<script type="text/javascript" src="../scripts/common/upload.preview.js"></script>
</head>
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
<body>
<table id="commodityList"></table>
<div id="commodityEdit" icon="icon-edit" style="width:500px;height:450px;display:none">
	<div style="background: #fafafa; padding: 10px; text-align: center">
		<form id="commodityForm" action="../commodity/create" method="post"	enctype="multipart/form-data">
			  <div>
          		<label for="name">类别:</label>
              	<select id="categoryId" name="categoryId"> 
              	</select>
              	<label for="name">产品:</label>
              	<select id="productId" name="productId"> 
              	</select>
          	  </div> 
			  <div>
	              	<label for="name">商品名称:</label>
	              	<input class="easyui-validatebox" type="text" name="commodityName" maxlength="20"/>
					<input id="commodityId" name="commodityId" type="hidden" /> 
					<input id="commodityimageId" name="commodityimageId" type="hidden" />
	          </div> 
	          <div>
	              	<label for="name">商品描述:</label>
	              	<input class="easyui-validatebox" type="text" name="commodityDescription" maxlength="20"/>
	          </div> 
	          <div>
	              	<label for="name">开始时间:</label>
	              	<input id="startDate" name="startDate" class="easyui-datebox" required="true" readonly="readonly"/>
	          </div> 
	          <div>
	              	<label for="name">结束时间:</label>
	              	<input id="endDate" name="endDate" class="easyui-datebox" required="true" readonly="readonly"/>
	          </div> 
	          <div>
	              	<label for="name">商品类型:</label>
	              	<select class="easyui-validatebox" id="commodityType" name="commodityType"> 
	                      <option value="S">二手</option> 
	                      <option value="P">促销</option>
	              	</select>
	          </div> 
	          <div>
	              	<label for="name">价格:</label>
	              	<input class="easyui-validatebox" type="text" id="commodityPrice" name="commodityPrice" maxlength="20"/>
	          </div> 
	          <div>
	              	<label for="name">原价:</label>
	              	<input class="easyui-validatebox" type="text" id="commodityPriceOld" name="commodityPriceOld" maxlength="20"/>
	          </div> 
	          <div>
	              	<label for="name">状态:</label>
	              	<select class="easyui-validatebox" id="activeFlag" name="activeFlag"> 
	                      <option value="Y">开启</option> 
	                      <option value="N">禁用</option>
	              	</select>
	          </div>
	          <div>
	              	<label for="name">图片: </label>
					<div id="image_wrapper">  
				        <div id="image_fake">  
				            <img id="image" onload="onPreviewLoad(this)"/>  
				        </div>  
				    </div> 
		    		<input type="file" name="file" id="file" onchange="onUploadImgChange(this, 'image');"/>
	          <div>
					<input type="hidden" name="MAX_FILE_SIZE" value="100000" /> 
	              <input type="submit"  name="submitButton" value="确定" /> 
	              <input type="reset"   name="resetButton " value="重置" onClick="$('#image').empty();"/>
	          </div> 
		</form>
	</div>
</div>
</body>
</html>