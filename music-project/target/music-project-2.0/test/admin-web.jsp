<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../pages/web-url.jsp" %>
<script src="<%=basePath%>static/plugins/bootstrap/js/bootstrap.min.js"></script>
<div align="center">
    <div class="form-group">
        <label for="email" class="col-sm-2 control-label">所属角色</label>
        <div class="col-sm-6">
            <!-- 样式1 -->
            <select class="form-control">
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
            </select>
            <!-- 样式2 -->
            <!--<div class="btn-group dropdown" id="dropdown">
              <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                超级管理员 <span class="caret"></span>
              </button>
              <input type="hidden" name="hidedrop_1" id="hidedrop_1" value="超级管理员" />
              <ul class="dropdown-menu">
                <li><a href="#">超级管理员</a></li>
                <li role="separator" class="divider"></li>
                <li><a href="#">设计总监</a></li>
                <li role="separator" class="divider"></li>
                <li><a href="#">运维人员</a></li>
                <li role="separator" class="divider"></li>
                <li><a href="#">发布人员</a></li>
              </ul>
            </div>-->

        </div>
        <div class="col-sm-4 tips"></div>
    </div>

    <h1>
        <button type="submit" class="btn btn-primary btn-block btn-flat">注册</button>
    </h1>
</div>
