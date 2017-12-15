<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>创建服务单据</title>
<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"	src="easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/servecreate.js"></script>
<link rel="stylesheet" type="text/css" href="css/servecreate.css">
</head>
<body>
<!-- readonly="true" placeholder="四川客户离心器售后服务"  -->
	<div id="serve_create">
	<p style="font-weight: normal;font-size:12px;margin-top:20px;margin-bottom: 0;padding-left:15px;">&nbsp;&nbsp;&nbsp;服务管理>> 服务创建>> 新增服务</p>
		<table id="serve_create_table">
			<tr>
				<td>服务名称：</td>
				<td>
				<input type="text" style="width: 375px;" id="sname" name="serve.sname"><span class="point_red">*</span>
				</td>
			</tr>
			<tr>
				<td>服务类型：</td>
				<td>
		      		 <select id="stype" class="easyui-combobox" data-options="panelHeight:'auto'" style="width:110px;" name="serve.stype">   
					    <option value="投诉服务">投诉服务</option>   
					    <option value="售前服务">售前服务</option>   
					    <option value="售后服务">售后服务</option>   
					    <option value="咨询服务" selected="selected">咨询服务</option>     
					</select>  
				<span class="point_red">*</span></td>
			</tr>
			<tr>
				<td>服务客户：</td>
				<td>
					<input type="text" class="two_input" id="sclient" name="sclient"><span class="point_red">*</span>
					<span style="padding: 24px;"></span>联系电话：&nbsp;&nbsp;
					<input type="text" class="two_input" readonly="readonly" id="clientPhone" name="clientPhone"><span class="point_red">*</span>
				</td>
			</tr>
			<tr>
				<td>服务内容：</td>
				<td>
					<textarea cols="51" rows="5"  maxlength="250" name="scontent"></textarea>
				</td>
			</tr>
			<tr>
				<td>备注信息：</td>
				<td>
					<textarea cols="51" rows="5" maxlength="250" name="sremark"></textarea>
				</td>
			</tr>
		</table>
	</div>
	<script type="text/javascript" src="../js/servecreate.js"></script>
</body>
</html>