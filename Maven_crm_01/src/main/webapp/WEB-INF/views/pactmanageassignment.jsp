<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>合同转让</title>
<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"	src="easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
	<div>
		<table id="pact_script">
			<tr id="pact_input">
				<td colspan="2" ><h5>合同管理>>合同转让</h5></td>
				<td colspan="2"><h3>执行合同</h3></td>
			</tr>
			<tr>
				<td>合同名称：</td>
				<td colspan="3" id="pact_input"><input  id="pname" style="width:470px"  value="pname"/><span class="point_red">*</span></td>
			</tr>
			<tr>
				<td>合同类型：</td>
				<td id="pact_input">
					<select id="ptype" name="pact.ptype">
						<option value="销售合同" selected="selected">销售合同</option>
						<option value="委托合同">委托合同</option>
						<option value="技术合同">技术合同</option>
						<option value="运输合同">运输合同</option>
					</select>
				<span class="point_red">*</span></td>
				<td>合同金额：</td>
				<td id="pact_input"><input style="width:115px"/>元<span class="point_red">*</span></td>
			</tr>
			<tr>
				<td>合同状态：</td>
				<td id="pact_input"><input style="width:135px"/><span class="point_red">*</span></td>
				<td>客户方：</td>
				<td id="pact_input"><input style="width:135px"/><span class="point_red">*</span></td>
			</tr>
			<tr>
				<td>经营许可证号：</td>
				<td id="pact_input"><input style="width:135px"/><span class="point_red">*</span></td>
				<td>创建人：</td>
				<td id="pact_input"><input style="width:135px"/><span class="point_red">*</span></td>
			</tr>
			<tr>
				<td>创建时间：</td>
				<td id="pact_input"><input style="width:135px"/><span class="point_red">*</span></td>
				<td>待处理人：</td>
				<td id="pact_input"><input style="width:135px"/><span class="point_red">*</span></td>
			</tr>
			<tr>
				<td>合同内容：</td>
				<td colspan="3" id="pact_input"></td>
			</tr>
			<tr>
				<td colspan="4" class="pactLeft">
					<textarea cols="75" rows="13"  maxlength="250" name="scontent"></textarea><span class="point_red">*</span>
				</td>
			</tr>
			<tr>
				<td>转让操作：<hr></td>
				<td colspan="3">&nbsp<hr>
				</td>
			</tr>
			<tr>
				<td>转让备注：
				</td>
				<td rowspan="6" colspan="3" id="pact_input">
					<textarea cols="67" rows="13"  maxlength="250" name="scontent"></textarea>
				</td>
			</tr>
			<tr>
				<td style="height:200px"></td>
			</tr>
		</table>
	</div>
	<link rel="stylesheet" type="text/css" href="../css/pact.css">
</body>
</html>