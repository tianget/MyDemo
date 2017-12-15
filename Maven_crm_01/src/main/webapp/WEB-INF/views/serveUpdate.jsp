<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div id="serve_look">
		<input type="hidden" name="sid" id="sid"> 
		<table class="serve_look_table">
			<tr>
				<td>服务名称：</td>
				<td>
				<input type="text" style="width: 375px;" id="sname" name="sname">
				</td>
			</tr>
			<tr>
				<td>服务类型：</td>
				<td>
					<input type="text" class="two_input" id="stype" name="stype">
					<span style="padding: 20px;"></span>服务状态：&nbsp;&nbsp;<input type="text" class="two_input" id="sstatus" name="sstatus">
				</td>
			</tr>
			<tr>
				<td>服务客户：</td>
				<td>
					<input type="text" class="two_input" id="sclient" name="sclient">
					<span style="padding: 20px;"></span>联系电话：&nbsp;&nbsp;<input type="text" class="two_input" id="clientPhone" name="clientPhone">
				</td>
			</tr>
			<tr>
				<td>&nbsp;&nbsp;&nbsp;创建人：</td>
				<td>
					<input type="text" class="two_input" id="screater" name="screater">
					<span style="padding: 20px;"></span>创建时间：&nbsp;&nbsp;<input type="text" class="two_input" id="screateTime" name="screateTime">
				</td>
			</tr>
			<tr>
				<td>待处理人：</td>
				<td><input type="text" name="sallot" ></td>
			</tr>
			<tr>
				<td>服务内容：</td>
				<td>
					<textarea cols="51" rows="3"  maxlength="250" name="scontent"></textarea>
				</td>
			</tr>
			<tr>
				<td>备注信息：</td>
				<td>
					<textarea cols="51" rows="3" maxlength="250" name="sremark"></textarea>
				</td>
			</tr>
		</table>
	</div>
	