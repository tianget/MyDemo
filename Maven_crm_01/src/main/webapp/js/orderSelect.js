$(function() {	
	alert("////")
	
		$('#orderSelect').datagrid({		
			columns : [ [  {
				field : 'g_gname',
				title : '商品名称',
				width : 100,
				align : 'center',
			}, {
				field : 'o_onum',
				title : '订单号',
				width : 100,
				align : 'center',
			}, {
				field : 'order_money',
				title : '单价',
				width : 100,
				align : 'center',
			}, {
				field : 'g_gtype',
				title : '型号',
				width : 100,
				align : 'center',
			}, {
				field : 'order_number',
				title : '数量',
				width : 100,
				align : 'center',
			}, {
				field : 'xiao',
				title : '小计',
				width : 80,
				align : 'center',
			},] ],
			rownumbers : true,	
			url:'../orderGoods/getAll'
		});
	
	
	
	
	
});




