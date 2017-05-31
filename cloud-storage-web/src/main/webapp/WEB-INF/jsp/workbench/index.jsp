<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cloud storage</title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width">
    <%@ include file="../include/includes.jsp" %>
    <script src="/static/js/login/login.js"></script>
    <script src="/static/js/workbench/file.js"></script>
</head>

<div id="alertBox" class="text-center" style="position: absolute; z-index: 5555; right:20px; top:20px;"></div>

<input id="pathId" type="text" hidden="hidden" value="-1">

<div class="navbar navbar-inverse" role="navigation" style="margin-bottom: 0px;">
    <div class="navbar-header">
        <div class="logo"><h1>Cloud Storage</h1></div>
    </div>
    <div class="pull-right" style="border-top-width: 20px; margin-top: 12px;margin-right: 20px;">
        <a href="/logout">
            <span id="nick">${nickname}</span>
            <i class="fa fa-sign-out"></i>
        </a>
    </div>
</div>

<div class="template-page-wrapper">
    <div class="navbar-collapse collapse templatemo-sidebar" style="padding-left: 0px;margin-top: 0px; width: 230px;padding-right: 0px;">
        <ul class="templatemo-sidebar-menu">
            <li class="active" onclick="file.init()"><a href="#"><i class="fa fa-book"></i>全部文件
                <div class="pull-right"></div>
            </a></li>
            <li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;图片</a></li>
            <li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;视频</a></li>
            <li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;文档</a></li>
            <li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;种子</a></li>
            <li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;音乐</a></li>
            <li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;其他</a></li>
        </ul>
    </div>
    <!--/.navbar-collapse -->

    <div class="templatemo-content-wrapper">
        <div class="templatemo-content" style="height: 100%;">

            <h3>
                CloudStorage
                <small>云存储</small>
            </h3>

            <ol class="breadcrumb">
                <li class="active">全部文件</li>
            </ol>

            <div class="row col-md-12">
                <button type="button" id="uploadFile" class="btn btn-info"><i class="fa fa-upload"></i>&nbsp;上传文件</button>
                <button type="button" id="createDir" class="btn btn-default"><i class="fa fa-folder-o"></i>&nbsp;新建文件夹</button>
            </div>


            <div>
                <div class="row">
                    <div class="col-md-12">
                        <table class="table">
                            <thead>
                            <tr>
                                <th>文件名</th>
                                <th>大小</th>
                                <th>修改日期</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody id="fileTable">
                            <tr>
                                <th><a href="#" onclick=""><i class="fa fa-folder">haha</i></a></th>
                                <th>3M</th>
                                <th>2017年05月31日14:37:41</th>
                                <th><div class="btn-group"><button class="btn btn-default">分享</button><button class="btn btn-default">重命名</button><button class="btn btn-default">删除</button></div></th>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<!-- 模态框 文件上传 -->
<div class="modal fade" id="fileUpload" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="width:900px">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">上传文件</h4>
            </div>
            <div class="modal-body">
                <div id="fileUploadContent" class="fileUploadContent"></div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button id="confirmUpload" type="button" class="btn btn-info" >确认上传</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>


<!-- 模态框 新增文件夹 -->
<div class="modal fade" id="createDirModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="width:350px">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">新建文件夹</h4>
            </div>
            <div class="modal-body">
                <div class="center-block">
                    文件夹名称:&nbsp;&nbsp;&nbsp;
                    <input type="text" id="dirName" value="新建文件夹">
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button id="confirmCreateDir" type="button" class="btn btn-info" >确认</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>


</body>
</html>

<script>
    $(function () {
       file.init();
    });
</script>
