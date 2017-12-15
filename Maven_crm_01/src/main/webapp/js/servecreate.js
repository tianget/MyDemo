/**
 * 
 */
$(function(){
	
	$('#sname').validatebox({
		required : true,
		missingMessage : '请输入服务名称',
	});
	
	$('#sclient').validatebox({
		required : true,
		missingMessage : '请输入服务客户',
	});
	
	/*$('#clientPhone').validatebox({
		required : true,
		validType : 'checkphone',
		missingMessage : '请输入联系电话',
	});   */
	
	$('#qtitle').validatebox({
		required : true,
		missingMessage : '请输入问题标题',
	});
	
	$.extend($.fn.validatebox.defaults.rules, {
		// 联系方式
		checkphone : {
			validator : function(value) {
				var regphone = /^[1][0-9]{10}$/;
				return regphone.test(value);
			},
			message : '电话格式不正确'
		}
	});
	
	$("#sclient").combobox({
		valueField: 'mid',    
        textField: 'name', 
        required : true,
        missingMessage : '请选择客户',
        editable : false,// 不可编辑，只能选择
        panelHeight:'auto',
        url: '../serve/getAllClient',    
        onSelect: function(rec){    
            //var url = '../serve/getClientPhone?mid='+rec.mid;   
        	$('#sclientPhone').val('');
            $.ajax({
            	url:"../serve/getClientPhone",
            	data:{
            		mid:rec.mid
            	},
            	success:function(data){
            		$('#clientPhone').val(data.phone);
            	}
            })  
        }
	});
});

function checkServeCreate(){
	if(!$('#sname').validatebox('isValid')){
		$('#sname').focus();
	}else if(!$('#sclient').validatebox('isValid')){
		$('#sclient').focus();
	}else if(!$('#clientPhone').validatebox('isValid')){
		$('#clientPhone').focus();
	}else{
		return true;
	}
	return false;
}

