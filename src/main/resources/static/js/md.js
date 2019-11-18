//对md文件的支持
$(document).ready(function () {
    $("#faqcontent").html('<textarea id="faq" style="display:none;"></textarea>');
    var content=null;
    $.get("classpath:FAQ.md",function (data,status) {
        content=data;
        alert("data"+data)
        alert("content"+content)
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
    $("#subjectitem").html('<textarea id="faqq" style="display:none;"></textarea>');
    var content1=null;
    $.get("classpath:static/1682.md",function (data,status) {
        content1=data;
        $("#faqq").val(content1);
        editormd.markdownToHTML("subjectitem", {
            htmlDecode: "style,script,iframe", //可以过滤标签解码
            emoji: true,
            taskList:true,
            tex: true,               // 默认不解析
            flowChart:true,         // 默认不解析
            sequenceDiagram:true,  // 默认不解析
        });
    })
})