function setProvinceSelect(provinceId, cityId) {
	$.ajax({
		url:"../city/getProvinceList",
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
	    	$.messager.alert('消息',err,'error');
		}
	});
}
/**
 * 字符串转JSON对象
 * @param strData
 * @return
 */
function parseObj(strData){
	return (new Function( "return " + strData ))();
}

// edit event
function formSubmit(actionUrl) {
	// validate
	$('#supplierForm').ajaxForm({ 
		url: actionUrl,
		beforeSubmit: validate, 
		dataType:  'html', 
        success:   processJson,
		cache: false,
        error:   function(err){
			$('#loader').remove();
	    	$.messager.alert('消息','更新操作失败！','error');
		}  
    }); 
}
// call back
function processJson(data) {
    data = parseObj($(data).text().replace(/=/g,":"));
    if (data.supplierId == -1) {
    	$('#loader').remove();
    	$.messager.alert('消息','商家名称已存在，请重新操作！','warning');
    	return;
    }
    if (data.supplierId == -2) {
    	$('#loader').remove();
		$.messager.alert('消息','商品图片大小应小于65K，请重新操作！','warning');
    	return;
    }
    var optMsg = "新增成功！";
    if ($('input[name="supplierId"]').val() > 0) {
    	optMsg = "更新成功！";
    }
    $.messager.show({
		title:'消息',
		msg:optMsg,
		timeout:optSuccessTime,
		showType:'slide'
	});
    $('#supplierId').val(data.supplierId);
    var url = "../supplier/getImage?id=" + data.supplierId + "&uuid=" + createUUID();
    $('#image').attr('src', url);
    var url1 = "../supplier/getImage1?id=" + data.supplierId + "&uuid=" + createUUID();
    $('#image1').attr('src', url1);
    var url2 = "../supplier/getImage2?id=" + data.supplierId + "&uuid=" + createUUID();
    $('#image2').attr('src', url2);
	//$('#supplierEdit').dialog('close');
    $('#supplierList').datagrid('reload');
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
	if (form.cityId.value.length == 0) {
		$.messager.alert('消息','请选择城市！','info');
		form.cityId.focus();
		return false;
	}
	if (form.supplierName.value.length == 0) {
		$.messager.alert('消息','请输入商家名称！','info');
		form.supplierName.focus();
		return false;
	}
	if (form.supplierContactname.value.length == 0) {
		$.messager.alert('消息','请输入联系人！','info');
		form.supplierContactname.focus();
		return false;
	}
	if (form.supplierZip.value.length == 0) {
		$.messager.alert('消息','请输入邮编！','info');
		form.supplierZip.focus();
		return false;
	}
	if (form.supplierFax.value.length == 0) {
		$.messager.alert('消息','请输入传真！','info');
		form.supplierFax.focus();
		return false;
	}
	if (form.supplierMobile.value.length == 0) {
		$.messager.alert('消息','请输入手机！','info');
		form.supplierMobile.focus();
		return false;
	}
	if (form.supplierTelephone.value.length == 0) {
		$.messager.alert('消息','请输入联系电话！','info');
		form.supplierTelephone.focus();
		return false;
	}
	if (form.supplierAddress.value.length == 0) {
		$.messager.alert('消息','请输入联系地址！','info');
		form.supplierAddress.focus();
		return false;
	}
	if (form.supplierDescription.value.length == 0) {
		$.messager.alert('消息','请输入简介！','info');
		form.supplierDescription.focus();
		return false;
	}
	if (form.supplierDescription.value.length > 1000) {
		$.messager.alert('消息','简介不能超过1000个字符！','info');
		form.supplierDescription.focus();
		return false;
	}
	if ($('#image').children().length == 0 && form.file.value.length == 0) {
		$.messager.alert('消息','请选择图片！','info');
		form.file.focus();
		return false;
	}
	var ext = form.file.value.split('.').pop().toLowerCase(); 
	var allow = new Array('gif','png','jpg','jpeg'); 
	if(form.file.value.length > 0 && jQuery.inArray(ext, allow) == -1) {
	
	   $.messager.alert('消息','请选择图片格式为：gif,png,jpg,jpeg！','info');
	   return false;
	} 
	$('#image_fake').append('<image id="loader" src="../images/datagrid/tree_loading.gif"/> ');
	$('#image1_fake').append('<image id="loader1" src="../images/datagrid/tree_loading.gif"/> ');
	$('#image2_fake').append('<image id="loader2" src="../images/datagrid/tree_loading.gif"/> ');
}
function onEditClickHandler(id) {
	$.get('../supplier/get', { id: id } ,function(data) {
		$('input[name="supplierId"]').val(id);
		setProvinceByCityId(data.cityId);
		setCitySelect(data.cityId);
		$('input[name="supplierName"]').val(data.supplierName);
		$('input[name="supplierContactname"]').val(data.supplierContactname);
		$('input[name="supplierZip"]').val(data.supplierZip);
		$('textarea[name="supplierDescription"]').val(data.supplierDescription);
		$('input[name="supplierMobile"]').val(data.supplierMobile);
		$('input[name="supplierTelephone"]').val(data.supplierTelephone);
		$('input[name="supplierFax"]').val(data.supplierFax);
		$('input[name="supplierAddress"]').val(data.supplierAddress);
		$('input[name="supplierAccess"]').val(data.supplierAccess);
		$('input[name="supplierScore"]').val(data.supplierScore);
		$('select[name="activeFlag"]').val(data.activeFlag);
		$('#supplierEdit').css('display','block');
		$('#supplierEdit').dialog({title:'修改', modal: true});
	    var url = "../supplier/getImage?id=" + id + "&uuid=" + createUUID();
	    $('#image').attr('src', url);
	    var url1 = "../supplier/getImage1?id=" + id + "&uuid=" + createUUID();
	    $('#image1').attr('src', url1);
	    var url2 = "../supplier/getImage2?id=" + id + "&uuid=" + createUUID();
	    $('#image2').attr('src', url2);
	});
	formSubmit('../supplier/update');
}

