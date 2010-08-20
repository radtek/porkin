$(document).ready(function() {
	$('#productWindow').window('close');
	$('#productWin').window({
		model:true,
		shadow: false,
		closed: false,
		minimizable:false,
		maximizable:false
	});
	$('#productWin').window('close');
});


function openProduct(supplierId){
	$('#productWindow').window('open');
	$('#supplierId').val(supplierId);
	$('#ownProductList').datagrid({
		width:'auto',
		height:'auto',
		sortName: 'countryName,brandName,categoryName,productName',
		sortOrder: 'asc,asc,asc,asc',
		remoteSort: false,
		frozenColumns:[[
            {field:'ck',checkbox:true}
		]],
		idField:'productBrandId',
		method:'get',
		url:'../supplierProduct/productSearch',
		queryParams:{productName:'', supplierId:supplierId},
		pagination:true,
		loadMsg:'数据加载中,请稍候...',
		columns:[[
			{field:'countryName',title:'国家',width:100,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
			{field:'brandName',title:'品牌',width:100,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
			{field:'categoryName',title:'类别',width:100,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
			{field:'productName',title:'产品',width:100,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
			{field:'opt',title:'操作',width:50,align:'center',
				formatter:function(value,rec){
					return '<image onClick="onProductDeleteClickHandler(' + rec['productId'] + ',' + supplierId +')" onmouseover="this.style.cursor=\'pointer\';" height="15" width="15" src="../images/datagrid/icon_list_delete.gif"/></span>';
				}
			}
		]],
		rownumbers:true,
		toolbar:[{
			id:'btnProductAdd',
			text:'追加产品',
			iconCls:'icon-add',
			handler:function(){
				$('#productWin').window('open');
				openProductBrand();
			}
		},
		{
			id:'btnProductDelete',
			text:'批量删除',
			iconCls:'icon-remove',
			handler:function(){
			}
		}],
		onBeforeLoad:function(){
			$(this).datagrid('rejectChanges');
		}
	});
	$('#ownProductList').datagrid('getPager').pagination({
		displayMsg:'显示 {from} 至 {to} 条  共 {total} 条记录',
		afterPageText:'/{pages}',
		beforePageText:'页'
	});
	$('#ownProductList').datagrid('clearSelections');
}
// product brand 
function addSupplierProduct() {
	var productIds = getSelectedProductIds();
	if (productIds) {
		$.get('../supplierProduct/addSupplierProduct', { productBrandIds: productIds, supplierId:$('#supplierId').val()} ,function(data) {
			if (data == "success") {
//				alert("追加成功！");
				$('#productWin').dialog('close');
			} else {
				alert("已存在的品牌产品列表：\n" + data);
			}
			$('#ownProductList').datagrid('reload');
			$('#supplierProductList').datagrid('reload');
		});
	} else {
		alert('请选择品牌产品！');
	}
}

function getSelectedProductIds() {
	var ids = [];
	var rows = $('#targetProductList').datagrid('getSelections');
	for(var i=0;i<rows.length;i++){
		ids.push(rows[i].productbrandId);
	}
	return ids.join(',');
}


function openProductBrand() {
	var lastIndex;
	$('#targetProductList').datagrid({
		width:600,
		height:'auto',
		sortName: 'countryName,brandName,categoryName,productName',
		sortOrder: 'asc,asc,asc,asc',
		remoteSort: false,
		frozenColumns:[[
            {field:'ckd',checkbox:true},
            {field:'productbrandId',title:'编号',width:80,align:'center'}
		]],
		nowrap: false,
		striped: true,
		idField:'productbrandId',
		method:'get',
		url:'../productBrand/search',
		queryParams:{activeFlag:'Y',productBrandName:''},
		pagination:true,
		loadMsg:'数据加载中,请稍候...',
		columns:[[
			{field:'countryName',title:'国家',width:100,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
			{field:'brandName',title:'品牌',width:100,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
			{field:'categoryName',title:'类别',width:100,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
			{field:'productName',title:'产品',width:100,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			}
		]],
		pagination:true,
		rownumbers:true
	});
	var p = $('#targetProductList').datagrid('getPager');
	if (p){
		$(p).pagination({
			onBeforeRefresh:function(){
//				alert('before refresh');
			}
		});
	}
	$('#targetProductList').datagrid('getPanel').panel({
		collapsible:true
	});
	$('#targetProductList').datagrid('getPager').pagination({
		displayMsg:'显示 {from} 至 {to} 条  共 {total} 条记录',
		afterPageText:'/{pages}',
		beforePageText:'页'
	});
	$('#targetProductList').datagrid('clearSelections');
}
// list
$(function(){
	// edit
	var lastIndex;
	$('#supplierProductList').datagrid({
		title:'商家与产品关系维护',
		iconCls:'icon-edit',
		width:750,
		height:'auto',
		singleSelect:true,
		sortName: 'provinceName,cityName,supplierName,productCount',
		sortOrder: 'asc,asc,asc,desc',
		remoteSort: false,
		idField:'supplierId',
		method:'get',
		url:'../supplierProduct/search',
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
			{field:'supplierName',title:'商家',width:100,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
			{field:'productCount',title:'产品数量',width:100,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
			{field:'opt',title:'操作',width:50,align:'center',
				formatter:function(value,rec){
					return '<span><image onClick="openProduct(' + rec['supplierId'] + ')" onmouseover="this.style.cursor=\'pointer\';" src="../images/datagrid/icon_list_edit.gif"/></span>';
				}
			}
		]],
		rownumbers:true,
		onBeforeLoad:function(){
			$(this).datagrid('rejectChanges');
		},
		onLoadSuccess:function() {
			
		}
	});
	
	$('#supplierProductList').datagrid('getPager').pagination({
		displayMsg:'显示 {from} 至 {to} 条  共 {total} 条记录',
		afterPageText:'/{pages}',
		beforePageText:'页'
	});
});