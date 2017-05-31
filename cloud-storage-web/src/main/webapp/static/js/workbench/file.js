var file = function(){

    var buttonInit = function () {
        $("#uploadFile").on("click", function(){
            $("#fileUpload").modal();
            $("#fileUploadContent").initUpload({
                "uploadUrl": "/file/fileUpload",
                //"progressUrl": "/file/getStatus",
                "filelSavePath": "test"
            });
            uploadFileList.fileList.splice(0, uploadFileList.fileList.length);
        });

        $("#createDir").on("click", function(){
            $("#createDirModal").modal("show");
        });

        $("#confirmCreateDir").on("click", function () {
            $.ajax({
                url: "file/createDir",
                data: {
                    parentId: $("#pathId").val(),
                    fileName: $("#dirName").val()
                },
                type: "POST",
                async:false,
                success: function () {
                    $.msgUtil.successMsg("创建文件夹成功！", "");
                },
                error: function () {
                    $.msgUtil.errorMsg("创建失败！", "请刷新后重试。")
                }
            });
            $("#createDirModal").modal("hide");
            getFileList($("#pathId").val());
        });
        $("#confirmRenameDir").on("click", function () {
            $.ajax({
                url: "file/renameDir",
                data: {
                    id: $("#reDirId").val(),
                    fileName: $("#reDirName").val()
                },
                type: "POST",
                async:false,
                success: function () {
                    $.msgUtil.successMsg("重命名文件夹成功！", "");
                },
                error: function () {
                    $.msgUtil.errorMsg("重命名失败！", "请刷新后重试。")
                }
            });
            $("#renameDirModal").modal("hide");
            getFileList($("#pathId").val());
        });
    };

    var getFileList = function (parentId) {

        $("#pathId").val(parentId);

        $.ajax({
            url: "file/listPage",
            dataType: "json",
            data: {
                parentId: parentId
            },
            type: "POST",
            async:false,
            success: function (res) {
                var result = '';

                $.each(res, function (index, context) {
                    if(context.fileType === 0){ //文件夹
                        result += '<tr><th><div id="'+ context.id +'">' +
                            '<a href="#" onclick="file.getFileListPage('+ context.id +')">' +
                            '<i class="fa fa-folder">'+ context.fileName +'</i></a>' +
                            '</div></th>';
                        result += '<th></th>' +
                            '<th>'+ $.timeUtil.UnixToDate(context.lastUpdateTime, true, 8) +'</th>';
                        result += '<th><div class="btn-group">' +
                            '<button class="btn btn-default" onclick="file.shareFile('+ context.id +')">分享</button>' +
                            '<button class="btn btn-default" onclick="file.renameFile('+ context.id +', \''+ context.fileName +'\')">重命名</button>' +
                            '<button class="btn btn-default" onclick="file.deleteFile('+ context.id +')">删除</button></div></th></tr>';
                    }else{
                        result += '<tr><th><div id="'+ context.id +'">' +
                            '<i class="fa fa-file">'+ context.fileName +'</i>' +
                            '</div></th>';
                        result += '<th>'+ context.fileSize +'M</th>' +
                            '<th>'+ $.timeUtil.UnixToDate(context.lastUpdateTime, true, 8) +'</th>';
                        result += '<th><div class="btn-group">' +
                            '<button class="btn btn-default" onclick="file.downloadFile('+ context.id +')">下载</button>' +
                            '<button class="btn btn-default" onclick="file.shareFile('+ context.id +')">分享</button>' +
                            '<button class="btn btn-default" onclick="file.deleteFile('+ context.id +')">删除</button></div></th></tr>'
                    }
                });

                $("#fileTable").empty();
                $("#fileTable").append(result);
            },
            error: function () {
                $.msgUtil.errorMsg("文件查询失败！", "请刷新后重试。")
            }
        });
    };


    return{
        init : function () {
            buttonInit();
            getFileList(-1);
        },
        getFileListPage : function (parentId) {
            getFileList(parentId);
        },
        renameFile : function (fileId, fileName) {
            $("#reDirName").val(fileName);
            $("#reDirId").val(fileId);
            $("#renameDirModal").modal("show");
        },
        shareFile: function(fileId){
            alert("分享单个文件");
        },
        deleteFile: function (fileId) {
            $.ajax({
                url: "file/delete",
                data: {
                    id: fileId
                },
                async:false,
                type: "POST",
                success: function (res) {
                    $.msgUtil.successMsg("删除成功！", "");
                },
                error: function(){
                    $.msgUtil.errorMsg("删除失败！", "请刷新后再试");
                }
            });
            getFileList($("#pathId").val());
        },
        downloadFile: function (fileId) {
            alert("下载单个文件");
        }
    }
    
}();