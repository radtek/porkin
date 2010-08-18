function setCountrySelect(countryId) {
	$.ajax({
		url:"../brand/getCountryList",
		dataType:"html",
		type: "GET",
		success: function(data) {
			$('select[name="countryId"]').empty().append(data).val(countryId);
		},
		error:function(err) {
			alert(err);
		}
	});
}

// edit event
function formSubmit(actionUrl) {
	// validate
	$('#brandForm').ajaxForm({ 
		url: actionUrl,
		beforeSubmit: validate, 
		dataType:  'json', 
        success:   processJson 
    }); 
}
// call back
function processJson(data) { 
    if (data.brandId == -1) {
    	alert("品牌名称已存在，请重新操作！");
    	return;
    }
	$('#brandEdit').dialog('close');
    $('#brandList').datagrid('reload');
}
// validate method
function validate(formData, jqForm, options) {
	var queryString = $.param(formData);
	var form = jqForm[0]; 
	if (form.countryId.value.length == 0) {
		alert('请选择国家！');
		form.countryId.focus();
		return false;
	}
	if (form.brandName.value.length == 0) {
		alert('请输入品牌中文名！');
		form.brandName.focus();
		return false;
	}
	if (form.brandEnglish.value.length == 0) {
		alert('请输入品牌英文名！');
		form.brandEnglish.focus();
		return false;
	}
}
function onEditClickHandler(id) {
	$.get('../brand/get', { id: id } ,function(data) {
		setCountrySelect(data.countryId);
		$('input[name="brandId"]').val(id);
		$('input[name="brandName"]').val(data.brandName);
		$('input[name="brandEnglish"]').val(data.brandEnglish);
		$('select[name="activeFlag"]').val(data.activeFlag);
		$('#brandEdit').css('display','block');
		$('#brandEdit').dialog({title:'Edit', modal: true});
	});
	formSubmit('../brand/update');
}

	
function onDeleteClickHandler(id) {
	if (confirm("确定要删除该记录吗？")) {
		$.get('../brand/delete', { id: id } ,function(data) {
			if (data == "success") {
			    $('#brandList').datagrid('reload');
				alert('删除成功！');
			}
		});
	}
}

$(document).ready(function() {
	
});
// list
$(function(){
	setCountrySelect();
	// edit
	var lastIndex;
	$('#brandList').datagrid({
		title:'品牌维护',
		iconCls:'icon-edit',
		width:950,
		height:'auto',
		singleSelect:true,
		sortName: 'countryName,brandName',
		sortOrder: 'asc,asc',
		remoteSort: false,
		idField:'brandId',
		method:'get',
		url:'../brand/search',
		queryParams:{brandName:''},
		pagination:true,
		loadMsg:'数据加载中,请稍候...',
		columns:[[
			{field:'brandId',title:'编号',width:80,align:'center'},
			{field:'countryName',title:'国家',width:100,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
			{field:'brandName',title:'品牌名称',width:100,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
			{field:'brandEnglish',title:'英文名称',width:100,align:'center',sortable:true,
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
					return '<span><image onClick="onEditClickHandler(' + rec['brandId'] + ')" onmouseover="this.style.cursor=\'pointer\';" src="../images/datagrid/icon_list_edit.gif"/>&nbsp;&nbsp;<image onClick="onDeleteClickHandler(' + rec['brandId'] + ')" onmouseover="this.style.cursor=\'pointer\';" height="15" width="15" src="../images/datagrid/icon_list_delete.gif"/></span>';
				}
			}
		]],
		rownumbers:true,
		toolbar:[{
				id:'btnadd',
				text:'新增',
				iconCls:'icon-add',
				handler:function(){
					// set country list
//			$('<option value=1>11</option><option value=2>22</option>').appendTo($('select[name="countryId"]'));
					setCountrySelect('');
					$('input[name="brandId"]').val('');
					$('select[name="countryId"]').val('');
					$('input[name="brandName"]').val('');
					$('input[name="brandEnglish"]').val('');
					$('select[name="activeFlag"]').val('Y');
					$('#brandEdit').css('display','block');
					$('#brandEdit').dialog({title:'Add', modal: true, icon:'icon-add'});
					formSubmit('../brand/create');
				}
		}],
		onBeforeLoad:function(){
			$(this).datagrid('rejectChanges');
		},
		onLoadSuccess:function() {
			
		}
	});
	
	$('#brandList').datagrid('getPager').pagination({
		displayMsg:'显示 {from} 至 {to} 条  共 {total} 条记录',
		afterPageText:'/{pages}',
		beforePageText:'页'
	});
});