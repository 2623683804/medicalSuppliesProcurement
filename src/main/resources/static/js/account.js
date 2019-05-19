$(document).ready(function(){


  	$('#frxx').click(function(){
        if($("#pop-wrap").css('display')=='none'){
            $("#pop-wrap").css("display","block");
            $(".pop-mask").css("display","block");


        }else{
            $("#pop-wrap").css("display","none");
            $(".pop-mask").css("display","none");
        }
    });
    $("#right-wrap").click(function(){
	   $("#pop-wrap").css("display","none");
	   $(".pop-mask").css("display","none");
	});
	
	$('#qylxrxx').click(function(){
        if($("#pop-wrap1").css('display')=='none'){
            $("#pop-wrap1").css("display","block");
            $(".pop-mask").css("display","block");
        }else{
            $("#pop-wrap1").css("display","none");
            $(".pop-mask").css("display","none");
        }
    });
    $("#right-wrap1").click(function(){
	   $("#pop-wrap1").css("display","none");
	   $(".pop-mask").css("display","none");
	});
	
	
	$('#releaseYongHuBtn').click(function(){
        if($("#pop-wrap2").css('display')=='none'){
            $("#pop-wrap2").css("display","block");
            $(".pop-mask").css("display","block");
        }else{
            $("#pop-wrap2").css("display","none");
            $(".pop-mask").css("display","none");
        }
    });
    $("#right-wrap2").click(function(){
	   $("#pop-wrap2").css("display","none");
	   $(".pop-mask").css("display","none");
	});
	
	$('#releaseBankCardBtn').click(function(){
        if($("#pop-wrap3").css('display')=='none'){
            $("#pop-wrap3").css("display","block");
            $(".pop-mask").css("display","block");
        }else{
            $("#pop-wrap3").css("display","none");
            $(".pop-mask").css("display","none");
        }
    });
	
	$("#right-wrap3").click(function(){
		   $("#pop-wrap3").css("display","none");
		   $(".pop-mask").css("display","none");
		});
		
	$('#tjyyp').click(function(){
        if($("#pop-wrap4").css('display')=='none'){
            $("#pop-wrap4").css("display","block");
            $(".pop-mask").css("display","block");
        }else{
            $("#pop-wrap4").css("display","none");
            $(".pop-mask").css("display","none");
        }
    });

    $('.tjyyp1').click(function(){
        if($("#pop-wrap4").css('display')=='none'){

            $("#pop-wrap4").css("display","block");
            $(".pop-mask").css("display","block");
            $("#yid").attr("value",updateMed(a));

        }else{
            $("#pop-wrap4").css("display","none");
            $(".pop-mask").css("display","none");
        }
    });
	$("#right-wrap4").click(function(){
		   $("#pop-wrap4").css("display","none");
		   $(".pop-mask").css("display","none");
		});
		
		
	$('#xgcgxx').click(function(){
        if($("#pop-wrap5").css('display')=='none'){
            $("#pop-wrap5").css("display","block");
            $(".pop-mask").css("display","block");
        }else{
            $("#pop-wrap5").css("display","none");
            $(".pop-mask").css("display","none");
        }
    });
	
	$('#tjcgxx').click(function(){
        if($("#pop-wrap5").css('display')=='none'){
            $("#pop-wrap5").css("display","block");
            $(".pop-mask").css("display","block");
        }else{
            $("#pop-wrap5").css("display","none");
            $(".pop-mask").css("display","none");
        }
    });
	$("#right-wrap5").click(function(){
		   $("#pop-wrap5").css("display","none");
		   $(".pop-mask").css("display","none");
		});
	
	
	$('#glygl').click(function(){
        if($("#pop-wrap6").css('display')=='none'){
            $("#pop-wrap6").css("display","block");
            $(".pop-mask").css("display","block");
        }else{
            $("#pop-wrap6").css("display","none");
            $(".pop-mask").css("display","none");
        }
    });
	$("#right-wrap6").click(function(){
		   $("#pop-wrap6").css("display","none");
		   $(".pop-mask").css("display","none");
		});
		

	$('#glyxg').click(function(){
    if($("#pop-wrap6").css('display')=='none'){
        $("#pop-wrap6").css("display","block");
        $(".pop-mask").css("display","block");
    }else{
        $("#pop-wrap6").css("display","none");
        $(".pop-mask").css("display","none");
    }
    });
});
