var file = function(){

    var buttonInit = function () {
        $("#uploadFile").on("click", function(){
            $("#fileUpload").modal();
            $("#fileUploadContent").initUpload({
                "uploadUrl": "/file/fileUpload",
                //上传文件信息地址
                //"progressUrl": "/file/getStatus",
                "filelSavePath": "test"
            });
            uploadFileList.fileList.splice(0, uploadFileList.fileList.length);
        });
    };
    
    return{
        init : function () {
            buttonInit();
        }
    }
    
}();