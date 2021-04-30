<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../pages/web-url.jsp" %>
<html>
<head>

    <script src="<%=basePath%>static/plugins/jQuery/jquery-2.2.3.min.js"></script>
    <script src="<%=basePath%>static/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=basePath%>static/plugins/base64/base64.js"></script>

    <script>
        $(function () {
            ajaxShowCourses()
            //Tab键排版
            $("textarea").on(
                'keydown',
                function (e) {
                    if (e.keyCode == 9) {
                        e.preventDefault();
                        var indent = '       ';
                        var start = this.selectionStart;
                        var end = this.selectionEnd;
                        var selected = window.getSelection().toString();
                        selected = indent + selected.replace(/\n/g, '\n' + indent);
                        this.value = this.value.substring(0, start) + selected
                            + this.value.substring(end);
                        this.setSelectionRange(start + indent.length, start
                            + selected.length);
                    }
                }
            )
        })

        function ajaxShowCourses() {
            $.ajax({
                url: "addWork/showCourses",
                type: "post",
                async: false,
                success: function (rep) {
                    $.each(rep, function (i, res) {
                        $("#selected").append("<option value=" + res.courseId + ">" + res.courseName + "</option>")
                    })
                }
            })
        }
        var indexBig = 0;
        var pageSizeBig = 9;
        function ajaxShowForumTitle() {
            var courseId = $('#selected').val()
            //console.log(courseId)
            $.ajax({
                url:'showQueIdByCid',
                data:{
                    cId:courseId,
                    index:indexBig,
                    pageSize:pageSizeBig
                },
                dataType:'json',
                type:'post',
                success:function (response) {
                    $.each(response,function (i,res) {
                        $.ajax({
                            url:'showQuestion',
                            type:'post',
                            dataType:'json',
                            data:{
                                cId:courseId,
                                qId:res,
                                indexAnswer:0,
                                answerPageSize:0
                            },
                            success:function (resp) {
                                $('#thisContent').empty()
                                $.each(resp,function (i,res) {
                                    $('#thisContent').append("<div class=\"post\">\n" +
                                        "                            <div>\n" +
                                        "                                <span class=\"username\">\n" +
                                        "                                <a style=\"font-size: 20px;\" href=\"\">\n" +
                                        "                                 "+res.context+"   \n" +
                                        "                                </a>\n" +
                                        "                                </span>\n" +
                                        "                                <br/>\n" +
                                        "                                <span class=\"description\" style=\"font-size: 10px;color: #8a8a8a\">发布时间：</span>\n" +
                                        "                            </div>\n" +
                                        "                            <p>\n" +
                                        "                              "+res.forumAnswer.answer+"  \n" +
                                        "                            </p>\n" +
                                        "                        </div>")
                                })
                                console.log(resp)
                            }
                        })
                    })
                }
            })
        }
    </script>
    <style>
        a:hover {
            color: #c800ff
        }
    </style>
</head>
<body>
<div class="content-wrapper">
    <!-- 内容头部 -->
    <section class="content-header">
        <h1>
            ${sessionScope.tName}
            <small>(教师)</small>
        </h1>
    </section>

    <section class="content">
        <div class="nav-tabs-custom">
            <ul class="nav nav-tabs">
                <li class="active"><a href="#activity" data-toggle="tab">教师论坛</a></li>
            </ul>

            <div class="tab-content">
                <div class="active tab-pane" id="activity">
                    <div class="form-group">
                        <label style="color: #0d6aad"><h4>选择课程</h4></label>
                        <%-- <select size="20" style="width:200px;font-size:12px" multiple>--%>
                        <select class="form-control" style="width:300px;height:35px;font-size:16px;" id="selected"
                                onchange="ajaxShowForumTitle()">
                        </select>
                        <br>
                        <div class="row">
                            <form class="navbar-form navbar-left">
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="标题搜索" name="doSearch">
                                </div>
                                <button type="button" class="btn btn-default" onclick="KnowSearch()">搜索一下</button>
                            </form>
                        </div>
                        <div class="row" style="padding: 15px">
                            <ul class="pagination pagination-sm inline" id="publishedPages">
                            </ul>
                        </div>
                    </div>
                    <hr/>
                    <!-- Post -->
                    <div id="thisContent">
                        <div class="post">
                            <div>
                                <span class="username">
                                <a style="font-size: 20px;" href="">

                                </a>
                                </span>
                                <br/>
                                <span class="description" style="font-size: 10px;color: #8a8a8a">发布时间：</span>
                            </div>
                            <p>

                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </section>
</div>
</body>
</html>
