<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link rel="stylesheet" type="text/css"
	href="../easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="../css/home.css" />
<script type="text/javascript" src="../easyui/jquery.min.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="../easyui/locale/easyui-lang-zh_CN.js"></script>

<!-- <script type="text/javascript">
	$(function() {
		$("#nav").tree({
			url : '../power/powerList',
			animate : true,
			lines : true,
			cascadeCheck : false,
			onlyLeafCheck : true,
			onLoadSuccess : function(node, data) {
				console.log(data);
				if (data) {
					$(data).each(function(index, value) {
						if (this.state == "closed" && this.nid == 0) {
							$("#nav").tree("expandAll");
						}
					});
				}
			},
			onClick : function(node) {
				if (node.url) {
					if ($("#tabs").tabs('exists', node.text)) {
						$("#tabs").tabs('select', node.text);
					} else {
						$("#tabs").tabs('add', {
							title : node.text,
							closable : true,
							iconCls:node.iconCls,
							href : "http://localhost:8080/crm/"+node.url,
						});
					}
				}
			}
		});
		$("#tabs").tabs({
			fit : true,
			border : false,
		});
	})
</script> -->
</head>
<body>
<body class="easyui-layout">
	<div
		data-options="region:'north',title:'North Title',split:true,noheader:true,iconCls:'icon-premium'"
		style="height: 60px; background: #ccc;">
		<div class="logo">客户关系管理系统</div>
		<div class="logout">
			您好,&nbsp;[${staff.nusername}]&nbsp;|&nbsp; <a href="../role/signout">&nbsp;&nbsp;退出</a>
		</div>
		<div class="logout">部门：${staff.role.department.dshortname} &nbsp;&nbsp;角色：${staff.role.rname}</div>
	</div>
	<div
		data-options="region:'south',title:'fotter',split:true,noheader:true"
		style="height: 35px; line-height: 30px; text-align: center;">
		&copy;2017-7-14 客户关系管理管理</div>
	<div
		data-options="region:'west',title:'     导             航',split:true,iconCls:'icon-world'"
		style="width: 180px; padding: 10px;">
		<ul id="nav"></ul>
	</div>
	<div data-options="region:'center'"
		style="overflow: hidden; background: #eee;">
		<div id="tabs">
			<div title="起始页" data-options="closable:true,iconCls:'icon-house'"
				class="iconfont .icon-logistic"
				style="padding: 0 10px; display: block;">
				<p style="color: #00EE00;">欢迎来到客户关系管理系统！</p>
			</div>
		</div>
	</div>
<script type="text/javascript" src="../js/orderInquiry.js"></script>
<script type="text/javascript" src="../js/home.js"></script>
</body>
</body>
</html>