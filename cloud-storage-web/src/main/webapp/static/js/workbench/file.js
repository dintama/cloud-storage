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
        })
    };
    
    return{
        init : function () {
            buttonInit();
        }
    }
    
}();