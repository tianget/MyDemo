<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>合同审核</title>
<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"	src="easyui/locale/easyui-lang-zh_CN.js"></script>

</head>
<body>
	<table  id="pactmanage_datagrid"></table>
	<div id="content" style="padding:10px;height:auto;">
		<div id="pactmanage_tool" style="padding-left:25px;">
		<h5>合同管理>>合同审核</h5>
			<p>合同名称：<input type="text" id="manage_pname">&nbsp;&nbsp;
			       类型：<select id="manage_ptype">
			       		<option value="不限" selected="selected">不限</option>
			       		<option value="销售合同">销售合同</option>
			       		<option value="委托合同">委托合同</option>
			       		<option value="技术合同">技术合同</option>
			       		<option value="运输合同">运输合同</option>
			       </select>&nbsp;&nbsp; 
			   <input type="button" value="查询" onclick="pact_onclick.search()"/>
			</p>
			<hr/>
			<p>合同信息列表：
						<input type="button" value="查询" onclick="pact_onclick.query()""/>
						<input type="button" value="执行" onclick="pact_onclick.execute()"/>
						<input type="button" value="变更" onclick="pact_onclick.change()"/>
						<input type="button" value="转让" onclick="pact_onclick.assignment()"/>
						<input type="button" value="解除" onclick="pact_onclick.remove()"/>
			</p>
		</div>
		<p style="height:7px;"></p>
	</div>
	<form action="pactfound_query" method="post" onsubmit="return pactfoundCreateQuery()" id="pactmanagequery"></form>
	<form action="pactfound_execute" method="post" onsubmit="return pactfoundCreateExecute()" id="pactexecute"></form>
	<form action="pactfound_change" method="post" onsubmit="return pactfoundCreateChange()" id="pactchange"></form>
	<form action="pactfound_assignment" method="post" onsubmit="return pactfoundCreateAssignment()" id="pactassignment"></form>
	<form action="pactfound_remove" method="post" onsubmit="return pactfoundCreateRemove()" id="pactremove"></form>
	<script type="text/javascript" src="../js/pactmanage.js"></script>
</body>
</html>