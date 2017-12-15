<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品管理</title>
<style type="text/css">
#a {
	position:
}

#fm {
	margin: 0;
	padding: 10px 30px;
}

.ftitle {
	font-size: 14px;
	font-weight: bold;
	padding: 5px 0;
	margin-bottom: 10px;
	border-bottom: 1px solid #ccc;
}

.fitem {
	margin-bottom: 5px;
}

.fitem label {
	display: inline-block;
	width: 80px;
}

.fitem input {
	width: 160px;
}
</style>

</head>

<body>
	<table id="Goods">

	</table>
	<div id="go">
		<a href="javascript:onclick=refresh()" class="easyui-linkbutton"
			data-options="iconCls:'icon-reload',text:'刷新',plain:true"></a>&nbsp;&nbsp;

		<a href="#" class="easyui-linkbutton" onclick="newEqument()"
			data-options="iconCls:'icon-add',text:'添加',plain:true"></a>&nbsp;&nbsp;

		<a href="#" class="easyui-linkbutton" onclick="destroyEqument()"
			data-options="iconCls:'icon-remove',text:'删除',plain:true"></a>&nbsp;&nbsp;
		<!-- <a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-edit',text:'修改',plain:true"></a>&nbsp;&nbsp; -->
		
		<!-- <span style="float: right"> 商品名称&nbsp;:&nbsp;<input
			class="easyui-textbox" type="text" /> <a href="#"
			class="easyui-linkbutton"
			data-options="iconCls:'icon-search',text:'搜索'"></a>
		</span> -->
	</div>

	<div id="dlg" class="easyui-dialog"
		style="width: 300px; height: 250px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">

		<form id="fm" method="post" >
			<div class="fitem">
				<label>商品名称:</label> <input name="gname" id="gname" class="easyui-textbox"
					required="true">
			</div>
			<p></p>
			<div class="fitem">
				<label>商品类型:</label> <input id="gtype" name="gtype" class="easyui-textbox"
					required="true">
			</div>
			<p></p>
			<div class="fitem">
				<label>商品价格:</label> <input id="gprice" name="gprice" class="easyui-textbox"
					required="true">
			</div>
			<p></p>
			<div class="fitem">
				<label>商品库存:</label> <input id="gstock" name="gstock" class="easyui-textbox"
					required="true">
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
			style="width: 90px" onclick="saveEqument()" >保存</a> <a href="#" class="easyui-linkbutton"
			iconCls="icon-cancel" style="width: 90px"
			onclick="javascript:$('#dlg').dialog('close')">取消</a>
	</div>

	<script type="text/javascript" src="../js/orderGoods.js"></script>

</body>
</html>