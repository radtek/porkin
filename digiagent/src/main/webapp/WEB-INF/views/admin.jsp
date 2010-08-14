<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
	<link rel="stylesheet" type="text/css" href="styles/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="styles/icon.css">
	<script type="text/javascript" src="scripts/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="scripts/jquery.easyui.min.js"></script>
	<script>		
		function addTab(title, url){
		    if ($('#mytab').tabs('exists', title)){
		        $('#mytab').tabs('select', title);
		    } else {
		        var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
		        $('#mytab').tabs('add',{
		            title:title,
		            content:content,
		            closable:true
		        });
		    }
		}
		
		$(document).ready(function() {
			$('#basic').tree({data:<%@include file="data/basic_data.json"%>});
			$('#report').tree({data:<%@include file="data/report_data.json"%>});
			$('#system').tree({data:<%@include file="data/system_data.json"%>});
			
			var map = $('#basic').find('.tree-title');
				$.each(map, function(key) {
						if ($(map[key]).text().toLowerCase() == '类别维护') {
							$(map[key]).click(function() {
								addTab($(this).text(), 'category/list');
							});
						}
						if ($(map[key]).text().toLowerCase() == '品牌维护') {
							$(map[key]).click(function() {
								addTab($(this).text(), 'vender.html');
							});
						}
						if ($(map[key]).text().toLowerCase() == '商家维护') {
							$(map[key]).click(function() {
								addTab($(this).text(), 'supplier.html');
							});
						}
				});
		});
	</script>
</head>
<body class="easyui-layout">
		<div region="north" title="Header" split="false" style="height:100px;padding:0px;">
			<div style="text-align:right;padding:10px">
				<a href="javascript:window.opener=null;window.close();">注销</a>
			</div>
		</div>
		<div region="south" title="Footer" split="false" style="height:100px;padding:10px;">
			
		</div>
		
		<div region="west" split="true" title="菜单" style="width:280px;padding1:1px;overflow:hidden;">
			<div class="easyui-accordion" fit="true" border="false">
				<div title="基础数据" style="overflow:auto;" selected="true">
					<ul id="basic" class="easyui-tree"></ul>
				</div>
				<div title="报表管理" style="padding:10px;">
					<ul id="report" class="easyui-tree"></ul>
				</div>
				<div title="系统设置">
					<ul id="system" class="easyui-tree"></ul>
				</div>
			</div>
		</div>
		<div region="center" title="内容" style="overflow:hidden;">
			<div id="mytab" class="easyui-tabs" fit="true" border="false">
				<div title="Welcome" style="padding:20px;overflow:hidden;"> 
					<div style="left:50%;top:50%;position:absolute;">
						<h1>Welcome</h1>
					</div>
				</div>
			</div>
		</div>
</body>
</html>