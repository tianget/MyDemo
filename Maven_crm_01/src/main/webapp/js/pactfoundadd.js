/**
 * 
 */
function pactfoundCreate(){
	if(!$('#namep').validatebox('isValid')){
		$('#pname').focus();
	}else if(!$('#typep').validatebox('isValid')){
		$('#ptype').focus();
	}else if(!$('#moneyp').validatebox('isValid')){
		$('#pmoney').focus();
	}else if(!$('#jiap').validatebox('isValid')){
		$('#pjia').focus();
	}else if(!$('#yip').validatebox('isValid')){
		$('#pyi').focus();
	}else if(!$('#operatejiap').validatebox('isValid')){
		$('#poperatejia').focus();
	}else if(!$('#operateyip').validatebox('isValid')){
		$('#poperateyi').focus();
	}else if(!$('#contentp').validatebox('isValid')){
		$('#pcontent').focus();
	}else if(!$('#remarksp').validatebox('isValid')){
		$('#premarks').focus();
	}else{
		return true;
	}
	return false;
}