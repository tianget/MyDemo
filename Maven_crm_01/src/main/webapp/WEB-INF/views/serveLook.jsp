<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div id="serve_look">
				<p style="font-weight: normal;font-size:12px;margin-top:20px;margin-bottom: 0;padding-bottom:0;">&nbsp;&nbsp;&nbsp;服务管理>> 服务创建>> 查看服务</p>
		<table class="serve_look_table" style="padding-top:0;">
			<tr>
				<td class="look_right">服务名称：</td>
				<td><input type="text" name="sname" style="width:275px;"> </td>
			</tr>
			<tr>
				<td class="look_right">服务类型：</td>
				<td><input type="text" name="stype" ></td>
			</tr>
			<tr>
				<td class="look_right">服务状态：</td>
				<td><input type="text" name="sstatus" ></td>
			</tr>
			<tr>
				<td class="look_right">客户：</td>
				<td><input type="text" name="sclient" ></td>
			</tr>
			<tr>
				<td class="look_right">客户联系电话：</td>
				<td><input type="text" name="clientPhone" ></td>
			</tr>
			<tr>
				<td class="look_right">服务内容：</td>
				<td>
					<textarea cols="45" rows="3" name="scontent"></textarea>
				</td>
			</tr>
			<tr>
				<td class="look_right">操作人：</td>
				<td><input type="text" name="shandler" ></td>
			</tr>
			<tr>
				<td class="look_right">创建时间：</td>
				<td><input type="text" name="screateTime" ></td>
			</tr>
			<tr>
				<td class="look_right">处理人：</td>
				<td><input type="text" name="sallot" ></td>
			</tr>
			<tr>
				<td class="look_right">备注信息:</td>
				<td>
					<textarea cols="45" rows="3" name="sremark"></textarea>
				</td>
			</tr>
			<tr>
				<td class="look_right">创建人：</td>
				<td><input type="text" name="screater" ></td>
			</tr>
			<tr>
				<td class="look_right">最后操作时间：</td>
				<td><input type="text" name="slastTime" ></td>
			</tr>
			<tr>
				<td class="look_right">处理结果:</td>
				<td>
					<input type="text" name="handleResult" >
				</td>
			</tr>
			<tr>
				<td class="look_right">处理说明:</td>
				<td>
					<textarea cols="45" rows="3" name="handleExplain"></textarea>
				</td>
			</tr>
			<tr>
				<td class="look_right">反馈结果:</td>
				<td><input type="text" name="ticklingResult" ></td>
			</tr>
			<tr>
				<td class="look_right">反馈说明:</td>
				<td>
					<textarea cols="45" rows="3" name="ticklingExplain"></textarea>
				</td>
			</tr>
		</table>
		<!-- <p class="a_slide" id="gengduo" style="text-align:center;"><a href="javascript:lookgengduo()">查看更多信息</a></p> -->
		<!-- <table id="look_gengduo" style="display:block;">
			
			<tr>
				<td colspan="2" style="text-align:center;"><p class="a_slide" id="shouqi"><a href="javascript:shouqi()">收起</a></p></td>
			</tr>
		</table> -->
		
	</div>
