<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="common/common.jsp" %>
<html>
<head>
	<script type="text/javascript" src="scripts/service/admin.js"></script>
	<script>
		$(function() {
			$('#basic').tree({data:<%@include file="data/basic_data.json"%>});
			$('#report').tree({data:<%@include file="data/report_data.json"%>});
			$('#system').tree({data:<%@include file="data/system_data.json"%>});
			basicFunction();
		});
	</script>
	<style>
		.logoCenter{ width:75px; height:90px; background:url(images/common/centerLogo.gif) no-repeat; float:left;}
	</style>
</head>
<body class="easyui-layout">
		<div region="north" split="false" style="height:100px;padding:0px;">
			<div class="logoCenter"></div>
			<div style="text-align:right;padding:10px">
				<a href="javascript:window.opener=null;window.close();"><fmt:message key="label.common.logout"/></a>
			</div>
		</div>
		<div region="west" split="true" title="<fmt:message key='label.common.menu'/>" style="width:280px;padding1:1px;overflow:hidden;">
			<div id="menuAccordion" class="easyui-accordion" fit="true" border="false">
				<div title="<fmt:message key='label.common.basic'/>" style="overflow:auto;" selected="true">
					<ul id="basic" class="easyui-tree"></ul>
				</div>
				<div title="<fmt:message key='label.common.report'/>" style="padding:10px;">
					<ul id="report" class="easyui-tree"></ul>
				</div>
				<div title="<fmt:message key='label.common.system'/>">
					<ul id="system" class="easyui-tree"></ul>
				</div>
			</div>
		</div>
		<div region="center" title="<fmt:message key='label.common.content'/>" style="overflow:hidden;">
			<div id="mytab" class="easyui-tabs" fit="true" border="false">
				<div title="<fmt:message key='label.common.welcome'/>" style="padding:20px;overflow:hidden;"> 
					<div style="left:50%;top:50%;position:absolute;">
						<h1><fmt:message key='label.common.welcome'/></h1>
					</div>
				</div>
			</div>
		</div>
</body>
</html>