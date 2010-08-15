﻿// edit event
function formSubmit(actionUrl) {
	// validate
	$('#caetgoryForm').ajaxForm({ 
		url: actionUrl,
		beforeSubmit: validate, 
		dataType:  'json', 
        success:   processJson 
    }); 
}
// call back
function processJson(data) { 
    if (data.categoryId == -1) {
    	alert("类别名已存在，请重新操作！");
    	return;
    }
	$('#dd').dialog('close');
    $('#tt').datagrid('reload');
}
// validate method
function validate(formData, jqForm, options) {
	var queryString = $.param(formData);
	var form = jqForm[0]; 
	if (form.categoryName.value.length == 0) {
		alert('请输入类别名！');
		form.categoryName.focus();
		return false;
	}
}
function onEditClickHandler(id) {
	$.get('../category/get', { id: id } ,function(data) {
		$('input[name="categoryId"]').val(id);
		$('input[name="categoryName"]').val(data.categoryName);
		$('select[name="activeFlag"]').val(data.activeFlag);
		$('#dd').dialog({title:'Edit', modal: true});
	});
	formSubmit('../category/update');
}

function onDeleteClickHandler(id) {
	if (confirm("确定要删除该记录吗？")) {
		$.get('../category/delete', { id: id } ,function(data) {
			if (data == "success") {
			    $('#tt').datagrid('reload');
				alert('删除成功！');
			}
		});
	}
}
// list
$(function(){
	// edit
	$('#dd').dialog();
	$('#dd').dialog('close');
	var lastIndex;
	$('#tt').datagrid({
		title:'类别维护',
		iconCls:'icon-edit',
		width:650,
		height:'auto',
		singleSelect:true,
		sortName: 'categoryName',
		sortOrder: 'asc',
		remoteSort: false,
		idField:'categoryId',
		method:'get',
		url:'../category/search',
		queryParams:{skipResults:0, maxResults:10},
		pagination:true,
		loadMsg:'数据加载中,请稍候...',
		columns:[[
			{field:'categoryId',title:'编号',width:80,align:'center'},
			{field:'categoryName',title:'类别',width:100,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
			{field:'activeFlag',title:'状态',width:100,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				},
				formatter:function(value,rec){
					if (value == 'Y') {
						return '开启';
					} else {
						return '禁用';
					}
				}
			},
			{field:'opt',title:'操作',width:100,align:'center',
				formatter:function(value,rec){
					return '<span><image onClick="onEditClickHandler(' + rec['categoryId'] + ')" onmouseover="this.style.cursor=\'pointer\';" src="../images/datagrid/icon_list_edit.gif"/>&nbsp;&nbsp;<image onClick="onDeleteClickHandler(' + rec['categoryId'] + ')" onmouseover="this.style.cursor=\'pointer\';" height="15" width="15" src="../images/datagrid/icon_list_delete.gif"/></span>';
				}
			}
		]],
		rownumbers:true,
		toolbar:[{
				id:'btnadd',
				text:'新增',
				iconCls:'icon-add',
				handler:function(){
					$('input[name="categoryId"]').val('');
					$('input[name="categoryName"]').val('');
					$('select[name="activeFlag"]').val('Y');
					$('#dd').dialog({title:'Add', modal: true, icon:'icon-add'});
					formSubmit('../category/create');
				}
		}],
		onBeforeLoad:function(){
			$('#tt').datagrid('getPager').pagination({
				displayMsg:'显示 {from} 到 {to} 共 {total} 条',
				beforePageText:'页',
				afterPageText:'/{pages}',
				onSelectPage:function(pageNumber, pageSize){
					$(this).pagination('loading');
					$('#tt').datagrid({pageNumber:pageNumber, pageSize:pageSize, queryParams:{skipResults:(pageNumber-1) * pageSize, maxResults:pageSize}});
					$(this).pagination('loaded');
				}
			});
		}
	});
	
});