function setProvinceByCityId(cityId) {
	$.get('../city/get', { id: cityId } ,function(data) {
		setProvinceSelect(data.provinceId, cityId);
	});
}

	
function onDeleteClickHandler(id) {
	$.messager.confirm('消息', '确认要删除该记录吗?', function(r){
		if (r){
			$.get('../supplier/delete', { id: id } ,function(data) {
				if (data == "success") {
				    $('#supplierList').datagrid('reload');
				    $.messager.show({
						title:'消息',
						msg:'删除成功！',
						timeout:optSuccessTime,
						showType:'slide'
					});
				} else if (data == "referenceSupplierProduct") {
					$.messager.alert('消息','有商家与产品关系关联此商家，暂时无法删除！','warning');
				} else if (data == "referenceContact") {
					$.messager.alert('消息','有商家联系方式关联此商家，暂时无法删除！','warning');
				} else {
					$.messager.alert('消息','删除失败！','error');
				}
			});
		}
	});
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
					$('input[name="supplierId"]').val('');
					$('select[name="provinceId"]').val('');
					setProvinceSelect('', -1);
					setCitySelect('');
					$('input[name="supplierName"]').val('');
					$('input[name="supplierContactname"]').val('');
					$('input[name="supplierZip"]').val('');
					$('textarea[name="supplierDescription"]').val('');
					$('input[name="supplierMobile"]').val('');
					$('input[name="supplierTelephone"]').val('');
					$('input[name="supplierAddress"]').val('');
					$('input[name="supplierAccess"]').val('0');
					$('input[name="supplierScore"]').val('0');
					$('input[name="file"]').val('');
					$('input[name="supplierFax"]').val('');
					$('select[name="activeFlag"]').val('Y');
					$('#loader').remove();
					$('#image').attr('src', '../images/common/nopic.jpg');
					$('#image1').attr('src', '../images/common/nopic.jpg');
					$('#image2').attr('src', '../images/common/nopic.jpg');
					$('#supplierEdit').css('display','block');
					$('#supplierEdit').dialog({title:'新增', modal: true, icon:'icon-add'});
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

$(document).ready(function() {
	//image click popup big pic
	var $enlargedCover = $('<img/>')
	.css('position', 'absolute')
	.css('z-index', 9999)
	.css('cursor', 'pointer')
	.hide()
	.appendTo('body');

	$('#image').click(function(event) {
	    var startPos = $(this).offset();
	    startPos.width = $(this).width();
	    startPos.height = $(this).height();
	    var endPos = {};
        endPos.width = startPos.width * 3;
        endPos.height = startPos.height * 6;
        endPos.top = 50;
        endPos.left = ($('body').width() - endPos.width) / 2;
        $enlargedCover.attr('src', $(this).children().attr('src'))
        .css(startPos)
        .show();
		var performAnimation = function() {
		    $enlargedCover.animate(endPos, 'normal',
		        function() {
		      $enlargedCover.one('click', function() {
		        $enlargedCover.fadeOut();
		      });
		    });
		};
		if ($enlargedCover[0].complete) {
		  performAnimation();
		}
		else {
		  $enlargedCover.bind('load', performAnimation);
		}
		event.preventDefault();
	})
	.hover(function() {
	    $(this).css('cursor', 'pointer');
	}, function() {
		$(this).css('cursor', '');
	});
});