//edit event
function formSubmit(actionUrl) {
	$('#loader').remove();
	$('#commodityForm').ajaxForm({ 
		url: actionUrl,
		beforeSubmit: validate, 
		dataType:  'html', 
        success:   processJson,
        error:   function(err){
    		$('#loader').remove();
	    	$.messager.alert('消息','更新操作失败！','error');
		} 
	});
}

function validate(formData, jqForm, options) {
	var form = jqForm[0]; 
	if (form.commodityName.value.length == 0) {
    	$.messager.alert('消息','请输入商品名称！','info');
		form.commodityName.focus();
		return false;
	}
	if (form.commodityDescription.value.length == 0) {
    	$.messager.alert('消息','请输入商品描述！','info');
		form.commodityDescription.focus();
		return false;
	}
	if (form.startDate.value.length == 0) {
    	$.messager.alert('消息','请选择开始时间！','info');
		return false;
	}
	if (form.endDate.value.length == 0) {
    	$.messager.alert('消息','请选择结束时间！','info');
		return false;
	}
	if (form.startDate.value.replace(/\//g,'') > form.endDate.value.replace(/\//g,'')) {
		$.messager.alert('消息','开始时间应大于结束时间！','info');
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
	$('#image').append('<image id="loader" src="../images/datagrid/tree_loading.gif"/> ');
}
/**
 * 字符串转JSON对象
 * @param strData
 * @return
 */
function parseObj(strData){
	return (new Function( "return " + strData ))();
}

function processJson(data) {
	data = parseObj($(data).text().replace(/=/g,":"));
    if (data.commodityId == -1) {
    	$('#loader').remove();
		$.messager.alert('消息','商品已存在，请重新操作！','warning');
    	return;
    }
    if (data.commodityId == -2) {
    	$('#loader').remove();
		$.messager.alert('消息','商品图片大小应小于65K，请重新操作！','warning');
    	return;
    }
    var optMsg = "新增成功！";
    if ($('input[name="commodityId"]').val() > 0) {
    	optMsg = "更新成功！";
    }
    $.messager.show({
		title:'消息',
		msg:optMsg,
		timeout:optSuccessTime,
		showType:'slide'
	});
    $('#commodityId').val(data.commodityId);
    var url = "../commodity/getImage?id=" +data.commodityId;
    $('#image').empty().append('<img id="pic" width="100" height="100" src="'+url+'"/>');
//	$('#image').append('<image  onClick="onDeleteClickHandler(' + data.commodityId + ')" onmouseover="this.style.cursor=\'pointer\';" height="15" width="15" src="../images/datagrid/icon_list_delete.gif"/>');
	$('#commodityList').datagrid('reload');
}

function onEditClickHandler(id) {
	$.get('../commodity/get', { id: id } ,function(result) {
		var data = result.commodity;
		var image = result.commodityImage;
		$('input[name="commodityId"]').val(id);
		$('input[name="commodityName"]').val(data.commodityName);
		$('input[name="commodityDescription"]').val(data.commodityDescription);
		$('input[name="startDate"]').val(new Date(data.startDate).format('yyyy/MM/dd'));
		$('input[name="endDate"]').val(new Date(data.endDate).format('yyyy/MM/dd'));
		$('select[name="activeFlag"]').val(data.activeFlag);
		$('input[name="commodityPrice"]').val(data.commodityPrice);
		$('select[name="commodityType"]').val(data.commodityType);
		$('#commodityEdit').css('display','block');
		$('#commodityEdit').dialog({title:'修改', modal: true});
		$('input[name="commodityimageId"]').val(image.commodityimageId);
		var url = "../commodity/getImage?id=" +image.commodityimageId;
		$('#image').empty().append('<img id="pic" width="100" height="100" src="'+url+'"/>');
//		$('#image').append('<image  onClick="onDeleteClickHandler(' + id + ')" onmouseover="this.style.cursor=\'pointer\';" height="15" width="15" src="../images/datagrid/icon_list_delete.gif"/>');
	});
	formSubmit('../commodity/update');
}

function onDeleteClickHandler(id) {
	$.messager.confirm('消息', '确认要删除该记录吗?', function(r){
		if (r){
			$.get('../commodity/delete', { id: id } ,function(data) {
				if (data == "success") {
					$('#image').empty();
				    $.messager.show({
						title:'消息',
						msg:'删除成功！',
						timeout:optSuccessTime,
						showType:'slide'
					});
				    $('#commodityList').datagrid('reload');
				} else {
					$.messager.alert('消息','删除失败！','error');
				}
			});
		}
	});
}

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
//list
$(function(){
	$('#startDate').datebox({
		formatter:function(value) {
		return new Date(value).format('yyyy/MM/dd');
		}
	});
	$('#endDate').datebox({
		formatter:function(value) {
		return new Date(value).format('yyyy/MM/dd');
		}
	});
	// edit
	var lastIndex;
	$('#commodityList').datagrid({
		title:'商品维护',
		iconCls:'icon-edit',
		width:950,
		height:'auto',
		singleSelect:true,
		sortName: 'commodityName',
		sortOrder: 'asc',
		remoteSort: false,
		idField:'commodityId',
		method:'get',
		url:'../commodity/search',
		queryParams:{commodityName:''},
		pagination:true,
		loadMsg:'数据加载中,请稍候...',
		columns:[[
			{field:'commodityId',title:'编号',width:80,align:'center'},
			{field:'commodityName',title:'商品名称',width:100,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
//			{field:'commodityDescription',title:'描述',width:100,align:'center',sortable:true,
//				sorter:function(a,b,order){
//					return (a>b?1:-1)*(order=='asc'?1:-1);
//				}
//			},
			{field:'startDate',title:'开始时间',width:120,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
			{field:'endDate',title:'结束时间',width:120,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
			{field:'commodityPrice',title:'价格',width:50,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
			{field:'commodityType',title:'商品类型',width:100,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				},
				formatter:function(value,rec){
					if (value == 'S') {
						return '二手';
					} else {
						return '促销';
					}
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
			{field:'createdDate',title:'创建时间',width:120	,align:'center',sortable:true,
					sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
			{field:'opt',title:'操作',width:80,align:'center',
				formatter:function(value,rec){
					return '<span><image onClick="onEditClickHandler(' + rec['commodityId'] + ')" onmouseover="this.style.cursor=\'pointer\';" src="../images/datagrid/icon_list_edit.gif"/>&nbsp;&nbsp;<image onClick="onDeleteClickHandler(' + rec['commodityId'] + ')" onmouseover="this.style.cursor=\'pointer\';" height="15" width="15" src="../images/datagrid/icon_list_delete.gif"/></span>';
				}
			}
		]],
		rownumbers:true,
		toolbar:[{
				id:'btnadd',
				text:'新增',
				iconCls:'icon-add',
				handler:function(){
					$('input[name="commodityId"]').val('');
					$('input[name="commodityName"]').val('');
					$('input[name="commodityDescription"]').val('');
					$('input[name="startDate"]').val('');
					$('input[name="endDate"]').val('');
					$('input[name="commodityPrice"]').val('');
					$('input[name="file"]').val('');
					$('input[name="commodityimageId"]').val('');
					$('select[name="commodityType"]').val('S');
					$('#image').empty();
					$('select[name="activeFlag"]').val('Y');
					$('#commodityEdit').css('display','block');
					$('#commodityEdit').dialog({title:'新增', modal: true, icon:'icon-add'});
					formSubmit('../commodity/create');
				}
		}],
		onBeforeLoad:function(){
			$(this).datagrid('rejectChanges');
		},
		onLoadSuccess:function() {
			
		}
	});
	
	$('#commodityList').datagrid('getPager').pagination({
		displayMsg:'显示 {from} 至 {to} 条  共 {total} 条记录',
		afterPageText:'/{pages}',
		beforePageText:'页'
	});
});
