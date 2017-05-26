(function($) {
    var count = 0;
    $.extend({
        msgUtil: {

            successMsg: function(info, msg){
                var tmp = count++;
                var result = '<div id="successAlert' + tmp + '" class="ext-center alert alert-success fade in">';
                result += '<a href="#" class="close" data-dismiss="alert">&times;</a>';
                result += '<strong>' + info + '</strong>' + msg;
                result += '</div>';
                $("#alertBox").append(result);
                setTimeout(function () {
                    var id = "#successAlert" + tmp;
                    $(id).alert("close");
                }, 2000)
            },
            errorMsg: function(info, msg){
                var tmp = count++;
                var result = '<div id="errorAlert' + tmp + '" class="ext-center alert alert-danger fade in">';
                result += '<a href="#" class="close" data-dismiss="alert">&times;</a>';
                result += '<strong>' + info + '</strong>' + msg;
                result += '</div>';
                $("#alertBox").append(result);
                setTimeout(function () {
                    var id = "#errorAlert" + tmp;
                    $(id).alert("close");
                }, 2000)
            }
        }
    });
})(jQuery);