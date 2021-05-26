<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--网站地址--%>
<%@include file="../pages/web-url.jsp" %>

<script src="<%=basePath%>static/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="<%=basePath%>static/plugins/bootstrap/js/bootstrap.min.js"></script>

<!-- 内容区域 -->
<div class="content-wrapper">

    <!-- 正文区域 -->
    <section class="content">
        <div class="row">
            <c:forEach items="${news}" var="news" varStatus="status">

                <div class="col-md-12">
                    <!-- Box Comment -->
                    <div class="box box-widget">
                        <div class="box-header with-border">
                            <div class="user-block">
                                <span class="username"><a href="<%=basePath%>newsDetail?newTitle=${news.newTitle}">${news.newTitle}</a></span>
                                <span class="description">发布时间:${news.upDate}</span>
                            </div>
                            <!-- /.user-block -->
                            <div class="box-tools">
                                <button type="button" class="btn btn-box-tool" data-toggle="tooltip"
                                        title="Mark as read">
                                    <i class="fa fa-circle-o"></i></button>
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                        class="fa fa-minus"></i>
                                </button>
                                <button type="button" class="btn btn-box-tool" data-widget="remove"><i
                                        class="fa fa-times"></i></button>
                            </div>
                            <!-- /.box-tools -->
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <!-- post text -->
                            <p>${news.newContext}</p>

                            <!-- Attachment -->
                            <div class="clearfix"  id="pic${status.count}">

                                <script>
                                    $(function () {
                                        //1.存储的图片字符串分割
                                        let pic = "${news.newImgUrl}"
                                        pic = pic.split("&*&")
                                        if(pic != ""){
                                            $("#pic${status.count}").append("<hr size='100px' />");
                                            for (let i = 0; i < pic.length; i++) {
                                                $("#pic${status.count}").append("<img class='attachment-img' " +
                                                    "style='margin-left:5px' " +
                                                    "src='<%=basePath%>" + pic[i] + "' />")
                                            }
                                        }
                                        else{
                                            $("#pic${status.count}").append("<div style='margin:100px' />")
                                        }

                                    })
                                </script>

                            </div>
                            <!-- /.attachment-block -->
                        </div>
                        <!-- /.box-footer -->
                    </div>
                    <!-- /.box -->
                </div>
                <!-- /.col -->

            </c:forEach>
        </div>
        <!-- /.row -->


    </section>
    <!-- 正文区域 /-->

</div>
<!-- 内容区域 /-->