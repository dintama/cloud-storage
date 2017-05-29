var file = function(){

    var buttonInit = function () {
        $("#uploadFile").on("click", function(){
            $("#fileUpload").modal();
        });
    };
    
    return{
        init : function () {
            buttonInit();
        }
    }
    
}();