// edit event
function formSubmit(actionUrl) {
	// validate
	$('#countryForm').ajaxForm({ 
		url: actionUrl,
		beforeSubmit: validate, 
		dataType:  'json', 
        success:   processJson 
    }); 
}
// call back
function processJson(data) { 
    if (data.countryId == -1) {
    	$.messager.alert('消息','国家名已存在，请重新操作！','warning');
    	return;
    }
    var optMsg = "新增成功！";
    if ($('input[name="countryId"]').val() > 0) {
    	optMsg = "更新成功！";
    }
    $.messager.show({
		title:'消息',
		msg:optMsg,
		timeout:optSuccessTime,
		showType:'slide'
	});
	$('#countryEdit').dialog('close');
    $('#countryList').datagrid('reload');
}
// validate method
function validate(formData, jqForm, options) {
	var queryString = $.param(formData);
	var form = jqForm[0]; 
	if (form.countryName.value.length == 0) {
		$.messager.alert('消息','请输入国家名称！','info');
		form.countryName.focus();
		return false;
	}
	if (form.countryAbbreviation.value.length == 0) {
		$.messager.alert('消息','请输入国家缩写！','info');
		form.countryAbbreviation.focus();
		return false;
	}
}
function onEditClickHandler(id) {
	$.get('../country/get', { id: id } ,function(data) {
		$('input[name="countryId"]').val(id);
		$('input[name="countryName"]').val(data.countryName);
		$('input[name="countryAbbreviation"]').val(data.countryAbbreviation);
		$('select[name="activeFlag"]').val(data.activeFlag);
		$('#countryEdit').css('display','block');
		$('#countryEdit').dialog({title:'修改', modal: true});
	});
	formSubmit('../country/update');
}

function onDeleteClickHandler(id) {
	$.messager.confirm('消息', '确认要删除该记录吗?', function(r){
		if (r){
			$.get('../country/delete', { id: id } ,function(data) {
				if (data == "success") {
				    $('#countryList').datagrid('reload');
				    $.messager.show({
						title:'消息',
						msg:'删除成功！',
						timeout:optSuccessTime,
						showType:'slide'
					});
				} else if (data == "reference") {
					$.messager.alert('消息','有品牌关联此国家，暂时无法删除！','warning');
				} else {
					$.messager.alert('消息','删除失败！','error');
				}
			});
		}
	});
}
// list
$(function(){
	// edit
	var lastIndex;
	$('#countryList').datagrid({
		title:'国家维护',
		iconCls:'icon-edit',
		width:850,
		height:'auto',
		singleSelect:true,
		sortName: 'countryName',
		sortOrder: 'asc',
		remoteSort: false,
		idField:'countryId',
		method:'get',
		url:'../country/search',
		queryParams:{countryName:''},
		pagination:true,
		loadMsg:'数据加载中,请稍候...',
		columns:[[
			{field:'countryId',title:'编号',width:80,align:'center'},
			{field:'countryName',title:'国家名称',width:100,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
			{field:'countryAbbreviation',title:'缩写',width:100,align:'center',sortable:true,
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
			{field:'createdBy',title:'创建人',width:100,align:'center',sortable:true,
				sorter:function(a,b,order){
				return (a>b?1:-1)*(order=='asc'?1:-1);
			}},
			{field:'createdDate',title:'创建时间',width:130	,align:'center',sortable:true,
					sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
			{field:'opt',title:'操作',width:100,align:'center',
				formatter:function(value,rec){
					return '<span><image onClick="onEditClickHandler(' + rec['countryId'] + ')" onmouseover="this.style.cursor=\'pointer\';" src="../images/datagrid/icon_list_edit.gif"/>&nbsp;&nbsp;<image onClick="onDeleteClickHandler(' + rec['countryId'] + ')" onmouseover="this.style.cursor=\'pointer\';" height="15" width="15" src="../images/datagrid/icon_list_delete.gif"/></span>';
				}
			}
		]],
		rownumbers:true,
		toolbar:[{
				id:'btnadd',
				text:'新增',
				iconCls:'icon-add',
				handler:function(){
					$('input[name="countryId"]').val('');
					$('input[name="countryName"]').val('');
					$('input[name="countryAbbreviation"]').val('');
					$('select[name="activeFlag"]').val('Y');
					$('#countryEdit').css('display','block');
					$('#countryEdit').dialog({title:'新增', modal: true, icon:'icon-add'});
					formSubmit('../country/create');
				}
		}],
		onBeforeLoad:function(){
			$(this).datagrid('rejectChanges');
		},
		onLoadSuccess:function() {
			
		}
	});
	
	$('#countryList').datagrid('getPager').pagination({
		displayMsg:'显示 {from} 至 {to} 条  共 {total} 条记录',
		afterPageText:'/{pages}',
		beforePageText:'页'
	});
	
});

