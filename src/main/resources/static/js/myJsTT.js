$(document).ready(function () {
    /*导航条点击效果*/
    $("#home").click(
        function () {
            $("#home_btn").css("color","black");
            $("#subject_btn").css("color","#808080");
            $("#contest_btn").css("color","#808080");
            $("#notice_btn").css("color","#808080");
            $("#user_btn").css("color","#808080");
        }
    );
    $("#subject").click(
        function () {
            $("#subject_btn").css("color","black");
            $("#home_btn").css("color","#808080");
            $("#contest_btn").css("color","#808080");
			$("#notice_btn").css("color","#808080");
			$("#user_btn").css("color","#808080");
        }
    );
    $("#contest").click(
        function () {
            $("#contest_btn").css("color","black");
            $("#subject_btn").css("color","#808080");
            $("#home_btn").css("color","#808080");
			$("#notice_btn").css("color","#808080");
			$("#user_btn").css("color","#808080");
        }
    );
    $("#notice").click(
    	function(){
    		$("#notice_btn").css("color","black");
    		$("#contest_btn").css("color","#808080");
    		$("#home_btn").css("color","#808080");
    		$("#subject_btn").css("color","#808080");
    		$("#user_btn").css("color","#808080");
    	}
    );
    $("#user").click(
    	function(){
    		$("#user_btn").css("color","black");
    		$("#contest_btn").css("color","#808080");
    		$("#subject_btn").css("color","#808080");
    		$("#home_btn").css("color","#808080");
    		$("#notice_btn").css("color","#808080");
    	}
    )
    /*左导航点击效果*/
    $(".bottomli").click(
        function () {
            $(".topli").css("background-color","#ffffff");
            $(".bottomli").css("background-color","#eeeeee");
            $(".secondli").css("background-color","#ffffff");
            $(".thirdli").css("background-color","#ffffff");
        }
    );
    $(".topli").click(
        function () {
            $(".topli").css("background-color","#eeeeee");
            $(".bottomli").css("background-color","#ffffff");
            $(".secondli").css("background-color","#ffffff");
            $(".thirdli").css("background-color","#ffffff");
        }
    );
    $(".secondli").click(
        function () {
            $(".topli").css("background-color","#ffffff");
            $(".bottomli").css("background-color","#ffffff");
            $(".secondli").css("background-color","#eeeeee");
            $(".thirdli").css("background-color","#ffffff");
        }
    );
    $(".thirdli").click(
        function () {
            $(".topli").css("background-color","#ffffff");
            $(".bottomli").css("background-color","#ffffff");
            $(".secondli").css("background-color","#ffffff");
            $(".thirdli").css("background-color","#eeeeee");
        }
    );
})

//对md文件的支持
$(document).ready(function () {
    $("#faqcontent").html('<textarea id="faq" style="display:none;"></textarea>');
    var content=null;
    $.get("static/FAQ.md",function (data,status) {
        content=data;
        $("#faq").val(content);
        editormd.markdownToHTML("faqcontent", {
            htmlDecode: "style,script,iframe", //可以过滤标签解码
            emoji: true,
            taskList:true,
            tex: true,               // 默认不解析
            flowChart:true,         // 默认不解析
            sequenceDiagram:true,  // 默认不解析
        });
    })
})


