$(function() {
	$('#orderPlace').datagrid({
		height : 300,
		pagination : true,
		pageNumber : 1,
		pageSize : 5,
		rownumbers : true,
		pagination : true,
		checkOnSelect : false,
		singleSelect : true,
		scrollOnSelect : false,
		pageList : [ 5, 10, 15, 20, 25 ],
		url : "../goods/pageGoodsList",

		columns : [ [ {
			field : 'gid',
			width : 50,
			checkbox : true,
		}, {
			field : 'gname',
			title : '商品名称',
			width : 200,
			align : 'center',
		}, {
			field : 'gtype',
			title : '商品型号',
			width : 200,
			align : 'center',
		}, {
			field : 'gprice',
			title : '单价（单位：万元）',
			width : 200,
			align : 'center',
		}, {
			field : 'peopleNum',
			title : '数量',
			width : 200,
			align : 'center',
		/*
		 * formatter : function(value, row, index) { alert(row.gid); return'<input
		 * type="text" name="peopleNum'+row.gid+'" id="peopleNum'+row.gid +'"
		 * value="'+value+'" style="width:20px" />' },
		 */
		}, {
			field : 'gstock',
			title : '库存',
			width : 200,
			align : 'center',

		} ] ],
	});
});

function minmin(t) {
	var test = $(t).next().val();
	if (test > 1) {
		test--;
		$(t).next().val(test);
	}

}

function add(r) {
	var count = $(r).prev().val();
	if (count < 500) {
		count++;
		$(r).prev().val(count);
	}
}

/*
 * function formatade(val, row, index) { return "<input class='min' name=''
 * type='button' value='-' /> " + "<input class='text_box' style='width:20px'
 * name='' type='text' value='1' /> " + "<input class='add' name=''
 * type='button' value='+' />" }
 */

function reload() {
	$("#orderPlace").datagrid("reload");
}

//
function place() {
	// 更新选择的面板的新标题和内容

	var tab = $('#tabs').tabs('getSelected'); // 获取选择的面板
	$('#tabs').tabs('update', {
		tab : tab,
		options : {
			title : '订单管理',
			href : '../order/orderOf' // 新内容的URL
		}
	});

	// 调用 'refresh' 方法更新选项卡面板的内容
	var tab = $('#tabs').tabs('getSelected'); // 获取选择的面板
	tab.panel('refresh', '../order/orderOf');

}

function placeTwo() {
	var id = $("#orderPlace").datagrid('getSelections');
	// alert($("#peopleNum2").val());
	console.log(id);
	var ts = "";
	var m = "";
	if (id != "") {
		for (var i = 0; i < id.length; i++) {
			//alert(id[i].gid );
			ts += id[i].gid + ",";
			//alert($('#goodsNumber'+id[i].gid).val());
			m += $('#goodsNumber' + id[i].gid).val()+ ",";
			
		}
		$.ajax({
			url : "../goods/getSelectIdTe",
			type : "post",
			data : {
				"ts" : ts,
				"m" : m
			},		
			
		});

		// 更新选择的面板的新标题和内容
		var tab = $('#tabs').tabs('getSelected'); // 获取选择的面板
		$('#tabs').tabs('update', {
			tab : tab,
			options : {
				title : '订单结算',
				href : '../order/orderFinal' // 新内容的URL
			}
		});

		// 调用 'refresh' 方法更新选项卡面板的内容
		var tab = $('#tabs').tabs('getSelected'); // 获取选择的面板
		tab.panel('refresh', '../order/orderFinal');
	}

}
