<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Index</title>
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
    <span class="leftLink">注册 | 忘记密码</span> <span class="rightLink">帮助 | 设为首页</span> </div>
  <div class="logo"></div>
</div>
<div class="redLine"></div>
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
      class="comp">欣龙海天渠道专营</span> <img alt="当前在线" 
      src="${ctx}/images/common/online.gif" 
      align="absmiddle" /> <br />
                      <div 
      style="MARGIN: 0px 0px 8px; OVERFLOW: hidden; WIDTH: 100%; BORDER-BOTTOM: #ccc 1px dotted; HEIGHT: 8px"></div>
                主营业务：<a 
      href="http://dealer.zol.com.cn/d_29835/pro_list_16.html">笔记本电脑</a> <a 
      href="http://dealer.zol.com.cn/d_29835/pro_list_27.html">PC电脑</a> <a 
      href="http://dealer.zol.com.cn/d_29835/pro_list_320.html">笔记本电池</a> <a 
      href="http://dealer.zol.com.cn/d_29835/pro_list_346.html">笔记本配件</a> <br />
                信誉等级：<a title="3钻商家" 
      href="http://dealer.zol.com.cn/d_29835/appraise.html" target="_blank"><img 
      height="16" src="${ctx}/images/common/d1.gif" 
      width="16" border="0" /><img height="16" 
      src="${ctx}/images/common/d1.gif" width="16" 
      border="0" /><img height="16" 
      src="${ctx}/images/common/d1.gif" width="16" 
      border="0" /><img height="16" 
      src="${ctx}/images/common/star.gif" width="16" 
      border="0" /><img height="16" 
      src="${ctx}/images/common/star.gif" width="16" 
      border="0" /></a><br />
                信誉评价：<a 
      href="http://dealer.zol.com.cn/d_29835/appraise.html#user_comment">共5条</a><br />
                所在地区：北京海淀区<br />
                创店时间：2006-06-29<br />
                联系电话：010-62682632&nbsp; 
                62682679&nbsp; <br />
                手机号码：13426438152<br />
                <span 
      style="DISPLAY: inline-block; FLOAT: left">店铺地址：</span><span 
      style="DISPLAY: inline-block; FLOAT: left">北京海淀中关村E世界财富中心C座10层1070(买家请从E世界C座进门左侧乘坐双数电梯直达10层经过长廊右转即到)</span><br 
      clear="all" />
                联 系 人：正品直销中心<br />
                在线联系： <a 
      href="tencent://Message/?Uin=156014986&amp;websiteName=dealer.zol.com.cn&amp;Menu=yes" 
      target="blank"><img id="qq_1" height="16" alt="点击这里给我发消息" src="" align="absmiddle" 
      border="no" />(客服)</a> <a 
      href="tencent://Message/?Uin=858968998&amp;websiteName=dealer.zol.com.cn&amp;Menu=yes" 
      target="blank"><img id="qq_1" height="16" alt="点击这里给我发消息" src="" align="absmiddle" 
      border="no" />(客服)</a> <a 
      href="tencent://Message/?Uin=1186966783&amp;websiteName=dealer.zol.com.cn&amp;Menu=yes" 
      target="blank"><img id="qq_1" height="16" alt="点击这里给我发消息" src="" align="absmiddle" 
      border="no" />(客服)</a> <br />
                公司网址：<a href="http://dealer.zol.com.cn/d_29835/" 
      target="_blank">http://dealer.zol.com.cn/d_29835/</a><br />
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
        <div class="mod_compC" style="WORD-BREAK: break-all">北京欣龙海天科技发展中心简介<br />
          北京欣龙海天科技发展中心（以下简称欣龙海天）位于北京高科技核心区—中关村，是一个集销售、维修及服务于一体的高科技企业集团。<br />
          公司定位：为企业提供完整的解决方案<br />
          公司主要优势：<br />
          <br />
          &nbsp;&nbsp;&nbsp;&nbsp;1．丰富的客户经验<br />
          <br />
          &nbsp;&nbsp;&nbsp;&nbsp;几年来，欣龙海天在逐步的摸索中，积累出丰富的客户经验。公司的技术服务贯穿“想客户所想，做客户所需，客户想到的我们要想到，客户没有想到的我们也要想到”这一宗旨。完善的售后服务为我们培养了一个日益壮大客户体系。<br />
          <br />
          &nbsp;&nbsp;&nbsp;&nbsp;2．雄厚的技术实力<br />
          <br />
          &nbsp;&nbsp;&nbsp;&nbsp;欣龙海天公司不但有完善的售后服务体系，同时也具备了雄厚的技术实力。公司现有多名服务器及网络产品全球专业认证工程师，为全国超过近万名用户提供了全方位售后服务，充份弥补了厂家在售后灵活性与实际操作经验方面的不足，获得良好的信誉和支持。同时，为适应信息时代的高速发展，工程师定期接受培训或专业性学习。优秀的技术工程师、全面到位的服务体系为公司赢得了固定的大客户群体，并在此基础上扩散发展。<br />
          <br />
          &nbsp;&nbsp;&nbsp;&nbsp;3．独树一帜的客户服务体系<br />
          <br />
          &nbsp;&nbsp;&nbsp;欣龙海天公司把产品销售与售后服务合理的加以结合，并向客户公开承诺“五心级服务”：对客户的需求实行&nbsp;“买的放心”“用的安心”“服务耐心”“工作专心”“售后热心”，得到了客户的一致好评。<br />
          <br />
          &nbsp;&nbsp;&nbsp;&nbsp;4．最优的价格<br />
          <br />
          &nbsp;&nbsp;&nbsp;&nbsp;作为IBM、DELL、HP、SUN、CISCO、华为-3COM、华硕等产品的优秀核心经销商。欣龙海天公司在保证产品质量的同时也给您最具竟争力的价格。<br />
          <br />
          &nbsp;&nbsp;&nbsp;<br />
          公司业务范围：<br />
          <br />
          &nbsp;&nbsp;&nbsp;.&nbsp;各品牌笔记本、台式机、服务器、工作站、小型机、网络产品、存储设备等硬件产品的销售及综合服务<br />
          &nbsp;&nbsp;&nbsp;.&nbsp;计算机辅助管理信息系统<br />
          &nbsp;&nbsp;&nbsp;.&nbsp;大中小型集成项目的方案设计及实施<br />
          &nbsp;&nbsp;&nbsp;. 大中小型广域网和局域网的系统集成<br />
          &nbsp;&nbsp;&nbsp;&nbsp;?&nbsp;IT外包综合服务<br />
          公司主要代理品牌：<br />
          <br />
          &nbsp;&nbsp;&nbsp;&nbsp;IBM&nbsp;DELL&nbsp;HP&nbsp;SUN&nbsp;Cisco&nbsp;华为-3Com、华硕<br />
          <br />
          公司发展进程：<br />
          <br />
          &nbsp;&nbsp;欣龙海天科技公司成立于2001年，经过5年来的高速发展，公司已从一个优秀的产品代理分销商发展成为一个以产品代理和分销为先导，针对用户的具体需求和具体应用，提供全面解决方案的系统集成商系为用户提供网络方案的设计、实施及网络维护全方位的服务。<br />
          <br />
          &nbsp;&nbsp;&nbsp;&nbsp;随着计算机市场在国内的迅速发展，欣龙海天公司紧跟用户发展需求，在从事计算机销售和服务的过程中确立了“以市场为中心,以客户的需求为导向”的经营宗旨，在不断追踪世界计算机领域最新技术及产品的同时，针对用户的具体需求和应用，为客户提供优质高效的服务。<br />
          <br />
          &nbsp;&nbsp;&nbsp;&nbsp;现在，公司主要代理的产品有笔记本、台式机、服务器、工作站、小型机、存储设备及网络产品，包括IBM、DELL、联想、SUN、CISCO、华为-3COM、NETSCREEN华硕等诸多品牌。此外，欣龙海天科技与IBM公司，CISCO公司，HP公司，微软公司，CA公司紧密配合先后推出几十套解决方案，满足客户的不同需求。<br />
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欣龙海天致力于为客户提供对以上产品的售前、售中及售后的全方位的服务，并以良好的信誉和全面的技术支持向各界用户提供科学有效的产品解决方案。&nbsp;<br />
          <br />
          公司业绩：<br />
          <br />
          &nbsp;欣龙海天科技公司团结共进，能迅速崛起于中关村的原因，不能不归结于我公司以客户利益为先导，为客户提供完善的销售服务体系的敬业工作而来的。几年来，欣龙海天公司的客户服务体系涉及社会的新闻媒体、国家机关、社会组织、科研机构、大型国企、金融、医药、外企、军队等各个领域，并逐渐的发展壮大。<br />
          公司在2002年专门成立了客户部，进一步扩大与政府采购的合作，加强与一些大型的企事业单位的信息系统工程建设，细化产品供应，技术支持和服务以及物流派送等工作，更好的为客户提供更完善，更贴心的服务。<br />
          <br />
          公司的部分行业客户：<br />
          中国科学院&nbsp;航天部&nbsp;农业部&nbsp;交通部&nbsp;铁道部&nbsp;教育部&nbsp;财政部&nbsp;水利部&nbsp;科技部&nbsp;信息产业部&nbsp;国土资源部&nbsp;国家发改委&nbsp;国家林业局&nbsp;国家体育总局&nbsp;国家工商总局&nbsp;国家统计局&nbsp;国家邮政局&nbsp;中国气象局&nbsp;国务院港澳办&nbsp;中国人民银行<br />
          中央电视台&nbsp;北京电视台&nbsp;人民日报社&nbsp;新华社&nbsp;中国电子报（赛迪）<br />
          总参谋部&nbsp;总政治部&nbsp;总后勤部&nbsp;总装备部&nbsp;海军司令部&nbsp;空军司令部&nbsp;第二炮兵&nbsp;武警总队&nbsp;北京军区&nbsp;国防大学&nbsp;军事科学院<br />
          清华大学&nbsp;北京大学&nbsp;中国农业大学&nbsp;中国政法大学&nbsp;中国林业大学&nbsp;北京理工大学&nbsp;北京航空航天大学&nbsp;北京邮电大学&nbsp;首都经贸大学&nbsp;北京师范大学&nbsp;北京电影学院<br />
          索尼-爱立信&nbsp;摩托罗拉&nbsp;诺基亚&nbsp;松下电器&nbsp;爱普生&nbsp;西门子&nbsp;GAC集团&nbsp;LG集团&nbsp;SK集团&nbsp;<br />
          中国电子&nbsp;中国石化&nbsp;中国网通&nbsp;中国煤碳&nbsp;中国兵器&nbsp;中国普天集团&nbsp;五矿集团&nbsp;中软网络&nbsp;太极集团&nbsp;大唐电信&nbsp;许继集团<br />
          &nbsp;&nbsp;&nbsp;北京欣龙海天愿与贵单位携手合作，共创美好未来！<br />
          <br />
          北京欣龙海天科技有限公司<br />
          地址：北京市中关村E世界C1070<br />
          联系人：乔坤&nbsp;&nbsp;MSN：guojialixing@hotmail.com&nbsp;&nbsp;<br />
          电话：82539089</div>
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
          <div class="modT">欣龙海天渠道专营</div>
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
                <td><div class="hui912 l_space">主营业务：</div>
                    <div class="info_r"><a 
      href="http://dealer.zol.com.cn/d_29835/pro_list_16.html" 
      target="_blank">笔记本电脑</a> <a 
      href="http://dealer.zol.com.cn/d_29835/pro_list_27.html" 
      target="_blank">PC电脑</a> <a 
      href="http://dealer.zol.com.cn/d_29835/pro_list_320.html" 
      target="_blank">笔记本电池</a> <a 
      href="http://dealer.zol.com.cn/d_29835/pro_list_346.html" 
      target="_blank">笔记本配件</a> </div>
                  <br clear="all" />
                  <div class="hui912 l_space">商品数量：</div>
                  <div class="info_r"><a 
      href="http://dealer.zol.com.cn/d_29835/pro_list.html">1189</a></div>
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
                  <div class="hui912 l_space">联系电话：</div>
                  <div class="info_r">010-62682632<br clear="all" />
                    62682679<br 
      clear="all" />
                    </div>
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
