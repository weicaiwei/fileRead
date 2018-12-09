$().ready(function(){
	$.get("staffinfo",function(result,status){
	    $("#staffName").html(result.data.staffName);		
	    $("#staffId").html(result.data.staffId);		
	    $("#age").html(result.data.age);
	    if (result.data.sex=="0"){
		    $("#sex").html("女");
	    }else{
	    	$("#sex").html("男");
	    }
	    $("#birthday").html(result.data.birthday);
	 })
  }
) 
