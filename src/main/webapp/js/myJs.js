$(document).ready(function () {
    /*导航条点击效果*/
    $("#home").click(
        function () {
            $("#home_btn").css("color","black");
            $("#practice_btn").css("color","#808080");
            $("#contest_btn").css("color","#808080");
        }
    );
    $("#practice").click(
        function () {
            $("#practice_btn").css("color","black");
            $("#home_btn").css("color","#808080");
            $("#contest_btn").css("color","#808080");

        }
    );
    $("#contest").click(
        function () {
            $("#contest_btn").css("color","black");
            $("#practice_btn").css("color","#808080");
            $("#home_btn").css("color","#808080");

        }
    );
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




