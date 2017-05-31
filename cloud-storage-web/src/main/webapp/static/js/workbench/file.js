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
                dataType: "json",
                data: {
                    parentId: $("#pathId").val(),
                    fileName: $("#dirName").val()
                },
                type: "POST",
                async:false,
                success: function (res) {
                    $.msgUtil.successMsg("创建文件夹成功！", "");
                },
                error: function () {
                    $.msgUtil.errorMsg("创建失败！", "请刷新后重试。")
                }
            });
            $("#createDirModal").modal("hidden");
        });
    };

    var getFileList = function (parentId) {
        $.ajax({
            url: "file/listPage",
            dataType: "json",
            data: {
                parentId: parentId
            },
            type: "POST",
            async:false,
            success: function (res) {
                alert("success");
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
        }
    }
    
}();