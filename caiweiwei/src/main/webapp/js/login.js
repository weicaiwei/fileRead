function fnLogin() {
 $("#error_box").empty();
  var isError = true;
 if ($("#uname").val().length > 20 || $("#uname").val().length < 6) {
  $("#error_box").html("用户名请输入6-20位字符");
  isError = false;
  return;
 }else if(($("#uname").val().charCodeAt(0)>=48) && ($("#uname").val().charCodeAt(0)<=57)){
	 $("#error_box").html("首字符必须为字母");
  return;
 }
 
 if ($("#upass").val().length > 20 || $("#upass").val().length < 1) {
	 $("#error_box").html("密码请输入1-20位字符");
	  isError = false;
  return;
 }

 $.ajax({
	 type: "POST",
     url: "./staff/checkLogin",
     data: $("#userform").serializeJSON(),
     dataType: "json",
     success: function(result,textStatus){ 
    	 console.log(result);
    	 if (result.status=="200"){
    	     if(result.data.role="staff"){
    		     window.location.href="main-personal.html";
    	     }else{
    	    	 window.location.href="main-admin.html"
    	     }
    	 }else{
        	 window.alert(result.message)
    	 }
     },
     error: function(data,textStatus){
    	 window.alert(textStatus)
     }  
 })

}