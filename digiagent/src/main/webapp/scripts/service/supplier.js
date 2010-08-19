function setProvinceSelect(provinceId, cityId) {
	$.ajax({
		url:"../supplier/getProvinceList",
		dataType:"html",
		type: "GET",
		success: function(data) {
			$('select[name="provinceId"]').empty().append(data).val(provinceId);
			if (cityId > 0) {
				setCitySelect(cityId);
			}
		},
		error:function(err) {
			alert(err);
		}
	});
}

function setCitySelect(cityId) {
	$.ajax({
		url:"../supplier/getCityList",
	    data: "id=" + $('select[name="provinceId"]').val(),
		dataType:"html",
		type: "GET",
		success: function(data) {
			$('select[name="cityId"]').empty().append(data).val(cityId);
		},
		error:function(err) {
			alert(err);
		}
	});
}

// edit event
function formSubmit(actionUrl) {
	// validate
	$('#supplierForm').ajaxForm({ 
		url: actionUrl,
		beforeSubmit: validate, 
		dataType:  'json', 
        success:   processJson 
    }); 
}
// call back
function processJson(data) { 
    if (data.supplierId == -1) {
    	alert("商家名称已存在，请重新操作！");
    	return;
    }
	$('#supplierEdit').dialog('close');
    $('#supplierList').datagrid('reload');
}
// validate method
function validate(formData, jqForm, options) {
	var queryString = $.param(formData);
	var form = jqForm[0]; 
	if (form.provinceId.value.length == 0) {
		alert('请选择省份！');
		form.provinceId.focus();
		return false;
	}
	if (form.cityId.value.length == 0) {
		alert('请选择城市！');
		form.cityId.focus();
		return false;
	}
	if (form.supplierName.value.length == 0) {
		alert('请输入商家中文名！');
		form.supplierName.focus();
		return false;
	}
}
function onEditClickHandler(id) {
	$.get('../supplier/get', { id: id } ,function(data) {
		$('input[name="supplierId"]').val(id);
		setProvinceByCityId(data.cityId);
		setCitySelect(data.cityId);
		$('input[name="supplierName"]').val(data.supplierName);
		$('select[name="activeFlag"]').val(data.activeFlag);
		$('#supplierEdit').css('display','block');
		$('#supplierEdit').dialog({title:'Edit', modal: true});
	});
	formSubmit('../supplier/update');
}

function setProvinceByCityId(cityId) {
	$.get('../city/get', { id: cityId } ,function(data) {
		setProvinceSelect(data.provinceId, cityId);
	});
}

	
function onDeleteClickHandler(id) {
	if (confirm("确定要删除该记录吗？")) {
		$.get('../supplier/delete', { id: id } ,function(data) {
			if (data == "success") {
			    $('#supplierList').datagrid('reload');
				alert('删除成功！');
			}
		});
	}
}

$(document).ready(function() {
	$('select[name="provinceId"]').bind('change', setCitySelect);
});
// list
$(function(){
	setProvinceSelect('', -1);
	// edit
	var lastIndex;
	$('#supplierList').datagrid({
		title:'商家维护',
		iconCls:'icon-edit',
		width:950,
		height:'auto',
		singleSelect:true,
		sortName: 'provinceName,cityName,supplierName',
		sortOrder: 'asc,asc,asc',
		remoteSort: false,
		idField:'supplierId',
		method:'get',
		url:'../supplier/search',
		queryParams:{supplierName:''},
		pagination:true,
		loadMsg:'数据加载中,请稍候...',
		columns:[[
			{field:'supplierId',title:'编号',width:80,align:'center'},
			{field:'provinceName',title:'省份',width:100,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
			{field:'cityName',title:'城市',width:100,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
			{field:'supplierName',title:'商家名称',width:100,align:'center',sortable:true,
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
					return '<span><image onClick="onEditClickHandler(' + rec['supplierId'] + ')" onmouseover="this.style.cursor=\'pointer\';" src="../images/datagrid/icon_list_edit.gif"/>&nbsp;&nbsp;<image onClick="onDeleteClickHandler(' + rec['supplierId'] + ')" onmouseover="this.style.cursor=\'pointer\';" height="15" width="15" src="../images/datagrid/icon_list_delete.gif"/></span>';
				}
			}
		]],
		rownumbers:true,
		toolbar:[{
				id:'btnadd',
				text:'新增',
				iconCls:'icon-add',
				handler:function(){
					// set province list
//			$('<option value=1>11</option><option value=2>22</option>').appendTo($('select[name="provinceId"]'));
					$('input[name="supplierId"]').val('');
					$('select[name="provinceId"]').val('');
					setProvinceSelect('', -1);
					setCitySelect('');
//					$('select[name="provinceId"]').val('');
//					$('select[name="cityId"]').val('');
					$('input[name="supplierName"]').val('');
					$('select[name="activeFlag"]').val('Y');
					$('#supplierEdit').css('display','block');
					$('#supplierEdit').dialog({title:'Add', modal: true, icon:'icon-add'});
					formSubmit('../supplier/create');
				}
		}],
		onBeforeLoad:function(){
			$(this).datagrid('rejectChanges');
		},
		onLoadSuccess:function() {
			
		}
	});
	
	$('#supplierList').datagrid('getPager').pagination({
		displayMsg:'显示 {from} 至 {to} 条  共 {total} 条记录',
		afterPageText:'/{pages}',
		beforePageText:'页'
	});
});