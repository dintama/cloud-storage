var file = function(){

    var buttonInit = function () {
        $("#uploadFile").on("click", function(){

            /*$("#myModalLabel").empty();
            $("#myModalLabel").append("上传文件");

            $("#myModalBody").empty();
            $("#myModalBody").append('<div id="fileUploadContent" class="fileUploadContent"></div>');*/

            $("#fileUpload").modal();
            $("#fileUploadContent").initUpload({
                "uploadUrl": "/file/fileUpload",
                //上传文件信息地址
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
                dataType: "json",
                data: {
                    parentId: $("#pathId").val(),
                    fileName: $("#dirName").val()
                },
                type: "POST",
                async:false,
                success: function (res) {
                    $.msgUtil.successMsg("创建成功！", "");
                },
                error: function () {
                    $.msgUtil.errorMsg("创建失败！", "请刷新后重试。")
                }
            });
            $("#createDirModal").modal("hidden");
        });
    };
    
    return{
        init : function () {
            buttonInit();
        }
    }
    
}();