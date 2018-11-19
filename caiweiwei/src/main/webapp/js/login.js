function fnLogin() {
 $("#error_box").empty();
  var isError = true;
 if ($("input[name='user']").val().length > 20 || $("input[name='user']").val().length < 6) {
  $("#error_box").html("用户名请输入6-20位字符");
  isError = false;
  return;
 }else if(($("input[name='user']").val().charCodeAt(0)>=48) && ($("input[name='user']").val().charCodeAt(0)<=57)){
	 $("#error_box").html("首字符必须为字母");
  return;
 }else for(var i=0;i<$("input[name='user']").val().charCodeAt(i);i++){
  if(($("input[name='user']").val().charCodeAt(i)<48)||($("input[name='user']").val().charCodeAt(i)>57) && ($("input[name='user']").val().charCodeAt(i)<97)||($("input[name='user']").val().charCodeAt(i)>122)){
	  $("#error_box").html("必须为字母跟数字组成");
   return;
  }
 }
 if ($("input[name='password']").val().length > 20 || $("input[name='password']").val().length < 1) {
	 $("#error_box").html("密码请输入1-20位字符");
	  isError = false;
  return;
 }


}