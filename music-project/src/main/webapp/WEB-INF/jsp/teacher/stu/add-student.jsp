<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--网站地址--%>
<%@include file="../../pages/web-url.jsp" %>

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
                <p class="login-box-msg">添加学生</p>

                <form method="post" id="form1">
                    <div class="form-group has-feedback">
                        <input type="text" class="form-control" placeholder="姓名" name="sRegName">
                        <span class="glyphicon glyphicon-user form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="text" class="form-control" placeholder="学号" name="sRegNumber">
                        <span class="glyphicon glyphicon-pencil form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="password" class="form-control" placeholder="密码" name="sRegPwd">
                        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="password" class="form-control" placeholder="确认密码" name="sRegPwd2">
                        <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
                    </div>
                    <div class="row">
                        <div class="col-xs-4">
                            <button type="button" class="btn btn-primary btn-block btn-flat" id="sub">注册</button>
                        </div>
                    </div>
                </form>
            </div>
            <!-- /.form-box -->
        </div>
    </section>
    <!-- 正文区域 /-->
</div>
<script src="<%=basePath%>static/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script type="text/javascript">
    $(function () {
        check()
    })

    function check() {
        $("#sub").click(function () {
            uName = $("input[name = 'sRegName']").val()
            uNumber = $("input[name = 'sRegNumber']").val()
            uPwd = $("input[name = 'sRegPwd']").val()
            uPwd2 = $("input[name = 'sRegPwd2']").val()
            if (uName == '' || uPwd == '' || uPwd2 == '' || uNumber == '') {
                alert("请填写完整信息！")
                return false
            } else if (uPwd != uPwd2) {
                alert("两次输入密码不一致！")
                $("input[name = 'sRegPwd']").val('')
                $("input[name = 'sRegPwd2']").val('')
                return false
            } else
                ajax()
        })
    }

    function ajax() {
        $.ajax({
            url: "regStudent",
            data: $("#form1").serialize(),
            dataType: "text",
            type: "post",
            success: function (rep) {
                //alert($("#form1").serialize())
                alert(rep)
            }
        })
        $("input[name = 'sRegName']").val('')
        $("input[name = 'sRegNumber']").val('')
        $("input[name = 'sRegPwd']").val('')
        $("input[name = 'sRegPwd2']").val('')
    }
</script>