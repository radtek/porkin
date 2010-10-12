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
<script src="${ctx}/scripts/Calendar.js"></script>
<script src="${ctx}/scripts/menu.js"></script>
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
function whenDelete() {
	var isDelete=true;
	if (!confirm("sure to delete")) {
		isDelete=false;
	}
	window.location = 'contractSearch.html'; 
	return isDelete;
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
                    <td class="Al_11" height="120"><img 
            src="${ctx}/images/876444.jpg" /></td>
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
      align="absmiddle" /></td>
              </tr>
              <tr>
                <td><div class="hui912 l_space">访问次数：<c:out value="${supplier.supplierAccess}" /></div>
                    
                  <br clear="all" />
                  <div class="hui912 l_space">评价数量：0</div>
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
                  <div class="info_r"><a 
      href="tencent://Message/?Uin=156014986&amp;websiteName=dealer.zol.com.cn&amp;Menu=yes" 
      target="blank"><img id="qq_2" height="16" alt="点击这里给我发消息" src="" align="absmiddle" 
      border="no" />(客服)</a> <a 
      href="tencent://Message/?Uin=858968998&amp;websiteName=dealer.zol.com.cn&amp;Menu=yes" 
      target="blank"><img id="qq_2" height="16" alt="点击这里给我发消息" src="" align="absmiddle" 
      border="no" />(客服)</a> <a 
      href="tencent://Message/?Uin=1186966783&amp;websiteName=dealer.zol.com.cn&amp;Menu=yes" 
      target="blank"><img id="qq_2" height="16" alt="点击这里给我发消息" src="" align="absmiddle" 
      border="no" />(客服)</a> </div></td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
      <script 
src="欣龙海天渠道专营 - 公司简介 【联系电话010-62682632】-ZOL经销商_files/apis.3&amp;key=2b47e646a5516a06c020ab8ca2bdcc09cda2ab682454a45c12693093464b8d7fc0af7de167e3a1df" 
type="text/javascript"></script>
      <script type="text/javascript">
	var mapoption = new MMapOptions();//构造地图参数选项对象
	mapoption.zoom=13;//设置地图zoom级别
	mapoption.center=new MLngLat('JIOMSLLOKNDLLH','LQGXXLPNMLLLD');//设置要加载的地图的中心点坐标
	mapoption.toolbar=ROUND;//设置地图初始化工具条
	mapoption.toolbarPos=new MPoint(10,20);//工具条在地图上的显示位置
	mapoption.returnCoordType=COORD_TYPE_OFFSET;//返回坐标类型
	mapoption.isCongruence = true; 		//叠加覆盖层
	mapoption.overviewMap=HIDE;		//隐藏鹰眼	 
	mapoption.fullScreenButton=HIDE; 	//隐藏全屏按钮
	mapoption.mapComButton=HIDE;		//设置新增商户按钮隐藏
	mapoption.centerCross=HIDE;		//去中心十字		
	var mapObj = new MMap("mapObj",mapoption);
	mapObj.setCtrlPanelState(TOOLBAR_CTRL,HIDE);//去除工具条
	mapObj.addEventListener(mapObj,MAP_READY,ready);//事件处理函数
	function ready(param){
		//mt = new MMapTools(mapObj);
		//mt.addSpecialLayer();	//在地图上添加专题地图
		addMarker();
	}
	function addMarker()
	{
		var markerOption = new MMarkerOptions();//此类的实例用于类 MMarker 的构造函数的option参数中
		var tipOption = new MTipOptions();//提示窗口选项对象，此对象服务于MMarker、MPlyline、MArea等对象
		var mlineStyle=new MLineStyle();
		mlineStyle.thickness=0;
		mlineStyle.alpha=1;
		mlineStyle.lineType=LINE_DASHED;
		tipOption.tipType=mlineStyle;//tip显示类型
		tipOption.title="经销商：<font color='#ff0000'>欣龙海天渠道专营</font><br>";
		tipOption.content =" <br>联系人：正品直销中心";
		tipOption.content +=" <br>地&nbsp;&nbsp;址：北京海淀中关村E世界<br>";

		markerOption.tipOption = tipOption;
		markerOption.imageUrl="http://api.mapabc.com/fmp/v1.0/components/point/DynamicPoint/1.png";
		Mmarker = new MMarker(mapObj.getCenter(),markerOption);//标注地图上点的位置
		Mmarker.id="mark";
		mapObj.addEventListener(mapObj,ADD_OVERLAY,addoverlay);
		mapObj.addOverlay(Mmarker,true);
	}
	function addoverlay()
	{
		mapObj.openOverlayTip("mark");
	}
	</script>
      <!--左边-->
    </div>
    <br class="c" />
  </div>
</div>
</body>
</html>
