
function buttonS(){	
	var m_id=$("#lid").val();
	var userName=$("#liname").val();	
	var opayment = $("#o").val();
	var otype = $("#e").val();
	var oinvoice = $("#lizhi").val();
	
	var gid = $("#is").val();
	var order_money = $("#sprice").val();
	var order_number = $("#snum").val();     
	$.ajax({
		url:"../orderGoods/getGoodsOrderAll",
		type:"post",
		data:{
			"opayment":opayment,
			"otype":otype,
			"oinvoice":oinvoice,
			"m_id":m_id,
			"gid":gid,
			"order_money":order_money,
			"order_number":order_number
		}
	});		

	$.messager.alert("提示", "提交成功", "info");	
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
}

//刷新
function refreshre(){
	$("#orderPlace").datagrid("reload");
}

function backFinal(url, title, method) {
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

