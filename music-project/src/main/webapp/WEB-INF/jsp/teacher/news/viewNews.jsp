<%@include file="../../pages/web-url.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>



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
            <div class="tab-content">
                <div class="active tab-pane" id="activity">
                    <div class="form-group">
                        <label style="color: #0d6aad"><h4>新闻列表</h4></label>
                        <%-- <select size="20" style="width:200px;font-size:12px" multiple>--%>
                        <br>

                        <%--标题搜索功能--%>
                        <div class="container-fluid">
                            <div class="row" >
                                <div class="col-4">
                                    <form class="navbar-form navbar-left">
                                        <div class="form-group" >
                                            <input type="text"  class="form-control" placeholder="标题搜索" name="doSearch">
                                        </div>
                                        <button type="button"  class="btn btn-default" onclick="ajaxShowForumTitle('findQueIdByCid')">搜索一下</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>

                    <%--新闻展示--%>
                    <c:forEach items="${news}" var="news">
                        <div class="panel panel-default">
                            <div class="panel-body" style="">
                                <%--展示标题--%>
                                <a href="" >${news.newTitle} </a>
                                    <a href="" class="btn btn-danger" style="float: right;margin-left: 10px">删除</a>
                                    <a href="" class="btn btn-danger" style="float: right">修改</a>
                                <%--展示发布时间--%>
                                <span style="font-size: 10px;
                                color:#8a8a8a;
                                float:right;
                                position: relative;
                                right: 10px;top : 30px;">发布时间:${news.upDate}</span>

                            </div>
                        </div>
                    </c:forEach>

                    <hr/>
                    <!-- Post -->
                    <div id="thisContent">
                        <%--<div class="post">
                            <div>
                                <span class="username">
                                <a style="font-size: 20px;" href="">

                                </a>
                                </span>
                                <br/>
                                <span class="description col-sm-12" style="font-size: 10px;color: #8a8a8a">发布时间：</span>
                            </div>
                            <p>

                            </p>
                        </div>--%>
                    </div>
                </div>
            </div>
        </div>

    </section>


</div>

<script>

    //输出新闻
    window.onload=function () {

    }

</script>