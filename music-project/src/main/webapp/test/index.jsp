<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
</head>
<script src="http://localhost:8080/Test01_war_exploded/static/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script type="text/javascript">
    $(function () {
        //$(location).attr("href","skip/skip.jsp")
    })
</script>
<html>
<body>
<div align="center">
    <h1>测试页面！</h1>
    <form action="Test" method="post">
        <input type="text" name="name">
        <input type="submit" value="提交">
    </form>
</div>
</body>
</html>