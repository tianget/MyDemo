<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>合同创建</title>
<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"	src="easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
	<table  id="pact_datagrid"></table>
	<div id="content" style="padding:10px;height:auto;">
		<div id="pact_tool" style="padding-left:25px;">
		<h5>合同管理>>合同创建</h5>
			<p>合同名称：<input type="text" id="pname">&nbsp;&nbsp;
			       类型：<select id="ptype">
			       		<option value="不限" selected="selected">不限</option>
			       		<option value="销售合同">销售合同</option>
			       		<option value="委托合同">委托合同</option>
			       		<option value="技术合同">技术合同</option>
			       		<option value="运输合同">运输合同</option>
			       </select>&nbsp;&nbsp; 
			       状态：<select id="pstate">
			       		<option value="不限" selected="selected">不限</option>
			       		<option value="已订立">已订立</option>
			       		<option value="已提交">已提交</option>
			       		<option value="待审核">待审核</option>
			       		<option value="已审核">已审核</option>
			       		<option value="履行中">履行中</option>
			       		<option value="已履行">已履行</option>
			       		<option value="已变更">已变更</option>
			       		<option value="已解除">已解除</option>
			       		<option value="已转让">已转让</option>
			       		<option value="已转让">已终止</option>
			       		<option value="已归档">已归档</option>
			       </select> 
			   <input type="button" value="查询" onclick="pact_onclick.search()"/>
			</p>
			<hr/>
			<p>合同信息列表：<input type="button" value="创建" onclick="pact_onclick.add()"/>
						<input type="button" value="修改" onclick="pact_onclick.update()"/>
						<input type="button" value="查看" onclick="pact_onclick.query()"/>
						<input type="button" value="提交" onclick="pact_onclick.submit()"/>
			</p>
		</div>
		<p style="height:7px;"></p>
	</div>
	<form action="pactfound_add" method="post" onsubmit="return pactfoundCreate()" id="pactfoundadd"></form>
	<form action="pactfound_update" method="post" onsubmit="return pactfoundCreateUpdate()" id="pactfoundupdate"></form>
	<form action="pactfound_query" method="post" onsubmit="return pactfoundCreateQuery()" id="pactfoundquery"></form>
	<script type="text/javascript" src="../js/pactfound.js"></script>
</body>
</html>