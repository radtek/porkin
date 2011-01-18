<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商讯网--商家信息</title>
<link href="${ctx}/styles/main2.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${ctx}/scripts/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="${ctx}/scripts/jquery.form.js"></script>
<script type="text/javascript" src="${ctx}/scripts/Calendar.js"></script>
<script type="text/javascript" src="${ctx}/scripts/common/upload.preview.js"></script>
<script type="text/javascript" src="${ctx}/scripts/infoRelease.js"></script>
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
		 <form id="commodityForm" name="commodityForm" action="${ctx}/commodity/release" method="post" enctype="multipart/form-data">
          <table width="600" border="0" align="center" cellpadding="0" cellspacing="0" class="list2">
            <tr>
              <td colspan="2" class="text_14size" style="border-bottom:1px solid #95b9e9; text-align:center; padding-left:30px"><b>促销发布</b></td>
            </tr>
            
   			 
			<tr>
	              <th>类别：</th>
	              <td>
	              	<select id="categoryId" name="categoryId"></select>
	              </td>
			</tr>
			
            <tr>
	              <th>产品：</th>
	              <td><select id="productId" name="productId"></select></td>
            </tr>
            
            <tr>
	              <th>商品名称：</th>
	              <td>
	              	<input type="hidden" name="commodityId" id="commodityId" size="30"/>
	              	<input type="text" name="commodityName" id="commodityName" size="30"/>
	              </td>
            </tr>
            
            <tr>
	              <th>商品单价：</th>
	              <td>
	              	<input type="text" name="commodityPrice" id="commodityPrice" size="30"/>
	              </td>
            </tr>
            
            <tr>
	              <th>商品原价：</th>
	              <td>
	              	<input type="text" name="commodityPriceOld" id="commodityPriceOld" size="30"/>
	              </td>
            </tr>
            
            <tr>
	              <th>开始时间：</th>
	              <td>
	              	<input type="text" name="startDate" id="startDate" size="30" readonly="readonly" onclick="SelectDate(this,'yyyy/MM/dd');"/>
	              </td>
            </tr>            
            
            <tr>
	              <th>结束时间：</th>
	              <td>
	              	<input type="text" name="endDate" id="endDate" size="30" readonly="readonly" onclick="SelectDate(this,'yyyy/MM/dd');"/>
	              </td>
            </tr>
            
             <tr>
	              <th>商品描述：</th>
	              <td>
	              	<textarea name="commodityDescription" id="commodityDescription" cols="50" rows="5"></textarea>
	              </td>
            </tr>
            
            <tr>
	              <th>图片1：</th>
	              <td>
	              	<input type="file" name="file1" id="file1" class="btn_02" onchange="onUploadImgChange(this, 'image1');"/>
	              </td>
            </tr>
            
            <tr>
	              <th>&nbsp;</th>
	              <td>
	              	<div id="image1_wrapper">  
		        		<div id="image1_fake">  
		            		<img id="image1" onload="onPreviewLoad(this)"/>  
		        		</div>  
		    		</div>
	              </td>
            </tr>
            
             <tr>
	              <th>图片2：</th>
	              <td>
	              	<input type="file" name="file2" id="file2"  class="btn_02" onchange="onUploadImgChange(this, 'image2');"/>
	              </td>
            </tr>
            
             <tr>
	              <th>&nbsp;</th>
	              <td>
	              	<div id="image2_wrapper">  
		        		<div id="image2_fake">  
		            		<img id="image2" onload="onPreviewLoad(this)"/>  
		        		</div>  
		    		</div>
	              </td>
            </tr>
            
            
             <tr>
	              <th>图片3：</th>
	              <td>
	              	<input type="file" name="file3" id="file3"  class="btn_02" onchange="onUploadImgChange(this, 'image3');"/>
	              </td>
            </tr>
            
             <tr>
	              <th>&nbsp;</th>
	              <td>
	              	<div id="image3_wrapper">  
		        		<div id="image3_fake">  
		            		<img id="image3" onload="onPreviewLoad(this)"/>  
		       			</div>  
		    		</div>
	              </td>
            </tr>
            
            
             <tr>
	              <th>图片4：</th>
	              <td>
	              	<input type="file" name="file4" id="file4" class="btn_02"  onchange="onUploadImgChange(this, 'image4');"/>
	              </td>
            </tr>
            
            
             <tr>
	              <th>&nbsp;</th>
	              <td>
	              		<div id="image4_wrapper">  
		        			<div id="image4_fake">  
		            			<img id="image4" onload="onPreviewLoad(this)"/>  
		        			</div>  
		   			 	</div>
	              </td>
            </tr>
            
             <tr>
	              <th>图片5：</th>
	              <td>
	              	<input type="file" name="file5" id="file5" class="btn_02"  onchange="onUploadImgChange(this, 'image5');"/>
	              </td>
            </tr>
            
             <tr>
	              <th>&nbsp;</th>
	              <td>
	              		<div id="image5_wrapper">  
		        			<div id="image5_fake">  
		            			<img id="image5" onload="onPreviewLoad(this)"/>  
		        			</div>  
		   				 </div>
	              </td>
            </tr>
            
            
            <tr>
              	<th>
			  	</th>
              	<td>
              		<input type="submit" value="发布" class="btn_02" onclick="releaseInfo()"/>
              		<input type="reset" name="reset" class="btn_02" value="取消"/>
					<input type="hidden" name="MAX_FILE_SIZE" value="100000" /> 
					<input type="hidden" name="commodityType" value="P" />
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
<jsp:include page="../footer.jsp"></jsp:include>
<!-- foot end -->

</body>
</html>
