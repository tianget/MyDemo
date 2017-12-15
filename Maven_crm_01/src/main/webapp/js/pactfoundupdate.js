/**
 * 
 */
$("#pactfoundupdate").click(function(){
	var pname = $("#pname").val();
	var ptype =$("#ptype").val();
	var pmoney =$("#pmoney").val();
	var pjia =$("#pjia").val();
	var pyi =$("#pyi").val();
	var poperatejia =$("#poperatejia").val();
	var poperateyi =$("#poperateyi").val();
	var pcontent =$("#pcontent").val();
	var premarks =$("#premarks").val();
 	$.ajax({  
		url:"../pact/pfoundupdate",
		type:"post",
		data:{
			"pname":pname,
			"ptype":ptype,
			"pmoney":pmoney,
			"pjia":pjia,
			"pyi":pyi,
			"poperatejia":poperatejia,
			"poperateyi":poperateyi,
			"pcontent":pcontent,
			"premarks":premarks,
		},
 		success:function(result){
 			if(result==true){
 				alert("修改成功");
 			}else{
 				alert("修改失败");
 			}
 		}
	})
})