<%@include file="../../pages/web-url.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<script>
    <%--检查标题是否为空--%>
    function checkTitleNull(){
        let title = $("#title").val();
        if ( title == "" ){
            $("#titleInfo").css("color", "red");
            $("#titleInfo").html("标题不能为空");

        }
    }

    /*通过提交按钮执行提交函数*/
    function dosubmit() {

        var thisData = new FormData();
        let marked

        //判断推荐新闻mark是否选中
        if($('#mark').is(':checked')) {
            // 不设置，默认值为marked
            marked = "marked"
        }else{
            //设false
            marked = "false"
        }

        let title = $("#title").val();
        //若标题不为空，则进行提交处理
        if ( title == "" ) {
            alert("标题不能为空");
        }
        else{
            let thisFiles = $('#file')
            //1、遍历所有文件，查看文件类型
            for (let i = 0; i < thisFiles[0].files.length; i++) {
                //最后出现'.'处的索引
                let index = thisFiles[0].files[i].name.lastIndexOf(".");
                //往后截取
                let fileName = thisFiles[0].files[i].name.substring(index + 1);
                //获取文件后缀名
                console.log(fileName)
            }
            //2、将文件放入formDate()
            for (let i = 0; i < thisFiles[0].files.length; i++) {
                thisData.append("files",thisFiles[0].files[i])
            }
            //3、将其他类型的数据放入formDate
            console.log($("#mark").val())
            thisData.append("title",$("input[name='title']").val())
            thisData.append("context",$("textarea[name='context']").val())
            thisData.append("marked",marked)

            //sleep
            console.log(thisData)
            // 4、ajax提交文件给后端
            $.ajax({
                url:'addNews',
                type: 'post',
                data: thisData,
                dataType: 'text',
                cache: false,
                //async: false,
                //不处理数据
                processData: false,
                //不设置内容类型
                contentType: false,
                success: function (data) {
                    if ( data == 1000){
                        alert("添加成功")
                    }else if(data == 1001){
                        alert("文件上传失败")
                    }else if(data == 1002){
                        alert("标题重复")
                        title = "";
                    }
                }
            })

        }
    }


</script>

<div class="content-wrapper">
    <!-- 内容头部 -->
    <section class="content-header">
        <h1>
            ${sessionScope.tName}
            <small>(教师)</small>
        </h1>
    </section>

    <%--    </section>--%>
    <section class="content">
        <br/><br/>
        <div class="box-body">
            <div class="form-group">
                <div class="form-group">
                    <form action="" role="form" id="formNews"  method="post" enctype="multipart/form-data">
                        <label>新闻标题</label>
                        <input type="text" class="form-control" name="title" onblur="checkTitleNull()"><span id="titleInfo"></span><br/>
                        <label>新闻内容</label>

                        <%--新闻内容输入框--%>
                        <div class="box">
                            <div class="box-header">
                                <!-- tools box -->
                                <div class="pull-right box-tools">
                                    <button type="button" class="btn btn-default btn-sm" data-widget="collapse" data-toggle="tooltip"
                                            title="Collapse">
                                        <i class="fa fa-minus"></i></button>
                                    <button type="button" class="btn btn-default btn-sm" data-widget="remove" data-toggle="tooltip"
                                            title="Remove">
                                        <i class="fa fa-times"></i></button>
                                </div>
                                <!-- /. tools -->
                            </div>
                            <!-- /.box-header -->
                            <div class="box-body pad">
                                        <textarea  name="context" class="textarea" placeholder="Place some text here"
                                                   style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>
                            </div>
                        </div>
                        <label>图片添加</label>
                        <input type="file" onclick="" multiple="multiple" id="file"/><br/>
                        <input type="button" name="addfile" onclick="addfile()" value="添加更多图片(未完成）"/>
                        <label class="checkbox-inline">
                            <input type="checkbox" id="mark" value="marked"> 标记为推荐新闻   <%--值有误--%>
                        </label>
                        <br>
                        <br>
                        <div class="container mt-5 mb-5" style="">
                            <input type="button" class="btn btn-success" id="toast" onclick="dosubmit()" value="提交新闻"></input>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
</div>