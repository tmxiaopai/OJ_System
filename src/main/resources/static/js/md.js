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
    });
})