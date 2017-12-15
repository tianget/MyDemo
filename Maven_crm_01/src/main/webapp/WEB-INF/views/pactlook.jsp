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
	<table  id="pactlook_datagrid"></table>
	<div id="content" style="padding:10px;height:auto;">
		<div id="pactlook_tool" style="padding-left:25px;">
		<h5>合同管理>>合同审核</h5>
			<p>合同名称：<input type="text" id="look_pname">&nbsp;&nbsp;
			       类型：<select id="look_ptype">
			       		<option value="不限" selected="selected">不限</option>
			       		<option value="销售合同">销售合同</option>
			       		<option value="委托合同">委托合同</option>
			       		<option value="技术合同">技术合同</option>
			       		<option value="运输合同">运输合同</option>
			       </select>&nbsp;&nbsp; 
			       状态：<select id="look_pstate">
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
			<p>合同信息列表：
						<input type="button" value="查询" onclick="pact_onclick.query()""/>
						<input type="button" value="审核" onclick="pact_onclick.inspect()"/>
			</p>
		</div>
		<p style="height:7px;"></p>
	</div>
	<form action="pactfound_query" method="post" onsubmit="return pactfoundCreateQuery()" id="pactlookquery"></form>
	
	<!--  合同审核弹出框 -->
	<form id="pact_insepect_form">
		<p>合同管理>> 合同审核>> 审核操作</p>
		<jsp:include page="pactmanageexecute.jsp" />
		<table>
			<tr>
				<td style="font-weight: normal;vertical-align:buttom;font-size:14px;padding:10px;">审批</td>
				<td></td>
			</tr>
			<tr>
				<td colspan="2"><hr style="height:1px;border:none;border-top:1px solid black;"></td>
			</tr>
			<tr>
				<td>审批意见：</td>
				<td>
					<textarea cols="45" rows="3"  maxlength="250" id="insepectagruments"></textarea>
				</td>
			</tr>
		</table>
	</form>
	
	
	<script type="text/javascript" src="../js/pactlook.js"></script>
</body>
</html>