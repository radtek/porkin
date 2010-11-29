function setProvinceSelect(provinceId) {
	$.ajax({
		url:"../city/getProvinceList",
		dataType:"html",
		type: "GET",
		success: function(data) {
			$('select[name="provinceId"]').empty().append(data).val(provinceId);
		},
		error:function(err) {
			$.messager.alert('消息',err,'error');
		}
	});
}

// edit event
function formSubmit(actionUrl) {
	// validate
	$('#cityForm').ajaxForm({ 
		url: actionUrl,
		beforeSubmit: validate, 
		dataType:  'json', 
        success:   processJson 
    }); 
}
// call back
function processJson(data) { 
    if (data.cityId == -1) {
    	$.messager.alert('消息','城市名称已存在，请重新操作！','warning');
    	return;
    }
    var optMsg = "新增成功！";
    if ($('input[name="cityId"]').val() > 0) {
    	optMsg = "更新成功！";
    }
    $.messager.show({
		title:'消息',
		msg:optMsg,
		timeout:optSuccessTime,
		showType:'slide'
	});
	$('#cityEdit').dialog('close');
    $('#cityList').datagrid('reload');
}
// validate method
function validate(formData, jqForm, options) {
	var queryString = $.param(formData);
	var form = jqForm[0]; 
	if (form.provinceId.value.length == 0) {
		$.messager.alert('消息','请选择省份！','info');
		form.provinceId.focus();
		return false;
	}
	if (form.cityName.value.length == 0) {
		$.messager.alert('消息','请输入城市中文名！','info');
		form.cityName.focus();
		return false;
	}
	if (form.cityAbbreviation.value.length == 0) {
		$.messager.alert('消息','请输入城市英文名！','info');
		form.cityAbbreviation.focus();
		return false;
	}
}
function onEditClickHandler(id) {
	$.get('../city/get', { id: id } ,function(data) {
		setProvinceSelect(data.provinceId);
		$('input[name="cityId"]').val(id);
		$('input[name="cityName"]').val(data.cityName);
		$('input[name="cityAbbreviation"]').val(data.cityAbbreviation);
		$('select[name="activeFlag"]').val(data.activeFlag);
		$('#cityEdit').css('display','block');
		$('#cityEdit').dialog({title:'修改', modal: true});
	});
	formSubmit('../city/update');
}

	
function onDeleteClickHandler(id) {
	$.messager.confirm('消息', '确认要删除该记录吗?', function(r){
		if (r){
			$.get('../city/delete', { id: id } ,function(data) {
				if (data == "success") {
				    $('#cityList').datagrid('reload');
				    $.messager.show({
						title:'消息',
						msg:'删除成功！',
						timeout:optSuccessTime,
						showType:'slide'
					});
				} else if (data == "reference") {
					$.messager.alert('消息','有商家关联此城市，暂时无法删除！','warning');
				} else {
					$.messager.alert('消息','删除失败！','error');
				}
			});
		}
	});
}

$(document).ready(function() {
	
});
// list
$(function(){
	setProvinceSelect();
	// edit
	var lastIndex;
	$('#cityList').datagrid({
		title:'城市维护',
		iconCls:'icon-edit',
		width:950,
		height:'auto',
		singleSelect:true,
		sortName: 'provinceName,cityName',
		sortOrder: 'asc,asc',
		remoteSort: false,
		idField:'cityId',
		method:'get',
		url:'../city/search',
		queryParams:{cityName:''},
		pagination:true,
		loadMsg:'数据加载中,请稍候...',
		columns:[[
			{field:'cityId',title:'编号',width:80,align:'center'},
			{field:'provinceName',title:'省份',width:100,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
			{field:'cityName',title:'城市名称',width:100,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
			{field:'cityAbbreviation',title:'英文名称',width:100,align:'center',sortable:true,
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
					return '<span><image onClick="onEditClickHandler(' + rec['cityId'] + ')" onmouseover="this.style.cursor=\'pointer\';" src="../images/datagrid/icon_list_edit.gif"/>&nbsp;&nbsp;<image onClick="onDeleteClickHandler(' + rec['cityId'] + ')" onmouseover="this.style.cursor=\'pointer\';" height="15" width="15" src="../images/datagrid/icon_list_delete.gif"/></span>';
				}
			}
		]],
		rownumbers:true,
		toolbar:[{
				id:'btnadd',
				text:'新增',
				iconCls:'icon-add',
				handler:function(){
					setProvinceSelect('');
					$('input[name="cityId"]').val('');
					$('select[name="provinceId"]').val('');
					$('input[name="cityName"]').val('');
					$('input[name="cityAbbreviation"]').val('');
					$('select[name="activeFlag"]').val('Y');
					$('#cityEdit').css('display','block');
					$('#cityEdit').dialog({title:'新增', modal: true, icon:'icon-add'});
					formSubmit('../city/create');
				}
		}],
		onBeforeLoad:function(){
			$(this).datagrid('rejectChanges');
		},
		onLoadSuccess:function() {
			
		}
	});
	
	$('#cityList').datagrid('getPager').pagination({
		displayMsg:'显示 {from} 至 {to} 条  共 {total} 条记录',
		afterPageText:'/{pages}',
		beforePageText:'页'
	});
});