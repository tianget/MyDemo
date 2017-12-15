function orderInquiry() {
	$('#orderInquiry').datagrid({
		height : 470,
		pagination : true,
		pageNumber : 1,
		pageSize : 10,
		rownumbers : true,
		pagination : true,
		checkOnSelect : false,
		singleSelect : true,
		scrollOnSelect : false,
		pageList : [ 10, 15, 20, 25, 30 ],
		url : "../orderGoods/getAllOrder",

		columns : [ [ {
			field : 'o_oid',
			width : 50,
			checkbox : true,
		}, {
			field : 'o_otype',
			title : '订单类型',
			width : 120,
			align : 'center',
		}, {
			field : 'o_onum',
			title : '订单编号',
			width : 150,
			align : 'center',
		}, {
			field : 'g_gname',
			title : '商品名称',
			width : 180,
			align : 'center',
		}, {
			field : 'c_cname',
			title : '收货人',
			width : 150,
			align : 'center',
		}, {
			field : 'order_money',
			title : '订单金额',
			width : 150,
			align : 'center',
		}, {
			field : 'o_otime',
			title : '下单时间',
			width : 150,
			align : 'center',
		}, {
			field : 'o_ostatus',
			title : '状态',
			width : 150,
			align : 'center',
		} ] ],
	});
	
	$.ajax({
		url:"../MyJob/wetherWeb",
		type:"post"
	})
}
function refresh() {
	$("#orderInquiry").datagrid("reload");
}

//状态
function plaSta() {
	var id = $("#orderInquiry").datagrid('getSelected');
	//console.log(id.o_ostatus);
	if (id == null) {
		$.messager.alert({
			title : '警告操作',
			msg : '<h3 style="color: red;">请先选择一条订单进行更改!</h3>',
			icon : 'warning',
		})
	} else if(id.o_ostatus=="等待付款"){
		
		$.messager.confirm('确认对话框', '您确定要付款吗？', function(r){
			if (r){
				$.ajax({
				url : "../orderGoods/getGoodsStutas",
				type : "post",
				data : {
					"id" : id.o_oid
				},
			});
			}
		});


		

	// 更新选择的面板的新标题和内容
	var tab = $('#tabs').tabs('getSelected'); // 获取选择的面板
	$('#tabs').tabs('update', {		
		tab : tab,
		options : {
			title : '订单查询',
			href : '../order/orderInquiry' // 新内容的URL
		}
	});
	// 调用 'refresh' 方法更新选项卡面板的内容
	var tab = $('#tabs').tabs('getSelected'); // 获取选择的面板
	tab.panel('refresh', '../order/orderInquiry');
	}else if(id.o_ostatus=="等待自提"){
		$.messager.alert({
			title : '警告操作',
			msg : '<h3 style="color: red;">已付款，等待自提中!</h3>',
			icon : 'warning',
		})
	}else if(id.o_ostatus=="已完成"){
		$.messager.alert({
			title : '警告操作',
			msg : '<h3 style="color: red;">此订单已完成!</h3>',
			icon : 'warning',
		})
	}else if(id.o_ostatus=="已取消"){
		$.messager.alert({
			title : '警告操作',
			msg : '<h3 style="color: red;">此订单已取消!</h3>',
			icon : 'warning',
		})
	}else if(id.o_ostatus=="等待收货") {
		$.messager.alert({
			title : '警告操作',
			msg : '<h3 style="color: red;">已付款，等待收货中!</h3>',
			icon : 'warning',
		})
		

	}
}

function places(url, title, method) {
	// alert("---");
	var id = $("#orderInquiry").datagrid('getSelected');

	if (id == null) {
		$.messager.alert({
			title : '警告操作',
			msg : '<h3 style="color: red;">请先选择一条订单进行查看!</h3>',
			icon : 'warning',
		})
	} else {
		$.ajax({
			url : "../orderGoods/getGoodsAll",
			type : "post",
			data : {
				"id" : id.o_oid
			},
		});

		// 更新选择的面板的新标题和内容
		var tab = $('#tabs').tabs('getSelected'); // 获取选择的面板
		$('#tabs').tabs('update', {
			tab : tab,
			options : {
				title : title,
				onLoad : function() {
					window[method]();
				}
			}
		});
		tab.panel('refresh', url);

		$.ajax({
			url : '../orderGoods/getGoodsOrderByid',
			type : 'post',
			data : {
				'id' : id.o_oid
			},
			success : function(result) {
				console.log(result);
				if (result) {
					for (var i = 0; i < result.length; i++) {
						var on = "<p>商品名称：" + result[i].g_gname + "  |   "
								+ "型号：" + result[i].g_gtype + "  |   " + "单价："
								+ result[i].order_money + "  |   " + "数量："
								+ result[i].order_number + "  |   " + "小计："
								+ result[i].xiao + "</p>";

						$("#te").append(on);
					}
				}
			}
		});

	}

}

function manager_searcht() {

	$("#orderInquiry").datagrid('reload', {
		ts : $("#zhuangtai_id").val(),
		begin : $("#begin").val(),
		conteTitle : $("#votems").val()
	});
	/*
	 * var ts = $("#zhuangtai_id").val(); var begin = $("#begin").val(); var
	 * conteTitle=$("#votems").val(); $("#orderInquiry").datagrid('reload',{
	 * data:{ "conteTitle":conteTitle, "ts":ts, "begin":begin, } });
	 */

}

function back(url, title, method) {
	var tab = $('#tabs').tabs('getSelected'); // 获取选择的面板
	$('#tabs').tabs('update', {
		tab : tab,
		options : {
			title : title,
			onLoad : function() {
				window[method]();
			}
		}
	});
	tab.panel('refresh', url);
}
