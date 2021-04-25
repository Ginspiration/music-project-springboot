<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--网站地址--%>
<%@include file="../../pages/web-url.jsp" %>
<html>
<head>
    <script src="<%=basePath%>static/plugins/jQuery/jquery-2.2.3.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#subAble").click(function () {
                check()
            })
            $("#subDisable").click(function () {
                check2()
            })
        })

        function check() {
            var msg = $("input[name='seekId']").val()
            if (msg == '') {
                alert("请填写完整信息！")
                return false
            } else
                ajaxAble()
        }

        function check2() {
            var msg = $("input[name='seekId2']").val()
            if (msg == '') {
                alert("请填写完整信息！")
                return false
            } else
                ajaxDisable()
        }

        function ajaxAble() {
            var Id = $("input[name='seekId']").val()
            $.ajax({
                url: "ableStudent",
                type: "post",
                dataType: "text",
                data: {
                    seekId: Id
                },
                success: function (rep) {
                    alert(rep)
                }
            })
        }

        function ajaxDisable() {
            var Id = $("input[name='seekId2']").val()
            $.ajax({
                url: "disableStudent",
                type: "post",
                dataType: "text",
                data: {
                    seekId: Id
                },
                success: function (rep) {
                    alert(rep)
                }
            })
        }


    </script>
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

    <!-- 正文区域 -->
    <section class="content">
        <div class="register-box">
            <div class="register-box-body">
                <p class="login-box-msg">启用学生</p>

                <form id="formAble" method="post">
                    <div class="form-group has-feedback">
                        <input type="text" class="form-control" placeholder="输入要启用的学号" name="seekId">
                        <span class="glyphicon glyphicon-pencil form-control-feedback"></span>
                    </div>
                    <div class="row">
                        <div class="col-xs-4">
                            <button type="button" class="btn btn-primary btn-block btn-flat" id="subAble">提交</button>
                        </div>
                    </div>
                </form>
            </div>
            <!-- /.form-box -->
        </div>
        <div class="register-box">
            <div class="register-box-body">
                <p class="login-box-msg">禁用学生</p>

                <form id="formDisable" method="post">
                    <div class="form-group has-feedback">
                        <input type="text" class="form-control" placeholder="输入要禁用的学号" name="seekId2">
                        <span class="glyphicon glyphicon-pencil form-control-feedback"></span>
                    </div>
                    <div class="row">
                        <div class="col-xs-4">
                            <button type="button" class="btn btn-primary btn-block btn-flat" id="subDisable">提交</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </section>
    <!-- 正文区域 /-->
</div>
</body>
</html>