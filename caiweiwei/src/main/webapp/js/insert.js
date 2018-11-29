function adduser() {

console.log($("#formUser").serializeJSON())
	            $.ajax({
	            //几个参数需要注意一下
	                type: "POST",//方法类型
	                dataType: "json",//预期服务器返回的数据类型
	                url: "./userAdd" ,//url
	                data: $("#formUser").serializeJSON(),
	                success: function (result) {
	                    console.log(result);//打印服务端返回的数据(调试用)
	                        alert("SUCCESS");
	                },
	                error : function() {
	                    alert("异常！");
	                }
	            });
	}
