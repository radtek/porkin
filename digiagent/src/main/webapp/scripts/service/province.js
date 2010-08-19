// edit event
function formSubmit(actionUrl) {
	// validate
	$('#provinceForm').ajaxForm({ 
		url: actionUrl,
		beforeSubmit: validate, 
		dataType:  'json', 
        success:   processJson 
    }); 
}
// call back
function processJson(data) { 
    if (data.provinceId == -1) {
    	alert("省份名已存在，请重新操作！");
    	return;
    }
	$('#provinceEdit').dialog('close');
    $('#provinceList').datagrid('reload');
}
// validate method
function validate(formData, jqForm, options) {
	var queryString = $.param(formData);
	var form = jqForm[0]; 
	if (form.provinceName.value.length == 0) {
		alert('请输入省份名称！');
		form.provinceName.focus();
		return false;
	}
	if (form.provinceAbbreviation.value.length == 0) {
		alert('请输入省份缩写！');
		form.provinceAbbreviation.focus();
		return false;
	}
}
function onEditClickHandler(id) {
	$.get('../province/get', { id: id } ,function(data) {
		$('input[name="provinceId"]').val(id);
		$('input[name="provinceName"]').val(data.provinceName);
		$('input[name="provinceAbbreviation"]').val(data.provinceAbbreviation);
		$('select[name="activeFlag"]').val(data.activeFlag);
		$('#provinceEdit').css('display','block');
		$('#provinceEdit').dialog({title:'Edit', modal: true});
	});
	formSubmit('../province/update');
}

function onDeleteClickHandler(id) {
	if (confirm("确定要删除该记录吗？")) {
		$.get('../province/delete', { id: id } ,function(data) {
			if (data == "success") {
			    $('#provinceList').datagrid('reload');
				alert('删除成功！');
			} else if (data == "reference") {
				alert('有城市关联此省份，暂时无法删除！');
			} else {
				alert('删除失败！');
			}
		});
	}
}
// list
$(function(){
	// edit
	var lastIndex;
	$('#provinceList').datagrid({
		title:'省份维护',
		iconCls:'icon-edit',
		width:850,
		height:'auto',
		singleSelect:true,
		sortName: 'provinceName',
		sortOrder: 'asc',
		remoteSort: false,
		idField:'provinceId',
		method:'get',
		url:'../province/search',
		queryParams:{provinceName:''},
		pagination:true,
		loadMsg:'数据加载中,请稍候...',
		columns:[[
			{field:'provinceId',title:'编号',width:80,align:'center'},
			{field:'provinceName',title:'省份名称',width:100,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
			{field:'provinceAbbreviation',title:'缩写',width:100,align:'center',sortable:true,
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
				},
				formatter: function(value,rec){
					return format_cn(value);
				}
			},
			{field:'opt',title:'操作',width:100,align:'center',
				formatter:function(value,rec){
					return '<span><image onClick="onEditClickHandler(' + rec['provinceId'] + ')" onmouseover="this.style.cursor=\'pointer\';" src="../images/datagrid/icon_list_edit.gif"/>&nbsp;&nbsp;<image onClick="onDeleteClickHandler(' + rec['provinceId'] + ')" onmouseover="this.style.cursor=\'pointer\';" height="15" width="15" src="../images/datagrid/icon_list_delete.gif"/></span>';
				}
			}
		]],
		rownumbers:true,
		toolbar:[{
				id:'btnadd',
				text:'新增',
				iconCls:'icon-add',
				handler:function(){
					$('input[name="provinceId"]').val('');
					$('input[name="provinceName"]').val('');
					$('input[name="provinceAbbreviation"]').val('');
					$('select[name="activeFlag"]').val('Y');
					$('#provinceEdit').css('display','block');
					$('#provinceEdit').dialog({title:'Add', modal: true, icon:'icon-add'});
					formSubmit('../province/create');
				}
		}],
		onBeforeLoad:function(){
			$(this).datagrid('rejectChanges');
		},
		onLoadSuccess:function() {
			
		}
	});
	
	$('#provinceList').datagrid('getPager').pagination({
		displayMsg:'显示 {from} 至 {to} 条  共 {total} 条记录',
		afterPageText:'/{pages}',
		beforePageText:'页'
	});
	
});

