<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>合同修改</title>
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
				<td colspan="2" ><h5>合同管理>>合同修改</h5></td>
				<td colspan="2"><h3>修改合同</h3></td>
			</tr>
			<tr>
				<td>合同名称：</td>
				<td colspan="3" id="pact_input"><input style="width:470px"  value="${pact.pname}" id="uname"/><span class="point_red">*</span></td>
			</tr>
			<tr>
				<td>合同类型：</td>
				<td id="pact_input">
					<select id="ptype"  id="ptype" name="ptype">
						<option value="销售合同" selected="selected">销售合同</option>
						<option value="委托合同">委托合同</option>
						<option value="技术合同">技术合同</option>
						<option value="运输合同">运输合同</option>
					</select>
				<span class="point_red">*</span></td>
				<td>合同金额：</td>
				<td id="pact_input"><input style="width:115px" value="${pact.pmoney}" id="umoney"/>元<span class="point_red">*</span></td>
			</tr>
			<tr>
				<td>甲方：</td>
				<td id="pact_input"><input style="width:135px" value="${pact.pjia}" id="ujia"/><span class="point_red">*</span></td>
				<td>乙方：</td>
				<td id="pact_input"><input style="width:135px" value="${pact.pyi}" id="uyi"/><span class="point_red">*</span></td>
			</tr>
			<tr>
				<td>企业经营许可号：</td>
				<td id="pact_input"><input style="width:135px" value="${pact.poperatejia}" id="uoperatejia"/><span class="point_red">*</span></td>
				<td>企业经营许可号：</td>
				<td id="pact_input"><input style="width:135px" value="${pact.poperateyi}" id="uoperateyi"/><span class="point_red">*</span></td>
			</tr>
			<tr>
				<td>合同内容：</td>
				<td colspan="3" id="pact_input"></td>
			</tr>
			<tr>
				<td colspan="4" class="pactLeft">
					<textarea cols="75" rows="15"  maxlength="250" name="pcontent" id="ucontent">${pact.pcontent}</textarea><span class="point_red">*</span>
				</td>
			</tr>
			<tr>
				<td>备注信息：
				</td>
				<td rowspan="6" colspan="3" id="pact_input">
					<textarea cols="67" rows="14"  maxlength="250" name="premarks" id="uremarks">${pact.premarks}</textarea>
				</td>
			</tr>
			<tr>
				<td style="height:200px"></td>
			</tr>
		</table>
	</div>
	<script type="text/javascript" src="../js/pactfound.js"></script>
	<link rel="stylesheet" type="text/css" href="../css/pact.css">
</body>
</html>