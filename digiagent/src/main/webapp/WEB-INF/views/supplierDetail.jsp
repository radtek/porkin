<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><c:out value="${supplier.supplierName}"/></title>
<link href="${ctx}/styles/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx}/scripts/jquery-1.4.2.min.js"></script>

<script type="text/javascript" src="${ctx}/scripts/login.js"></script>
<script type="text/javascript" src="${ctx}/scripts/index.js"></script>
<script language="javascript">
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
<script language="javascript">
function showCommentForm(){
	window.open ('${ctx}/supplier/commentForm','','height=360,width=520,top=50,left=200,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no,status=no,depended=yes,titlebar=no,scrollbars=no,toolbar=no');
}


</script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<DIV style="CLEAR: both"></DIV>
<div class="div_body">
  <div class="bodyW mt8">
    <!--右边-->
    <div class="Brr">
      <!--基本信息开始-->
      <div class="mod_comp">
        <div class="mod_compT">基本信息</div>
        <table cellspacing="12" cellpadding="0" width="100%" border="0">
          <tbody>
            <tr>
              <td valign="top"><table cellspacing="0" cellpadding="0" width="100%" border="0">
                <tbody>
                  <tr>
                    <td class="Al_11" height="120"><img	src="${ctx}/supplier/getImage?id=${supplier.supplierId}" /></td>
                  </tr>
                </tbody>
              </table></td>
              <td><div class="Al_2 l f14" 
      style="PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; WIDTH: 530px; PADDING-TOP: 0px"><span 
      class="comp"><c:out value="${supplier.supplierName}"/></span> <img alt="当前在线" 
      src="${ctx}/images/common/online.gif" 
      align="absmiddle" /> <br />
                      <div 
      style="MARGIN: 0px 0px 8px; OVERFLOW: hidden; WIDTH: 100%; BORDER-BOTTOM: #ccc 1px dotted; HEIGHT: 8px"></div>
              
      
                所在地区：<c:out value="${area}" /><br /><BR/>

                联系电话：<c:forEach var="telephone" items="${telephoneList}"><c:out value="${telephone}"/>&nbsp;&nbsp;</c:forEach> 
                <br />
                <br />
                手机号码：<c:forEach var="mobile" items="${mobileList}"><c:out value="${mobile}"/>&nbsp;&nbsp;</c:forEach><br /><br />
                
               邮政编码：<c:out value="${supplier.supplierZip}" /><br /><br />
                <span 
      style="DISPLAY: inline-block; FLOAT: left">联系地址：</span><span 
      style="DISPLAY: inline-block; FLOAT: left"><c:out value="${supplier.supplierAddress}" /></span><br 
      clear="all" />
               <br/></>联 系 人：${supplier.supplierContactname}<br /><br/>
               
                 电子邮件: <c:forEach var="email" items="${emailList}"><c:out value="${email}"/>&nbsp;&nbsp;</c:forEach><br /><br />   
       QQ 号码: <c:forEach var="qq" items="${qqList}"><c:out value="${qq}"/>&nbsp;&nbsp;</c:forEach><br /><br />        
              </div></td>
            </tr>
          </tbody>
        </table>
      </div>
      <!--基本信息结束-->
      <!--认证图片开始-->
      <!--认证图片结束-->
      <!--公司简介开始-->
      <div class="mod_comp mt8">
        <div class="mod_compT">公司简介</div>
        
        <div class="mod_compC" style="WORD-BREAK: break-all">
        <c:out value="${supplier.supplierDescription}"/>
        </div>
      </div>
      <!--公司简介结束-->
      <!--店铺实体图片开始-->
      <!--end of commonts-->

       <div class="mod_comp mt8">
        <div class="mod_compT">公司简介</div>
        
        <div class="mod_compC" style="WORD-BREAK: break-all">
        <c:out value="${supplier.supplierDescription}"/>
        </div>
      </div>
    </div>
   

    <!--右边-->
    <div class="Bl l">
      <!--左边-->
      <!--其他页商家信息开始-->
      <!--其他页商家信息结束-->
<div class="mod_div">
        <div class="mod">
          <div class="modT"><c:out value="${supplier.supplierName}"/></div>
          <table style="MARGIN: 0px auto" cellspacing="0" cellpadding="0" width="166" 
align="center" border="0">
            <tbody>
              <tr>
                <td height="10"></td>
              </tr>
              <tr>
                <td class="liuyan_box" valign="center" align="middle"><a 
      onclick="document.getElementById('content').focus();" 
      href="javascript:void(0)"><img alt="给我留言" 
      src="${ctx}/images/common/ly.gif" /></a> <img alt="当前在线" 
      src="${ctx}/images/common/online.gif" 
      align="absmiddle" /><br></td>
              </tr>
              <tr>
                <td><div class="hui912 l_space">访问次数：<c:out value="${supplier.supplierAccess}" /></div>
                    
                  <br clear="all" />
                  <div class="hui912 l_space"><a href="javascript:showCommentForm();">快速评价</a></a></div><br>
                  
                  <div class="hui912 l_space">评价数量：0</div><br>
                  
                  <div class="hui912 l_space">实名认证:
                  <c:choose>
                  	<c:when test="${empty supplier.supplierCertify }">否</c:when>
                  	<c:otherwise>
                  		<a href="${ctx}/supplier/getImage1?id=${supplier.supplierId}" target="_blank">是</a>
                  	</c:otherwise>
                  </c:choose>
                  </div><br>
                  
                  <div class="hui912 l_space">资质认证:
                  <c:choose>
                  	<c:when test="${empty supplier.supplierQualify }">否</c:when>
                  	<c:otherwise><a href="${ctx}/supplier/getImage2?id=${supplier.supplierId}" target="_blank">是</a></c:otherwise>
                  </c:choose>
                  </div>
                  
                  
                  <div class="info_r"></div>
                  <br 
      clear="all" />
                  <div class="hui912 l_space">信誉等级：</div>
                  <div class="info_r"><a title="点击查看信誉等级来源" 
      href="http://dealer.zol.com.cn/d_29835/appraise.html" target="_blank"><A 
      title=3钻商家 href="http://dealer.zol.com.cn/d_29835/appraise.html" 
      target=_blank><img height="16" 
      src="${ctx}/images/common/d1.gif" width="16" 
      border="0" /><img height="16" 
      src="${ctx}/images/common/d1.gif" width="16" 
      border="0" /><img height="16" 
      src="${ctx}/images/common/d1.gif" width="16" 
      border="0" /><img height="16" 
      src="欣龙海天渠道专营 - 公司简介 【联系电话010-62682632】-ZOL经销商_files/star.gif" width="16" 
      border="0" /><img height="16" 
      src="欣龙海天渠道专营 - 公司简介 【联系电话010-62682632】-ZOL经销商_files/star.gif" width="16" 
      border="0" /></a></div>
                  <br clear="all" />
                  
                  <br clear="all" />
                  <div class="hui912 l_space">在线联系：</div>
                  <div class="info_r">
                 <c:forEach var="qq" items="${qqList}">
                 <a 
      href="http://wpa.qq.com/msgrd?V=1&Uin=<c:out value='${qq}'/>Site=商讯网&Menu=yes" 
      target="blank"><img id="qq_2" height="16" alt="点击这里给我发消息" src="http://wpa.qq.com/pa?p=1:<c:out value='${qq}'/>:4" align="absmiddle" 
      border="no" />(客服)</a>
                 </c:forEach>
                  </div></td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
      
      <!--左边-->
    </div>
    <br class="c" />
  </div>
</div>

</body>
</html>
